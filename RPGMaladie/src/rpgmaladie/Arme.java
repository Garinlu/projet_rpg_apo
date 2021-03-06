package rpgmaladie;

public class Arme extends Item {// ajout de la proba de reussite+ les gets.+ je comprends pas trop la stats de soin
                                //il faudrat ajouter le prix

	private final int degat;
        private final int proba; 

    /**
     *
     * @param nom
     * @param poids
     * @param caracteristique
     * @param valeur
     * @param degat
     * @param proba
     * @param prix
     */
    public Arme(String nom, int poids, Caracteristique caracteristique, int valeur, int degat, int proba,int prix) {
		super(nom,poids,caracteristique, valeur,prix);
                this.degat=degat;
                this.proba=proba;
	}
        
    /**
     *
     * @param perso
     */
    @Override
        public void utiliserItem(Personnage perso){ //Equiper l'arme au personnage
            perso.equipeArme(this);
        }
        
    /**
     *
     */
    public void afficheInfosArme(){ //Affichage des caractéristique de l'arme
            System.out.println("Nom: "+this.nom);
            System.out.println("Poids: "+this.poids);
            System.out.println("Bonus: +"+this.valeur+" en "+this.caracteristique.getNom());
            System.out.println("Degats de base: "+this.degat);
            System.out.println("Malus possibles..");
        }
        
    /**
     *
     * @param i
     */
    @Override
        public void afficherItem(int i){    //affichage d'un item sans le prix
            System.out.println(i+" : "+this.nom+" (dégat : "+this.degat+" ; probabilité : "+this.proba+")");
        }
        
    /**
     *
     * @param i
     */
    @Override
        public void afficherItemPrix(int i){    //affichage d'un item avec le prix (pour la boutique)
            System.out.println(i+" : "+this.nom+" (dégat : "+this.degat+" ; probabilité : "+this.proba+") -> "+this.prix+"€");
        }
        
        //Tout les getter
        public int getProba(){
            return proba;
            
        }
        public int getDegat(){
            return degat;
        }

}