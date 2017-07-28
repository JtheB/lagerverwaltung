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
                shelf.itemFits(item);
            }
        }
        return
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
        throw new UnsupportedOperationException("Error -sShelves are full"); //TODO implement correct ERROR Function
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
