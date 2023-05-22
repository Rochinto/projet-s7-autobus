import tec.Usager;
import tec.Transport;
import tec.Autobus;
import tec.PassagerStandard;
import tec.PassagerIndecis;
import tec.PassagerStresse;

import tec.TecException;
//make 3_comportements__ensemble(avec levee et prise en consideration
//des exceptions NON CONTROLEES).
class Simple {
  static private void deboguerEtat(Transport t, Usager p) {
    System.out.println(p);
    System.out.println(t);
  }

  static public void main(String[] args) throws TecException {
    Transport serenity = new Autobus(2, 2);

    Usager nathan = new PassagerStandard("Nathan", 4);
    Usager guillaume = new PassagerStandard("Guillaume", 6);
    Usager maxime = new PassagerStresse("Maxime", 6);
    Usager martial = new PassagerIndecis("Martial", 5);
    Usager ismail = new PassagerIndecis("Ismail", 5);

    // 0
    System.out.println(serenity);

    serenity.allerArretSuivant();
    // 1
    nathan.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(nathan);

    serenity.allerArretSuivant();
    // 2
    maxime.monterDans(serenity);
    martial.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(nathan);
    System.out.println(maxime);
    System.out.println(martial);

    serenity.allerArretSuivant();
    // 3
    guillaume.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(nathan);
    System.out.println(maxime);
    System.out.println(martial);
    System.out.println(guillaume);

    serenity.allerArretSuivant();
    // 4
    ismail.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(nathan);
    System.out.println(maxime);
    System.out.println(martial);
    System.out.println(guillaume);
    System.out.println(ismail);

    serenity.allerArretSuivant();
    // 5
    System.out.println(serenity);
    System.out.println(maxime);
    System.out.println(martial);
    System.out.println(guillaume);
    System.out.println(ismail);

    serenity.allerArretSuivant();
    // 6
    System.out.println(serenity);
    System.out.println(maxime);
    System.out.println(guillaume);
  }
}
