FROM ${CI_DEPENDENCY_PROXY_GROUP_IMAGE_PREFIX}/mikhailnt87/playwright_java_chrome:97

WORKDIR /builds/qa/autosmoke_mftv_web_and_mobile_web

COPY . .

RUN cd /builds/qa/autosmoke_mftv_web_and_mobile_web/mWebPlaywright
#ENV http_proxy="http://proxy.megalabs.ru:8808"
#ENV https_proxy="http://proxy.megalabs.ru:8808"
# Install node14
#RUN apt-get update && apt-get install -y curl && \
#    curl -sL https://deb.nodesource.com/setup_14.x | bash - && \
#    apt-get install -y nodejs
## Upgrade to NPM7 (see https://github.com/microsoft/playwright/pull/8915)
#RUN npm install -g npm@8
#
### Install stable chrome
#RUN npx playwright install chrome
#CMD SELENIUM_REMOTE_URL=http://192.168.1.139:4444/wd/hub mvn -pl WebPlaywright clean test
CMD mvn -pl mWebPlaywright clean test

