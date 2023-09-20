package ar.unlam.intraconsulta;

public class Aula {

	private Integer aulaNumero;
	private Integer capacidadMaxima;
	
	public Aula (Integer aulaNumero, Integer capacidadMaxima) {
		this.aulaNumero = aulaNumero;
		this.capacidadMaxima = capacidadMaxima;
	}

	public Integer getAulaNumero() {
		return aulaNumero;
	}

	public void setAulaNumero(Integer aulaNumero) {
		this.aulaNumero = aulaNumero;
	}

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
}
