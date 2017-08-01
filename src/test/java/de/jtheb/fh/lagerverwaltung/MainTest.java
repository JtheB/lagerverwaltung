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

        shelf.initiateShelf(compartment);
        warehouse.initiateShelves(shelf);

        warehouse.addItem(item);

        ReadFile readFile = new ReadFile();
        readFile.writeWarehouse(warehouse);

        assertEquals(100, shelf.getCompartments().size());
        assertEquals(8, warehouse.getShelves().size());
        assertFalse(warehouse.isFull());
        assertEquals(compartment, warehouse.findFittingCompartment(item));
    }
}