package tec;

/**
 * Sort si il n'y a plus de place assise ou debout.
 */
public class ArretAgoraphobe implements ArretComportement {
	public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination) {
		if (!(v.aPlaceAssise() || v.aPlaceDebout())) {
			v.arretDemanderSortie(p);
		}
	}
}
