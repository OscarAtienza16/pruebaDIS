package com.oscar.atienza;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSONManager {
    public ArrayList<Ship> getShipsList(String fichero){
        try {
            // Lee el fichero que le pasemos y lo carga en un reader
            Reader reader = Files.newBufferedReader(Paths.get(fichero));
            // Convierte el array JSON a un arrayList de Ships
            ArrayList<Ship> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Ship>>() {}.getType());
            reader.close();
            return users;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>(); // Si no ha leido nada, devuelve un array vacio
        }
    }
}
