package rpgmaladie;

import java.util.List;
import java.util.Map;

public class Femme extends Personnage {
   
    
    private final String nomAttaque="Coup en bas fort";
    private final Caracteristique caracAttaque= Caracteristique.SANTE;
    private final int valAttaque=-5;
    private final int probaAttaque=90;
    
    private final String nomParade="Esquive";
    private final Caracteristique caracParade= Caracteristique.SANTE;
    private final int valParade=-1000;//A mieux gerer après dans Tour
    private final int probaParade=40;
    
    private final String nomSoin1="Recette de grand-mère";
    private final Caracteristique caracSoin1= Caracteristique.SANTE;
    private final int valSoin1=5;
    private final int probaSoin1=80;
    
    private final String nomSoin2="Chimiothérapie";
    private final Caracteristique caracSoin2= Caracteristique.SANTE;
    private final int valSoin2=10;
    private final int probaSoin2=50;
    
    

    public Femme(String nom, Map<Caracteristique, Integer> caracs,int pi) {
        super(nom, caracs,pi);
        Attaque coupBasFort = new Attaque(nomAttaque,new Effet(caracAttaque,valAttaque),probaAttaque);
        Parade esquive= new Parade(nomParade,new Effet(caracParade,valParade),probaParade);
        Soin recetteGrandMere= new Soin(nomSoin1, new Effet(caracSoin1,valSoin1),probaSoin1);
        Soin chimiotherapie= new Soin(nomSoin2, new Effet(caracSoin2,valSoin2),probaSoin2);
        
    }

}