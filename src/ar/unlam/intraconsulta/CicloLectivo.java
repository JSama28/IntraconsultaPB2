package ar.unlam.intraconsulta;

import java.time.LocalDate;

public class CicloLectivo {

		private LocalDate fechaInicio;
		private LocalDate fechaFin;
		private LocalDate fechaInscripcion;
		
		public CicloLectivo(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaInscripcion) {
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.fechaInscripcion = fechaInscripcion;
		}

		public LocalDate getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(LocalDate fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public LocalDate getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(LocalDate fechaFin) {
			this.fechaFin = fechaFin;
		}

		public LocalDate getFechaInscripcion() {
			return fechaInscripcion;
		}

		public void setFechaInscripcion(LocalDate fechaInscripcion) {
			this.fechaInscripcion = fechaInscripcion;
		}
		
}
