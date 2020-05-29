import java.util.HashMap;
import java.util.Set;

public class Vlucht extends Stap{
//    private ArrayList<Stap> connecties = new ArrayList<>();
    private HashMap<Stap, Double> connecties = new HashMap<>();
    private String naam;
    Double afstandkosten = 999999999.0;
    public Vlucht(String naam){
        this.naam = naam;
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
        // returns the distance to a node from this one.
        return connecties.get(connectie);

    }
    public double calculateRatio(int distance){
        // this is the base "unit" of flights, what should be measured in cost in euros.
        // I take distance as distance in kilometers what I multiply by 0.40 what is the cost per kilometer for KLM according to following source:
        // https://www.luchtvaartnieuws.nl/nieuws/categorie/2/airlines/klm-per-kilometer-twee-keer-zo-duur-als-emirates
        // because of this, if a neighbour or endnode has an airport, flying will almost always be cheap.
        return ((distance*0.40)+40);
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
