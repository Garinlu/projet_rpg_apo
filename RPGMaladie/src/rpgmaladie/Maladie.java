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
            this.sante=10;
            this.defense=0;
      }
        
        public void setMute(boolean b){
            this.estMute=b;
        }
        public boolean getEstMute(){
            return this.estMute;
        }
        
        public void initCarac(int niveau){
            this.sante=5+niveau*5;
            this.defense=0;
        }
        
        
        

	public void GrosseMigraine (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-6)*this.niveau);
            Effet effetSymptome= new Effet(Caracteristique.DEXTERITE,(-1)*this.niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome);
            System.out.println("");
            System.out.println("Maladie vous inflige une grosse migraine.");
            System.out.println("Maladie vous a appliqué "+effetDegat.getValeur()+" de dégats.");
            System.out.println("De plus, vos symptôme vous fait diminuer votre dextérité de "+effetSymptome.getValeur()+".");
           	
	}

	public void FievreTerrible (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-7)*this.niveau);
            Effet effetSymptome1= new Effet(Caracteristique.DEXTERITE,(-2)*this.niveau);
            Effet effetSymptome2= new Effet(Caracteristique.DEFENSE,(-1)*this.niveau);
            Effet effetSymptome3= new Effet(Caracteristique.FORCE,(-1)*this.niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome1);
            cible.appliqueEffet(effetSymptome2);
            cible.appliqueEffet(effetSymptome3);
            System.out.println("");
            System.out.println("Maladie vous inflige une fièvre terrible.");
            System.out.println("Maladie vous a appliqué "+effetDegat.getValeur()+" de dégats.");
            System.out.println("De plus, vos symptôme vous fait diminuer votre dextérité de "+effetSymptome1.getValeur()+".");
            System.out.println("De plus, vos symptôme vous fait diminuer votre défense de "+effetSymptome2.getValeur()+".");
            System.out.println("De plus, vos symptôme vous fait diminuer votre force de "+effetSymptome3.getValeur()+".");

	}

	public void CoupdeGrace (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-10)*this.niveau);
            Effet effetSymptome= new Effet(Caracteristique.DEFENSE,(-1)*this.niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome);
            System.out.println("");
            System.out.println("Maladie vous inflige un coup de grace.");
            System.out.println("Maladie vous a appliqué "+effetDegat.getValeur()+" de dégats.");
            System.out.println("De plus, vos symptôme vous fait diminuer votre défense de "+effetSymptome.getValeur()+".");

	}

	public void MauxdeVentre (Personnage cible){
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-8)*this.niveau);
            Effet effetSymptome1= new Effet(Caracteristique.DEXTERITE,(-1)*this.niveau);
            Effet effetSymptome2= new Effet(Caracteristique.DEFENSE,(-1)*this.niveau);
            Effet effetSymptome3= new Effet(Caracteristique.FORCE,(-2)*this.niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome1);
            cible.appliqueEffet(effetSymptome2);
            cible.appliqueEffet(effetSymptome3);
            System.out.println("");
            System.out.println("Maladie vous inflige des maux de ventre.");
            System.out.println("Maladie vous a appliqué "+effetDegat.getValeur()+" de dégats.");
            System.out.println("De plus, vos symptôme vous fait diminuer votre dextérité de "+effetSymptome1.getValeur()+".");
            System.out.println("De plus, vos symptôme vous fait diminuer votre défense de "+effetSymptome2.getValeur()+".");
            System.out.println("De plus, vos symptôme vous fait diminuer votre force de "+effetSymptome3.getValeur()+".");
            

	}
        public void AppliqueEffet(Effet effet){
            int valeurFinale=effet.getValeur() + this.defense;
            this.sante=this.sante + valeurFinale;
            System.out.println("Maladie perd "+valeurFinale+" points de vie.");
        }
        
        public int getSante(){
            return this.sante;
        }
        
        public int getDefense(){
            return this.defense;
        }
        public int getProbaGM(){
            return this.probaGM;
        }
        public int getProbaFT(){
            return this.probaFT;
        }
        public int getProbaCG(){
            return this.probaCG;
        }
        public int getProbaMV(){
            return this.probaMV;
        }
        public String getNomMaladie(){
            return this.nomMaladie;
        }
        


}