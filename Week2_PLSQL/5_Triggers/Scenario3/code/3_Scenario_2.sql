-- This will succeed if account 1 has enough balance
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (10, 1, SYSDATE, 100, 'Withdrawal');

-- This will fail if the amount is more than the balance
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (11, 1, SYSDATE, 100000, 'Withdrawal');

-- This will fail because deposit amount is not positive
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (12, 1, SYSDATE, 0, 'Deposit');
COMMIT;