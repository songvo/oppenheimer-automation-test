package com.oppenheimer.steps.portal;

import com.oppenheimer.configs.Color;
import com.oppenheimer.pages.PortalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PortalSteps {
    @Autowired
    private PortalPage portalPage;

    @Given("As the Clerk,/Bookkeeper,/Governor, I want to opened the Oppenheimer portal page")
    public void openOppenheimerPortalPage() {
        this.portalPage.navigateTo();
    }

    @Then("As the Clerk,/Bookkeeper,/Governor, I arrived at Oppenheimer portal page")
    public void asTheClerkIArrivedAtPortalPage() {
        assertThat(this.portalPage.isAt()).isTrue();
    }

    @When("As the Clerk, I want to upload a csv file is {string} to portal")
    public void uploadACsvFileToPortal(String fileName) {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/data/" + fileName;

        portalPage.getTheFirstRowOfFile();//todo
        portalPage.uploadFile(filePath);
    }

    @And("As the Clerk, I want to refresh tax relief table")
    public void refreshTaxReliefTable() {
        portalPage.refreshTaxReliefTable();
    }

    @Then("QA verify the list of working class heroes and their tax relief is populated to table:")
    public void verifyTheListOfWorkingClassHeroesAndTheirTaxRelief(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps();
        for (int col = 0; col < dataList.size(); col++) {
            assertThat(portalPage.getReliefTableCellData(col + 1, 1))
                    .isEqualTo(dataList.get(col).get("NatId"));
            assertThat(portalPage.getReliefTableCellData(col + 1, 2))
                    .isEqualTo(dataList.get(col).get("Relief"));
        }
    }

    @Then("As the Governor, I should be able to see a button on the screen")
    public void asTheGovernorIShouldBeAbleToSeeAButtonOnTheScreen(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps();
        assertThat(portalPage.getDispenseTaxReliefButtonText())
                .isEqualTo(dataList.get(0).get("text"));
        assertThat(portalPage.getDispenseTaxReliefColor())
                .isEqualTo(Color.valueOf(dataList.get(0).get("color")).getColorCode());
    }

    @When("As the Governor, I can dispense tax relief for my working class heroes")
    public void asTheGovernorICanDispenseTaxReliefForMyWorkingClassHeroes() {
        portalPage.clickDispenseTaxReliefButton();
    }
}
