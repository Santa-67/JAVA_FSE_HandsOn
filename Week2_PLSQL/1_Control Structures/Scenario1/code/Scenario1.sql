DECLARE
    CURSOR cur_senior_customers IS
        SELECT CustomerID, DOB
        FROM Customers;

    v_age NUMBER;
BEGIN
    FOR cust_rec IN cur_senior_customers LOOP
        -- Calculate age
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust_rec.DOB) / 12);

        IF v_age > 60 THEN
            -- Apply 1% discount to all loans for this customer
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/