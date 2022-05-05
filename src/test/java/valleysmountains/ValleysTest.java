package valleysmountains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValleysTest {

    @Test
    public void countingValleys_UDDDUDUU_1valley() {

        int valleysCount = Valleys.countingValleys(8, "UDDDUDUU");

        Assertions.assertEquals(1, valleysCount);
    }

    @Test
    public void countingValleys_UDDDUDUUDDUU_2valley() {

        int valleysCount = Valleys.countingValleys(12, "UDDDUDUUDDUU");

        Assertions.assertEquals(2, valleysCount);
    }

    @Test
    public void countingValleys_null_0valley() {

        int valleysCount = Valleys.countingValleys(1, null);

        Assertions.assertEquals(0, valleysCount);
    }

    @Test
    public void countingValleys_empty_0valley() {

        int valleysCount = Valleys.countingValleys(1, "");

        Assertions.assertEquals(0, valleysCount);
    }

    @Test
    public void countingValleys_0steps_0valley() {

        int valleysCount = Valleys.countingValleys(0, "U");

        Assertions.assertEquals(0, valleysCount);
    }
}
