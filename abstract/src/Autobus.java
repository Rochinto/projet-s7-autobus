package tec;

import java.util.*;
import java.lang.*;//si utile.

/*
import java.util.ArrayList;
import java.util.ListIterator;//classe qui étend Iterator.
import java.util.List;
*/


public class Autobus extends Vehicule implements Transport {
	
	private Jauge jaugeAssis;
	private Jauge jaugeDebout;

    //private Passager[] passagers;
    private List<Passager> passagers;
	// private int nbPassagers;

	private int arretCourant;

    private ListIterator<Passager> it;

	public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
	    //lever une exception non controlee
	    //sur soit l'un des deux <0.
	    if(nbPlaceAssise <0 || nbPlaceDebout<0){
		throw new IllegalStateException("Scenario Incorrect, au moins une place debout ou assise dans un Transport donné");
	    }

	    
		jaugeAssis = new Jauge(nbPlaceAssise, 0);
		jaugeDebout = new Jauge(nbPlaceDebout, 0);
		arretCourant = 0;
		//	passagers = new Passager[nbPlaceAssise + nbPlaceDebout];

		passagers=new ArrayList<>();
		it=passagers.listIterator();
	}

	private void enleverPassager(Passager p) {
	    it=passagers.listIterator();//important d'initialiser (recuperation)
	    //sinon un des tests ne marchent plus!!
	    ListIterator<Passager> it2=it;
	    while(it2.hasNext()){
		Passager q=it2.next();
		if(q.equals(p)){
		    it2.remove();
		    it=passagers.listIterator();
		}
	    }
	}

	private void ajouterPassager(Passager p) {
	    passagers.add(p);
	}

	public void allerArretSuivant() {
	    arretCourant++;
	    it=passagers.listIterator();
	    while(it.hasNext()){
		Passager p=it.next();
		p.nouvelArret(this,arretCourant);
		    }
	}

    //les 3 premieres a modifier; a chaque iteration, il faut récupérer la valeur
    //courante de it si pas d'itération, place a .add(Passager p) direct comme
    //la 3ieme. 
	boolean aPlaceAssise() {
		return jaugeAssis.estVert();
	}

	boolean aPlaceDebout() {
		return jaugeDebout.estVert();
	}

	void arretDemanderAssis(Passager p) {
		jaugeDebout.decrementer();
		jaugeAssis.incrementer();
		p.changerEnAssis();
	}

	void arretDemanderDebout(Passager p) {
		jaugeAssis.decrementer();
		jaugeDebout.incrementer();
		p.changerEnDebout();
	}

	void arretDemanderSortie(Passager p) {
		if (p.estAssis()) {
			jaugeAssis.decrementer();
		} else {
			jaugeDebout.decrementer();
		}
		p.changerEnDehors();
		this.enleverPassager(p);
	}
    
    //avec la levee de la premiere exception non controlee.
    //c'est ici d'ou vient l'idee de faire les arraylist d'ou les list
    //par polymorphisme et les parcours de sequences attribuees
    //pour les methodes: enelverPassager() car(*).


    
    //Les 2 monterDemander*() a modifier.
    void monteeDemanderAssis(Passager p) {
	    int i=0;
	    while(i<passagers.size()){
		if(p==passagers.get(i)){
		    throw new IllegalStateException("L'usager est déjà dans le transport.");
		}
		i++;
	    }

	    //iteration soit parcours sur un type ArrayList possible
	    //sans meler l'it a cela(il faut gerer sa recuperation au
	    //parcours --debut puis le reaffecter a passagers.listIterator
	    //si il y a eu remove(voir la methode enlever Passager POUR CELA.

	    
		jaugeAssis.incrementer();
		p.changerEnAssis();
		this.ajouterPassager(p);
	}
    //(*):Vous ne pouvez pas supprimer un objet par ArrayList pendant que vous itérez.(Important ! )
    //avec la levee de la deuxieme exception non controlee.
	void monteeDemanderDebout(Passager p) {
int i=0;
	    while(i<passagers.size()){
		if(p==passagers.get(i)){
		    throw new IllegalStateException("L'usager est déjà dans le transport.");
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
