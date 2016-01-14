package rpgmaladie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Personnage {

    //ajout de la capacite CorpsAcorps, commune à Femme et a Homme. Du coup j'ai du ajouter 
    //sa construction dans le constructeur avec une arme de depart(les poings), j'ai rajouter pas 
    //mal de methodes supplémentaires mais je souviens pas de toutes.++++
    
    
	private final String nomPersonnage;
	protected Map<Caracteristique, Integer> caracs;
	protected int niveau=1;
	private final int poidsMax;
	private int SanteMax;
	private List<Item> inventaire=null;
        protected Arme armeEquipee;
        private int poidsInventaire=0;
        private int bourse=0;
        private Capacite corpsACorps;
        private Capacite capacite1;
        private Capacite capacite2;
        private Capacite capacite3;
        private Capacite capacite4;
   
        
        public Personnage(String nom, Map<Caracteristique, Integer> caracs, int p){
            this.SanteMax=300-(caracs.get(Caracteristique.FORCE)+caracs.get(Caracteristique.SANTE)+caracs.get(Caracteristique.DEXTERITE)+caracs.get(Caracteristique.DEFENSE));
            this.nomPersonnage=nom;
            this.caracs=caracs;
            this.poidsMax=p;
            Arme armeEquipee=new Arme("Poings",0,Caracteristique.FORCE,0,-2,0,1,100);
            Attaque corpsACorps= new Attaque("Attaque au corps a corps",new Effet(Caracteristique.SANTE,armeEquipee.getDegat()),armeEquipee.getProba());
            

            
        }
        public void setBourse(int b){
            bourse=bourse+b;
        }
        public int getBourse(){
            return bourse;
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
                System.out.println("Medicament avalé");
                appliqueEffet(medoc.getEffetNegatifMedicament());
                System.out.println("Oups ! Ce médicament vous a fait perdre "+medoc.getValeurEffetNeg()+" points de "+medoc.getCaracEffetNeg()+".");
                RetireInventaire(medoc);
            }
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
        
        public void setSante(int v){
            caracs.put(Caracteristique.SANTE,v );
        }
        public void setForce(int v){
            caracs.put(Caracteristique.FORCE,v );
        }
        public void setDexterite(int v){
            caracs.put(Caracteristique.DEXTERITE,v );
        }
        public void setDefense(int v){
            caracs.put(Caracteristique.DEFENSE,v );
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
        public Arme getArmeEquipee(){
            return armeEquipee;
        }
        
        public void afficheNomPerso(){
            System.out.println(this.nomPersonnage);
        }
        
        public void afficheCaracteristique(){
            for(Caracteristique ca : Caracteristique.values()){
                System.out.println(ca.getNom()+" : "+this.caracs.get(ca));
                System.out.println("");
            }
        }
        
        public void afficheNiveau(){
            System.out.println(niveau);
        }
        
        public void affichePoidsMax(){
            System.out.println(this.poidsInventaire);
        }
        
        public void afficheInventaire(){
            for(int i=0; i<inventaire.size(); i++) 
                System.out.println(inventaire.get(i)); 
        }
        
        public boolean EstHomme(Personnage perso){
            if(perso instanceof Homme){
                return true;
            }
            else{
                return false;
                
            }
        }
        
        public boolean EstFemme(Personnage perso){
            if(perso instanceof Femme){
                return true;
            }
            else{
                return false;
                
            }
        }
        public int getNiveau(){
            return niveau;
        }
        public void ExplicationActions(){
            
        }
        
        public Capacite getCapacite1(){
            return capacite1;
        }
        public Capacite getCapacite2(){
            return capacite2;
        }
        public Capacite getCapacite3(){
            return capacite3;
        }
        public Capacite getCapacite4(){
            return capacite4;
        }
        public Capacite getCorpsACorps(){
            return corpsACorps;
        }
}