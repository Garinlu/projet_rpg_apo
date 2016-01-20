package rpgmaladie;

public class Attaque extends Capacite {//pas de changement

    /**
     *
     * @param nom
     * @param effet
     * @param proba
     */

        
    public Attaque (String nom, Effet effet,int proba){
        super(nom,effet,proba);
    }
    
    /**
     *
     * @param src
     * @param maladie
     * @return
     */
    public Effet effet(Personnage src, Maladie maladie){    //Détermine l'effet final à appliquer selon la force du personnage et la défense de la maladie
        int newValeurAttaque = effet.getValeur() - src.getForce() + maladie.getDefense();
        return (new Effet(Caracteristique.SANTE,newValeurAttaque));
    }
          
    /**
     *
     * @param perso
     * @param maladie
     */
    @Override
    public void AppliqueEffet(Personnage perso, Maladie maladie){   //Application de l'attaque si la proba de réussite est bonne
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