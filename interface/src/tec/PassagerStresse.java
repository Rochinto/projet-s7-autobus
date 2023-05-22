package tec;

/**
 * Passager ayant les caractères suivants :
 * <ul>
 * <li>MonteeFatigue
 * <li>ArretPrudent
 */
public class PassagerStresse extends MonteeFatigue {
	public PassagerStresse(String nom, int destination) {
		super(nom, destination, new ArretPrudent());
	}
}
