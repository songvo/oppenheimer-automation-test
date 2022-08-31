package com.oppenheimer.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NormalTable implements Table {
    private WebElement element;

    public NormalTable(WebElement element) {
        this.element = element;
    }

    @Override
    public String getCellTextByIndex(int colIndexFrom1, int rowIndexFrom1) {
        return element.findElement(By.xpath("//tr[" + colIndexFrom1 + "]/td[" + rowIndexFrom1 + "]")).getText();
    }
}
