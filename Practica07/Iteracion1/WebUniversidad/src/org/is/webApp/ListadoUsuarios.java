package org.is.webApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListadoUsuarios {
	
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private String rutaArchivo = "WebUniversidad/WebContent/pages/usuario/usuarios.txt";
	
	public ListadoUsuarios(){
		this.listaUsuarios = cargarUsuariosDelArchivo();

		for(int i = 0; i<getListaUsuarios().size(); i++){
			Usuario u = getListaUsuarios().get(i);
			System.out.println(u.toString());
		}
	}
	
	private ArrayList<Usuario> cargarUsuariosDelArchivo() {
		System.out.println("Cargando Torneos de: "+ rutaArchivo);
		ArrayList<Usuario> usuariosLeidos = new ArrayList<Usuario>();

		try {
			BufferedReader in = new BufferedReader(new FileReader(rutaArchivo));
			String cadena;
			int i = 0;
			while ((cadena = in.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(cadena, "|");
				String nombre = null, apellido1 = null, apellido2 = null, direccion = null, correo = null, dni = null, genero = null,puntuacion = null, contrasena = "";
				
				while(token.hasMoreTokens()){
					nombre = token.nextToken();
					apellido1 = token.nextToken();
					apellido2 = token.nextToken();
					direccion = token.nextToken();
					correo = token.nextToken();
					dni = token.nextToken();
					genero = token.nextToken();
					puntuacion = token.nextToken();
					contrasena = token.nextToken();
				}
				Usuario u = new Usuario(nombre, apellido1, apellido2, direccion, correo, dni, genero, puntuacion, contrasena);
				usuariosLeidos.add(u);
				i++;
			}
			System.out.println("Numero Usuarios leidos: "+i);
		} catch (IOException e) {
			System.out.println("Error en la carga del archivo: " + e.getMessage());
			System.out.println(System.getProperty("user.dir"));
		}
		return usuariosLeidos;
	}
	
	public void guardarUsuariosEnArchivo (){

		System.out.println("Guardando Usuarios en: " + this.rutaArchivo);

		try {
			PrintWriter out = new PrintWriter(new FileWriter(new File(this.rutaArchivo)));

			for(int i = 0; i<this.listaUsuarios.size(); i++){
				String linea = this.listaUsuarios.get(i).getNombre()
						+ "|"
						+ this.listaUsuarios.get(i).getApellido1()
						+ "|"
						+ this.listaUsuarios.get(i).getApellido2()
						+ "|"
						+ this.listaUsuarios.get(i).getDireccion()
						+ "|"
						+ this.listaUsuarios.get(i).getCorreo()
						+ "|"
						+ this.listaUsuarios.get(i).getDni()
						+ "|"
						+ this.listaUsuarios.get(i).getGenero()
						+ "|"
						+ this.listaUsuarios.get(i).getPuntuacion()
						+ "|"
						+ this.listaUsuarios.get(i).getContrasena();
				out.println(linea);
			}
			out.close();
		} catch (IOException e) {
			System.out.println("Excepcion al guardar archivo de usuarios");
		}
	}
	
	public int insertarUsuario(Usuario u){
		int encontrado = 0;

		for(int i = 0; i<listaUsuarios.size() && encontrado==0; i++){
			if(listaUsuarios.get(i).getDni().equalsIgnoreCase(u.getDni()))
				encontrado = 1;
		}

		if(encontrado == 0){
			listaUsuarios.add(u);
			guardarUsuariosEnArchivo();
			return 1;
		}
		else return 0;
	}
	
	public Usuario buscarUsuarios(String dni){

		Usuario u = null;

		for(int i=0; i<listaUsuarios.size(); i++){
			Usuario uAux = listaUsuarios.get(i);
			if(uAux.getDni()==dni){
				u = uAux;
			}
		}
		return u;
	}
	
	public int modificarUsuario(Usuario u){

		int encontrado = 0;

		Usuario uAux = buscarUsuarios(u.getDni()); 
		
		for(int i = 0; i<listaUsuarios.size() && encontrado == 0; i++){
			encontrado = listaUsuarios.get(i).compareTo(u);
		}
		
		if(encontrado==0){
			uAux.setNombre(u.getNombre());
			uAux.setApellido1(u.getApellido1());
			uAux.setApellido2(u.getApellido2());
			uAux.setDireccion(u.getDireccion());
			uAux.setCorreo(u.getCorreo());
			uAux.setDni(u.getDni());
			uAux.setGenero(u.getGenero());
			uAux.setPuntuacion(u.getPuntuacion());
			uAux.setContrasena(u.getContrasena());
			guardarUsuariosEnArchivo();
			encontrado = 1;
		}else{
			encontrado = 0;
		}
		return encontrado;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	


}
