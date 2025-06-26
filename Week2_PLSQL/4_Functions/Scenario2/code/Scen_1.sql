CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount   IN NUMBER,
    p_interest_rate IN NUMBER,  -- Annual interest rate in percent
    p_years         IN NUMBER   -- Loan duration in years
) RETURN NUMBER
IS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_installment  NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 12 / 100;
    v_months := p_years * 12;

    IF v_monthly_rate = 0 THEN
        v_installment := p_loan_amount / v_months;
    ELSE
        v_installment := p_loan_amount * v_monthly_rate / (1 - POWER(1 + v_monthly_rate, -v_months));
    END IF;

    RETURN ROUND(v_installment, 2);
END;
/