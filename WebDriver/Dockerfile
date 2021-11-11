FROM maven:3.8.2-jdk-11

WORKDIR /MFTV_Web_Desktop_Smoke_JUnit5_only

COPY . .

RUN cd /MFTV_Web_Desktop_Smoke_JUnit5_only/WebDriver
RUN mkdir target
RUN cd target
RUN mkdir site
RUN cd site
RUN mkdir allure-maven-plugin
#RUN mkdir site
#RUN cd site
#RUN mkdir allure-maven-plugin

CMD mvn -pl WebDriver clean test
CMD mvn -pl WebDriver io.qameta.allure:allure-maven:report

