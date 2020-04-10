package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testUpgradeQualityDegradables() {
        GildedRose app = new GildedRose();

        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals("Elixir of the Mongoose", app.items[2].name);

        app.updateQuality(1);

        assertEquals(19, app.items[0].quality);
        assertEquals(6, app.items[2].quality);

        app.updateQuality(1000);
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[2].quality);
    }

    @Test
    void testUpgradeQualityAgedBrie(){
        GildedRose app = new GildedRose();

        assertEquals("Aged Brie", app.items[1].name);

        app.updateQuality(1);
        assertEquals(1, app.items[1].quality);

        app.updateQuality(100);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    void testUpgradeQualityConcertTickets(){
        GildedRose app = new GildedRose();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[4].name);

        app.updateQuality(6);
        assertEquals(27, app.items[4].quality);

        app.updateQuality(5);
        assertEquals(38, app.items[4].quality);

        app.updateQuality(6);
        assertEquals(0, app.items[4].quality);
    }

    @Test
    void testUpgradeQualityLegendary(){
        GildedRose app = new GildedRose();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[3].name);

        app.updateQuality(100);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(80, app.items[3].quality);
    }

    @Test
    void testUpgradeQualityConjured(){
        GildedRose app = new GildedRose();

        assertEquals("Conjured Mana Cake", app.items[5].name);

        app.updateQuality(1);
        assertEquals(4, app.items[5].quality);
    }



}
