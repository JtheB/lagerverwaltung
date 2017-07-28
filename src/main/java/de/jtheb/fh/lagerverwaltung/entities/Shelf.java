package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    public static final int COMPARTMENTCOUNT = 100;

    private List<Compartment> compartments = new ArrayList<>();

    public Shelf() {
        this.compartments = new ArrayList<>();
    }

    public boolean itemFits(Item item) {
        if (!isFull()) {
            for (Compartment compartment : compartments) {
                if (compartment.itemFitsWithArticleNr(item) || compartment.getArticleNr().equals(null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        for (Compartment compartment : this.compartments) {
            if (!compartment.isFull()) {
                return false;
            }
        }
        return true;
    }

    public Compartment findFittingCompartment(Item item) {
        for (Compartment compartment : this.compartments) {
            if (compartment.itemFitsWithArticleNr(item)) {
                return compartment;
            }
        }
        for (Compartment compartment : compartments) {
            if (compartment.getArticleNr().equals(null)) {
                return compartment;
            }
        }
        throw new UnsupportedOperationException("Error - compartements full"); //TODO Correct ERROR Function/Shelffull
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

    public void initiateShelf(final Compartment compartment) {
        for (int i = 0; i < COMPARTMENTCOUNT; i++) {
            add(compartment);
        }
    }
}
