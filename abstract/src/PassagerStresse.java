package tec;

public class PassagerStresse extends MonteeFatigue {
    public PassagerStresse(String nom, int destination) {
        super(nom, destination, ArretPrudent.obtenirInstance());
    }
}
