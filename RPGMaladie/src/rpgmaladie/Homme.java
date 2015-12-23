package rpgmaladie;

import java.util.List;
import java.util.Map;

public class Homme extends Personnage {
    private int poidsMaxHomme;

    public Homme(String nom, Map<Caracteristique, Integer> caracs, int p, List<Item> inventaire, int pi, Arme a) {
        super(nom, caracs,p, inventaire, pi, a);
    }


}