package com.oppenheimer.bdd;

import com.oppenheimer.utils.ScreenshotUtils;
import com.oppenheimer.services.InsertPersonService;
import io.cucumber.java.*;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

@Slf4j
public class Hooks {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ScreenshotUtils screenshotService;

//    @Autowired
//    private InsertPersonService insertPersonService;

    public static ThreadLocal<Scenario> scenarios = new ThreadLocal<>();

    @BeforeAll
    public static void beforeAll() {

    }

    @AfterAll
    public static void afterAll() {

    }

    @Before("@service")
    public void setupForServices(Scenario scenario) {
        log.info(String.format("[Thread %2d] Running -> [Scenario: %s]%n",
                Thread.currentThread().getId(), scenario.getName()));
    }

    @After("@service")
    public void teardownForServices(Scenario scenario) {
//        this.insertPersonService.rakeDatabase(); // Clear database
    }

    @Before("@portal")
    public void setup(Scenario scenario) {
        log.info(String.format("[Thread %2d] Running -> [Scenario: %s]%n",
                Thread.currentThread().getId(), scenario.getName()));
    }

    @After("@portal")
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", "***** Screenshot attachment *****");
        }
        this.applicationContext.getBean(WebDriver.class).quit();
//        this.insertPersonService.rakeDatabase(); // Clear database
    }
}
