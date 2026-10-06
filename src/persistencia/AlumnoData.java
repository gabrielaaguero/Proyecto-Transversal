
package persistencia;

import java.sql.PreparedStatement;
import modelo.Alumno;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class AlumnoData {
    private Connection con = null;
    
    public AlumnoData(conexion conexion){
        this.con = conexion.buscarConexion();
    }
    
    public void guardarAlumno(Alumno a) throws SQLException{
        String sql = "INSERT INTO alumno(dni, nombre, fecNac, activo) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(a.getFechaNac()));
            ps.setBoolean(4, a.isActivo());
            ps.executeUpdate();     // 3
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                a.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener ID");
            }
            ps.close();
            System.out.println("");
        } catch (SQLException ex) {
            System.out.println("No pude insertar");
        }
    }
    
    public Alumno buscarAlumno(int id){
        Alumno a = null;
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fecNac").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
            }
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
    public List<Alumno> listarAlumnos(){
        Alumno a= null;
       List<Alumno> alumnos = new ArrayList<>();
        String query = "SELECT * FROM alumno";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                a = new Alumno();
                a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
                alumnos.add(a);
            }
            ps.close();   // 5
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alumnos;
    }
    
}