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
    final String DB_URL;
    
    // Connection
    Connection conn = null;
    Statement stmt = null;
    
    // Database credentials
    static String user;
    static String pass;
    
    public dbconn(String DB_URL, String _user, String _pass) throws SQLException, ClassNotFoundException {
        this.DB_URL=DB_URL;
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
                + "FOREIGN KEY (`id_pemesanan_ruangan`) REFERENCES `pemesanan_ruangan`(`id`) ON DELETE CASCADE"
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
        ps.close();
    }
    
    public void editKuliahByKode(String kode_kuliah_target, Kuliah k_databaru) throws SQLException{
        String sql;
        stmt = conn.createStatement();
        sql = "UPDATE kuliah SET kode_kuliah=?,nama_kuliah=?,jumlah_peserta=? WHERE kode_kuliah=?; ";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, k_databaru.getKode_kuliah());
        ps.setString(2, k_databaru.getNama_kuliah());
        ps.setInt(3, k_databaru.getJumlah_peserta());
        ps.setString(4, kode_kuliah_target);
        
        ps.executeUpdate();
        ps.close();
    }
    
    public void addKuliah(Kuliah k_databaru)throws SQLException{
        String sql;
        stmt = conn.createStatement();
        sql = "INSERT INTO kuliah (kode_kuliah, nama_kuliah, jumlah_peserta) VALUES (?, ?, ?)";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, k_databaru.getKode_kuliah());
        ps.setString(2, k_databaru.getNama_kuliah());
        ps.setInt(3, k_databaru.getJumlah_peserta());
        
        ps.executeUpdate();
        ps.close();
    }
    
    public Ruang[] getAllRuang() throws SQLException{
        String sql;
        
        stmt = conn.createStatement();
        sql = "SELECT * FROM ruang";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<Ruang> retv = new ArrayList<>();
        while (rs.next()){
            Ruang r = new Ruang(rs.getInt("id"),rs.getString("nama_ruang"),rs.getString("jenis_ruang"),rs.getInt("kapasitas_ruang"),rs.getString("fasilitas"));
            retv.add(r);
        }

        return retv.toArray(new Ruang[retv.size()]);
    }
    
    public void deleteRuangById(int id) throws SQLException{
        String sql;
        stmt = conn.createStatement();
        sql = "DELETE FROM ruang WHERE id=?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ps.executeUpdate();
        ps.close();
    }
    
    public void editRuangById(int id, Ruang r_databaru) throws SQLException{
        String sql;
        stmt = conn.createStatement();
        sql = "UPDATE ruang SET nama_ruang=?,jenis_ruang=?,kapasitas_ruang=?,fasilitas=? WHERE id=?; ";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, r_databaru.getNama_ruang());
        ps.setString(2, r_databaru.getJenis_ruang());
        ps.setInt(3, r_databaru.getKapasitas_ruang());
        ps.setString(4, r_databaru.getFasilitas());
        ps.setInt(5, id);
        
        ps.executeUpdate();
        ps.close();
    }
    
    public void addRuang(Ruang r_databaru)throws SQLException{
        String sql;
        stmt = conn.createStatement();
        sql = "INSERT INTO ruang (nama_ruang, jenis_ruang, kapasitas_ruang, fasilitas) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, r_databaru.getNama_ruang());
        ps.setString(2, r_databaru.getJenis_ruang());
        ps.setInt(3, r_databaru.getKapasitas_ruang());
        ps.setString(4, r_databaru.getFasilitas());
        
        ps.executeUpdate();
        ps.close();
    }
    
    public Pemesanan[] getPemesanan(int id_ruang, Date tanggal_mulai, Date tanggal_selesai) throws SQLException{
        String sql;
        
        sql = "SELECT * FROM pemesanan_ruangan WHERE id_ruang=? AND tanggal <= ? AND tanggal >= ?";
        
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id_ruang);
        ps.setDate(2, tanggal_selesai);
        ps.setDate(3, tanggal_mulai);
        
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Pemesanan> retv = new ArrayList<>();
        while (rs.next()){
            Pemesanan p = new Pemesanan();
            p.setId(rs.getInt("id"));
            p.setNama_kegiatan(rs.getString("nama_kegiatan"));
            p.setJenis_kegiatan(rs.getString("jenis_kegiatan"));
            p.setStart_time(rs.getTime("start_time"));
            p.setFinish_time(rs.getTime("finish_time"));
            p.setTanggal(rs.getDate("tanggal"));
            p.setId_ruang(rs.getInt("id_ruang"));
            retv.add(p);
        }

        return retv.toArray(new Pemesanan[retv.size()]);        
    }
    
    public Pemesanan[] getPemesananBeririsan(Pemesanan pi) throws SQLException{
            String sql;
        
        sql = "SELECT * FROM pemesanan_ruangan WHERE "
                + "id_ruang = ? AND ("
                + "(start_time <= ? AND finish_time >= ?) OR "
                + "(finish_time >= ? AND start_time <= ?) "
                + ") AND tanggal = ?";
        
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, pi.getId_ruang());
        ps.setTime(2, pi.getStart_time());
        ps.setTime(3, pi.getStart_time());
        ps.setTime(4, pi.getFinish_time());
        ps.setTime(5, pi.getFinish_time());
        ps.setDate(6, pi.getTanggal());
        
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Pemesanan> retv = new ArrayList<>();
        while (rs.next()){
            Pemesanan p = new Pemesanan();
            p.setId(rs.getInt("id"));
            p.setNama_kegiatan(rs.getString("nama_kegiatan"));
            p.setJenis_kegiatan(rs.getString("jenis_kegiatan"));
            p.setStart_time(rs.getTime("start_time"));
            p.setFinish_time(rs.getTime("finish_time"));
            p.setTanggal(rs.getDate("tanggal"));
            p.setId_ruang(rs.getInt("id_ruang"));
            if (pi.getId()==null)//selain dirinya
                retv.add(p);
            else if (p.getId()!=pi.getId()) //(cont)selain dirinya
                retv.add(p);
        }

        return retv.toArray(new Pemesanan[retv.size()]);        
    
    }
    
    public void deletePemesananById(int id) throws SQLException{
        String sql;
        stmt = conn.createStatement();
        sql = "DELETE FROM pemesanan_ruangan WHERE id=?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        
        ps.executeUpdate();
        ps.close();
    }
    
    //returns resulting id
    public int addPemesanan(Pemesanan p) throws SQLException{
        String sql;
        sql = "INSERT INTO pemesanan_ruangan (nama_kegiatan, jenis_kegiatan, start_time, finish_time, tanggal, id_ruang) "
                + "VALUES (?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, p.getNama_kegiatan());
        ps.setString(2, p.getJenis_kegiatan());
        ps.setTime(3, p.getStart_time());
        ps.setTime(4, p.getFinish_time());
        ps.setDate(5, p.getTanggal());
        ps.setInt(6, p.getId_ruang());
        
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int retval = rs.getInt(1);
        ps.close();
        rs.close();
        return retval;
    }
    
    public void addKuliahPemesan(String kode_kuliah_kuliah, int id_pemesanan_ruangan) throws SQLException{
        String sql;
        sql = "INSERT INTO kuliah_pemesan (kode_kuliah_kuliah, id_pemesanan_ruangan) "
                + "VALUES (?,?)";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode_kuliah_kuliah);
        ps.setInt(2, id_pemesanan_ruangan);
        
        ps.executeUpdate();
        ps.close();
    }
        
        
    public Statistic getStatistic(String jenis_kegiatan, Date tanggal_mulai, Date tanggal_selesai) throws SQLException{
        String sql;
        Statistic stat = new Statistic();
        
        Ruang[] ruangan = getAllRuang();
        
        for (int i = 0; i < ruangan.length; i++) {
            sql = "SELECT COUNT(*) AS jumlah_penggunaan FROM penggunaan_ruangan WHERE jenis_kegiatan = ? AND tanggal <= ? AND tanggal >= ? AND id_ruang = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jenis_kegiatan);
            ps.setDate(2, tanggal_mulai);
            ps.setDate(3, tanggal_selesai);
            ps.setInt(4, ruangan[i].getId());
            
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            stat.getRuangan().add(ruangan[i].getNama_ruang());
            System.out.println(ruangan[i].getNama_ruang());
            while (rs.next()) {
                System.out.println(rs.getInt("jumlah_penggunaan"));
                stat.getFrekuensi().add(rs.getInt("jumlah_penggunaan"));

            }
            stat.setJenisKegiatan(jenis_kegiatan);
            System.out.println(jenis_kegiatan);
        }
        
        return stat;
    }
}
