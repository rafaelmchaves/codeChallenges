package sockmerchant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SockMerchantTest {

    @Test
    public void sockMerchant_10socks_3Pairs() {

        int n = 10;
        List<Integer> sockList = new ArrayList<>(Arrays.asList(1,2,1,2,3,3,4,5,6,7));
        int result = SockMerchant.sockMerchant(n, sockList);

        Assertions.assertEquals(3, result);
    }

    @Test
    public void sockMerchant_10socks_0Pairs() {

        int n = 10;
        List<Integer> sockList = new ArrayList<>(Arrays.asList(9,2,8,12,3,13,4,5,6,7));
        int result = SockMerchant.sockMerchant(n, sockList);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void sockMerchant_10socks_5Pairs() {

        int n = 10;
        List<Integer> sockList = new ArrayList<>(Arrays.asList(1,4,5,3,3,2,4,5,2,1));
        int result = SockMerchant.sockMerchant(n, sockList);

        Assertions.assertEquals(5, result);
    }

    @Test
    public void sockMerchant_10socksandColor3Repeated3Times_4Pairs() {

        int n = 10;
        List<Integer> sockList = new ArrayList<>(Arrays.asList(1,4,3,3,3,2,4,5,2,1));
        int result = SockMerchant.sockMerchant(n, sockList);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void sockMerchant_10socksandColor4Repeated3Times_3Pairs() {

        int n = 10;
        List<Integer> sockList = new ArrayList<>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));
        int result = SockMerchant.sockMerchant(n, sockList);

        Assertions.assertEquals(3, result);
    }

    @Test
    public void sockMerchant_emptyList_0Pairs() {

        int n = 0;
        int result = SockMerchant.sockMerchant(n, new ArrayList<>());

        Assertions.assertEquals(0, result);
    }

    @Test
    public void sockMerchant_nullList_0Pairs() {

        int n = 0;
        int result = SockMerchant.sockMerchant(n, null);

        Assertions.assertEquals(0, result);
    }
}
