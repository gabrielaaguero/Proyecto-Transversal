
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
 
 public Connection buscarConexion(){
     if (conexion==null){
         try {
             Class.forName("com.mysql.jdbc.Driver");
               conexion=
        DriverManager.getConnection(url, usuario,password);
         } catch (SQLException | ClassNotFoundException e){
             System.out.println("no se puede conectar o no se puede cargar el drive.Error:" + e.getMessage());
         }
     }
     return conexion;
 }
}



             
   
