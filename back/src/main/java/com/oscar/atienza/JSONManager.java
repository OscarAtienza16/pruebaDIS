package com.oscar.atienza;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSONManager {
    public ArrayList<Ship> getShipsList(String fichero){
        try {
            // Lee el fichero que le pasemos y lo carga en un reader
            Reader reader = Files.newBufferedReader(Paths.get(fichero));
            // Convierte el array JSON a un arrayList de Ships
            ArrayList<Ship> ships = new Gson().fromJson(reader, new TypeToken<ArrayList<Ship>>() {}.getType());
            reader.close();
            return ships;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>(); // Si no ha leido nada, devuelve un array vacio
        }
    }

    public ArrayList<ShipLog> getLog(String fichero){
        try {
            // Lee el fichero que le pasemos y lo carga en un reader
            Reader reader = Files.newBufferedReader(Paths.get(fichero));
            // Convierte el array JSON a un arrayList de Ships
            ArrayList<ShipLog> shipLogs = new Gson().fromJson(reader, new TypeToken<ArrayList<ShipLog>>() {}.getType());
            reader.close();
            return shipLogs;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>(); // Si no ha leido nada, devuelve un array vacio
        }
    }

    // Escribir el fichero JSON
    public boolean writeLog(String fichero, ArrayList<ShipLog> shipLogs){
        try {
            // Lee el fichero que le pasemos y lo abre en modo escritura
            Writer writer = Files.newBufferedWriter(Paths.get(fichero));
            // Convierte el arrayList de users a un array JSON, y lo escribe en el fichero
            writer.write(new Gson().toJson(shipLogs));
            writer.close();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
