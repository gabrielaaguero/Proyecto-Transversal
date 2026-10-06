
package modelo;

import java.time.LocalDate;

public class Alumno {
    private int id= -1;
    private int dni;
    private String nombre; //varchar
    private LocalDate fechaNac; //parsea Date
    private boolean activo;  //TINYINT
    
     public Alumno( int id,int dni, String nombre, LocalDate fechaNac, boolean activo) {
        this.id= id;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
     }

     public Alumno(int dni, String nombre, LocalDate fechaNac, boolean activo) {
        this.id= -1;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id+ "-"+ nombre;
    }
    
}

