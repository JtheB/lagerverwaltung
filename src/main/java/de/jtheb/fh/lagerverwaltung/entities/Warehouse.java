package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Shelf> shelves;

    public Warehouse() {
        this.shelves = new ArrayList<>();
    }

    public Warehouse(final List<Shelf> shelves) {
        this.shelves = shelves;
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
}
