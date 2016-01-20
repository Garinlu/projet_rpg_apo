package rpgmaladie;

import java.util.List;
import java.util.Map;

public class Femme extends Personnage {
    
//j'ai modifier les nom des capacités par des noms qui sont communs avec celles
//de la classe Homme, comme sa on peut gerer facilement leur utilisation en faisant
    //une generalitée.
    
    private final String nomAttaque="Coup en bas fort";
    private final Caracteristique caracAttaque= Caracteristique.SANTE;
    private final int valAttaque=-10;
    private final int probaAttaque=90;
    
    private final String nomSoin1="Recette de grand-mère";
    private final Caracteristique caracSoin1= Caracteristique.SANTE;
    private final int valSoin1=5;
    private final int probaSoin1=80;
    
    private final String nomSoin2="Chimiothérapie";
    private final Caracteristique caracSoin2= Caracteristique.SANTE;
    private final int valSoin2=10;
    private final int probaSoin2=50;
    
    private final String nomParade="Esquive";
    private final Caracteristique caracParade= Caracteristique.SANTE;
    private final int valParade=-1000;//A mieux gerer après dans Tour
    private final int probaParade=40;

    public Femme(String nom, Map<Caracteristique, Integer> caracs,int pi) {
        super(nom, caracs,pi);
        this.capacite1 = new Attaque(nomAttaque,new Effet(caracAttaque,valAttaque),probaAttaque);
        this.capacite2= new Soin(nomSoin1, new Effet(caracSoin1,valSoin1),probaSoin1);
        this.capacite3= new Soin(nomSoin2, new Effet(caracSoin2,valSoin2),probaSoin2);
        this.capacite4= new Parade(nomParade,new Effet(caracParade,valParade),probaParade);
        this.defenseMax=8;
        this.santeMax=100;
        this.forceMax=10;
        this.dexteriteMax=15;
        
    }
    public void ExplicationActions(){
        System.out.println("Petit rappel de vos attaques");
        System.out.println("1 : "+capacite1.getNom()+" (dégats = "+(capacite1.getValeur()-caracs.get(Caracteristique.FORCE))+" ; Probabilité = "+capacite1.getProba()+"%)");
        System.out.println("2 : "+capacite2.getNom()+" (soins = "+(capacite2.getValeur())+" ; Probabilité = "+capacite2.getProba()+"%)");
        System.out.println("3 : "+capacite3.getNom()+" (dégats = "+(capacite3.getValeur()-caracs.get(Caracteristique.FORCE))+" ; Probabilité = "+capacite3.getProba()+"%)");
        System.out.println("4 : "+armeEquipee.getNom()+" (dégats = "+(armeEquipee.getDegat()-caracs.get(Caracteristique.FORCE))+" ; Probabilité = "+armeEquipee.getProba()+"%)");

    }
    public Capacite getCapacite1(){
        return super.getCapacite1();
    }
    public Capacite getCapacite2(){
        return super.getCapacite2();
    }
    public Capacite getCapacite3(){
        return super.getCapacite3();
    }
    public Capacite getCapacite4(){
        return super.getCapacite4();
    }
    public Capacite getCorpsACorps(){
        return super.getCorpsACorps();
    }
}