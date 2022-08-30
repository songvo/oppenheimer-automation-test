package com.oppenheimer.elements;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class Windows {
    @Autowired
    private WebDriver driver;

    public void switchToFirstWindow() {
        Set<String> handles = driver.getWindowHandles();
        List<String> handleList = new ArrayList<>(handles);
        driver.switchTo().window(handleList.get(0));
    }

    public void switchToLastWindow() {
        Set<String> handles = driver.getWindowHandles();
        List<String> handleList = new ArrayList<>(handles);
        driver.switchTo().window(handleList.get(handleList.size() - 1));
    }

    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    public void switchToWindow(String nameOrHandle) {
        driver.switchTo().window(nameOrHandle);
    }

    public void switchToNextWindow() {
        String originalWindow = driver.getWindowHandle();
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
