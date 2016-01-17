package rpgmaladie;

import java.util.Scanner;



public class ControleurHumain extends Controleur {
    private Personnage perso;
    private Capacite prochaineAttaque;
    private boolean mutationFatale=false;
    //On appelera cette classe pour tout les scanner normalement. j'ai fait la classe payer(prix) qui se charge
    //juste de verifier et de mettre a jour la bourse (l'ajout a l'inventaire sera gerer dans Event). PayementObligatoire()
    //c'est pour le cas de la mutation. et puis choisir action permet de demander au joueur la prochaine action( en modifiant
    //l'attribut prochaineAttaque, une capacite)
    
    public ControleurHumain(Personnage perso){
        this.perso=perso;
        
    }
    
   
    public void jetezUnItem(Item item){
        System.out.println("Votre inventaire est deja plein, voulez vous jetez un item pour recuperer celui la? '1 pour oui et 2 pour non)");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        if (choix.equals("1")){
            perso.afficheInventaire();
            System.out.println("Quel objet souhaitez-vous abandonner?");
            Scanner s = new Scanner(System.in);
            String c = sc.nextLine();
            int i=Integer.parseInt(c);
            
        }
        if (choix.equals("2")){
            System.out.println("Vous laissez cet item par terre.");

        }
        
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
            mutationFatale=true;
            
        }
    }
    
    public boolean getMutationFatale(){
        return mutationFatale;
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
    
    public void prendreMedicament(Medicament medicament){
        System.out.println("Voulez vous avaler ce medicament pour remonter votre sante?");
        System.out.println("Mais attention, il aura peut etre des effets secondaires!(Tapez 1 pour acceptez et 2 pour refuser");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        if (choix.equals("1")){
            perso.prendMedicament(medicament);
        }

    }
    
    public void choisirArme(Arme arme){
        System.out.println("Tapez 1 pour equipé la nouvelle et autre chose pour la ranger dans votre sac");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        if (choix.equals("1")){
            perso.equipeArme(arme);
        }
    }

}