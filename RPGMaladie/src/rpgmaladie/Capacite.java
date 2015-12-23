package rpgmaladie;

public interface Capacite {


	Effet[] effet(Personnage src, Personnage cible);


	double probaReussite(Personnage src);

}