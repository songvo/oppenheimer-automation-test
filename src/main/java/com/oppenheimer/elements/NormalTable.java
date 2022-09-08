package com.oppenheimer.elements;

import com.oppenheimer.utils.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NormalTable implements Table {
    private WebElement element;

    private WebDriver driver;

    public NormalTable(WebElement element, WebDriver driver) {
        this.element = element;
        this.driver = driver;
    }

    @Override
    public String getCellTextByIndex(int colIndexFrom1, int rowIndexFrom1) {
        JavaScriptUtils.scrollToElement(element, driver);
        return element.findElement(By.xpath("//tr[" + colIndexFrom1 + "]/td[" + rowIndexFrom1 + "]")).getText();
    }
}
