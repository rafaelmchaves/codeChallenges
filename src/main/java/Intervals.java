import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Intervals {

	public static void main(String[] args) {

		int[][] intervals = new int[][]{{15, 18}, {1, 3}, {8, 10}, {2, 6}};

		// first thing: sort the array by the first number of interval O(log n)
		//{1, 3}, {2, 6}  {8, 10} {15, 18}

		//second thing: create a new interval list with the first interval
		//newIntervalList: {1, 3}

		// third thing: compare if it has overlapping
		//if interval[1][0] <= newIntervalList[0,1] && interval[1][1] > newIntervalList[0,1]
		// newIntervalList[0, 1] = interval[1][1]
		//else
		// newIntervalList.add(interval[1])

		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

		List<int[]> newIntervalList = new ArrayList<>();
		newIntervalList.add(intervals[0]);

		int[] newInterval = newIntervalList.get(0);

		for (int[] interval: intervals) {
			if ( interval[0] <= newInterval[1] && interval[1] >= newInterval[1]) {
				newInterval[1] = interval[1];
			} else {
				newIntervalList.add(interval);
				newInterval = interval;
			}
		}

		//final var result = merge(intervals);

		for (int[] ints : newIntervalList) {
			System.out.println(Arrays.toString(ints));
		}
	}
	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

}
