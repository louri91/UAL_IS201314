package org.is.webApp;

public class Torneo {
	private String nombre;
	private static int idTor = 0;
	private int idTorneo;
	private int numMinimo;
	private int numMaximo;
	private String tipoMesa;
	private boolean clasificatoria;
	private String premio;
	private String jugadores;
	
	public Torneo(String nombre, int idTorneo, int numMinimo, int numMaximo,
			String tipoMesa, boolean clasificatoria, String premio,
			String jugadores) {
		super();
		this.nombre = nombre;
		this.idTorneo = idTorneo;
		this.numMinimo = numMinimo;
		this.numMaximo = numMaximo;
		this.tipoMesa = tipoMesa;
		this.clasificatoria = clasificatoria;
		this.premio = premio;
		this.jugadores = jugadores;
	}

	public Torneo(String nombre, int numMinimo, int numMaximo, String tipoMesa,
			boolean clasificatoria, String premio, String jugadores) {
		super();
		this.nombre = nombre;
		this.numMinimo = numMinimo;
		this.numMaximo = numMaximo;
		this.tipoMesa = tipoMesa;
		this.clasificatoria = clasificatoria;
		this.premio = premio;
		this.jugadores = jugadores;
		this.idTorneo = idTor++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumMinimo() {
		return numMinimo;
	}

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public void setNumMinimo(int numMinimo) {
		this.numMinimo = numMinimo;
	}

	public int getNumMaximo() {
		return numMaximo;
	}

	public void setNumMaximo(int numMaximo) {
		this.numMaximo = numMaximo;
	}

	public String getTipoMesa() {
		return tipoMesa;
	}

	public void setTipoMesa(String tipoMesa) {
		this.tipoMesa = tipoMesa;
	}

	public boolean isClasificatoria() {
		return clasificatoria;
	}

	public void setClasificatoria(boolean clasificatoria) {
		this.clasificatoria = clasificatoria;
	}

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}

	public String getJugadores() {
		return jugadores;
	}

	public void setJugadores(String jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Torneo [nombre=" + nombre + ", numMinimo=" + numMinimo
				+ ", numMaximo=" + numMaximo + ", tipoMesa=" + tipoMesa
				+ ", clasificatoria=" + clasificatoria + ", premio=" + premio
				+ ", jugadores=" + jugadores + "]";
	}
	
	
	public int compareTo(Torneo t){
		int igual = 0;
		if(this.nombre.equalsIgnoreCase(t.getNombre()))
			if(this.numMinimo == t.getNumMinimo())
				if(this.numMaximo == t.getNumMaximo())
					if(this.premio.equalsIgnoreCase(t.getPremio()))
						if(this.tipoMesa.equalsIgnoreCase(t.getTipoMesa()))
							if(this.jugadores.equalsIgnoreCase(t.getJugadores()))
								if(this.clasificatoria == t.isClasificatoria())
									igual = 1;
		
		return igual;
					
	}
	
}
