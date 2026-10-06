package vista;

import java.time.LocalDate;
import java.util.List;
import modelo.Alumno;
import persistencia.AlumnoData;
import persistencia.conexion;

public class Universidad {

    public static void main(String[] args) {

        conexion c = new conexion();
        if (c.buscarConexion() == null) {
            System.out.println("Sin conexión, revisa XAMPP y el jar mysql-connector");
            return;
        }

        AlumnoData ad = new AlumnoData(c);
        ad.guardarAlumno(new Alumno(40111222, "Santino", LocalDate.of(2000, 1, 15), true));
        ad.guardarAlumno(new Alumno(40222333, "Gonzalo", LocalDate.of(2001, 5, 20), true));
        ad.guardarAlumno(new Alumno(40333444, "Martina", LocalDate.of(1999, 11, 30), true));


        List<Alumno> lista = ad.listarAlumnos();
        System.out.println("Total alumnos: " + lista.size());
        for (Alumno a : lista) {
            System.out.println(a.getId() + " - " + a.getDni() + " - " + a.getNombre()
                    + " - " + a.getFechaNac() + " - activo=" + a.isActivo());
        }
    }

}
