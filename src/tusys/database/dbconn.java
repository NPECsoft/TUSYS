/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys.database;

/**
 *
 * @author erickchandra
 */

import java.sql.*;

public class dbconn {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    
    // Connection
    Connection conn = null;
    Statement stmt = null;
    
    // Database credentials
    static String user;
    static String pass;
    
    public dbconn(String _user, String _pass) throws SQLException, ClassNotFoundException {
        initializeDBCONN(_user, _pass);
    }
    
    public void useDB() throws SQLException {
        String sql;
        
        System.out.println("useDB: Trying to use database.");
        stmt = conn.createStatement();
        sql = "USE `tusys`";
        
        int rs = stmt.executeUpdate(sql);
    }
    
    public void createNewDB() throws SQLException {
        String sql;
        
        // Build and execute query
        System.out.println("createNewDB: Creating database...");
        stmt = conn.createStatement();
        
        sql = "CREATE DATABASE `tusys`;";
        int rs = stmt.executeUpdate(sql);
        
        System.out.println("createNewDB: Database successfully created.");
        
        createNewTables();
        useDB();
    }
    
    public void createNewTables() throws SQLException {
        String qtab1, qtab2, qtab3, qtab4, qtab5, qtab6, qtab7, qtab8;
        
        useDB();
        // Build batch queries
        qtab1 = "CREATE TABLE `kuliah` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`nama_kuliah` VARCHAR(255), "
                + "`jumlah_peserta` INT(8)"
                + ");";
        
        qtab2 = "CREATE TABLE `ruang` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`nama_ruang` VARCHAR(255), "
                + "`jenis_ruang` VARCHAR(255), "
                + "`kapasitas_ruang` INT(8), "
                + "`fasilitas` TEXT"
                + ");";
        
        qtab3 = "CREATE TABLE `penggunaan_ruangan` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`nama_kegiatan` VARCHAR(255), "
                + "`jenis_kegiatan` VARCHAR(255), "
                + "`start_time_date` DATETIME, "
                + "`finish_time_date` DATETIME"
                + ");";
        
        qtab4 = "CREATE TABLE `pemesanan_ruangan` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`nama_kegiatan` VARCHAR(255), "
                + "`jenis_kegiatan` VARCHAR(255), "
                + "`start_time_date` DATETIME, "
                + "`finish_time_date` DATETIME"
                + ");";
        
        // Continue HERE for qtab5 until qtab8!!
        
        // Execute query
        System.out.println("createNewTables: Creating tables in database...");
        stmt = conn.createStatement();
        
        // Execute batch queries here!!
        
        // int rs = stmt.executeUpdate(sql);
        
        System.out.println("createNewTables: Tables successfully created in database.");
    }
    
    private void initializeDBCONN(String _user, String _pass) throws SQLException, ClassNotFoundException {
        user = _user;
        pass = _pass;
        boolean databaseExistsStatus = false;
        
        // Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        
        // Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, user, pass);
        
        try ( // Check for database availability in MySQL
            ResultSet resultSet = conn.getMetaData().getCatalogs()) {
            // Iterate each catalog in the ResultSet
            while (resultSet.next() && !databaseExistsStatus) {
                // Get the database name, which is at position 1
                String databaseName;
                databaseName = resultSet.getString(1);
                if (databaseName.equals("tusys")) {
                    databaseExistsStatus = true;
                    System.out.println("Database exists.");
                }
            }
            
            if (!databaseExistsStatus) {
                System.out.println("Database does not exists.");
                System.out.println("Trying to create new database...");
                createNewDB();
            }
        }
    }
    
    public void finalizeDBCONN() {
        // finally block used to close resources
        try {
            if (stmt != null) {
                stmt.close();
            }
        }
        catch (SQLException se2) {
            // Nothing we can do
        }
        
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException se) {
        }
        
        System.out.println("Database successfully closed.");
    }
}
