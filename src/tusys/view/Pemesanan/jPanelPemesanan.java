/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys.view.Pemesanan;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tusys.database.Pemesanan;
import tusys.database.Ruang;
import tusys.view.ButtonColumn;
import tusys.view.Data.jPanelData;
import tusys.view.Data.jPanelEditDataKuliah;
import tusys.view.MainMenu;

/**
 *
 * @author nim_13512501
 */
public class jPanelPemesanan extends javax.swing.JPanel {

    /**
     * Creates new form jPanelPemesanan
     */
    public jPanelPemesanan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxRuang = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTanggalMulai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTanggalSelesai = new javax.swing.JTextField();
        jLabelWarningTanggalMulai = new javax.swing.JLabel();
        jLabelWarningTanggalSelesai = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                onComponentShown(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Ruang");

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxRuang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRuangActionPerformed(evt);
            }
        });

        jLabel1.setText("Tanggal mulai");

        jTextFieldTanggalMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTanggalMulaiActionPerformed(evt);
            }
        });

        jLabel3.setText("Tanggal Selesai");

        jTextFieldTanggalSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTanggalSelesaiActionPerformed(evt);
            }
        });

        jLabelWarningTanggalMulai.setForeground(new java.awt.Color(255, 0, 0));
        jLabelWarningTanggalMulai.setText("format yyyy-mm-dd");

        jLabelWarningTanggalSelesai.setForeground(new java.awt.Color(255, 0, 0));
        jLabelWarningTanggalSelesai.setText("format yyyy-mm-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelWarningTanggalMulai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelWarningTanggalSelesai))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldTanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTanggalSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(253, 253, 253))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTanggalSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWarningTanggalMulai)
                    .addComponent(jLabelWarningTanggalSelesai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTanggalMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTanggalMulaiActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jTextFieldTanggalMulaiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxRuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRuangActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jComboBoxRuangActionPerformed

    private void onComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onComponentShown
        try {
            // TODO add your handling code here:
            Ruang [] ruangs = getMainmenu().getDbc().getAllRuang();
            DefaultComboBoxModel model = new DefaultComboBoxModel(ruangs);
            jComboBoxRuang.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error: " + ex);
            Logger.getLogger(jPanelPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_onComponentShown

    private void jTextFieldTanggalSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTanggalSelesaiActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jTextFieldTanggalSelesaiActionPerformed

    private void refresh(){
        //validasi input
        Date tanggalmulai = null;
        try{
            tanggalmulai = Date.valueOf(jTextFieldTanggalMulai.getText());
            jLabelWarningTanggalMulai.setVisible(false);
        }catch(IllegalArgumentException e){
            jLabelWarningTanggalMulai.setVisible(true);
            return;
        }
        Date tanggalselesai = null;
        try{
            tanggalselesai = Date.valueOf(jTextFieldTanggalSelesai.getText());
            jLabelWarningTanggalSelesai.setVisible(false);
        }catch(IllegalArgumentException e){
            jLabelWarningTanggalSelesai.setVisible(true);
            return;
        }
        Ruang ruangterpilih = (Ruang) jComboBoxRuang.getModel().getSelectedItem();
        int idruang = ruangterpilih.getId();
               
        //refresh
        
        try {
            Pemesanan allpemesanan []= this.getMainmenu().getDbc().getPemesanan(idruang, tanggalmulai, tanggalselesai);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("Nama Kegiatan");
            model.addColumn("Jenis Kegiatan");
            model.addColumn("Tanggal");
            model.addColumn("Waktu Mulai");
            model.addColumn("Waktu Selesai");
            model.addColumn("");
            model.addColumn("");
            
            //aksi hapus
            Action delete = new AbstractAction()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "not implemented");
//                    JTable table = (JTable)e.getSource();
//                    int modelRow = Integer.valueOf( e.getActionCommand() );
//                    String kodekuliah = (String) table.getModel().getValueAt(modelRow, 0);
//                    int confirm = JOptionPane.showConfirmDialog(null, "Yakin menghapus kuliah " + kodekuliah + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
//                    if (confirm==JOptionPane.YES_OPTION){
//                        try {
//                            getMainMenu().getDbc().deleteKuliahByKode(kodekuliah);
//                        } catch (SQLException ex) {
//                            JOptionPane.showMessageDialog(null, "error: " + ex);
//                            Logger.getLogger(jPanelData.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    showDataKuliah();
                }
            };
            //aksi ubah
            Action edit = new AbstractAction()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "not implemented");
//                    JTable table = (JTable)e.getSource();
//                    int modelRow = Integer.valueOf( e.getActionCommand() );
//                    
//                    TableModel model = table.getModel();
//                    final JDialog frame = new JDialog(jPanelData.this.getMainMenu(), "Ubah Data Kuliah", true);
//                    frame.getContentPane().add(new jPanelEditDataKuliah(frame,getMainMenu().getDbc(),
//                                                                          (String) model.getValueAt(modelRow, 0),
//                                                                          (String) model.getValueAt(modelRow, 1),
//                                                                          (int) model.getValueAt(modelRow, 2)));
//                    frame.pack();
//                    frame.setVisible(true);
//                    showDataKuliah();
                }
            };
            for (int i=0;i<allpemesanan.length;i++){
                Object [] p = new Object[8];
                p[0]=allpemesanan[i].getId();
                p[1]=allpemesanan[i].getNama_kegiatan();
                p[2]=allpemesanan[i].getJenis_kegiatan();
                p[3]=allpemesanan[i].getTanggal();
                p[4]=allpemesanan[i].getStart_time();
                p[5]=allpemesanan[i].getFinish_time();  
                p[6]="Ubah";
                p[7]="Hapus";
                model.addRow(p);
            }
            jTable1.setModel(model);

            ButtonColumn buttonColumnDelete = new ButtonColumn(jTable1, delete, 7);
            buttonColumnDelete.setMnemonic(KeyEvent.VK_D);

            ButtonColumn buttonColumnEdit = new ButtonColumn(jTable1, edit, 6);
            buttonColumnEdit.setMnemonic(KeyEvent.VK_D);
            
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
            Logger.getLogger(jPanelData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxRuang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelWarningTanggalMulai;
    private javax.swing.JLabel jLabelWarningTanggalSelesai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldTanggalMulai;
    private javax.swing.JTextField jTextFieldTanggalSelesai;
    // End of variables declaration//GEN-END:variables

    private MainMenu mainmenu;

    /**
     * @return the mainmenu
     */
    public MainMenu getMainmenu() {
        return mainmenu;
    }

    /**
     * @param mainmenu the mainmenu to set
     */
    public void setMainmenu(MainMenu mainmenu) {
        this.mainmenu = mainmenu;
    }
}
