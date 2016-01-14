package rpgmaladie;

public class Maladie {

    //je comprend pas trop l'erreur dans le constructeur y'a besoin d'un oeil neuf mon Garin!
    //sinon j'ai ajouter estMute et les gets et sets qui vont avec.Plus initCarac() en fonction du niveau
    //+ tout les gets des caracs.
    
	private final String nomMaladie;
	private int sante;
        private int defense;
        private final int niveau;//de 1 a 10-> augmente la puissance des attaques
        //on ajoute des probabilitÃ©s pour determiner quelle attaque a le plus de chance d'etre realisÃ©e.
        private final int probaGM=45;//GrosseMigraine
        private final int probaFT=25;
        private final int probaCG=10;
        private final int probaMV=20;
        private boolean estMute=false;
        

    public Maladie(String nom, int niveau){
            this.nomMaladie=nom;
            this.niveau=niveau;
      }
        
        public void setMute(boolean b){
            estMute=b;
        }
        public boolean getEstMute(){
            return estMute;
        }
        
        public void initCarac(int niveau){
            sante=100+niveau*15;
            defense=100+niveau*15;
        }
        
        
        

	public void GrosseMigraine (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-6)*niveau);
            Effet effetSymptome= new Effet(Caracteristique.DEXTERITE,(-4)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome);
           	
	}

	public void FievreTerrible (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-7)*niveau);
            Effet effetSymptome1= new Effet(Caracteristique.DEXTERITE,(-3)*niveau);
            Effet effetSymptome2= new Effet(Caracteristique.DEFENSE,(-3)*niveau);
            Effet effetSymptome3= new Effet(Caracteristique.FORCE,(-3)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome1);
            cible.appliqueEffet(effetSymptome2);
            cible.appliqueEffet(effetSymptome3);

	}

	public void CoupdeGrace (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-10)*niveau);
            Effet effetSymptome= new Effet(Caracteristique.DEFENSE,(-2)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome);

	}

	public void MauxdeVentre (Personnage cible){
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-8)*niveau);
            Effet effetSymptome1= new Effet(Caracteristique.DEXTERITE,(-2)*niveau);
            Effet effetSymptome2= new Effet(Caracteristique.DEFENSE,(-2)*niveau);
            Effet effetSymptome3= new Effet(Caracteristique.FORCE,(-2)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome1);
            cible.appliqueEffet(effetSymptome2);
            cible.appliqueEffet(effetSymptome3);
            

	}
        public void AppliqueEffet(Effet effet){
            sante=effet.getValeur()-defense;
            
        }
        
        public int getSante(){
            return sante;
        }
        
        public int getDefense(){
            return defense;
        }
        public int getProbaGM(){
            return probaGM;
        }
        public int getProbaFT(){
            return probaFT;
        }
        public int getProbaCG(){
            return probaCG;
        }
        public int getProbaMV(){
            return probaMV;
        }
        


}