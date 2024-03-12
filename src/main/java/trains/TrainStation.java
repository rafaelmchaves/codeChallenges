package trains;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays that represent the arrival and departure times of trains that stop.
 */
public class TrainStation {

    //O(nˆ2)
    static int countMinimumPlatform(int[] arrive, int[] depart) {

        int platformsCount = 0;

        for (int i = 0; i < depart.length; i++) {
            int auxCount = 0;
            for (int j = 0; j < arrive.length; j++) {
                if (arrive[j] <= depart[i] && depart[j] >= depart[i]) {
                    auxCount += 1;
                }
            }
            platformsCount = Math.max(platformsCount, auxCount);

        }

        return platformsCount;
    }


    //O(n)
    public static int findPlatformOptimized(int[] arr, int[] dep, int n)
    {
        int count = 0, maxPlatforms = 0;
        // Find the maximum departure time
        int maxDepartureTime = dep[0];
        for (int i = 1; i < n; i++) {
            maxDepartureTime = Math.max(maxDepartureTime, dep[i]);
        }

        // Create a vector to store the count of trains at each time
        List<Integer> v = new ArrayList<>(maxDepartureTime + 2);
        for (int i = 0; i < maxDepartureTime + 2; i++) {
            v.add(0);
        }

        // Increment the count at the arrival time and decrement at the departure time
        for (int i = 0; i < n; i++) {
            v.set(arr[i], v.get(arr[i]) + 1);
            v.set(dep[i] + 1, v.get(dep[i] + 1) - 1);
        }

        // Iterate over the vector and keep track of the maximum sum seen so far
        for (int i = 0; i <= maxDepartureTime + 1; i++) {
            count += v.get(i);
            maxPlatforms = Math.max(maxPlatforms, count);
        }

        return maxPlatforms;
    }


    //auxCount = 2
    //platformsCount = 3

    public static void main(String[] args) {
        int[] arrive = new int[] {900, 940, 950, 1100, 1500, 1800};
        int[] depart = new int[] {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(countMinimumPlatform(arrive, depart));

        System.out.println(findPlatformOptimized(arrive, depart, arrive.length));
    }
}
