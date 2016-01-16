package rpgmaladie;


//pas de changement
public enum Caracteristique {
	FORCE("Force"),
	DEXTERITE("Dextérité"),
	SANTE("Santé"),
	DEFENSE("Défense");
        
        private String nom;
        
        Caracteristique(String nom){
            this.nom=nom;
        }
        
        public String getNom(){ 
            return this.nom; 
        }
}