package com.oppenheimer.steps.services;

import com.oppenheimer.bdd.Context;
import com.oppenheimer.bdd.ScenarioContext;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CommonSteps {
    @Autowired
    private ScenarioContext scenarioContext;

    @Then("QA verifies that the HTTP response code is {int}")
    public void qaVerifiesThatTheHTTPResponseCodeIs(int expectedErrorCode) {
        Response response = scenarioContext.get(Context.RESPONSE);
        assertThat(response.getStatusCode()).isEqualTo(expectedErrorCode);
    }

    @SneakyThrows
    @Then("QA verifies that the HTTP response body as json:")
    public void qaVerifiesThatTheHTTPResponseBodyIs(String expectedJson) {
        Response response = scenarioContext.get(Context.RESPONSE);
        JSONAssert.assertEquals(expectedJson, response.getBody().asString(), false);
    }

    @SneakyThrows
    @Then("QA verifies that the HTTP response body as text:")
    public void qaVerifiesThatTheHTTPResponseBodyAsText(String expectedJson) {
        Response response = scenarioContext.get(Context.RESPONSE);
        assertThat(response.getBody().asString()).isEqualTo(expectedJson);
    }
}
