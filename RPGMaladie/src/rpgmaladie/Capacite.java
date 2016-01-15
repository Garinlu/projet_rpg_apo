package rpgmaladie;

public abstract class Capacite {//la y'a du boulot, il va falloir generer l'application des degats et des soins.
                                //le probleme c'est que la classe Effet est en fonction d'une Caracteristique alors
                                //que les degats seron fait sur maladie.setSante(), on devrait pouvoir s'en sortir quand meme
    protected final String nomCapacite;
    protected final Effet effet;
    protected final int probaReussite;
    
    public Capacite(String nom, Effet effet, int proba){
        this.nomCapacite=nom;
        this.effet=effet;
        this.probaReussite=proba;
    }
       
        
        
    public boolean probaReussite(Personnage src){
        int varAlea=(int)(Math.random()*100);
        int chanceReussite=probaReussite+src.getDexterite()+src.getArmeEquipee().getManiabilite();
        boolean action = (varAlea<chanceReussite);
        return action;
    }
    public void AppliqueEffet(Personnage perso, Maladie maladie){
        //Définition dans les filles
        
    }
    public String getNom(){
        return this.nomCapacite;
    }
    
    public int getValeur(){
        return this.effet.getValeur();
    }
    
    public int getProba(){
        return this.probaReussite;
    }
}