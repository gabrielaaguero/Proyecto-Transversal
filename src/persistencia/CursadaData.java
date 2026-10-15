
package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Cursada;
import modelo.Alumno;
import modelo.Materia;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursadaData {

    private Connection con = null;
    
    public CursadaData (conexion conexion){
        this.con = conexion.buscarConexion();
    }
    
    public void guardarCursada (Cursada c){
        
        String sql = "INSERT INTO cursada (idAlumno, idMateria, nota, asist, cursa) VALUES (?, ?, ?, ?, ?))";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getAlumno().getId());
            ps.setInt(2, c.getMateria().getIdMateria());
            ps.setDouble(3, c.getNota());
            ps.setDouble(4, c.getAsist());
            ps.setInt(5, c.getCursa());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                c.setIdCursada(rs.getInt(1));
            } else {
                System.out.println("Error al obtener ID");
            }
            
            ps.close();
        } catch (SQLException ex){
            System.out.println("No se pudo insertar: " + ex.getMessage());
        }
        
    }
    
    public Cursada buscarCursada (int id){
        Cursada c = null;
        String sql = "SELECT * FROM cursada WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                c = new Cursada();
                c.setIdCursada(rs.getInt("idCursada"));
                
                Alumno a = new Alumno();
                a.setId(rs.getInt("idAlumno"));
                c.setAlumno(a);
                
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                c.setMateria(m);
                
                c.setNota(rs.getDouble("nota"));
                c.setAsist(rs.getDouble("asist"));
                c.setCursa(rs.getInt("cursa"));

            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo buscar: " + ex.getMessage());
        }
        return c;
    }
    
    public List<Cursada> listarCursadas(){
        
        List<Cursada> cursadas = new ArrayList<>();
        String sql = "SELECT * FROM cursada";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Cursada c = new Cursada();
                c.setIdCursada(rs.getInt("idCursada"));

                Alumno a = new Alumno();
                a.setId(rs.getInt("idAlumno"));
                c.setAlumno(a);

                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                c.setMateria(m);

                c.setNota(rs.getDouble("nota"));
                c.setAsist(rs.getDouble("asist"));
                c.setCursa(rs.getInt("cursa"));
                cursadas.add(c);
            }
            ps.close();
        } catch (SQLException ex){
            System.out.println("No se pudo obtener un listado: " + ex.getMessage());
        }
        return cursadas;
    }
    
    public void actualizarCursada (Cursada c){
        
        String sql = "UPDATE cursada SET nota = ?, asist = ?, cursa = ? WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, c.getNota());
            ps.setDouble(2, c.getAsist());
            ps.setInt(3, c.getCursa());
            ps.setInt(4, c.getIdCursada());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CursadaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void borrarCursada (int id){
        String sql = "DELETE FROM cursada WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex){
            Logger.getLogger(CursadaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List <Materia> materiasDeUnAlumno (int idAlumno){
        List <Materia> materias = new ArrayList<>();
        String sql = "SELECT m.* FROM materia m INNER JOIN cursada c ON m.idMateria = c.idMateria WHERE c.idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }
            ps.close();
        }catch (SQLException ex){
            System.out.println("No se pudo listar la lista de materias: " + ex.getMessage());
        }
        return materias;
        
    }
    
    public List <Alumno> alumnosDeUnaMateria (int idMateria){
        
        List<Alumno> alumnos = new ArrayList<>(); 
        String sql = "SELECT a.* FROM alumno a INNER JOIN cursada c ON a.idAlumno = c.idAlumno WHERE c.idMateria = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idMateria);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){
                 
                 Alumno a = new Alumno();
                 a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
                alumnos.add(a);
             }
             ps.close();
         } catch (SQLException ex){
             System.out.println("No se pudo listar los alumnos: " + ex.getMessage());
         }
         return alumnos;
         
    }
    
    public void registrarAsistencia (int idCursada, double asist){
        String sql = "UPDATE cursada SET asist = ? WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, asist);
            ps.setInt(2, idCursada);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex){
            Logger.getLogger(CursadaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarNota (int idCursada, double nota){
        
        String sql = "UPDATE cursada SET nota = ? WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idCursada);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex){
            Logger.getLogger(CursadaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
