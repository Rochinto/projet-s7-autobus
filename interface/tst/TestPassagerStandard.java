package tec;

class TestPassagerStandard extends TestPassagerAbstrait {
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		return new PassagerStandard(nom, destination);
	}

	/*
	 * Interaction a la montee
	 * Trois cas
	 * - des places assises et debout
	 * - pas de place assise
	 * - aucune place.
	 */
	public void testInteractionMontee() {
		PassagerStandard p = new PassagerStandard("yyy", 5);

		FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}
		;

		assert "monteeDemanderAssis" == getLastLog(faux) : "assis";

		faux = new FauxVehicule(FauxVehicule.DEBOUT);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}
		;

		assert "monteeDemanderDebout" == getLastLog(faux) : "debout";

		faux = new FauxVehicule(FauxVehicule.PLEIN);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}
		;

		assert 0 == faux.logs.size() : "pas de place";
	}

	/*
	 * Interaction a un arret
	 * Deux cas
	 * - numero d'arret < a la destination
	 * - numero d'arret >= a la destination
	 */
	public void testInteractionArret() {
		PassagerStandard p = new PassagerStandard("yyy", 5);

		FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

		p.nouvelArret(faux, 1);
		assert 0 == faux.logs.size() : "pas a destination";

		p.nouvelArret(faux, 5);
		assert "arretDemanderSortie" == getLastLog(faux) : "destination";
	}
}
