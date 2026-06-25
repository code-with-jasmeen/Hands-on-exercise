------------------------------------------------------------
-- STEP 1: TABLES (ONLY FIRST TIME RUN)
------------------------------------------------------------

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

------------------------------------------------------------
-- STEP 2: SAMPLE DATA
------------------------------------------------------------

INSERT INTO Customers VALUES
(1, 'Senior User', TO_DATE('1955-01-01','YYYY-MM-DD'), 15000, SYSDATE);

INSERT INTO Customers VALUES
(2, 'Young User', TO_DATE('1995-06-10','YYYY-MM-DD'), 8000, SYSDATE);

INSERT INTO Loans VALUES
(101, 1, 5000, 10, SYSDATE, SYSDATE + 20);

INSERT INTO Loans VALUES
(102, 2, 7000, 8, SYSDATE, SYSDATE + 40);

COMMIT;

------------------------------------------------------------
-- STEP 3: SCENARIO 1 (AGE DISCOUNT)
------------------------------------------------------------

DECLARE
    v_age NUMBER;
BEGIN
    FOR cust IN (SELECT CustomerID, DOB FROM Customers) LOOP

        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;

    END LOOP;

    COMMIT;
END;
/

------------------------------------------------------------
-- STEP 4: SCENARIO 2 (VIP STATUS)
------------------------------------------------------------

ALTER TABLE Customers ADD IsVIP VARCHAR2(5);

BEGIN
    FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP

        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = cust.CustomerID;
        END IF;

    END LOOP;

    COMMIT;
END;
/

------------------------------------------------------------
-- STEP 5: SCENARIO 3 (LOAN REMINDER)
------------------------------------------------------------

SET SERVEROUTPUT ON;

BEGIN
    FOR loan_rec IN (
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
            'REMINDER → LoanID: ' || loan_rec.LoanID ||
            ', CustomerID: ' || loan_rec.CustomerID ||
            ', Due Date: ' || TO_CHAR(loan_rec.EndDate,'DD-MON-YYYY')
        );

    END LOOP;
END;
/