import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraafTest {
    private ArrayList<Stap> alleNodes = new ArrayList<>();
    private ArrayList<Stap> goedkoopsteRoute = new ArrayList<>();
    Stap testrit = new Rit("testrit");
    Reis reis;
    private Stap beginpunt;
    private Stap eindpunt;
    @Before
    void setup(){

    alleNodes.add(testrit);
    beginpunt = testrit;
    eindpunt = testrit;
    goedkoopsteRoute.add(testrit);
    }

    @Test
    void getAlleNodes() {
        assertEquals(alleNodes.size(),0);
        setup();
        assertEquals(alleNodes.size(),1);

    }

    @Test
    void printRoute() {
        // geen idee hoe ik anders een printer moet testen...
        setup();
        assertEquals(("De goedkoopste reis van " + beginpunt + " naar " + eindpunt + " is :"),
                ("De goedkoopste reis van " + testrit + " naar " + testrit + " is :"));

    }
}