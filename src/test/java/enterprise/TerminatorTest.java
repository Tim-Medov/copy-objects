
package enterprise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class TerminatorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getModel() throws NoSuchFieldException, IllegalAccessException {

        // given
        Terminator terminator = new Terminator("n/a", 0);
        Field model = terminator.getClass().getDeclaredField("model");
        model.setAccessible(true);
        model.set(terminator, "T-800");

        // when
        String result = terminator.getModel();

        // then
        assertEquals("T-800", result);
    }

    @Test
    void setModel() throws NoSuchFieldException, IllegalAccessException {

        // given
        Terminator terminator = new Terminator("n/a", 0);

        // when
        terminator.setModel("T-800");

        // then
        Field model = terminator.getClass().getDeclaredField("model");
        model.setAccessible(true);
        assertEquals("T-800", model.get(terminator));
    }

    @Test
    void getDamage() throws NoSuchFieldException, IllegalAccessException {

        // given
        Terminator terminator = new Terminator("n/a", 0);
        Field damage = terminator.getClass().getDeclaredField("damage");
        damage.setAccessible(true);
        damage.set(terminator, 100);

        // when
        int result = terminator.getDamage();

        // then
        assertEquals(100, result);
    }

    @Test
    void setDamage() throws NoSuchFieldException, IllegalAccessException {

        // given
        Terminator terminator = new Terminator("n/a", 0);

        // when
        terminator.setDamage(100);

        // then
        Field damage = terminator.getClass().getDeclaredField("damage");
        damage.setAccessible(true);
        assertEquals(100, damage.get(terminator));
    }

    @Test
    void copy() {

        // given
        Terminator prototype = new Terminator("T-800", 100);

        // when
        Terminator copy = prototype.copy();

        // then
        assertNotSame(prototype, copy);
        assertEquals(prototype.getModel(), copy.getModel());
        assertEquals(prototype.getDamage(), copy.getDamage());
    }

    @Test
    void print() {

        // given
        Terminator terminator = new Terminator("T-800", 100);

        // when
        terminator.print();

        // then
        assertEquals("Model: T-800 Damage: 100%", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {

        System.setOut(standardOut);
    }
}
