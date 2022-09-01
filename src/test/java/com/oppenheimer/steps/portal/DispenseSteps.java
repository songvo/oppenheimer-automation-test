package com.oppenheimer.steps.portal;

import com.oppenheimer.pages.DispensePage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DispenseSteps {

    @Autowired
    private DispensePage dispensePage;

    @Then("QA verifies that dispense page will be displayed with text {string}")
    public void qaVerifiesThatDispensePageWillBeDisplayed(String expectedText) {
        dispensePage.isAt();
        assertThat(this.dispensePage.getTitleText()).isEqualTo(expectedText);
    }
}
