package cellsTests;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidSizeException;
import com.company.exceptions.fieldsExceptions.InvalidVelocityException;
import com.company.models.cells.RedBloodCell;
import com.company.models.cells.WhiteBloodCell;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WhiteBloodCellTests {

    private final String ID = "ABB1B";
    private final int HEALTH = 50;
    private final int ROW = 10;
    private final int COL = 10;

    private final int TOO_SMALL_SIZE = InputDataRestrictions.MIN_SIZE - 1;
    private final int TOO_BIG_SIZE = InputDataRestrictions.MAX_SIZE + 1;
    private final int CORRECT_SIZE = InputDataRestrictions.MAX_SIZE / 2;

    WhiteBloodCell whiteBloodCell;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testShouldThrowExceptionWhenSizeTooSmall() {
        expectedException.expect(InvalidSizeException.class);
        expectedException.expectMessage(new InvalidSizeException().getMessage());
        whiteBloodCell = new WhiteBloodCell(ID, HEALTH, ROW, COL, TOO_SMALL_SIZE);
    }

    @Test
    public void testShouldThrowExceptionWhenSizeTooBig() {
        expectedException.expect(InvalidSizeException.class);
        expectedException.expectMessage(new InvalidSizeException().getMessage());
        whiteBloodCell = new WhiteBloodCell(ID, HEALTH, ROW, COL, TOO_BIG_SIZE);
    }

    @Test
    public void testGetEnergy() {
        whiteBloodCell = new WhiteBloodCell(ID, HEALTH, ROW, COL, CORRECT_SIZE);

        Assert.assertEquals("Wrong value for energy!",
                (HEALTH + CORRECT_SIZE) * 2,
                whiteBloodCell.getEnergy());
    }
}
