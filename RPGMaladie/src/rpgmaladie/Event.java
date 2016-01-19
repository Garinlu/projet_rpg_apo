/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmaladie;

import java.util.Scanner;


public class Event {

   
    //Faire les evenements entre les parties.
    //Rendre les coups plus aléatoires
    
    
    private Personnage personnage;
    private int sommeInvestie=0;
    private static int sommeNecessaire;
    private ControleurHumain controleurHumain;
    private boolean jeuFini=false;
    Caracteristique carac=Caracteristique.SANTE;
    private int creationMedicament=-1;
    private int creationArme=0;
    private String[] tableauMedicament={"Taloxa", "Tirofiban", "Abufene", "Chlorum", "Calagel", "Calcifluor", "Jaydess","Jevtana","Rabipur","Rinhocort"};
    private String[] tableauArme={"Econome", "Couteau", "Batte de baseball", "Cutter", "Epee", "Katanna", "Lance","Epee enflammée","Nunchaku","Sabre laser"};
    private Boutique boutique;
    
    public Event(Personnage personnage,int niveau){
        this.personnage=personnage;
        this.sommeNecessaire=niveau*300;
        boutique=new Boutique();
        
    }
    public void demarrerPartie(){
        System.out.println("Votre personnage a bien été créer, vous voila infecter par le sida...");
        System.out.println("Vous allez devoir vous battre sans cesse contre de nouvelles maladies infectieuses");
        System.out.println("En effet le virus du Sida a fortement affaiblit votre défense immunitaire");
        System.out.println("vous allez donc rencontre des maladies, normalement begnines pour l'Homme,");
        System.out.println("mais dangereuses pour vous...");
        System.out.println("Votre but est de survivre jusqu'a la fin du jeu et qui sait ...peut etre guerir!");
        System.out.println("Vous possedez un inventaire, dans lequel vous pouvez conserver un poids limité,");
        System.out.println("ainsi qu'une bourse qui pourra vous permettre d'acheter des armes, des medicaments");
        System.out.println("et d'inverstir dans Sidaction.");
        System.out.println("Cela fait seulement quelques jours qu'on vous a diagnostiquer le Sida et vous etes");
        System.out.println("deja faible...voila la premiere difficultée.");
       
        ControleurHumain controleurHumain= new ControleurHumain(personnage,boutique);
        
        while(jeuFini==false){
            ControleurA controleurA= new ControleurA("maladie",personnage.getNiveau());
            Combat combat = new Combat(personnage,controleurA.getMaladie());
            combat.DeroulementCombat(personnage,controleurA.getMaladie(),controleurHumain,controleurA);
            if (combat.getJoueurVainqueur()){
                personnage.incrementNiveau();
                personnage.setDexteriteMax(personnage.getDexteriteMax()+1);
                personnage.setDefenseMax(personnage.getDefenseMax()+1);
                personnage.setForceMax(personnage.getForceMax()+1);
                personnage.setSanteMax(personnage.getSanteMax()+5);
                
                personnage.setDefense(personnage.getDefenseMax());
                //personnage.setSante(personnage.getSanteMax());
                personnage.setForce(personnage.getForceMax());
                personnage.setDexterite(personnage.getDexteriteMax());
                
                System.out.println("Chacun de vos attributs augmentent de +1 car vous gagnez de l'experience:");
                personnage.afficheCaracteristique();
                int alea=(int)(Math.random()*100);// on peut tomber 1 fois sur 2 sur une arme a la fin du combat
                if(alea>10){
                    System.out.println("Vous avez de la chance, vous venez de trouver une arme!");
                    
                    if(alea<65){//Carac de l'arme généré aléatoirement
                        Caracteristique carac=Caracteristique.FORCE;
                    }
                    else if(alea>64 && alea<83){
                        Caracteristique carac=Caracteristique.DEFENSE;
                    }
                    else if(alea>82){
                        Caracteristique carac=Caracteristique.DEXTERITE;
                    }

                    
                    Arme arme =new Arme(genereNomArme(),1, carac, personnage.getNiveau(),-personnage.getNiveau()*5, 100-alea,alea,personnage.getNiveau()*alea);
                    //A completer! La decrire et verifier si le poids correspond! L'equiper?
                    personnage.AjouteInventaire(arme);
                    System.out.println("Voici ces attributs :");
                    arme.afficheInfosArme();
                    System.out.println("Pour info, l'arme que vous utiliser en ce moment est celle-ci:");
                    personnage.getArmeEquipee().afficheInfosArme();
                //}
               // else if(alea>0){//on peut tomber 2 fois sur 3 un medicament.
                    System.out.println("Vous avez de la chance, vous venez de trouver un medicament!");
                    if(alea<34){//Carac de l'arme généré aléatoirement
                        Caracteristique carac=Caracteristique.FORCE;
                    }
                    else if(alea>33 && alea<67){
                        Caracteristique carac=Caracteristique.DEFENSE;
                    }
                    else if(alea>66 && alea<76){
                        Caracteristique carac=Caracteristique.DEXTERITE;
                    }
                    


                    Medicament medicament= new Medicament(genereNomMedicament(),1,Caracteristique.SANTE, personnage.getSanteMax()-personnage.getSante(),carac, -(personnage.getNiveau()+(alea%4)),personnage.getNiveau()*alea);
                    personnage.AjouteInventaire(medicament);
                    medicament.afficheInfosMedicament();
             
                        
                }

                

               
                System.out.println("Vous gagnez "+(100+10*personnage.getNiveau())+" euros.");//gain en fonction du niveau
                System.out.println("Voulez vous les garder ou les investir dans Sidaction?");
                if(controleurHumain.investir()){
                    this.sommeInvestie=this.sommeInvestie+(100+10*personnage.getNiveau());
                    System.out.println("Vous avez investi "+(100+10*personnage.getNiveau())+"€ dans la recherche.");
                }
                else{
                     personnage.setBourse(100+10*personnage.getNiveau());//ajout du gain a la bourse
                    System.out.println("Vous avez récupéré "+(100+10*personnage.getNiveau())+"€ dans votre bourse.");
                }
                System.out.println("Votre bourse : "+personnage.getBourse()+"€");
                System.out.println("Vous avez investi "+this.sommeInvestie+"€ depuis le début.");
                personnage.incrementNiveau();
                personnage.setDexteriteMax(personnage.getDexteriteMax()+1);
                personnage.setDefenseMax(personnage.getDefenseMax()+1);
                personnage.setForceMax(personnage.getForceMax()+1);
                personnage.setSanteMax(personnage.getSanteMax()+5);
                
                personnage.setDefense(personnage.getDefenseMax());
                //personnage.setSante(personnage.getSanteMax());
                personnage.setForce(personnage.getForceMax());
                personnage.setDexterite(personnage.getDexteriteMax());
                
                System.out.println("Chacun de vos attributs augmentent de +1 car vous gagnez de l'experience:");
                personnage.afficheCaracteristique();
                controleurHumain.achatBoutique();
                System.out.println("Voici votre inventaire:");
                personnage.afficheInventaire();
                controleurHumain.choixInventaire();
                
                System.out.println("----------");
                controleurHumain.entreLesCombats();
                       
                

            
            }
            
            else{
                System.out.println("Le SIDA a finalement eu raison de vous comme plus de 40 millions de personnes depuis 1981...");
                System.out.println("Game over.");
                jeuFini=true;
            }
            if(sommeInvestie>=sommeNecessaire){
                System.out.println("Votre investissement dans la recherche contre le Sida, avec celui de millions de personnes, ");
                System.out.println("a permis aux chercheurs de trouver un medicament miracle!");
                System.out.println("Vous etes maintenant sorti d'affaire, bravo! Vous avez gagnez!");
                jeuFini=true;
            }
            
        }
        
    }
    
   public String genereNomMedicament(){
       creationMedicament++;
       if (creationMedicament>9){
           creationMedicament=0;
           return tableauMedicament[creationMedicament];
       }
           else{
       return tableauMedicament[creationMedicament];
       
       
                }


           
       }
       public String genereNomArme(){
       creationArme++;
       if (creationArme>9){
           creationArme=0;
           return tableauArme[creationArme];
       }
           else{
       return tableauArme[creationArme];
       
       
                }


           
       }
       

           
       

   }

