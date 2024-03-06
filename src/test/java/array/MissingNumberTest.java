package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumberTest {

    @Test
    void test_number5Missed_withoutTempArray() {

        int[] array = {1,2,4,6,3,7,8};
        Assertions.assertEquals(5, MissingNumber.findWithoutTempArray(array, 8));

    }
    @Test
    void test_number11Missed_withoutTempArray() {

        int[] array = {1,2,4,6,3,7,8,12, 14,9, 13,5, 10};
        Assertions.assertEquals(11, MissingNumber.findWithoutTempArray(array, 14));

    }
    @Test
    void test_NoneNumberMissed() {

        int[] array = {1,2,4,6,3,7,8,12, 14,9, 13,5, 10, 11};
        Assertions.assertEquals(0, MissingNumber.find(array, 14));

    }

    @Test
    void test_number5Missed() {

        int[] array = {1,2,4,6,3,7,8};
        Assertions.assertEquals(5, MissingNumber.find(array, 8));

    }
    @Test
    void test_number11Missed() {

        int[] array = {1,2,4,6,3,7,8,12, 14,9, 13,5, 10};
        Assertions.assertEquals(11, MissingNumber.find(array, 14));

    }
    @Test
    void test_NoneNumberMissed_withoutTempArray() {

        int[] array = {1,2,4,6,3,7,8,12, 14,9, 13,5, 10, 11};
        Assertions.assertEquals(0, MissingNumber.findWithoutTempArray(array, 14));

    }
}
