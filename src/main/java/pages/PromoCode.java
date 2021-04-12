package pages;

import base.BasePage;
import base.TestBase;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;

public class PromoCode extends BasePage {
    public PromoCode (WebDriver driver)
    { super(driver); }

    public void createAndPublishedRC() {
        //Создание рекламной кампании:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("id", "RC_autotest").
                multiPart("name", "РК автотест").
                when().post("https://bmp-preprod2.megafon.tv/cms/ad_campaigns/create").
                then().statusCode(302);


    }

    public void archiveCodeGroupPackageStartSoftTnB() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                when().get("https://bmp-preprod2.megafon.tv/cms/code_groups/CG_autotest_SotTnb/toggle_publish").
                then().statusCode(200);
    }
    public void createAndPublishedCodeGroupAndPromoCodePackageStartSoftTnB() {
        //Создание и активация код-группы:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"CG_autotest_SotTnb\",\"ad_campaign_id\":\"RC_autotest\",\"name\":\"Код-группа для автотестов Мягкий ТнБ\", " +
                        "\"published\":true,\"valid_from\":\"2021-03-30T00:00:00Z\",\"valid_to\":\"2021-10-01T00:00:00Z\",\"description_popup\":\"текст для описания\"," +
                        "\"description_promotion\":\"текст для описания\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                        "\"group_package\": {\"id\": \"Mixed_start\", \"date\": \"2021-10-01T00:00:00Z\", \"only_new\": false, \"tnb_type\": \"soft\", " +
                        "\"ownership_type\": \"date\"}}}").
                when().post("https://bmp-preprod2.megafon.tv/cms/ad_campaigns/RC_autotest/add_code_group").
                then().statusCode(200);
        //Создание промокода:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "promoCodeSoftTnB").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post("https://bmp-preprod2.megafon.tv/cms/code_groups/CG_autotest_SotTnb/add_promocode").
                then().statusCode(302);
    }

    public void createAndPublishedCodeGroupAndPromoCodePackageMoreTvHardTnB() {
        //Создание и активация код-группы:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"CG_autotest_HardTnB\",\"ad_campaign_id\":\"RC_autotest\",\"name\":\"Код-группа для автотестов Жёсткий ТнБ\", " +
                        "\"published\":true,\"valid_from\":\"2021-03-30T00:00:00Z\",\"valid_to\":\"2021-10-01T00:00:00Z\",\"description_popup\":\"текст для описания\"," +
                        "\"description_promotion\":\"текст для описания\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                        "\"group_package\": {\"id\": \"Mixed_more_tv\", \"date\": \"2021-10-01T00:00:00Z\", \"only_new\": false, \"tnb_type\": \"hard\", " +
                        "\"ownership_type\": \"date\"}}}").
                when().post("https://bmp-preprod2.megafon.tv/cms/ad_campaigns/RC_autotest/add_code_group").
                then().statusCode(200);
        //Создание промокода:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "promoCodeHardTnB").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post("https://bmp-preprod2.megafon.tv/cms/code_groups/CG_autotest_HardTnB/add_promocode").
                then().statusCode(302);
    }


}
