package sockmerchant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockMerchant {
    public static int sockMerchant(int n, List<Integer> ar) {

        if (ar == null || ar.isEmpty()) {
            return 0;
        }

        final var colorMap = createColorMap(ar);

        return colorMap.values().stream()
                .filter(SockMerchant::isThereOnePair)
                .map(integer -> integer / 2)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static Map<Integer, Integer> createColorMap(List<Integer> ar) {

        final var mapColorCount = new HashMap<Integer, Integer>();

        ar.forEach(color -> {
            if (mapColorCount.containsKey(color)) {
                mapColorCount.put(color, mapColorCount.get(color) + 1);
            } else {
                mapColorCount.put(color, 1);
            }
        });

        return mapColorCount;
    }

    private static boolean isThereOnePair(Integer value) {
        return value > 1;
    }
}
