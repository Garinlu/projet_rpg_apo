package rpgmaladie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Personnage {

	private final String nomPersonnage;
	private Map<Caracteristique, Integer> caracs;
	private int niveau;
	private final int poidsMax;
	private int SanteMax;
	private List<Item> inventaire;
        private Arme armeEquipee;
        private int poidsInventaire;
        
        public Personnage(String nom, Map<Caracteristique, Integer> caracs, int p,List<Item> inventaire, int pi, Arme a){
            this.niveau=1;
            this.SanteMax=300-(caracs.get(Caracteristique.FORCE)+caracs.get(Caracteristique.SANTE)+caracs.get(Caracteristique.DEXTERITE)+caracs.get(Caracteristique.DEFENSE));
            this.nomPersonnage=nom;
            this.inventaire=inventaire;
            this.caracs= new HashMap<>();
            this.caracs=caracs;
            this.poidsMax=p;
            this.armeEquipee=a;
            this.poidsInventaire=0;
            
        }
        

	public void appliqueEffetItem(Item i) {
            caracs.put(i.getCaracEffet(),caracs.get(i.getCaracEffet())+i.getValeurEffet());
            System.out.println("Effet Appliqué: +"+i.getValeurEffet()+"dans la caracteristique "+i.getCaracEffet());

	}

        public void appliqueEffet(Effet e) {
            caracs.put(e.getCaracteristique(),caracs.get(e.getCaracteristique())+e.getValeur());
            System.out.println("Effet Appliqué: +"+e.getValeur()+"dans la caracteristique "+e.getCaracteristique());

	}
        
        public boolean EstDansInventaire(Item i){
            return inventaire.contains(i);
        }

        public void AjouteInventaire(Item i){
            inventaire.add(i);
            poidsInventaire=poidsInventaire + i.getPoids();
  
        }
	public void equipeArme(Arme arme) {
            if (EstDansInventaire(arme)){
            
                AjouteInventaire(armeEquipee);
                armeEquipee=arme;
                RetireInventaire(arme);
                System.out.println("Arme équipée");
            }
            else{
                System.out.println("Vous n'avez pas l'arme, n'assayez pas de nous arnaquer");
            }
	}
        public void RetireInventaire(Item i){
            inventaire.remove(i);
            poidsInventaire=poidsInventaire- i.getPoids();
            System.out.println("Element retiré de l'inventaire");
            
        }
        
	public void prendMedicament(Medicament medoc) {
            if(EstDansInventaire(medoc)){
            appliqueEffetItem(medoc);
            RetireInventaire(medoc);
            System.out.println("Medicament avalé");}
            else{
                System.out.println("Vous n'etes pas en possession de ce médicament désolé...trouvez-vous une pharmacie de garde");
            }
	}

	public int getPoidsInventaire() {
            
            return poidsInventaire;

	}

	public void incrementNiveau() {
            niveau++;
            this.SanteMax=300-(sumCarac()*niveau*3);
            System.out.println("Level up");

	}

	public int sumCarac() {
            int s;
            s=caracs.get(Caracteristique.FORCE)+caracs.get(Caracteristique.DEXTERITE)+ caracs.get(Caracteristique.SANTE)+caracs.get(Caracteristique.DEFENSE);
            return s;

	}

	public Map<Caracteristique, Integer> getValeurCarac() {
            return (Map<Caracteristique, Integer>) caracs.entrySet();
	
	}

	public void initCaracteristiques() {
            caracs.put(Caracteristique.FORCE, 0);
            caracs.put(Caracteristique.DEFENSE,0);
            caracs.put(Caracteristique.SANTE,0);
            caracs.put(Caracteristique.DEXTERITE,0);
	}

        
	public void verifierCaracteristique() {
        }
        

            
	public void initCapacite() {

	}
        
        public int getSante(){
            return caracs.get(Caracteristique.SANTE);
        }
        
        public int getForce(){
            return caracs.get(Caracteristique.FORCE);
        }
        
        public int getDexterite(){
            return caracs.get(Caracteristique.DEXTERITE);
        }
        
        public int getDefense(){
            return caracs.get(Caracteristique.DEFENSE);
        }
        
        public int getManiabilite(){
            return armeEquipee.getManiabilite();
        }
}