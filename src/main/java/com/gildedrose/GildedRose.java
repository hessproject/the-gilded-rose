package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    ArrayList<String> nonDegradables;

    public GildedRose() {
        this.items = new Item[] { //
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), //
                new Item("Conjured Mana Cake", 3, 6) //
        };

        this.nonDegradables = new ArrayList<String>(List.of("Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"));
    }

    public void updateQuality(int numberOfDays) {
        for(int days = 0; days < numberOfDays; days++){
            for (int i = 0; i < items.length; i++) {
                if (!nonDegradables.contains(items[i].name)) {
                    if (items[i].quality > 0) {
                        if(items[i].sellIn >= 0){
                            items[i].quality -= 1;
                        } else {
                            items[i].quality -= 2;
                        }
                    }
                } else {
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if(items[i].sellIn < 0){
                            items[i].quality = 0;
                        } else if(items[i].sellIn < 6){
                            items[i].quality += 3;
                        } else if(items[i].sellIn < 11) {
                            items[i].quality += 2;
                        } else {
                            items[i].quality += 1;
                        }
                    } else if (items[i].quality < 50){
                        items[i].quality = items[i].quality + 1;
                    }
                }

                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].sellIn = items[i].sellIn - 1;
                }
                
                if (items[i].sellIn < 0) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}

