package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private List<Compartment> compartments;

    public Shelf() {
        this.compartments = new ArrayList<>();
    }

    public Shelf(final List<Compartment> compartments) {
        this.compartments = compartments;
    }

    public boolean itemFits(Item item) {
        // iterate over compartments
        throw new UnsupportedOperationException("not implemented");
    }

    public boolean isFull() {
        throw new UnsupportedOperationException("not implemented");
    }

    public Compartment findFittingCompartment(Item item) {
        throw new UnsupportedOperationException("not implemented");
    }

    void add(final Compartment compartment) {
        this.compartments.add(compartment);
    }

    public List<Compartment> getCompartments() {
        return compartments;
    }

    public void setCompartments(final List<Compartment> compartments) {
        this.compartments = compartments;
    }
}
