package rpgmaladie;

public abstract class Item {

    protected String nom;
    protected int poids;
    protected Effet effet;
    protected int prix;
    protected Caracteristique caracteristique;
    protected int valeur;

    public Item(String nom, int poids, Caracteristique caracteristique, int valeur,int prix) {
        this.effet= new Effet(caracteristique,valeur);
        this.poids=poids;
        this.nom=nom;
        this.prix=prix;
        this.caracteristique=caracteristique;
        this.valeur=valeur;

    }

    public void utiliserItem(Personnage perso){
        //Définition dans les filles
    }

    public void jeterItem(Personnage perso){    //Méthode pour jeter un item de l'inventaire du perso
        perso.RetireInventaire(this);
    }

    public void afficherItem(int i){
        //Définition dans les filles
    }

    public void afficherItemPrix(int i){
        //Définition dans les filles
    }

    //Tout les getter
    public int getPrix(){
        return prix;
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
    
    public int getPoids(){
        return poids;
    }
    public Effet getEffet(){
        return this.effet;
    }
}