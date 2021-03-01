package TestSmoke.Р4_Продвижение_В_РАЗРАБОТКЕ.П3_Персональные_предложения;

import base.TestBase;
import io.qameta.allure.*;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;



public class Test_01_Внешний_вид_и_навигация_Добавил_API_ДОДЕЛАТЬ_КЕЙС extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "Внешний вид и навигация")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void registerFromHeaderMenu()  {
        headerMenu.goToNilPage();
        flowRegistation();
        given().auth()
                .basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").body("{\"id\":\"yahoo6\",\"ad_campaign_id\":\"Test2\",\"name\":\"Код-группа 7\", " +
                "\"published\":true,\"valid_from\":\"2021-02-12T21:00:00Z\",\"valid_to\":\"2021-03-12T21:00:00Z\",\"description_popup\":\"опс\"," +
                "\"description_promotion\":\"опс\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                "\"group_package\": {\"id\": \"Mixed_start\", \"date\": \"2021-03-12T21:00:00Z\", \"only_new\": false, \"tnb_type\": \"hard\", " +
                "\"ownership_type\": \"date\"}}}").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/ad_campaigns/Test2/add_code_group").
                then().
                statusCode(200);
        given().auth()
                .basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").body("{\"id\":\"yahoo6\",\"ad_campaign_id\":\"Test2\",\"name\":\"Код-группа 7\", " +
                "\"published\":true,\"valid_from\":\"2021-02-12T21:00:00Z\",\"valid_to\":\"2021-03-12T21:00:00Z\",\"description_popup\":\"опс\"," +
                "\"description_promotion\":\"опс\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                "\"group_package\": {\"id\": \"Mixed_start\", \"date\": \"2021-03-12T21:00:00Z\", \"only_new\": false, \"tnb_type\": \"hard\", " +
                "\"ownership_type\": \"date\"}}}").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/ad_campaigns/Test2/add_code_group").
                then().
                statusCode(200);
        LOGGER.info("New code_group has been added." + "\n");

        pageCMS.deleteAccount();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
