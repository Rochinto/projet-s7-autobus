package tec;

public class PassagerStandard extends MonteeRepos {
    public PassagerStandard(String nom, int destination) {
        super(nom, destination, ArretCalme.obtenirInstance());
    }
}
