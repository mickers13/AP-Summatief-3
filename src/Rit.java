import java.util.HashMap;
import java.util.Set;

public class Rit extends Stap{
    private HashMap<Stap, Double> connecties = new HashMap<>();
    private String naam;
    public Rit(String naam){
        this.naam = naam;
    }
    @Override
    public void addConnectie(Stap connectie, int distance) {
        Double afstandkosten = calculateRatio(distance);
        connecties.put(connectie,afstandkosten);
    }

    public HashMap<Stap, Double> getConnecties(){
        return new HashMap<>(connecties);
    }

    public Double getDistance(Stap connectie){
        // returns the distance to a node from this one, if no connection is found return 100000.
        if (connecties.containsKey(connectie)){
            return connecties.get(connectie);
        }else{
            // ik moet íets returnen, dus ik return een hoog getal, wat dus nooit de snelste route zal zijn( aangezien het niet kan ).
            // ik had de if statement ook kunnen verwijderen, maar dat kan voor undefined behaviour zorgen, dus dit vind ik mooier, dan is het tenminste soortvan afgevangen.
            return 100000.0;
        }
    }
    public double calculateRatio(int distance){
        // My base units are KM, dan kijk ik naar prijs per km voor een auto die 1/19 rijd, en weet ik de prijs.
        if (distance == 0){
            // even een division by zero voorkomen, sowieso als je geen afstand hoeft af te leggen, dan kan je beter niet in de trein stappen.
            return distance;
        }
        return (distance);
    }
    @Override
    public String getNaam() {
        return naam;
    }


    public Set getNeighbours(){
        // return alle nodes waar deze node een connectie mee heeft.
        return connecties.keySet();
    }
}
