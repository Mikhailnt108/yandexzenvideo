package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import static base.TestBasePlaywright.vrt;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class PersonalOfferPW extends BasePagePlaywright {
    private Page page;
    private String backend;

    public PersonalOfferPW(Page page, String backend) {
        this.page = page;
        this.backend = backend;
    }

    public void createPersonalOfferTypePackageForZeroRublesForMF() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now().minusDays(2);
        //конец перс предложения
        LocalDateTime endOffer = startOffer.plusDays(4);
        //конец действия промоподписки
        LocalDateTime tnbDateEnd = startOffer.plusDays(6);
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
                when().post(backend+"cms/personal_offers/1/edit").
                then().statusCode(anyOf(is(200), is(302)));
    }
    public void createPersonalOfferTypeSubscription() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now().minusDays(2);
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(4);
        //конец действия подписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(6);
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
                when().post(backend+"cms/personal_offers/2/edit").
                then().statusCode(anyOf(is(200),is(302)));
    }
    public void createPersonalOfferTypePartnerOfferKinoPoiskForMF() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now().minusDays(2);
        //конец перс предложения
        LocalDateTime endOffer = startOffer.plusDays(4);
        //конец действия подписки
        LocalDateTime tnbDateEnd = startOffer.plusDays(6);
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
                when().post(backend+"cms/personal_offers/3/edit").
                then().statusCode(anyOf(is(200), is(302)));
    }
    public void createPersonalOfferTypePartnerOfferOkkoTvForMF() {
        //начало перс предложения
        LocalDateTime startOffer = LocalDateTime.now().minusDays(2);
        //конец перс предложения
        LocalDateTime  endOffer = startOffer.plusDays(4);
        //конец действия подписки
        LocalDateTime  tnbDateEnd = startOffer.plusDays(6);
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
                when().post(backend+"cms/personal_offers/4/edit").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void archivePersonalOfferPackageForZeroRublesForMF() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get(backend+"cms/personal_offers/1/archive").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void archivePersonalOfferSubscription() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get(backend+"cms/personal_offers/2/archive").
                then().statusCode(anyOf(is(200),is(302)));
    }
    public void archivePersonalOfferPartnerOfferKinoPoiskForMF() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get(backend+"cms/personal_offers/3/archive").
                then().statusCode(anyOf(is(200), is(302)));
    }
    public void archivePersonalOfferPartnerOfferOkkoTvForMF() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get(backend+"cms/personal_offers/4/archive").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void checkImagePagePersonalOfferSubscription() throws IOException, InterruptedException {
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        ElementHandle countContent = page.querySelector("//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
        countContent.evaluate("cC => cC.innerText='166 сериалов, 10 фильмов'");

        // делаем скриншот полной страницы "PagePersonalOfferSubscription":
        vrt.track(
                "PagePersonalOfferSubscription",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}
