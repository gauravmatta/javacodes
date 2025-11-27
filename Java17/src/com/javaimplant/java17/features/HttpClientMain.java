package com.javaimplant.java17.features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientMain {
    static HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    static void main() throws IOException, InterruptedException {
        System.out.println("HttpClient feature demo");
        HttpRequest request=HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();
        System.out.println(request.method());
        System.out.println(request.uri());
        HttpResponse<String> resp1 = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp1.statusCode());
        System.out.println(resp1.body());
    }
}
