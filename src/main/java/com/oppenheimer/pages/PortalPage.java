package com.oppenheimer.pages;

import com.oppenheimer.annotations.Page;
import com.oppenheimer.elements.NormalTable;
import com.oppenheimer.elements.Table;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;

@Page
public class PortalPage extends Base{
    @Value("${application.url}")
    private String url;

    @FindBy(xpath = "//blockquote/preceding-sibling::h1")
    private WebElement title;

    @FindBy(xpath = "//input[@class='custom-file-input']")
    private WebElement uploadCSVFileInput;

    @FindBy(xpath = "//button[contains(@class, 'primary')]")
    private WebElement refreshTaxReliefTableButton;

    @FindBy(tagName = "table")
    private WebElement reliefTableElm;

    @FindBy(xpath = "//a[contains(@class, 'danger')]")
    private WebElement dispenseButtonElm;

    @Override
    public boolean isAt() {
        return this.wait.until(x -> this.title.isDisplayed());
    }

    public void navigateTo() {
        this.driver.get(this.url);
    }

    public void uploadFile(String filePath) {
        this.uploadCSVFileInput.sendKeys(filePath);
    }

    public void getTheFirstRowOfFile() {

    }

    public void refreshTaxReliefTable() {
        this.refreshTaxReliefTableButton.click();
    }

    public String getReliefTableCellData(int colStartFrom1, int rowStartFrom1) {
        Table reliefTable = new NormalTable(reliefTableElm);
        return reliefTable.getCellTextByIndex(colStartFrom1, rowStartFrom1);
    }

    public String getDispenseTaxReliefButtonText() {
        return this.wait.until(ExpectedConditions.visibilityOf(dispenseButtonElm)).getText();
    }

    public String getDispenseTaxReliefColor() {
        String backgroundColor = dispenseButtonElm.getCssValue("background-color");
        return Color.fromString(backgroundColor).asHex();
    }

    public void clickDispenseTaxReliefButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(dispenseButtonElm)).click();
    }
}
