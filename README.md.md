***Selenium Test Automation Framework (End-to-End)***



**Project Overview**

This project is a real-world, end-to-end Selenium Test Automation Framework designed to automate web application testing using industry best practices.

It supports parallel execution, retry mechanism, rich reporting, screenshots on failure, and environment/browser flexibility using Maven and Jenkins-ready configurations.



The framework follows Page Object Model (POM) with a clean separation of concerns, making it scalable, maintainable, and production-ready.





**Tech Stack**



Language: Java



Automation Tool: Selenium WebDriver



Test Framework: TestNG



Build Tool: Maven



Design Pattern: Page Object Model (POM)



Reporting: Extent Reports



Logging: SLF4J



CI Ready: Jenkins



Parallel Execution: TestNG + ThreadLocal WebDriver





**Framework Architecture**

BaseTest        → Test lifecycle management

BaseDriver     → Driver factory (browser initialization)

BasePage       → Common page utilities

Pages          → Page Object classes

Utils          → Config, Wait, Retry

Listeners      → Retry, Screenshot, Reporting

Tests          → TestNG test classes



Key Principle :

Each layer has one responsibility only (Single Responsibility Principle).





**How to Run Tests**

Option 1: Run from IntelliJ



Import project as Maven Project



Right-click:



testng.xml → Run



OR individual test classes



Reports and screenshots will be generated automatically



Option 2: Run using Maven (Recommended)

mvn clean test



Run with specific browser:

mvn clean test -Dbrowser=chrome

mvn clean test -Dbrowser=firefox





Browser value is picked dynamically via configuration.



Parallel Execution



Parallel execution is enabled using TestNG + ThreadLocal WebDriver.



<suite name="Automation Suite" parallel="methods" thread-count="3">





✔ Each test runs in its own browser instance

✔ Thread safety ensured using ThreadLocal<WebDriver>

✔ Scales easily in CI/CD pipelines





**Reporting**



Extent Reports generated after every execution



Single consolidated report even in parallel execution



Shows:



Passed / Failed tests



Execution time



Failure screenshots



Logs



Location :



/reports/ExtentReport.html





**Retry Mechanism**



A custom RetryAnalyzer is implemented to re-run failed tests automatically.



Prevents false failures



Configurable retry count



Integrated using TestNG listeners



implements IRetryAnalyzer





**Screenshots on Failure**



Automatically captured on test failure



Stored with test method name



Attached to Extent Report



Location:



/screenshots/





**Folder Structure**

src

├── main

│   └── java

│       └── framework

│           ├── base

│           ├── pages

│           ├── utils

│           └── listeners

├── test

│   └── java

│       └── framework

│           └── tests

|	├── utils

│

├── resources

│   └── Config.properties

│

├── screenshots

├── reports

├── pom.xml

├── testng.xml

└── README.md





**Key Features Summary**



✔ Page Object Model

✔ Parallel Execution

✔ Thread-safe WebDriver

✔ Retry on failure

✔ Screenshot on failure

✔ Extent Reports

✔ Maven + Jenkins ready

✔ Clean, scalable architecture





**Author**



Ramyashree (SDET)

