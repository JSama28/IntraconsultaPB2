package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Comision {

	private ArrayList<Alumno> alumnos;
	private Integer codigoMateria;
	private CicloLectivo cicloLectivo;
	private Integer comisionId;
	private ArrayList<Profesor> profesores;
	private ArrayList<Examen> examenes;
	private Turno turno;
	
	public Comision (Integer comisionId, CicloLectivo cicloLectivo, Integer codigoMateria, Turno turno) {
		this.comisionId = comisionId;
		this.alumnos = new ArrayList<Alumno>();
		this.codigoMateria = codigoMateria;
		this.cicloLectivo = cicloLectivo;
		this.profesores = new ArrayList<Profesor>();
		this.examenes = new ArrayList<Examen>();
		this.turno = turno;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Integer getComisionId() {
		return comisionId;
	}

	public void setComisionId(Integer comisionId) {
		this.comisionId = comisionId;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public ArrayList<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(ArrayList<Examen> examenes) {
		this.examenes = examenes;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	
	
}
