package org.is.webApp;

public class Usuario {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String correo;
	private String dni;
	private String genero;
	private int idUsuario;
	private static int idUsu = 0;
	private String puntuacion;
	private String contrasena;
	
	
	public Usuario(String nombre, String apellido1, String apellido2,
			String direccion, String correo, String dNI, String genero,
			int idUsuario, String puntuacion, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.correo = correo;
		this.dni = dni;
		this.genero = genero;
		this.idUsuario = idUsuario;
		this.puntuacion = puntuacion;
		this.contrasena = contrasena;
	}


	public Usuario(String nombre, String apellido1, String apellido2,
			String direccion, String correo, String dni, String genero,
			String puntuacion, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.correo = correo;
		this.dni = dni;
		this.genero = genero;
		this.puntuacion = puntuacion;
		this.contrasena = contrasena;
		this.idUsuario = idUsu++;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}


	
	public int getIdUsuario() {
		return idUsuario;
	}



	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", direccion=" + direccion
				+ ", correo=" + correo + ", dni=" + dni + ", genero=" + genero
				+ ", puntuacion=" + puntuacion + ", contrasena=" + contrasena
				+ "]";
	}
	
	public int compareTo(Usuario u){
		int igual = 0;
		
		if(this.nombre.equalsIgnoreCase(u.getNombre()))
			if(this.apellido1.equalsIgnoreCase(u.getApellido1()))
				if(this.apellido2.equalsIgnoreCase(u.getApellido2()))
					if(this.dni.equalsIgnoreCase(u.getDni()))
						if(this.correo.equalsIgnoreCase(u.getCorreo()))
							if(this.direccion.equalsIgnoreCase(u.getDireccion()))
								if(this.genero.equalsIgnoreCase(u.getGenero()))
									if(this.puntuacion == u.getPuntuacion())
										if(this.contrasena.equalsIgnoreCase(u.getContrasena()))
											igual = 1;
		return igual;
}
	
}
