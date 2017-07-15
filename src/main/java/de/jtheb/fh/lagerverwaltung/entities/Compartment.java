package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Compartment {

    private int height = 200;
    private int width = 200;
    private int depth = 200;

    List<Item> items = new ArrayList<>();

    public Compartment() {
        this.items = new ArrayList<>();
    }

    public Compartment(final List<Item> items) {
        this.items = items;
    }

    void add(final Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(final int depth) {
        this.depth = depth;
    }
}
