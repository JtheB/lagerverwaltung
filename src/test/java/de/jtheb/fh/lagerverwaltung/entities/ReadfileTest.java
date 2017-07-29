package de.jtheb.fh.lagerverwaltung.entities;

import de.jtheb.fh.lagerverwaltung.entities.Compartment;
import de.jtheb.fh.lagerverwaltung.entities.Shelf;
import de.jtheb.fh.lagerverwaltung.entities.Warehouse;
import de.jtheb.fh.lagerverwaltung.entities.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ReadfileTest {
    @Test
    public void readWriteWarehouseFromJson() {
        Warehouse warehouse = new Warehouse();
        Shelf shelf = new Shelf();
        Compartment compartment = new Compartment();

        shelf.initiateShelf(compartment);
        warehouse.initiateShelves(shelf);

        Readfile readfile = new Readfile();

        readfile.writeWarehouse(warehouse);

        Warehouse newWarehouse = readfile.readWarehouse();
        System.out.println(newWarehouse);
        //assertEquals(warehouse, newWarehouse);
    }
}