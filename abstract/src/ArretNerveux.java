
package tec;

class ArretNerveux implements ArretComportement {

    private static final ArretNerveux NERVEUX = new ArretNerveux();
	public static ArretNerveux obtenirInstance(){
		return NERVEUX;
	}

    private ArretNerveux(){}

    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if (p.estDebout() && v.aPlaceAssise()) {
            v.arretDemanderAssis(p);
        } else if (p.estAssis() && v.aPlaceDebout()) {
            v.arretDemanderDebout(p);
        }
    }

}