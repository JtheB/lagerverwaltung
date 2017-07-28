package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Compartment {

    public static final int HEIGHT = 200;
    public static final int WIDTH = 200;
    public static final int DEPTH = 200;

    private List<Item> items;

    public Compartment() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public int getVolume() {
        return HEIGHT * WIDTH * DEPTH;
    }

    public int getItemsVolume() {

        int volume = 0;
        for (Item item : items) {
            volume += item.getHeight() * item.getWidth() * item.getDepth();
        }
        return volume;
    }

    /**
     * This Method tests for itemFitsVolume and articleNrFits
     *
     * @param item is an Item which has an articleID, height, width, depth and a name.
     */
    public boolean itemFitsWithArticleNr(Item item) {
        return this.articleNrFits(item) && itemFitsVolume(item);
    }

    public boolean itemFitsVolume(Item item) {
        return this.getVolume() - this.getItemsVolume() - item.getVolume() >= 0;
    }

    public boolean isFull() {
        return this.getVolume() == this.getItemsVolume();
    }

    public String getArticleNr() {
        for (Item item : items) {
            return item.getArticleNr();
        }
        return null;
    }

    /**
     * articleNrFits tests whether there is an item in Compartment, which has the same articleNr
     *
     * @param item is an Item which has an articleID, height, width, depth and a name.
     */
    public boolean articleNrFits(Item item) {
        return this.getArticleNr().equals(item.getArticleNr());
    }
}
