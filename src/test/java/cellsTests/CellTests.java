package cellsTests;

import com.company.constants.InputDataRestrictions;
import com.company.exceptions.fieldsExceptions.InvalidHealthException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.messages.ExceptionMessages;
import com.company.models.Cell;
import com.company.models.cells.BloodCell;
import com.company.models.cells.RedBloodCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class CellTests {

    private final String ID = "AA1B";

    private final int TOO_LOW_HEALTH = InputDataRestrictions.MIN_HEALTH - 1;
    private final int TOO_HIGH_HEALTH = InputDataRestrictions.MAX_HEALTH + 1;
    private final int CORRECT_HEALTH = InputDataRestrictions.MAX_HEALTH / 2;

    private final int TOO_LOW_DIMENSION = InputDataRestrictions.MIN_DIMENSION - 1;
    private final int TOO_HIGH_DIMENSION = InputDataRestrictions.MAX_DIMENSION + 1;
    private final int CORRECT_DIMENSION = InputDataRestrictions.MAX_DIMENSION / 2;

    private final int CORRECT_ENERGY = CORRECT_HEALTH;

    private Cell cell;
    private Cell mockCell;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {
        mockCell = Mockito.mock(BloodCell.class, Mockito.CALLS_REAL_METHODS);

        Mockito.when(mockCell.getEnergy()).thenReturn(CORRECT_ENERGY);
        Mockito.when(mockCell.getHealth()).thenReturn(CORRECT_HEALTH);
        Mockito.when(mockCell.getPositionRow()).thenReturn(CORRECT_DIMENSION);
        Mockito.when(mockCell.getPositionCol()).thenReturn(CORRECT_DIMENSION);
    }

    @Test
    public void testShouldThrowExceptionWhenHealthTooLow() {
        expectedEx.expect(InvalidHealthException.class);
        expectedEx.expectMessage(new InvalidHealthException().getMessage());

        cell = new Cell(ID, TOO_LOW_HEALTH, CORRECT_DIMENSION, CORRECT_DIMENSION) {
        };
    }

    @Test
    public void testShouldThrowExceptionWhenHealthTooHigh() {
        expectedEx.expect(InvalidHealthException.class);
        expectedEx.expectMessage(new InvalidHealthException().getMessage());

        cell = new Cell(ID, TOO_HIGH_HEALTH, CORRECT_DIMENSION, CORRECT_DIMENSION) {
        };
    }

    @Test
    public void testShouldThrowExceptionWhenRowValueTooLow() {
        expectedEx.expect(InvalidRowException.class);
        expectedEx.expectMessage(new InvalidRowException().getMessage());

        cell = new Cell(ID, CORRECT_HEALTH, TOO_LOW_DIMENSION, CORRECT_DIMENSION) {
        };
    }

    @Test
    public void testShouldThrowExceptionWhenRowValueTooHigh() {
        expectedEx.expect(InvalidRowException.class);
        expectedEx.expectMessage(new InvalidRowException().getMessage());

        cell = new Cell(ID, CORRECT_HEALTH, TOO_HIGH_DIMENSION, CORRECT_DIMENSION) {
        };
    }

    @Test
    public void testShouldThrowExceptionWhenColumnValueTooLow() {
        expectedEx.expect(InvalidColumnException.class);
        expectedEx.expectMessage(new InvalidColumnException().getMessage());

        cell = new Cell(ID, CORRECT_HEALTH, CORRECT_DIMENSION, TOO_LOW_DIMENSION) {
        };
    }

    @Test
    public void testShouldThrowExceptionWhenColumnValueTooHigh() {
        expectedEx.expect(InvalidColumnException.class);
        expectedEx.expectMessage(new InvalidColumnException().getMessage());

        cell = new Cell(ID, CORRECT_HEALTH, CORRECT_DIMENSION, TOO_HIGH_DIMENSION) {
        };
    }

    @Test
    public void testGetEnergy() {
        Assert.assertEquals("Wrong energy value.", mockCell.getEnergy(), CORRECT_ENERGY);
    }

    @Test
    public void testGetHealth() {
        Assert.assertEquals("Wrong health value.", mockCell.getHealth(), CORRECT_HEALTH);
    }

    @Test
    public void testGetPositionRow() {
        Assert.assertEquals("Wrong row value.", mockCell.getPositionRow(), CORRECT_DIMENSION);
    }

    @Test
    public void testGetPositionCol() {
        Assert.assertEquals("Wrong col value.", mockCell.getPositionCol(), CORRECT_DIMENSION);
    }
}
