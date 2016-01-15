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
    
    private final String nomParade="Kravmaga";
    private final Caracteristique caracParade= Caracteristique.SANTE;
    private final int valParade=-15;
    private final int probaParade=95;

    
    public Homme(String nom, Map<Caracteristique, Integer> caracs,int pi) {
        super(nom, caracs,pi);
        this.capacite1 = new Attaque(nomAttaque1,new Effet(caracAttaque1,valAttaque1),probaAttaque1);
        this.capacite2= new Soin(nomSoin, new Effet(caracSoin,valSoin),probaSoin);
        this.capacite3= new Attaque(nomAttaque2,new Effet(caracAttaque2,valAttaque2),probaAttaque2);
        this.capacite4= new Parade(nomParade,new Effet(caracParade,valParade),probaParade);
        
    }
    
    public void ExplicationActions(){
        System.out.println("Petit rappel de vos attaques");
        System.out.println("1.Coup de Poing(réussite 80%): Potentiel de dégats:"+ (-6*niveau));
        System.out.println("2.Chimiothérapie(réussite 50%): Potentiel de soin de:"+ (+10*niveau));
        System.out.println("3.Rage(réussite 50%): Potentiel de dégats:"+ (-10*niveau));
        System.out.println("4.Attaque au corps a corps: Potentiel de dégats:"+ (armeEquipee.getDegat()+caracs.get(Caracteristique.FORCE))+" avec une reussite de:"+armeEquipee.getProba()+"%");

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