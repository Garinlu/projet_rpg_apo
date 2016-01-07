/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmaladie;

/**
 *
 * @author calvi
 */
public class Combat {

protected Personnage personnage;
protected Maladie maladie;
protected Tour tour;
    
    
    
    public Combat(Personnage personnage, Maladie maladie){
        this.tour=new Tour(1);
        this.personnage=personnage;
        this.maladie=maladie;    
    }
    
    public void TourSuivant(){
        this.tour=new Tour(2);
    } 
    
    
    
}
