DROP TABLE Management;
DROP TABLE Employee_Service;
DROP TABLE Assessment;
DROP TABLE Account;
DROP TABLE Customer;
DROP TABLE Loan_Issue;
DROP TABLE Employee_Dependant_Detail;
DROP TABLE Employee_Phone_Contact;
DROP TABLE Employee;
DROP TABLE Assignment;
DROP TABLE Compose;
DROP TABLE Service;
DROP TABLE Cost;
DROP TABLE Service_Provider;
DROP TABLE Customer_Age;
DROP TABLE Payment;
DROP TABLE Loan_Term;
DROP TABLE Loan;
DROP TABLE Branch;
DROP TABLE Job;

CREATE TABLE Job(
  title VARCHAR(20) NOT NULL,
  description VARCHAR(30) NOT NULL UNIQUE,
  PRIMARY KEY(title)
  ) ENGINE = InnoDB;

CREATE TABLE Branch(
  branchName VARCHAR(30) NOT NULL,
  assets INT NOT NULL,
  branchCity VARCHAR(30) NOT NULL,
  nbrBranCityWide INT NOT NULL,
  PRIMARY KEY (branchName)
  ) ENGINE = InnoDB;

CREATE TABLE Loan(
  loanCode INT NOT NULL,
  description VARCHAR(30) NOT NULL UNIQUE,
  branchName VARCHAR(30) NOT NULL,
  PRIMARY KEY (loanCode),
  FOREIGN KEY (branchName) REFERENCES Branch(branchName)
  ) ENGINE = InnoDB;

CREATE TABLE Loan_Term(
  termId INT NOT NULL,
  loanCode INT NOT NULL,
  termDesc VARCHAR(30) NOT NULL UNIQUE,
  status VARCHAR(30) NOT NULL,
  PRIMARY KEY (termId, loanCode),
  FOREIGN KEY (loanCode) REFERENCES Loan(loanCode)
  ) ENGINE = InnoDB;
  
CREATE TABLE Payment(
  paymentNbr INT NOT NULL,
  dateOfPayment DATE NOT NULL,
  payAmount INT NOT NULL,
  PRIMARY KEY (paymentNbr)
  ) ENGINE = InnoDB;
  
CREATE TABLE Customer_Age(
  custName VARCHAR(30) NOT NULL,
  dateOfBirth DATE NOT NULL,
  age INT NOT NULL,
  PRIMARY KEY (custName, dateOfBirth)
  ) ENGINE = InnoDB;
  
CREATE TABLE Service_Provider(
  serviceProvider VARCHAR(30) NOT NULL,
  providerLocation VARCHAR(30) NOT NULL,
  PRIMARY KEY (serviceProvider)
  ) ENGINE = InnoDB;
  
CREATE TABLE Cost(
  quantity INT NOT NULL,
  totalCost INT NOT NULL,
  PRIMARY KEY (quantity)
  ) ENGINE = InnoDB;

CREATE TABLE Service(
  serviceNbr INT NOT NULL,
  description VARCHAR(30) NOT NULL UNIQUE,
  unitCost INT NOT NULL,
  serviceProvider VARCHAR(30) NOT NULL,
  PRIMARY KEY (serviceNbr),
  FOREIGN KEY (serviceProvider) REFERENCES Service_Provider(serviceProvider)
  ) ENGINE = InnoDB;

CREATE TABLE Compose(
  serviceNbr INT NOT NULL,
  PRIMARY KEY (serviceNbr),
  FOREIGN KEY (serviceNbr) REFERENCES Service(serviceNbr)
  ) ENGINE = InnoDB;
  
CREATE TABLE Assignment(
  title VARCHAR(30) NOT NULL,
  branchName VARCHAR(30) NOT NULL,
  empNbr INT NOT NULL,
  hourlyRateOfPay INT NOT NULL,
  employmentStartDate DATE NOT NULL,
  PRIMARY KEY (title, branchName, empNbr),
  FOREIGN KEY (title) REFERENCES Job(title),
  FOREIGN KEY (branchName) REFERENCES Branch(branchName),
  FOREIGN KEY (empNbr) REFERENCES Employee(empNbr)
  ) ENGINE = InnoDB;
  
