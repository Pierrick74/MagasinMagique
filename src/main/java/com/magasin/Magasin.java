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
                items[i].quality = calculeItemQualityWhenExpirationPassed(items[i]);
            }
        }
    }

    private Integer calculeItemQualityWhenExpirationPassed(Item item) {
        if (!item.name.equals("Comté")) {
            if (!item.name.equals("Pass VIP Concert")) {
                if (item.quality > 0) {
                    return item.quality - 1;
                }
            } else {
                return item.quality - item.quality;
            }
        } else {
            if (item.quality < 50) {
                return item.quality + 1;
            }
        }
        return item.quality;
    }

    private int calculeItemQualityUpdate(Item item) {
        if (item.name.equals("Comté")) {
            return item.quality < 50 ? item.quality + 1 :  item.quality;
        }

        if (item.name.equals("Pass VIP Concert")) {
            if (item.quality >= 50) {
                return item.quality;
            }

            if (item.sellIn < 6) {
                return Math.min((item.quality + 3), 50);
            }

            if (item.sellIn < 11) {
                return Math.min((item.quality + 2), 50);
            }

            return item.quality = item.quality + 1;
        }

        return item.quality > 0 ? item.quality - 1 : item.quality;
    }
}
