package collecte;

import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Système de collecte utilisant un fichier
 */
public class CollecteFichier implements Collecte {
	private int arret;
	private int entree;
	private int sortie;
	private FileWriter f;

	public CollecteFichier() {
		arret = 0;
		entree = 0;
		sortie = 0;
		try {
			f = new FileWriter("Collecte.txt");
			PrintWriter p = new PrintWriter((Writer) f);
			p.println("Arrêt\tEntrée\tSortie\n");
			p.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void uneEntree() {
		entree = entree + 1;
	}

	public void uneSortie() {
		sortie = sortie + 1;
	}

	public void changerArret() {
		PrintWriter p = new PrintWriter((Writer) f);
		p.println(arret + "\t" + entree + "\t" + sortie + "\n");
		p.flush();
		entree = 0;
		sortie = 0;
		arret = arret + 1;
	}

	public void closeFile() {
		PrintWriter p = new PrintWriter((Writer) f);
		p.println(arret + "\t" + entree + "\t" + sortie + "\n");
		p.flush();
		try {
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
