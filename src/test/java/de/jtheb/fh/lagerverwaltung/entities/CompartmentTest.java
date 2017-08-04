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

        item.setArticleNr("000-000");
        item.setDepth(10);
        item.setHeight(20);
        item.setName("Teddybär");
        item.setWidth(30);

        compartment.add(item);
        compartment.add(item);
        compartment.add(item);
        //compartment.removeLastItem(); //TODO fix cannot find symbol removeLastItem() Error!

        assertEquals("000-000", compartment.getArticleNr());
        assertTrue(compartment.itemExists(item));
        assertEquals(3, compartment.getItems().size());
        assertEquals(item, compartment.getItems().get(0));
    }
}
