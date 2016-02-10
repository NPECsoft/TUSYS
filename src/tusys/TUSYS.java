/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys;

import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tusys.database.DatabaseLoginJDialog;
import tusys.view.MainMenu;
import tusys.database.dbconn;

/**
 *
 * @author erickchandra
 */
public class TUSYS {
    private static dbconn dbc = null;
    // private static DatabaseLoginJDialog dbLoginDialog;
    
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        //mencoba membuka config file
        String userhomedir = System.getProperty("user.home");        
        String tusysconffile = userhomedir+"/NPECSOFTTUSYS.properties";
        
        Properties TUSYSproperties = new Properties();
        
        String DBURL = null;
        String DBUsername = null;
        String DBPassword = null;
        
        File propertiesfile = new File(tusysconffile);
        if (propertiesfile.exists()){
            try {
                if (propertiesfile.isDirectory()) {
                    JOptionPane.showMessageDialog(null, "error: NPECSOFTTUSYS.properties is a directory");
                    return;
                }
                try {
                    FileInputStream fis = new FileInputStream(propertiesfile);
                    TUSYSproperties.load(fis);
                    fis.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "error opening configuration file, \n" + ex);
                    Logger.getLogger(TUSYS.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                DBURL = TUSYSproperties.getProperty("DBURL");
                DBUsername = TUSYSproperties.getProperty("DBUsername");
                DBPassword = TUSYSproperties.getProperty("DBPassword");
                
                dbc = new dbconn(DBURL, DBUsername, DBPassword);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(TUSYS.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
        
        
        do{
        try{
            if (dbc==null){
                DatabaseLoginJDialog dbLoginDialog = new DatabaseLoginJDialog(null, true);
                dbLoginDialog.setVisible(true);
                DBURL = dbLoginDialog.getDBURL();
                DBUsername = dbLoginDialog.getDBUsername();
                DBPassword = dbLoginDialog.getDBPassword();
                dbc = new dbconn(DBURL, DBUsername, DBPassword);
            }
            dbc.useDB();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            dbc = null;
        }}while (dbc==null);
        
        TUSYSproperties.setProperty("DBURL", DBURL);
        TUSYSproperties.setProperty("DBUsername", DBUsername);
        TUSYSproperties.setProperty("DBPassword", DBPassword);

        //saving properties
        FileOutputStream fos;
        try {
            fos = new FileOutputStream (propertiesfile);
            TUSYSproperties.store(fos, "");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(TUSYS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(TUSYS.class.getName()).log(Level.SEVERE, null, ex);
        }

        MainMenu mm = new MainMenu();
        mm.setDbc(dbc);
        mm.setVisible(true);
    }

    public TUSYS() throws SQLException, ClassNotFoundException {
        
    }
    
}
