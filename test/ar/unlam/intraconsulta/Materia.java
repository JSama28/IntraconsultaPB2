package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Materia {



	private Integer codigo;
	private String nombre;
	private ArrayList<Comision> comisiones;
	
	public Materia(Integer codigo, String nombre) {
		this.codigo =codigo;
		this.nombre=nombre;
		this.comisiones = new ArrayList<>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	
}
