
package tec;

class ArretPrudent implements ArretComportement {

	private static final ArretPrudent PRUDENT = new ArretPrudent();
	public static ArretPrudent obtenirInstance(){
		return PRUDENT;
	}

	private ArretPrudent(){}

    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if (p.estDebout() && distanceDestination > 5 && v.aPlaceAssise()) {
			v.arretDemanderAssis(p);
		} else if (p.estAssis() && distanceDestination < 3 && v.aPlaceDebout()) {
			v.arretDemanderDebout(p);
		}
    }

}