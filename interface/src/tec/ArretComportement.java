package tec;

/**
 * Représente un comportement lors d'un arrêt
 */
interface ArretComportement {

	void choixPlaceArret(Passager p, Vehicule v, int distanceDestination);
}
