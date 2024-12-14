-- NOW() function is used to get the current timestamp
SELECT NOW();

-- To get the current Date only the value returned from the NOW() function
-- should be casted to DATE
SELECT NOW()::DATE;

-- To get the current Time only the value returned from the NOW() function
-- should be casted to TIME
SELECT NOW()::TIME;

-- INTERVAL keyword can be used to perform DATE-TIME related operations,
-- like addition, subtraction
SELECT NOW() - INTERVAL '1 YEAR';
SELECT NOW() + INTERVAL '5 YEARS';
SELECT NOW() + INTERVAL '6 MONTHS';

-- EXTRACT() function can be used to extract different fields of the date-timestamp
SELECT EXTRACT(YEAR FROM NOW());
SELECT EXTRACT(MONTH FROM NOW());
SELECT EXTRACT(DAY FROM NOW());
SELECT EXTRACT(HOUR FROM NOW());
SELECT EXTRACT(MINUTE FROM NOW());
SELECT EXTRACT(SECOND FROM NOW());
SELECT EXTRACT(DOW FROM NOW()); -- day of the week as a numeric value
SELECT EXTRACT(CENTURY FROM NOW());

-- AGE() function is used to calculate age using the given date of birth
SELECT first_name, last_name, date_of_birth, AGE(NOW(), date_of_birth) AS age FROM test.person;
