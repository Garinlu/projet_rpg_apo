package rpgmaladie;

public class Soin extends Capacite {
    
//pas toucher comme Brandao
        
    public Soin (String nom, Effet effet,int proba){
        super(nom,effet,proba);
    }

        
    public Effet effet(Personnage src, Maladie maladie){
        int newValeurSoin = effet.getValeur() + src.getDexterite();
        if(newValeurSoin+src.getSante()>src.getSanteMax()){
            return (new Effet(Caracteristique.SANTE,src.getSanteMax()-src.getSante()));
        }
        else{
            return (new Effet(Caracteristique.SANTE,newValeurSoin));
        }
    }
    
    
    public void AppliqueEffet(Personnage perso, Maladie maladie){//Application de l'attaque si la proba de réussite est bonne
        Effet effetFinal = effet(perso,maladie);
        if(probaReussite(perso)){
            System.out.println("Soin lancée : "+nomCapacite);
            perso.appliqueEffet(effetFinal);
        }
        else{
            System.out.println("Oups ! Le soin est manquée..");
        }
    }
}