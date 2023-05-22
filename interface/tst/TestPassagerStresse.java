package tec;

import tec.TestPassagerAbstrait;

class TestPassagerStresse extends TestPassagerAbstrait {
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		return new PassagerStresse(nom, destination);
	}

	/*
	 * Interaction a la montee
	 * Trois cas
	 * - des places assises et debout
	 * - pas de place assise
	 * - aucune place.
	 */
	public void testInteractionMontee() {
		PassagerStresse p = new PassagerStresse("yyy", 5);

		FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}

		assert "monteeDemanderAssis" == getLastLog(faux) : "assis";

		faux = new FauxVehicule(FauxVehicule.DEBOUT);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}

		assert 0 == faux.logs.size() : "pas de place assise";

		faux = new FauxVehicule(FauxVehicule.PLEIN);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}

		assert 0 == faux.logs.size() : "pas de place";
	}

	/*
	 * Interaction a un arret
	 * Trois cas
	 * - numero d'arret > 5 arrets avant a la destination
	 * - numero d'arret < 3 a la destination
	 * - numero d'arret = à la destination
	 */
	// TODO Comment tester le changement de position à l'arret
	public void testInteractionArret() {
		PassagerStresse p = new PassagerStresse("yyy", 7);

		FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

		p.changerEnDebout();
		p.nouvelArret(faux, 1);
		assert "arretDemanderAssis" == getLastLog(faux) : "+5 arrets (assis)";

		p.changerEnAssis();
		p.nouvelArret(faux, 5);
		assert "arretDemanderDebout" == getLastLog(faux) : "-3 arrets (debout)";

		p.changerEnDebout();
		p.nouvelArret(faux, 7);
		assert "arretDemanderSortie" == getLastLog(faux) : "destination";
	}
}
