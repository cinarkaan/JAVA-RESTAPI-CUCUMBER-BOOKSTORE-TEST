package StepDefinitions;

import Api.BookApi;
import Entity.Book;
import Entity.Response;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class BookStep {

    BookApi bookApi = new BookApi();
    Response response;
    Book book;

    @When("Get all book from database")
    public void getAllBooks () throws Exception{
        response = bookApi.get();
        Assert.assertEquals("Status Code" , 200, response.getStatusCode());
        System.out.println(response.getBody());
    }

    @And("Get isbn number of first book")
    public void getFirst () throws Exception {
        JSONArray jsonArray = new JSONArray(response.getBody().substring(9,response.getBody().length()));
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        book = new Book();
        book.setIsbn(jsonObject.getString("isbn"));
    }

    @Then("Delete first book and checkout status code")
    public  void getFeatures () throws Exception {
        System.out.println(book.getIsbn());
        response = bookApi.delete();
        //System.out.println(response.getStatusCode() + response.getBody());
    }

    @And("Add book the user who has {string} id and {string} isbn")
    public void addBook (String arg0 , String arg1) throws Exception {
        response = bookApi.add(arg0,arg1,"");
    }

    @Then("Validate the result of response")
    public void validateResponse () {
        System.out.println(response.getBody());
        Assert.assertEquals("The book was added successfully", 201, response.getStatusCode());
    }
}
