package de.jtheb.fh.lagerverwaltung.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadFileTest {
    @Test
    public void readWriteWarehouseFromJson() {
        Warehouse warehouse = new Warehouse();
        Shelf shelf = new Shelf();
        Compartment compartment = new Compartment();

        shelf.initiateShelf(compartment);
        warehouse.initiateShelves(shelf);

        ReadFile readFile = new ReadFile();

        readFile.writeWarehouse(warehouse);

        String oldString = warehouse.toString();
        String newString = readFile.readWarehouse().toString();

        assertEquals(oldString, newString);
    }
}