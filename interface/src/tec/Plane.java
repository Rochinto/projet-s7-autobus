package tec;
//voir les comments d'avant pour bien comprendre la démarche.
import java.util.ListIterator;
import java.util.List;
import java.util.ArrayList;


//classe a prestige
//classe b standard
//classe c normaux ceux a embarquer en avant dernier
//classe d a l'arriere de l'avion.

//nbWagon c'est le nombre de sous etages dans l'avion c'est comme un train
//mais a l'horizentale.
class Plane implements Transport, Vehicule {
	private ArrayList<Jauge> jaugeAssis;
	private ArrayList<Jauge> jaugeDebout;

	private List<Passager> passagers;
	private ListIterator<Passager> it;

	private int arretCourant;

	public Plane(int nbPlaceAssise, int nbPlaceDebout, int nbWagon) {
		if (nbPlaceAssise < 0 || nbPlaceDebout < 0) {
			throw new IllegalArgumentException("Le tramway ne peut pas avoir un nombre de place négatif");
		}
		if (nbWagon < 0) {
			throw new IllegalArgumentException("Le tramway doit avoir minimum un wagon");
		}
		jaugeAssis = new ArrayList<Jauge>();
		jaugeDebout = new ArrayList<Jauge>();
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



	public boolean aPlaceDebout() {
		for (int i = 0; i < jaugeDebout.size(); i++) {
			if (jaugeDebout.get(i).estVert()) {
				return true;
			}
		}
		return false;
	}



    /*Les 2 méthodes en plus*/
    	private boolean wagonAPlaceAssise(int i) {
		return jaugeAssis.get(i).estVert();
	}
	private boolean wagonAPlaceDebout(int i) {
		return jaugeDebout.get(i).estVert();
	}
    /*les voilà , groupement de transports équivalent.*/

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
