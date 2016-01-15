package rpgmaladie;

import java.util.Scanner;



public class ControleurHumain extends Controleur {
    private Personnage perso;
    private Capacite prochaineAttaque;
    
    //On appelera cette classe pour tout les scanner normalement. j'ai fait la classe payer(prix) qui se charge
    //juste de verifier et de mettre a jour la bourse (l'ajout a l'inventaire sera gerer dans Event). PayementObligatoire()
    //c'est pour le cas de la mutation. et puis choisir action permet de demander au joueur la prochaine action( en modifiant
    //l'attribut prochaineAttaque, une capacite)
    
    public ControleurHumain(Personnage perso){
        this.perso=perso;
    }
    
   
    
    
    public void Payer(int prix){
        System.out.println("Vous souhaitez acheter cet item, la banque controle si vous avez les fonds necessaires");
        if(prix<perso.getBourse()){
            
            perso.setBourse(perso.getBourse()-prix);
            System.out.println("Achat efectué, désormais il a "+perso.getBourse()+"e sur votre compte personnel");
        }
        else{
            System.out.println("Vous n'avez pas les fonds pour cet objet, désolé");
        }
        
      
    }
    public void PayementObligatoire(int prix,Maladie maladie){
        System.out.println("Vous etes obligé de payer un spécialiste car la maladie a muté. ");
         if(prix<perso.getBourse()){
            maladie.setMute(false);
            perso.setBourse(perso.getBourse()-prix);
            System.out.println("L'équipe scientifique compétente a trouvé le nouveau génome,vous pouvez de nouveau combatre la maladie");
            System.out.println("Désormais il a "+perso.getBourse()+"e sur votre compte personnel");
        }
        else{
            System.out.println("Vous n'avez pas les fonds pour cet objet, désolé");
        }
    }
    
    public Capacite ChoisirAction(){
        System.out.println("");
        System.out.println("");
        System.out.println("Quelle action voulez vous réaliser pour ce tour? ");
        perso.ExplicationActions();
        System.out.println("Indiquez votre choix(entre 1 et 4), si vous vous trompez vous realiserez la meme attaque qu'au tour précédent.");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        Capacite capacite;
        if (choix.equals("1")){
            return perso.getCapacite1();
        }
        if (choix.equals("2")){
            return perso.getCapacite2();
        }
        if (choix.equals("3")){
            return perso.getCapacite3();
        }
        else {
            return perso.getCorpsACorps();
        } 
 
        
    }
    
    public Capacite getProchaineAttaque(){
        return prochaineAttaque;
    }
    
    public boolean investir(){
        System.out.println("Voulez vous investir ? Oui : 1 / Non : tout sauf 1");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        return choix.equals("1");
    }
}