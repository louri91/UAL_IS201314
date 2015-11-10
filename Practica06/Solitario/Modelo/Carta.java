package Solitario.Modelo;

public class Carta {
	public static final int oros = 0;
	public static final int copas = 1;
	public static final int espadas = 2;
	public static final int bastos = 3;
	private int _numero;
	private int _palo;

	public int numero() {
		throw new UnsupportedOperationException();
	}

	public int palo() {
		throw new UnsupportedOperationException();
	}

	public String stringnum() {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		throw new UnsupportedOperationException();
	}

	public void dibujar() {
		throw new UnsupportedOperationException();
	}

	protected Carta(int aASv, int aARv) {
		throw new UnsupportedOperationException();
	}

	public int numerillo() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Devuelve true si la carta es menor que otra
	 */
	public boolean menor(Carta aAOtra) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Devuelve true si es menor y del mismo palo que otra
	 */
	public boolean menormismopalo(Carta aAOtra) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Devuelve true si es del mismo palo que otra
	 */
	public boolean mismopalo(Carta aAOtra) {
		throw new UnsupportedOperationException();
	}
}