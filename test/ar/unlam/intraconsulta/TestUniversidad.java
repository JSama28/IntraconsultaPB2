package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "Marta";
    	String apellido = "perez";
    	Integer dni= 44555; 
    	Alumno alumno = new Alumno (dni,apellido, nombre);
		Boolean registroExitoso = unlam.registrar(alumno);
    	assertTrue(registroExitoso);
    	
    	
	}
	
	
	@Test
	public void queNoSePuedaRegistrarUnAlumnoCuandoElAlumnoYaEsteRegistradoAUnaUniversidad() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "Marta";
    	String apellido = "perez";
    	Integer dni= 44555; 
    	Alumno alumno = new Alumno (dni,apellido, nombre);
    	Alumno alumno2 = new Alumno (dni,"jose", "Lopez");
    	unlam.registrar(alumno);
		Boolean registroExitoso = unlam.registrar(alumno2);
    	assertFalse(registroExitoso);
    	
    	
	}
	
	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "PB2 ";
        Integer codigo = 1;
        Materia pb2 = new Materia (codigo,nombre);
        assertTrue (unlam.registrarMateria(pb2));
    	       
	}
	
	
	
	@Test
	public void queSePuedaInscribirUnAlumnoenMateria() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "PB2 ";
        Integer codigo = 1;
        Materia pb2 = new Materia (codigo,nombre);
        unlam.registrarMateria(pb2);
     	nombre = "Marta";
    	String apellido = "perez";
    	Integer dni= 44555; 
        Alumno alumno = new Alumno (dni,apellido, nombre);
    	unlam.registrar(alumno);
    	assertTrue (unlam.inscribirAlumnoAUnaMateria(dni,codigo)) ;
    	       
	}
	
	@Test
	public void agregarMateria() {
	//No se puede agregar 2 materias con mismo Id
		 Materia computacion = new Materia (1,"Computacion");
		 Materia ingles = new Materia (1,"Ingles");
		 Universidad unlam = new Universidad ("UNLaM");
		 unlam.registrarMateria(computacion);
		 assertFalse(unlam.registrarMateria(ingles));
	}
	
	@Test
	public void agregarAlumno() {
	//No se puede agregar 2 alumnos con mismo Dni
		Alumno nico = new Alumno(3425,"Ciri","Nicolas");
		Alumno javier = new Alumno(3425,"Taura","Javier");
		Universidad unlam = new Universidad("UNLaM");
		unlam.registrar(javier);
		assertFalse(unlam.registrar(nico));
	}

	@Test
	public void agregarCicloLectivo() {
		
	}

	@Test
	public void agregarComision() {
	//No se Pueden generar 2 Comisiones para la misma materia, el mismo cicloLectivo y el mismo turno
		 Materia ingles = new Materia (1,"Ingles");
		 Universidad unlam = new Universidad ("UNLaM");
		 
	}
	
/*	agregarDocentes
	//No se puede agregar 2 docentes con el mismo dni

	asignarDocentesAComision
	//El mismo docente no puede ser profesor de la misma comisión 2 veces.

	agregarCorrelatividad(idMateria,  idCorrelativa)
	//Se debe validar que ambos códigos existan en una materia

	eliminarCorrelatividad(idMateria, idCorrelativaAELiminar)
	//Se debe validar que esa correlatividad exista

	inscribirAlumnoAComision (dni, idComision)
	// Verificar que el alumno y la comisión estén dados de alta
	//No se puede inscribir Alumnos si este no tiene aprobadas todas las correlativas. Se aprueba con 4 o más.
	//La inscripción no se puede realizar si esta fuera de fecha Inscripción
	//No se puede inscribir el alumno si excede la cantidad de alumnos permitidos en el aula
	//No se puede inscribir el Alumno si ya está inscripto a otra comisión el mismo día y Turno
	//No se puede inscribir a una materia que haya aprobado previamente

	asignarProfesorAlaComision(idComision, dniDocente)
	// verificar que exista la comisión y el docente
	//Cada 20 alumnos se debe agregar un docente ejemplo de 1 a 20 alumnos solo se puede asignar un docente, de 21 a 40 2 docentes

	asignarAulaAlaComision(idComision, dniDocente)
	// verificar que exista la comisión y el docente
	//Cada 20 alumnos se debe agregar un docente ejemplo de 1 a 20 alumnos solo se puede asignar un docente, de 21 a 40 2 docentes

	registrarNota (idComision, idAlumno, nota)
	// La nota debe estar entre 1 y 10
	// No se puede asignar Una nota Mayor o igual a 7 si no están todas las correlativas aprobadas (Mayor o igual a 7)
	//Las notas pueden ser de tipo 1erParc, 2doParc, Rec1Parcial, Rec2Parcial, Final
	//no puede rendir 2 recuperatorios, es solo 1.
	//para cargar la nota final, debe tener aprobadas las parciales

	obtenerMateriasAprobadasParaUnAlumno(idAlumno)
	Debe devolver un arreglo de materias

	obtenerNota(idAlumno, idMateria)

	obtenerMateriasQueFaltanCursarParaUnAlumno(idAlumno)
	Debe devolver un arreglo de materias

	calcularPromedio(idAlumno)

	
	
	*/
	
	
	
	

	

}