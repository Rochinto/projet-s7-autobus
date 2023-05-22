package tec;

public class PassagerIndecis extends MonteeSportif {
	public PassagerIndecis(String nom, int destination) {
		super(nom, destination, ArretNerveux.obtenirInstance());
	}
}
