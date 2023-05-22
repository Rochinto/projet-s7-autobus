package tec;

public class TestArretPrudent {
	public static void main(String[] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;
		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}
		int nbrTest = 0;
		System.out.print('.');
		new TestArretPrudent().testLoin();
		nbrTest++;
		System.out.print('.');
		new TestArretPrudent().testMoyen();
		nbrTest++;
		System.out.print('.');
		new TestArretPrudent().testProche();
		nbrTest++;
		System.out.println("(" + nbrTest + "):OK: " + "tec.TestMonteeFatigue");
	}

	public void testLoin() {
		FauxVehicule fauxV = new FauxVehicule(FauxVehicule.VIDE);
		FauxPassager fauxP = new FauxPassager(FauxPassager.DEBOUT);
		ArretPrudent arret = ArretPrudent.obtenirInstance();
		arret.choixPlaceArret(fauxP, fauxV, 10);
		assert fauxV.logs.get(fauxV.logs.size() - 1).equals("arretDemanderAssis") : "dest-arret > 5";
	}

	public void testMoyen() {
		FauxVehicule fauxV = new FauxVehicule(FauxVehicule.VIDE);
		FauxPassager fauxP = new FauxPassager(FauxPassager.DEBOUT);
		ArretPrudent arret = ArretPrudent.obtenirInstance();
		arret.choixPlaceArret(fauxP, fauxV, 5);
		assert fauxV.logs.size() == 0 : "dest-arret = 5";
	}

	public void testProche() {
		FauxVehicule fauxV = new FauxVehicule(FauxVehicule.VIDE);
		FauxPassager fauxP = new FauxPassager(FauxPassager.DEBOUT);
		ArretPrudent arret = ArretPrudent.obtenirInstance();
		arret.choixPlaceArret(fauxP, fauxV, 3);
		assert fauxV.logs.size() == 0 : "dest-arret < 3";
	}
}
