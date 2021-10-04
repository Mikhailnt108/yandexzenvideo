FROM mcr.microsoft.com/playwright/java:latest

WORKDIR /tests

COPY . .

CMD mvn -pl WebPlaywright clean test