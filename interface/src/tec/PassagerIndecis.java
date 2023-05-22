package tec;

/**
 * Passager ayant les caractères suivants :
 * <ul>
 * <li>MonteeSportif
 * <li>ArretNerveux
 */
public class PassagerIndecis extends MonteeSportif {
	public PassagerIndecis(String nom, int destination) {
		super(nom, destination, new ArretNerveux());
	}
}
