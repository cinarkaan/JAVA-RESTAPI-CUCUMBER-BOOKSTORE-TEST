package Api;

import Entity.Response;
import Entity.User;
import util.HttpMethods;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserApi extends User implements HttpMethods {

    @Override
    public void get() {

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
    public void delete() {

    }
}
