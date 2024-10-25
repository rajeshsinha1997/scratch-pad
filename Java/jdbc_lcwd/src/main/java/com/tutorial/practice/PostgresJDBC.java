package com.tutorial.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresJDBC {
    // database configuration values
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/practice";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "password";

    public static void connectToPostgres() {
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

            // 2. create a connection
            Connection databaseConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            // check if connection is established
            if (databaseConnection.isClosed()) {
                System.err.println("DATABASE CONNECTION IS CLOSED");
            } else {
                System.out.println("DATABASE CONNECTION IS ESTABLISHED");
            }

            // 6. close database connection
            databaseConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
