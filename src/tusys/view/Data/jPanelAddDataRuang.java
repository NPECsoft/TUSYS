/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys.view.Data;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import tusys.database.Kuliah;
import tusys.database.Ruang;
import tusys.database.dbconn;

/**
 *
 * @author nim_13512501
 */
public class jPanelAddDataRuang extends javax.swing.JPanel {

    /**
     * Creates new form jPanelAddDataRuang
     */
    public jPanelAddDataRuang(JDialog closetarget,
                                dbconn targetdbconn) {
        initComponents();
        this.closeTarget=closetarget;
        this.targetdbconn=targetdbconn;
        closeTarget.setLocation(500,250);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonTambah = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();
        jLabelJudul = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNamaRuangan = new javax.swing.JTextField();
        jTextFieldFasilitas = new javax.swing.JTextField();
        jTextFieldKapasitasRuangan = new javax.swing.JTextField();
        jComboBoxJenisRuangan = new javax.swing.JComboBox();

        jLabel4.setText("Fasilitas");

        jLabel5.setText("Kapasitas Ruangan");

        jButtonTambah.setText("Tambah");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jButtonBatal.setText("Batal");
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalActionPerformed(evt);
            }
        });

        jLabelJudul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelJudul.setText("Tambah Data Ruangan");

        jLabel2.setText("Nama Ruangan");

        jLabel3.setText("Jenis Ruangan");

        jTextFieldNamaRuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaRuanganActionPerformed(evt);
            }
        });

        jComboBoxJenisRuangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kelas", "Laboratorium" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldFasilitas, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldKapasitasRuangan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jTextFieldNamaRuangan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jComboBoxJenisRuangan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabelJudul)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJudul)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNamaRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxJenisRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFasilitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKapasitasRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTambah)
                    .addComponent(jButtonBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNamaRuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaRuanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaRuanganActionPerformed

    private void jButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalActionPerformed
        // TODO add your handling code here:
        getCloseTarget().setVisible(false);
    }//GEN-LAST:event_jButtonBatalActionPerformed

    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
    try {
            // TODO add your handling code here:
            //validasi input
            if (jTextFieldNamaRuangan.getText().length()<1){
                JOptionPane.showMessageDialog(null, "Nama ruangan tidak boleh kosong");
                return;
            }
            
            try{
                int peserta = Integer.parseInt(jTextFieldKapasitasRuangan.getText());
                if ((peserta > 0)&&(peserta < 200)) {
                    //do nothing
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Kapasitas ruangan di luar range 1-199");
                    jTextFieldKapasitasRuangan.setText("");
                    return;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "angka kapasitas salah");
                return;
            }
            
            //to query
            
            Ruang r = new Ruang(null,jTextFieldNamaRuangan.getText(), 
                    (String)jComboBoxJenisRuangan.getSelectedItem(),
                    Integer.parseInt(jTextFieldKapasitasRuangan.getText()),
                    jTextFieldFasilitas.getText());
            
            System.out.println("check " + getTargetdbconn());
            Ruang ruangnamasama = getTargetdbconn().getRuangByNama(jTextFieldNamaRuangan.getText());
            if (ruangnamasama!=null){
                JOptionPane.showMessageDialog(null, "Ruang dengan nama " + ruangnamasama.getNama_ruang() + "sudah ada");
                return;
            }
            getTargetdbconn().addRuang(r);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
            Logger.getLogger(jPanelAddDataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getCloseTarget().setVisible(false);
    }//GEN-LAST:event_jButtonTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JComboBox jComboBoxJenisRuangan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JTextField jTextFieldFasilitas;
    private javax.swing.JTextField jTextFieldKapasitasRuangan;
    private javax.swing.JTextField jTextFieldNamaRuangan;
    // End of variables declaration//GEN-END:variables


    private JDialog closeTarget;
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
