package tec;

/**
 * Comportement particulier 
 */


public class ArretNormal implements ArretComportement {

    private static final ArretNormal NORMAL = new ArretNormal();
    public static ArretNormal obtenirInstance(){
	return NORMAL;
    }
    
    private ArretNormal(){}

    /*public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination) {
	}
    */

    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){

	if(p.estAssis() && !v.aPlaceDebout() && distanceDestination <= 1)
	    v.arretDemanderSortie(p);
	
    }

    //ne fait rien de particulier au changement d'arret sauf s'arrete une destination avant si il y a pas de place debout.(il est assis, sa destination se rapproche, si pas de place debout ; il sort)
    
}
