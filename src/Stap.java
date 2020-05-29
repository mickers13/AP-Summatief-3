import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class Stap {
    // in deze verschillende stappen vind ik stap een onduidelijke naam, ik zelf vind node of locatie duidelijker, dit is hoe ik deze classe dus ook ga gebruiken. Dit zijn alle "locaties" waar we heen kunnen.
    // alleen houd ik het voor nu de classe naam als Stap. IPV node.
    private int tempShortestDistance = 99999999;// dit is gewoon een erg hoog getal, laten we dit beschouwen als oneindig.
    private static int aantalNodes;
    private static ArrayList<Stap> nodesList = new ArrayList<>();
    private Stap Lastnode = null;

    public void addNode(Stap stap){
        //een method die gerunned moet worden elke keer dat een node aangemaakt word.
        aantalNodes++;
        nodesList.add(stap);
    }

    public abstract Set getNeighbours();

    public static int getAantalNodes() { // bugfix tool, checken of alle nodes goed gemaakt zijn door te kijken hoeveel het er zijn op een nettemanier.
        return aantalNodes;
    }

    public abstract void addConnectie(Stap connectie,int distance);

    public int getTempShortestDistance() {
        return tempShortestDistance;
    }
    public abstract HashMap<Stap, Double> getConnecties();

    public void setTempShortestDistance(int tempShortestDistance) {
        this.tempShortestDistance = tempShortestDistance;
    }

    public ArrayList<Stap> getNodesListCopy() {
        // return a copy of nodes list, as name dictates.
        return new ArrayList<>(nodesList);
    }

    public Stap getLastnode() {
        return Lastnode;
    }

    public void setLastnode(Stap lastnode) {
        Lastnode = lastnode;
    }

    public abstract Double getDistance(Stap b);

    @Override
    public String toString() {
        return (this.getClass().getName() +"");
    }
}
