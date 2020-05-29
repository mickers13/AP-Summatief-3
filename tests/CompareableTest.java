import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class CompareableTest {
    private Stap a = new Vlucht("a");
    private Stap b = new Rit("b");
    private Stap c = new Treinrit("c");

    private PriorityQueue<Stap> testq = new PriorityQueue<>(Compareable.nodeCompareator);
    @Test
    void compareTest() {
        Main.addWederzijdseConnectie(a,b,3);
        Main.addWederzijdseConnectie(a,c,2);
        Main.addWederzijdseConnectie(b,c,4);
        testq.add(a);
        testq.add(b);
        testq.add(c);
        // de waardes moeten niet heel veel veranderen in prio, maar wel een beetje. Hierdoor is a niet weer de eerste.
        assertEquals(a,testq.poll());
        testq.add(a);
        assertEquals(b,testq.poll());
    }
}