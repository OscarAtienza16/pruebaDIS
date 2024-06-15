package org.vaadin.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private static final String urlShipsList = "http://localhost:8888/ships";


    // Mostrar todos los ships de back
    public String getShips() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder() // Builder de la request
                .uri(new URI(urlShipsList))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient // Respuesta de la URL
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
