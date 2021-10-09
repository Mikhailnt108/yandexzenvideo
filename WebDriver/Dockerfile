FROM maven:3.8.2-jdk-11

WORKDIR /MFTV_Web_Desktop_Smoke_JUnit5_only

COPY . .

RUN pwd
RUN ls -l
RUN cd /MFTV_Web_Desktop_Smoke_JUnit5_only/WebPlaywright
RUN mkdir target/allure-results

CMD mvn -pl WebDriver clean test
CMD mvn io.qameta.allure:allure-maven:report