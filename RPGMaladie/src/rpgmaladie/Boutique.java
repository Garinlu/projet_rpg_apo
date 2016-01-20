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
    
    public Boutique(int niveau){    //Constructeur ajoutant tout les items dans la boutique
        this.catalogue=new ArrayList<>();
        Item arme1 = new Arme("AK-47",1,Caracteristique.FORCE,5,-10,niveau,50);
        Item arme2 = new Arme("Famas",1,Caracteristique.FORCE,10,-15,niveau,100);
        Item arme3 = new Arme("Barett",2,Caracteristique.FORCE,15,-20,niveau,150);
        Item arme4 = new Arme("Colt",2,Caracteristique.FORCE,20,-25,niveau,200);
        Item arme5 = new Arme("Thompson",2,Caracteristique.FORCE,25,-30,niveau,250);
        Item medoc1 = new Medicament("EPO", 1,Caracteristique.SANTE, 20, Caracteristique.DEXTERITE, -1,20);
        Item medoc2 = new Medicament("Doliprane", 1,Caracteristique.SANTE, 50, Caracteristique.DEXTERITE, -1,50);
        Item medoc3 = new Medicament("Ibuprofène", 1,Caracteristique.SANTE, 100, Caracteristique.DEXTERITE, -1,100);
        Item medoc4 = new Medicament("Morphine", 1,Caracteristique.SANTE, 150, Caracteristique.DEXTERITE, -1,150);
        Item medoc5 = new Medicament("Fervex", 1,Caracteristique.SANTE, 200, Caracteristique.DEXTERITE, -1,200);
        catalogue.add(arme1);
        catalogue.add(arme2);
        catalogue.add(arme3);
        catalogue.add(arme4);
        catalogue.add(arme5);
        catalogue.add(medoc1);
        catalogue.add(medoc2);
        catalogue.add(medoc3);
        catalogue.add(medoc4);
        catalogue.add(medoc5);
    }
    
    public void afficherBoutique(){ //Affichage de la boutique
        System.out.println("BOUTIQUE");
        System.out.println("Voici le contenu de la boutique :");
        for (int i=0;i<catalogue.size();i++){
            catalogue.get(i).afficherItemPrix(i);
        }
    }
    
    //tout les getter
    public List<Item> getCatalogue(){
        return catalogue;
    }
}
