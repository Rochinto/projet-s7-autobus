package tec;

/**
 * Prend une place debout même si le véhicule est plein
 */
public class MonteeTetu extends PassagerAbstrait {

	public MonteeTetu(String nom, int destination, ArretComportement c) {
		super(nom, destination, c);
	}

	public void choixPlaceMontee(Vehicule v) {
		v.monteeDemanderDebout(this);
	}
}
