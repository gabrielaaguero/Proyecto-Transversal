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

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia(codigo, nombre, estado) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, materia.getCodigo());
            ps.setString(2, materia.getNombre());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                System.out.println("¡materia guardada!");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("no pude guardar la materia:" + e.getMessage());
        }
    }

    public boolean actualizarMateria(Materia materia) {
        String sql = "UPDATE materia SET codigo=?, nombre= ?, estado= ? WHERE idMateria= ?";
        boolean actualizado = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, materia.getCodigo());
            ps.setString(2, materia.getNombre());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            if (ps.executeUpdate() == 1) {
                actualizado = true;
                System.out.println("materia actualizada");
            } else {
                System.out.println("no existe la materia");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("no pude actualizar la materia" + e.getMessage());
        }
        return actualizado;
    }

    public void borrarMateria(int codigo) {
        String sql = "DELETE FROM materia WHERE codigo= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            if (ps.executeUpdate() == 1) {
                System.out.println("materia borrada correctamente");
            } else {
                System.out.println("no existe la materia");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("no pude borrar la materia: " + e.getMessage());
        }
    }

    public void bajaLogica(int codigo) {
        cambiarEstado(codigo, false);
    }

    public void altaLogica(int codigo) {
        cambiarEstado(codigo, true);
    }

    public Materia buscarMateria(int codigo) {
        Materia materia = null;
        String sql = "SELECT idMateria,codigo,nombre,estado FROM materia WHERE codigo= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setCodigo(rs.getInt("codigo"));
                materia.setNombre(rs.getString("nombre"));
                materia.setEstado(rs.getBoolean("estado"));
            } else {
                System.out.println("no existe la materia");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("no pude buscar la materia" + e.getMessage());
        }
        return materia;
    }

    public List<Materia> listarMateria() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT idMateria, codigo, nombre, estado FROM materia";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setCodigo(rs.getInt("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("no pude listar las materias" + e.getMessage());
        }
        return materias;
    }

    private void cambiarEstado(int codigo, boolean estado) {
        String sql = "UPDATE materia SET estado= ? WHERE codigo= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setInt(2, codigo);
            if (ps.executeUpdate() == 1) {
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
