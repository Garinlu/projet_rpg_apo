package rpgmaladie;

public abstract class Capacite {
    private final String nomCapacite;
    private final Effet effet;
    private final int probaReussite;
    
    public Capacite(String nom, Effet effet, int proba){
        this.nomCapacite=nom;
        this.effet=effet;
        this.probaReussite=proba;
    }
       
        
        
    public boolean probaReussite(Personnage src){
        int varAlea=(int)(Math.random()*100);
        int chanceReussite=probaReussite+src.getDexterite()+src.getManiabilite();
        boolean action = (varAlea<chanceReussite);
        return action;
    }
    

    public void AppliqueEffet(Capacite capacite){//uniquement pour attaque et soin, parade etant un cas a part
        if (capacite instanceof Attaque){
            
            
            
            
        }

    }

    


}