
package modelo;

public class Materia {
    private int idMateria;
    private String nombre;
    private boolean estado;

    public Materia(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public Materia(int idMateria, String nombre, boolean estado) {
        this.idMateria = idMateria;
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

    @Override
    public String toString() {
        return idMateria + "-" + nombre;
    }
    
}

