
package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Materia;

public class MateriaData {
    private Connection con;

    public MateriaData(conexion c) {
        this.con = c.buscarConexion();
    }
    public void guardarMateria(Materia materia){
        String sql="INSERT INTO materia(nombre, estado) VALUES (?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setBoolean(2, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()){
           materia.setIdMateria(rs.getInt(1));
                System.out.println("¡materia guardada!");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("no pude guardar la materia:" + e.getMessage());
        }
    }
    public boolean actualizarMateria(Materia materia) {
        String sql= "UPDATE materia SET nombre= ?, estado= ? WHERE idMateria= ?";
        boolean actualizado = false;
        try {
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setString(1, materia.getNombre());
             ps.setBoolean(2, materia.isEstado());
             ps.setInt(3, materia.getIdMateria());
             if( ps.executeUpdate()== 1){
                 actualizado = true;
                 System.out.println("materia actualizada");
             } else {
                 System.out.println("no existe la materia");
             }
             ps.close();
        } catch (SQLException e){
            System.out.println("no pude actualizar la materia" + e.getMessage());
        }
        return actualizado;
    }
    public void borrarMateria(int id){
        String sql = "DELETE FROM materia WHERE idMateria= ?";
        try {
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setInt(1, id);
          if (ps.executeUpdate()==1){
              System.out.println("materia borrada correctamente");
          } else {
              System.out.println("no existe la materia");
          }
          ps.close();
        } catch (SQLException e){
            System.out.println("no pude borrar la materia: " + e.getMessage());
        }
    }
    public void bajaLogica(int id){
        cambiarEstado(id,false);
    }
    public void altaLogica(int id){
        cambiarEstado(id,true);
    }
    public Materia buscarMateria(int id){
        Materia materia=null;
        String sql= "SELECT nombre,estado FROM materia WHERE idMateria= ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                materia=new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setEstado(rs.getBoolean("estado"));
              } else {
                System.out.println("no existe la materia");
            }
            ps.close();
        } catch (SQLException e){
            System.out.println("no pude buscar la materia" + e.getMessage());
        }
        return materia;
    }
    public List<Materia> listarMateria(){
        List<Materia> materias= new ArrayList<>();
        String sql= "SELECT idMateria, nombre, estado FROM materia";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Materia m =new Materia();
            m.setIdMateria(rs.getInt("idMateria"));
            m.setNombre(rs.getString("nombre"));
            m.setEstado(rs.getBoolean("estado"));
               materias.add(m);
            }
            ps.close();
        } catch(SQLException e) {
            System.out.println("no pude listar las materias" + e.getMessage());
        }
        return materias;
    }
    private void cambiarEstado(int id, boolean estado){
        String sql= "UPDATE materia SET estado= ? WHERE idMateria= ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setInt(2, id);
           if(ps.executeUpdate() == 1){
               System.out.println(estado ? "materia dada de alta" : "materia dada de baja");
           } else {
               System.out.println("no existe la materia");
           }
           ps.close();
        } catch (SQLException e) {
            System.out.println("no pude cambiar el estado: " + e.getMessage());
        }
    }
}

    
        
   
