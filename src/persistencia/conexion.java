
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
     private String url;
     private String usuario;
     private String password;
     
 private static Connection conexion= null;

    public conexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }
    
    public conexion (){
        this.url = "jdbc:mysql://localhost:3306/universidad";
        this.usuario = "root";
        this.password = "";
        
    }
    
    
 
 public Connection buscarConexion(){
     if (conexion == null) {
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e1) {
                    Class.forName("com.mysql.jdbc.Driver");
                }
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println("Conexión OK a " + url);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("no se puede conectar el driver. Error:" + e.getMessage());
            }
        }
        return conexion;
 }
}



             
   
