package rpgmaladie;

import java.util.List;
import java.util.Map;

public abstract class Personnage {

	private final String nomPersonnage;
	private Map<Caracteristique, Integer> caracs;
	private int niveau;
	private final int poidsMax;
	private final int SanteMax;
	private List<Item> inventaire;
        private Arme armeEquipee;
        private int poidsInventaire;
        
        public Personnage(String nom, Map<Caracteristique, Integer> caracs, int p,List<Item> inventaire, int pi, Arme a){
            this.niveau=1;
            this.SanteMax=150;
            this.nomPersonnage=nom;
            this.inventaire=inventaire;
            this.caracs=caracs;
            this.poidsMax=p;
            this.armeEquipee=a;
            this.poidsInventaire=0;
            
        }
        

	public void appliqueEffet(Item i) {
            

	}

        
        
        public boolean EstDansInventaire(Item i){
            return inventaire.contains(i);
        }

        public void AjouteInventaire(Item i){
            inventaire.add(i);
            poidsInventaire=poidsInventaire + i.getPoids();
  
        }
	public void equipeArme(Arme arme) {
         
                AjouteInventaire(armeEquipee);
                armeEquipee=arme;
                System.out.println("Arme équipée");
                   
	}
        public void RetireInventaire(Item i){
            inventaire.remove(i);
            poidsInventaire=poidsInventaire- i.getPoids();
            System.out.println("Element retiré de l'inventaire");
            
        }
        
        

	public void prendMedicament(Medicament medoc) {
            appliqueEffet(medoc);
            System.out.println("Medicament avalé");
	}

	public int getPoidsInventaire() {
            
            return poidsInventaire;

	}




	public void incrementNiveau() {
            niveau++;

	}

	public int sumCarac() {
            int s;
            s=(Map<Caracteristique, Integer>) caracs.get(FORCE)+(Map<Caracteristique, Integer>) caracs.get(DEXTERITE)+(Map<Caracteristique, Integer>) caracs.get(SANTE)+ (Map<Caracteristique, Integer>) caracs.get(DEFENSE);
            

	}

	public Map<Caracteristique, Integer> getValeurCarac() {
            return (Map<Caracteristique, Integer>) caracs.entrySet();
	
	}

	public void initCaracteristiques() {
		// TODO - implement Personnage.initCaracteristiques
		throw new UnsupportedOperationException();
	}

	public void verifierCaracteristique() {
		// TODO - implement Personnage.verifierCaracteristique
		throw new UnsupportedOperationException();
	}

	public void initCapacite() {

	}

}