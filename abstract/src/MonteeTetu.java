
package tec;

class MonteeTetu extends PassagerAbstrait {
	
    public MonteeTetu(String nom, int destination, ArretComportement comportement){
        super(nom, destination, comportement);
    }

    public void choixPlaceMontee(Vehicule v){
        v.monteeDemanderDebout(this);
    }

}
