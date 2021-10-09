FROM mcr.microsoft.com/playwright/java:latest

WORKDIR /MFTV_Web_Desktop_Smoke_JUnit5_only

COPY . .
RUN pwd
RUN ls -l
RUN cd /MFTV_Web_Desktop_Smoke_JUnit5_only/WebPlaywright
RUN ls -l
RUN mkdir target
CMD mvn -pl WebPlaywright clean test
CMD mvn io.qameta.allure:allure-maven:report

