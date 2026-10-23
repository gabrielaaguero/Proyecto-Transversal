package vista;

import java.time.LocalDate;
import java.util.List;
import modelo.Alumno;
import modelo.Materia;
import persistencia.AlumnoData;
import persistencia.MateriaData;
import persistencia.conexion;

public class Universidad {

    public static void main(String[] args) {
        try {
            conexion c = new conexion();
            AlumnoData ad = new AlumnoData(c);

            try {
                ad.guardarAlumno(new Alumno(40111222, "Santino", LocalDate.of(2000, 1, 15), true));
                ad.guardarAlumno(new Alumno(40222333, "Gonzalo", LocalDate.of(2001, 5, 20), true));
                ad.guardarAlumno(new Alumno(40333444, "Martina", LocalDate.of(1999, 11, 30), true));
            } catch (Exception e) {
                System.out.println("Aviso: Algunos alumnos ya estaban registrados en la base de datos.");
            }

            List<Alumno> lista = ad.listarAlumnos();
            System.out.println("Total alumnos: " + lista.size());
            for (Alumno a : lista) {
                System.out.println(a.getId() + " - " + a.getDni() + " - " + a.getNombre()
                        + " - " + a.getFechaNac() + " - activo=" + a.isActivo());
            }

            Ventanaprincipal pantalla = new Ventanaprincipal();
            pantalla.setVisible(true);
            pantalla.setLocationRelativeTo(null);

            MateriaData md = new MateriaData(c);
            try {
                md.guardarMateria(new Materia(01, "Laboratorio", true));
            } catch (Exception e) {
                System.out.println("Aviso: La materia ya podria existir.");
            }

            for (Materia m : md.listarMateria()) {
                System.out.println(m.getIdMateria() + " - " + m.getCodigo() + " - " +m.getNombre() + " - " + m.isEstado());
            }

        } catch (Exception ex) {
            System.out.println("Error general en el main: " + ex.getMessage());
        }
    }
}
