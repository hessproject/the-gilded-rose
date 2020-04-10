package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    ArrayList<String> nonDegradables;
    ArrayList<String> legendaryItems;
    int conjuredModifier;

    public GildedRose() {
        this.items = new Item[] { //
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), //
                new Item("Conjured Mana Cake", 3, 6) //
        };

        this.nonDegradables = new ArrayList<String>(List.of("Aged Brie", "Backstage passes to a TAFKAL80ETC concert"));
        this.legendaryItems = new ArrayList<String>(List.of("Sulfuras, Hand of Ragnaros"));
        this.conjuredModifier = 2;
    }

    public void updateQuality(int numberOfDays) {
        for(int days = 0; days < numberOfDays; days++){
            for (int i = 0; i < items.length; i++) {

                //Legendary items don't need to be adjusted, go to next loop iteration
                if(legendaryItems.contains(items[i].name)){
                    continue;
                }

                //Degrading process for perishable items
                if (!nonDegradables.contains(items[i].name)) {
                    if (items[i].quality > 0) {
                        if(items[i].sellIn >= 0){
                            items[i].quality -= isConjured(items[i].name)? 1 * conjuredModifier : 1;
                        } else {
                            items[i].quality -= isConjured(items[i].name)? 2 * conjuredModifier : 2;
                        }
                    }
                } else {

                    //Special case for concert tickets
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        items[i] = adjustConcertTickets(items[i]);

                    //Items that increase in quality with age eg. Aged Brie
                    } else if (items[i].quality < 50){
                        items[i].quality = items[i].quality + 1;
                    }
                }

                items[i].sellIn -= 1;

            }
        }
    }

    private Item adjustConcertTickets(Item concertTicket){
        if(concertTicket.sellIn < 0){
            concertTicket.quality = 0;
        } else if(concertTicket.sellIn < 6){
            concertTicket.quality += 3;
        } else if(concertTicket.sellIn < 11) {
            concertTicket.quality += 2;
        } else {
            concertTicket.quality += 1;
        }

        return concertTicket;
    }

    private boolean isConjured(String itemName){
        return itemName.contains("Conjured");
    }
}

