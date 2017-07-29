package de.jtheb.fh.lagerverwaltung.entities;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import de.jtheb.fh.lagerverwaltung.entities.Shelf;
import de.jtheb.fh.lagerverwaltung.entities.Warehouse;

public class WarehouseTest {
    @Test
    public void addShelfToWarehouse() throws Exception {
        Warehouse warehouse = new Warehouse();
        final Shelf shelf = new Shelf();

        warehouse.initiateShelves(shelf);

        List<Shelf> shelves = warehouse.getShelves();
        assertEquals(8, shelves.size());
        assertEquals(shelf, warehouse.getShelves().get(0));
    }
}

