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
  

-- 
-- 
-- 
-- 
-- 
-- 
CREATE TABLE movies (
	id INTEGER NOT NULL PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	category VARCHAR(15) NOT NULL);
  
CREATE TABLE members (
	id INTEGER NOT NULL REFERENCES movies(id),	
	first_name VARCHAR(15) NOT NULL,
	last_name VARCHAR(15) NOT NULL,
	movie_id INTEGER NOT NULL);

INSERT INTO movies(id, title, category) VALUES(1, ASSASINS CREED EMBERS, Animations);
INSERT INTO members(id, first_name, last_name, movie_id) VALUES(1, Adam, Smith, 1);
  
  
  --all rows from both tables
  --Cross JOIN mathces each row from one database table to all rows from another
  SELECT * FROM 'movies' CROSS JOIN 'members'
  
  --inner JOIN return rows from both tables that satisfy given condition
  --get a list of members who have rented movies together with titles of movies rented by them
  SELECT members.'first_name', members.'last_name', movies.'title'
  FROM members, movies
  WHERE movies.'id' = members.'movie_id'
  
  --outer JOIN returns all records matching from both tables, it can return records having no match in joined table, will return NULL values for records of joined table if no match is found
  --Left JOIN returns all rows from table on left even if no matching rows are found on right table, wherever no matches are found on right table NULL is instead returned
  --get titles of all movies together with names of members who have rented them, if movie has not been rented by anyone return NULL
  SELECT A.'title', B.'first_name', B.'last_name'
  FROM 'movies' AS A
  LEFT JOIN 'members' AS B
  ON B.'movie_id' = A.'id'
  --ON and USING, match records between tables, USING requires identical names for matched columns
  --alter table to be able to use USING
  ALTER TABLE 'movies' CHANGE 'id' 'movie_id' INT(11) NOT NULL AUTO_INCREMENT;
  --can now use USING instead of ON
  SELECT A.'title', B.'first_name', B.'last_name'
  FROM 'movies' AS A
  LEFT JOIN 'members' AS B
  USING ('movie_id')
  
  
  --VIEWS , virtual tables that do not store any data of their own but display data stored in other tables
  CREATE VIEW 'view_name' AS SELECT statement;
  
  --create a view that restritcts columns seen
  CREATE VIEW  `account_v_members` AS SELECT `membership_number`,`full_names`,`gender` FROM `members`;
  
  --JOIN to get information from 3 different tables
  CREATE VIEW `general_v_movie_rentals` AS SELECT mb.`membership_number`,mb.`full_names`,mo.`title`,mr.`transaction_date`,mr.`return_date` 
  FROM `movierentals` 
  AS mr INNER JOIN `members` AS mb ON mr.`membership_number` = mb.`membership_number` INNER JOIN `movies` AS mo ON mr.`movie_id` = mo.`movie_id`;
  
  --delete a view from database
  DROP VIEW `general_v_movie_rentals` ;
  
  --PL/SQL beginnings
  DECLARE
	message varchar2(20) := 'Hello, World!';
	BEGIN
		dbms_output.put_line(message);
	END;
  
  --assign sql query results to pl/sql variables
  CREATE TABLE CUSTOMERS(
	ID	INT NOT NULL,
	NAME VARCHAR (20) NOT NULL,
	AGE INT NOT NULL,
	ADDRESS CHAR (25),
	SALARY DECIMAL (18,2),
	PRIMARY KEY(ID)
  );
  INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
  VALUES(1,'Lors',32,'Darush',1920.00);
  
  
  --COmparison operators
  --LIKE , BETWEEN , IN, IS NULL
  --Operator Precedence
  -- exponentation > identity, negation > multiplication, division > addition, subtraction, concatenation > NOT > AND > OR
  --pl/sql loops
  DECLARE
  i number(1);
  j number(1);
  BEGIN
  <<outer_loop>>
  FOR i IN 1..3 LOOP
	<<inner_loop>>
	FOR j IN 1..3 LOOP
		dbms_output.put_line();
	END loop inner_loop;
  END loop outer_loop;
END;

  
  