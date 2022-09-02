# About the project

## Technologies
* Spring boot
* Java 11
* Selenium
* Gradle Wrapper
* Cucumber
* AssertJ
* RestAssured
* Log4J

## Installation
1. Install the softwares on your machine: Java, Git
2. Clone the source:
   ```bash
    git clone https://github.com/songvo/oppenheimer-automation-test.git
   ```
3. Navigate to `oppenheimer-automation-test` project folder
4. Change `browser.download` property in `application.properties` file to your browser setting
5. Run this command line which means "run all the tests with tags is @regression"
   ```bash
   ./gradlew cucumberCli -Ptags='@regression'
   ```
6. The report will generate in `target > cucumber > cucumber-report.html`. There are some example reports here
7. The feature files is in `main > test > resources > features`

## How to run and debug on IDE
1. Install IntelliJ
2. Add Plugin: Cucumber, Lombok for IntelliJ
3. At Gradle panel, select Reload All Gradle projects
4. Open CucumberTestRunner.java then right click and run or debug
5. Able to update the tags to run each cases
   1. @portal : tag for ui
   2. @service: tag for api
   3. @regression: tag for both

## Features
* Support multiple browsers chrome, edge, safari, ....
* Generate report after run `CucumberTestRunner` or `cucumberCli task`
  * Refer example report in target > cucumber
* Run parallel with multi threads which is config in `cucumberCli task` in `build.gradle`
* Take screenshot and attach to report
* Able to run with different tags
* Call the API and verify the response

## Framework
* Using Selenium and Cucumber on top of Spring framework
* Gradle wrapper to manage the gradle version
* Apply Page Object Model
* Apply BDD using Cucumber
* Using different profile for each environment ex st, sit1, sit2,...
* AssertJ is awesome lib for assertion
* RestAssure for sending the API
* Log4j to log to file

