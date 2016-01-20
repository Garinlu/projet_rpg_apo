package rpgmaladie;

import java.util.Random;

public class Tour {
    
    public int numeroTour;
    private int proba;
    
    
    public Tour(int tour){
        this.numeroTour=tour;
    }

    public boolean JoueurEstPremier(Personnage perso){//(note de dexterité limitée a 30, donc proba va de 30 à 90)
        //sauf si on a recu des malus.
        proba=perso.getDexterite()*3;//perso a recuperer apres avoir été construit dans Combat(composition)
        int varAlea=(int)(Math.random()*100);
        if (varAlea<proba){
            return false;
        }
        else{
            return true;
        } 
    }
    
    //Tout les getter
    public int getTour(){
        return numeroTour;
    }
}