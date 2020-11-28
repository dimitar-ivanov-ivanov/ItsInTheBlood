package microbeTests;

import com.company.models.microbes.Fungi;
import com.company.models.microbes.Virus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VirusTests {

    private final String ID = "ABB1B";
    private final int HEALTH = 50;
    private final int ROW = 10;
    private final int COL = 10;
    private final int VIRULENCE = 5;

    private Virus virus;

    @Before
    public void setUp() {
        virus = new Virus(ID, HEALTH, ROW, COL, VIRULENCE) {
        };
    }

    @Test
    public void testGetEnergy() {
        int expectedEnergy = HEALTH + VIRULENCE;
        Assert.assertEquals("Wrong energy", expectedEnergy, virus.getEnergy());
    }
}
