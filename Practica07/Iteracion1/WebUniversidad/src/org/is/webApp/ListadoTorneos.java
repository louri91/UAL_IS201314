package org.is.webApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListadoTorneos {
	
	private ArrayList<Torneo> listaTorneos = new ArrayList<Torneo>();
	private String rutaArchivo = "WebUniversidad/WebContent/pages/torneo/torneos.txt";
	
	public ListadoTorneos(){
		this.listaTorneos = cargarTorneosDelArchivo();

		for(int i = 0; i<getListaTorneos().size(); i++){
			Torneo t = getListaTorneos().get(i);
			System.out.println(t.toString());
		}
	}
	
	private ArrayList<Torneo> cargarTorneosDelArchivo() {
		System.out.println("Cargando Torneos de: "+ rutaArchivo);
		ArrayList<Torneo> torneosLeidos = new ArrayList<Torneo>();

		try {
			BufferedReader in = new BufferedReader(new FileReader(rutaArchivo));
			String cadena;
			int i = 0;
			while ((cadena = in.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(cadena, "|");
				String nombre = "", tipoMesa = "", premio = "", jugadores = "";
				int numMinimo = 0;
				int numMaximo = 0;
				boolean clasificatoria = false;
				
				while(token.hasMoreTokens()){
					nombre = token.nextToken();
					numMinimo = Integer.parseInt(token.nextToken());
					numMaximo = Integer.parseInt(token.nextToken());
					tipoMesa = token.nextToken();
					clasificatoria = Boolean.parseBoolean(token.nextToken());
					premio = token.nextToken();
					jugadores = token.nextToken();
				}
				Torneo t = new Torneo(nombre, numMinimo, numMaximo, tipoMesa, clasificatoria, premio, jugadores);
				torneosLeidos.add(t);
				i++;
			}
			System.out.println("Numero Torneos leidos: "+i);
		} catch (IOException e) {
			System.out.println("Error en la carga del archivo: " + e.getMessage());
			System.out.println(System.getProperty("user.dir"));
		}
		return torneosLeidos;
	}
	
	public void guardarTorneosEnArchivo (){

		System.out.println("Guardando Torneos en: " + this.rutaArchivo);

		try {
			PrintWriter out = new PrintWriter(new FileWriter(new File(this.rutaArchivo)));

			for(int i = 0; i<this.listaTorneos.size(); i++){
				String linea = this.listaTorneos.get(i).getNombre()
						+ "|"
						+ this.listaTorneos.get(i).getNumMinimo()
						+ "|"
						+ this.listaTorneos.get(i).getNumMaximo()
						+ "|"
						+ this.listaTorneos.get(i).getTipoMesa()
						+ "|"
						+ this.listaTorneos.get(i).isClasificatoria()
						+ "|"
						+ this.listaTorneos.get(i).getPremio()
						+ "|"
						+ this.listaTorneos.get(i).getJugadores();
				out.println(linea);
			}
			out.close();
		} catch (IOException e) {
			System.out.println("Excepcion al guardar archivo de torneos");
		}
	}
	
	public int insertarTorneo(Torneo t){
		int encontrado = 0;

		for(int i = 0; i<listaTorneos.size() && encontrado==0; i++){
			if(listaTorneos.get(i).getNombre().equalsIgnoreCase(t.getNombre()))
				encontrado = 1;
		}

		if(encontrado == 0){
			listaTorneos.add(t);
			guardarTorneosEnArchivo();
			return 1;
		}
		else return 0;
	}
	
	public Torneo buscarTorneo(int id){

		Torneo t = null;

		for(int i=0; i<listaTorneos.size(); i++){
			Torneo tAux = listaTorneos.get(i);
			if(tAux.getIdTorneo()==id){
				t = tAux;
			}
		}
		return t;
	}
	
	public int modificarTorneo(Torneo t){

		int encontrado = 0;

		Torneo tAux = buscarTorneo(t.getIdTorneo()); 
		
		for(int i = 0; i<listaTorneos.size() && encontrado == 0; i++){
			encontrado = listaTorneos.get(i).compareTo(t);
		}
		
		if(encontrado==0){
			tAux.setNombre(t.getNombre());
			tAux.setNumMinimo(t.getNumMinimo());
			tAux.setNumMaximo(t.getNumMaximo());
			tAux.setTipoMesa(t.getTipoMesa());
			tAux.setClasificatoria(t.isClasificatoria());
			tAux.setPremio(t.getPremio());
			tAux.setJugadores(t.getJugadores());
			guardarTorneosEnArchivo();
			encontrado = 1;
		}else{
			encontrado = 0;
		}
		return encontrado;
	}

	public ArrayList<Torneo> getListaTorneos() {
		return listaTorneos;
	}

	public void setListaTorneos(ArrayList<Torneo> listaTorneos) {
		this.listaTorneos = listaTorneos;
	}


}
