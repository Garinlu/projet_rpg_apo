/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmaladie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Boutique {
    private List<Item> catalogue;
    
    public Boutique(int niveau){
        this.catalogue=new ArrayList<>();
        Item arme1 = new Arme("AK-47",2,Caracteristique.FORCE,10,-15,niveau,100);
        Item arme2 = new Arme("Famas",2,Caracteristique.FORCE,15,-20,niveau,200);
        catalogue.add(arme1);
        catalogue.add(arme2);
    }
    
    public void afficherBoutique(){
        System.out.println("BOUTIQUE");
        System.out.println("Voici le contenu de la boutique :");
        for (int i=0;i<catalogue.size();i++){
            catalogue.get(i).afficherItemPrix(i);
        }
    }
    
    public List<Item> getCatalogue(){
        return catalogue;
    }
}
