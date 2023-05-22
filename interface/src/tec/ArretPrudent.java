package tec;

/**
 * S'assoit si à plus de 5 arrêts de sa destination,
 * se lève si à moins de 3 arrêts de sa destination
 */
public class ArretPrudent implements ArretComportement {
	public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination) {
		if (p.estDebout() && distanceDestination > 5 && v.aPlaceAssise()) {
			v.arretDemanderAssis(p);
		} else if (p.estAssis() && distanceDestination < 3 && v.aPlaceDebout()) {
			v.arretDemanderDebout(p);
		}
	}
}
