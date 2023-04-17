package sushinori;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sushinori.scheduler.ChefScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChefSchedulerTest {

    @Test
    public void schedulableFirstExample() {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put(
                "ada", new ArrayList<>(Arrays.asList(
                        "mon", "tue", "wed", "fri", "sat", "sun"))
        );
        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        "tue", "wed", "thu", "sun"))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        "mon", "sat"))
        );
        requests.put(
                "zach", new ArrayList<>(List.of())
        );
        Assertions.assertTrue(ChefScheduler.schedulable(requests));
    }

    @Test
    public void schedulableSecondExample() {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put(
                "emma", new ArrayList<>(List.of(
                        "sun"))
        );
        requests.put(
                "remy", new ArrayList<>(List.of(
                        "sun"))
        );
        requests.put(
                "zach", new ArrayList<>(List.of())
        );
        Assertions.assertFalse(ChefScheduler.schedulable(requests));
    }

    @Test
    public void schedulableThirdExample() {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put(
                "ada", new ArrayList<>(Arrays.asList(
                        "mon", "tue", "wed", "thu", "fri", "sat"))
        );
        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        "tue", "wed", "thu", "sun"))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        "mon", "fri", "sun"))
        );
        requests.put(
                "zach", new ArrayList<>(List.of())
        );
        Assertions.assertFalse(ChefScheduler.schedulable(requests));
    }

    @Test
    public void schedulableFourthExample() {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put(
                "emma", new ArrayList<>(List.of())
        );
        requests.put(
                "remy", new ArrayList<>(List.of())
        );
        requests.put(
                "zach", new ArrayList<>(List.of())
        );
        Assertions.assertFalse(ChefScheduler.schedulable(requests));
    }

    @Test
    public void schedulableFifthExample() {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put(
                "ada", new ArrayList<>(Arrays.asList(
                        "mon", "tue", "wed", "fri", "sat", "sun"))
        );
        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        "tue", "wed", "thu", "sun"))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        "mon", "sat"))
        );
        requests.put(
                "zach", new ArrayList<>(List.of())
        );

        requests.put(
                "Harry", new ArrayList<>(List.of("tue", "wed"))
        );
        Assertions.assertTrue(ChefScheduler.schedulable(requests));
    }
}
