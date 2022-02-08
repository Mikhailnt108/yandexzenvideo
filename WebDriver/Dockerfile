#FROM gitlab.megafon.tv:443/qa/dependency_proxy/containers/mikhailnt87/webdriver_java_maven_proxy:3.8.2
#FROM mikhailnt87/webdriver_java_maven_proxy:3.8.2
FROM openjdk:11-jdk
#WORKDIR /WebDriver
#WORKDIR /home/mtabunkov/auto/autosmoke_mftv_web_and_mobile_web
#WORKDIR /builds/qa/autosmoke_mftv_web_and_mobile_web
#COPY pom.xml .
WORKDIR /gradle
RUN apt-get update && apt-get install -y unzip
RUN curl -L https://services.gradle.org/distributions/gradle-6.0.1-bin.zip -o gradle-6.0.1-bin.zip
RUN unzip gradle-6.0.1-bin.zip
ENV GRADLE_HOME=/gradle/gradle-6.0.1
ENV PATH=$PATH:$GRADLE_HOME/bin
WORKDIR /WebDriver
USER root
#RUN cd ..
COPY . .

#RUN mvn dependency:go-offline
#RUN cd /autosmoke_mftv_web_and_mobile_web/WebDriver
#RUN cd /home/mtabunkov/auto/autosmoke_mftv_web_and_mobile_web/WebDriver
#RUN #cd /builds/qa/autosmoke_mftv_web_and_mobile_web/WebDriver
#ENV http_proxy="http://proxy.megalabs.ru:8808"
#ENV https_proxy="http://proxy.megalabs.ru:8808"

CMD gradle test allureReport allureServe
#io.qameta.allure:allure-maven:install io.qameta.allure:allure-maven:report
#CMD mvn io.qameta.allure:allure-maven:install



