import java.util.HashMap;
import java.util.Set;

public class Rit extends Stap{
    private HashMap<Stap, Double> connecties = new HashMap<>();
    public Rit(){
        //add deze node aan de list van alle bestaande nodes, en voer uit wat uitgevoerd moet worden.
        addNode(this);
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
        return ((distance/19)*0.43);//return how many hours you have traveled.
    }


    public Set getNeighbours(){
        // return alle nodes waar deze node een connectie mee heeft.
        return connecties.keySet();
    }
}
