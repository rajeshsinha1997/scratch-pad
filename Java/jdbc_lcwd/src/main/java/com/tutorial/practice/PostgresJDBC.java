package com.tutorial.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            final String createTableQuery = "CREATE TABLE public.jdbc (j_id int GENERATED ALWAYS AS IDENTITY NOT NULL, j_name varchar NOT NULL, j_img BYTEA, CONSTRAINT jdbc_pk PRIMARY KEY (j_id))";

            // create statement
            Statement createTableStatement = PostgresJDBC.databaseConnection.createStatement();

            // execute statement
            createTableStatement.executeUpdate(createTableQuery);

            System.out.println("Table Created in the Database Successfully");
        } catch (SQLException e) {
            System.out.println("Table not Created in the Database");
            e.printStackTrace();
        } finally {
            // close database connection
            PostgresJDBC.closeDatabaseConnection();
        }
    }

    /*
     * method to insert record into the database
     */
    private static void insertRecordToDatabase() {
        try {
            // connect to the database
            PostgresJDBC.connectToDatabase();

            // generate insert query
            String insertQuery = "INSERT INTO public.jdbc(j_name, j_img) VALUES(?, ?)";

            // load the image file
            File imageFile = new File("D:\\scratch-pad\\Java\\jdbc_lcwd\\src\\main\\res\\img.png");

            // convert the image file to a binary stream
            FileInputStream imageFileStream = new FileInputStream(imageFile);

            // get prepared statement
            PreparedStatement insertRecordStatement = PostgresJDBC.databaseConnection.prepareStatement(insertQuery);

            // set values to the query
            insertRecordStatement.setString(1, "Rajesh");
            insertRecordStatement.setBinaryStream(2, imageFileStream, imageFile.length());

            // execute update
            insertRecordStatement.executeUpdate();

            System.out.println("Record Inserted into the Database Successfully");
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // close database connection
            PostgresJDBC.closeDatabaseConnection();
        }
    }

    /*
     * method to view records from the database using JDBC
     */
    private static void viewRecordsFromDatabase() {
        try {
            // create database connection
            PostgresJDBC.connectToDatabase();

            // generate select query
            String selectRecordQuery = "SELECT * FROM public.jdbc";

            // create statement
            Statement selectRecordStatement = PostgresJDBC.databaseConnection.createStatement();

            // execute query
            ResultSet databaseRecords = selectRecordStatement.executeQuery(selectRecordQuery);

            // check if any database record was found
            if (databaseRecords.next()) {
                // print database records
                do {
                    System.out.println("ID: " + databaseRecords.getInt(1) + ", Name: " + databaseRecords.getString(2));
                } while (databaseRecords.next());
            } else {
                System.err.println("NO RECORD WAS FOUND IN THE DATABASE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close database connection
            PostgresJDBC.closeDatabaseConnection();
        }
    }

    /*
     * method to update existing record in the database using JDBC
     */
    private static void updateRecordInDatabase() {
        try {
            // connect to the database
            PostgresJDBC.connectToDatabase();

            // generate update query
            String updateRecordQuery = "UPDATE public.jdbc SET j_name=? WHERE j_id=?";

            // get prepared statement
            PreparedStatement updateRecordStatement = PostgresJDBC.databaseConnection
                    .prepareStatement(updateRecordQuery);

            // set values to the query
            updateRecordStatement.setString(1, "Sinha");
            updateRecordStatement.setInt(2, 1);

            // execute update
            updateRecordStatement.executeUpdate();

            System.out.println("Record Updated in the Database Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close database connection
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
            // close database connection
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

        // view records
        PostgresJDBC.viewRecordsFromDatabase();

        // insert record into the database
        PostgresJDBC.insertRecordToDatabase();

        // view records
        PostgresJDBC.viewRecordsFromDatabase();

        // update record in the database
        PostgresJDBC.updateRecordInDatabase();

        // view records
        PostgresJDBC.viewRecordsFromDatabase();

        // drop database table
        PostgresJDBC.dropDatabaseTable();
    }
}
