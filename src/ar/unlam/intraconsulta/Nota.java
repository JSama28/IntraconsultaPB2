package ar.unlam.intraconsulta;

public class Nota {

	private Integer valor;
	private TipoNota tipoNota;
	
	public Nota(Integer valor, TipoNota tipoNota) {
		this.valor = valor;
		this.tipoNota = tipoNota;
		
	}
		
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public TipoNota getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(TipoNota tipoNota) {
		this.tipoNota = tipoNota;
	}

	public void estadoNota(Integer valor) {
		if (valor >= 4 && valor <=10) {
		         this.tipoNota = TipoNota.Aprobado;
		     } else {
		         this.tipoNota = TipoNota.Desaprobado;
		     }
		}
}
