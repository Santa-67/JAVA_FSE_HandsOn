CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id   IN NUMBER,
    p_name          IN VARCHAR2,
    p_dob           IN DATE,
    p_balance       IN NUMBER,
    p_last_modified IN DATE
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, p_last_modified);
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully. ID: ' || p_customer_id);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
        ROLLBACK;
END;
/