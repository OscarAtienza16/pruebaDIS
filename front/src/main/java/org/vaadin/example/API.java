package org.vaadin.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private static final String urlShipsList = "http://localhost:8888/ships";

    // Mostrar todos los ships del back
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


    public String sendPDF(String name) throws URISyntaxException, IOException, InterruptedException {
        // Crea la solicitud HTTP con el nombre como cuerpo
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(urlShipsList))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(name))  // Envía el String directamente
                .build();

        // Envía la solicitud y recibe la respuesta
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Retorna la respuesta del servidor como String
        return response.body();
    }
}
