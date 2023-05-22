package tec;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

class Autobus implements Transport, Vehicule {
	private Jauge jaugeAssis;
	private Jauge jaugeDebout;

	private List<Passager> passagers;
	private ListIterator<Passager> it;

	private int arretCourant;

	public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
		if (nbPlaceAssise < 0 || nbPlaceDebout < 0) {
			throw new IllegalArgumentException("L'autobus ne peut pas avoir un nombre de place négatif");
		}
		jaugeAssis = new Jauge(nbPlaceAssise, 0);
		jaugeDebout = new Jauge(nbPlaceDebout, 0);
		arretCourant = 0;
		passagers = new ArrayList<>();
		it = passagers.listIterator();
	}

	private void enleverPassager(Passager p) {
		it = passagers.listIterator();
		ListIterator<Passager> it2 = it;
		while (it2.hasNext()) {
			Passager q = it2.next();
			if (q.equals(p)) {
				it2.remove();
				it = passagers.listIterator();
			}
		}

	}

	private void ajouterPassager(Passager p) {
		passagers.add(p);
	}

	public void allerArretSuivant() {
		arretCourant++;
		it = passagers.listIterator();
		while (it.hasNext()) {
			Passager p = it.next();
			p.nouvelArret(this, arretCourant);
		}
	}

	public boolean aPlaceAssise() {
		return jaugeAssis.estVert();
	}

	public boolean aPlaceDebout() {
		return jaugeDebout.estVert();
	}

	public void arretDemanderAssis(Passager p) {
		jaugeDebout.decrementer();
		jaugeAssis.incrementer();
		p.changerEnAssis();
	}

	public void arretDemanderDebout(Passager p) {
		jaugeAssis.decrementer();
		jaugeDebout.incrementer();
		p.changerEnDebout();
	}

	public void arretDemanderSortie(Passager p) {
		if (p.estAssis()) {
			jaugeAssis.decrementer();
		} else {
			jaugeDebout.decrementer();
		}
		p.changerEnDehors();
		this.enleverPassager(p);
	}

	public void monteeDemanderAssis(Passager p) {
		int i = 0;
		while (i < passagers.size()) {
			if (p == passagers.get(i)) {
				throw new IllegalStateException("L'usager est déjà dans l'autobus");
			}
			i++;
		}
		jaugeAssis.incrementer();
		p.changerEnAssis();
		this.ajouterPassager(p);
	}

	public void monteeDemanderDebout(Passager p) {
		int i = 0;
		while (i < passagers.size()) {
			if (p == passagers.get(i)) {
				throw new IllegalStateException("L'usager est déjà dans l'autobus");
			}
			i++;
		}
		jaugeDebout.incrementer();
		p.changerEnDebout();
		this.ajouterPassager(p);
	}

	@Override
	public String toString() {
		String res = "[arret " + arretCourant + "] " + "assis" + jaugeAssis + " debout" + jaugeDebout;
		return res;
	}
}
