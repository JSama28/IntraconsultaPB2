package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Comision {

	private ArrayList<Alumno> alumnos;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Integer comisionId;
	
	public Comision (Integer comisionId, CicloLectivo cicloLectivo, Materia materia, Alumno alumnos) {
		this.comisionId = comisionId;
		this.alumnos = new ArrayList<Alumno>();
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
	
	}
	
	
}
