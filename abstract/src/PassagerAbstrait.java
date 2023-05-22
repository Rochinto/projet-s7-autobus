package tec;

//cette classe abstraite a un lien <estUN> avec la classe abstraite
//passager.

abstract public class PassagerAbstrait extends Passager implements Usager {

    private String nom;
    private int destination;
    private Position maPosition;

    final private ArretComportement comportement;

    public PassagerAbstrait(String nom, int destination, ArretComportement comportement) {
        this.nom = nom;
        this.destination = destination;
        this.comportement = comportement;
        this.maPosition = Position.dehors();
    }

    String nom() {
        return nom;
    }

    int destination() {
        return destination;
    }

    boolean estDehors() {
        return maPosition.estDehors();
    }

    boolean estAssis() {
        return maPosition.estAssis();
    }

    boolean estDebout() {
        return maPosition.estDebout();
    }

    void changerEnDehors() {
        maPosition = Position.dehors();
    }

    void changerEnAssis() {
        maPosition = Position.assis();
    }

    void changerEnDebout() {
        maPosition = Position.debout();
    }

    public void monterDans(Transport t) throws TecException {
        Vehicule v = (Vehicule) t;
	if(!(v instanceof Vehicule))
	    throw new TecException("Erreur de conversion au bon typage.");
	try{
	    choixPlaceMontee(v);}
	catch(IllegalStateException e){
	    throw new TecException(e);
	}
    }

    //IllegalStateException e
    //puis appel au 2ieme constructeur
    //soit throw(pas de RETURN!) via->:
    //>
    //    throw new TecException(e)
    //avec e en polymorphisme de type IllegalStateArgument ici.///

    void nouvelArret(Vehicule v, int numeroArret)  {
        if (numeroArret == destination) {
            v.arretDemanderSortie(this);
        }
        comportement.choixPlaceArret(this, v, destination-numeroArret);
    }

    public String toString() {
        return nom + " " + maPosition;
    }

    abstract void choixPlaceMontee(Vehicule v);
}
