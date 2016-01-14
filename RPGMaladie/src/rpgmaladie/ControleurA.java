package rpgmaladie;

public class ControleurA extends Controleur {
    //Le controleurA est créer a la création de chaque nouvelle maladie donc il
    //a un niveau fixe des sa construction. j'ai fait la methode genereAttaque()+
    //le cas de mutation dont on avait parler!
    
    
    private final int niveau;
    private Maladie maladie;
    
    public ControleurA(String nomm,int niveau){
        this.niveau=niveau;
        this.maladie = new Maladie(nomm,niveau);
        maladie.initCarac(niveau);
        
    }
    
    
    
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
        else if(alea%10==0){
            maladie.setMute(true);
            System.out.println("Le virus a muté..toutes vos actions seront innoffenssives tant que");
            System.out.println("vous n'aurez pas trouver la nouvelle forme du virus...Vous avez donc");
            System.out.println("besoin d'un spécialiste!");
            controleurHumain.PayementObligatoire(niveau*100,maladie);
            
                    
            
        }
    }
    
    public Maladie getMaladie(){
        return maladie;
    }
    
    
    
}