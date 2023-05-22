package tec;

import collecte.Collecte;

/**
 * Lie les véhicules et les collectes par un lien "a-un"
 */
public class GreffonAUn implements Transport, Vehicule {

	private Vehicule v;
	private Transport t;
	public Collecte c;

	public GreffonAUn(Vehicule v2, Collecte c2) {
		v = v2;
		t = (Transport) v2;
		c = c2;
	}

	@Override
	public void monteeDemanderAssis(Passager p) {
		if (!v.aPlaceAssise())
			return;
		this.envoyerGreffon(p);
		v.monteeDemanderAssis(p);
		c.uneEntree();
	}

	@Override
	public void monteeDemanderDebout(Passager p) {
		if (!v.aPlaceDebout())
			return;
		this.envoyerGreffon(p);
		v.monteeDemanderDebout(p);
		c.uneEntree();
	}

	@Override
	public void arretDemanderSortie(Passager p) {
		v.arretDemanderSortie(p);
		c.uneSortie();
	}

	@Override
	public boolean aPlaceAssise() {
		return v.aPlaceAssise();
	}

	@Override
	public boolean aPlaceDebout() {
		return v.aPlaceDebout();
	}

	@Override
	public void arretDemanderDebout(Passager p) {
		if (!v.aPlaceDebout())
			return;
		v.arretDemanderDebout(p);
	}

	@Override
	public void arretDemanderAssis(Passager p) {
		if (!v.aPlaceAssise())
			return;
		v.arretDemanderAssis(p);
	}

	@Override
	public void allerArretSuivant() {
		c.changerArret();
		t.allerArretSuivant();
	}

	public void envoyerGreffon(Passager p) {
		p.setGreffon(this);
	}

	@Override
	public String toString() {
		return v.toString();
	}

}
