FROM maven:3.8.2-jdk-11

WORKDIR /MFTV_Web_Desktop_Smoke_JUnit5_only
#COPY pom.xml .
COPY . .
#RUN mvn dependency:go-offline
RUN cd /MFTV_Web_Desktop_Smoke_JUnit5_only/WebDriver


CMD mvn -pl WebDriver clean test
#io.qameta.allure:allure-maven:install io.qameta.allure:allure-maven:report
#CMD mvn io.qameta.allure:allure-maven:install