CREATE TABLE Employee(
  empNbr INT NOT NULL,
  last VARCHAR(30) NOT NULL,
  first VARCHAR(30) NOT NULL,
  supervisorNbr INT NOT NULL,
  PRIMARY KEY (empNbr)
  ) ENGINE = InnoDB;

ALTER TABLE Employee
ADD FOREIGN KEY (supervisorNbr) REFERENCES Employee(empNbr);

CREATE TABLE Employee_Phone_Contact(
  empNbr INT NOT NULL,
  location VARCHAR(30) NOT NULL,
  phoneNumber INT NOT NULL,
  PRIMARY KEY (empNbr),
  FOREIGN KEY (empNbr) REFERENCES Employee(empNbr)
  ) ENGINE = InnoDB;
  
CREATE TABLE Employee_Dependant_Detail(
  empNbr INT NOT NULL,
  birthDate DATE NOT NULL,
  name VARCHAR(30) NOT NULL,
  gender VARCHAR(20) NOT NULL,
  PRIMARY KEY (empNbr),
  FOREIGN KEY (empNbr) REFERENCES Employee(empNbr)
  ) ENGINE = InnoDB;

CREATE TABLE Loan_Issue(
  loanCode INT NOT NULL,
  paymentNbr INT NOT NULL,
  custNbr INT NOT NULL,
  amount INT NOT NULL,
  PRIMARY KEY (loanCode, paymentNbr, custNbr),
  FOREIGN KEY (loanCode) REFERENCES Loan(loanCode),
  FOREIGN KEY (paymentNbr) REFERENCES Payment(paymentNbr),
  FOREIGN KEY (custNbr) REFERENCES Customer(custNbr)
  ) ENGINE = InnoDB;
  
CREATE TABLE Customer(
  custNbr INT NOT NULL,
  custName VARCHAR(30) NOT NULL,
  dateOfBirth DATE NOT NULL,
  nbr INT NOT NULL,
  street VARCHAR(30) NOT NULL,
  city VARCHAR(30) NOT NULL,
  province CHAR(2) NOT NULL,
  postalCode CHAR(6) NOT NULL,
  spouseNbr INT,
  PRIMARY KEY (custNbr),
  FOREIGN KEY (custName, dateOfBirth) REFERENCES Customer_Age(custName, dateOfBirth)
  ) ENGINE = InnoDB;

ALTER TABLE Customer
ADD FOREIGN KEY (spouseNbr) REFERENCES Customer(custNbr);

CREATE TABLE Account(
  accountNbr INT NOT NULL,
  custNbr INT NOT NULL,
  balance INT NOT NULL,
  PRIMARY KEY (accountNbr),
  FOREIGN KEY (custNbr) REFERENCES Customer(custNbr)
  ) ENGINE = InnoDB;

CREATE TABLE Assessment(
  custNbr INT NOT NULL,
  accountNbr INT NOT NULL,
  typeOfTransaction VARCHAR(30) NOT NULL,
  amount INT NOT NULL,
  dateOfTransaction DATE NOT NULL,
  PRIMARY KEY (custNbr, accountNbr),
  FOREIGN KEY (custNbr) REFERENCES Customer(custNbr),
  FOREIGN KEY (accountNbr) REFERENCES Account(accountNbr)
  ) ENGINE = InnoDB;
  
CREATE TABLE Employee_Service(
  empNbr INT NOT NULL,
  serviceNbr INT NOT NULL,
  date DATE NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (empNbr, serviceNbr),
  FOREIGN KEY (empNbr) REFERENCES Employee(empNbr),
  FOREIGN KEY (serviceNbr) REFERENCES Service(serviceNbr),
  FOREIGN KEY (quantity) REFERENCES Cost(quantity)
  ) ENGINE = InnoDB;
  
CREATE TABLE Management(
  branchName VARCHAR(30) NOT NULL,
  empNbr INT NOT NULL,
  mgrStartDate DATE NOT NULL,
  PRIMARY KEY (branchName, empNbr),
  FOREIGN KEY (branchName) REFERENCES Branch(branchName),
  FOREIGN KEY (empNbr) REFERENCES Employee(empNbr)
  ) ENGINE = InnoDB;

