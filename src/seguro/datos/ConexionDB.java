/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguro.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A
 */
public class ConexionDB {
    Connection con = null;
    String url = "jdbc:postgresql://localhost:5432/Db_Ferreteria";
    String usuario = "postgres";
    String clave = "6781";
    
    public ConexionDB(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
