package de.jtheb.fh.lagerverwaltung.entities;

import org.junit.Test;
import static org.junit.Assert.*;

import de.jtheb.fh.lagerverwaltung.entities.Compartment;
import de.jtheb.fh.lagerverwaltung.entities.Item;

public class CompartmentTest {
    @Test
    public void addItemToCompartment() throws Exception {
        Compartment compartment = new Compartment();
        Item item = new Item();

        compartment.add(item);

        assertEquals(1, compartment.getItems().size());
        assertEquals(item, compartment.getItems().get(0));
    }
}
