package ar.unlam.intraconsulta;

public class CicloLectivo {

		private Integer fechaInicio;
		private Integer fechaFin;
		private Integer fechaInscripcion;
		
		public CicloLectivo(Integer fechaInicio, Integer fechaFin, Integer fechaInscripcion) {
			this.setFechaInicio(fechaInicio);
			this.setFechaFin(fechaFin);
			this.setFechaInscripcion(fechaInscripcion);
		}

		public Integer getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(Integer fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public Integer getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(Integer fechaFin) {
			this.fechaFin = fechaFin;
		}

		public Integer getFechaInscripcion() {
			return fechaInscripcion;
		}

		public void setFechaInscripcion(Integer fechaInscripcion) {
			this.fechaInscripcion = fechaInscripcion;
		}
		
}
