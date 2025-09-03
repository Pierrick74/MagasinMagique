package com.magasin;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class MagasinTest {

    @Test
    public void testList() {
        String[] names = new String[] {"Comté", "Kryptonite", "Pass VIP Concert", "Pouvoirs magiques", "kryptonite", "comté"};
        Integer[] sellins = new Integer[] {8, -1, 0, 2, 4, 5, 6, 9, 10, 11};
        Integer[] qualities = new Integer[] {1, 0, 20, 50, 49, 51, 80, };

        CombinationApprovals.verifyAllCombinations(
                (String name, Integer sellin, Integer quality) -> {
                    Item[] items = new Item[] { new Item(name, sellin, quality) };
                    Magasin app = new Magasin(items);
                    app.updateQuality();
                    return items[0].toString();
                },
                names, sellins, qualities
        );
    }

}
