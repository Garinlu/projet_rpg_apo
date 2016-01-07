package rpgmaladie;

public class Attaque extends Capacite {
    private Effet effet;
    private int probaReussite;
        
    public Attaque (String nom, Effet effet,int proba){
        super(nom,effet,proba);
    }
    
    public Effet effet(Personnage src, Maladie maladie){
        int newValeurAttaque = effet.getValeur() + src.getForce() - maladie.getDefense();
        return (new Effet(Caracteristique.SANTE,-newValeurAttaque));
    }
          
    public boolean probaReussite(Personnage src){
        int varAlea=(int)(Math.random()*100);
        int chanceReussite=probaReussite+src.getDexterite()+src.getManiabilite();
        boolean action;
        action = (varAlea<chanceReussite);
        return action;
    }
}