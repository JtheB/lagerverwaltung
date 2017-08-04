package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    public static final int SHELFCOUNT = 8;
    public static final int SPACE_BETWEEN_SHELVES = 200;

    private List<Shelf> shelves;

    public Warehouse() {
        this.shelves = new ArrayList<>();
    }

    public boolean itemFits(Item item) {
        if (!isFull()) {
            for (Shelf shelf : shelves) {
                return shelf.itemFits(item);
            }
        }
        return false;
    }

    public boolean isFull() {
        for (Shelf shelf : shelves) {
            if (!shelf.isFull()) {
                return false;
            }
        }
        return true;
    }

    public Compartment findFittingCompartment(Item item) {
        if (!isFull()) {
            for (Shelf shelf : shelves) {
                return shelf.findFittingCompartment(item);
            }
        }
        return null;
    }

    public void add(final Shelf shelf) {
        this.shelves.add(shelf);
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(final List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public void initiateShelves(final Shelf shelf) {
        for (int i = 0; i < SHELFCOUNT; i++) {
            add(shelf);
        }
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "shelves=" + shelves +
                '}';
    }
}
