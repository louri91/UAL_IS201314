package Solitario.Modelo;

import java.io.BufferedReader;

/**
 * La clase <em>Teclado</em> permite la lectura de datos desde la entrada estandar.
 * Es decir trata de hacer transparente la lectura de los tipos
 * mas comunes de datos desde la entrada estandar  (p.e. sin tener que tener en cuenta
 * excepciones ya que son capturadas dentro de la propia clase, y sin tener que introducir
 * las clases de entrada/salida -streams-).
 * @version 2.0
 */
public class Teclado {
	/**
	 * variable de clase asignada a la entrada estandar del sistema
	 */
	public static BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * lee una cadena desde la entrada estandar
	 * @exception excepciones No lanza ningun tipo de excepcion de entrada/salida
	 * @return cadena de tipo String
	 * @throws excepciones No produce ninguna excepcion (comentario java 1.2)
	 */
	public static String leerString() {
		throw new UnsupportedOperationException();
	}

	/**
	 * lee un numero entero desde la entrada estandar
	 * @exception excepciones No lanza ningun tipo de excepcion de entrada/salida
	 * @return numero entero de tipo int
	 */
	public static int leerInt() {
		throw new UnsupportedOperationException();
	}

	/**
	 * lee un numero real (float) desde la entrada estandar
	 * @exception excepciones No lanza ningun tipo de excepcion de entrada/salida
	 * @return numero real de tipo float
	 */
	public static float leerFloat() {
		throw new UnsupportedOperationException();
	}

	/**
	 * lee un numero real (double) desde la entrada estandar
	 * @exception excepciones No lanza ningun tipo de excepcion de entrada/salida
	 * @return numero real de tipo double
	 */
	public static double leerDouble() {
		throw new UnsupportedOperationException();
	}

	/**
	 * lee un caracter desde la entrada estandar. Vease el metodo {@link #leerString() leerString}
	 * @see #leerString()
	 * @exception excepciones No lanza ningun tipo de excepcion de entrada/salida
	 * @return caracter de tipo char
	 */
	public static char leerChar() {
		throw new UnsupportedOperationException();
	}
}