package rpgmaladie;

public class Effet {//je n'ai rien changer

	private Caracteristique c;
	private int valeur;
        
        public Effet(Caracteristique c, int v){
            this.c=c;
            this.valeur=v;
        }
        
        public int getValeur(){
            return valeur;
        }
        
        public Caracteristique getCaracteristique(){
            return c;
        }

}