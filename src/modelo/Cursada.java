
package modelo;

/**
 *
 * @author Educacion
 */
public class Cursada {
   private int idCursada;
   private Alumno alumno;
   private Materia materia;
   private double nota;
   private double asist;
   private int cursa;

    public Cursada(Alumno alumno, Materia materia, double nota, double asist, int cursa) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.asist = asist;
        this.cursa = cursa;
    }

    public Cursada(int idCursada, Alumno alumno, Materia materia, double nota, double asist, int cursa) {
        this.idCursada = idCursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.asist = asist;
        this.cursa = cursa;
    }

    public int getIdCursada() {
        return idCursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public double getNota() {
        return nota;
    }

    public double getAsist() {
        return asist;
    }

    public int getCursa() {
        return cursa;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setAsist(double asist) {
        this.asist = asist;
    }

    public void setCursa(int cursa) {
        this.cursa = cursa;
    }
   
}

