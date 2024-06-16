package com.oscar.atienza;

import com.google.gson.stream.JsonReader;

import java.util.ArrayList;
import java.util.List;

public class ShipHandling {
    // Busca si existe un usuario con ese nombre
    public Ship getShipInfo(String name){
        Ship foundShip = null;
        JSONManager reader = new JSONManager();

        ArrayList<Ship> shipsList = reader.getShipsList("./back/src/main/resources/data.json");
        // Comprobamos que el SHIP introducido existe y lo devolvemos
        for(Ship ship: shipsList){
            if(ship.getName().equalsIgnoreCase(name)){
                foundShip = ship;
            }
        }
        return foundShip;
    }

    public void writeLogJSON(String nombre) {
        JSONManager manager = new JSONManager();
        ArrayList<ShipLog> logs = manager.getLog("./back/peticiones/requests.json");

        // Verificar si logs es null (cuando el archivo está vacío o no existe)
        if (logs == null) {
            logs = new ArrayList<>(); // Crear una nueva lista vacía
        }

        // Buscar si el nombre de la nave ya existe en los logs
        boolean found = false;
        for (ShipLog log : logs) {
            if (log.getNombre().equals(nombre)) {
                log.setApariciones(log.getApariciones() + 1); // Incrementar las apariciones
                found = true;
                break;
            }
        }

        // Si no se encontró, agregar un nuevo registro
        if (!found) {
            logs.add(new ShipLog(nombre, 1)); // Crear un nuevo ShipLog con 1 aparición
        }

        // Escribir los logs actualizados en el archivo JSON
        manager.writeLog("./back/peticiones/requests.json", logs);
    }
}
