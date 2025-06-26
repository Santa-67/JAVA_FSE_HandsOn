SELECT AccountID, 
       CASE WHEN HasSufficientBalance(AccountID, 1000) = 1 THEN 'Y' ELSE 'N' END AS Sufficient
FROM Accounts;