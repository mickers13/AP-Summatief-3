import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Stap testvlucht = new Vlucht("testvlucht");
    Stap testrit = new Rit("testrit");
    @Before
    void setup(){
        
    }

    @Test
    void addWederzijdseConnectie() {
        addWederzijdseConnectie();
    }
}