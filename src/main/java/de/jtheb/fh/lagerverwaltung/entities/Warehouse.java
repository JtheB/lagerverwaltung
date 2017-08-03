package de.jtheb.fh.lagerverwaltung.entities;

import com.google.common.collect.Lists;

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
                if (shelf.itemFits(item)){
                    return true;
                }
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
                if (null != shelf.findFittingCompartment(item)) {
                    return shelf.findFittingCompartment(item);
                }
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

    public int addItem(Item item) {
        int distance = 1;
        Compartment fittingCompartment;
        System.out.println("\ndavor"+ itemFits(item));
        if (itemFits(item)) {
            System.out.println("vor For:");
            for (Shelf shelf : shelves) {
                fittingCompartment = shelf.findFittingCompartment(item);
                System.out.println("in for test" + distance);
                if (null == fittingCompartment) {
                    distance++;
                } else {
                    fittingCompartment.add(item);
                    return distance * SPACE_BETWEEN_SHELVES;
                }
            }
        }
        return 0; //TODO Returns 0 even if there are plenty of empty shelves left.
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

    public boolean itemExits(Item item) {
        for (Shelf shelf : shelves) {
            if (shelf.itemExists(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function removes the last Item in the warehouse with type item and returns the distance the robot has to drive to get it.
     *
     * @param item item is an Item which has an articleID, height, width, depth and a name. It is the object to be removed.
     * @return this function returns the distance the robot has to drive to get to the shelf
     */
    public int removeItem(Item item) {
        int shelfDistance = SHELFCOUNT;
        for (Shelf shelf : Lists.reverse(shelves)) {
            if (shelf.itemExists(item)) {
                shelf.removeItem(item);
                return shelfDistance * SPACE_BETWEEN_SHELVES;
            } else {
                shelfDistance--;
            }
        }
        return shelfDistance;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "shelves=" + shelves +
                '}';
    }
}
