FROM mcr.microsoft.com/playwright/java:v1.18.0-focal
#FROM mikhailnt87/playwright_java_chrome_proxy:97
#FROM gitlab.megafon.tv:443/qa/dependency_proxy/containers/mikhailnt87/playwright_java_chrome_proxy:97

#WORKDIR /home/mtabunkov/auto/autosmoke_mftv_web_and_mobile_web
#WORKDIR /builds/qa/autosmoke_mftv_web_and_mobile_web
#WORKDIR /WebPlaywright
#COPY pom.xml .
#RUN mvn -B -f pom.xml dependency:go-offline
#COPY . .

#RUN cd /builds/qa/autosmoke_mftv_web_and_mobile_web/WebPlaywright
#RUN cd /home/mtabunkov/auto/autosmoke_mftv_web_and_mobile_web/WebPlaywright
#RUN cd /WebPlaywright
#ENV http_proxy="http://proxy.megalabs.ru:8808"
#ENV https_proxy="http://proxy.megalabs.ru:8808"

# Install node14
RUN apt update && apt install -y curl && \
    curl -sL https://deb.nodesource.com/setup_14.x | bash - && \
    apt install -y nodejs

## Upgrade to NPM7 (see https://github.com/microsoft/playwright/pull/8915)
RUN npm install -g npm@8

## Install stable chrome
#RUN npx playwright install chrome
RUN apt-get update && apt-get install -y unzip
WORKDIR /gradle
RUN curl -L https://services.gradle.org/distributions/gradle-6.0.1-bin.zip -o gradle-6.0.1-bin.zip
RUN unzip gradle-6.0.1-bin.zip
ENV GRADLE_HOME=/gradle/gradle-6.0.1
ENV PATH=$PATH:$GRADLE_HOME/bin
#RUN groupadd -r myuser && adduser -r -g myuser myuser
#USER myuser
#RUN newgrp docker
WORKDIR /WebPlaywright
#USER root
#RUN gradle -v
#RUN cd ..
COPY . .
#RUN chown usernonroot:usernonroot
#USER usernonroot
#RUN groupadd --gid 5000 newuser \
#    && useradd --home-dir /home/newuser --create-home --uid 5000 \
#        --gid 5000 --shell /bin/sh --skel /dev/null newuser
#USER newuser
#RUN cd gradle
##CMD HTTP_PROXY=http://proxy.megalabs.ru:8808 HTTPS_PROXY=http://proxy.megalabs.ru:8808 SELENIUM_REMOTE_URL=http://10.236.64.48:4444/wd/hub mvn -pl WebPlaywright clean test
CMD DEBUG=pw:browser* gradle clean test
##CMD SELENIUM_REMOTE_URL=http://192.168.1.139:4444/wd/hub mvn -pl WebPlaywright clean test


