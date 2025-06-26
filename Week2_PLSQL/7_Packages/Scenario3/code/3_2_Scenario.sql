-- Open a new account
EXEC AccountOperations.OpenAccount(100, 1, 'Savings', 5000, SYSDATE);

-- Close an account
EXEC AccountOperations.CloseAccount(100);

-- Get total balance for a customer
SELECT AccountOperations.GetTotalBalance(1) AS TotalBalance FROM dual;