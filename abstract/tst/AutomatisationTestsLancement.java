package tec;
import java.util.*;//pour revork() liste d'exceptions DERNIERE.
import java.lang.*;//optionnelle.(on peut importer un répertoire
//et pas l'utiliser car pas inclus desormais dans le classPATH
//deja vue dans la partie package.

import java.lang.reflect.*;//et voilà la source.
//((pour avoir la reconnaissance de Method par le pseudo-compilateur.))

//package important :
//try catch catch(.. e)
//ce .. concernera la classe:
//java.lang.reflect.Method.
//et globalement(si tout est juste):
//java.lang.InvocationTargetException.///

//a ameliorer SURTOUT!

public class AutomatisationTestsLancement{
    //On prefere celle-ci en premier.
    //PUIS LA METHODE STATIC VOID main(String args[])!!.///


    
static private void lancer(Class<?> c) throws Exception
    {///d'après le sujet throws Exception.
	Method m[]=c.getMethods();//depuis la classe c
	//on recupere les methodes
	//d'après java.lang.reflect.Method;
	int i=0;
	for(Method method : m){//On itere dessus
	    if(method.getName().startsWith("test")){//si la methode demarre
		//avec test..
		System.out.println('.');//le 1er point indiquant la marche premiere en cours du first tst.
		Object test=c.getDeclaredConstructor().newInstance();//on obtient depuis c qui est la classe le constructeur par getDeclaredConstructor et une nouvelle instance pour lancer le test recupere avant(la methode commencant par test.."""") 
		method.invoke(test);
		//On invoque cette methode on l'execute via la classe test
		//de type Object
		//via: method.invoke(test) <=> () via la classe test quia été
		//éventuellement chargée lors de nos exécutions.
		i++;
		//on enumere le nombre de tests de cette classe c
		//effectues.
	    }
	}
	System.out.println("(" + i + "):OK:"+c.getName()+ "\n"  );
    }//comme d'habitude le message final avec un petit retour chariot à la fin.




    
    
    static public void main(String[] args) throws Exception
    {
	boolean estMisAssertion=false;
	assert estMisAssertion=true;
	if(!estMisAssertion){
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	for (String arg : args){
	    //On charge la classe via Class.forName(arg) qui donne
	    //depuis l'argument le byte-code '''' correspondant à la classe test
	    //argument c de la fonction statique en-haut.
	    Class c=Class.forName(arg);
	    lancer(c);
	    //on lance la classe de test chargée via lancer(c)
	    //lancer étant une méthode statique de la classe d'automatisation des tests: LancerTests. 
	}
    }

    
}
