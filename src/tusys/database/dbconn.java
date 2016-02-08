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
import java.util.ArrayList;

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
                + "`kode_kuliah` VARCHAR(6), "
                + "`nama_kuliah` VARCHAR(255) NOT NULL, "
                + "`jumlah_peserta` INT(8) NOT NULL, "
                + "PRIMARY KEY (`kode_kuliah`)"
                + ");";
        
        qtab2 = "CREATE TABLE `ruang` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`nama_ruang` VARCHAR(255) NOT NULL, "
                + "`jenis_ruang` VARCHAR(255) NOT NULL, "
                + "`kapasitas_ruang` INT(8) NOT NULL, "
                + "`fasilitas` TEXT"
                + ");";
        
        qtab3 = "CREATE TABLE `penggunaan_ruangan` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`nama_kegiatan` VARCHAR(255) NOT NULL, "
                + "`jenis_kegiatan` VARCHAR(255) NOT NULL, "
                + "`start_time` TIME NOT NULL, "
                + "`finish_time` TIME, "
                + "`tanggal` DATE NOT NULL, "
                + "`id_ruang` INT(8) NOT NULL,"
                + "FOREIGN KEY (`id_ruang`) REFERENCES `ruang`(`id`)"
                + ");";
        
        qtab4 = "CREATE TABLE `pemesanan_ruangan` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`nama_kegiatan` VARCHAR(255) NOT NULL, "
                + "`jenis_kegiatan` VARCHAR(255) NOT NULL, "
                + "`start_time` TIME NOT NULL, "
                + "`finish_time` TIME NOT NULL, "
                + "`tanggal` DATE NOT NULL, "
                + "`id_ruang` INT(8) NOT NULL, "
                + "FOREIGN KEY (`id_ruang`) REFERENCES `ruang`(`id`)"
                + ");";
        
        // Continue HERE for qtab5 until qtab8!!
        qtab5 = "CREATE TABLE `kuliah_pemesan` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`kode_kuliah_kuliah` VARCHAR(6) NOT NULL, "
                + "`id_pemesanan_ruangan` INT(8) NOT NULL, "
                + "FOREIGN KEY (`kode_kuliah_kuliah`) REFERENCES `kuliah`(`kode_kuliah`), "
                + "FOREIGN KEY (`id_pemesanan_ruangan`) REFERENCES `pemesanan_ruangan`(`id`)"
                + ");";
        
        qtab6 = "CREATE TABLE `kuliah_pengguna` ("
                + "`id` INT(8) PRIMARY KEY AUTO_INCREMENT, "
                + "`kode_kuliah_kuliah` VARCHAR(6) NOT NULL, "
                + "`id_pemesanan_ruangan` INT(8) NOT NULL, "
                + "FOREIGN KEY (`kode_kuliah_kuliah`) REFERENCES `kuliah`(`kode_kuliah`), "
                + "FOREIGN KEY (`id_pemesanan_ruangan`) REFERENCES `pemesanan_ruangan`(`id`)"
                + ");";
        
        // Execute query
        System.out.println("createNewTables: Creating tables in database...");
        stmt = conn.createStatement();
        
        // conn.setAutoCommit(false);
        // Execute batch queries here!!
        stmt.addBatch(qtab1);
        stmt.addBatch(qtab2);
        stmt.addBatch(qtab3);
        stmt.addBatch(qtab4);
        stmt.addBatch(qtab5);
        stmt.addBatch(qtab6);
        
        stmt.executeBatch();
        // conn.commit();
        // int rs = stmt.executeUpdate(sql);
        
        System.out.println("createNewTables: Tables successfully created in database (batch).");
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
    
    public Kuliah[] getAllKuliah() throws SQLException{
        String sql;
        
        stmt = conn.createStatement();
        sql = "SELECT * FROM kuliah";
        
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Kuliah> retv = new ArrayList<>();
        while (rs.next()){
            Kuliah k = new Kuliah();
            k.setKode_kuliah(rs.getString("kode_kuliah"));
            k.setNama_kuliah(rs.getString("nama_kuliah"));
            k.setJumlah_peserta(rs.getInt("jumlah_peserta"));
            retv.add(k);
        }
        return retv.toArray(new Kuliah[retv.size()]);
    }
    
    public void deleteKuliahByKode(String kode_kuliah) throws SQLException{
        String sql;
        stmt = conn.createStatement();
        sql = "DELETE FROM kuliah WHERE kode_kuliah=?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode_kuliah);
        
        ps.executeUpdate();
    }
}
