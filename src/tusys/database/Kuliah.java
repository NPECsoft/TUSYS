/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys.database;

/**
 *
 * @author nim_13512501
 */
public class Kuliah {    
    private String kode_kuliah;
    private String nama_kuliah;
    private int jumlah_peserta;

    public Kuliah(){
        kode_kuliah = "";
        nama_kuliah = "";
        jumlah_peserta = 0;
    }
    
    public Kuliah(String kode_kuliah, String nama_kuliah, int jumlah_peserta) {
        this.kode_kuliah=kode_kuliah;
        this.nama_kuliah=nama_kuliah;
        this.jumlah_peserta=jumlah_peserta;
        
    }

    /**
     * @return the kode_kuliah
     */
    public String getKode_kuliah() {
        return kode_kuliah;
    }

    /**
     * @param kode_kuliah the kode_kuliah to set
     */
    public void setKode_kuliah(String kode_kuliah) {
        this.kode_kuliah = kode_kuliah;
    }

    /**
     * @return the nama_kuliah
     */
    public String getNama_kuliah() {
        return nama_kuliah;
    }

    /**
     * @param nama_kuliah the nama_kuliah to set
     */
    public void setNama_kuliah(String nama_kuliah) {
        this.nama_kuliah = nama_kuliah;
    }

    /**
     * @return the jumlah_peserta
     */
    public int getJumlah_peserta() {
        return jumlah_peserta;
    }

    /**
     * @param jumlah_peserta the jumlah_peserta to set
     */
    public void setJumlah_peserta(int jumlah_peserta) {
        this.jumlah_peserta = jumlah_peserta;
    }
}
