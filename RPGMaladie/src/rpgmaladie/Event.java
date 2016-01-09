/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmaladie;


public class Event {
    //le jeu sera lancer grace a demarrerPartie et tout se deroulera a partir de cette methode.
   
    
    
    private Personnage personnage;
    private int sommeInvestie=0;
    private ControleurHumain controleurHumain;
    
    
    
    public Event(Personnage personnage){
        this.personnage=personnage;
        this.controleurHumain=controleurHumain;
        
    }
    public void demarrerPartie(Personnage perso){
        System.out.println("Votre personnage a bien été créer, vous voila infecter par le sida.");
        System.out.println("Vous allez devoir vous battre sans cesse contre de nouvelle maladies");
        System.out.println("infectieuses en esperant survivre jusqu'a la fin du jeu...Bonne chance");
        
        
    }
    
    
}
