package tec;

/**
 * Se lève si il n'y a plus de place assise
 */
public class ArretPoli implements ArretComportement {
	public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination) {
		if (!v.aPlaceAssise() && v.aPlaceDebout()) {
			v.arretDemanderDebout(p);
		}
	}
}
