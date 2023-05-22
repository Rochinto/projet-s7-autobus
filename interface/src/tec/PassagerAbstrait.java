package tec;

/**
 * Représente un passager ayant un certain comportement
 */
abstract class PassagerAbstrait implements Passager, Usager {

	private String nom;
	private int destination;
	private Position maPosition;
	private ArretComportement comportement;
	private GreffonAUn greffon;

	/**
	 * Construit un passager nommé nom, avec une destination >= 0,
	 * et un comportement à l'arrêt c
	 * 
	 * @param nom         le nom du passager
	 * @param destination la destination du passager
	 * @param c           le comportement à l'arrêt
	 */
	public PassagerAbstrait(String nom, int destination, ArretComportement c) {
		if (destination < 0) {
			throw new IllegalArgumentException("La destination d'un passager ne peut pas être négative");
		}
		this.nom = nom;
		this.destination = destination;
		this.maPosition = Position.dehors();
		this.comportement = c;
	}

	public void setGreffon(GreffonAUn g) {
		this.greffon = g;
	}

	public String nom() {
		return nom;
	}

	public int destination() {
		return destination;
	}

	public boolean estDehors() {
		return maPosition.estDehors();
	}

	public boolean estAssis() {
		return maPosition.estAssis();
	}

	public boolean estDebout() {
		return maPosition.estDebout();
	}

	public void changerEnDehors() {
		maPosition = Position.dehors();
	}

	public void changerEnAssis() {
		maPosition = Position.assis();
	}

	public void changerEnDebout() {
		maPosition = Position.debout();
	}

	public void monterDans(Transport t) throws TecException {
		Vehicule v = (Vehicule) t;
		if (!(v instanceof Vehicule))
			throw new TecException("Le transport n'a pas pu être converti en véhicule");
		try {
			choixPlaceMontee(v);
		} catch (IllegalStateException e) {
			throw new TecException(e);
		}
	}

	public void nouvelArret(Vehicule v, int numeroArret) {
		if (numeroArret == destination) {
			if (this.greffon != null) {
				greffon.arretDemanderSortie(this);
			} else {
				v.arretDemanderSortie(this);
			}
		}
		comportement.choixPlaceArret(this, v, destination - numeroArret);
	}

	public String toString() {
		return nom + " " + maPosition;
	}

	abstract public void choixPlaceMontee(Vehicule v);
}
