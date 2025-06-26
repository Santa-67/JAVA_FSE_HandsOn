DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID
        FROM CUSTOMERS
        WHERE Balance > 10000;
BEGIN
    FOR rec IN cur_customers LOOP
        UPDATE CUSTOMERS
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;
    COMMIT;
END;
/