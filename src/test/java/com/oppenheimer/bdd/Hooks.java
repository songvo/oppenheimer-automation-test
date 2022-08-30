package com.oppenheimer.bdd;

import com.oppenheimer.helpers.ScreenshotHelper;
import io.cucumber.java.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Slf4j
public class Hooks {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ScreenshotHelper screenshotService;

    public static ThreadLocal<Scenario> scenarios = new ThreadLocal<>();

    @BeforeAll
    public static void beforeAll() {

    }

    @AfterAll
    public static void afterAll() {

    }

    @Before("@api")
    public void setupForServices(Scenario scenario) {
        log.info(String.format("[Thread %2d] Running -> [Scenario: %s]%n",
                Thread.currentThread().getId(), scenario.getName()));
    }

    @After("@api")
    public void teardownForServices(Scenario scenario) {
    }

    @Before("@ui")
    public void setup(Scenario scenario) {
        log.info(String.format("[Thread %2d] Running -> [Scenario: %s]%n",
                Thread.currentThread().getId(), scenario.getName()));
    }

    @After("@ui")
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", "***** Screenshot attachment *****");
        }
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
