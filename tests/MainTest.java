import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Stap testvlucht = new Vlucht("testvlucht");
    Stap testrit = new Rit("testrit");
    @Before
    void setup(){
        assertEquals(0,testvlucht.getConnecties().size());
    }

    @Test
    void addWederzijdseConnectie() {
        setup();
        Main.addWederzijdseConnectie(testvlucht,testrit,5);
        // test of 5*0.40+40 == the answer to Life, the Universe and Everything
        assertEquals(testvlucht.getConnecties().get(testrit),42);
    }
}