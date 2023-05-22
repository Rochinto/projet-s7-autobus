import tec.Usager;
import tec.Transport;
import tec.FabriqueTec;
import tec.TecException;
import collecte.*;

class SimpleCollecteAUn {
	static private void deboguerEtat(Transport t, Usager p) {
		System.out.println(p);
		System.out.println(t);
	}

	static public void main(String[] args) throws TecException {
		Collecte col = new CollecteCollection();
		Transport serenity = FabriqueTec.faireGreffonsAUnAutobus(1, 2, col);

		Usager kaylee = FabriqueTec.fairePassagerStandard("Kaylee", 4);
		Usager jayne = FabriqueTec.fairePassagerStandard("Jayne", 4);
		Usager inara = FabriqueTec.fairePassagerStandard("Inara", 5);

		// 0
		System.out.println(serenity);
		System.out.println(serenity);
		System.out.println(kaylee);
		System.out.println(jayne);
		System.out.println(inara);

		serenity.allerArretSuivant();
		// 1
		kaylee.monterDans(serenity);
		inara.monterDans(serenity);

		System.out.println(serenity);
		System.out.println(kaylee);
		System.out.println(jayne);
		System.out.println(inara);

		serenity.allerArretSuivant();
		// 2

		jayne.monterDans(serenity);

		System.out.println(serenity);
		System.out.println(kaylee);
		System.out.println(jayne);
		System.out.println(inara);

		serenity.allerArretSuivant();
		// 3

		System.out.println(serenity);
		System.out.println(kaylee);
		System.out.println(jayne);
		System.out.println(inara);

		serenity.allerArretSuivant();
		// 4
		System.out.println(serenity);
		System.out.println(kaylee);
		System.out.println(jayne);
		System.out.println(inara);

		serenity.allerArretSuivant();
		// 5
		System.out.println(serenity);
		System.out.println(kaylee);
		System.out.println(jayne);
		System.out.println(inara);

		System.out.println(col);
	}
}
