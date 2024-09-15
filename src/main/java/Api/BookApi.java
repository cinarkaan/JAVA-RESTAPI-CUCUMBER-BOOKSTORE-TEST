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
    public void get() throws Exception{

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://bookstore.toolsqa.com/BookStore/v1/Books"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response body: " + response.body());

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
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Response(response.statusCode() , response.body());

    }

    @Override
    public void update(String ...args) {

    }

    @Override
    public void delete() {

    }
}
