CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account   IN NUMBER,
    p_to_account     IN NUMBER,
    p_amount         IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check if source account has sufficient funds
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct from source account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    -- Add to destination account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Log the error (for demonstration, using DBMS_OUTPUT)
        DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
        ROLLBACK;
END;
/