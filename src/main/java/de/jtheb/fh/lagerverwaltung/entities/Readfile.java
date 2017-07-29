package de.jtheb.fh.lagerverwaltung.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Readfile {

    public static final String FILENAME = "warehouse.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Readfile() {
    }

    public Warehouse readWarehouse() {
        Warehouse warehouse = null;
        try {
            warehouse = gson.fromJson(new FileReader(FILENAME), Warehouse.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return warehouse;
    }

    public void writeWarehouse(Warehouse warehouse) {
        try {
            gson.toJson(warehouse, new FileWriter(FILENAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
