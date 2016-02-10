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
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tusys.database.Ruang;
import tusys.view.ButtonColumn;
import tusys.view.Data.jPanelData;
import tusys.view.Data.jPanelEditDataRuang;
import tusys.view.MainMenu;

/**
 *
 * @author nim_13512501
 */
public class jPanelKetersediaanPemesanan extends javax.swing.JPanel {

    /**
     * Creates new form jPanelKetersediaanPemesanan
     */
    public jPanelKetersediaanPemesanan() {
        initComponents();
        jLabelWarningTanggal.setVisible(false);
        jLabelWarningWaktuMulai.setVisible(false);
        jLabelWarningWaktuSelesai.setVisible(false);
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
        jTableDaftarRuang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTanggal = new javax.swing.JTextField();
        jLabelWarningTanggal = new javax.swing.JLabel();
        jLabelWaktuMulai = new javax.swing.JLabel();
        jTextFieldWaktuMulai = new javax.swing.JTextField();
        jLabelWaktuSelesai = new javax.swing.JLabel();
        jTextFieldWaktuSelesai = new javax.swing.JTextField();
        jLabelWarningWaktuMulai = new javax.swing.JLabel();
        jLabelWarningWaktuSelesai = new javax.swing.JLabel();

        jTableDaftarRuang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableDaftarRuang);

        jLabel1.setText("Tanggal");

        jTextFieldTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTanggalActionPerformed(evt);
            }
        });

        jLabelWarningTanggal.setForeground(new java.awt.Color(255, 0, 0));
        jLabelWarningTanggal.setText("format yyyy-mm-dd");

        jLabelWaktuMulai.setText("waktu Mulai");

        jTextFieldWaktuMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWaktuMulaiActionPerformed(evt);
            }
        });

        jLabelWaktuSelesai.setText("waktu Selesai");

        jTextFieldWaktuSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWaktuSelesaiActionPerformed(evt);
            }
        });

        jLabelWarningWaktuMulai.setForeground(new java.awt.Color(255, 0, 0));
        jLabelWarningWaktuMulai.setText("format HH:MM");

        jLabelWarningWaktuSelesai.setForeground(new java.awt.Color(255, 0, 0));
        jLabelWarningWaktuSelesai.setText("format HH:MM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelWarningTanggal)
                            .addComponent(jTextFieldTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabelWaktuMulai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldWaktuMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelWaktuSelesai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldWaktuSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabelWarningWaktuMulai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelWarningWaktuSelesai)
                                .addGap(36, 36, 36))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelWarningTanggal)
                            .addComponent(jLabelWarningWaktuMulai)))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelWaktuMulai)
                            .addComponent(jTextFieldWaktuMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelWaktuSelesai)
                            .addComponent(jTextFieldWaktuSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelWarningWaktuSelesai)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refresh(){
        final Date tanggal;
        try{
            tanggal = Date.valueOf(jTextFieldTanggal.getText());
            jLabelWarningTanggal.setVisible(false);
        }catch(IllegalArgumentException e){
            jLabelWarningTanggal.setVisible(true);
            return;
        }
        final Time waktu_mulai;
        try{
            String str = jTextFieldWaktuMulai.getText();
            if (str.length()<=5) str+=":00";
            waktu_mulai = Time.valueOf(str);
            jLabelWarningWaktuMulai.setVisible(false);
        }catch(IllegalArgumentException e){
            jLabelWarningWaktuMulai.setVisible(true);
            return;
        }
        final Time waktu_selesai;
        try{
            String str = jTextFieldWaktuSelesai.getText();
            if (str.length()<=5) str+=":00";
            waktu_selesai = Time.valueOf(str);
            jLabelWarningWaktuSelesai.setVisible(false);
        }catch(IllegalArgumentException e){
            jLabelWarningWaktuSelesai.setVisible(true);
            return;
        }
        
        try {
            Ruang [] allruang = getMainMenu().getDbc().getRuangAvaliableDipesan(tanggal, waktu_mulai, waktu_selesai);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("Nama Ruang");
            model.addColumn("Jenis Ruang");
            model.addColumn("Kapasitas Ruang");
            model.addColumn("Fasilitas");
            model.addColumn("");
            
            //aksi pesan
            Action pesan = new AbstractAction()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    
                    TableModel model = table.getModel();
                    final JDialog frame = new JDialog(getMainMenu(), "Pesan Data Ruang", true);
                    jPanelAddPemesanan panelIsiData = new jPanelAddPemesanan(frame, getMainMenu().getDbc());
                    panelIsiData.setRuang((int) model.getValueAt(modelRow, 0));
                    panelIsiData.setTanggalMulai(tanggal);
                    panelIsiData.setWaktuMulai(waktu_mulai);
                    panelIsiData.setWaktuSelesai(waktu_selesai);
                    frame.getContentPane().add(panelIsiData);
                    frame.pack();
                    frame.setVisible(true);
                    refresh();
                }
            };
            for (int i=0;i<allruang.length;i++){
                Object [] r = new Object[6];
                r[0]=allruang[i].getId();
                r[1]=allruang[i].getNama_ruang();
                r[2]=allruang[i].getJenis_ruang();
                r[3]=allruang[i].getKapasitas_ruang();
                r[4]=allruang[i].getFasilitas();
                r[5]="pesan";
                model.addRow(r);
            }
            jTableDaftarRuang.setModel(model);
        
            ButtonColumn buttonColumnPesan = new ButtonColumn(jTableDaftarRuang, pesan, 5);
            buttonColumnPesan.setMnemonic(KeyEvent.VK_D);
            
            jTableDaftarRuang.removeColumn(jTableDaftarRuang.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(jPanelKetersediaanPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void jTextFieldTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTanggalActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jTextFieldTanggalActionPerformed

    private void jTextFieldWaktuMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWaktuMulaiActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jTextFieldWaktuMulaiActionPerformed

    private void jTextFieldWaktuSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWaktuSelesaiActionPerformed
        refresh();
// TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldWaktuSelesaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelWaktuMulai;
    private javax.swing.JLabel jLabelWaktuSelesai;
    private javax.swing.JLabel jLabelWarningTanggal;
    private javax.swing.JLabel jLabelWarningWaktuMulai;
    private javax.swing.JLabel jLabelWarningWaktuSelesai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDaftarRuang;
    private javax.swing.JTextField jTextFieldTanggal;
    private javax.swing.JTextField jTextFieldWaktuMulai;
    private javax.swing.JTextField jTextFieldWaktuSelesai;
    // End of variables declaration//GEN-END:variables

    private MainMenu mainMenu;

    /**
     * @return the mainMenu
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    /**
     * @param mainmenu the mainMenu to set
     */
    public void setMainMenu(MainMenu mainmenu) {
        this.mainMenu = mainmenu;
    }

}
