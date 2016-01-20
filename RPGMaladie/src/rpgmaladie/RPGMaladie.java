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
        boolean choice=false;
        boolean choice2=false;
        int niveau=0;
        Scanner sc = new Scanner(System.in);        
        String classePerso="";
        while(!choice){
            System.out.println("Tapez 1 pour Femme et 2 pour Homme.");
            classePerso = sc.nextLine();
            if (classePerso.equals("1") || classePerso.equals("2")){choice=true;}
        }
        System.out.println("Parfait, maintenant choississez votre nom:");
        String nomPerso = sc.nextLine();
        System.out.println("Choisissez un niveau de difficultée:");
        System.out.println("1.Debutant");
        System.out.println("2.Facile");
        System.out.println("3.Difficile");
        System.out.println("4.Professionnel");
        Scanner sc2 = new Scanner(System.in);
        String niv;
        while(!choice2){
            System.out.println("Veuillez indiquer votre choix");
            niv = sc2.nextLine();
            if(niv.equals("1")){
                niveau=1;
                choice2=true;
            }
            else if(niv.equals("2")){
                niveau=2;
                choice2=true;
            }
            else if(niv.equals("3")){
                niveau=3;
                choice2=true;
            }
            else if(niv.equals("4")){
                niveau=4;
                choice2=true;
            }
            
            
        }
        
        

        if(classePerso.equals("1")){// caracs a modifier!!
            Map<Caracteristique,Integer> caracs = new HashMap<Caracteristique,Integer>() {{
            put(Caracteristique.FORCE, 10);
            put(Caracteristique.DEFENSE,8);
            put(Caracteristique.SANTE,100);
            put(Caracteristique.DEXTERITE,15);
            }};
            Femme personnage= new Femme(nomPerso,caracs,10);
            System.out.println(personnage.getNomPersonnage()+", vous avez choisi d'etre une femme");
            Event event = new Event(personnage,niveau);
            event.demarrerPartie(); 
        }    
        else if (classePerso.equals("2")){
            Map<Caracteristique,Integer> caracs = new HashMap<Caracteristique,Integer>() {{
            put(Caracteristique.FORCE, 13);
            put(Caracteristique.DEFENSE,10);
            put(Caracteristique.SANTE,110);
            put(Caracteristique.DEXTERITE,8);
            }};
            Homme personnage= new Homme(nomPerso,caracs,15);
            System.out.println(personnage.getNomPersonnage()+", vous avez choisi d'etre un homme");
            Event event = new Event(personnage,niveau);
            event.demarrerPartie();
        }

        }
   
    
            
        }
        
        
        
        
    

