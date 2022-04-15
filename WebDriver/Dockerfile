FROM openjdk:11-jdk

WORKDIR /gradle
RUN apt-get update && apt-get install -y unzip
RUN curl -L https://services.gradle.org/distributions/gradle-7.4.2-bin.zip -o gradle-7.4.2-bin.zip
RUN unzip gradle-7.4.2-bin.zip
ENV GRADLE_HOME=/gradle/gradle-7.4.2
ENV PATH=$PATH:$GRADLE_HOME/bin
WORKDIR /WebDriver
USER root

COPY . .

CMD gradle clean test allureReport allureServe




