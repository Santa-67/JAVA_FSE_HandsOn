-- Add a new customer
EXEC CustomerManagement.AddNewCustomer(10, 'Sam Wilson', TO_DATE('1992-04-10','YYYY-MM-DD'), 5000, SYSDATE);

-- Update customer details
EXEC CustomerManagement.UpdateCustomerDetails(10, 'Samuel Wilson', TO_DATE('1992-04-10','YYYY-MM-DD'));

-- Get customer balance
SELECT CustomerManagement.GetCustomerBalance(10) AS Balance FROM dual;