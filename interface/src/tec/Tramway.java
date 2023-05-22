package tec;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.util.LinkedList;

class Tramway implements Transport, Vehicule {
	private LinkedList<Jauge> jaugeAssis;
	private LinkedList<Jauge> jaugeDebout;

	private List<Passager> passagers;
	private ListIterator<Passager> it;

	private int arretCourant;

	public Tramway(int nbPlaceAssise, int nbPlaceDebout, int nbWagon) {
		if (nbPlaceAssise < 0 || nbPlaceDebout < 0) {
			throw new IllegalArgumentException("Le tramway ne peut pas avoir un nombre de place négatif");
		}
		if (nbWagon < 0) {
			throw new IllegalArgumentException("Le tramway doit avoir minimum un wagon");
		}
		jaugeAssis = new LinkedList<Jauge>();
		jaugeDebout = new LinkedList<Jauge>();
		for (int i = 0; i < nbWagon; i++) {
			jaugeAssis.add(new Jauge(nbPlaceAssise / nbWagon, 0));
			jaugeDebout.add(new Jauge(nbPlaceDebout / nbWagon, 0));
		}
		arretCourant = 0;
		passagers = new ArrayList<>();
		it = passagers.listIterator();
	}

	private void enleverPassager(Passager p) {
		it = passagers.listIterator();
		while (it.hasNext()) {
			Passager q = it.next();
			if (q.equals(p)) {
				it.remove();
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
		int i = 0;
		for (i = 0; i < jaugeAssis.size(); i++) {
			if (jaugeAssis.get(i).estVert()) {
				return true;
			}
		}
		return false;
	}

	private boolean wagonAPlaceAssise(int i) {
		return jaugeAssis.get(i).estVert();
	}

	public boolean aPlaceDebout() {
		for (int i = 0; i < jaugeDebout.size(); i++) {
			if (jaugeDebout.get(i).estVert()) {
				return true;
			}
		}
		return false;
	}

	private boolean wagonAPlaceDebout(int i) {
		return jaugeDebout.get(i).estVert();
	}

	public void arretDemanderAssis(Passager p) {
		for (int i = 0; i < jaugeAssis.size(); i++) {
			if (wagonAPlaceAssise(i)) {
				jaugeDebout.get(i).decrementer();
				jaugeAssis.get(i).incrementer();
				p.changerEnAssis();
			}
		}
	}

	public void arretDemanderDebout(Passager p) {
		for (int i = 0; i < jaugeDebout.size(); i++) {
			if (wagonAPlaceDebout(i)) {
				jaugeAssis.get(i).decrementer();
				jaugeDebout.get(i).incrementer();
				p.changerEnDebout();
			}
		}
	}

	public void arretDemanderSortie(Passager p) {
		if (p.estAssis()) {
			for (int i = 0; i < jaugeAssis.size(); i++) {
				if (wagonAPlaceAssise(i)) {
					jaugeAssis.get(i).decrementer();
				}
			}
		} else {

			for (int i = 0; i < jaugeDebout.size(); i++) {
				if (wagonAPlaceDebout(i)) {
					jaugeDebout.get(i).decrementer();
				}
			}
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

		for (i = 0; i < jaugeAssis.size(); i++) {
			if (wagonAPlaceAssise(i)) {
				jaugeAssis.get(i).incrementer();
			}
		}
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
		for (i = 0; i < jaugeDebout.size(); i++) {
			if (wagonAPlaceDebout(i)) {
				jaugeDebout.get(i).incrementer();
			}
		}
		p.changerEnDebout();
		this.ajouterPassager(p);
	}

	@Override
	public String toString() {
		String res = "[arret " + arretCourant + "] " + "assis" + jaugeAssis + " debout" + jaugeDebout;
		return res;
	}
}
