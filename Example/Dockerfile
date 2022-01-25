FROM mcr.microsoft.com/playwright/java:v1.18.0-focal
#FROM mikhailnt87/playwright_java_chrome_proxy:97
#FROM gitlab.megafon.tv:443/qa/dependency_proxy/containers/mikhailnt87/playwright_java_chrome_proxy:97

#WORKDIR /home/mtabunkov/auto/autosmoke_mftv_web_and_mobile_web
#WORKDIR /builds/qa/autosmoke_mftv_web_and_mobile_web
WORKDIR /autosmoke_mftv_web_and_mobile_web

COPY . .

#RUN cd /builds/qa/autosmoke_mftv_web_and_mobile_web/WebPlaywright
#RUN cd /home/mtabunkov/auto/autosmoke_mftv_web_and_mobile_web/WebPlaywright
RUN cd /autosmoke_mftv_web_and_mobile_web/Example
#ENV http_proxy="http://proxy.megalabs.ru:8808"
#ENV https_proxy="http://proxy.megalabs.ru:8808"
# Install node14

RUN apt update && apt install -y curl && \
    curl -sL https://deb.nodesource.com/setup_14.x | bash - && \
    apt install -y nodejs

## Upgrade to NPM7 (see https://github.com/microsoft/playwright/pull/8915)
RUN npm install -g npm@8

## Install stable chrome
RUN npx playwright install chrome

#CMD HTTP_PROXY=http://proxy.megalabs.ru:8808 HTTPS_PROXY=http://proxy.megalabs.ru:8808 SELENIUM_REMOTE_URL=http://10.236.64.48:4444/wd/hub mvn -pl WebPlaywright clean test
#CMD mvn -pl WebPlaywright clean test
CMD DEBUG=pw:browser* SELENIUM_REMOTE_URL=http://192.168.1.139:4444/wd/hub mvn -pl Example clean test

#SELENIUM_REMOTE_URL=http://internal.grid:4444/wd/hub mvn test