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

    public void initiateShelves() {
        for (int i = 0; i < SHELFCOUNT; i++) {
            Shelf shelf = new Shelf();
            shelf.initiateShelf();
            add(shelf);
        }
    }

    public void addItem(Item item) {
        if (!isFull() && itemFits(item)) {
            Compartment fittingcompartment = findFittingCompartment(item);
            /*for (Shelf shelf : shelves){
                for (Compartment compartment :shelf.getCompartments()){
                    if (compartment.equals(fittingcompartment)){
                        compartment.add(item);
                        break;
                    }
                }
            }*/
            fittingcompartment.add(item);
        }
    }

    public Item getExistingItemFromArticleNr(String articleNr) {
        if (itemNrExists(articleNr)) {
            for (Shelf shelf : this.getShelves()) {
                for (Compartment compartment : shelf.getCompartments()) {
                    for (Item item : compartment.getItems()) {
                        if (item.getArticleNr().equals(articleNr)) {
                            return item;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Item getExistingItemFromName(String name) {
        if (itemNameExists(name)) {
            for (Shelf shelf : this.getShelves()) {
                for (Compartment compartment : shelf.getCompartments()) {
                    for (Item item : compartment.getItems()) {
                        if (item.getName().equals(name)) {
                            return item;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean itemNrExists(String articleNr) {
        for (Shelf shelf : this.getShelves()) {
            for (Compartment compartment : shelf.getCompartments()) {
                for (Item item : compartment.getItems()) {
                    if (item.getArticleNr().equals(articleNr)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean itemNameExists(String name) {
        for (Shelf shelf : this.getShelves()) {
            for (Compartment compartment : shelf.getCompartments()) {
                for (Item item : compartment.getItems()) {
                    if (item.getName().equals(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "shelves=" + shelves +
                '}';
    }
}
