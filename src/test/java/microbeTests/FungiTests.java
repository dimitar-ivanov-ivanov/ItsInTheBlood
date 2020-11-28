package microbeTests;

import com.company.models.microbes.Bacteria;
import com.company.models.microbes.Fungi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FungiTests {

    private final String ID = "ABB1B";
    private final int HEALTH = 50;
    private final int ROW = 10;
    private final int COL = 10;
    private final int VIRULENCE = 5;

    private Fungi fungi;

    @Before
    public void setUp() {
        fungi = new Fungi(ID, HEALTH, ROW, COL, VIRULENCE) {
        };
    }

    @Test
    public void testGetEnergy() {

        int expectedEnergy = (HEALTH + VIRULENCE) / 4;
        Assert.assertEquals("Wrong energy", expectedEnergy, fungi.getEnergy());
    }
}
