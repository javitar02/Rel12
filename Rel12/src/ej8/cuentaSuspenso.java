package ej8;

public class cuentaSuspenso {
	private String nombreAlumno;
	private double[] nota;
	
	public cuentaSuspenso(String nombreAlumno, double[] nota) {
		super();
		this.nombreAlumno = nombreAlumno;
		this.nota = nota;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public double[] getNota() {
		return nota;
	}
	public void setNota(double[] nota) {
		this.nota = nota;
	}
	
}
