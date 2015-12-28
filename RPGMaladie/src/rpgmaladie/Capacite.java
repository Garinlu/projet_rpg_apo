package rpgmaladie;

public interface Capacite {


	Effet effet(Personnage src, Personnage cible);
        boolean probaReussite(Personnage src);

}