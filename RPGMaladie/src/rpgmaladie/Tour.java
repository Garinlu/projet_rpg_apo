package rpgmaladie;

public class Tour {
    public int numeroTour=1;
    
    
    
    public Tour(){
    }
    
    public void implementeTour(){
        numeroTour=numeroTour+1;
        System.out.println("Tour suivant");
    }
    
    public int getTour(){
        return numeroTour;
        
    }
    public void raz(){
        numeroTour=0;
    }
}