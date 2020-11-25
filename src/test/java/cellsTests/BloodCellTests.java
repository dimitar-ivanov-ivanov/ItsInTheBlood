package cellsTests;

import com.company.models.cells.BloodCell;
import com.company.models.cells.RedBloodCell;
import com.company.models.microbes.Microbe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BloodCellTests {

    private final String ID = "ABB1B";
    private final int HEALTH = 50;
    private final int ROW = 10;
    private final int COL = 10;

    private final int MICROBE_HEALTH = 25;
    private final int MICROBE_ROW = 17;
    private final int MICROBE_COL = 17;
    private final int MICROBE_VIRULENCE = 5;

    private BloodCell bloodCell;
    private Microbe microbe;

    @Before
    public void setUp() {
        bloodCell = new BloodCell(ID, HEALTH, ROW, COL) {
        };
        microbe = new Microbe(ID, MICROBE_HEALTH, MICROBE_ROW, MICROBE_COL, MICROBE_VIRULENCE) {
        };
    }

    @Test
    public void testFightingChangeDimensions() {
        bloodCell.fight(microbe);

        Assert.assertEquals("Wrong row value!", MICROBE_ROW, bloodCell.getPositionRow());
        Assert.assertEquals("Wrong col value!", MICROBE_COL, bloodCell.getPositionCol());
    }


    @Test
    public void testFightingAssimilateOtherCell() {
        bloodCell.fight(microbe);

        Assert.assertEquals("Wrong health value!", HEALTH + MICROBE_HEALTH, bloodCell.getHealth());
    }

    @Test
    public void testBloodCellHasLowerHealthAfterBeingHit() {
        microbe.fight(bloodCell);

        Assert.assertEquals("Wrong health value for blood cell after attack!",
                HEALTH - (MICROBE_HEALTH + MICROBE_VIRULENCE),
                bloodCell.getHealth());
    }

    @Test
    public void testBloodCellSurvivesAttackAndStartsAttacking() {
        microbe.fight(bloodCell);
        bloodCell.fight(microbe);

        int bloodCellHealthAfterFight = HEALTH - MICROBE_HEALTH - MICROBE_VIRULENCE;
        int microbeHealthAfterFight = MICROBE_HEALTH - bloodCellHealthAfterFight;
        Assert.assertEquals("Wrong health value for microbe after attack!", microbeHealthAfterFight,
                microbe.getHealth());
    }
}
