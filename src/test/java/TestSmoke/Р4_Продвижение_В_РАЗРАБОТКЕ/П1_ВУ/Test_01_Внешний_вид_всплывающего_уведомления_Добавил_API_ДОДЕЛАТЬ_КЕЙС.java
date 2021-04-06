package TestSmoke.Р4_Продвижение_В_РАЗРАБОТКЕ.П1_ВУ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test_01_Внешний_вид_всплывающего_уведомления_Добавил_API_ДОДЕЛАТЬ_КЕЙС extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "1. ВУ")
    @DisplayName(value = "Внешний вид и навигация")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceOfPopUpNotification() {
        headerMenu.goToNilPage();
        flowRegistation();
        given().auth()
                .basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").body("{\"id\":\"yahoo\",\"name\":\"автотест\",\"header\":\"автотест\"," +
                "\"published\":true,\"body\":\"автотест\",\"start_activity\":\"2021-02-25T00:00:00Z\",\"stop_activity\":\"2021-03-25T00:00:00Z\"," +
                "\"notification_type\":\"info\",\"no_pictogram\":false,\"buttons\":[{\"text\":\"Закрыть\",\"type\":\"button_x\",\"action\":\"none\"," +
                "\"accepts_offer\":false},{\"link\":\"mftv://content/Series/Psih_2020\",\"text\":\"Смотреть\",\"type\":\"button_goto\"," +
                "\"action\":\"link\"}],\"processed_images_id\":null,\"notification_duration\":{\"type\":\"date\",\"valid_duration\":3600," +
                "\"valid_until\":\"2021-03-25T18:59:00.000Z\"},\"user_filters\":{\"msisdn_filter\":false,\"bundles_filter\":[9,7,25,5,3,2,1,17]," +
                "\"vk_only_filter\":false,\"package_filter\":[{\"package_id\":\"optimal\",\"ownership_types\":[\"subs1\"]," +
                "\"ownership_statuses\":[\"active\"]}],\"partners\":[\"megafon_tv\"]}}").
                when().
                put("https://bmp-preprod1.megafon.tv/cms/api/v0/notification_factories/yahoo").
                then().
                statusCode(200);
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
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}

