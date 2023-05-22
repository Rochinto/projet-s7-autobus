package tec;

/**
 * Prend une place debout sinon reste dehors
 */
class MonteeSportif extends PassagerAbstrait {

	public MonteeSportif(String nom, int destination, ArretComportement c) {
		super(nom, destination, c);
	}

	public void choixPlaceMontee(Vehicule v) {
		if (v.aPlaceDebout()) {
			v.monteeDemanderDebout(this);
		}
	}
}
