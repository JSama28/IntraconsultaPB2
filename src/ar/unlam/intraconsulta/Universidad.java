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
	private ArrayList<HistorialAcademico> historialAcademico;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<>();
		this.inscripcionesMateria = new ArrayList<>();
		this.ciclosLectivos = new ArrayList <>();
		this.profesores = new ArrayList <>();
		this.comisiones = new ArrayList <>();
		this.historialAcademico = new ArrayList <>();
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Boolean agregarProfesorAComision(Integer dniProf, Integer idComision) {
		
		Comision comision = buscarComisionPorId(idComision);
		Profesor profe = buscarProfesorPorDni(dniProf);
		
		Boolean existeLaComision = comision != null;
		Boolean existeElProfeEnLaUni = profe != null;
		Boolean noTieneEsaComision = profe.tieneLaMismaComision(comision) == false;
		
		if(existeLaComision && existeElProfeEnLaUni && noTieneEsaComision) {
			return comision.agregarProfesorAComision(profe);
		}
		return false; 
	}
	
	public Boolean agregarCorrelatividad(Integer codigoMateria, Integer idCorrelativa) {
		Materia materia = buscarMateriaPorCodigo(codigoMateria);
		
		Boolean existeMateria = materia != null;
		Boolean existeCorrelativa = buscarMateriaPorCodigo(idCorrelativa) != null;
		
		  if (existeMateria && existeCorrelativa) {
		     return materia.agregarCorrelatividad(idCorrelativa);
		   }
		  return false;
		} 
	
	public Boolean eliminarCorrelatividad(Integer codigoMateria, Integer idCorrelativa) {
		Materia materia = buscarMateriaPorCodigo(codigoMateria);
		Boolean existeMateria = materia != null;
		Boolean existeCorrelativa = buscarMateriaPorCodigo(idCorrelativa) != null;
		
		if (existeMateria && existeCorrelativa) {
	       return materia.eliminarCorrelatividad(idCorrelativa);
		}
		return false;
	}
	
	public HistorialAcademico buscarHistorialAcademico(Integer dniAlumno, Integer codigoMateria) {
		for (int i = 0; i < this.historialAcademico.size(); i++) {
			Boolean esDelAlumno = this.historialAcademico.get(i).getDniAlumno().equals(dniAlumno);
			Boolean esLaMateria = this.historialAcademico.get(i).getCodigoMateria().equals(codigoMateria);
			
			if (esDelAlumno && esLaMateria)
				return this.historialAcademico.get(i);
		}
		return null;
	}
	
	public Boolean inscribirAlumnoAComision (Integer dni, Integer idComision) {
		Alumno alumno = buscarAlumnoPorDni(dni);
		Comision comision = buscarComisionPorId(idComision);
		Integer codigoMateria = comision.getCodigoMateria();
		Materia materia = buscarMateriaPorCodigo(codigoMateria);
		
		Boolean existeAlumno = alumno != null;
		Boolean existeComision = idComision != null;
		Boolean existeLaMateria = materia != null;
		Boolean aproboTodasLasCorrelativas = true;
		Boolean noExcedeMaximoDeAlumnos = comision.getAlumnos().size() < comision.getAula().getCapacidadMaxima();
		
		// Chequeo si aprobo todas las correlativas
		for(int i = 0; i<=materia.getIdCorrelativas().size(); i++) {
			Integer idCorrelativa = materia.getIdCorrelativas().get(i);
			HistorialAcademico historial = buscarHistorialAcademico(alumno.getDni(), idCorrelativa);
			Boolean desaprobo = historial.getEstadoNota() == TipoNota.Desaprobado;
			
			if (desaprobo) {
				aproboTodasLasCorrelativas = false;
			}
		}

		if(existeAlumno && existeComision && existeLaMateria && aproboTodasLasCorrelativas && noExcedeMaximoDeAlumnos) {
			return comision.inscribirAlumnoAComision(alumno);
		}
		
		return false;
	}
	
	
}
