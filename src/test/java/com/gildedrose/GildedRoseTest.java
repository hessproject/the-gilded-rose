package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testUpgradeQualityOneDay() {
        GildedRose app = new GildedRose();

        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals("Aged Brie", app.items[1].name);
        assertEquals("Elixir of the Mongoose", app.items[2].name);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[3].name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[4].name);
        assertEquals("Conjured Mana Cake", app.items[5].name);

        app.updateQuality(1);

        assertEquals(19, app.items[0].quality);
        assertEquals(1, app.items[1].quality);
        assertEquals(6, app.items[2].quality);
        assertEquals(80, app.items[3].quality);
        assertEquals(21, app.items[4].quality);
        assertEquals(4, app.items[5].quality);
    }



}
