import java.util.HashMap;
import java.util.Set;

public class Treinrit extends Stap{
    private HashMap<Stap, Double> connecties = new HashMap<>();
    public Treinrit(){
        //add deze node aan de list van alle bestaande nodes, en voer uit wat uitgevoerd moet worden.
        addNode(this);
    }
    @Override
    public void addConnectie(Stap connectie, int distance) {
//        connecties.add(connectie);
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
        // this is the base "unit" of trains, what should be measured in cost in time (km/u).
        // I take distance as distance in kilometers what I divide by 100 what is the cost per kilometer for trains according to following source:
        // https://gemiddeldgezien.nl/gemiddelde-snelheid-trein
        // because of this, if a neighbour has a train station, it might be a very short drive by train.
        // I also add 5 as a "instap tarief." want instappen kost ook wat tijd met de trein.
        if (distance == 0){
            // even een division by zero voorkomen, sowieso als je geen afstand hoeft af te leggen, dan kan je beter niet in de trein stappen.
            return distance;
        }
        return (distance/100+20);//return how many hours you have traveled.
    }


    public Set getNeighbours(){
        // return alle nodes waar deze node een connectie mee heeft.
        return connecties.keySet();
    }

}
