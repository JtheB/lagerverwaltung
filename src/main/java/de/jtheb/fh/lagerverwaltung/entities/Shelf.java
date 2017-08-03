package de.jtheb.fh.lagerverwaltung.entities;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Shelf {
    public static final int COMPARTMENTCOUNT = 100;

    private List<Compartment> compartments = new ArrayList<>();

    public Shelf() {
        this.compartments = new ArrayList<>();
    }

    public boolean itemFits(Item item) {
        if (!isFull()) {
            for (Compartment compartment : compartments) {
                if (compartment.itemFitsWithArticleNr(item) || null == compartment.getArticleNr()) {
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
        for (Compartment compartment : compartments) {
            if (compartment.itemFitsWithArticleNr(item)) {
                return compartment;
            }
        }
        for (Compartment compartment : compartments) {
            if (null == compartment.getArticleNr()) {
                return compartment;
            }
        }
        return null;
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

    public void initiateShelf() {
        for (int i = 0; i < COMPARTMENTCOUNT; i++) {
            Compartment compartment = new Compartment();
            add(compartment);
        }
    }

    public void removeItem(Item item){
        if (itemExists(item)) {
            for (Compartment compartment : Lists.reverse(compartments)) {
                if (compartment.itemExists(item)) {
                    compartment.removeItem(item);
                    return;
                }
            }
        }
    }

    public boolean itemExists(Item item){
        for (Compartment compartment : compartments){
            if (compartment.itemExists(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "compartments=" + compartments +
                '}';
    }
}
