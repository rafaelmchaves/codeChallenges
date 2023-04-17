package sushinori.orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainOrder {

    public static void main(String[] args) {

        //firstExample();
        //secondExample();
        //thirdExample();
        fourthExample();
    }

    private static void firstExample() {
        ArrayList<SushiOrder> request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1, // seatId for this order
                                new ArrayList<>(Arrays.asList(
                                        // menuItemIds for this order
                                        "tuna", "california", "avocado"))
                        ),
                        new SushiOrder(3,
                                new ArrayList<>(List.of(
                                        "avocado"))
                        ),
                        new SushiOrder(2,
                                new ArrayList<>(Arrays.asList(
                                        "salmon", "tuna", "crab", "scallop"))
                        )
                )
        );

        SushiOrderManager manager = new SushiOrderManager();
        manager.addOrder(request);

        for (int i = 0; i <= 8; i++) {
            var sushiItem = manager.nextItem();
            if(sushiItem != null) {
                System.out.println(sushiItem.getSeatId() + ": " + sushiItem.getMenuItemId());
            }

        }
    }

    private static void secondExample() {
        SushiOrderManager manager = new SushiOrderManager();

        ArrayList<SushiOrder> request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(2,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"dragon"}
                                ))
                        ),
                        new SushiOrder(1,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"avocado", "dynamite"}
                                ))
                        )
                )
        );
        manager.addOrder(request);
        var sushiItemFirst = manager.nextItem();
        System.out.println(sushiItemFirst.getSeatId() + ": " + sushiItemFirst.getMenuItemId());

        request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"mushroom"}
                                ))
                        )
                )
        );
        manager.addOrder(request);

        for (int i = 0; i <= 8; i++) {
            var sushiItem = manager.nextItem();
            if(sushiItem != null) {
                System.out.println(sushiItem.getSeatId() + ": " + sushiItem.getMenuItemId());
            } else {
                System.out.println(sushiItem);
            }

        }
    }

    private static void thirdExample() {
        SushiOrderManager manager = new SushiOrderManager();
        var sushiItemFirst = manager.nextItem();
        System.out.println(sushiItemFirst);
    }

    private static void fourthExample() {
        SushiOrderManager manager = new SushiOrderManager();

        ArrayList<SushiOrder> request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(2,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"dragon"}
                                ))
                        ),
                        new SushiOrder(1,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"avocado", "dynamite"}
                                ))
                        )
                )
        );
        manager.addOrder(request);

        request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"mushroom"}
                                ))
                        )
                )
        );
        manager.addOrder(request);

        request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(16,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"dragon"}
                                ))
                        ),
                        new SushiOrder(5,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"avocado", "dynamite"}
                                ))
                        )
                )
        );
        manager.addOrder(request);

        for (int i = 0; i <= 30; i++) {
            var sushiItem = manager.nextItem();
            if(sushiItem != null) {
                System.out.println(sushiItem.getSeatId() + ": " + sushiItem.getMenuItemId());
            } else {
                System.out.println(sushiItem);
            }

        }

        request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(12,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"dragon"}
                                ))
                        ),
                        new SushiOrder(8,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"avocado", "dynamite"}
                                ))
                        )
                )
        );
        manager.addOrder(request);

        var sushiItem = manager.nextItem();

        System.out.println(sushiItem.getSeatId() + ": " + sushiItem.getMenuItemId());

        request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"mushroom"}
                                ))
                        ),
                        new SushiOrder(15,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"avocado", "dynamite"}
                                ))
                        )
                )
        );
        manager.addOrder(request);

        sushiItem = manager.nextItem();

        System.out.println(sushiItem.getSeatId() + ": " + sushiItem.getMenuItemId());
        sushiItem = manager.nextItem();

        System.out.println(sushiItem.getSeatId() + ": " + sushiItem.getMenuItemId());

        sushiItem = manager.nextItem();

        System.out.println(sushiItem.getSeatId() + ": " + sushiItem.getMenuItemId());

    }
}
