import java.util.HashMap;
import java.util.Set;

public class Vlucht extends Stap{
//    private ArrayList<Stap> connecties = new ArrayList<>();
    private HashMap<Stap, Double> connecties = new HashMap<>();
    public Vlucht(){
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
        // this is the base "unit" of flights, what should be measured in cost in euros.
        // I take distance as distance in kilometers what I multiply by 0.20 what is the cost per kilometer for KLM according to following source:
        // https://www.luchtvaartnieuws.nl/nieuws/categorie/2/airlines/klm-per-kilometer-twee-keer-zo-duur-als-emirates
        // because of this, if a neighbour or endnode has an airport, flying will almost always be cheap.
        return ((distance*0.20)+5);
    }


    public Set getNeighbours(){
        // return alle nodes waar deze node een connectie mee heeft.
        return connecties.keySet();
    }

}
