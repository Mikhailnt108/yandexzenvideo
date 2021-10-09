FROM mcr.microsoft.com/playwright/java:latest

WORKDIR /MFTV_Web_Desktop_Smoke_JUnit5_only

COPY . .

RUN cd /MFTV_Web_Desktop_Smoke_JUnit5_only/WebPlaywright/target
RUN mkdir allure-results
CMD mvn -pl WebPlaywright clean test
CMD mvn io.qameta.allure:allure-maven:report

