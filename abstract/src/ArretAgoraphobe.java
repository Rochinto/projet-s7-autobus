
package tec;

class ArretAgoraphobe implements ArretComportement {

    private static final ArretAgoraphobe AGORAPHOBE = new ArretAgoraphobe();
	public static ArretAgoraphobe obtenirInstance(){
		return AGORAPHOBE;
	}

    private ArretAgoraphobe(){}

    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if(!v.aPlaceDebout() || !v.aPlaceAssise())
            v.arretDemanderSortie(p);
    }

}