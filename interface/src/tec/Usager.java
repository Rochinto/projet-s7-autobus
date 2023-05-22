package tec;

/**
 * Interface représentant un usager pour le code client
 */
public interface Usager {

	/**
	 * Fait rentrer l'usager dans le transport.
	 * 
	 * @param t
	 * @throws TecException
	 */
	public void monterDans(Transport t) throws TecException;
}
