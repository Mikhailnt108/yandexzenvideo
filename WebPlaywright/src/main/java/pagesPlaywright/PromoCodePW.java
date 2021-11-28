package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.util.Base64;

import static base.TestBasePlaywright.vrt;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class PromoCodePW extends BasePagePlaywright {
    private Page page;
    private String frontend;
    private String backend;

    public PromoCodePW (Page page, String frontend, String backend) {
        this.page = page;
        this.frontend = frontend;
        this.backend = backend;
    }
    public void checkElementsPagePromocode() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertTrue("not visible element", page.querySelectorAll("//h1[text()='Введите промокод']").size()==1);
        Assert.assertTrue("not visible element", page.querySelectorAll("//input[@placeholder='Введите промокод']").size()==1);
        Assert.assertTrue("not visible element", page.querySelectorAll("//button[@disabled and text()='Активировать']").size()==1);
        Assert.assertTrue("not visible element", page.querySelectorAll("//button[text()='Закрыть']").size()==1);
    }

    public void checkImagePagePromocode() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PagePromocodeFull":
        Thread.sleep(3000);
        vrt.track(
                "PagePromocodeFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnButtonCloseAndCheckOpenNil() {
        page.waitForSelector("//button[text()='Закрыть']").click();
        page.waitForSelector("//div[contains(@class,'carousel')]");
        Assert.assertEquals("bug: not opened page nil", frontend, page.url());
    }

    public void checkInputUnknownCodeInFormPromocode(String unknownPromocode) throws InterruptedException {
        page.querySelector("//h1[text()='Введите промокод']");
        page.fill("//input[@placeholder='Введите промокод']", unknownPromocode);
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Активировать']").size());
        Thread.sleep(3000);
        ElementHandle buttonActivate = page.waitForSelector("//button[text()='Активировать']");
        String background = (String) buttonActivate.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: color of the element is not green", background.contains("rgb(0, 185, 86)"));
    }

    public void clickOnButtonActivateForUnknownCodeAndCheckElements() {
        ElementHandle buttonActivate = page.waitForSelector("//button[text()='Активировать']");
        buttonActivate.click();
        ElementHandle errorText = page.waitForSelector("//span[contains(@class,'FormInput_error') and text()='Неверный промокод']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[contains(@class,'FormInput_error') and text()='Неверный промокод. Пожалуйста, проверьте правильность введенного промокода.']").size());
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assert.assertEquals("bug: color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
    }

    public void createAndPublishedRC() {
        //Создание рекламной кампании:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("id", "RC_autotest").
                multiPart("name", "RC_autotest").
                multiPart("partner","megafon_tv").
                when().post(backend+"cms/ad_campaigns/create").
                then().statusCode(anyOf(is(200),is(302),is(500)));

    }

    public void createAndPublishedCodeGroupAndPromoCodePackageStartSoftTnB() {
        //Создание и активация код-группы:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"CG_autotest_SotTnb\",\"ad_campaign_id\":\"RC_autotest\",\"name\":\"Код-группа для автотестов Мягкий ТнБ\", " +
                        "\"published\":true,\"valid_from\":\"2021-03-30T00:00:00Z\",\"valid_to\":\"2022-12-01T00:00:00Z\",\"description_popup\":\"текст для описания\"," +
                        "\"description_promotion\":\"текст для описания\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                        "\"group_package\": {\"id\": \"Mixed_start\", \"date\": \"2022-12-01T00:00:00Z\", \"only_new\": false, \"tnb_type\": \"soft\", " +
                        "\"ownership_type\": \"date\"}}}").
                when().post(backend+"cms/ad_campaigns/RC_autotest/add_code_group").
                then().statusCode(anyOf(is(200),is(500)));
        //Создание промокода:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "promoCodeSoftTnB").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post(backend+"cms/code_groups/CG_autotest_SotTnb/add_promocode").
                then().statusCode(anyOf(is(200),is(302),is(409)));

    }

    public void inputValidPromoCode(String allowedPromoCod) {
        page.querySelector("//h1[text()='Введите промокод']");
        page.fill("//input[@placeholder='Введите промокод']", allowedPromoCod);

    }

    public void clickOnFirstButtonActivatePromoCode() {
        ElementHandle buttonActivate = page.waitForSelector("//button[text()='Активировать']");
        buttonActivate.click();
    }
    
    public void checkOpenPopUpAfterActivation() {
        Assert.assertEquals("bug: not opened popUp 'ActivateFinish'", 1, page.querySelectorAll("//h1[contains(text()='Промокод активирован!')]"));
    }

    public void checkElementsPopUpBeforeActivationPackageStartSoftTnB() {
        page.waitForSelector("//h1[text()='«START» бесплатно по промокоду!']");
        page.waitForSelector("//p[contains(normalize-space(),'Бесплатный доступ к пакету «START» по промокоду предоставляется до')]");
        page.waitForSelector("//p[contains(normalize-space(),'По окончании срока бесплатного доступа пакет будет отключен автоматически.')]");
        page.waitForSelector("//p[contains(normalize-space(),'Сервис предоставляется ООО «Старт.ру».')]");
        page.waitForSelector("//p[contains(normalize-space(),'Подтверждая подписку, вы принимаете условия оферты ООО «Старт.ру»:')]");
        page.waitForSelector("//a[@href='https://start.ru/termsofuse']");
        page.waitForSelector("//button[text()='Активировать']");
        page.waitForSelector("//button[text()='Отменить']");

    }

    public void clickToButtonCancel() {
        page.waitForSelector("//button[text()='Отменить']").click();
    }

    public void checkClosePopUpBeforeActivationPackageStartSoftTnB() {
        Assert.assertEquals("Не закрылся попап 'до активации'", 0, page.querySelectorAll("//h1[text()='«START» бесплатно по промокоду!']").size());
        Assert.assertEquals("Не закрылся попап 'до активации'", 1, page.querySelectorAll("//h1[text()='Введите промокод']").size());
    }

    public void clickOnSecondButtonActivatePromoCode() {
        page.waitForSelector("//button[text()='Активировать']").click();
    }

    public void checkOpenPopUpBeforeActivation() {
        Assert.assertTrue("bug: not opened popUp 'PromocodeActivate'", page.querySelectorAll("//h1[contains(@class,'PromocodeActivateRequest_title')]").size()==1);}

    public void checkElementsPopUpAfterActivationPackageStartSoftTnB() {
        page.waitForSelector("//h3[text()='Промокод активирован!']");
        page.waitForSelector("_2VizWvlDNzA0Ud_F09jJco");
        page.waitForSelector("wEpDEZzWIj5YGechGyzkl");
        page.waitForSelector("//div[text()='Вам доступно:']");
        page.waitForSelector("//span[text()='\"START\"']");
        page.waitForSelector("//span[text()='текст для описания']");
        page.waitForSelector("//button[text()='Смотреть']");
    }

    public void clickToButtonWatchAndCheckOpenCardPackageStart() {
        String name = page.waitForSelector("uCaVLp73F3t8zT0sYCoBh").innerText();
        String namePackage = name.replace("\"", "");
        System.out.println(namePackage);
        page.waitForSelector("//button[text()='Смотреть']").click();
        Assert.assertEquals("bug: not opened card package", page.url().contains("/mixed_groups/"));
        Assert.assertEquals("Не тот пакет", namePackage, page.waitForSelector("_3JWCAjonEZRvpx1iIk6Y0n").innerText());
    }

    public void archiveCodeGroupPackageStartSoftTnB() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                when().get(backend+"cms/code_groups/CG_autotest_SotTnb/toggle_publish").
                then().statusCode(200);
    }

    public void createAndPublishedCodeGroupAndPromoCodePackageMoreTvHardTnB() {
        //Создание и активация код-группы:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"CG_autotest_HardTnB\",\"ad_campaign_id\":\"RC_autotest\",\"name\":\"Код-группа для автотестов Жёсткий ТнБ\", " +
                        "\"published\":true,\"valid_from\":\"2021-03-30T00:00:00Z\",\"valid_to\":\"2022-12-01T00:00:00Z\",\"description_popup\":\"текст для описания\"," +
                        "\"description_promotion\":\"текст для описания\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                        "\"group_package\": {\"id\": \"Mixed_more_tv\", \"date\": \"2022-12-01T00:00:00Z\", \"only_new\": false, \"tnb_type\": \"hard\", " +
                        "\"ownership_type\": \"date\"}}}").
                when().post(backend+"cms/ad_campaigns/RC_autotest/add_code_group").
                then().statusCode(anyOf(is(200),is(500)));
        //Создание промокода:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "promoCodeHardTnB").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post(backend+"cms/code_groups/CG_autotest_HardTnB/add_promocode").
                then().statusCode(anyOf(is(200),is(302),is(409)));

    }

    public void checkElementsPopUpBeforeActivationPackageMoreTvHardTnB() {
        page.waitForSelector("//h1[text()='«morе.tv» бесплатно по промокоду!']");
        page.waitForSelector("//p[contains(normalize-space(),'Бесплатный доступ к пакету по промокоду предоставляется по')]");
        page.waitForSelector("//p[contains(normalize-space(),'Начиная с')]");
        page.waitForSelector("//p[contains(normalize-space(),'стоимость пакета составит')]");
        page.waitForSelector("//p[contains(normalize-space(),'Сервис предоставляется ООО «M3».')]");
        page.waitForSelector("//p[contains(normalize-space(),'Подтверждая подписку, вы принимаете условия оферты ООО «M3»:')]");
        page.waitForSelector("//a[@href='https://more.tv/useragreement']");
        page.waitForSelector("//button[text()='Активировать']");
        page.waitForSelector("//button[text()='Отменить']");
    }

    public void checkElementsPopUpAfterActivationPackageMoreTvHardTnB() {
        page.waitForSelector("//h3[text()='Промокод активирован!']");
        page.waitForSelector("_2VizWvlDNzA0Ud_F09jJco");
        page.waitForSelector("wEpDEZzWIj5YGechGyzkl");
        page.waitForSelector("//div[text()='Вам доступно:']");
        page.waitForSelector("//span[text()='\"morе.tv\"']");
        page.waitForSelector("//span[text()='текст для описания']");
        page.waitForSelector("//button[text()='Смотреть']");
    }

    public void clickToButtonCloseInPopUpAfterActivation() {
        page.waitForSelector("_2VizWvlDNzA0Ud_F09jJco").click();
    }

    public void checkClosePopUpAfterActivation() {
        Assert.assertEquals("Не закрылся попап 'после активации'", 0, page.querySelectorAll("//h1[text()='Промокод активирован!']").size());
    }

    public void archiveCodeGroupPackageMoreTvHardTnB() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                when().get(backend+"cms/code_groups/CG_autotest_HardTnB/toggle_publish").
                then().statusCode(200);
    }

    public void createAndPublishedCodeGroupAndPromoCodeFilmOnEST() {
        //Создание и активация код-группы:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"СG_autotest_Film_EST\",\"ad_campaign_id\":\"RC_autotest\",\"name\":\"Код-группа для автотестов Фильм по EST\", " +
                        "\"published\":true,\"valid_from\":\"2021-03-30T00:00:00Z\",\"valid_to\":\"2021-12-30T00:00:00Z\",\"description_popup\":\"текст для описания\"," +
                        "\"description_promotion\":\"опс\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"films\", " +
                        "\"films\": {\"ids\": [\"Dovod_2020\"], \"only_new\": false, \"ownership_type\":\"est\"}}}").
                when().post(backend+"cms/ad_campaigns/RC_autotest/add_code_group").
                then().statusCode(anyOf(is(200),is(500)));

        //Создание промокода:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "promoCodeFilmOnEST").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post(backend+"cms/code_groups/СG_autotest_Film_EST/add_promocode").
                then().statusCode(anyOf(is(200),is(302),is(409)));
    }

    public void checkElementsPopUpBeforeActivationFilmOnEST() {
        page.waitForSelector("//h1[text()='Фильм «Довод» бесплатно по промокоду']");
        page.waitForSelector("//p[contains(normalize-space(),'Смотри бесплатно.']");
        page.waitForSelector("//button[text()='Активировать']");
        page.waitForSelector("//button[text()='Отменить']");
    }

    public void checkElementsPopUpAfterActivationFilmOnEST() {
        page.waitForSelector("//h3[text()='Промокод активирован!']");
        page.waitForSelector("_3E3Ou4BLw1i_TQHV34ofs6");
        page.waitForSelector("_2o8kH-If8mc-reHlaOHfFH");
        page.waitForSelector("//div[text()='Вам доступно:']");
        page.waitForSelector("//span[text()='\"Довод\"']");
        page.waitForSelector("//span[text()='текст для описания']");
        page.waitForSelector("//button[text()='Смотреть']");
    }

    public void clickToButtonWatchAndCheckOpenCardFilmOnEST() {
        String name = page.waitForSelector("_1Euevex6MnqG-kMnzDFzTx").innerText();
        String namePackage = name.replace("\"", "");
        System.out.println(namePackage);
        page.waitForSelector("//button[text()='Смотреть']").click();
        Assert.assertEquals("bug: not opened card film", page.url().contains("/vods/"));
        Assert.assertEquals("Не тот фильм", namePackage, page.waitForSelector("_3JWCAjonEZRvpx1iIk6Y0n").innerText());
    }

    public void archiveCodeGroupFilmOnEST() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                when().get(backend+"cms/code_groups/СG_autotest_Film_EST/toggle_publish").
                then().statusCode(200);
    }

    public void createAndPublishedCodeGroupAndPromoCodeFilmOnRentPromo() {
        //Создание и активация код-группы:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"СG_autotest_Film_RentPromo\",\"ad_campaign_id\":\"RC_autotest\",\"name\":\"Код-группа для автотестов Фильм по RentPromo\", " +
                        "\"published\":true,\"valid_from\":\"2021-03-30T00:00:00Z\",\"valid_to\":\"2021-12-15T00:00:00Z\",\"description_popup\":\"текст для описания\"," +
                        "\"description_promotion\":\"опс\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"films\", " +
                        "\"films\": {\"ids\": [\"Dovod_2020\"], \"only_new\": false, \"ownership_type\":\"rentpromo_date\",\"date\":\"2021-12-30T00:00:00Z\",\"days\":null}}}").
                when().post(backend+"cms/ad_campaigns/RC_autotest/add_code_group").
                then().statusCode(anyOf(is(200),is(500)));
        //Создание промокода:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "promoCodeFilmOnRent").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post(backend+"cms/code_groups/СG_autotest_Film_RentPromo/add_promocode").
                then().statusCode(anyOf(is(200),is(302),is(409)));
    }

    public void checkElementsPopUpBeforeActivationFilmOnRent() {
        page.waitForSelector("//h1[text()='Фильм «Довод» бесплатно по промокоду']");
        page.waitForSelector("//p[contains(normalize-space(),'Смотри бесплатно до']");
        page.waitForSelector("//button[text()='Активировать']");
        page.waitForSelector("//button[text()='Отменить']");
    }

    public void checkElementsPopUpAfterActivationFilmOnRent() {
        page.waitForSelector("//h1[text()='Промокод активирован!']");
        page.waitForSelector("_3E3Ou4BLw1i_TQHV34ofs6");
        page.waitForSelector("_2o8kH-If8mc-reHlaOHfFH");
        page.waitForSelector("//div[text()='Вам доступно:']");
        page.waitForSelector("//span[text()='\"Довод\"']");
        page.waitForSelector("//span[text()='текст для описания']");
        page.waitForSelector("//button[text()='Смотреть']");

    }

    public void clickToButtonWatchAndCheckOpenCardFilmOnRent() {
        String name = page.waitForSelector("_1Euevex6MnqG-kMnzDFzTx").innerText();
        String namePackage = name.replace("\"", "");
        System.out.println(namePackage);
        page.waitForSelector("//button[text()='Смотреть до']").click();
        Assert.assertEquals("bug: not opened card film", page.url().contains("/vods/"));
        Assert.assertEquals("Не тот фильм", namePackage, page.waitForSelector("_3JWCAjonEZRvpx1iIk6Y0n").innerText());
    }

    public void archiveCodeGroupFilmOnRentPromo() {
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                when().get(backend+"cms/code_groups/СG_autotest_Film_RentPromo/toggle_publish").
                then().statusCode(200);
    }

    public void checkElementsPopUpErrorReusingPromocode() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Введите промокод']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Введите промокод']").size());

        ElementHandle errorText = page.waitForSelector("//span[text()='Введенный промокод был ранее активирован. Повторная активация недоступна.']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[text()='Введенный промокод был ранее активирован. Повторная активация недоступна.']").size());
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assert.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");

        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Активировать']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[text()='Закрыть']").size());
    }

    public void createAndPublishedCodeGroupAndPromoCodeExpiredPackageStartSoftTnB() {
        //Создание и активация код-группы:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/json").
                body("{\"id\":\"CG_autotest_SotTnb\",\"ad_campaign_id\":\"RC_autotest\",\"name\":\"Код-группа для автотестов Мягкий ТнБ\", " +
                        "\"published\":true,\"valid_from\":\"2021-03-30T00:00:00Z\",\"valid_to\":\"2021-10-01T00:00:00Z\",\"description_popup\":\"текст для описания\"," +
                        "\"description_promotion\":\"текст для описания\",\"user_type\":{\"type\": \"megafon\"},\"mechanics\":{\"type\": \"tnb\", " +
                        "\"group_package\": {\"id\": \"Mixed_start\", \"date\": \"2021-10-01T00:00:00Z\", \"only_new\": false, \"tnb_type\": \"soft\", " +
                        "\"ownership_type\": \"date\"}}}").
                when().post(backend+"cms/ad_campaigns/RC_autotest/add_code_group").
                then().statusCode(anyOf(is(200),is(500)));
        //Создание промокода:
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("multipart/form-data").
                multiPart("promocode", "promoCodeSoftTnB").
                multiPart("partner", "default").
                multiPart("dispatch_channel", "default").
                when().post(backend+"cms/code_groups/CG_autotest_SotTnb/add_promocode").
                then().statusCode(anyOf(is(200),is(302),is(409)));
    }

    public void checkElementsPopUpErrorExpiredPromocode() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Введите промокод']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Введите промокод']").size());

        ElementHandle errorText = page.waitForSelector("//span[text()='Срок действия промокода истек.']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[text()='Срок действия промокода истек.']").size());
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assert.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");

        Assert.assertTrue("not visible element", page.querySelectorAll("//button[@disabled and text()='Активировать']").size()==1);
        Assert.assertTrue("not visible element", page.querySelectorAll("//button[text()='Закрыть']").size()==1);
    }
}
