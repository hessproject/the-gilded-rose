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

        assertEquals(app.items[0].quality, 19);
        assertEquals(app.items[1].quality, 1);
        assertEquals(app.items[2].quality, 6);
        assertEquals(app.items[3].quality, 80);
        assertEquals(app.items[4].quality, 21);
    }



}
