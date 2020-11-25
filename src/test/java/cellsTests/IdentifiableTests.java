package cellsTests;

import com.company.exceptions.fieldsExceptions.InvalidIdException;
import com.company.messages.ExceptionMessages;
import com.company.models.IdentifiableImpl;
import com.company.models.interfaces.Identifiable;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;

public class IdentifiableTests {

    private final String BAD_ID_FIRST = "aA1";
    private final String BAD_ID_SECOND = "aA_";
    private final String BAD_ID_THIRD = "1A1";
    private final String BAD_ID_FOURTH = "A_1";

    private String[] badIds = {BAD_ID_FIRST, BAD_ID_SECOND, BAD_ID_THIRD, BAD_ID_FOURTH};
    private final String GOOD_ID = "Aa9A";

    Identifiable identifiable;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsInvalidIDExceptionWhenPassedInvalidIds() {
        for (int i = 0; i < badIds.length; i++) {
            expectedException.expect(InvalidIdException.class);
            expectedException.expectMessage(ExceptionMessages.INVALID_ID_MESSAGE);
            Identifiable identifiable = new IdentifiableImpl(badIds[i]) {
            };
        }
    }

    @Test
    public void testGetValidId() throws NoSuchFieldException, IllegalAccessException {
        Identifiable identifiable = new IdentifiableImpl(GOOD_ID) {
        };
        Field idField = IdentifiableImpl.class.getDeclaredField("id");
        Assert.assertEquals("Wrong id was passed!", identifiable.getId(), GOOD_ID);
    }
}
