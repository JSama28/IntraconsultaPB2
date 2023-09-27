package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Materia {

	private Integer codigoMateria;
	private String nombre;
	private ArrayList <Comision> comisiones;
	private ArrayList <Integer> idCorrelativas;
	
	
	public Materia(Integer codigoMateria, String nombre) {
		this.codigoMateria =codigoMateria;
		this.nombre=nombre;
		this.comisiones = new ArrayList<>();
		this.idCorrelativas = new ArrayList<>();
		
	}

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}
	
	public Boolean agregarComision(Comision comision) {
		return this.comisiones.add(comision);
		
	}
	
	public Comision buscarComisionPorId(Integer comisionId) {
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getComisionId().equals(comisionId))
				return this.comisiones.get(i);
		}
		
		return null;
	}
	
	public Boolean tieneLaMismaComision(Comision comision) {
		for (int i = 0; i < comisiones.size(); i++) {
			Comision comisionFor = this.comisiones.get(i);
			Boolean mismaMateria = comisionFor.getCodigoMateria() == comision.getCodigoMateria();
			Boolean mismoCiclo = comisionFor.getCicloLectivo().getFechaInicio() == comision.getCicloLectivo().getFechaInicio();
			Boolean mismoTurno =  comisionFor.getTurno() == comision.getTurno();
			
			if (mismaMateria && mismoCiclo && mismoTurno)
				return true;
		}
		
		return false;
	}
	
	public Boolean agregarCorrelatividad(Integer idCorrelativa) {
		return this.idCorrelativas.add(idCorrelativa);
	}
	
	public Boolean eliminarCorrelatividad(Integer idCorrelativa) {
		return this.idCorrelativas.remove(idCorrelativa);
	}

	public ArrayList<Integer> getIdCorrelativas() {
		return idCorrelativas;
	}

	public void setIdCorrelativas(ArrayList<Integer> idCorrelativas) {
		this.idCorrelativas = idCorrelativas;
	}
}
