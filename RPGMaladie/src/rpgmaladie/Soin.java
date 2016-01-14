package rpgmaladie;

public class Soin extends Capacite {
    private Effet effet;
    private int probaReussite;
    
//pas toucher comme Brandao
        
        public Soin (String nom, Effet effet,int proba){
            super(nom,effet,proba);
        }
        
        public void AppliqueEffet(Personnage perso, Maladie maladie){//Application de l'effet de la capacité
            perso.appliqueEffet(this.effet);
        }

}