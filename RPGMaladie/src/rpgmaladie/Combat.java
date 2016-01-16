
package rpgmaladie;

import java.util.Scanner;

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
        this.numeroTour=0;
        this.tour=new Tour(numeroTour);
        this.personnage=personnage;
        this.maladie=maladie;
        this.estFini=false;
    }
    
    public void TourSuivant(){
        this.numeroTour++;
        this.tour=new Tour(this.numeroTour);
        System.out.println("");
        System.out.println("");
        System.out.println("Tour "+numeroTour);
    } 
    
    public void DeroulementCombat(Personnage personnage, Maladie maladie,ControleurHumain ch,ControleurA ca){
        while (estFini==false){
            nextTour();
            TourSuivant();
            System.out.println("Resume de vos caractéristiques :");
            personnage.afficheCaracteristique();
            System.out.println("");
            System.out.println("Resume des caractéristiques de la maladie :");
            maladie.afficheCaracteristique();
            System.out.println("");
            if (tour.JoueurEstPremier(personnage)){
                System.out.println(personnage.getNomPersonnage()+" joue en premier");
                ch.ChoisirAction().AppliqueEffet(personnage, maladie);
                System.out.println("");
                if (maladie.getSante()<=0){
                    personnageVainqueur();
                } 
                else{
                    ca.genereAttaque(maladie, personnage, ch);
                }
            }
            else{
                System.out.println(maladie.getNomMaladie()+" joue en premier");
                ca.genereAttaque(maladie, personnage, ch);
                System.out.println("");
                if(personnage.getSante()<=0){
                    maladieVainqueur();
                }
                else{
                    ch.ChoisirAction().AppliqueEffet(personnage, maladie);
                }
            }
            if(estFini==false){
                if (maladie.getSante()<=0){
                    personnageVainqueur();
                } 
                else if(personnage.getSante()<=0){
                    maladieVainqueur();
                }
            }
            
            if(ch.getMutationFatale()==true){//cas de la mutation
                this.estFini=true;
                this.joueurVainqueur=false;
            }
        }
    }
    
    public void maladieVainqueur(){
        this.estFini=true;
        this.joueurVainqueur=false;
        System.out.println(maladie.getNomMaladie()+" a gagné le combat contre "+personnage.getNomPersonnage());        
    }
    
        public void personnageVainqueur(){
        this.estFini=true;
        this.joueurVainqueur=true;
        System.out.println(personnage.getNomPersonnage()+" a gagné le combat contre "+maladie.getNomMaladie());      
    }
    
    public boolean getJoueurVainqueur(){
        return joueurVainqueur;
    }
    
    public void nextTour(){
        System.out.println("");
        System.out.println("");
        System.out.println("Appuyer sur ENTRER pour passer au tour suivant");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        System.out.println("");
        System.out.println("");
    }
    
    
    
}
