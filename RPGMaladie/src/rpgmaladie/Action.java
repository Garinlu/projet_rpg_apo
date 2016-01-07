package rpgmaladie;

import java.util.Random;

public class Action {
        
	private Personnage cible;
	private Maladie maladie;
        private Attaque attaque;
        private int proba;
        Random commence=new Random();//proba pour savoir qui commence
        Random reussitePerso=new Random();//proba pour la proba du coup du perso
        Random reussiteMaladie=new Random();//proba pour la proba du coup de la maladie
        
        
        public Action(Attaque attaque, Personnage cible, Maladie maladie){
 
            this.cible=cible;
            this.maladie=maladie;
            this.attaque=attaque;

        }
        
        //On part du principe que la note de dexterité va determiner la proba
        //de commencer.
        public void agir(){
            proba= cible.getDexterite()*3;//(note de dexte limitée a 30, donc proba va de 30à90)
            //sauf si on a recu des malus.
            

            
            
                
            }
            
            
            
                
            
        }
        
        

}