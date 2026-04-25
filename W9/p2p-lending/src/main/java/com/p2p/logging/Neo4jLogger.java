package com.p2p.logging;

import org.neo4j.driver.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Neo4jLogger implements AutoCloseable {

    private static final String URI      = "bolt://localhost:7687";
    private static final String USER     = "neo4j";
    private static final String PASSWORD = "password";

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Driver driver;
    private boolean connected = false;

    public Neo4jLogger() {
        try {
            driver = GraphDatabase.driver(URI, AuthTokens.basic(USER, PASSWORD));
            driver.verifyConnectivity();
            connected = true;
            System.out.println("[Neo4j] Terhubung ke Neo4j di " + URI);
        } catch (Exception e) {
            System.out.println("[Neo4j] Tidak dapat terhubung ke Neo4j (" + e.getMessage()
                    + "). Logging ke Neo4j dinonaktifkan.");
        }
    }

    public void logLoanEvent(boolean borrowerVerified, int creditScore,
                             double amount, String result, String errorMessage) {
        String timestamp = LocalDateTime.now().format(FMT);

        System.out.printf("[Neo4j LOG] %s | verified=%b | creditScore=%d | amount=%.2f | result=%s%s%n",
                timestamp, borrowerVerified, creditScore, amount, result,
                errorMessage != null ? " | error=" + errorMessage : "");

        if (!connected) return;

        try (Session session = driver.session()) {
            session.run(
                "CREATE (e:LoanEvent {"
                + "  timestamp: $timestamp,"
                + "  borrowerVerified: $verified,"
                + "  creditScore: $creditScore,"
                + "  amount: $amount,"
                + "  result: $result,"
                + "  errorMessage: $errorMessage"
                + "})",
                Values.parameters(
                    "timestamp",    timestamp,
                    "verified",     borrowerVerified,
                    "creditScore",  creditScore,
                    "amount",       amount,
                    "result",       result,
                    "errorMessage", errorMessage != null ? errorMessage : ""
                )
            );
        } catch (Exception e) {
            System.out.println("[Neo4j] Gagal menulis event: " + e.getMessage());
        }
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
