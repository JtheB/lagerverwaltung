package de.jtheb.fh.lagerverwaltung;

import de.jtheb.fh.lagerverwaltung.entities.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by jens on 15/07/17 in lagerverwaltung.
 */
public class MainTest {
    @Test
    public void initiateWarehouse() throws Exception {
        Warehouse warehouse = new Warehouse();
        Shelf shelf = new Shelf();
        Compartment compartment = new Compartment();
        final Item item = new Item();

        item.setArticleNr("0000-0001");
        item.setDepth(10);
        item.setHeight(20);
        item.setName("Teddybärin");
        item.setWidth(30);

        shelf.initiateShelf();
        warehouse.initiateShelves();

        warehouse.addItem(item);

        ReadFile readFile = new ReadFile();
        readFile.writeWarehouse(warehouse);

        compartment.add(item);
        String test = compartment.toString();

        assertEquals(100, shelf.getCompartments().size());
        assertEquals(8, warehouse.getShelves().size());
        assertEquals(1, getTeddyCount(warehouse, item));
        assertFalse(warehouse.isFull());
        assertEquals(test, warehouse.findFittingCompartment(item).toString());
    }

    private int getTeddyCount(Warehouse warehouse, Item item){
        int counter = 0;
        for (Shelf shelf : warehouse.getShelves()){
            for (Compartment compartment : shelf.getCompartments()){
                for (Item item2 : compartment.getItems()){
                    if (item2.equals(item)){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}