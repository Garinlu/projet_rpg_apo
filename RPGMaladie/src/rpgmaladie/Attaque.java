package rpgmaladie;

public class Attaque extends Capacite {//pas de changement

        
    public Attaque (String nom, Effet effet,int proba){
        super(nom,effet,proba);
    }
    
    public Effet effet(Personnage src, Maladie maladie){
        int newValeurAttaque = effet.getValeur() + src.getForce() - maladie.getDefense();
        return (new Effet(Caracteristique.SANTE,newValeurAttaque));
    }
          
    public boolean probaReussite(Personnage src){
        int varAlea=(int)(Math.random()*100);
        int chanceReussite=probaReussite+src.getDexterite()+src.getArmeEquipee().getManiabilite();
        boolean action;
        action = (varAlea<chanceReussite);
        return action;
    }
    
    public void AppliqueEffet(Personnage perso, Maladie maladie){//Application de l'attaque si la proba de réussite est bonne
        Effet effetFinal = effet(perso,maladie);
        if(probaReussite(perso)){
            maladie.AppliqueEffet(effetFinal);
        }
        else{
            System.out.println("Oups ! L'attaque est manquée..");
        }
    }
}