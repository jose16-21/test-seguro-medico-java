
package seguro.datos;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

        
public class Conexion {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    String url ="jdbc:mysql://localhost:3306/db_ferreteria?useSSL=false";
    String usuario = "root";
    String pass = "";
    
    public Conexion(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, pass);
            /*
            st = con.createStatement();
            rs = st.executeQuery("SELECT nom_categoria, dsc_categoria FROM categorias");
            
            while (rs.next()){
      
                String nombre = rs.getString("nom_categoria");
                String dsc = rs.getString("dsc_categoria");
                System.out.println(nombre);
                System.out.println(dsc);
;
            }
            JOptionPane.showMessageDialog(null, "La conexión fue correcta");
            */
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió este error: \n"+ex,
                            "¡Error!", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió este error: \n"+ex,
                            "¡Error!", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public static void main (String []args){
        new Conexion();
    }
}
