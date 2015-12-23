package rpgmaladie;

import java.util.List;
import java.util.Map;

public class Femme extends Personnage {
    private int poidsMaxFemme=7;

    public Femme(String nom, Map<Caracteristique, Integer> caracs, int p, List<Item> inventaire, int pi, Arme a) {
        super(nom, caracs,p, inventaire, pi, a);
        
    }
 
}