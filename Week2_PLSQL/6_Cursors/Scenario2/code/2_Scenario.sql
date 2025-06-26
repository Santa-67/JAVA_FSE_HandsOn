DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_fee CONSTANT NUMBER := 100; -- Set your annual fee amount here
BEGIN
    FOR rec IN cur_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_fee || ' applied to Account ID: ' || rec.AccountID);
    END LOOP;
    COMMIT;
END;
/