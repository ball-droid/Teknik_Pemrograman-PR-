package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.logging.Neo4jLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    private LoanService loanService;

    @BeforeEach
    void setUp() {
        // Gunakan logger non-connected agar test tidak butuh Neo4j berjalan
        loanService = new LoanService(new Neo4jLogger());
    }

    // =========================================================
    // TC-01: shouldRejectLoanWhenBorrowerNotVerified
    // =========================================================
    // SKENARIO:
    //   Borrower tidak terverifikasi (KYC = false)
    //   Ketika borrower mengajukan pinjaman
    //   Maka sistem harus menolak dengan melempar exception
    // =========================================================
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        // Arrange
        Borrower borrower = new Borrower(false, 700);

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () ->
            loanService.createLoan(borrower, BigDecimal.valueOf(1000))
        );
    }

    // =========================================================
    // TC-02: shouldRejectLoanWhenAmountIsZeroOrNegative
    // =========================================================
    // SKENARIO:
    //   Borrower valid (KYC = true)
    //   Amount <= 0
    //   Maka sistem harus menolak dengan melempar exception
    // =========================================================
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        // Arrange
        Borrower borrower = new Borrower(true, 700);

        // Act + Assert: amount = 0
        assertThrows(IllegalArgumentException.class, () ->
            loanService.createLoan(borrower, BigDecimal.ZERO)
        );

        // Act + Assert: amount negatif
        assertThrows(IllegalArgumentException.class, () ->
            loanService.createLoan(borrower, BigDecimal.valueOf(-500))
        );
    }

    // =========================================================
    // TC-03: shouldApproveLoanWhenCreditScoreHigh
    // =========================================================
    // SKENARIO:
    //   Borrower verified, credit score >= 600
    //   Maka loan harus berstatus APPROVED
    // =========================================================
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {

        // Arrange
        Borrower borrower = new Borrower(true, 700);

        // Act
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));

        // Assert
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    // =========================================================
    // TC-04: shouldRejectLoanWhenCreditScoreLow
    // =========================================================
    // SKENARIO:
    //   Borrower verified, credit score < 600
    //   Maka loan harus berstatus REJECTED
    // =========================================================
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {

        // Arrange
        Borrower borrower = new Borrower(true, 500);

        // Act
        Loan loan = loanService.createLoan(borrower, BigDecimal.valueOf(1000));

        // Assert
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}
