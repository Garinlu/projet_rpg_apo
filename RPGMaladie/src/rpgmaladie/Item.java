package rpgmaladie;

public abstract class Item {

	private String nom;
	private int poids;
	private Effet effet;
      

	public Item(String nom, int poids, Caracteristique caracteristique, int valeur) {
            this.effet= new Effet(caracteristique,valeur);
            this.poids=poids;
            this.nom=nom;
           
	}


	public int getValeurEffet(){
            return effet.getValeur();
	
	}


	public void ajouteEffet(Effet effet) {
            

	}
        
        public int getPoids(){
            return poids;
        }
        

}