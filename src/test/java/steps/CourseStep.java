package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

public class CourseStep {
    RestAssured restAssured;
    ValidatableResponse response;
    @Given("we have access to url {string}")
    public void we_have_access_to_url(String url) {
        RestAssured.baseURI = url;
    }
    @When("We will call end point {string} with id {string}")
    public void we_will_call_end_point_with_id(String endpoint, String id) {
        System.out.println("endpoint = " + endpoint);
        response = restAssured.when().get(endpoint, id).then();
    }
    @Then("We should have got status code of {int}")
    public void we_should_have_got_status_code_of(Integer statusCode) {

        response.assertThat().statusCode(statusCode);
    }

    @And("Enrolled student should be {string}")
    public void enrolled_student_should_be(String studentCnt) {
       response.assertThat().body("uuid", equalTo(studentCnt));
    }
    @And("Total Modules should be {string}")
    public void total_modules_should_be(String moduleCnt) {
     response.assertThat().body("companyId", equalTo(moduleCnt));
    }

}
