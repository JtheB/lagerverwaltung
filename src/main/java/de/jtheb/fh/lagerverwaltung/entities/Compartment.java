package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Compartment{

    public static final int HEIGHT = 200;
    public static final int WIDTH = 200;
    public static final int DEPTH = 200;
    //private String id;

    private List<Item> items = new ArrayList<>();

    public Compartment() {
        this.items = new ArrayList<>();
    }

    //public Compartment(final List<Item> items) { this.items = items; }

    void add(final Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public int getVolume(){return HEIGHT*WIDTH*DEPTH;}

    public int getitemsVolume(){
        int volume;

        for (Item item:this.items) {
            volume += (item.getHeight()*item.getWidth()*item.getDepth());
        }
        return volume;
    }

    public boolean itemFits(Item item) {
        return (this.getVolume() - this.getitemsVolume() - item.getVolume() >= 0);
    }

    public boolean isFull() {
        return (this.getVolume() - this.getitemsVolume() == 0);
    }
}
