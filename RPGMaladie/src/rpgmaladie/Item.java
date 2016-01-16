package rpgmaladie;

public abstract class Item {
//Rien changé
	protected String nom;
	protected int poids;
	protected Effet effet;
        protected int prix;
      

	public Item(String nom, int poids, Caracteristique caracteristique, int valeur,int prix) {
            this.effet= new Effet(caracteristique,valeur);
            this.poids=poids;
            this.nom=nom;
            this.prix=prix;
           
	}
        public String getNom(){
            return nom;
        }


	public int getValeurEffet(){
            return effet.getValeur();
	
	}
        
        public Caracteristique getCaracEffet(){
            return effet.getCaracteristique();
        }


	public void ajouteEffet(Effet effet) {
            this.effet=effet;

	}
        
        public int getPoids(){
            return poids;
        }
        

}