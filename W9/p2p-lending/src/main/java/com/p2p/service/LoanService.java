package com.p2p.service;

import com.p2p.domain.*;
import com.p2p.logging.Neo4jLogger;
import java.math.BigDecimal;

public class LoanService {

    private final Neo4jLogger logger;

    public LoanService() {
        this.logger = new Neo4jLogger();
    }

    public LoanService(Neo4jLogger logger) {
        this.logger = logger;
    }

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        // ========================
        // VALIDASI (TC-01)
        // ========================
        validateBorrower(borrower);

        // ========================
        // VALIDASI (TC-02)
        // ========================
        validateAmount(amount);

        // ========================
        // CREATE LOAN (domain object)
        // ========================
        Loan loan = new Loan();

        // ========================
        // BUSINESS ACTION (TC-03 & TC-04)
        // ========================
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else {
            loan.reject();
        }

        logger.logLoanEvent(
            borrower.isVerified(),
            borrower.getCreditScore(),
            amount.doubleValue(),
            loan.getStatus().name(),
            null
        );

        return loan;
    }

    // ========================
    // PRIVATE VALIDATION METHOD
    // ========================
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.logLoanEvent(
                borrower.isVerified(),
                borrower.getCreditScore(),
                0,
                "ERROR",
                "Borrower not verified"
            );
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.logLoanEvent(
                true,
                0,
                amount != null ? amount.doubleValue() : 0,
                "ERROR",
                "Amount must be greater than 0"
            );
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}
