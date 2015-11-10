package org.is.webApp;
import java.io.*;
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
			if(listaUsuarios.get(i).getIdUsuario()==u.getIdUsuario())
				encontrado = 1;
		}

		if(encontrado == 0){
			listaUsuarios.add(u);
			guardarUsuariosEnArchivo();
			return 1;
		}
		else return 0;
	}
	
	public int borrarUsuario(Usuario u){
		
		
		for (int i=0;i<listaUsuarios.size();i++){
			if(listaUsuarios.get(i).getIdUsuario()==(u.getIdUsuario())){
				listaUsuarios.remove(u);
				try {
					BufferedReader in = new BufferedReader(new FileReader(rutaArchivo));
					String cadena;
					String archivo="";					
					while ((cadena = in.readLine()) != null) {
						StringTokenizer token = new StringTokenizer(cadena, "|");
						token.nextToken();
						token.nextToken();
						token.nextToken();
						token.nextToken();
						token.nextToken();
						if(token.nextToken().equalsIgnoreCase(u.getDni())){
							
						}else{
					archivo=archivo+cadena+"\n";
						}
					}
					in.close();

					PrintWriter out = new PrintWriter(new FileWriter(new File(this.rutaArchivo)));

					out.println(archivo);
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 1;
			}
		}
		return 0;
	}
	
	public Usuario buscarUsuarios(int id){

		Usuario u = null;

		for(int i=0; i<listaUsuarios.size(); i++){
			Usuario uAux = listaUsuarios.get(i);
			if(uAux.getIdUsuario()==id){
				u = uAux;
			}
		}
		return u;
	}
	
	public int modificarUsuario(Usuario u){
		int modificacion;
		int i=-1;

		for(int j=0;j<listaUsuarios.size();j++){
			//if(listaUsuarios.get(j).getDni().equalsIgnoreCase(u.getDni())){
			if(listaUsuarios.get(j).getDni().equalsIgnoreCase(u.getDni())||listaUsuarios.get(j).getDireccion().equalsIgnoreCase(u.getDireccion())){
				i=j;

				break;
			}
		}
		
		if(i==-1){
			modificacion=0;
		}
	else{
		listaUsuarios.get(i).setNombre(u.getNombre());
		listaUsuarios.get(i).setApellido1(u.getApellido1());
		listaUsuarios.get(i).setApellido2(u.getApellido2());
		listaUsuarios.get(i).setDireccion(u.getDireccion());
		listaUsuarios.get(i).setCorreo(u.getCorreo());
		listaUsuarios.get(i).setDni(u.getDni());
		listaUsuarios.get(i).setGenero(u.getGenero());
		listaUsuarios.get(i).setPuntuacion(u.getPuntuacion());
		listaUsuarios.get(i).setContrasena(u.getContrasena());
	//	listaUsuarios.add(i, u);
		System.out.print(u.toString());
			guardarUsuariosEnArchivo();
			modificacion = 1;

	}	
		return modificacion;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	


}
