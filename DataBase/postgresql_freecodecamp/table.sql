-- see list of tables
SELECT table_name FROM information_schema.tables WHERE table_schema='test';

-- structure of the command for creating a table is shown below
-- CREATE TABLE table_name (
--      column_name data_type constraints
-- );
CREATE TABLE test.person (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(15) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(150) UNIQUE,
    country_of_birth VARCHAR(50) NOT NULL
);

-- CHECK constraint is applied on a column of a table to allow only
-- specific values for that column
ALTER TABLE test.person ADD CONSTRAINT gender_constraint CHECK(gender = 'Male' or gender = 'Female');

-- see the indices of a table
SELECT indexname, indexdef
FROM pg_indexes
WHERE tablename = 'car' AND schemaname = 'test';

-- see the primary key of a table
SELECT pg_attribute.attname AS column_name
FROM pg_index, pg_class, pg_attribute, pg_namespace
WHERE pg_class.oid = 'car'::regclass
AND indrelid = pg_class.oid
AND nspname = 'test'
AND pg_class.relnamespace = pg_namespace.oid 
AND pg_attribute.attrelid = pg_class.oid 
AND pg_attribute.attnum = any(pg_index.indkey)
AND indisprimary;

-- see the constraints of a table
SELECT conname AS constraint_name,
contype AS constraint_type,
pg_get_constraintdef(c.oid) AS constraint_definition
FROM pg_constraint c
JOIN pg_namespace n ON n.oid = c.connamespace
JOIN pg_class cl ON cl.oid = c.conrelid
WHERE cl.relname = 'person' AND n.nspname = 'test';

-- see details of the columns of a table
SELECT column_name, data_type, column_default, is_identity, is_nullable, character_maximum_length, is_updatable
FROM information_schema.columns WHERE table_name='person' AND table_schema='test';

-- structure of the command for inserting values into a table is shown below
-- INSERT INTO table_name (column_names) VALUES (values);
INSERT INTO test.person (first_name, last_name, gender, date_of_birth, email, country_of_birth)
VALUES ('Rajesh', 'Sinha', 'Male', '05-15-1997', 'rajeshsinha@test.com', 'India');

-- view contents of a table
SELECT * FROM test.person;

-- ORDER BY is used to sort the result data of a table. The default sorting order is ascending (ASC)
-- the below query is same as, SELECT * FROM test.person ORDER BY country_of_birth ASC;
SELECT * FROM test.person ORDER BY country_of_birth;

-- also we can sort the result in descending (DESC) order
SELECT * FROM test.person ORDER BY country_of_birth DESC;

-- multiple columns can also be used to sort the result data of a table
SELECT * FROM test.person ORDER BY country_of_birth DESC, id ASC;

-- DISTINCT is used to see list of unique records present in a specific column of a table
SELECT DISTINCT country_of_birth FROM test.person ORDER BY country_of_birth;

-- WHERE clause is used to filter out the result data of a table
SELECT * FROM test.person WHERE country_of_birth='United States' ORDER BY first_name ASC, id ASC;

-- AND, OR keywords can be used along with WHERE clause to chain multiple conditions
SELECT * FROM test.person WHERE country_of_birth='United States' AND gender='Female' ORDER BY first_name;
SELECT * FROM test.person 
WHERE (country_of_birth='Canada' or country_of_birth='France') 
AND gender='Female' 
ORDER BY date_of_birth DESC, id ASC;

-- comparison operators can also be used with the SELECT query
SELECT * FROM test.person WHERE gender<>'Male' ORDER BY date_of_birth DESC;

-- LIMIT keyword is used to fetch limited number of records from a table
SELECT * FROM test.person LIMIT 5;

-- OFFSET keyword can be used to skip those many initial number of records,
-- while retrieving records from a table
SELECT * FROM test.person OFFSET 2;

-- LIMIT and OFFSET keyword can be used together as well
SELECT * FROM test.person OFFSET 2 LIMIT 3;

