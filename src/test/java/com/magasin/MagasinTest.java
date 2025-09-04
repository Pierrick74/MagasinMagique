package com.magasin;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MagasinTest {

    @Test
    public void testList() {
        String[] names = new String[] {"Comté", "Kryptonite", "Pass VIP Concert", "kryptonite", "comté"};
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

    @Nested
    class MagicPowerTest {

        @ParameterizedTest(name = "Item {0}: sellIn {1}→{3}, quality {2}→{4}")
        @DisplayName("given name {0}, selin at {1} and quality at {2} When Update then selin = {3} and quality = {4}")
        @CsvSource(value = {
                "'Pouvoirs magiques', 5, 11, 4, 9",
                "'Pouvoirs magiques', 1, 11, 0, 9",
                "'Pouvoirs magiques', 0, 11, -1, 7",
                "'Pouvoirs magiques', 5, 0, 4, 0"
        })
        public void testMagicPower(String name, Integer sellin, Integer quality, Integer resultSellin, Integer resultQuality ) {
            Item[] items = new Item[] { new Item(name, sellin, quality) };
            Magasin app = new Magasin(items);
            app.updateQuality();
            Assertions.assertEquals(items[0].quality, resultQuality);
            Assertions.assertEquals(items[0].sellIn, resultSellin);
        }
    }
}
