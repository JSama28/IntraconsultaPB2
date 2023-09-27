package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class HistorialAcademico {
	
	private Integer dniAlumno;
	private Integer codigoMateria;
	private TipoNota estadoNota;
	
	public HistorialAcademico(Integer dniAlumno, Integer codigoMateria, TipoNota estadoNota) {
		this.dniAlumno = dniAlumno;
		this.codigoMateria = codigoMateria;
		this.estadoNota = estadoNota;
	}
	
	public Integer getDniAlumno() {
		return dniAlumno;
	}
	public void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}
	public Integer getCodigoMateria() {
		return codigoMateria;
	}
	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}
	public TipoNota getEstadoNota() {
		return estadoNota;
	}
	public void setEstadoNota(TipoNota estadoNota) {
		this.estadoNota = estadoNota;
	}
}
