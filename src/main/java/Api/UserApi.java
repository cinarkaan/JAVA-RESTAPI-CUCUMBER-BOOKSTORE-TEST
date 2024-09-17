package Api;

import Entity.Response;
import Entity.User;
import util.HttpMethods;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserApi extends User implements HttpMethods {

    public Response generateToken (String username, String password) throws Exception {

        String requestBody = "{\n" +
                "  \"userName\": \"" + username +
                "\",\n" +
                "  \"password\": \"" + password +
                "\"\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create("https://bookstore.toolsqa.com/Account/v1/GenerateToken"))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Response(response.statusCode(), response.body());
    }

    public Response getUser (User user, String token) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://bookstore.toolsqa.com/Account/v1/User/" + user.getUserId()))
                .header("Authorization", "Bearer " + token)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Response(response.statusCode(), response.body());
    }

    @Override
    public Response get() {
        return null;
    }

    @Override
    public Response add(String... args) throws Exception{

        String requestBody = "{\n" +
                "  \"userName\": \"" + args[0] +
                "\",\n" +
                "  \"password\": \"" + args[1] +
                "\"\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create("https://bookstore.toolsqa.com/Account/v1/User"))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Response(response.statusCode(), response.body());

    }

    @Override
    public void update(String... args) {

    }

    @Override
    public Response delete(String... args) {
        return null;
    }
}
