
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
    private boolean estFini;//savoir si le combat est fini
    private boolean joueurVainqueur;
    private int numeroTour;
    
    
    public Combat(Personnage personnage, Maladie maladie){
        numeroTour=1;
        this.tour=new Tour(numeroTour);
        this.personnage=personnage;
        this.maladie=maladie;
        this.estFini=false;
    }
    
    public void TourSuivant(){
        numeroTour++;
        this.tour=new Tour(numeroTour);
    } 
    
    public void DeroulementCombat(Personnage personnage, Maladie maladie,ControleurHumain ch,ControleurA ca){
        while (estFini==false){
            System.out.println("Tour "+numeroTour);
            System.out.println("Resume de vos caractéristiques :");
            personnage.afficheCaracteristique();
            System.out.println("Votre adversaire a "+maladie.getSante()+" points de vie");
            if (tour.JoueurEstPremier(personnage)){
                Capacite capacite=ch.ChoisirAction();
                capacite.AppliqueEffet(personnage, maladie);
                ca.genereAttaque(maladie, personnage, ch);
            }
            else{
                
                ca.genereAttaque(maladie, personnage, ch);
                Capacite capacite=ch.ChoisirAction();
                capacite.AppliqueEffet(personnage, maladie);
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
    public boolean getJoueurVainqueur(){
        return joueurVainqueur;
    }
    
    
    
    
}
