package stepDefination;

import Core.ApiCall;
import Core.HeaderFormatHelper;
import Repository.remoteRepo.responseRepo.UserGetApiResponseModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.response.Response;

import static Core.CoreConstrainHelper.base_url;

public class GetApiStepdefs {
    String url;
    private Response responseGetApi;
    private final Gson gson = new Gson();

    @Given("user has the base api")
    public void userHasTheBaseApi() {
        url = base_url + "users";
    }

    @When("user call the {string} and {string}")
    public void userCallTheParameterAndParamsValue( String parameter,String paramsValue) {
        url = url +parameter + "="+ paramsValue;
        System.out.println(url);
        responseGetApi = ApiCall.getCall(HeaderFormatHelper.commonHeaders(),url);
        System.out.println(responseGetApi.body().asString());
    }

    @Then("it will return valid date")
    public void itWillReturnValidDate() {
        System.out.println(url);
        UserGetApiResponseModel getApiResponseModel = gson.fromJson(responseGetApi.getBody().asString(), UserGetApiResponseModel.class);
        System.out.println(getApiResponseModel.getPage());
        System.out.println(getApiResponseModel.getData().get(0).getFirst_name());
    }
}
