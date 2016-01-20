package rpgmaladie;

import java.util.List;
import java.util.Map;

public class Homme extends Personnage {
 
    private final String nomAttaque1="Coup de Poing";
    private final Caracteristique caracAttaque1= Caracteristique.SANTE;
    private final int valAttaque1=-6;
    private final int probaAttaque1=80;
    
    private final String nomSoin="Chimiothérapie";
    private final Caracteristique caracSoin= Caracteristique.SANTE;
    private final int valSoin=10;
    private final int probaSoin=50;
    
    private final String nomAttaque2="Rage";
    private final Caracteristique caracAttaque2= Caracteristique.SANTE;
    private final int valAttaque2=-10;
    private final int probaAttaque2=50;

    
    public Homme(String nom, Map<Caracteristique, Integer> caracs,int pi) {
        super(nom, caracs,pi);
        this.capacite1 = new Attaque(nomAttaque1,new Effet(caracAttaque1,valAttaque1),probaAttaque1);
        this.capacite2= new Soin(nomSoin, new Effet(caracSoin,valSoin),probaSoin);
        this.capacite3= new Attaque(nomAttaque2,new Effet(caracAttaque2,valAttaque2),probaAttaque2);
        this.defenseMax=10;
        this.santeMax=110;
        this.forceMax=13;
        this.dexteriteMax=8;
        
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