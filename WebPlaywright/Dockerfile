FROM mcr.microsoft.com/playwright/java:v1.16.1-focal

WORKDIR /MFTV_Web_Desktop_Smoke_JUnit5_only/WebPlaywright

COPY . .

RUN cd /MFTV_Web_Desktop_Smoke_JUnit5_only/WebPlaywright
# Install node14
RUN apt-get update && apt-get install -y curl && \
    curl -sL https://deb.nodesource.com/setup_14.x | bash - && \
    apt-get install -y nodejs

# Upgrade to NPM7 (see https://github.com/microsoft/playwright/pull/8915)
RUN npm install -g npm@7

# Install stable chrome
RUN npx playwright install chrome

CMD mvn -pl WebPlaywright clean test


