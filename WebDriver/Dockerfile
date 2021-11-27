FROM maven:3.8.2-jdk-11

WORKDIR /AutoSmoke_MFTV
#COPY pom.xml .
COPY . .

#RUN mvn dependency:go-offline
RUN cd /AutoSmoke_MFTV/WebDriver


CMD mvn -pl WebDriver clean test
#io.qameta.allure:allure-maven:install io.qameta.allure:allure-maven:report
#CMD mvn io.qameta.allure:allure-maven:install



