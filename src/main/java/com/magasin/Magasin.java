package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Kryptonite")) {
                break;
            }

            items[i].quality = calculeItemQualityUpdate(items[i]);

            items[i].sellIn = items[i].sellIn - 1;

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Comté")) {
                    if (!items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].quality > 0) {
                            items[i].quality = items[i].quality - 1;
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private int calculeItemQualityUpdate(Item item) {
        if (item.name.equals("Comté")) {
            return item.quality < 50 ? item.quality + 1 :  item.quality;
        }

        if (item.name.equals("Pass VIP Concert")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Pass VIP Concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
            return item.quality;
        }

        return item.quality > 0 ? item.quality - 1 : item.quality;
    }
}
