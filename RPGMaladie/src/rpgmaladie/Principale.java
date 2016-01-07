/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmaladie;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author calvi
 */
class Principale {
    public static void main(String[] args){
        System.out.println("Résumé du jeu ......Veuillez choisir un personnage,/n"
                + "vous avez le choix entre Homme et Femme, ils ont des caracté/n"
                + "ristiques différentes mais un niveau a peu près équivalent!/n"
                + "Tapez 1 pour Femme et 2 pour Homme.");
        Scanner sc = new Scanner(System.in);
        String classePerso = sc.nextLine();
        System.out.println("Parfait, maintenant choississez votre nom:");
        String nomPerso = sc.nextLine();
        
        Map<Caracteristique,Integer> caracs=null;
        
        if(classePerso=="1"){ // caracs a modifier!!
            caracs.put(Caracteristique.FORCE, 10);
            caracs.put(Caracteristique.DEFENSE,10);
            caracs.put(Caracteristique.SANTE,10);
            caracs.put(Caracteristique.DEXTERITE,10);
            Femme personnage= new Femme(nomPerso,caracs,10);
            Event event = new Event(personnage);
           
                
                
            }
        else{
            caracs.put(Caracteristique.FORCE, 10);
            caracs.put(Caracteristique.DEFENSE,10);
            caracs.put(Caracteristique.SANTE,10);
            caracs.put(Caracteristique.DEXTERITE,10);
            Homme personnage= new Homme(nomPerso,caracs,15);
            Event event = new Event(personnage);
        }        
        
    
            
        }
        
        
        
        
    }
    
}
