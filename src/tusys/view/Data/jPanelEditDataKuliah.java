/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys.view.Data;

import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import tusys.database.Kuliah;
import tusys.database.dbconn;

/**
 *
 * @author nim_13512501
 */
public class jPanelEditDataKuliah extends javax.swing.JPanel {

    /**
     * Creates new form jPanelEditDataKuliah
     */
    public jPanelEditDataKuliah(JDialog closetarget,
                                dbconn targetdbconn,
                                String kode_kuliah,
                                String nama_kuliah,
                                int jumlah_peserta) {
        initComponents();
        this.closeTarget=closetarget;
        this.targetdbconn=targetdbconn;
        closeTarget.setLocation(500,250);
        target_kode_kuliah = kode_kuliah;
        jLabelJudul.setText("Ubah Data Kuliah " + kode_kuliah);
        jTextFieldKodeKuliah.setText(kode_kuliah);
        jTextFieldNamaKuliah.setText(nama_kuliah);
        jTextFieldJumlahPeserta.setText(Integer.toString(jumlah_peserta));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelJudul = new javax.swing.JLabel();
        jTextFieldKodeKuliah = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNamaKuliah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldJumlahPeserta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonBatal = new javax.swing.JButton();
        jButtonUbah = new javax.swing.JButton();

        jLabelJudul.setText("Ubah Data Kuliah");

        jLabel2.setText("Kode Kuliah");

        jLabel3.setText("Nama Kuliah");

        jLabel5.setText("orang");

        jLabel4.setText("Jumlah Peserta");

        jButtonBatal.setText("Batal");
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalActionPerformed(evt);
            }
        });

        jButtonUbah.setText("Ubah");
        jButtonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelJudul)
                        .addComponent(jTextFieldKodeKuliah, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addComponent(jTextFieldNamaKuliah))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldJumlahPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJudul)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKodeKuliah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNamaKuliah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldJumlahPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUbah)
                    .addComponent(jButtonBatal))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUbahActionPerformed
        try {
            // TODO add your handling code here:
            //validasi input
            if (jTextFieldKodeKuliah.getText().length()>6){
                JOptionPane.showMessageDialog(null, "Panjang kode kuliah max. 6 karakter");
                return;
            } else if (jTextFieldKodeKuliah.getText().length()<1){
                JOptionPane.showMessageDialog(null, "Kode kuliah tidak boleh kosong");
                return;
            }
            
            try{
                int peserta = Integer.parseInt(jTextFieldJumlahPeserta.getText());
                if ((peserta > 0)&&(peserta < 200)) {
                    //do nothing
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah peserta melewati range 1-199");
                    jTextFieldJumlahPeserta.setText("");
                    return;
                }
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "angka jumlah peserta salah");
                return;
            }
            
            //to query
            Kuliah k = new Kuliah(jTextFieldKodeKuliah.getText(),
                    jTextFieldNamaKuliah.getText(),
                    Integer.parseInt(jTextFieldJumlahPeserta.getText()));
            
            System.out.println("check " + getTargetdbconn());
            getTargetdbconn().editKuliahByKode(target_kode_kuliah, k);
            
        } catch (SQLException ex) {
            String err = ex.toString();
            if (err.contains("MySQLIntegrityConstraintViolationException: Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "error duplicate kode kuliah");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "error " + ex);
                Logger.getLogger(jPanelEditDataKuliah.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        getCloseTarget().setVisible(false);
    }//GEN-LAST:event_jButtonUbahActionPerformed

    private void jButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalActionPerformed
        closeTarget.setVisible(false);
                // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBatalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonUbah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JTextField jTextFieldJumlahPeserta;
    private javax.swing.JTextField jTextFieldKodeKuliah;
    private javax.swing.JTextField jTextFieldNamaKuliah;
    // End of variables declaration//GEN-END:variables

    private JDialog closeTarget;
    private String target_kode_kuliah;
    private dbconn targetdbconn;
    
    /**
     * @return the closeTarget
     */
    public JDialog getCloseTarget() {
        return closeTarget;
    }

    /**
     * @param closeTarget the closeTarget to set
     */
    public void setCloseTarget(JDialog closeTarget) {
        this.closeTarget = closeTarget;
    }

    /**
     * @return the target_kode_kuliah
     */
    public String getTarget_kode_kuliah() {
        return target_kode_kuliah;
    }

    /**
     * @param target_kode_kuliah the target_kode_kuliah to set
     */
    public void setTarget_kode_kuliah(String target_kode_kuliah) {
        this.target_kode_kuliah = target_kode_kuliah;
    }

    /**
     * @return the targetdbconn
     */
    public dbconn getTargetdbconn() {
        return targetdbconn;
    }

    /**
     * @param targetdbconn the targetdbconn to set
     */
    public void setTargetdbconn(dbconn targetdbconn) {
        this.targetdbconn = targetdbconn;
    }
}