INSERT INTO Job (title, description)
VALUES ('Teller', 'Help customers'),
       ('Manager', 'Manage workers');

INSERT INTO Branch (branchName, assets, branchCity, nbrBranCityWide)
VALUES ('TD', 100000000, 'Calgary', 50),
       ('Scotia Bank', 100000000, 'Edmonton', 30);
     
INSERT INTO Loan (loanCode, description, branchName)
VALUES (1001, '1001 Owing money', 'TD'),
       (1002, '1002 Owing money', 'Scotiabank');
       
INSERT INTO Loan_Term (termId, termDesc, status, loanCode)
VALUES (2001, 'Term 2001 terminates in 5 days', 'Pending', 3001),
       (2002, 'Term 2002 terminates in 10 days', 'Pending', 3002);

INSERT INTO Payment (paymentNbr, dateOfPayment, payAmount)
VALUES (4001, '2018-01-01', 1000000),
       (4002, '2018-02-01', 2000000);

INSERT INTO Customer_Age (custName, dateOfBirth, age)
VALUES ('John Smith', '2000-01-01', 19),
       ('John Doe', '2000-01-01', 19);

INSERT INTO Service_Provider (serviceProvider, providerLocation)
VALUES ('TD John Doe', 'Calgary SW'),
       ('TD John Smith', 'Calgary NE');

INSERT INTO Cost (quantity, totalCost)
VALUES (1, 100),
       (2, 100);

INSERT INTO Service (serviceNbr, description, unitCost, serviceProvider)
VALUES (5001, 'Service 5001 has been done', 100, 'TD John Smith'),
       (5002, 'Service 5002 has been done', 100, 'TD John Doe');

INSERT INTO Compose (serviceNbr)
VALUES (5001),
       (5002);
       
INSERT INTO Assignment (hourlyRateOfPay, employmentStartDate, title, branchName, empNbr)
VALUES (15, '2018-01-01', 'Teller', 'TD', 6001),
       (20, '2018-01-01', 'Manager', 'TD', 6002);
       
INSERT INTO Employee (last, first, empNbr, supervisorNbr)
VALUES ('Smith', 'Mike', 6003, NULL),
       ('Martin', 'Sarah', 6004, 6003);
       
INSERT INTO Employee_Phone_Contact (location, phoneNumber, empNbr)
VALUES ('NE', 4036989236, 6006),
       ('SE', 4033654981, 6007);

INSERT INTO Employee_Dependant_Detail (birthDate, name, gender, empNbr)
VALUES ('1995-01-06', 'Tom Brady', 'Male', 6009),
       ('1995-01-06', 'Lebron James', 'Male', 6010);

INSERT INTO Loan_Issue (amount, loanCode, paymentNbr, custNbr)
VALUES (1331, 2003, 1234, 6202),
       (9999, 2005, 4321, 9080);

INSERT INTO Customer (custNbr, custName, dateOfBirth, nbr, street, city, province, postalCode, spouseNbr)
VALUES (3215, 'Mike Perry', '1991-01-02', 12, '1st', 'Calgary', 'AB', 'T3A6R4', 12321),
       (3225, 'Kyrie Irving', '1992-01-12', 90, 'Center St', 'Calgary', 'AB', 'T2A6R3', 15451);

INSERT INTO Account (accountNbr, balance, custNbr)
VALUES (8797, 123456, 5464),
       (5456, 546456, 5544);

INSERT INTO Assessment (custNbr, accountNbr, typeOfTransaction, amount, dateOfTransaction)
VALUES (1236, 2132, 'Deposit', 123456, '2018-03-02'),
       (1221, 2512, 'Withdrawal', 999999, '2018-03-03');
       
INSERT INTO Employee_Service (date, empNbr, serviceNbr, quantity)
VALUES ('2018-01-01', 2135, 5654, 20),
       ('2018-01-01', 2515, 6654, 15);

INSERT INTO Management (mgrStartDate, branchName, empNbr)
VALUES ('2018-02-02', 'TD', 3210),
       ('2018-02-03', 'TD', 6221);











