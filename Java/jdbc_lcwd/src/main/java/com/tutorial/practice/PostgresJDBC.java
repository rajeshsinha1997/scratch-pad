package com.tutorial.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresJDBC {
    // database configuration values
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/practice";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "password";

    // database connection object
    private static Connection databaseConnection;

    /*
     * method to check if the postgres database is connected
     * 
     * @return true if the database is connected, false otherwise
     */
    private static boolean isDatabaseConnected() {
        try {
            // check if the database connection is not closed
            return PostgresJDBC.databaseConnection != null && !PostgresJDBC.databaseConnection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * method to connect to the postgres database using JDBC
     */
    private static void connectToDatabase() {
        try {
            /*
             * Applications do not need to explicitly load the org.postgresql.Driver class
             * because the pgJDBC driver jar supports the Java Service Provider mechanism.
             * The driver will be loaded by the JVM when the application connects to
             * PostgreSQL® (as long as the driver’s jar file is on the classpath).
             * 
             * https://jdbc.postgresql.org/documentation/use/
             */

            // 1. load database driver
            // Class.forName("org.postgresql.Driver"); --> this step is not necessary now

            // check if the connection is not established already
            if (!PostgresJDBC.isDatabaseConnected()) {
                // 2. create a connection
                PostgresJDBC.databaseConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER,
                        DATABASE_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * method to create a table in the postgres database using JDBC
     */
    private static void createDatabaseTable() {
        try {
            // connect to the database
            PostgresJDBC.connectToDatabase();

            // generate create table query
            final String createTableQuery = "CREATE TABLE public.jdbc (j_id int GENERATED ALWAYS AS IDENTITY NOT NULL, j_name varchar NOT NULL, CONSTRAINT jdbc_pk PRIMARY KEY (j_id))";

            // create statement
            Statement createTableStatement = PostgresJDBC.databaseConnection.createStatement();

            // execute statement
            createTableStatement.executeUpdate(createTableQuery);

            System.out.println("Table Created in the Database Successfully");
        } catch (SQLException e) {
            System.out.println("Table not Created in the Database");
            e.printStackTrace();
        } finally {
            // close database connection in case of any exception occurs
            PostgresJDBC.closeDatabaseConnection();
        }
    }

    /*
     * method to drop a table using JDBC
     */
    private static void dropDatabaseTable() {
        try {
            // connect to the database
            PostgresJDBC.connectToDatabase();

            // generate drop table query
            final String dropTableQuery = "DROP TABLE public.jdbc;";

            // create statement
            Statement dropTableStatement = PostgresJDBC.databaseConnection.createStatement();

            // execute statement
            dropTableStatement.executeUpdate(dropTableQuery);

            System.out.println("Table Dropped from the Database Successfully");
        } catch (SQLException e) {
            System.out.println("Table Dropped Failed");
            e.printStackTrace();
        } finally {
            // close database connection in case of any exception occurs
            PostgresJDBC.closeDatabaseConnection();
        }
    }

    /*
     * method to close the existing postgres database connection
     */
    private static void closeDatabaseConnection() {
        try {
            // check if the database is connected
            if (PostgresJDBC.isDatabaseConnected()) {
                // close database connection
                PostgresJDBC.databaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * method to run postgres database operations
     */
    public static void runPostgresJDBC() {
        // create database table
        PostgresJDBC.createDatabaseTable();

        // drop database table
        PostgresJDBC.dropDatabaseTable();
    }
}
