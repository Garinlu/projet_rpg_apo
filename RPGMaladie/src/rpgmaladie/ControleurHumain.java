package rpgmaladie;

import java.util.Scanner;

public class ControleurHumain {     //Gère les choix du personnage
    private final Personnage perso;
    private Capacite prochaineAttaque;
    private boolean mutationFatale=false;
    private final Boutique boutique;

    
    public ControleurHumain(Personnage perso, Boutique boutique){
        this.perso=perso;
        this.boutique=boutique;
    }
    
    public void PayementObligatoire(int prix,Maladie maladie){  //Méthode utilisée lorsque la maladie mute et oblige le payement
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
    
    public Capacite ChoisirAction(){    //Détermine l'action pour le joueur : Attaque/Soin ou utiliser inventaire
        System.out.println("");
        System.out.println("");
        Capacite empty = new Attaque("Vous n'attaquez pas pendant ce tour.", (new Effet(Caracteristique.SANTE,0)), 100);
        boolean check=false;
        while(!check){
            System.out.println("Quelle action voulez vous réaliser pour ce tour ? (Attaque = 1 / Inventaire = 2) ");
            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();
            if(choix.equals("1")){
                boolean confirm=false;
                perso.ExplicationActions();
                System.out.println("Indiquez votre choix(entre 1 et 4)");
                Scanner sc2 = new Scanner(System.in);
                String choix2 = sc2.nextLine();
                switch (choix2) {
                    case "1":
                        return perso.getCapacite1();
                    case "2":
                        return perso.getCapacite2();
                    case "3":
                        return perso.getCapacite3();
                    case "4":
                        return perso.getCorpsACorps();
                }
            }
            else if(choix.equals("2")){
                if(perso.getInventaire().isEmpty()){
                    System.out.println("Inventaire vide");
                }
                else{
                    choixInventaire();
                    return empty;
                }
            }
            else{
                check=false;
            }
        }
        return empty;
    }
    
    public boolean investir(){      //Propose l'investissement ou non dans la recherche
        boolean check=false;
        while(!check){
            System.out.println("Voulez vous investir ? Oui : 1 / Non : 0");
            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();
            if (choix.equals("1") || choix.equals("0")) return choix.equals("1");
        }
        return true;
    }
    
    public void prendreMedicament(Medicament medicament){   //Personnage consomme un médicament
        System.out.println("Voulez vous avaler ce medicament pour remonter votre sante?");
        System.out.println("Mais attention, il aura peut etre des effets secondaires!(Tapez 1 pour acceptez et autre chose pour refuser");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        if (choix.equals("1")){
            perso.prendMedicament(medicament);
        }

    }
    
    public void choixInventaire(){  //Affiche l'inventaire et gère l'utilisation ou le jet d'un item
        boolean check=false;
        while(!check){
            perso.afficheInventaire();
            System.out.println("Voulez vous utilisé ou jeté un item ? Utilisé : 1 / Jeté : 2 / Non : 0");
            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();
            if(choix.equals("1") || choix.equals("2")){
                System.out.println("Veuillez entrer le numéro de l'item :");
                Scanner sc2 = new Scanner(System.in);
                String choix2 = sc2.nextLine();
                int itemAEquiper;
                try { 
                    itemAEquiper=Integer.parseInt(choix2);
                }
                catch (Exception e) {
                   itemAEquiper=10000;
                }
                if(perso.nombreDansInventaire(itemAEquiper)){
                    if(choix.equals("1"))perso.choixDansInventaire(itemAEquiper).utiliserItem(perso);
                    if(choix.equals("2"))perso.choixDansInventaire(itemAEquiper).jeterItem(perso);
                }
            }
            else if(choix.equals("0"))check=true;
        }
    }
    
    public void entreLesCombats(){      //Gère le scénario entre les combats selon la demande du personnage
        int varAlea=(int)(Math.random()*100);
        boolean choice= false;
        System.out.println("Après cette victoire contre la maladie, plussieurs possibilitées s'offrent a vous:");
        System.out.println("1:Vous vous reposez auprès de votre famille et vos amis");
        System.out.println("2:Vous faites de la prévention auprès de jeunes en lycée");
        System.out.println("3.Vous faites un peu de sport");
        System.out.println("4.Vous allez faire des examens et vous reposer a l'hopital");
        System.out.println("5.Vous sortez avec vos amis");
        System.out.println("6.Vous jouez au loto");
        Scanner sc = new Scanner(System.in);
        while(!choice){
            System.out.println("Faites votre choix");
            String choix = sc.nextLine();
            if (choix.equals("1")){
                perso.setSante(perso.getSante()+varAlea);
                perso.setSanteMax(perso.getSanteMax()+varAlea);
                System.out.println("Votre santé augmente de "+varAlea+".");
                choice=true;
            }
            if (choix.equals("2")){
                perso.setBourse(perso.getBourse()+varAlea);
                System.out.println("Votre bourse augmente de "+varAlea+".");
                choice=true;
                
            }
            if (choix.equals("3")){
                perso.setForce(perso.getForce()+varAlea);
                System.out.println("Votre force augmente de "+varAlea+".");
                choice=true;
            }
            if (choix.equals("4")){
                perso.setDexterite(perso.getDexterite()+varAlea);
                System.out.println("Votre dextérité augmente de "+varAlea+".");
                choice=true;
            }
            if (choix.equals("5")){
                System.out.println("Vous passez du temps avec vos amis.");
                choice=true;
             
            }
            if (choix.equals("6")){
                if (varAlea<10){
                    perso.setBourse(perso.getBourse()+1000);
                    System.out.println("YES ! Vous avez gagné au Loto ! Vous remportez 1000€.");
                }
                else{
                    System.out.println("Dommage, vous n'avez malheureusement pas gagné d'argent.");
                }
                choice=true;
            }
        }
    }
    
    public void achatBoutique(){    //Affichage de la boutique et gère les demande du personnage
        boolean confirm = false;
        while(!confirm){
            boutique.afficherBoutique();
            System.out.println("Bourse : "+perso.getBourse()+"€");
            System.out.println("Voulez vous acheter un item ? Si oui, entrer le numéro d'un item, sinon entrer -1");
            Scanner sc = new Scanner(System.in);
            String choix2 = sc.nextLine();
            if(choix2.equals("-1"))confirm=true;
            else{
                for (int i=0;i<boutique.getCatalogue().size();i++){
                    if(choix2.equals(Integer.toString(i))){
                        perso.achete(boutique.getCatalogue().get(i),boutique.getCatalogue().get(i).getPrix());
                    }
                }
            }
        }
    }
    
    //Tout les getter
    public boolean getMutationFatale(){
        return mutationFatale;
    }
}