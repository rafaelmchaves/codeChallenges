package bribe;

import java.util.HashMap;
import java.util.List;

public class Bribe {

    public static String minimumBribes(List<Integer> q) {

        var countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < q.size()-1; i++) {
            if (q.get(i) > q.get(i+1)) {
                var firstPosition = q.get(i);
                var secondPosition = q.get(i+1);
                q.set(i, secondPosition);
                q.set(i + 1, firstPosition);
                countMap.put(firstPosition, countMap.get(firstPosition) != null ? ((countMap.get(firstPosition)) + 1) : 1);
                i = 0;
            }
        }
//21534
        var isAnyoneBribeALot = countMap.values().stream().anyMatch(count -> count >= 3);
        if(isAnyoneBribeALot) {
            System.out.println("Too chaotic");
            return "Too chaotic";
        } else {
            var bribeCount = countMap.values().stream().reduce(Integer::sum);
            System.out.println(bribeCount.orElse(0));
            return String.valueOf(bribeCount.orElse(0));
        }

    }

}
