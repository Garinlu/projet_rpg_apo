package rpgmaladie;

import java.util.Scanner;

public class Combat {

    protected Personnage personnage;
    protected Maladie maladie;
    protected Tour tour;
    private int numeroTour;     
    private boolean estFini;    //savoir si le combat est fini
    private boolean joueurVainqueur;    //Variable pour connaitre le vainqueur
    
    
    public Combat(Personnage personnage, Maladie maladie){
        this.numeroTour = 0;
        this.personnage=personnage;
        this.maladie=maladie;
        this.estFini=false;
    }
    
    public void TourSuivant(){  //Création d'un tour ainsi que affichage du tour
        this.numeroTour++;
        this.tour=new Tour(this.numeroTour);
        System.out.println("");
        System.out.println("");
        System.out.println("Tour "+numeroTour);
    } 
    
    public void nextTour(){     //Méthode pour ralentir l'affichage ; attendre que le joueur appuye sur ENTRER pour continuer
        System.out.println("");
        System.out.println("");
        System.out.println("Appuyer sur ENTRER pour continuer");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        System.out.println("");
        System.out.println("");
    }
    
    //Méthode principale ; Contient tout le combat, lie personnage, maladie et leur controleur
    public void DeroulementCombat(Personnage personnage, Maladie maladie,ControleurHumain ch,ControleurA ca){
        while (!estFini){   //Boucle tant que le joueur gagne
            nextTour();
            TourSuivant();
            System.out.println("Resume de vos caractéristiques :");
            personnage.afficheCaracteristique();
            System.out.println("");
            System.out.println("Resume des caractéristiques de la maladie :");
            maladie.afficheCaracteristique();
            System.out.println("");
            if (tour.JoueurEstPremier(personnage)){     //Tester qui joue en premier
                System.out.println(personnage.getNomPersonnage()+" joue en premier");
                ch.ChoisirAction().AppliqueEffet(personnage, maladie);  //Joueur attaque
                System.out.println("");
                if (maladie.getSante()<=0){     //Test de la mort ou non
                    personnageVainqueur();
                } 
                else{
                    ca.genereAttaque(maladie, personnage, ch);  //Maladie attaqe
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
            if(estFini==false){     //Test de la mort
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
                System.out.println("Vous ne pouvez rien y faire, la maladie a muté et vous n'avez pas pu payer de spécialistes..");
            }
        }
    }
    
    public void maladieVainqueur(){     //Test de la mort du joueur
        this.estFini=true;
        this.joueurVainqueur=false;
        System.out.println(maladie.getNomMaladie()+" a gagné le combat contre "+personnage.getNomPersonnage()); 
        nextTour();       
    }
    
    public void personnageVainqueur(){  //Test de la mort de la maladie
        this.estFini=true;
        this.joueurVainqueur=true;
        System.out.println(personnage.getNomPersonnage()+" a gagné le combat contre "+maladie.getNomMaladie());
        nextTour();
    }
    
    //Tout les getter
    public boolean getJoueurVainqueur(){
        return joueurVainqueur;
    }

}
