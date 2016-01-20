package rpgmaladie;

public class ControleurA {//Gère la maladie
    
    private final int niveau;
    private Maladie maladie;
    
    public ControleurA(String nomm,int niveau){
        this.niveau=niveau;
        this.maladie = new Maladie(nomm,niveau);
        maladie.initCarac(niveau);
        
    }
    
    //Génère une attaque aléatoirement pour la maladie
    public void genereAttaque(Maladie maladie,Personnage cible,ControleurHumain controleurHumain){
        int alea=(int)(Math.random()*100);
        if(alea<=maladie.getProbaGM()){
            maladie.GrosseMigraine(cible);
        }
        else if(alea>maladie.getProbaGM() && alea<=maladie.getProbaGM()+maladie.getProbaFT()){
            maladie.FievreTerrible(cible);            
        }
        else if(alea>maladie.getProbaFT() && alea<=maladie.getProbaFT()+maladie.getProbaCG()){
            maladie.CoupdeGrace(cible);
        } 
        else if(alea>maladie.getProbaCG() && alea<=maladie.getProbaCG()+maladie.getProbaMV()){
            maladie.MauxdeVentre(cible);
            
        }
        else if(alea%10==0 && cible.getNiveau()>1){
            maladie.setMute(true);
            System.out.println("Le virus a muté..toutes vos actions seront innoffenssives tant que");
            System.out.println("vous n'aurez pas trouver la nouvelle forme du virus...Vous avez donc");
            System.out.println("besoin d'un spécialiste!");
            controleurHumain.PayementObligatoire(niveau*10,maladie);  
        }
        else
        {
            maladie.GrosseMigraine(cible);
        }
    }
    
    //Tout les getter
    public Maladie getMaladie(){
        return maladie;
    }

}