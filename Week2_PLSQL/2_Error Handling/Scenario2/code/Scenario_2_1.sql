CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percent     IN NUMBER
) AS
    v_count NUMBER;
BEGIN
    -- Check if employee exists
    SELECT COUNT(*) INTO v_count FROM Employees WHERE EmployeeID = p_employee_id;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
        RETURN;
    END IF;

    -- Update salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_employee_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for Employee ID ' || p_employee_id);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
        ROLLBACK;
END;
/