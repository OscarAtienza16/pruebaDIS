package com.oscar.atienza;

import com.google.gson.stream.JsonReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ShipController {

    // GET del JSON
    @GetMapping("/ships")
    public ArrayList<Ship> ships(){
        JSONManager reader = new JSONManager();
        ArrayList<Ship> shipsList = reader.getShipsList("./back/src/main/resources/data.json");
        return shipsList;
    }

    // POST al JSON
    @PostMapping(path = "/ships",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody String shipName){
        ShipHandling handling = new ShipHandling();
        Ship ship = handling.getShipInfo(shipName);
        handling.writeLogJSON(shipName);
        PDFManager manager = new PDFManager();
        manager.createPDF(ship);
        return ResponseEntity.ok("Creado");
    }
}
