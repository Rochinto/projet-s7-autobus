package tec;

/**
 * Classe d'erreur pour les exceptions du package tec
 */
public class TecException extends Exception {

	/**
	 * Construit une TexException avec un message
	 * 
	 * @param message le message de l'exception
	 */
	public TecException(String message) {
		super(message);
	}

	/**
	 * Construit une TexException avec une cause
	 * 
	 * @param cause la cause de l'exception
	 */
	public TecException(Throwable cause) {
		super(cause);
	}
}
