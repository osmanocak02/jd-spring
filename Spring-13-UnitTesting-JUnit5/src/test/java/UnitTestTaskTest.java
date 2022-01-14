import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestTaskTest {

    @Test
    void removePairs() {
        assertEquals("ABCDEF", UnitTestTask.removePairs());
    }
}