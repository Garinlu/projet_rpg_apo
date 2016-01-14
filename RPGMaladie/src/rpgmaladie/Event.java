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
    private static int sommeNecessaire=1000;
    private ControleurHumain controleurHumain;
    private boolean jeuFini=false;

    
    public Event(Personnage personnage){
        this.personnage=personnage;
   
        
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
       
        ControleurHumain controleurHumain= new ControleurHumain(personnage);
        
        while(jeuFini==false){
            ControleurA controleurA= new ControleurA("maladie",personnage.getNiveau());
            System.out.println("Votre adversaire a "+controleurA.getMaladie().getSante()+" points de vie");
            Combat combat = new Combat(personnage,controleurA.getMaladie());
            combat.DeroulementCombat(personnage,controleurA.getMaladie(),controleurHumain,controleurA);
            if (combat.getJoueurVainqueur()){
               
                System.out.println("Vous gagnez "+(100+10*personnage.getNiveau())+" euros.");//gain en fonction du niveau
                System.out.println("Voulez vous les garder ou les investir dans Sidaction?");
                if(controleurHumain.investir()){
                    sommeInvestie=sommeInvestie+(100+10*personnage.getNiveau());
                }
                else{
                     personnage.setBourse(100+10*personnage.getNiveau());//ajout du gain a la bourse
                    
                }
                personnage.incrementNiveau();
               // personnage.setDefense(personnage.getDefense()+1);
               // personnage.setSante(personnage.getSante()+3);
               // personnage.setForce(personnage.getForce()+1);
               // personnage.setDexterite(personnage.getDexterite()+1);
                System.out.println("Chacun de vos attributs augmentent de +1 car vous gagnez de l'experience:");
                personnage.afficheCaracteristique();
                System.out.println("Voici votre inventaire:");
                personnage.afficheInventaire();
                
                
                
                
                
                
            }
            
        }
        
    }
    
    public String generate(int length)
{
	    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String pass = "";
	    for(int i=0;i<length;i++)
	    {
	       int x = (int)Math.floor(Math.random() * 26); // Si tu supprimes des lettres tu diminues ce nb
	       pass += chars.charAt(i);
	    }
	    System.out.println(pass);
	    return pass;
}
}
