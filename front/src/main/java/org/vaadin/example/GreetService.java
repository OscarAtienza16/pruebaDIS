package org.vaadin.example;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.googlecode.gentyref.TypeToken;
import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

    public ArrayList<Ship> getShipsList() throws URISyntaxException, IOException, InterruptedException {
        API api = new API();
        String resultsAPI = api.getShips(); // LLamamos a la función para devolver todos los datos de la API
        Type listType = new TypeToken<ArrayList<Ship>>() {}.getType(); // Creamos un arraylist para utilizar Gs
        return new Gson().fromJson(resultsAPI, listType); // Transformamos el objeto JSON a un arraylist Java
    }

    public void sendPDFShip(String name) throws URISyntaxException, IOException, InterruptedException {
        // Llamamos a la función para enviar el nombre y obtener la respuesta
        API api = new API();
        String response = api.sendPDF(name);

        System.out.println("Respuesta del servidor: " + response);
    }
}
