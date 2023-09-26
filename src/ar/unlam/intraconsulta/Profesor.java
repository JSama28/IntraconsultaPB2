package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Profesor {
	private Integer dni;
	private String apellido;
	private String nombre;
	private ArrayList <Comision> comisiones;

	public Profesor(Integer dni, String apellido, String nombre) {
	this.dni=dni;
	this.apellido=apellido;
	this.nombre=nombre;
	this.comisiones = new ArrayList<>();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean tieneLaMismaComision(Comision comision) {
		for (int i = 0; i < comisiones.size(); i++) {
			Comision comisionFor = this.comisiones.get(i);
			Boolean mismaMateria = comisionFor.getCodigoMateria() == comision.getCodigoMateria();
			Boolean mismoCiclo = comisionFor.getCicloLectivo().getFechaInicio() == comision.getCicloLectivo().getFechaInicio();
			Boolean mismoTurno =  comisionFor.getTurno() == comision.getTurno();
			Boolean mismoProfesor = comisionFor.getProfesores() == comision.getProfesores();
			
			if (mismoProfesor && mismoCiclo && mismoTurno && mismaMateria)
				return true;
		}
		
		return false;
	}
	

}

