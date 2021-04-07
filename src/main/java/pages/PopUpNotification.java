package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static io.restassured.RestAssured.given;

public class PopUpNotification extends BasePage {
    public PopUpNotification(WebDriver driver) {super(driver);}

    public void createAndPublishedPopUpNotifPayFilm() {
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").body("{\"id\":\"autotest\",\"name\":\"автотест\",\"header\":\"автотест\",\"published\":true," +
                "\"body\":\"тело\",\"start_activity\":\"2021-04-07T12:56:00Z\",\"stop_activity\":\"2021-04-30T12:56:00Z\",\"notification_type\":" +
                "\"text\",\"no_pictogram\":false,\"buttons\":[{\"text\":\"Закрыть\",\"type\":\"button_x\",\"action\":\"none\",\"accepts_offer\":false}," +
                "{\"text\":\"Купить\",\"type\":\"button_other\",\"action\":\"purchase\",\"purchase_package_id\":\"Dovod_2020\"}],\"processed_images_id\":" +
                "null,\"images\":{\"tile_notification\":" +
                "\"https://static-sesure.cdn.megafon.tv/images/notifications/6a/d7/87d3a9a18e2ea9f7fb8df5c30240d03196bb/tile_notification__web.jpeg\"}," +
                "\"notification_duration\":{\"type\":\"date\",\"valid_until\":\"2021-04-30T12:56:00Z\",\"valid_duration\":3600},\"user_filters\":" +
                "{\"msisdn_filter\":false,\"auth_filter\":\"registered\",\"vk_only_filter\":false,\"partners\":[\"megafon_tv\"]}}").
                when().
                put("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest").
                then().
                statusCode(200);
    }

    public void checkElementsPopUpNotifPayFilm() {
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//button)[3]"));
        isElementDisplayed(By.className("x8TnYuA0SaYGPCw7RRFOL"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//h3[text()='автотест']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//div[text()='тело']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Купить']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Закрыть']"));
    }

    public void deletePopUpNotification() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                delete("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest").
                then().
                statusCode(204);
    }
}
