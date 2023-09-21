package ar.unlam.intraconsulta;

public class Examen {
	private Integer nota;
	private Alumno alumno;
	private Materia materia;
	
	public Examen(Materia materia, Alumno alumno, Integer nota) {
		this.materia = materia;
		this.alumno = alumno;
		this.nota = nota;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
