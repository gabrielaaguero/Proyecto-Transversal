
package modelo;

public class Materia {
    private int idMateria;
    private String nombre;
    private int codigo;
    private boolean estado;
    
    public Materia(){
    }

    public Materia(int codigo, String nombre, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Materia(int idMateria, int codigo, String nombre, boolean estado) {
        this.idMateria = idMateria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    public int getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    

    @Override
    public String toString() {
        return idMateria + "-" + nombre;
    }
    
}


