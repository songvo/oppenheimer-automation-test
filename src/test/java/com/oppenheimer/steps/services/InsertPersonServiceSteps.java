package com.oppenheimer.steps.services;

import com.oppenheimer.bdd.Context;
import com.oppenheimer.bdd.ScenarioContext;
import com.oppenheimer.entities.WorkingClassHero;
import com.oppenheimer.services.InsertPersonService;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsertPersonServiceSteps {
    @Autowired
    private InsertPersonService insertPersonService;

    @Autowired
    private ScenarioContext scenarioContext;

    @When("As the Clerk, I want to insert {recordType} record\\(s) of working class hero as following details:")
    public void insertWorkingClassHeroes(String type, List<WorkingClassHero> workingClassHeroList) {
        Response response;
        switch (type) {
            case "single":
                assertThat(workingClassHeroList.size()).isEqualTo(1);
                response = this.insertPersonService.insertPerson(workingClassHeroList.get(0));
                break;
            case "multiple":
                response = this.insertPersonService.insertMultiPerson(workingClassHeroList);
                break;
            default:
                throw new RuntimeException("Type not found");
        }
        scenarioContext.put(Context.RESPONSE, response);
    }
}
