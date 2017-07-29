package de.jtheb.fh.lagerverwaltung.entities;

import org.junit.Test;

import static org.junit.Assert.*;

import de.jtheb.fh.lagerverwaltung.entities.Compartment;
import de.jtheb.fh.lagerverwaltung.entities.Shelf;

public class ShelfTest {
    @Test
    public void addCompartmentToShelf() throws Exception {
        Shelf shelf = new Shelf();
        Compartment compartment = new Compartment();

        shelf.initiateShelf(compartment);

        assertEquals(100, shelf.getCompartments().size());
        assertEquals(compartment, shelf.getCompartments().get(0));
    }
}
