FROM gitlab.megafon.tv:443/qa/dependency_proxy/containers/mikhailnt87/webdriver_java_maven_proxy:3.8.2

WORKDIR /builds/qa/autosmoke_mftv_web_and_mobile_web
#COPY pom.xml .
COPY . .

#RUN mvn dependency:go-offline
RUN cd /builds/qa/autosmoke_mftv_web_and_mobile_web/WebDriver
ENV http_proxy="http://proxy.megalabs.ru:8808"
ENV https_proxy="http://proxy.megalabs.ru:8808"

CMD mvn -pl WebDriver clean test
#io.qameta.allure:allure-maven:install io.qameta.allure:allure-maven:report
#CMD mvn io.qameta.allure:allure-maven:install



