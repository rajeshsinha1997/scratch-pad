-- create database
CREATE DATABASE test;

-- see list of databases
SELECT datname FROM pg_database;

-- see connection details to a specific database
SELECT * FROM pg_stat_activity WHERE datname = 'test';

-- terminate connections to a specific database
SELECT pg_terminate_backend(3275) FROM pg_stat_activity WHERE datname = 'test';

-- delete database
DROP DATABASE test;
