import java.util.ArrayList;

public class Graaf {
    private ArrayList<Stap> alleNodes = new ArrayList<>();
    private ArrayList<Stap> goedkoopsteRoute = new ArrayList<>();
    Reis reis;
    private Stap beginpunt;
    private Stap eindpunt;

    public Graaf(ArrayList<Stap> alleNodes,Stap beginpunt, Stap eindpunt){
        //een graaf houd rekening met een reis, want hij gaat berekenen vanaf de begin node berekenen wat alle afstanden zijn.
        this.beginpunt = beginpunt;
        this.eindpunt = eindpunt;
        if(alleNodes.contains(beginpunt)&&alleNodes.contains(eindpunt))
        this.reis = new Reis(this,beginpunt,eindpunt);
        this.alleNodes = alleNodes;
        goedkoopsteRoute = reis.getGoedkoopsteroute();

     }


    public ArrayList<Stap> getAlleNodes() {
        return alleNodes;
    }

    public void PrintRoute() {
        System.out.println("------------------------------------");
        System.out.println("De goedkoopste reis van " + beginpunt + " naar " + eindpunt + " is :");
        for (Stap index : goedkoopsteRoute) {
            System.out.println(index.toString());
        }
        System.out.println("En dit heeft €"+reis.getPrijs()+",- gekost.");
        System.out.println("------------------------------------");
    }
}