-- IN keyword is used to fetch records from a table with the values of a column is
-- matching with a given list of values
SELECT * FROM test.person WHERE country_of_birth IN ('India', 'Rwanda', 'Panama');

-- BETWEEN keyword is used to retrieve records from a table where the values of a
-- column belongs to a given range
SELECT * FROM test.person WHERE date_of_birth BETWEEN '1997-05-14' AND '1997-05-16' ORDER BY date_of_birth;

-- LIKE keyword is used to fetch values from a table where the values of a column
-- matches with a pattern or a wildcard pattern
-- '%' is used to match any number of characters
-- '_' is used to match a single character
SELECT * FROM test.person WHERE email LIKE '%google.__';

-- ILIKE keyword works similar to the keyword LIKE, but it ignores the case while
-- matching with the pattern
SELECT * FROM test.person WHERE country_of_birth ILIKE 'z%';

-- GROUP BY keyword is used to aggregate all the rows of a table with the same value
-- for a specific column
SELECT country_of_birth, COUNT(country_of_birth) FROM test.person 
GROUP BY country_of_birth 
ORDER BY country_of_birth;

-- HAVING keyword is used with the GROUP BY keyword to perform additional filtering
-- operation after the aggregation
SELECT country_of_birth, COUNT(country_of_birth) FROM test.person
GROUP BY country_of_birth HAVING COUNT(country_of_birth) > 10
ORDER BY COUNT(country_of_birth) DESC;

-- MAX() function is used to find the maximum value of a given column in a table
SELECT MAX(price) FROM test.car;

-- MIN() function is used to find the minimum value of a given column in a table
SELECT MIN(price) FROM test.car;

-- AVG() function is used to find the average value of a given column in a table
SELECT AVG(price) FROM test.car;

-- ROUND() function is used to round off a value
SELECT ROUND(AVG(price)) FROM test.car;

-- SUM() function is used to perform the addition operation on the data of a table
SELECT SUM(price) FROM test.car;

-- AS keyword is used to create alias for a specific column
SELECT make, model, ROUND(price*0.8) AS discounted_price FROM test.car LIMIT 10;

-- COALESCE() function is used to provide alternate value for a column if a NULL value is
-- found
SELECT COALESCE(email, 'EMAIL NOT AVAILABLE') FROM test.person LIMIT 50 OFFSET 1;

-- UPDATE command is used to update records of a table
UPDATE test.person SET gender = 'Male' WHERE gender IN ('Genderqueer', 'Bigender', 'Genderfluid');
UPDATE test.person SET gender = 'Female' WHERE gender IN ('Polygender', 'Non-binary', 'Agender'); 

-- DELETE command is used to delete a record from a table
DELETE FROM test.person WHERE email='rajeshsinha@test.com';

-- ON CONFLICT DO NOTHING statement is used to handle situations where there is a
-- possibility of conflict exists for the value of a specific column which already
-- has a unique constraint in place
INSERT INTO test.person (id, first_name, last_name, email, gender, date_of_birth, country_of_birth)
VALUES (1, 'Rajesh', 'Sinha', 'rajeshsinha@test.com', 'Male', '05-15-1997', 'India')
ON CONFLICT (id) DO NOTHING;

-- ON CONFLICT DO UPDATE statement is used to handle situations where there is a
-- possibility of conflict exists for a value of a specific column which already
-- has a unique constraint in place, it will update the existing record with the
-- new values provided via the INSERT statement for the specified columns
INSERT INTO test.person (id, first_name, last_name, email, gender, date_of_birth, country_of_birth)
VALUES (1005, 'Rajesh', 'Sinha', 'rajeshsinha01@test.com', 'Male', '05-15-1997', 'India')
ON CONFLICT (id) DO UPDATE SET email = EXCLUDED.email;

-- delete a table
DROP Table test.car;
