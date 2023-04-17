package sushinori.scheduler;

import java.util.*;
import java.util.stream.Collectors;

public class ChefScheduler {

    private static final List<String> DAYS = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");
    private static final int MAX_WORK_DAYS = 5;

    private static final int MAX_WORKERS_PER_DAY = 2;

    public static boolean schedulable(
            HashMap<String, ArrayList<String>> requests
    ) {

        final HashMap<String,ArrayList<String>> weeklySchedule = new HashMap<>();

        for (String day: DAYS) {
            weeklySchedule.put(day, new ArrayList<>());
            final var avaliableChefList = getAvalaibleChefsByDay(requests, day);

            for (String chefsAvailable: avaliableChefList) {
                    if (weeklySchedule.get(day).size() < MAX_WORKERS_PER_DAY) {
                        final var daysWorkedSoFar = getDaysWorked(weeklySchedule, chefsAvailable);
                        if (daysWorkedSoFar < MAX_WORK_DAYS) {
                            weeklySchedule.get(day).add(chefsAvailable);
                        }

                    }

                }
        }

        for (Map.Entry<String, ArrayList<String>> schedule: weeklySchedule.entrySet()) {
            System.out.println(schedule.getKey() + ": " + schedule.getValue());
        }

        return weeklySchedule
                .entrySet()
                .stream()
                .noneMatch(stringArrayListEntry -> stringArrayListEntry.getValue().size() < 2);
    }

    private static long getDaysWorked(HashMap<String, ArrayList<String>> weeklySchedule, String chefsAvailable) {
        return weeklySchedule.values()
                .stream()
                .filter(chef -> chef.contains(chefsAvailable)).count();
    }

    private static List<String> getAvalaibleChefsByDay(HashMap<String, ArrayList<String>> requests, String day) {
        return requests.entrySet()
                .stream()
                .filter(chefDayOff -> !chefDayOff.getValue().contains(day))
                .sorted((r1, r2) -> r2.getValue().size() - r1.getValue().size())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
//Monday    : Emma, Zach
//        Tuesday   : Zach, Remy
//        Wednesday : Zach, Remy
//        Thursday  : Remy, Ada
//        Friday    : Remy, Emma
 //       Saturday  : Emma, Zach
//        Sunday    : Zach, Remy