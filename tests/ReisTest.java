import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class ReisTest {
    private Stap begin;
    private Stap eind;
    private int prijs;
    private PriorityQueue<Stap> unsettled = new PriorityQueue<>(Compareable.nodeCompareator);
    // opslag van alle daadwerkelijk bezochte nodes, die pas gevuld is aan het einde van de reis.
    private ArrayList<Stap> route = new ArrayList<>();
    ArrayList<Stap> goedkoopsteroute = new ArrayList<>();
    private ArrayList<Stap> alleNodes = new ArrayList<>();
    Stap a = new Rit("a");
    Stap b = new Rit("b");
    Stap c = new Rit("c");


    @Before
    void setup() throws Exception {
        alleNodes.addAll(Arrays.asList(a,b,c));
        begin = a;
        eind = b;
        // a -> b is minder goedkoop dan a -> c -> b
        Main.addWederzijdseConnectie(a,b,10);
        Main.addWederzijdseConnectie(a,c,1);
        Main.addWederzijdseConnectie(c,b,1);

    }

    @Test
    void DijkstraAlgoritmeTest() throws Exception {
        setup();
        Graaf graaf = new Graaf(alleNodes,a,b);
        graaf.PrintRoute();
//        assertEquals(graaf.reis.goedkoopsteroute.get(1),c);

    }
}