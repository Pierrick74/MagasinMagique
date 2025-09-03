package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Kryptonite")) {
                break;
            }

            item.quality = calculeItemQualityUpdate(item);

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                item.quality = calculeItemQualityWhenExpirationPassed(item);
            }
        }
    }

    private Integer calculeItemQualityWhenExpirationPassed(Item item) {
        if (item.name.equals("Comté")) {
                return (item.quality < 50) ? item.quality + 1 : item.quality;
        }

        if (item.name.equals("Pass VIP Concert")) {
            return 0;
        }

        return item.quality > 0 ? item.quality - 1 : item.quality;
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
