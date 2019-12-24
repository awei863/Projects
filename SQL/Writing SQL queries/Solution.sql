--1a
SELECT officeCode, city, phone
FROM offices
WHERE country = 'USA'
OR country = 'France';

--1b
SELECT officeCode, city, phone
FROM offices
WHERE country IN ('USA', 'France');

--2
SELECT *
FROM orderdetails
WHERE orderNumber = '10203'
ORDER BY orderLineNumber;

--3
SELECT *
FROM payments
WHERE checkNumber like '_O%'
AND checkNumber like '%0_';

--4
SELECT employeeNumber, reportsTo
FROM employees
WHERE lastName like 'B%'
AND firstName like '%y';

--5
SELECT employeeNumber, lastName, firstName, jobTitle
FROM employees
WHERE officeCode >= 2
AND reportsTo = '1143'
OR reportsTo = '1088';

--6
SELECT productCode, MIN(quantityOrdered)
FROM orderdetails
GROUP BY productCode;

--7
SELECT productCode, SUM(quantityOrdered) AS 'Total Quantity'
FROM orderdetails
GROUP BY productCode
ORDER BY SUM(quantityOrdered) DESC;

--8a
SELECT DISTINCT country
FROM customers;

--8b
SELECT country
FROM customers
GROUP BY country;

--9
SELECT country, COUNT(customerNumber)
FROM customers
GROUP BY country;

--10
SELECT reportsTo, COUNT(employeeNumber)
FROM employees
GROUP BY reportsTo;

--11 Diane Murphy does not appear because she reports to no one
SELECT e.employeeNumber, e.firstName, e.lastName, m.employeeNumber, m.firstName, m.lastName
FROM employees e, employees m
WHERE e.reportsTo = m.employeeNumber;

--12
SELECT *
FROM employees
WHERE reportsTo is NULL;

--13a
SELECT customerName, firstName, lastName, orders.orderNumber, productName, quantityOrdered, priceEach
FROM customers, employees, orders, orderdetails, products
WHERE customers.salesRepEmployeeNumber = employees.employeeNumber
AND customers.customerNumber = orders.customerNumber
AND orders.orderNumber = orderdetails.orderNumber
AND orderdetails.productCode = products.productCode
AND country = 'Canada';

--13b
SELECT customerName, firstName, lastName, orders.orderNumber, productName, quantityOrdered, priceEach
FROM customers JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
               JOIN orders USING(customerNumber)
               JOIN orderdetails USING(orderNumber)
               JOIN products USING(productCode)
WHERE country = 'Canada';

--14
SELECT customerName, phone
FROM customers JOIN orders USING(customerNumber)
               JOIN orderdetails USING(orderNumber)
WHERE quantityOrdered > 10;

--15
SELECT buyPrice, priceEach, ROUND(priceEach - buyPrice) AS 'Difference', ROUND((priceEach - buyPrice) * 100 / priceEach) AS 'Profit Margin %'
FROM products JOIN orderdetails USING(productCode)
              JOIN orders USING(orderNumber);
              
--16
SELECT country, status, COUNT(status)
FROM customers JOIN orders USING(customerNumber)
               JOIN orderdetails USING(orderNumber)
WHERE status = 'Disputed'
OR status = 'Cancelled'
GROUP BY country, status;


















