package rpgmaladie;

public class Attaque extends Capacite {
    private Effet effet;
    private int probaReussite;
    

        
        public Attaque (String nom, Effet effet,int proba){
            super(nom,effet,proba);
        }
        public Effet effet(Personnage src){ //je comprends pas trop, je suis pas sur qu'on puisse 
            //construire dans une autre classe en dehors d'un constructeur
            int newValeurAttaque = effet.getValeur() + src.getForce();
            return (new Effet(Caracteristique.SANTE,-newValeurAttaque) );
        }
        
        
        public boolean probaReussite(Personnage src){
            int varAlea=(int)(Math.random()*100);
            int chanceReussite=probaReussite+src.getDexterite()+src.getManiabilite();
            boolean action = (varAlea<chanceReussite);
            return action;
        }
}