
package rpgmaladie;

public class Combat {

// la j'ai ajouter le booleen est fini pour savoir si le combat est fini.     
//dans DeroulementCombat()( la methode qu'on appelera dans la classe Event et qui
//se chargera de tout le combat, j'ai fait une boucle while qui s'arrete lorsque
//quelqu'un est mort(dans ce cas estFini passera a true).
//DeroulementCombat() communique avec ControleurHumain et ControleurA.
    protected Personnage personnage;
    protected Maladie maladie;
    protected Tour tour;
    private boolean estFini=false;//savoir si le combat est fini
    private boolean joueurVainqueur;

    
    
    public Combat(Personnage personnage, Maladie maladie){
        this.tour=new Tour(1);
        this.personnage=personnage;
        this.maladie=maladie;    
    }
    
    public void TourSuivant(){
        this.tour=new Tour(2);
    } 
    
    public void DeroulementCombat(Personnage personnage, Maladie maladie,ControleurHumain ch,ControleurA ca){
        while (estFini=false){
            System.out.println("Resume du jeu:");
            personnage.afficheCaracteristique();
            System.out.println("Votre adversaire a "+maladie.getSante()+" points de vie");
            if (tour.JoueurEstPremier(personnage)){
                ch.ChoisirAction();
                
            }
            TourSuivant();
            if (maladie.getSante()<0){
                estFini=true;
                joueurVainqueur=true;
            } 
            if(personnage.getSante()<0){
                estFini=true;
                joueurVainqueur=false;
            }
        }
    }
    
    
    
    
}
