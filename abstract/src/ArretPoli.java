
package tec;

class ArretPoli implements ArretComportement {

    private static final ArretPoli POLI = new ArretPoli();
	public static ArretPoli obtenirInstance(){
		return POLI;
	}

    private ArretPoli(){}

    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if(!v.aPlaceAssise() && v.aPlaceDebout())
            v.arretDemanderDebout(p);
    }

}