DECLARE
    CURSOR cur_statements IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY c.CustomerID, t.TransactionDate;

    v_last_customer_id Customers.CustomerID%TYPE := NULL;
BEGIN
    FOR rec IN cur_statements LOOP
        IF v_last_customer_id IS NULL OR v_last_customer_id != rec.CustomerID THEN
            DBMS_OUTPUT.PUT_LINE('--- Monthly Statement for ' || rec.Name || ' (Customer ID: ' || rec.CustomerID || ') ---');
            v_last_customer_id := rec.CustomerID;
        END IF;
        DBMS_OUTPUT.PUT_LINE('  Transaction ID: ' || rec.TransactionID ||
                             ', Date: ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY') ||
                             ', Amount: ' || rec.Amount ||
                             ', Type: ' || rec.TransactionType);
    END LOOP;
END;
/