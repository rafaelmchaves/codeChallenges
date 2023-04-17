package sushinori.orders;

import java.util.*;

public class SushiOrderManager {

    private SortedMap<Integer, String> currentRound;

    private final LinkedList<SortedMap<Integer, String>> rounds;

    int lastSeat;

    public SushiOrderManager() {
        currentRound = new TreeMap<>();
        rounds = new LinkedList<>();

        lastSeat = 0;
    }

    public void addOrder(ArrayList<SushiOrder> request) {

        for (SushiOrder order : request) {
            for (String item : order.getMenuItemIds()) {
                addToRoundList(order, item);
            }
        }

    }

    private void addToRoundList(SushiOrder order, String item) {
        if(rounds.isEmpty()) {
            createFirstRound(order, item);
        } else if (!currentRound.containsKey(order.getSeatId()) && order.getSeatId() > lastSeat) {
            currentRound.put(order.getSeatId(), item);
        } else {

            for (var round : rounds) {
                if (!round.containsKey(order.getSeatId()) && !round.equals(currentRound)) {
                    round.put(order.getSeatId(), item);
                    return;
                }
            }

            rounds.add(createNewRound(order.getSeatId(), item));

        }
    }

    private void createFirstRound(SushiOrder order, String item) {
        var firstRound = createNewRound(order.getSeatId(), item);
        rounds.add(firstRound);
        currentRound = firstRound;
    }

    public SushiItem nextItem() {

        if(rounds == null || rounds.isEmpty()) {
            return null;
        }

        if (currentRound == null) {
            currentRound = rounds.iterator().next();
        }

        if (currentRound.isEmpty()) {
            rounds.removeFirst();
            if(rounds.isEmpty()) {
                return null;
            }
            currentRound = rounds.getFirst();
        }

        lastSeat =  currentRound.firstKey();
        var item = currentRound.get(lastSeat);
        currentRound.remove(lastSeat);

        return new SushiItem(lastSeat, item);

    }

    private SortedMap<Integer, String> createNewRound(Integer seatId, String item) {
        final SortedMap<Integer, String> newRound = new TreeMap<>();
        newRound.put(seatId, item);
        return newRound;
    }

}
