SELECT * FROM test.car;
SELECT * FROM test.person;

UPDATE test.person SET car_id = 13 WHERE id = 4;

-- inner join
SELECT * FROM test.person p INNER JOIN test.car c ON p.car_id = c.id;

-- selecting specific columns in inner join
SELECT first_name, last_name, date_of_birth, email, make, model, price FROM test.person p INNER JOIN test.car c ON p.car_id = c.id;

-- left join
SELECT * FROM test.person p LEFT JOIN test.car c ON p.car_id = c.id;

DELETE FROM test.car WHERE id = 13;

DELETE FROM test.person WHERE id = 4;
