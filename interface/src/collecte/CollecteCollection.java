package collecte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Système de collecte utilisant une liste de dictionnaires
 */
public class CollecteCollection implements Collecte {

    private List<HashMap<String, Integer>> data;
    private int arret;

    public CollecteCollection() {
        data = new ArrayList<>();
        arret = 0;
        data.add(new HashMap<String, Integer>());
        data.get(arret).put("entrees", 0);
        data.get(arret).put("sorties", 0);
    }

    public void uneEntree() {
        data.get(arret).put("entrees", data.get(arret).get("entrees") + 1);
    }

    public void uneSortie() {
        data.get(arret).put("sorties", data.get(arret).get("sorties") + 1);
    }

    public void changerArret() {
        data.add(new HashMap<String, Integer>());
        arret++;
        data.get(arret).put("entrees", 0);
        data.get(arret).put("sorties", 0);
    }

    @Override
    public String toString() {
        String res = new String();
        int i = 0;
        for (HashMap<String, Integer> hashMap : data) {
            res += "arrêt n°" + i++ + " -> entrées : " + hashMap.get("entrees") + " sorties : " + hashMap.get("sorties")
                    + "\n";
        }
        return res;
    }
}
