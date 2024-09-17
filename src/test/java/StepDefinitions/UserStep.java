package StepDefinitions;

import Api.UserApi;

import Entity.Response;

import Entity.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;

public class UserStep {

    UserApi userApi = new UserApi();
    Response response;
    JSONObject body;
    User user;

    @When("Generate token the user who has {string} username and {string} password")
    public void generateToken (String arg0, String arg1) throws Exception {
        response = userApi.generateToken(arg0, arg1);
    }

    @Then("Get the user who has {string} userid , {string} username and {string} password")
    public void getUser (String arg0 , String arg1, String arg2) throws Exception {
        JSONObject jsonObject = new JSONObject(response.getBody());
        response = userApi.getUser(new User(arg0, arg1, arg2, true),jsonObject.getString("token"));
        Assert.assertEquals("The user : " , 200 , response.getStatusCode());
        System.out.println(response.getBody());
    }

    @When("The user who has {string} email and {string} password will be added")
    public void addUser(String arg0, String arg1) throws Exception {
        user = new User();
        user.setUsername(arg0);
        user.setPassword(arg1);
        user.setAuthorized(false);
        response = userApi.add(arg0,arg1);
        body = new JSONObject(response.getBody());
    }

    @Then("Response will be confirmed as 200 code ok")
    public void validateCodeSuccess () {
        user.setUserId(body.get("userID").toString());
        System.out.println("-------USER WAS ADDED-------");
        System.out.println(user.toString());
        Assert.assertEquals("User was added successfully" , 201 , response.getStatusCode());
    }

    @Then("Response will be confirmed as 400 code ok")
    public void validateCodeFail() {
        System.out.println(body.get("message"));
        Assert.assertEquals("User was not added" , 400 , response.getStatusCode());
    }
}
