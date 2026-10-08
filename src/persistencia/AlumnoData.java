package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Alumno;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoData {
    private Connection con = null;

    public AlumnoData(conexion conexion) {
        this.con = conexion.buscarConexion();
    }

    public void guardarAlumno(Alumno a) {
        String sql = "INSERT INTO alumno(dni, nombre, fechaNac, activo) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(a.getFechaNac()));
            ps.setBoolean(4, a.isActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                a.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener ID");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No pude insertar: " + ex.getMessage());
        }
    }

    public Alumno buscarAlumno(int id) {
        Alumno a = null;
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No pude buscar: " + ex.getMessage());
        }
        return a;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String query = "SELECT * FROM alumno";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
                alumnos.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No pude listar: " + ex.getMessage());
        }
        return alumnos;
    }
    
    public void actualizarAlumno(Alumno a){
        String query = "UPDATE alumno SET nombre = ?, dni = ?, fechaNac = ?, activo = ? WHERE idAlumno = ?";  //1
        
        try {
            PreparedStatement ps = con.prepareStatement(query); 
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getDni());
            ps.setDate(3, java.sql.Date.valueOf(a.getFechaNac()));
            ps.setBoolean(4, a.isActivo());
            ps.setInt(5, a.getId());
            ps.executeUpdate();
                       
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void borrarAlumno(int id){
        String query = "DELETE FROM alumno WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminadoLogicoAlumno(int id){
        String query = "UPDATE alumno SET activo = 0 WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
