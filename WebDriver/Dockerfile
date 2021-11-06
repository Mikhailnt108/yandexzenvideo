FROM maven:3.8.2-jdk-11

WORKDIR /MFTV_Web_Desktop_Smoke_JUnit5_only

COPY . .

RUN cd /MFTV_Web_Desktop_Smoke_JUnit5_only/WebDriver

CMD mvn -pl WebDriver clean test

