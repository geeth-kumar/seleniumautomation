# Selenium Automation Framework

A Java-based Selenium WebDriver automation framework using Maven, TestNG, Page Object Model (POM), Log4j, and Jenkins.

## Technologies Used

- Java 25
- Selenium WebDriver 4.35.0
- TestNG 7.11.0
- Maven
- Log4j 2
- Jenkins
- Git & GitHub
- Eclipse IDE

## Framework Structure

```text
src
├── main
│   └── java
│       └── seleniumautomation
│           ├── pages
│           │   ├── BasePage.java
│           │   ├── LoginPage.java
│           │   ├── SecureAreaPage.java
│           │   └── AddRemoveElementsPage.java
│           │
│           └── utils
│               ├── WaitUtils.java
│               └── LogUtils.java
│
└── test
    └── java
        └── seleniumautomation
            └── tests
                ├── BaseTest.java
                ├── LoginTest.java
                ├── InvalidLoginTest.java
                ├── LoginDataTest.java
                ├── AddRemoveElementsTest.java
                ├── ConfigTest.java
                ├── ExceptionTest.java
                ├── ReportingTest.java
                └── ScreenshotFailureTest.java

pom.xml
.gitignore
README.md# Selenium Automation Framework

A Java-based Selenium WebDriver automation framework designed for web application testing using Selenium, TestNG, Maven, Page Object Model (POM), Log4j, Git/GitHub, and Jenkins.

## Project Overview

This project demonstrates an entry-level QA automation framework with reusable components, automated test cases, test data handling, screenshots on failure, logging, reporting, Maven execution, and Jenkins CI integration.

## Technologies Used

* **Java 25**
* **Selenium WebDriver 4.35.0**
* **TestNG 7.11.0**
* **Maven**
* **Log4j 2**
* **Git & GitHub**
* **Jenkins**
* **Eclipse IDE**

## Framework Features

* Page Object Model (POM)
* Reusable BasePage
* BaseTest for common test setup and teardown
* Explicit waits
* TestNG assertions
* TestNG DataProvider
* Configuration properties
* Screenshot capture on test failure
* Log4j logging
* Maven test execution
* TestNG test reporting
* Jenkins CI execution
* Dynamic XPath
* Dropdown handling
* Checkboxes and radio buttons
* Alerts
* Frames
* Multiple browser windows
* Cookies
* WebTables
* File upload
* File download
* Auto-suggestions
* Calendar handling

## Project Structure

```text
seleniumautomation
│
├── src
│   ├── main
│   │   └── java
│   │       └── seleniumautomation
│   │           ├── pages
│   │           │   ├── BasePage.java
│   │           │   ├── LoginPage.java
│   │           │   ├── SecureAreaPage.java
│   │           │   └── AddRemoveElementsPage.java
│   │           │
│   │           └── utils
│   │               ├── LogUtils.java
│   │               └── WaitUtils.java
│   │
│   └── test
│       ├── java
│       │   └── seleniumautomation
│       │       ├── tests
│       │       │   ├── BaseTest.java
│       │       │   ├── LoginTest.java
│       │       │   ├── InvalidLoginTest.java
│       │       │   ├── LoginDataTest.java
│       │       │   ├── AddRemoveElementsTest.java
│       │       │   ├── ConfigTest.java
│       │       │   ├── ExceptionTest.java
│       │       │   ├── ReportingTest.java
│       │       │   └── ScreenshotFailureTest.java
│       │       │
│       │       ├── AutoSuggestionTest.java
│       │       ├── CalendarTest.java
│       │       ├── CheckboxTest.java
│       │       ├── CookieTest.java
│       │       ├── DataProviderTest.java
│       │       ├── DynamicXPathTest.java
│       │       ├── FileDownloadTest.java
│       │       ├── FileUploadTest.java
│       │       ├── MultipleWindowTest.java
│       │       ├── RadioButtonTest.java
│       │       └── WebTableTest.java
│       │
│       └── resources
│           ├── config.properties
│           └── log4j2.properties
│
├── testdata
│   └── sample.txt
│
├── testng.xml
├── pom.xml
├── .gitignore
└── README.md
```

## How to Run the Tests

### Using Maven

Open a terminal in the project directory and run:

```bash
mvn clean test
```

### Using Eclipse

Right-click a TestNG test class and select:

```text
Run As → TestNG Test
```

## Test Execution with Jenkins

The project is integrated with Jenkins for continuous integration.

Jenkins executes the Maven test command:

```bash
mvn clean test
```

The TestNG results are published in Jenkins after execution.

The current automation suite has successfully executed **29 tests** through Jenkins.

## Git Workflow

The project is maintained using Git and GitHub.

Typical workflow:

```bash
git add .
git commit -m "Update automation tests"
git push
```

## Future Enhancements

* API testing with Postman
* SQL/database validation
* JIRA integration
* Additional CI/CD improvements
* Expanded automation coverage

## Author

**Geeth Kumar**

QA Automation / Software Testing
