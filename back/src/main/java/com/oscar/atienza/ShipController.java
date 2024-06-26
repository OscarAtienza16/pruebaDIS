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
}
