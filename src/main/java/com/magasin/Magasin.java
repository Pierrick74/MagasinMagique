package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case "Kryptonite":
                    break;
                case "Pass VIP Concert":
                    updatePassViP(item);
                    break;
                case "Comté":
                    updateComte(item);
                    break;
                case "Pouvoirs magiques":
                    updateMagicPower(item);
                    break;
                default:
                    update(item);
                    break;
            }
        }
    }

    private void updateMagicPower(Item item) {
        item.quality =  Math.max(item.quality - 2, 0);
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality =  Math.max(item.quality - 2, 0);
        }
    }

    private void updateComte(Item item){

        item.quality = item.quality < 50 ? item.quality + 1 :  item.quality;

        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = item.quality < 50 ? item.quality + 1 : item.quality;
        }
    }

    private void updatePassViP(Item item){

        if (item.quality >= 50) {
        } else if (item.sellIn < 6) {
            item.quality = Math.min((item.quality + 3), 50);
        } else if (item.sellIn < 11) {
            item.quality = Math.min((item.quality + 2), 50);
        } else {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void update(Item item) {
        item.quality =  item.quality > 0 ? item.quality - 1 : item.quality;

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality > 0 ? item.quality - 1 : item.quality;
        }
    }
}
