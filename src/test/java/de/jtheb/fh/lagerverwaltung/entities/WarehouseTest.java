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

        warehouse.initiateShelves();

        List<Shelf> shelves = warehouse.getShelves();
        String test1 = shelves.get(0).toString();

        assertEquals(8, shelves.size());
        assertEquals(test1, warehouse.getShelves().get(1).toString());
    }
}

