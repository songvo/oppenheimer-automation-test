package com.oppenheimer.services;

import com.oppenheimer.entities.WorkingClassHero;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

@Service
public class CalculatorControllerService {

    @Value("${calculatorCtrl.insertPerson.endpoint}")
    private String insertSinglePersonEndpoint;

    @Value("${calculatorCtrl.insertMultiPerson.endpoint}")
    private String insertMultiPersonEndpoint;

    @Value("${calculatorCtrl.rakeDatabase.endpoint}")
    private String rakeDatabaseEndpoint;

    @Value("${calculatorCtrl.taxRelief.endpoint}")
    private String getTaxReliefEndpoint;

    @Value("${calculatorCtrl.uploadLargeFile.endpoint}")
    private String uploadLargeFileEndpoint;

    @Value("${calculatorCtrl.insertRandomToDatabase.endpoint}")
    private String insertRandomToDatabaseEndpoint;

    @Value("${host}")
    private String host;

    @Value("${port}")
    private int port;

    @PostConstruct
    public void postConstruct() {
        RestAssured.baseURI = this.host;
        RestAssured.port = this.port;
    }

    public Response insertPerson(WorkingClassHero workingClassHero) {
        return given()
                .header("Content-Type", "application/json")
                .body(workingClassHero)
                .when()
                .post(insertSinglePersonEndpoint);
    }

    public Response insertMultiPerson(List<WorkingClassHero> workingClassHeroList) {
        return given()
                .header("Content-Type", "application/json")
                .body(workingClassHeroList)
                .when()
                .post(insertMultiPersonEndpoint);
    }

    public Response rakeDatabase() {
        return given()
                .header("Content-Type", "application/json")
                .body("")
                .when()
                .post(rakeDatabaseEndpoint);
    }

    public Response getTaxRelief() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(getTaxReliefEndpoint);
    }

    public Response uploadLargeFile(String filePath) {
        File file = new File(filePath);
        return given()
                .multiPart("file", file)
                .body("")
                .when()
                .post(uploadLargeFileEndpoint);
    }

    public Response insertRandomToDatabase(int count) {
        return given()
                .header("Content-Type", "application/json")
                .queryParam("count", count)
                .body("")
                .when()
                .post(insertRandomToDatabaseEndpoint);
    }
}
