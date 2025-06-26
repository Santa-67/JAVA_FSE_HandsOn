-- Hire a new employee
EXEC EmployeeManagement.HireEmployee(10, 'Mark Lee', 'Analyst', 50000, 'Finance', TO_DATE('2022-01-15','YYYY-MM-DD'));

-- Update employee details
EXEC EmployeeManagement.UpdateEmployeeDetails(10, 'Mark Lee', 'Senior Analyst', 'Finance');

-- Calculate annual salary
SELECT EmployeeManagement.CalculateAnnualSalary(10) AS AnnualSalary FROM dual;