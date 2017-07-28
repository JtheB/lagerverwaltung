package de.jtheb.fh.lagerverwaltung;

import de.jtheb.fh.lagerverwaltung.entities.Compartment;
import de.jtheb.fh.lagerverwaltung.entities.Shelf;
import de.jtheb.fh.lagerverwaltung.entities.Warehouse;
import de.jtheb.fh.lagerverwaltung.entities.Item;
import org.junit.Test;
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

        shelf.initiateShelf(compartment);
        warehouse.initiateShelves(shelf);

        assertEquals(100, shelf.getCompartments().size());
        assertEquals(8, warehouse.getShelves().size());
        assertFalse(warehouse.isFull());
        assertEquals(compartment, warehouse.findFittingCompartment(item));
    }
}