package com.oppenheimer;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = com.oppenheimer.CucumberTestConfig.class)
public class CucumberSpringConfiguration {
}
