package rpgmaladie;

public class Soin extends Capacite {
    
//pas toucher comme Brandao
        
        public Soin (String nom, Effet effet,int proba){
            super(nom,effet,proba);
        }
        
        public void AppliqueEffet(Personnage perso){//Application de l'effet de la capacité
            perso.appliqueEffet(effet);
        }

}