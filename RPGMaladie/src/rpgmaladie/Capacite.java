package rpgmaladie;

public abstract class Capacite {
    
    protected final String nomCapacite;
    protected final Effet effet;
    protected final int probaReussite;
    
    public Capacite(String nom, Effet effet, int proba){
        this.nomCapacite=nom;
        this.effet=effet;
        this.probaReussite=proba;
    }
       
    public boolean probaReussite(Personnage src){   //Détermine si l'attaque va réussir (probabilité de l'arme et dextérité du personnage)
        int varAlea=(int)(Math.random()*100);
        int chanceReussite=probaReussite+src.getDexterite();
        boolean action = (varAlea<chanceReussite);
        return action;
    }
    
    public void AppliqueEffet(Personnage perso, Maladie maladie){   //Application de l'effet de la capacité
        //Définition dans les filles
    }
    
    //Tout les getter
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