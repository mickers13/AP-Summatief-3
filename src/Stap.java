import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class Stap {
    // in deze verschillende stappen vind ik stap een onduidelijke naam, ik zelf vind node of locatie duidelijker, dit is hoe ik deze classe dus ook ga gebruiken. Dit zijn alle "locaties" waar we heen kunnen.
    // alleen houd ik het voor nu de classe naam als Stap. IPV node.
    private int tempShortestDistance = 99999999;// dit is gewoon een erg hoog getal, laten we dit beschouwen als oneindig.

    private Stap Lastnode = null;

    public abstract void addConnectie(Stap connectie,int distance);

    public int getTempShortestDistance() {
        return tempShortestDistance;
    }

    public abstract HashMap<Stap, Double> getConnecties();

    public void setTempShortestDistance(int tempShortestDistance) {
        this.tempShortestDistance = tempShortestDistance;
    }

    public Stap getLastnode() {
        return Lastnode;
    }

    public void setLastnode(Stap lastnode) {
        Lastnode = lastnode;
    }

    public abstract Double getDistance(Stap b);

    public abstract String getNaam();

    @Override
    public String toString() {

        String type = this.getClass().getName();


        return (this.getNaam());
    }
}
