package bribe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BribeTest {

    @Test
    public void minimumBribe_21534_return3() {

        final var list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(4);
        var result = Bribe.minimumBribes(list);
        Assertions.assertEquals("3", result);
    }

    @Test
    public void minimumBribe_12537864_return7() {

        final var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(6);
        list.add(4);
        var result = Bribe.minimumBribes(list);
        Assertions.assertEquals("7", result);
    }

    @Test
    public void minimumBribe_25134_returnTooChaotic() {

        final var list = new ArrayList<Integer>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(4);
        var result = Bribe.minimumBribes(list);
        Assertions.assertEquals("Too chaotic", result);
    }

}
