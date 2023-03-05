package examples;

import builtinexceptions.SimpleTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * this is an example of writing tests with JUnit5
 * More information at:
 * <a href="https://howtodoinjava.com/junit-5-tutorial">JUnit tutorial</a>
 * to run the tests, right click on the tests folder and select "Run all tests"
 *
 * @author solangekarsenty
 */
class SimpleTimeTest {
    SimpleTime s;

    /**
     * this method is called before each test
     * it is used to initialize the objects to test
     */
    @BeforeEach
    void setUp() {
        s = new SimpleTime(2, 30, 40);
    }

    /**
     * this method is called after each test
     * it is used to clean up the objects to test
     */
    @AfterEach
    void tearDown() {
    }

    @Test
    void testCtor() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SimpleTime(2, 60, 30));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SimpleTime(-1, 30, 30));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SimpleTime(5, 30, 466));
    }

    @Test
    void testValidValues() {
        assertEquals(2, s.getHour());
        assertEquals(30, s.getMinute());
        assertEquals(40, s.getSecond());
    }

    @Test
    void testModifiedValues() {
        s.setTime(12,13,14);
        assertEquals(12, s.getHour());
        assertEquals(13, s.getMinute());
        assertEquals(14, s.getSecond());
    }

    @Test
    void testInvalidValues() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> s.setHour(24));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> s.setMinute(60));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> s.setSecond(60));
    }

    @Test
    void testInvalidModifiedValues() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> s.setTime(24, 5, 30));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> s.setTime(4, 60, 30));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> s.setTime(5, 5, 60));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> s.setTime(24, 60, 60));
    }
}