package cellsTests;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidVelocityException;
import com.company.models.cells.BloodCell;
import com.company.models.cells.RedBloodCell;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RedBloodCellTests {

    private final String ID = "ABB1B";
    private final int HEALTH = 50;
    private final int ROW = 10;
    private final int COL = 10;

    private final int TOO_LOW_VELOCITY = InputDataRestrictions.MIN_VELOCITY - 1;
    private final int TOO_HIGH_VELOCITY = InputDataRestrictions.MAX_VELOCITY + 1;
    private final int CORRECT_VELOCITY = InputDataRestrictions.MAX_VELOCITY / 2;

    RedBloodCell redBloodCell;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testShouldThrowExceptionWhenVelocityTooLow() {
        expectedException.expect(InvalidVelocityException.class);
        expectedException.expectMessage(new InvalidVelocityException().getMessage());
        redBloodCell = new RedBloodCell(ID, HEALTH, ROW, COL, TOO_HIGH_VELOCITY);
    }
}
