package rpgmaladie;

import java.util.List;
import java.util.Map;

public class Femme extends Personnage {
    
//j'ai modifier les nom des capacités par des noms qui sont communs avec celles
//de la classe Homme, comme sa on peut gerer facilement leur utilisation en faisant
    //une generalitée.
    
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
        Attaque capacite1 = new Attaque(nomAttaque,new Effet(caracAttaque,valAttaque),probaAttaque);
        Parade capacite2= new Parade(nomParade,new Effet(caracParade,valParade),probaParade);
        Soin capacite3= new Soin(nomSoin1, new Effet(caracSoin1,valSoin1),probaSoin1);
        Soin capacite4= new Soin(nomSoin2, new Effet(caracSoin2,valSoin2),probaSoin2);
        
    }
 


}