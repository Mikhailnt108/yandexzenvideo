FROM maven:3.8.2-jdk-11

WORKDIR /tests

COPY . .

CMD ["mvn -pl WebDriver clean test", "mvn io.qameta.allure:allure-maven:report"]