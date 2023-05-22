package tec;

public class TestMonteeFatigue {
	public static void main(String[] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;
		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}
		int nbrTest = 0;
		System.out.print('.');
		new TestMonteeFatigue().testAssis();
		nbrTest++;
		System.out.print('.');
		new TestMonteeFatigue().testDebout();
		nbrTest++;
		System.out.print('.');
		new TestMonteeFatigue().testPlein();
		nbrTest++;
		System.out.println("(" + nbrTest + "):OK: " + "tec.TestMonteeFatigue");
	}

	public void testAssis() {
		FauxVehicule faux = new FauxVehicule(FauxVehicule.ASSIS);
		MonteeFatigue passager = new MonteeFatigue("passager", 5, ArretNerveux.obtenirInstance());
		passager.choixPlaceMontee(faux);
		assert faux.logs.get(faux.logs.size() - 1).equals("monteeDemanderAssis") : "montee places assise";
	}

	public void testDebout() {
		FauxVehicule faux = new FauxVehicule(FauxVehicule.DEBOUT);
		MonteeFatigue passager = new MonteeFatigue("passager", 5, ArretNerveux.obtenirInstance());
		passager.choixPlaceMontee(faux);
		assert faux.logs.size() == 0 : "montee places debout";
	}

	public void testPlein() {
		FauxVehicule faux = new FauxVehicule(FauxVehicule.PLEIN);
		MonteeFatigue passager = new MonteeFatigue("passager", 5, ArretNerveux.obtenirInstance());
		passager.choixPlaceMontee(faux);
		assert faux.logs.size() == 0 : "montee pas de places";
	}
}
