/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tusys.database;

import java.util.ArrayList;

/**
 *
 * @author Candy Olivia Mawalim
 */
public class Statistic {
    private ArrayList<String> ruangan = new ArrayList<String>();
    private ArrayList<Integer> frekuensi = new ArrayList<Integer>(); 
    private String jenisKegiatan = "kuliah"; 
    
    public ArrayList<String> getRuangan() {
        return ruangan;
    }

    public void setRuangan(ArrayList<String> ruangan) {
        this.ruangan = ruangan;
    }

    public ArrayList<Integer> getFrekuensi() {
        return frekuensi;
    }

    public void setFrekuensi(ArrayList<Integer> frekuensi) {
        this.frekuensi = frekuensi;
    }

    public String getJenisKegiatan() {
        return jenisKegiatan;
    }

    public void setJenisKegiatan(String jenisKegiatan) {
        this.jenisKegiatan = jenisKegiatan;
    }
    
    
}
