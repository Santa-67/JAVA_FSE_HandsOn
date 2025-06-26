-- Package specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(
        p_customer_id   IN NUMBER,
        p_name          IN VARCHAR2,
        p_dob           IN DATE,
        p_balance       IN NUMBER,
        p_last_modified IN DATE
    );
    PROCEDURE UpdateCustomerDetails(
        p_customer_id   IN NUMBER,
        p_name          IN VARCHAR2,
        p_dob           IN DATE
    );
    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

-- Package body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddNewCustomer(
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
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
            ROLLBACK;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
            ROLLBACK;
    END;

    PROCEDURE UpdateCustomerDetails(
        p_customer_id   IN NUMBER,
        p_name          IN VARCHAR2,
        p_dob           IN DATE
    ) AS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;
        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' not found.');
        ELSE
            COMMIT;
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error updating customer: ' || SQLERRM);
            ROLLBACK;
    END;

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            RETURN NULL;
    END;

END CustomerManagement;
/