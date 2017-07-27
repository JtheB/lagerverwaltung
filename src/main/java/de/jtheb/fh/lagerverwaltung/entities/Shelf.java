package de.jtheb.fh.lagerverwaltung.entities;

import java.util.ArrayList;
import java.util.List;

public class Shelf{
    public static final int COMPARTMENTCOUNT = 100;

    private List<Compartment> compartments = new ArrayList<>();

    public Shelf() {
        this.compartments = new ArrayList<>();
    }

    public boolean itemFits(Item item) {
        for (Compartment compartment: this.compartments){
            if (compartment.itemFits(item)){
                return true;
                break;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (Compartment compartment : this.compartments){
            if (compartment.isFull() == false){
                return false;
                break;
            }
        }
        return true;
    }

    public Compartment findFittingCompartment(Item item) {
        for (Compartment compartment : this.compartments){
            if (compartment.itemFits(item)) {
                return compartment;
            }
        }
        throw new UnsupportedOperationException("not implemented"); //TODO ERROR Function/Shelffull
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
        for(int i = 0; i < COMPARTMENTCOUNT; i++) {
            add(compartment);
        }
    }
}
