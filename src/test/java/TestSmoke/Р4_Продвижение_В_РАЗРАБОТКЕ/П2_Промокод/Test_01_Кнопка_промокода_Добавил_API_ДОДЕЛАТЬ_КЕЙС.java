package TestSmoke.Р4_Продвижение_В_РАЗРАБОТКЕ.П2_Промокод;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class Test_01_Кнопка_промокода_Добавил_API_ДОДЕЛАТЬ_КЕЙС extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "2. Промокод")
    @DisplayName(value = "Кнопка промокода")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceOfPopUpNotification() {
        //headerMenu.goToNilPage();
        //flowRegistation();
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("id", "RK_autotest").
                multiPart("name", "english_name").
                when().post("https://bmp-preprod1.megafon.tv/cms/ad_campaigns/create").
                then().statusCode(302);
        //LOGGER.info("New RK has been created." + "\n");
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"KD_autotest\",\"ad_campaign_id\":\"RK_autotest\",\"name\":\"Код-группа для автотестов\", " +
                "\"published\":true,\"valid_from\":\"2021-02-12T21:00:00Z\",\"valid_to\":\"2021-03-12T21:00:00Z\",\"description_popup\":\"опс\"," +
                "\"description_promotion\":\"опс\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                "\"group_package\": {\"id\": \"Mixed_start\", \"date\": \"2021-03-12T21:00:00Z\", \"only_new\": false, \"tnb_type\": \"hard\", " +
                "\"ownership_type\": \"date\"}}}").
                when().
                post("https://bmp-preprod1.megafon.tv/cms/ad_campaigns/RK_autotest/add_code_group").
                then().
                statusCode(200);
        //LOGGER.info("New code group has been created." + "\n");
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "yahoo1").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post("https://bmp-preprod1.megafon.tv/cms/code_groups/KD_autotest/add_promocode").
                then().statusCode(302);
        //LOGGER.info("New promocode has been created." + "\n");
        //pageCMS.deleteAccount();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
