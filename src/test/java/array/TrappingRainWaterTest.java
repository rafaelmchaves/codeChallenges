package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrappingRainWaterTest {

    @Test
    public void test_basic() {

        int[] array = {2,0,2};

        Assertions.assertEquals(2, TrappingRainWater.countTrappedWater(array));
    }

    @Test
    public void test() {

        int[] array = {1,0,2,1,0,1,3,2,1,2,1};

        Assertions.assertEquals(6, TrappingRainWater.countTrappedWater(array));
    }
}
