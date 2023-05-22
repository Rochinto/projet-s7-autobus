package tec;

import collecte.*;

/**
 * Classe de fabrication d'objets du package tec
 */
public final class FabriqueTec {
	private FabriqueTec() {
	};

	public static Usager fairePassagerStandard(String nom, int destination) {
		return new PassagerStandard(nom, destination);
	};

	public static Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout) {
		return new Autobus(nbPlaceAssise, nbPlaceDebout);
	};

	public static Transport faireGreffonsAUnAutobus(int nbPlaceAssise, int nbPlaceDebout, Collecte col) {
		return new GreffonAUn(new Autobus(nbPlaceAssise, nbPlaceDebout), col);
	};

	public static Transport faireGreffonsEstUnAutobus(int nbPlaceAssise, int nbPlaceDebout, Collecte col) {
		return new GreffonEstUn(nbPlaceAssise, nbPlaceDebout, col);
	};

	public static Usager fairePassagerIndecis(String nom, int destination) {
		return new PassagerIndecis(nom, destination);
	};

	public static Usager fairePassagerStresse(String nom, int destination) {
		return new PassagerStresse(nom, destination);
	}
}
