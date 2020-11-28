import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidColumnException;
import com.company.exceptions.fieldsExceptions.dimensionExceptions.InvalidRowException;
import com.company.models.Cluster;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.testng.annotations.Test;

public class ClusterTests {

    private final String ID = "ABB15B";
    private final int ROWS = 15;
    private final int COLS = 15;
    private final int INVALID_DIMENSION = -1;


    private Cluster cluster;

    @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        cluster = new Cluster(ID, ROWS, COLS);
    }

    @Test
    public void testPassingInvalidRowShouldThrowException() {
        expectedException.expect(InvalidRowException.class);
        expectedException.expectMessage(new InvalidRowException().getMessage());

        cluster = new Cluster(ID, INVALID_DIMENSION, COLS);
    }

    @Test
    public void testPassingInvalidColShouldThrowException() {
        expectedException.expect(InvalidColumnException.class);
        expectedException.expectMessage(new InvalidColumnException().getMessage());

        cluster = new Cluster(ID, ROWS, INVALID_DIMENSION);
    }



}
