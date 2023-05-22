
package tec;

class MonteeSportif extends PassagerAbstrait {
	
    public MonteeSportif(String nom, int destination, ArretComportement comportement){
        super(nom, destination, comportement);
    }

    public void choixPlaceMontee(Vehicule v){
        if (v.aPlaceDebout()) {
            v.monteeDemanderDebout(this);
        }
    }

}
