package telran.range;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class RangeTest {

    private static final int MIN = 50;
    private static final int MAX = 100;
    Range range = Range.getRange(MIN, MAX);

    @Test
    void wrongRangeCtreatingTest() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN));
    }

    @Test
    void rightNumberTest() throws Exception {
        range.checkNumber(55);
    }

    void wrongNumberTest() throws Exception {
        assertThrowsExactly(OutOfRangeMaxValueException.class,
                () -> range.checkNumber(MAX + 1));
        assertThrowsExactly(OutOfRangeMinValueException.class, () -> range.checkNumber(MIN - 1));
    }

    @Test
    void iteratorTest() {
        //TODO
        //different test cases
        Iterator<Integer> iterator = range.iterator();
        var a = MIN;
        while (iterator.hasNext()) {
            // assertTrue(a<=MAX);
            if (a > MAX) {
                fail();
            }
            assertEquals(a++, iterator.next());
        }
        range.setPredicate(x -> x % 2 == 0);
        if (MIN % 2 == 0) {
            a = MIN;
        } else {
            a = MIN + 1;
        }

        for (Integer x : range) {
            if (a > MAX) {
                fail();
            }
            assertEquals(a, x);
            a += 2;
        }

    }

}
