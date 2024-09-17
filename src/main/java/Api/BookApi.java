package Api;

import Entity.Book;
import Entity.Response;
import util.HttpMethods;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BookApi extends Book implements HttpMethods {

    @Override
    public Response get() throws Exception{

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://bookstore.toolsqa.com/BookStore/v1/Books"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println("response body: " + response.body());

        return new Response(response.statusCode(), response.body());
    }

    @Override
    public Response add(String... args) throws Exception {

        String requestBody = "{\n" +
                "  \"userId\": \" " + args[0] +
                "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + args[1] +
                "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create("https://bookstore.toolsqa.com/BookStore/v1/Books"))
                .header("Authorization", "Bearer" + args[2])
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Response(response.statusCode() , response.body());

    }

    @Override
    public void update(String ...args) {

    }

    @Override
    public Response delete(String... args) throws Exception{

        String requestBody = "{\n" +
                "  \"isbn\": \"" + args[0] +
                "\",\n" +
                "  \"userId\": \"" + args[1] +
                "\"\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).DELETE()
                .uri(URI.create("https://bookstore.toolsqa.com/BookStore/v1/Book"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Response(response.statusCode(), response.body());
    }
}
