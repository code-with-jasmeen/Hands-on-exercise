------------------------------------------------------------
-- STEP 1: CLEAN TABLE SETUP (RUN ONLY ONCE)
------------------------------------------------------------

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Loans';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

------------------------------------------------------------
-- CREATE TABLES
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
    EndDate DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER
);

------------------------------------------------------------
-- STEP 2: SAMPLE DATA
------------------------------------------------------------

INSERT INTO Customers VALUES (1,'Senior User',TO_DATE('1955-01-01','YYYY-MM-DD'),15000,SYSDATE);
INSERT INTO Customers VALUES (2,'Young User',TO_DATE('1995-06-10','YYYY-MM-DD'),8000,SYSDATE);

INSERT INTO Loans VALUES (101,1,5000,10,SYSDATE,SYSDATE+20);
INSERT INTO Loans VALUES (102,2,7000,8,SYSDATE,SYSDATE+40);

INSERT INTO Accounts VALUES (1,1,'Savings',10000);
INSERT INTO Accounts VALUES (2,2,'Savings',5000);

INSERT INTO Employees VALUES (1,'Aman','IT',50000);
INSERT INTO Employees VALUES (2,'Neha','HR',60000);

COMMIT;

------------------------------------------------------------
-- STEP 3: PROCESS MONTHLY INTEREST
------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

------------------------------------------------------------
-- STEP 4: EMPLOYEE BONUS
------------------------------------------------------------

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE Department = dept_name;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

------------------------------------------------------------
-- STEP 5: TRANSFER FUNDS
------------------------------------------------------------

CREATE OR REPLACE PROCEDURE TransferFunds (
    from_acc IN NUMBER,
    to_acc IN NUMBER,
    amt IN NUMBER
)
AS
    bal NUMBER;
BEGIN
    SELECT Balance INTO bal
    FROM Accounts
    WHERE AccountID = from_acc;

    IF bal < amt THEN
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    ELSE
        UPDATE Accounts
        SET Balance = Balance - amt
        WHERE AccountID = from_acc;

        UPDATE Accounts
        SET Balance = Balance + amt
        WHERE AccountID = to_acc;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');
    END IF;
END;
/

BEGIN
    TransferFunds(1,2,500);
END;
/