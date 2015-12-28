package rpgmaladie;

public abstract class Attaque implements Capacite {

	private final String nom;
        private final Effet effet;
        private int probaReussite;
        
        public Attaque (String nom, Effet effet){
            this.nom=nom;
            this.effet=effet;
        }

        /**
         *
         * @param src
         * @param cible
         * @return
         */
        @Override
        public Effet effet(Personnage src, Personnage cible){
            int newValeurAttaque = effet.getValeur() - cible.getDefence() + src.getForce();
            return (new Effet(Caracteristique.SANTE,-newValeurAttaque) );
        }
        
        @Override
        public boolean probaReussite(Personnage src){
            int varAlea=(int)(Math.random()*100);
            int chanceReussite=probaReussite+src.getDexterite()+src.getManiabilite();
            boolean action = (varAlea<chanceReussite);
            return action;
        }
}