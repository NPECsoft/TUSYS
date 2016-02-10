/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys.database;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author nim_13512501
 */
public class Pemesanan {
    private Integer id;
    private String nama_kegiatan;
    private String jenis_kegiatan;
    private Time start_time;
    private Time finish_time;
    private Date tanggal;
    private int id_ruang;

    public Pemesanan(){}
    public Pemesanan(Pemesanan p){
        this.id=p.id;
        this.nama_kegiatan=p.nama_kegiatan;
        this.jenis_kegiatan=p.jenis_kegiatan;
        this.start_time=(Time) p.start_time.clone();
        this.finish_time=(Time) p.finish_time.clone();
        this.tanggal=(Date) p.tanggal.clone();
        this.id_ruang=p.id_ruang;
    }
    
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
     * @return the nama_kegiatan
     */
    public String getNama_kegiatan() {
        return nama_kegiatan;
    }

    /**
     * @param nama_kegiatan the nama_kegiatan to set
     */
    public void setNama_kegiatan(String nama_kegiatan) {
        this.nama_kegiatan = nama_kegiatan;
    }

    /**
     * @return the jenis_kegiatan
     */
    public String getJenis_kegiatan() {
        return jenis_kegiatan;
    }

    /**
     * @param jenis_kegiatan the jenis_kegiatan to set
     */
    public void setJenis_kegiatan(String jenis_kegiatan) {
        this.jenis_kegiatan = jenis_kegiatan;
    }

    /**
     * @return the start_time
     */
    public Time getStart_time() {
        return start_time;
    }

    /**
     * @param start_time the start_time to set
     */
    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    /**
     * @return the finish_time
     */
    public Time getFinish_time() {
        return finish_time;
    }

    /**
     * @param finish_time the finish_time to set
     */
    public void setFinish_time(Time finish_time) {
        this.finish_time = finish_time;
    }

    /**
     * @return the tanggal
     */
    public Date getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the id_ruang
     */
    public int getId_ruang() {
        return id_ruang;
    }

    /**
     * @param id_ruang the id_ruang to set
     */
    public void setId_ruang(int id_ruang) {
        this.id_ruang = id_ruang;
    }

}
