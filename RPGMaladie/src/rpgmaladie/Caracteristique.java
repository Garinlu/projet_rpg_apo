package rpgmaladie;


//pas de changement
public enum Caracteristique {
	FORCE("Force"),
	DEXTERITE("Dextérité"),
	DEFENSE("Défense"),
	SANTE("Santé");
        
        private String nom;
        
        Caracteristique(String nom){
            this.nom=nom;
        }
        
        public String getNom(){ 
            return this.nom; 
        }
}