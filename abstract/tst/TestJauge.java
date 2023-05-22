package tec;
import java.lang.*;

public class TestJauge {
	public static void main(String[] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;
		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}
		int nbrTest = 0;
		TestJauge test = new TestJauge();
		System.out.print('.');
		test.testDansIntervalle();
		nbrTest++;
		System.out.print('.');
		test.testHorsIntervalle();
		nbrTest++;
		System.out.print('.');
		test.testExceptionCasLimite();
		nbrTest++;
		//ajout de tests pour les exceptions.
		test.testNegatif();
		nbrTest++;
		//il faut parfois instancier test à nouveau pour permettre
		//d'utiliser une de ses méthodes 'statiques'.
		System.out.println("(" + nbrTest + "):OK: " + "tec.TestJauge");
	}

	public void testDansIntervalle() {
		Jauge jauge = new Jauge(500, 200);
		assert jauge.estVert() == true : "doit renvoyer vrai";
		assert jauge.estRouge() == false : "doit renvoyer faux";
	}

	public void testHorsIntervalle() {
		Jauge jauge = new Jauge(500, 501);
		assert jauge.estVert() == false : "doit renvoyer faux";
		assert jauge.estRouge() == true : "doit renvoyer vrai";
		jauge.decrementer();
		jauge.decrementer();
		assert jauge.estVert() == true : "doit renvoyer vrai";
		assert jauge.estRouge() == false : "doit renvoyer faux";
		jauge.incrementer();
		assert jauge.estVert() == false : "doit renvoyer faux";
		assert jauge.estRouge() == true : "doit renvoyer vrai";
	}

    public void testNegatif() {//de meme que le suivant
	try{
		Jauge jauge = new Jauge(-10, 10);

		assert false : "pas d'instanciation, scenario incorrect";
		
		assert jauge.estVert() == false : "doit renvoyer faux";
		assert jauge.estRouge() == true : "doit renvoyer vrai";
	}catch(IllegalArgumentException e){
	    return ;
	}
    }

	public void testExceptionCasLimite() {
		Jauge inverse = null;
		try{
			inverse = new Jauge(-42, 10);
			assert false : "Exception non levée";
			//ici pas a la fin sinon erreur
			//car on a la valeur true par defaut
			//et on passe les flags -ea dans make utest.
		}catch(IllegalArgumentException e){

		    //Systeme de reprise après a levée pour éviter la
		    //mise en visuel de l'erreur(il faut lire le code
		    //sinon n'importe qui aurait tendance
		    //a faire un scenario incoherent)
		    
		    //System.out.println(inverse.estVert());
		    //	System.out.println(inverse.estRouge());

		    return;
		}
		
	}
}
