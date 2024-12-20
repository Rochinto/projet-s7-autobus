package tec;

//demande debout ou dehors

//a chaque arret il change.

class TestPassagerIndecis extends TestPassagerAbstrait {
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		return new PassagerIndecis(nom, destination);
	}

	/*
	 * Interaction a la montee
	 * Deux cas
	 * - debout
	 * - pas de place debout
	 */
	public void testInteractionMontee() {
		PassagerIndecis p = new PassagerIndecis("yyy", 5);

		FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}
		// le caractere faussaire de fauxvehicule rend impossible
		// la verification du 2ieme caractere de passagerIndecis.class.

		assert "monteeDemanderDebout" == getLastLog(faux) : "debout";

		faux = new FauxVehicule(FauxVehicule.ASSIS);
		try {
			p.monterDans(faux);
		} catch (Exception e) {
			System.out.println(e);
		}

		assert 0 == faux.logs.size() : "pas de place";
	}

	/*
	 * Interaction a un arret
	 * Cinq cas
	 * 1 numero d'arret < a la destination
	 * 1.1 Place assise vers debout
	 * 1.1.1 place debout
	 * 1.1.2 pas de place debout
	 * 1.2 Place debout vers assise
	 * 1.2.1 place assise
	 * 1.2.2 pas de place assise
	 * 2 numero d'arret >= a la destination
	 */
	public void testInteractionArret() {
		PassagerIndecis p = new PassagerIndecis("yyy", 5);

		FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

		p.changerEnAssis();
		p.nouvelArret(faux, 1);
		assert "arretDemanderDebout" == getLastLog(faux) : "assis vers debout";

		p.changerEnDebout();
		p.nouvelArret(faux, 1);
		assert "arretDemanderAssis" == getLastLog(faux) : "debout vers assis";

		p.changerEnAssis();
		faux = new FauxVehicule(FauxVehicule.ASSIS);
		p.nouvelArret(faux, 1);

		assert faux.logs.size() == 0 : "assis vers debout impossible";

		p.changerEnDebout();
		faux = new FauxVehicule(FauxVehicule.DEBOUT);
		p.nouvelArret(faux, 1);

		assert faux.logs.size() == 0 : "debout vers assis impossible";

		p.nouvelArret(faux, 5);
		assert "arretDemanderSortie" == getLastLog(faux);
	}
}
