
package tec;

class MonteeFatigue extends PassagerAbstrait {
	
    public MonteeFatigue(String nom, int destination, ArretComportement comportement){
        super(nom, destination, comportement);
    }

    public void choixPlaceMontee(Vehicule v){
        if (v.aPlaceAssise()) {
            v.monteeDemanderAssis(this);
        }
    }

}
