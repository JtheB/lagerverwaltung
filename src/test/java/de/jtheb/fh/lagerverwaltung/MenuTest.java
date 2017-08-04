package de.jtheb.fh.lagerverwaltung;

import de.jtheb.fh.lagerverwaltung.entities.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void addNewItemButtonListener() throws Exception {
        Warehouse warehouse = new Warehouse();
        final Item item = new Item();
        ReadFile readFile = new ReadFile();
        warehouse = readFile.readWarehouse();

        item.setArticleNr("0000-0001");
        item.setDepth(10);
        item.setHeight(20);
        item.setName("Teddybärin");
        item.setWidth(30);

        int distance = warehouse.addItem(item);

        Menu menu = new Menu();
        menu.addItemWithDistance(distance, warehouse, item, readFile);

        assertEquals(200, distance);
    }

}