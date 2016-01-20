package rpgmaladie;

public class Attaque extends Capacite {//pas de changement

        
    public Attaque (String nom, Effet effet,int proba){
        super(nom,effet,proba);
    }
    
    public Effet effet(Personnage src, Maladie maladie){
        int newValeurAttaque = effet.getValeur() - src.getForce() + maladie.getDefense();
        return (new Effet(Caracteristique.SANTE,newValeurAttaque));
    }
          
    
    public void AppliqueEffet(Personnage perso, Maladie maladie){//Application de l'attaque si la proba de réussite est bonne
        super.AppliqueEffet(perso, maladie);
        Effet effetFinal = effet(perso,maladie);
        if(probaReussite(perso)){
            System.out.println("Attaque lancée : "+nomCapacite);
            maladie.AppliqueEffet(effetFinal);
        }
        else{
            System.out.println("Oups ! L'attaque est manquée..");
        }
    }
}