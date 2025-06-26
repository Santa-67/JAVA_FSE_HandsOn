SELECT 
    LoanID,
    CustomerID,
    LoanAmount,
    InterestRate,
    ROUND(MONTHS_BETWEEN(EndDate, StartDate) / 12, 2) AS LoanYears,
    CalculateMonthlyInstallment(
        LoanAmount,
        InterestRate,
        FLOOR(MONTHS_BETWEEN(EndDate, StartDate) / 12)
    ) AS Monthly_Installment
FROM Loans;