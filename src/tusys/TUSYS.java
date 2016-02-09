/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys;

import java.sql.*;
import tusys.database.DatabaseLoginJDialog;
import tusys.view.MainMenu;
import tusys.database.dbconn;

/**
 *
 * @author erickchandra
 */
public class TUSYS {
    private static dbconn dbc;
    // private static DatabaseLoginJDialog dbLoginDialog;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        MainMenu mm = new MainMenu();
        DatabaseLoginJDialog dbLoginDialog = new DatabaseLoginJDialog(mm, true);
        dbLoginDialog.setVisible(true);
        dbc = new dbconn(dbLoginDialog.getDBUsername(), dbLoginDialog.getDBPassword());
        dbc.useDB();
        mm.setDbc(dbc);
        mm.setVisible(true);
    }

    public TUSYS() throws SQLException, ClassNotFoundException {
        
    }
    
}
