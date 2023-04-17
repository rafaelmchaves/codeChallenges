package sushinori.orders;

import java.util.ArrayList;
import java.util.Objects;

public class SushiOrder {

    private final int seatId;
    private final ArrayList<String> menuItemIds;

    public SushiOrder(int seatId, ArrayList<String> menuItemIds) {
        this.seatId = seatId;
        this.menuItemIds = menuItemIds;
    }
    public int getSeatId() {
        return this.seatId;
    }
    public ArrayList<String> getMenuItemIds() {
        return this.menuItemIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SushiOrder that = (SushiOrder) o;
        return seatId == that.seatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId);
    }

    @Override
    public String toString() {
        return "SushiOrder{}";
    }
}
