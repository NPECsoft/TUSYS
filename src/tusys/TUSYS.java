/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tusys;

import java.sql.*;
import tusys.database.dbconn;

/**
 *
 * @author erickchandra
 */
public class TUSYS {
    private static dbconn dbc;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        dbc = new dbconn("desktopuser", "desktoppass");
    }

    public TUSYS() throws SQLException, ClassNotFoundException {
        
    }
    
}
