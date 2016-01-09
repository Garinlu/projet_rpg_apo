package rpgmaladie;


//pas de changement
public enum Caracteristique {
	FORCE("force"),
	DEXTERITE("dextérité"),
	SANTE("santé"),
	DEFENSE("défense");
        
        private String nom;
        
        Caracteristique(String nom){
            this.nom=nom;
        }
        
        public String getNom(){ 
            return this.nom; 
        }
}