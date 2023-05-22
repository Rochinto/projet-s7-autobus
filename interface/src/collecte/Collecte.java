package collecte;

/**
 * Représente un système de collecte de données
 */
public interface Collecte {

    /**
     * Ajoute une entrée à la collecte
     */
    public void uneEntree();

    /**
     * Ajoute une sortie à la collecte
     */
    public void uneSortie();

    /**
     * Ajoute un nouvel arrêt à la collecte
     */
    public void changerArret();
}
