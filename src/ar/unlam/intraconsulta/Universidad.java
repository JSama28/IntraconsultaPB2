package ar.unlam.intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {

	// private Alumno [] alumnos;
	private ArrayList<Alumno> alumnos;
	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList <InscripcionMateria> inscripcionesMateria;
	private ArrayList <CicloLectivo> ciclosLectivos;
	private ArrayList <Profesor> profesores;
	private ArrayList <Comision> comisiones;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<>();
		this.inscripcionesMateria = new ArrayList<>();
		this.ciclosLectivos = new ArrayList <>();
		this.profesores = new ArrayList <>();
		this.comisiones = new ArrayList <>();
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

	public Boolean registrarProfesor(Profesor profesor) {
		if (buscarProfesorPorDni(profesor.getDni()) == null)
			return this.profesores.add(profesor);

		return false;
	}

	public Profesor buscarProfesorPorDni(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni))
				return this.profesores.get(i);
		}
		
		return null;
	}
	
	public Comision buscarComisionPorId(Integer id) {
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getComisionId().equals(id))
				return this.comisiones.get(i);
		}
		
		return null;
	}
		
	public Boolean registrarMateria(Materia materia) {
		if(this.buscarMateriaPorCodigo(materia.getCodigoMateria()) == null) {
			return this.materias.add(materia); 	
		}
		return false;
	} 
	
	public Boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {
	
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
			if (this.materias.get(i).getCodigoMateria().equals(codigo))
				return this.materias.get(i);
		}
		return null;
	}
	
	public Boolean agregarComision(Comision comision) {
		Integer codigoMateria = comision.getCodigoMateria();
		Materia materia = buscarMateriaPorCodigo(codigoMateria);
		
		Boolean existeLaMateria = materia != null;
		Boolean noTieneEsaComision = materia.tieneLaMismaComision(comision) == false;
		
		if(existeLaMateria && noTieneEsaComision) {
			return materia.agregarComision(comision);
		}
		return false; 
	}
	
/*	public Boolean tieneLaMismaComision(Comision comision) {
		for (int i = 0; i < comisiones.size(); i++) {
			Comision comisionFor = this.comisiones.get(i);
			Boolean mismaMateria = comisionFor.getCodigoMateria() == comision.getCodigoMateria();
			Boolean mismoCiclo = comisionFor.getCicloLectivo().getFechaInicio() == comision.getCicloLectivo().getFechaInicio();
			Boolean mismoTurno =  comisionFor.getTurno() == comision.getTurno();
			Boolean mismoProfesor = comisionFor.getProfesores() == comision.getProfesores();
			
			if (mismaMateria && mismoCiclo && mismoTurno && mismoProfesor)
				return true;
		}
		
		return false;
	}

*/	

	public Boolean agregarProfesorAComision(Integer dniProf, Comision comision) {
		
		//Comision comision = buscarComisionPorId(comisionId);
		Profesor profe = buscarProfesorPorDni(dniProf);
		
		Boolean existeLaComision = comision != null;
		Boolean existeElProfeEnLaUni = profe != null;
		Boolean noTieneEsaComision = profe.tieneLaMismaComision(comision) == false;
		
		if(existeLaComision && existeElProfeEnLaUni && noTieneEsaComision) {
			return comision.agregarProfesorAComision(profe);
		}
		return false; 
	}
	
	

}
