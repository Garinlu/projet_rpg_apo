package rpgmaladie;

public abstract class Item {

	protected String nom;
	protected int poids;
	protected Effet effet;
      

	public Item(String nom, int poids, Caracteristique caracteristique, int valeur) {
            this.effet= new Effet(caracteristique,valeur);
            this.poids=poids;
            this.nom=nom;
           
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