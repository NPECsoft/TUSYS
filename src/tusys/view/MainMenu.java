/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import tusys.database.dbconn;
import tusys.view.Data.jPanelData;
import tusys.view.FirstPage;

/**
 *
 * @author erickchandra
 */
public class MainMenu extends javax.swing.JFrame {
    private static JPanel firstPage;
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        initComponents();
        setTitle ("TU System");
        setSize (800,590);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        jPanelData1.setMainMenu(this);
        jPanelPemesanan1.setMainMenu(this);
        jPanelKetersediaanPemesanan1.setMainMenu(this);
        jPanelStatistik1.setMainMenu(this);
        jPanelTransaksi1.setMainMenu(this);
        jPanelKetersediaanTransaksi1.setMainMenu(this);
        //Data Button

        // Window Listeners
        addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to exit the program?", "Exit Program",
                JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
              dispose(); 
            }
          }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelData1 = new tusys.view.Data.jPanelData();
        jPanelPemesanan1 = new tusys.view.Pemesanan.jPanelPemesanan();
        jPanelKetersediaanPemesanan1 = new tusys.view.Pemesanan.jPanelKetersediaanPemesanan();
        jPanelTransaksi1 = new tusys.view.Transaksi.jPanelTransaksi();
        jPanelKetersediaanTransaksi1 = new tusys.view.Transaksi.jPanelKetersediaanTransaksi();
        jPanelStatistik1 = new tusys.view.jPanelStatistik();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("MainMenu"); // NOI18N

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.addTab("Data", jPanelData1);
        jTabbedPane1.addTab("Pemesanan", jPanelPemesanan1);
        jTabbedPane1.addTab("Ketersediaan Pemesanan", jPanelKetersediaanPemesanan1);
        jTabbedPane1.addTab("Transaksi", jPanelTransaksi1);
        jTabbedPane1.addTab("Ketersediaan Transaksi", jPanelKetersediaanTransaksi1);
        jTabbedPane1.addTab("Statistik", jPanelStatistik1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.getContentPane().setBackground(new Color (143,176,167));
                
                
                //First Page
                firstPage = new FirstPage();
                firstPage.setLocation(200,10);
                firstPage.setSize(585,540);
                firstPage.setVisible(true);
                m.getContentPane().add(firstPage);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tusys.view.Data.jPanelData jPanelData1;
    private tusys.view.Pemesanan.jPanelKetersediaanPemesanan jPanelKetersediaanPemesanan1;
    private tusys.view.Transaksi.jPanelKetersediaanTransaksi jPanelKetersediaanTransaksi1;
    private tusys.view.Pemesanan.jPanelPemesanan jPanelPemesanan1;
    private tusys.view.jPanelStatistik jPanelStatistik1;
    private tusys.view.Transaksi.jPanelTransaksi jPanelTransaksi1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private dbconn dbc;

    /**
     * @return the dbc
     */
    public dbconn getDbc() {
        return dbc;
    }

    /**
     * @param dbc the dbc to set
     */
    public void setDbc(dbconn dbc) {
        this.dbc = dbc;
    }

    public jPanelData getjPanelData1() {
        return jPanelData1;
    }

    public void setjPanelData1(jPanelData jPanelData1) {
        this.jPanelData1 = jPanelData1;
    }
    
    
}
