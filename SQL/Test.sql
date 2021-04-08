-- Write only the SQL statement that solves the problem and nothing else.
SELECT
  firstName
FROM
  students
WHERE
  firstName = "John";
  
  
  
  
  -- Write only the SQL statement that solves the problem and nothing else.
UPDATE 
  enrollments
SET
  year = 2015
WHERE
  id BETWEEN 20 AND 100

  
   
  -- Write only the SQL statement that solves the problem and nothing else.
SELECT
  name
FROM
  products
WHERE
  price = (
    SELECT
      min(price)
    FROM
      products
  );
  
  
  
  -- Write only the SQL statement that solves the problem and nothing else
--0 test cases passed
-- create another column with values from both tables that will represent status
ALTER TABLE departments 
ADD COLUMN status VARCHAR(10);

--insert into status appropriate values
--INSERT INTO departments(salary, status) VALUES(1200, 'Above');


--select id, salary, and status from the joined tables
SELECT
  departmentId, salary, status
FROM
  employees 
LEFT JOIN departments ON
  employees.id = departments.id
ORDER BY departmentId;



-- Write only the SQL statement that solves the problem and nothing else.
--select names
SELECT
  name
FROM
  employees 
--join tables
LEFT JOIN sales ON
  employees.id = sales.employeeId
--only choose columns with no sale value
WHERE
  value = NULL
ORDER BY name;
  
  
  
  
  
  -- Suggested testing environment:
-- http://sqlite.online/

-- Example case create statement:
CREATE TABLE employees (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE sales (
  employeeId INTEGER NOT NULL REFERENCES employees(id), 
  value INTEGER NOT NULL CHECK(value > 0)
);

INSERT INTO employees(id, name) VALUES(1, 'John');
INSERT INTO employees(id, name) VALUES(2, 'Mark');
INSERT INTO employees(id, name) VALUES(3, 'Jane');

INSERT INTO sales(employeeId, value) VALUES(1, 100);
INSERT INTO sales(employeeId, value) VALUES(3, 300);

-- Expected output:
-- name
-- ----
-- Mark

-- Explanation:
-- In this example.
-- John and Jane both have sales. Only Mark has no sales.

-- Write only the SQL statement that solves the problem and nothing else.

--select names and # of transactions
SELECT
  name, amount
FROM
  customers 
--join tables
INNER JOIN transactions
  ON customers.id = transactions.customerId
  
  
  
  
  
  
  