package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static io.restassured.RestAssured.given;

public class PopUpNotification extends BasePage {
    public PopUpNotification(WebDriver driver) {super(driver);}

    public void createAndPublishedPopUpNotifScreenNilPayFilm() {
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").body("{\"id\":\"autotest1\",\"name\":\"автотест ВУ\",\"header\":\"автотест ВУ для экрана НиЛ\",\"published\":true," +
                "\"body\":\"тело\",\"start_activity\":\"2021-04-07T12:56:00Z\",\"stop_activity\":\"2021-04-30T12:56:00Z\",\"notification_type\":" +
                "\"text\",\"no_pictogram\":false,\"buttons\":[{\"text\":\"Закрыть\",\"type\":\"button_x\",\"action\":\"none\",\"accepts_offer\":false}," +
                "{\"text\":\"Купить\",\"type\":\"button_other\",\"action\":\"purchase\",\"purchase_package_id\":\"Dovod_2020\"}],\"processed_images_id\":" +
                "null,\"images\":{\"tile_notification\":" +
                "\"https://static-sesure.cdn.megafon.tv/images/notifications/6a/d7/87d3a9a18e2ea9f7fb8df5c30240d03196bb/tile_notification__web.jpeg\"}," +
                "\"notification_duration\":{\"type\":\"date\",\"valid_until\":\"2021-04-30T12:56:00Z\",\"valid_duration\":3600},\"user_filters\":" +
                "{\"msisdn_filter\":false,\"auth_filter\":\"registered\",\"vk_only_filter\":false,\"partners\":[\"megafon_tv\"]}}").
                when().
                put("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest1").
                then().
                statusCode(200);
    }

    public void checkElementsPopUpNotifScreenNilPayFilm() {
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//button)[3]"));
        isElementDisplayed(By.className("x8TnYuA0SaYGPCw7RRFOL"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//h3[text()='автотест ВУ для экрана НиЛ']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//div[text()='тело']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Купить']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Закрыть']"));
    }

    public void deletePopUpNotifScreenNilPayFilm() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                delete("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest1").
                then().
                statusCode(204);
    }

    public void clickToButtonPayToPopUpNotif() {
        click(By.xpath("//div[@aria-label='Notification']//button[text()='Купить']"));
    }

    public void createAndPublishedPopUpNotifScreenFilms() {
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").body("{\"id\":\"autotest2\",\"name\":\"автотест ВУ\",\"header\":\"автотест ВУ для экрана Фильмы\",\"published\":true," +
                "\"body\":\"тело\",\"start_activity\":\"2021-04-07T12:56:00Z\",\"stop_activity\":\"2021-04-30T12:56:00Z\",\"screen_filter\":\"mftv://menu/films\"," +
                "\"notification_type\":" +
                "\"text\",\"no_pictogram\":false,\"buttons\":[{\"text\":\"Закрыть\",\"type\":\"button_x\",\"action\":\"none\",\"accepts_offer\":false}," +
                "{\"text\":\"Купить\",\"type\":\"button_other\",\"action\":\"purchase\",\"purchase_package_id\":\"Dovod_2020\"}],\"processed_images_id\":" +
                "null,\"images\":{\"tile_notification\":" +
                "\"https://static-sesure.cdn.megafon.tv/images/notifications/6a/d7/87d3a9a18e2ea9f7fb8df5c30240d03196bb/tile_notification__web.jpeg\"}," +
                "\"notification_duration\":{\"type\":\"date\",\"valid_until\":\"2021-04-30T12:56:00Z\",\"valid_duration\":3600},\"user_filters\":" +
                "{\"msisdn_filter\":false,\"auth_filter\":\"registered\",\"vk_only_filter\":false,\"partners\":[\"megafon_tv\"]}}").
                when().
                put("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest2").
                then().
                statusCode(200);
    }

    public void checkElementsPopUpNotifScreenFilms() {
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//button)[3]"));
        isElementDisplayed(By.className("x8TnYuA0SaYGPCw7RRFOL"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//h3[text()='автотест ВУ для экрана Фильмы']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//div[text()='тело']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Купить']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Закрыть']"));
    }

    public void deletePopUpNotifScreenFilms() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                delete("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest2").
                then().
                statusCode(204);
    }

    public void checkElementsPopUpBundleUserMF() {
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//button)[2]"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//div)[4]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Вам доступно')]"));
        Assert.assertEquals("Нет кнопки 'Смотреть' в ВУ 'Вам доступно'", 1, driver.findElements(By.xpath("//button[text()='Смотреть']")).size());
        isElementDisplayed(By.xpath("//button[text()='Закрыть']"));
   }

    public void clickButtonWatchInPopUpBundle() {
        click(By.xpath("//button[text()='Смотреть']"));
    }

    public void createAndPublishedPopUpNotifScreenNilDeepLinkFilms() {
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").body("{\"id\":\"autotest3\",\"name\":\"автотест ВУ\",\"header\":\"автотест ВУ c deeplink Films\",\"published\":true," +
                "\"body\":\"тело\",\"start_activity\":\"2021-04-07T12:56:00Z\",\"stop_activity\":\"2021-04-30T12:56:00Z\",\"notification_type\":" +
                "\"text\",\"no_pictogram\":false,\"buttons\":[{\"text\":\"Закрыть\",\"type\":\"button_x\",\"action\":\"none\",\"accepts_offer\":false}," +
                "{\"type\":\"button_other\",\"text\":\"Смотреть\",\"action\":\"link\",\"link\":\"mftv://menu/films\"}],\"processed_images_id\":" +
                "null,\"images\":{\"tile_notification\":" +
                "\"https://static-sesure.cdn.megafon.tv/images/notifications/6a/d7/87d3a9a18e2ea9f7fb8df5c30240d03196bb/tile_notification__web.jpeg\"}," +
                "\"notification_duration\":{\"type\":\"date\",\"valid_until\":\"2021-04-30T12:56:00Z\",\"valid_duration\":3600},\"user_filters\":" +
                "{\"msisdn_filter\":false,\"auth_filter\":\"registered\",\"vk_only_filter\":false,\"partners\":[\"megafon_tv\"]}}").
                when().
                put("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest3").
                then().
                statusCode(200);
    }

    public void checkElementsPopUpNotifScreenNilDeepLinkFilms() {
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//button)[3]"));
        isElementDisplayed(By.className("x8TnYuA0SaYGPCw7RRFOL"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//h3[text()='автотест ВУ c deeplink Films']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//div[text()='тело']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Смотреть']"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']//button[text()='Закрыть']"));
    }

    public void clickButtonWatchInPopUpNotifScreenNilDeepLinkFilms() {
        click(By.xpath("//div[@aria-label='Notification']//button[text()='Смотреть']"));
    }

    public void deletePopUpNotifScreenNilDeepLinkFilms() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                delete("https://bmp-preprod2.megafon.tv/cms/api/v0/notification_factories/autotest3").
                then().
                statusCode(204);
    }
}
