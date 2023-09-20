package ar.unlam.intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	// private Alumno [] alumnos;
	private ArrayList<Alumno> alumnos;
	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList <InscripcionMateria> inscripcionesMateria;
	private ArrayList <CicloLectivo> ciclosLectivos;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<>();
		this.inscripcionesMateria = new ArrayList<>();
		this.ciclosLectivos = new ArrayList <>();
	}

	public Boolean agregarCicloLectivo(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaInscripcion) {
		CicloLectivo ciclo = new CicloLectivo(fechaInicio, fechaFin, fechaInscripcion);
		
		if(buscarCicloLectivoPorFecha(fechaInicio) == null) {
			return ciclosLectivos.add(ciclo);
		}
		
		return false;
	}
	
	public CicloLectivo buscarCicloLectivoPorFecha(LocalDate fechaInicio) {
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if (this.ciclosLectivos.get(i).getFechaInicio().equals(fechaInicio))
				return this.ciclosLectivos.get(i);
		}
		
		return null;
	}
	
	public Boolean registrar(Alumno alumno) {
		if (buscarAlumnoPorDni(alumno.getDni()) == null)
			return this.alumnos.add(alumno);

		return false;
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {

		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return this.alumnos.get(i);
		}
		
		return null;
	}

	public Boolean existeAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	public Boolean registrarMateria(Materia materia) {
		if(this.buscarMateriaPorCodigo(materia.getCodigo()) == null) {
			return this.materias.add(materia); 	
		}
		return false;
	} 

	public boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {
	
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarMateriaPorCodigo(codigo);
		
		if (alumno != null && materia != null) {
			InscripcionMateria  inscripcionMateria = new InscripcionMateria (alumno,materia);
			return this.inscripcionesMateria.add(inscripcionMateria );
		}
		
		return false;
	}

	private Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo))
				return this.materias.get(i);
		}
		return null;
	}
	
	

}
