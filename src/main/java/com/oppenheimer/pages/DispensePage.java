package com.oppenheimer.pages;

import com.oppenheimer.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class DispensePage extends Base {
    @FindBy(xpath = "//div[@id='app']//div[contains(@class,'display-4')]")
    private WebElement title;

    @Override
    public boolean isAt() {
        return this.wait.until(x -> title.isDisplayed());
    }

    public String getTitleText() {
        return this.title.getText();
    }
}
