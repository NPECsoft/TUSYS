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
public class Ruang {
    public Ruang(){
        
    }
    
    //null-kan id saat insert
    public Ruang(Integer id, String nama_ruang, String jenis_ruang,int kapasitas_ruang, String fasilitas){
        this.id=id;
        this.nama_ruang = nama_ruang;
        this.jenis_ruang = jenis_ruang;
        this.kapasitas_ruang = kapasitas_ruang;
        this.fasilitas = fasilitas;
    }
    
    private Integer id;
    private String nama_ruang;
    private String jenis_ruang;
    private int kapasitas_ruang;
    private String fasilitas;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nama_ruang
     */
    public String getNama_ruang() {
        return nama_ruang;
    }

    /**
     * @param nama_ruang the nama_ruang to set
     */
    public void setNama_ruang(String nama_ruang) {
        this.nama_ruang = nama_ruang;
    }

    /**
     * @return the jenis_ruang
     */
    public String getJenis_ruang() {
        return jenis_ruang;
    }

    /**
     * @param jenis_ruang the jenis_ruang to set
     */
    public void setJenis_ruang(String jenis_ruang) {
        this.jenis_ruang = jenis_ruang;
    }

    /**
     * @return the kapasitas_ruang
     */
    public int getKapasitas_ruang() {
        return kapasitas_ruang;
    }

    /**
     * @param kapasitas_ruang the kapasitas_ruang to set
     */
    public void setKapasitas_ruang(int kapasitas_ruang) {
        this.kapasitas_ruang = kapasitas_ruang;
    }

    /**
     * @return the fasilitas
     */
    public String getFasilitas() {
        return fasilitas;
    }

    /**
     * @param fasilitas the fasilitas to set
     */
    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }
}
