package rpgmaladie;
//je n'ai rien changer
public class Medicament extends Item {
        private Effet effetNegatifMedicament;


	public Medicament(String nom, int poids,Caracteristique carac, int valeur, Caracteristique malus, int valeurMalus,int prix) {
            super(nom,poids,carac,valeur,prix);
            effetNegatifMedicament=new Effet(malus, valeurMalus);
	}
        
        public Effet getEffetNegatifMedicament(){
            return this.effetNegatifMedicament;
        }
        
        public int getValeurEffetNeg(){
            return effetNegatifMedicament.getValeur();
        }
        
        public String getCaracEffetNeg(){
            return effetNegatifMedicament.getCaracteristique().getNom();
        }
        public void utiliserItem(Personnage perso){
            perso.prendMedicament(this);
        }
        public void afficherItem(int i){
            System.out.println(i+" : "+this.nom+" ("+effet.getCaracteristique().getNom()+" : "+effet.getValeur()+")");
        }
        
}