package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class PersonalOffer extends BasePage {
    public PersonalOffer(WebDriver driver) {
        super(driver);
    }

    public void clickTolinkViewAllPromotions() {
        click(By.linkText("Смотреть все акции"));
    }

    public void createPersonalOfferTypePackageForZeroRublesForMF() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(3);
        //конец действия промоподписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POPackageForZeroRubles").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#8FBC8F").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "megafon").
                multiPart("mechanics", "tnb").
                multiPart("tnb.package_id", "Mixed_start").
                multiPart("tnb.expiration_type", "date").
                multiPart("tnb.date", tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("tnb.tnb_type", "soft").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/1/edit").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void checkElementsOnePersonalOffer() {
        driver.navigate().refresh();
        isElementDisplayed(By.className("_2EES6eXVXSN1-aglhcBq0D"));
        isElementDisplayed(By.className("_3H-YE-_SDd808d1cqEgy5q"));
        isElementDisplayed(By.xpath("//div[text()='Мы подготовили для Вас персональное предложение']|//div[text()='Мы подготовили для вас персональные предложения']"));
        isElementDisplayed(By.className("_2yfj41btmBF-chrc0LwQQ1"));
        String colorElementPO = driver.findElement(By.cssSelector("._3oPCKMu7Sfm9IMsxuhwuXy")).getCssValue("background-color");
        System.out.println(colorElementPO);
        Assert.assertEquals("Плашка ПП не пурпурно-синего цвета", "rgba(68, 65, 137, 1)", colorElementPO);
    }

    public void checkElementsWhiteColorSandPersonalOffer() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(3);
        //конец действия промоподписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POPackageForZeroRubles").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#8FBC8F").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "registered").
                multiPart("mechanics", "tnb").
                multiPart("tnb.package_id", "Mixed_start").
                multiPart("tnb.expiration_type", "date").
                multiPart("tnb.date", tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("tnb.tnb_type", "soft").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/1/edit").
                then().statusCode(anyOf(is(200),is(302)));
        isElementDisplayed(By.xpath("//div[@class='_3H-YE-_SDd808d1cqEgy5q']//*[@fill='#FFFFFF']"));
        isElementDisplayed(By.xpath("//div[text()='Мы подготовили для Вас персональное предложение']"));

    }

    public void checkElementsYellowColorSandPersonalOffer() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(2);
        //конец действия промоподписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POPackageForZeroRubles").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#8FBC8F").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "registered").
                multiPart("mechanics", "tnb").
                multiPart("tnb.package_id", "Mixed_start").
                multiPart("tnb.expiration_type", "date").
                multiPart("tnb.date", tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("tnb.tnb_type", "soft").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/1/edit").
                then().statusCode(anyOf(is(200),is(302)));
        driver.navigate().refresh();
        driver.navigate().refresh();
        isElementDisplayed(By.xpath("//div[@class='_3H-YE-_SDd808d1cqEgy5q']//*[@fill='#F5A623']"));
        isElementDisplayed(By.xpath("//div[contains(text(),'Успейте активировать персональное предложение до')]"));

    }

    public void checkElementsRedColorSandPersonalOffer() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(1);
        //конец действия промоподписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POPackageForZeroRubles").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#8FBC8F").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "registered").
                multiPart("mechanics", "tnb").
                multiPart("tnb.package_id", "Mixed_start").
                multiPart("tnb.expiration_type", "date").
                multiPart("tnb.date", tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("tnb.tnb_type", "soft").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/1/edit").
                then().statusCode(anyOf(is(200),is(302)));
        driver.navigate().refresh();
        driver.navigate().refresh();
        isElementDisplayed(By.xpath("//div[@class='_3H-YE-_SDd808d1cqEgy5q']//*[@fill='#EB5D44']"));
        isElementDisplayed(By.xpath("//div[text()='Последний шанс активировать Ваше персональное предложение.']"));
    }

    public void clickToElementPersonalOffer() {
        click(By.className("_3oPCKMu7Sfm9IMsxuhwuXy"));
    }
    public void checkOpenPagePersonalOfferPackageForZeroRubles() {
        isElementDisplayed(By.xpath("//div[text()='POPackageForZeroRubles']"));
    }

    public void createPersonalOfferTypeSubscription() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(3);
        //конец действия подписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POSubscription").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#006400").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "registered").
                multiPart("mechanics", "subscription").
                multiPart("subscription.package_id", "Mixed_more_tv").
                multiPart("subscription.duration", "10").
                multiPart("subscription.template_id", "1").
                multiPart("subscription.price", "40").
                multiPart("subscription.payment_interval", "10").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/2/edit").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void checkElementsFewPersonalOffers() {
        isElementDisplayed(By.className("_2EES6eXVXSN1-aglhcBq0D"));
        isElementDisplayed(By.className("_3H-YE-_SDd808d1cqEgy5q"));
        isElementDisplayed(By.xpath("//div[text()='Мы подготовили для вас персональные предложения']"));
        isElementDisplayed(By.className("_2yfj41btmBF-chrc0LwQQ1"));
        isElementDisplayed(By.xpath("//div[@class='_3H-YE-_SDd808d1cqEgy5q']//*[@fill='#FFFFFF']"));
        String colorBackgroundPO = driver.findElement(By.cssSelector("._3oPCKMu7Sfm9IMsxuhwuXy")).getCssValue("background-color");
        System.out.println(colorBackgroundPO);
        Assert.assertEquals("Плашка ПП не пурпурно-синего цвета", "rgba(68, 65, 137, 1)", colorBackgroundPO);
    }

    public void createPersonalOfferTypePartnerOfferForNonMF() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(3);
        //конец действия подписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POPartner").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#DAA520").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "non_megafon").
                multiPart("mechanics", "partner_offer").
                multiPart("partner_offer.partner_link", "https://hd.kinopoisk.ru/").
                multiPart("partner_offer.partner_button", "KinoPoiskHD").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/3/edit").
                then().statusCode(anyOf(is(200),is(302)));
        driver.navigate().refresh();
    }
    public void createPersonalOfferTypePartnerOfferKinoPoiskForMF() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(3);
        //конец действия подписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POPartner1").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#DAA520").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "megafon").
                multiPart("mechanics", "partner_offer").
                multiPart("partner_offer.partner_link", "https://hd.kinopoisk.ru/").
                multiPart("partner_offer.partner_button", "KinoPoiskHD").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/3/edit").
                then().statusCode(anyOf(is(200),is(302)));
        driver.navigate().refresh();
    }
    public void createPersonalOfferTypePartnerOfferOkkoTvForMF() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now();
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(3);
        //конец действия подписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(5);
        //стандартный формат даты
        //System.out.println("стандартный формат даты LocalDateTime : " + startOffer);
        //приименяем свой формат даты
        //System.out.println(tnbDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("name", "POPartner2").
                multiPart("description", "text for description").
                multiPart("poster", "http://static.cdn.megafon.tv/images/Film/d4/2c/52071210c58982627bcd80c9ccdb9bc2b636/Poster.png").
                multiPart("poster_wide", "http://static.cdn.megafon.tv/images/Film/e3/3a/2ab31af96c4c988cbbae7451e1fc55d9d7a2/WidePoster.png").
                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/Film/fd/c2/9a45ceb01a9b56f17232368b9874dec72051/Tile.png").
                multiPart("color", "#310062").
                multiPart("activation_type", "segment").
                multiPart("partners", "megafon_tv").
                multiPart("segment_type", "megafon").
                multiPart("mechanics", "partner_offer").
                multiPart("partner_offer.partner_link", "https://okko.tv/").
                multiPart("partner_offer.partner_button", "OkkoTv").
                multiPart("valid_since", startOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                multiPart("valid_until", endOffer.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))).
                when().post("https://bmp-preprod5.megafon.tv/cms/personal_offers/4/edit").
                then().statusCode(anyOf(is(200),is(302)));
        driver.navigate().refresh();
    }

    public void archivePersonalOfferPackageForZeroRublesForMF() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get("https://bmp-preprod5.megafon.tv/cms/personal_offers/1/archive").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void archivePersonalOfferSubscription() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get("https://bmp-preprod5.megafon.tv/cms/personal_offers/2/archive").
                then().statusCode(anyOf(is(200),is(302)));
    }
    public void archivePersonalOfferPartnerOfferKinoPoiskForMF() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get("https://bmp-preprod5.megafon.tv/cms/personal_offers/3/archive").
                then().statusCode(anyOf(is(200), is(302)));
    }
    public void archivePersonalOfferPartnerOfferOkkoTvForMF() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get("https://bmp-preprod5.megafon.tv/cms/personal_offers/4/archive").
                then().statusCode(anyOf(is(200), is(302)));
    }
    public void checkOpenPagePersonalOfferSubscription() {
        isElementDisplayed(By.xpath("//div[text()='POSubscription']"));
    }

    public void checkOpenPagePersonalOfferPartnerOffer() {
        isElementDisplayed(By.xpath("//div[text()='POPartner']"));
    }

    public void activatePersonalOfferPackageForZeroRubles() {
        click(By.xpath("//button[text()='Активировать']"));
        click(By.xpath("//button[text()='Принять и подключить']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//div[text()='АКТИВИРОВАНО']"));
    }

    public void checkAbsentElementPersonalOffer() {
        Assert.assertEquals("Отображается плашка ПП", 0, driver.findElements(By.className("_2EES6eXVXSN1-aglhcBq0D")).size());
    }

    public void activatePersonalOfferSubscription() {
        click(By.xpath("//button[text()='Активировать']"));
        click(By.xpath("//button[text()='Подтвердить']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//div[text()='АКТИВИРОВАНО']"));
    }

    public void clickButtonPartner() {
        click(By.xpath("//button[text()='KinoPoiskHD']"));
    }

    public void checkOpenPageURLPartner() {
        String url1 = "https://hd.kinopoisk.ru/";
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().window((String) tabs1.get(1));
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        String url2 = driver.getCurrentUrl();
        System.out.println(url2);
        Assert.assertEquals(url1, url2);
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
    }

    public void checkElementsPersonalOfferPage() {
        isElementDisplayed(By.linkText("Смотреть все акции"));
        isElementDisplayed(By.xpath("//div[contains(text(),'Осталось')]"));
        isElementDisplayed(By.xpath("//div[@class='_5VLZiv3cySyTjGiy4XkfE' and text()]"));
        isElementDisplayed(By.xpath("//div[@class='_1qmJTRdAghUdA6VFbLFewU' and text()]"));
        isElementDisplayed(By.xpath("//button[text()='Активировать']"));
        isElementDisplayed(By.xpath("//button[text()='Не интересно']"));
        isElementDisplayed(By.xpath("//div[text()='Сервисы, входящие в персональное предложение']|//div[text()='Пакеты, входящие в персональное предложение']"));
        isElementDisplayed(By.xpath("//a[@data-test='PackageLink']"));
    }

    public void clickToTailPackageInPO() {
        click(By.xpath("//a[@data-test='PackageLink']"));
    }

    public void clickToButtonNotInterested() {
        click(By.xpath("//button[text()='Не интересно']"));
    }
}

