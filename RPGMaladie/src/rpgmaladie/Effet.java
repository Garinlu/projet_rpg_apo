package rpgmaladie;

public class Effet {  

	private Caracteristique c;
	private int valeur;
        
        public Effet(Caracteristique c, int v){
            this.c=c;
            this.valeur=v;
        }
        
        //Tout les getter
        public int getValeur(){
            return valeur;
        }
        
        public Caracteristique getCaracteristique(){
            return c;
        }

}