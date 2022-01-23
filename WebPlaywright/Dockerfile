FROM gitlab.megafon.tv:443/qa/dependency_proxy/containers/mikhailnt87/playwright_java_chrome_proxy:97

WORKDIR /builds/qa/autosmoke_mftv_web_and_mobile_web

COPY . .

RUN cd /builds/qa/autosmoke_mftv_web_and_mobile_web/WebPlaywright
ENV http_proxy="http://proxy.megalabs.ru:8808"
ENV https_proxy="http://proxy.megalabs.ru:8808"
# Install node14

#RUN apt-get update && apt-get install -y curl && \
#    curl -sL https://deb.nodesource.com/setup_14.x | bash - && \
#    apt-get install -y nodejs
#
## Upgrade to NPM7 (see https://github.com/microsoft/playwright/pull/8915)
#RUN npm install -g npm@8

## Install stable chrome
#RUN npx playwright install chrome

CMD SELENIUM_REMOTE_URL=http://10.236.64.48:4445/wd/hub mvn -pl WebPlaywright clean test
#CMD mvn -pl WebPlaywright clean test

#SELENIUM_REMOTE_URL=http://internal.grid:4444/wd/hub mvn test