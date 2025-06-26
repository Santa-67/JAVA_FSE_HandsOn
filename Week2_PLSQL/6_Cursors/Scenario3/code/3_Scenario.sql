DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    -- Example policy: Increase all interest rates by 0.5%
    v_increment CONSTANT NUMBER := 0.5;
BEGIN
    FOR rec IN cur_loans LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + v_increment
        WHERE LoanID = rec.LoanID;
        DBMS_OUTPUT.PUT_LINE('Interest rate updated for Loan ID: ' || rec.LoanID ||
                             ' to ' || (rec.InterestRate + v_increment) || '%');
    END LOOP;
    COMMIT;
END;
/