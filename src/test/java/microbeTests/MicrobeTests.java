package microbeTests;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidVirulenceException;
import com.company.models.cells.BloodCell;
import com.company.models.microbes.Microbe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MicrobeTests {

    private final String ID = "ABB1B";
    private final int HEALTH = 50;
    private final int ROW = 10;
    private final int COL = 10;
    private final int VIRULENCE = 5;

    private final int BLOOD_CELL_HEALTH = 25;
    private final int BLOOD_CELL_ROW = 17;
    private final int BLOOD_CELL_COL = 17;

    private Microbe microbe;
    private BloodCell bloodCell;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        bloodCell = new BloodCell(ID, BLOOD_CELL_HEALTH, BLOOD_CELL_ROW, BLOOD_CELL_COL) {
        };
        microbe = new Microbe(ID, HEALTH, ROW, COL, VIRULENCE) {
        };
    }

    @Test
    public void testShouldThrowExceptionForInvalidVirulence() {
        expectedException.expect(InvalidVirulenceException.class);
        expectedException.expectMessage(new InvalidVirulenceException().getMessage());

        Microbe microbe1 = new Microbe(ID, HEALTH, ROW, COL, InputDataRestrictions.MAX_VIRULENCE + 1) {
        };
    }

    @Test
    public void testGetEnergy() {

        Assert.assertEquals("Wrong energy.", HEALTH + VIRULENCE, microbe.getEnergy());
    }

    @Test
    public void testFightingChangeDimensions() {
        microbe.fight(bloodCell);

        Assert.assertEquals("Wrong row value!", BLOOD_CELL_ROW, bloodCell.getPositionRow());
        Assert.assertEquals("Wrong col value!", BLOOD_CELL_COL, bloodCell.getPositionCol());
    }

    @Test
    public void testFightingBloodCellShouldLowerHealth() {
        microbe.fight(bloodCell);

        int expectedBloodCellHealth = BLOOD_CELL_HEALTH - microbe.getEnergy();
        Assert.assertEquals("Blood cell health wasn't lowered correctly.", expectedBloodCellHealth,
                bloodCell.getHealth());
    }
}
