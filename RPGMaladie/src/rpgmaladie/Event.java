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
        this.controleurHumain=controleurHumain;
   
        
    }
    public void demarrerPartie(Personnage perso){
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
        
        while(jeuFini==false){
            ControleurA controleurA= new ControleurA(generate(5),personnage.getNiveau());
            Combat combat = new Combat(personnage,controleurA.getMaladie());
            
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
