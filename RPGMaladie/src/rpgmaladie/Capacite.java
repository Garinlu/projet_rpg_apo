package rpgmaladie;

public abstract class Capacite {//la y'a du boulot, il va falloir generer l'application des degats et des soins.
                                //le probleme c'est que la classe Effet est en fonction d'une Caracteristique alors
                                //que les degats seron fait sur maladie.setSante(), on devrait pouvoir s'en sortir quand meme
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
        int chanceReussite=probaReussite+src.getDexterite()+src.getArmeEquipee().getManiabilite();
        boolean action = (varAlea<chanceReussite);
        return action;
    }
    

    public void AppliqueEffet(Capacite capacite,Personnage perso, Maladie maladie){//uniquement pour attaque et soin, parade etant un cas a part
        if (capacite instanceof Attaque){
            
            
            
            
            
        }

    }

    


}