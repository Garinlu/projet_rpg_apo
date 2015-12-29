package rpgmaladie;

import java.util.List;
import java.util.Map;

public class Homme extends Personnage {
    
    
    private final String nomAttaque1="Coup de Poing";
    private final Caracteristique caracAttaque1= Caracteristique.SANTE;
    private final int valAttaque1=-6;
    private final int probaAttaque1=80;
    
    private final String nomParade="Kravmaga";
    private final Caracteristique caracParade= Caracteristique.SANTE;
    private final int valParade=-15;
    private final int probaParade=95;
    
    private final String nomSoin="Chimiothérapie";
    private final Caracteristique caracSoin= Caracteristique.SANTE;
    private final int valSoin=10;
    private final int probaSoin=50;
    
    private final String nomAttaque2="Rage";
    private final Caracteristique caracAttaque2= Caracteristique.SANTE;
    private final int valAttaque2=-10;
    private final int probaAttaque2=50;
    
    

    public Homme(String nom, Map<Caracteristique, Integer> caracs,int p, List<Item> inventaire, int pi, Arme a) {
        super(nom, caracs,p, inventaire, pi, a);
        Attaque coupdePoing = new Attaque(nomAttaque1,new Effet(caracAttaque1,valAttaque1),probaAttaque1);
        Parade kravmaga= new Parade(nomParade,new Effet(caracParade,valParade),probaParade);
        Soin chimiotherapie= new Soin(nomSoin, new Effet(caracSoin,valSoin),probaSoin);
        Attaque rage= new Attaque(nomAttaque2,new Effet(caracAttaque2,valAttaque2),probaAttaque2);
        
    }


}