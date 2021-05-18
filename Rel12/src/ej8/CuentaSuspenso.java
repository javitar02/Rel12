package ej8;

public class CuentaSuspenso {
	private String nombreAlumno;
	private int asignaturaSuspensas;
	public CuentaSuspenso(String nombreAlumno, int asignaturaSuspensas) {
		super();
		this.nombreAlumno = nombreAlumno;
		this.asignaturaSuspensas = asignaturaSuspensas;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public int getAsignaturaSuspensas() {
		return asignaturaSuspensas;
	}
	public void setAsignaturaSuspensas(int asignaturaSuspensas) {
		this.asignaturaSuspensas = asignaturaSuspensas;
	}
	@Override
	public String toString() {
		return "cuentaSuspenso [nombreAlumno=" + nombreAlumno + ", asignaturaSuspensas=" + asignaturaSuspensas + "]";
	}
	
	

	
}
