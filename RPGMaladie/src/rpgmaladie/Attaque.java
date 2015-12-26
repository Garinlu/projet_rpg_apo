package rpgmaladie;

public abstract class Attaque implements Capacite {

	private String nom;
        private Effet effet;
        
        public Attaque (String nom, Effet effet){
            this.nom=nom;
            this.effet=effet;
        }
        public Effet[] effet(Personnage src, Personnage cible){

        }
}