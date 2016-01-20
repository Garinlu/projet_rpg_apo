package rpgmaladie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
public abstract class Personnage {

    //ajout de la capacite CorpsAcorps, commune à Femme et a Homme. Du coup j'ai du ajouter 
    //sa construction dans le constructeur avec une arme de depart(les poings), j'ai rajouter pas 
    //mal de methodes supplémentaires mais je souviens pas de toutes.++++
    
    
	private final String nomPersonnage;
	protected Map<Caracteristique, Integer> caracs;
	protected int niveau=1;
	private final int poidsMax;
	private List<Item> inventaire;
        protected Arme armeEquipee;
        private int poidsInventaire=0;
        private int bourse=0;
        protected Capacite corpsACorps;
        protected Capacite capacite1;
        protected Capacite capacite2;
        protected Capacite capacite3;
        protected Capacite capacite4;
        //Les capacitées de base
        protected int santeMax;
        protected int dexteriteMax;
        protected int forceMax;
        protected int defenseMax;
   
        
        public Personnage(String nom, Map<Caracteristique, Integer> caracs, int p){
            this.nomPersonnage=nom;
            this.caracs=caracs;
            this.poidsMax=p;
            this.armeEquipee=new Arme("Poings américain",0,Caracteristique.FORCE,0,-5,100,100);
            this.corpsACorps= new Attaque("Attaque au corps a corps",new Effet(Caracteristique.SANTE,armeEquipee.getDegat()),armeEquipee.getProba());
            this.inventaire=new ArrayList<Item>();
        }
        
        public void setBourse(int b){
            this.bourse=b;
        }
        public int getBourse(){
            return this.bourse;
        }
        public int getPoidsMax(){
            return poidsMax;
        }

	public void appliqueEffetItem(Item i) {
            
            //if(e.getCaracteristique()==Caracteristique.SANTE){
              //  caracs.put(e.getCaracteristique(),this.santeMax);
            if(verifierCaracteristique(i.getEffet())){
                caracs.put(i.getCaracEffet(),caracs.get(i.getCaracEffet())+i.getValeurEffet());
                System.out.println("Effet appliqué : "+i.getValeurEffet()+" dans la caracteristique "+i.getCaracEffet()+".");
            }
            else{
                caracs.put(i.getCaracEffet(),0);
                System.out.println("Effet appliqué : "+i.getValeurEffet()+" dans la caracteristique "+i.getCaracEffet()+".");
            }
	}

        public void appliqueEffet(Effet e) {
            if(verifierCaracteristique(e)){
                caracs.put(e.getCaracteristique(),caracs.get(e.getCaracteristique())+e.getValeur());
                System.out.println("Effet appliqué : "+e.getValeur()+" dans la caracteristique "+e.getCaracteristique()+".");
            }
            else{
                caracs.put(e.getCaracteristique(),0);
                System.out.println("Effet appliqué : "+e.getValeur()+" dans la caracteristique "+e.getCaracteristique()+".");
            }
	}
        
        public boolean EstDansInventaire(Item i){
            return inventaire.contains(i);
        }

        public void AjouteInventaire(Item i){
            if(poidsInventaire+i.getPoids()<=this.poidsMax){
                inventaire.add(i);
                poidsInventaire=poidsInventaire + i.getPoids();
                System.out.println(i.getNom()+" ajouté à votre inventaire.");
            }
            else{
                System.out.println("Vous avez pas assez de place dans votre inventaire.");
            }
  
        }
	public void equipeArme(Arme arme) {
            if (EstDansInventaire(arme)){
            
                AjouteInventaire(armeEquipee);
                System.out.println("Vous rangez l'arme équipée dans votre sac");
                armeEquipee=arme;
                RetireInventaire(arme);
                System.out.println("Nouvelle arme équipée : "+arme.getNom());
                this.corpsACorps=new Attaque(armeEquipee.getNom(),new Effet(Caracteristique.SANTE,armeEquipee.getDegat()),armeEquipee.getProba());
                
            }
            else{
                System.out.println("Vous n'avez pas l'arme.");
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
            System.out.println("Level up");
            levelUpCaracteristiques();
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

        public void levelUpCaracteristiques() {
            caracs.put(Caracteristique.FORCE, caracs.get(Caracteristique.FORCE)+1);
            caracs.put(Caracteristique.DEFENSE, caracs.get(Caracteristique.DEFENSE)+1);
            caracs.put(Caracteristique.SANTE, caracs.get(Caracteristique.SANTE)+1);
            caracs.put(Caracteristique.DEXTERITE, caracs.get(Caracteristique.DEXTERITE)+1);
	}
        
	public boolean verifierCaracteristique(Effet effet) {
            return (caracs.get(effet.getCaracteristique())+effet.getValeur() >= 0);
        }

            
	public void initCapacite() {

	}
        
        public void setSante(int v){
            caracs.put(Caracteristique.SANTE,v );
        }
         public void setSanteMax(int v){
            this.santeMax=v;
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
        
        public int getSanteMax() {
            return this.santeMax;
        
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
                
            }
            System.out.println("Santé max ="+this.santeMax);
            System.out.println("Arme équipée = "+this.armeEquipee.getNom());
        }
        
        public void afficheNiveau(){
            System.out.println(niveau);
        }
        
        public void affichePoidsMax(){
            System.out.println(this.poidsInventaire);
        }
        
        public void afficheInventaire(){
            if (!inventaire.isEmpty()){
                for(int i=0; i<inventaire.size(); i++) 
                    inventaire.get(i).afficherItem(i);
            }
            else{
                System.out.println("L'inventaire est vide.");
            }
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
        public List<Item> getInventaire(){
            return inventaire;
        }
        
        public int getNiveau(){
            return niveau;
        }
        public void ExplicationActions(){
        }
        
        public Capacite getCapacite1(){
            return this.capacite1;
        }
        public Capacite getCapacite2(){
            return this.capacite2;
        }
        public Capacite getCapacite3(){
            return this.capacite3;
        }
        public Capacite getCapacite4(){
            return this.capacite4;
        }
        public Capacite getCorpsACorps(){
            return this.corpsACorps;
        }
        public String getNomPersonnage(){
            return this.nomPersonnage;
        }
        
        
        
        public int getDexteriteMax(){
            return this.dexteriteMax;
        }
        public int getForceMax(){
            return this.forceMax;
        }
        public int getDefenseMax(){
            return this.defenseMax;
        }
        
        public void setDefenseMax(int v){
            this.defenseMax=v;
        }
        public void setForceMax(int v){
            this.forceMax=v;
        }
        public void setDexteriteMax(int v){
            this.dexteriteMax=v;
        }
        public boolean nombreDansInventaire(int i){
            return (i<=inventaire.size() && i>=0);
        }
        public Item choixDansInventaire(int i){
            return this.inventaire.get(i);
        }
        
        public boolean achete(Item i, int prix){
            if (prix<bourse){
                this.AjouteInventaire(i);
                bourse-=prix;
                System.out.println("Bourse : "+bourse+"€.");
                return true;
            }
            else{
                System.out.println("Cet article est trop chère !");
                return false;
            }
        }
}
