package tec;

/**
 * Change de place à chaque arrêt
 */
public class ArretNerveux implements ArretComportement {
	public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination) {
		if (p.estDebout() && v.aPlaceAssise()) {
			v.arretDemanderAssis(p);
		} else if (p.estAssis() && v.aPlaceDebout()) {
			v.arretDemanderDebout(p);
		}
	}
}
