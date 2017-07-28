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

    public boolean itemFits(Item item) { //TODO Fix the items with an ID and add that to all itemFits
        for (Shelf shelf : shelves) {
            if (shelf.itemFits(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        throw new UnsupportedOperationException("not implemented");
    }

    public Compartment findFittingCompartment(Item item) {
        throw new UnsupportedOperationException("not implemented");
    }

    void add(final Shelf shelf) {
        this.shelves.add(shelf);
    }

    List<Shelf> getShelves() {
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
}
