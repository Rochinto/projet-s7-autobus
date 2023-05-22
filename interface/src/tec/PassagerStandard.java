package tec;

/**
 * Passager ayant les caractères suivants :
 * <ul>
 * <li>MonteeRepos
 * <li>ArretCalme
 */
public class PassagerStandard extends MonteeRepos {
	public PassagerStandard(String nom, int destination) {
		super(nom, destination, new ArretCalme());
	}
}
