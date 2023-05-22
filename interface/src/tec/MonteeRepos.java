package tec;

/**
 * Prend une place assise si possible, debout sinon
 */
class MonteeRepos extends PassagerAbstrait {
	public MonteeRepos(String nom, int destination, ArretComportement c) {
		super(nom, destination, c);
	}

	public void choixPlaceMontee(Vehicule v) {
		if (v.aPlaceAssise()) {
			v.monteeDemanderAssis(this);
		} else if (v.aPlaceDebout()) {
			v.monteeDemanderDebout(this);
		}
	}
}
