package com.oppenheimer.steps.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oppenheimer.bdd.Context;
import com.oppenheimer.bdd.ScenarioContext;
import com.oppenheimer.entities.TaxRelief;
import com.oppenheimer.entities.WorkingClassHero;
import com.oppenheimer.services.CalculatorControllerService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorControllerSteps {
    @Autowired
    private CalculatorControllerService calculatorControllerService;

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private ObjectMapper objectMapper;

    @When("As the Clerk,/QA, I want to insert {recordType} record(s) of working class hero as following details:")
    public void insertWorkingClassHeroes(String type, List<WorkingClassHero> workingClassHeroList) {
        Response response;
        switch (type) {
            case "single":
                assertThat(workingClassHeroList.size()).isEqualTo(1);
                response = this.calculatorControllerService.insertPerson(workingClassHeroList.get(0));
                break;
            case "multiple":
                response = this.calculatorControllerService.insertMultiPerson(workingClassHeroList);
                break;
            default:
                throw new RuntimeException("Type not found");
        }
        scenarioContext.put(Context.RESPONSE, response);
        scenarioContext.put(Context.REQUEST_BODY, workingClassHeroList);
    }

    @When("As the Bookkeeper, I want to query the amount of tax relief for each person")
    public void queryTheAmountOfTaxReliefForEachPerson() {
        Response response = calculatorControllerService.getTaxRelief();
        scenarioContext.put(Context.RESPONSE, response);
    }

    @When("As the Clerk, I want to upload a csv file is {string} using api")
    public void uploadACsvFileIsUsingApi(String fileName) {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/data/" + fileName;
        Response response = calculatorControllerService.uploadLargeFile(filePath);
        scenarioContext.put(Context.RESPONSE, response);
    }

    @Given("As the Governor, I want to insert {int} random to database")
    public void insertRandomToDatabase(int count) {
        Response response = calculatorControllerService.insertRandomToDatabase(count);
        scenarioContext.put(Context.RESPONSE, response);
    }

    @And("QA verifies that natid must be masked and calculated tax relief must be rounded correctly")
    public void natidMustBeMaskedAndCalculatedTaxReliefMustBeRoundedCorrectly() {
        Response response = scenarioContext.get(Context.RESPONSE);
        TaxRelief[] actualTaxRelief = response.body().as(TaxRelief[].class);

        List<WorkingClassHero> workingClassHeroList = scenarioContext.get(Context.REQUEST_BODY);
        List<TaxRelief> expectedTaxReliefs = calculatorControllerService.calculateTaxReliefList(workingClassHeroList);

        assertThat(actualTaxRelief).usingRecursiveComparison().isEqualTo(expectedTaxReliefs);
    }
}
