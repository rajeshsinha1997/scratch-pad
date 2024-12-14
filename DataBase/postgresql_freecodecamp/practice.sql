-- find out the minimum, maximum, and rounded off average car price for each make
-- also calculate the total cost of all cars from each makes
SELECT make, MIN(price), MAX(price), ROUND(AVG(price)), SUM(price) FROM test.car 
GROUP BY make
ORDER BY make;

-- write a query to get the price of all cars, along with the other data after
-- applying a 10% discount.
SELECT *, ROUND(price * 0.9, 2) AS discounted_price FROM test.car;
