/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmaladie;

import java.util.Map;
import java.util.Scanner;

/**
 
 * @author Lucas et Alexis
 */
public class RPGMaladie {

    /**
     * @param args the command line arguments
     */
    
    // les problemes sont la, je ne comprends pas du tout pourquoi mais je rentre pas dans
    //la boucle de la construction du personnage et de Event... sans doute un probleme de
    //lecture du scanner, regarde le nom de l'erreur 
    
    
    public static void main(String[] args){
        System.out.println("Résumé du jeu ......Veuillez choisir un personnage,/n"
                + "vous avez le choix entre Homme et Femme, ils ont des caracté/n"
                + "ristiques différentes mais un niveau a peu près équivalent!/n"
                + "Tapez 1 pour Femme et 2 pour Homme.");
        Scanner sc = new Scanner(System.in);
        String classePerso = sc.nextLine();
        System.out.println("Parfait, maintenant choississez votre nom:");
        
        String nomPerso = sc.nextLine();
        
        System.out.println(classePerso+nomPerso);
        Map<Caracteristique,Integer> caracs=null;
        
        
        
        
        //je ne comprend pas pourquoi sa ne rentre pas dans la boucle
        if(classePerso=="1"){// caracs a modifier!!
            System.out.println("Vous avez choisi d'etre une femme");//test
            caracs.put(Caracteristique.FORCE, 10);
            caracs.put(Caracteristique.DEFENSE,10);
            caracs.put(Caracteristique.SANTE,10);
            caracs.put(Caracteristique.DEXTERITE,10);
            Femme personnage= new Femme(nomPerso,caracs,10);
            Event event = new Event(personnage);
            event.demarrerPartie(personnage); 
        }    
        else if (classePerso=="2"){
            caracs.put(Caracteristique.FORCE, 10);
            caracs.put(Caracteristique.DEFENSE,10);
            caracs.put(Caracteristique.SANTE,10);
            caracs.put(Caracteristique.DEXTERITE,10);
            Homme personnage= new Homme(nomPerso,caracs,15);
            Event event = new Event(personnage);
            event.demarrerPartie(personnage);
        }

        }
   
    
            
        }
        
        
        
        
    

