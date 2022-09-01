package com.oppenheimer.steps.services;

import com.oppenheimer.bdd.Context;
import com.oppenheimer.bdd.ScenarioContext;
import com.oppenheimer.entities.WorkingClassHero;
import com.oppenheimer.services.CalculatorControllerService;
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

    @When("As the Clerk, I want to insert {recordType} record(s) of working class hero as following details:")
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
    }

    @When("As the Bookkeeper, I want to query the amount of tax relief for each person")
    public void queryTheAmountOfTaxReliefForEachPerson() {
        Response response = calculatorControllerService.getTaxRelief();
        scenarioContext.put(Context.RESPONSE, response);
    }

    @When("As the Clerk, I want to upload a csv file is {string} using api")
    public void asTheClerkIWantToUploadACsvFileIsUsingApi(String fileName) {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/data/" + fileName;
        Response response = calculatorControllerService.uploadLargeFile(filePath);
        scenarioContext.put(Context.RESPONSE, response);
    }
}
