package microbeTests;

import com.company.models.cells.BloodCell;
import com.company.models.microbes.Bacteria;
import com.company.models.microbes.Microbe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BacteriaTests {

    private final String ID = "ABB1B";
    private final int HEALTH = 50;
    private final int ROW = 10;
    private final int COL = 10;
    private final int VIRULENCE = 5;

    private Bacteria bacteria;

    @Before
    public void setUp() {
        bacteria = new Bacteria(ID, HEALTH, ROW, COL, VIRULENCE) {
        };
    }

    @Test
    public void testGetEnergy() {

        int expectedEnergy = (HEALTH + VIRULENCE) / 3;
        Assert.assertEquals("Wrong energy", expectedEnergy, bacteria.getEnergy());
    }
}
