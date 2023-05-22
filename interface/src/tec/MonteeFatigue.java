package tec;

/**
 * Prend une place assise sinon reste dehors
 */
class MonteeFatigue extends PassagerAbstrait {

	public MonteeFatigue(String nom, int destination, ArretComportement c) {
		super(nom, destination, c);
	}

	public void choixPlaceMontee(Vehicule v) {
		if (v.aPlaceAssise()) {
			v.monteeDemanderAssis(this);
		}
	}
}
