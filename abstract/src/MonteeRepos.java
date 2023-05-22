
package tec;

class MonteeRepos extends PassagerAbstrait {
	
    public MonteeRepos(String nom, int destination, ArretComportement comportement){
        super(nom, destination, comportement);
    }

    public void choixPlaceMontee(Vehicule v){
        if (v.aPlaceAssise()) {
            v.monteeDemanderAssis(this);
        } else if (v.aPlaceDebout()) {
            v.monteeDemanderDebout(this);
        }
    }

}
