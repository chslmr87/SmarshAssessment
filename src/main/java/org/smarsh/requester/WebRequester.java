package org.smarsh.requester;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebRequester implements Requester {
    private final HttpClient client =  HttpClient.newHttpClient();


    @Override
    public String request(String url) throws InterruptedException, IOException {

        IO.println("Downloading from page: " + url + "...");

        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
