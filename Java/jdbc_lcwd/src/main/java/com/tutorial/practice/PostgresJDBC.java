package com.tutorial.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        // check if the database is connected
        if (PostgresJDBC.isDatabaseConnected()) {
            System.out.println("Database is Connected");
        } else {
            System.out.println("Database is not Connected");
        }

        // connect to the database
        PostgresJDBC.connectToDatabase();

        // check if the database is connected
        if (PostgresJDBC.isDatabaseConnected()) {
            System.out.println("Database is Connected");
        } else {
            System.out.println("Database is not Connected");
        }

        // close database connection
        PostgresJDBC.closeDatabaseConnection();

        // check if the database is connected
        if (PostgresJDBC.isDatabaseConnected()) {
            System.out.println("Database is Connected");
        } else {
            System.out.println("Database is not Connected");
        }
    }
}
