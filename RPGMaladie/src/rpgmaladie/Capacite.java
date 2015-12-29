package rpgmaladie;

public abstract class Capacite {
    private final String nomCapacite;
    private final Effet effet;
    private final int probaReussite;
    
    public Capacite(String nom, Effet effet, int proba){
        this.nomCapacite=nom;
        this.effet=effet;
        this.probaReussite=proba;
    }
    


}