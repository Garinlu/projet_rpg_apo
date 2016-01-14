package rpgmaladie;

import java.util.Random;

public class Tour {
    // lis plus bas
    
    public int numeroTour;
    private int proba;
    
    
    
    public Tour(int tour){
        this.numeroTour=tour;
    }
    
    
    public int getTour(){
        return numeroTour;
        
    }
    public void raz(){
        numeroTour=0;
    }
    
            //On part du principe que la note de dexterité va determiner la proba
        //de commencer.
    public boolean JoueurEstPremier(Personnage perso){//(note de dexte limitée a 30, donc proba va de 30à90)
        //sauf si on a recu des malus.
        proba=perso.getDexterite()*3;//perso a recuperer apres avoir été construit dans Combat( composition)
        int varAlea=(int)(Math.random()*100);
        if (varAlea<proba){
            return false;
        }
        else{
            return true;
        }
         
        }
}