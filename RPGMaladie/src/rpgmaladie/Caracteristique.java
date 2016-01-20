package rpgmaladie;

public enum Caracteristique {
    
	FORCE("Force"),
	DEXTERITE("Dextérité"),
	DEFENSE("Défense"),
	SANTE("Santé");
        
        private String nom;
        
        Caracteristique(String nom){    //Constructeur énumération avec un nom
            this.nom=nom;
        }
        
        //Tout les getter
        public String getNom(){ 
            return this.nom; 
        }
}