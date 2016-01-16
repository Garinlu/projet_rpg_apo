/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmaladie;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
/**
 
 * @author Lucas et Alexis
 */
public class RPGMaladie {

    /**
     * @param args the command line arguments
     */
    
    // Tu rentrais pas dans la boucle car tu comparais les adresses et non les valeurs^^
    // Après pas mal de recherche bien casse burne j'ai l'impression que ça fonctionne 
    
    public static void main(String[] args){
        System.out.println("Bonjour, bienvenue sur notre jeu.");
        System.out.println("Veuillez choisir un personnage,");
        System.out.println("vous avez le choix entre Homme et Femme, ils ont des caractéristiques");
        System.out.println("différentes mais un niveau a peu près équivalent!");
        System.out.println("Tapez 1 pour Femme et 2 pour Homme.");
        Scanner sc = new Scanner(System.in);
        String classePerso = sc.nextLine();
        System.out.println("Parfait, maintenant choississez votre nom:");
        String nomPerso = sc.nextLine();
        //je ne comprend pas pourquoi sa ne rentre pas dans la boucle
        if(classePerso.equals("1")){// caracs a modifier!!
            Map<Caracteristique,Integer> caracs = new HashMap<Caracteristique,Integer>() {{
            put(Caracteristique.FORCE, 10);
            put(Caracteristique.DEFENSE,5);
            put(Caracteristique.SANTE,100);
            put(Caracteristique.DEXTERITE,10);
            }};
            Femme personnage= new Femme(nomPerso,caracs,10);
            System.out.println(personnage.getNomPersonnage()+", vous avez choisi d'etre une femme");
            Event event = new Event(personnage);
            event.demarrerPartie(); 
        }    
        else if (classePerso.equals("2")){
            Map<Caracteristique,Integer> caracs = new HashMap<Caracteristique,Integer>() {{
            put(Caracteristique.FORCE, 10);
            put(Caracteristique.DEFENSE,5);
            put(Caracteristique.SANTE,100);
            put(Caracteristique.DEXTERITE,10);
            }};
            Homme personnage= new Homme(nomPerso,caracs,15);
            System.out.println(personnage.getNomPersonnage()+", vous avez choisi d'etre un homme");
            Event event = new Event(personnage);
            event.demarrerPartie();
        }

        }
   
    
            
        }
        
        
        
        
    

