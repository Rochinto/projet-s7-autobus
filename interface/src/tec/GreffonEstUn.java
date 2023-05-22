package tec;

import collecte.*;

class GreffonEstUn extends Autobus {
	public Collecte collecteur;

	// dans FabriqueTec on va creer un Greffon au lieu d'un Autobus.
	public GreffonEstUn(int nbPlaceAssise, int nbPlaceDebout, Collecte col) {
		super(nbPlaceAssise, nbPlaceDebout);
		collecteur = col;
	}

	@Override
	public void arretDemanderSortie(Passager p) {
		super.arretDemanderSortie(p);
		collecteur.uneSortie();
	}

	@Override
	public void monteeDemanderAssis(Passager p) {
		super.monteeDemanderAssis(p);
		collecteur.uneEntree();
	}

	@Override
	public void monteeDemanderDebout(Passager p) {
		super.monteeDemanderDebout(p);
		collecteur.uneEntree();
	}

	@Override
	public void allerArretSuivant() {
		super.allerArretSuivant();
		collecteur.changerArret();
	}
}
