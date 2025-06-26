DECLARE
    CURSOR due_loans_cur IS
        SELECT l.LoanID, l.EndDate AS DueDate, c.CustomerId, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerId = c.CustomerId
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN due_loans_cur LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name ||
                             ', your loan (ID: ' || rec.LoanID ||
                             ') is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/