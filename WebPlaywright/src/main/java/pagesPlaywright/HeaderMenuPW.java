package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static base.TestBasePlaywright.*;
import static io.restassured.RestAssured.given;
import static java.lang.Thread.sleep;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class HeaderMenuPW extends BasePagePlaywright {
    private Page page;
    private Page pageCMS;
    private BrowserContext contextIncognitoModeHeadless;
    private BrowserContext contextIncognitoModeHeadfull;
    private String frontend;
    private String backend;

    public HeaderMenuPW(Page page, Page pageCMS, BrowserContext contextIncognitoModeHeadless,String frontend, String backend) {
        this.page = page;
        this.pageCMS = pageCMS;
        this.contextIncognitoModeHeadless = contextIncognitoModeHeadless;
        this.frontend = frontend;
        this.backend = backend;
    }

    public void checkNotLoggedIsCorrect() {
        if(page.querySelectorAll("(//span[contains(text(),'+79')])[2]").size()>0){
            page.click("(//span[contains(text(),'+79')])[2]");
            page.click("(//span[text()='Выйти'])[1]");
        }
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");}
        page.querySelector("(//span[text()='Вход'])[1]");
    }

    public void clickToEnter() {
         page.waitForSelector("(//span[text()='Вход'])[1]");
         page.click("(//span[text()='Вход'])[1]");
         page.waitForSelector("//h1[text()='Введите номер телефона']|//div[text()='Введите номер телефона']");
    }

    public void clickToNext() {
        page.click("//button[text()='Далее']");
    }

    public void checkOpenPageCreatePasswordForAdWebFlowRegistrationMF(String login, String password) {
        page.waitForSelector("//h1[text()='Придумайте пароль']|//h1[text()='Введите пароль']");
        if (page.querySelectorAll("//h1[text()='Введите пароль']").size() != 0) {

            pageCMS = contextIncognitoModeHeadless.newPage();
            String onlyPreprod = backend.substring(8);
            System.out.println("this place before cms");
//            System.setProperty("http.proxyHost", null);
            System.setProperty("http.proxyHost", "proxy.megalabs.ru");
            System.setProperty("http.proxyPort", "8808");
            pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
            pageCMS.waitForTimeout(60000);
            System.out.println("this place after url cms");
            try {
                vrt.track(
                        "CMSPageFull",
                        Base64.getEncoder().encodeToString(pageCMS.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                        TestRunOptions.builder()
                                .device("Acer")
                                .os("Win10 Pro")
                                .browser("Chrome")
                                .diffTollerancePercent(0.5f)
                                .build());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pageCMS.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("cms.png"))
                    .setFullPage(true));
            byte[] buffer = pageCMS.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("cmsFullPage.png"))
                    .setFullPage(true));
            System.out.println(Base64.getEncoder().encode(buffer));
            pageCMS.click("//form[@method='GET']//input[1]");
            pageCMS.fill("//form[@method='GET']//input[1]", login);
            pageCMS.click("//button[text()='Поиск']");
            pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']");
            pageCMS.click("//a[contains(@href, '/cms/households/')]");
            pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.onDialog(dialog -> dialog.accept());
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.close();
//            System.setProperty("http.proxyHost", "proxy.megalabs.ru");
//            System.setProperty("http.proxyPort", "8808");
            page.bringToFront();
            page.reload();
            page.querySelector("(//span[text()='Вход'])[1]");
            page.click("(//span[text()='Вход'])[1]");
            page.waitForSelector("//h1[text()='Введите номер телефона']");
            page.focus("//input[@name='phone']");
            page.fill("//input[@name='phone']", login);
            page.click("//button[text()='Далее']");
            page.waitForSelector("//h1[text()='Придумайте пароль']");
            page.fill("//input[@type='password']",password);
        } else {
            page.waitForSelector("//h1[text()='Придумайте пароль']");
            page.fill("//input[@type='password']",password);
        }
    }

    public void checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF(String login, String password) {
        page.waitForSelector("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']");
        if (page.querySelectorAll("//div[text()='Введите пароль']").size() != 0) {
            pageCMS = contextIncognitoModeHeadless.newPage();
            String onlyPreprod = backend.substring(8);
            pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
            pageCMS.click("//form[@method='GET']//input[1]");
            pageCMS.fill("//form[@method='GET']//input[1]", login);
            pageCMS.click("//button[text()='Поиск']");
            pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']");
            pageCMS.click("//a[contains(@href, '/cms/households/')]");
            pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.onDialog(dialog -> dialog.accept());
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.close();
            page.bringToFront();
            page.reload();
            page.querySelector("(//span[text()='Вход'])[1]");
            page.click("(//span[text()='Вход'])[1]");
            page.waitForSelector("//div[text()='Введите номер телефона']");
            page.focus("//input[@name='login']");
            page.fill("//input[@name='login']", login);
            page.click("//button[text()='Далее']");
            page.waitForSelector("//div[text()='Придумайте пароль']");
            page.fill("//input[@type='password']",password);
        } else {
            page.waitForSelector("//div[text()='Придумайте пароль']");
            page.fill("//input[@type='password']",password);
        }

    }

    public void goToNilPage() {
        page.navigate(frontend);
    }

    public void clickToComeIn(String buttons) {
        page.click("//button[text()='Войти']");
    }

    public void checkOpenPopUpInputCode() {
        page.waitForSelector("//h1[text()='Введите код']|//div[text()='Введите код']");
    }

    public void copyPasteCodMsisdnForAdWeb(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/msisdn_confirmations");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        String codMsisdn = pageCMS.waitForSelector("(//td[text()='79260192144']/following-sibling::td)[4]|(//td[text()='79260172279']/following-sibling::td)[4]|(//td[text()='79260205027']/following-sibling::td)[4]").innerText();
        pageCMS.close();
        page.waitForSelector("//input[@placeholder='Введите код из sms']");
        page.fill("//input[@placeholder='Введите код из sms']",codMsisdn);
    }

    public void copyPasteCodMsisdnForNonAdWeb(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/msisdn_confirmations");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        String codMsisdn = pageCMS.waitForSelector("(//td[text()='79260192144']/following-sibling::td)[4]|(//td[text()='79260172279']/following-sibling::td)[4]|(//td[text()='79260205027']/following-sibling::td)[4]").innerText();
        pageCMS.close();
        page.waitForSelector("//input[@placeholder='Код подтверждения']");
        page.fill("//input[@placeholder='Код подтверждения']",codMsisdn);
    }

    public void checkLoginUserIsCorrectFlowForMfOrNonMf() {
        page.querySelector("(//span[contains(text(),'+792')])[2]|//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller__trigger']");
        page.navigate(frontend+"my/favorites");
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.navigate(frontend);
        page.reload();
    }

    public void deleteAccountMF(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']");
        pageCMS.click("//a[contains(@href, '/cms/households/')]");
        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
        pageCMS.click("//button[text()='Удалить']");
        pageCMS.onDialog(dialog -> dialog.accept());
        pageCMS.click("//button[text()='Удалить']");
        pageCMS.close();
    }

    public void goToTvTabTvProgramInAir() {
        page.navigate(frontend+"tv/tv_catalog");
    }

    public void goToTvTabProgramTv() {

        page.navigate(frontend+"tv");
    }

    public void goToFilmsPage() {
        page.navigate(frontend+"movies/vods");
    }

    public void goToSerialsPage() {
        page.navigate(frontend+"shows");
    }

    public void goToAllCollectionsPage() {
        page.navigate(frontend+"collection");
    }

    public void goToKidsPage() {
        page.navigate(frontend+"kids");
    }

    public void clickToSearchButton() {
        page.click("(//div[@class='ch-trigger__container'])[1]");
    }

    public void checkOpenFieldSearch() {
        page.querySelector("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]");
    }

    public void inputValidRequestSearch() {
        page.fill("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]", "робот");
    }

    public void checkResponseOnValidSearch() {
        page.waitForSelector("//div[@class='ch-search__result']");
        page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Фильмы']");
        page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Сериалы']");
        page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']");
        page.waitForSelector("//a[@class='ch-search__all-result-link' and text()='Все результаты']");
    }

    public void checkImageResponseOnValidSearch() throws IOException, InterruptedException {
        List<ElementHandle> posterFilmResultSearchAll;
        List<ElementHandle> titleFilmResultSearchAll;
        List<ElementHandle> subtitleFilmResultSearchAll;
        for (int i = 0; i < page.querySelectorAll("(//div[@class='ch-search__title-line'])[1]/following-sibling::a[@class='ch-search-item ch-search__item']").size(); i++) {
            posterFilmResultSearchAll = page.querySelectorAll("//img[@class='ch-search-item__img']");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Film/5e/18/f09ea86f29460280f99545116607979532f4/tile__web-wp.webp')", posterFilmResultSearchAll.get(i));
            titleFilmResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Фильмы']/following::div[@class='ch-search-item__title']");
            page.evaluate("t => t.innerText='Название фильма'", titleFilmResultSearchAll.get(i));
            subtitleFilmResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Фильмы']/following::div[@class='ch-search-item__subtitle']");
            page.evaluate("d => d.textContent='2021, Жанр'", subtitleFilmResultSearchAll.get(i));
        }

        List<ElementHandle> posterSerialResultSearchAll;
        List<ElementHandle> titleSerialResultSearchAll;
        List<ElementHandle> subtitleSerialResultSearchAll;
        for (int i = 0; i < page.querySelectorAll("(//div[@class='ch-search__title-line'])[2]/following-sibling::a[@class='ch-search-item ch-search__item']").size(); i++) {
            posterSerialResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Сериалы']/following::img[@class='ch-search-item__img']");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Season/9d/b0/ffea226b76c7fe6b53a28be2b1840447b15f/tile__web.jpeg')", posterSerialResultSearchAll.get(i));
            titleSerialResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Сериалы']/following::div[@class='ch-search-item__title']");
            page.evaluate("t => t.innerText='Название сериала'", titleSerialResultSearchAll.get(i));
            subtitleSerialResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Сериалы']/following::div[@class='ch-search-item__subtitle']");
            page.evaluate("d => d.textContent='1 сезон, Жанр'", subtitleSerialResultSearchAll.get(i));
        }
        List<ElementHandle> posterCollectionResultSearchAll;
        List<ElementHandle> titleCollectionResultSearchAll;
        for (int i = 0; i < page.querySelectorAll("(//div[@class='ch-search__title-line'])[3]/following-sibling::a[@class='ch-search-item ch-search__item']").size(); i++) {
            posterCollectionResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Подборки']/following::img[@class='ch-search-item__img']");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Season/f3/e2/d64f0cdef60e2eaacec576b87e8cb005bacf/tile__web-wp.webp')", posterCollectionResultSearchAll.get(i));
            titleCollectionResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Подборки']/following::div[@class='ch-search-item__title']");
            page.evaluate("t => t.innerText='Название подборки'", titleCollectionResultSearchAll.get(i));
        }

        List<ElementHandle> posterTvProgramResultSearchAll;
        List<ElementHandle> titleTvProgramResultSearchAll;
        List<ElementHandle> subtitleTvProgramResultSearchAll;
        for (int i = 0; i < page.querySelectorAll("(//div[@class='ch-search__title-line'])[4]/following-sibling::a[@class='ch-search-item ch-search__item']").size(); i++) {
            posterTvProgramResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']/following::img[@class='ch-search-item__img']");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/img/dc/3e/89aaa164a2655c2aa0301e375d48f0cd5940/tile__web-wp.webp')", posterTvProgramResultSearchAll.get(i));
            titleTvProgramResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']/following::div[@class='ch-search-item__title']");
            page.evaluate("t => t.innerText='Название тв передачи'", titleTvProgramResultSearchAll.get(i));
            subtitleTvProgramResultSearchAll = page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']/following::div[@class='ch-search-item__subtitle']");
            page.evaluate("d => d.textContent='Сегодня, 00:00, Docubox'", subtitleTvProgramResultSearchAll.get(i));
        }

        ElementHandle resultSearch = page.querySelector("//div[@class='ch-search__result']");
        // делаем скриншот элемента "ResponseOnValidSearchForUnauthorized":
        vrt.track(
                "ResponseOnValidSearchForUnauthorized",
                Base64.getEncoder().encodeToString(resultSearch.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToButtonPromocode() {
        page.click("(//div[@class='ch-trigger__container'])[2]");
    }

    public void checkOpenPopUpPromoCode() {
        page.waitForSelector("//h3[text()='Введите промокод']");
    }

    public void checkElementsPopUpPromoCode() {
        page.querySelector("//h3[text()='Введите промокод']");
        page.querySelector("._1uIaIlXYEWVJVnh2J-OqTc");
        page.querySelector("//input[@placeholder='Промокод']");
        page.querySelector("//button[text()='Активировать']");
        page.querySelector("._1GJv4RgE7fcPe2l0tSahro");
    }

    public void checkImagePopUpPromoCode() throws IOException, InterruptedException {
        ElementHandle popUpPromoCode = page.querySelector("//div[@aria-label='Popup']");

        // делаем скриншот элемента "popUpPromoCode":
        vrt.track(
                "popUpPromoCode",
                Base64.getEncoder().encodeToString(popUpPromoCode.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openSubsectionPromo() throws InterruptedException {
        Thread.sleep(3000);
        page.click("(//span[contains(text(),'+79')])[2]");
        page.waitForSelector("//div[@class='ch-account-item__icon']");
        page.click("//div[@class='ch-account-item__icon']");
        page.waitForTimeout(3000);
    }

    public void openSubsectionPaymentMethod() {
        page.click("(//span[contains(text(),'+79')])[2]");
        page.waitForSelector("(//span[text()='Способы оплаты'])[1]");
        page.click("(//span[text()='Способы оплаты'])[1]");
        page.waitForSelector("//h1//span[text()='Способы оплаты']");
        page.waitForSelector("//div[text()='Счет основного номера телефона']");
        Assert.assertEquals("Нет текста 'Счет основного номера телефона'", "Счет основного номера телефона", page.querySelector("//div[text()='Счет основного номера телефона']").innerText());
        page.querySelector("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 020 50 27']");
    }

    public void checkImagePagePaymentMethod() throws IOException, InterruptedException {
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        ElementHandle numberPhone = page.querySelector("//div[@class='_3sPPVdFZlo5j1Ys7pGgnnQ']//span");
        numberPhone.evaluate("nP => nP.innerText='+7 926 001 01 01'");
        // делаем скриншот полной страницы "PagePaymentMethod":
        vrt.track(
                "PagePaymentMethod",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openSubsectionConnect() {
        page.click("(//span[contains(text(),'+79')])[2]");
        page.click("(//span[text()='Подключить SmartTV'])[1]");
        page.waitForSelector("//div[text()='Подключение Smart TV']");
    }

    public void checkImagePopUpConnectSmartTv() throws IOException, InterruptedException {
        ElementHandle popUpPromoCode = page.querySelector("//div[@aria-label='Popup']");
        // делаем скриншот элемента "popUpConnectSmartTv":
        vrt.track(
                "popUpConnectSmartTv",
                Base64.getEncoder().encodeToString(popUpPromoCode.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openSubsectionEmail() {
        page.click("(//span[contains(text(),'+79')])[2]");
        page.click("(//span[text()='Email'])[1]");
        page.waitForSelector("//div[text()='Ваш email']");
    }

    public void checkImagePopUpEmail() throws IOException, InterruptedException {
        ElementHandle popUpEmail = page.querySelector("//div[@aria-label='Notification']");
        // делаем скриншот элемента "popUpEmail":
        vrt.track(
                "popUpEmail",
                Base64.getEncoder().encodeToString(popUpEmail.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void goToPackagesPage() {
        page.navigate(frontend+"packages");
    }

    public void checkImageBlockCollectHistoryWatch() throws IOException, InterruptedException {
        page.navigate(frontend);
        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackageAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m']").size(); i++) {
            posterPackageAll = page.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; " +
                    "background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = page.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название контента'", titlePackageAll.get(i));
            descriptionTextPackageAll = page.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span");
            page.evaluate("d => d.textContent='Description'", descriptionTextPackageAll.get(i));
            ageAll = page.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        ElementHandle blockCollectHistoryWatchNil = page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']");
        // делаем скриншот элемента "blockCollectHistoryWatchNil":
        vrt.track(
                "blockCollectHistoryWatchNil",
                Base64.getEncoder().encodeToString(blockCollectHistoryWatchNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        ElementHandle tailWatchAndEditCollectHistoryWatchNil = page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@class='ArHiwAcYUlO8lYdGJYyYT']");
        // делаем скриншот элемента "tailWatchAndEditCollectHistoryWatchNil":
        vrt.track(
                "tailWatchAndEditCollectHistoryWatchNil",
                Base64.getEncoder().encodeToString(tailWatchAndEditCollectHistoryWatchNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkOpenPopUpInputEmail(String login) {
        page.waitForSelector("//h1[text()='Введите E-mail']|//h1[text()='Введите пароль']");
        if (page.querySelectorAll("//h1[text()='Введите пароль']").size() != 0) {
            pageCMS = contextIncognitoModeHeadless.newPage();
            String onlyPreprod = backend.substring(8);
            pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
            pageCMS.click("//form[@method='GET']//input[1]");
            pageCMS.fill("//form[@method='GET']//input[1]", login);
            pageCMS.click("//button[text()='Поиск']");
            pageCMS.waitForSelector("//td[text()='79261184972']");
            pageCMS.click("//a[contains(@href, '/cms/households/')]");
            pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.onDialog(dialog -> dialog.accept());
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.close();
            page.bringToFront();
            page.reload();
            page.waitForSelector("(//span[text()='Вход'])[1]");
            page.click("(//span[text()='Вход'])[1]");
            page.waitForSelector("//h1[text()='Введите номер телефона']");
            page.focus("//input[@name='phone']");
            page.fill("//input[@name='phone']", login);
            page.click("//button[text()='Далее']");
            page.waitForSelector("//h1[text()='Введите E-mail']");
        }
    }

    public void checkInputValidEmailInPopUpInputEmail(String email) throws InterruptedException {
        page.querySelector("//h1[text()='Введите E-mail']");
        page.fill("//input[@placeholder='Введите e-mail']", email);
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
        ElementHandle buttonComeIn = page.waitForSelector("//button[text()='Далее']");
        Thread.sleep(3000);
        String background = (String) buttonComeIn.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: the color of the element is not green", background.contains("rgb(0, 215, 86)"));
    }

    public void copyPasteCodMsisdnForNonMF(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/msisdn_confirmations");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        String codMsisdn = pageCMS.waitForSelector("(//td[text()='79261184972']/following-sibling::td)[4]").innerText();
        pageCMS.close();
        page.waitForSelector("//input[@placeholder='Введите код из sms']");
        page.fill("//input[@placeholder='Введите код из sms']",codMsisdn);
    }

    public void deleteAccountNonMF(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        pageCMS.waitForSelector("//td[text()='79261184972']");
        pageCMS.click("//a[contains(@href, '/cms/households/')]");
        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
        pageCMS.click("//button[text()='Удалить']");
        pageCMS.onDialog(dialog -> dialog.accept());
        pageCMS.click("//button[text()='Удалить']");
        pageCMS.close();
    }

    public void reloadPage() {
        page.reload();
    }

    public void saveCookiesBrowserHeadless() {
        contextIncognitoModeHeadless.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
    }

    public void getCookiesAndOpenHeadfullBrowser() {
        contextIncognitoModeHeadfull = browserIncognitoModeHeadfull.newContext(new Browser.NewContextOptions().setViewportSize(null).setStorageStatePath(Paths.get("state.json")));
        pageHeadfull = contextIncognitoModeHeadfull.newPage();
        pageHeadfull.navigate(frontend);
        pageHeadfull.setDefaultNavigationTimeout(60000);
        contextIncognitoModeHeadless.close();
    }

    public void goToNilPageHeadfull() {
        pageHeadfull.navigate(frontend);
    }

    public void goToPackagesPageHeadfull() {
        pageHeadfull.navigate(frontend+"packages");
    }

    public void goToTvTabTvProgramInAirHeadfull() {
        pageHeadfull.navigate(frontend+"tv/tv_catalog");
    }

    public void goToSerialsPageHeadfull() {
        pageHeadfull.navigate(frontend+"shows");
    }

    public void reloadPageHeadfull() {
        pageHeadfull.reload();
    }

    public void logOut() {
        page.click("(//span[contains(text(),'+79')])[2]");
        page.click("(//span[text()='Выйти'])[1]");
    }
    public void chooseBundleNotSelected(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260205027']|//td[text()='79260172279']");
        pageCMS.click("//a[contains(@href, '/cms/households/')]");
        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
        pageCMS.click("(//a[@role='button'])[2]");
        pageCMS.waitForSelector("//h3[text()=' Редактирование хаусхолда ']");
        pageCMS.reload();
        pageCMS.querySelector("id=bundle").click();
//        pageCMS.querySelector("//option[. = '(не выбрано)']").hover();
        pageCMS.hover("//select[@id='bundle']//option[text()='(не выбрано)']");
        pageCMS.click("//select[@id='bundle']//option[text()='(не выбрано)']");
        pageCMS.click("//input[@value='Сохранить']");
        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
        pageCMS.click("//button[text()='Обновить ТП/ТО и бандлы']");
        pageCMS.close();
        page.bringToFront();
        page.reload();
    }

    public void goToSportPage() {
        page.navigate(frontend+"sport");
    }

    public void deleteImagesFromFilm() {
        page.navigate(frontend);
        page.click("(//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_title')])[3]");
        String nameFilm = page.url().substring(44);
        System.out.println(nameFilm);
        String url = String.join(nameFilm,backend+"cms/packages/","/change_posters");
        System.out.println(url);
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("poster=http%3A%2F%2Fstatic.cdn.megafon.tv%2Fimages%2FFilm%2Ffd%2Fc2%2F9a45ceb01a9b56f17232368b9874dec72051%2FPoster.pn&wide_poster=http%3A%2F%2Fstatic.cdn.megafon.tv%2Fimages%2FFilm%2Fd4%2F2c%2F52071210c58982627bcd80c9ccdb9bc2b636%2FWidePoster.pn&tile=http%3A%2F%2Fstatic.cdn.megafon.tv%2Fimages%2FFilm%2F2a%2F14%2F96ee4475306fc00a4473d5db475fce6b53ab%2FTile.pn&rate_helper=https%3A%2F%2Fsrv2.imgonline.com.ua%2Fresult_img%2Fimgonline-com-ua-Resize-JEFU850hpoWTVRoF.jp").
                when().
                when().post(url).
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void addImagesFromFilm() {
        page.navigate(frontend);
        page.click("(//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_title')])[3]");
        String nameFilm = page.url().substring(44);
        System.out.println(nameFilm);
        String url = String.join(nameFilm,backend+"cms/packages/","/change_posters");
        System.out.println(url);
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("poster=http%3A%2F%2Fstatic.cdn.megafon.tv%2Fimages%2FFilm%2F54%2Fd7%2Fe2622c2dce4989281811571624fd3cbea23d%2FPoster.png&wide_poster=http%3A%2F%2Fstatic.cdn.megafon.tv%2Fimages%2FFilm%2F54%2Fd7%2Fe2622c2dce4989281811571624fd3cbea23d%2FWidePoster.png&tile=http%3A%2F%2Fstatic.cdn.megafon.tv%2Fimages%2FFilm%2F54%2Fd7%2Fe2622c2dce4989281811571624fd3cbea23d%2FTile.png&rate_helper=http%3A%2F%2Fstatic.cdn.megafon.tv%2Fimages%2FFilm%2F54%2Fd7%2Fe2622c2dce4989281811571624fd3cbea23d%2FRateHelper.png").
                when().
                when().post(url).
                then().statusCode(anyOf(is(200), is(302)));
        page.navigate(frontend);
        page.click("(//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_title')])[3]");
        page.navigate(frontend);
    }


    public void openMinFramePage() {
     page.setViewportSize(540, 1334);
    }

    public void openMediumFramePage() {
     page.setViewportSize(799, 1674);
    }

    public void openWideFramePage() {
     page.setViewportSize(1900, 920);
    }

    public void inputPasswordAutorization(String password) {
     page.querySelector("//h1[text()='Введите пароль']");
     page.fill("//input[@type='password']", password);
    }

    public void chooseBucket110InCmsHh(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260205027']|//td[text()='79260172279']");
        pageCMS.click("//a[contains(@href, '/cms/households/')]");
        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
        pageCMS.click("(//a[@role='button'])[2]");
        pageCMS.waitForSelector("//h3[text()=' Редактирование хаусхолда ']");
        pageCMS.selectOption("//select[@name='hypothesis_group']", "110");
        pageCMS.selectOption("//select[@id='ab_group']", "0");
        pageCMS.click("text=Сохранить");
        pageCMS.click("text=Запрос на пересчет ПГ");
//        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
//        pageCMS.click("//button[text()='Обновить ТП/ТО и бандлы']");
//        pageCMS.click("//button[text()='Запрос на пересчет ПГ']");
        pageCMS.close();
        page.bringToFront();
        page.reload();
    }

    public void chooseBucket103InCmsHh(String login) {
        pageCMS = contextIncognitoModeHeadless.newPage();
        String onlyPreprod = backend.substring(8);
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@"+onlyPreprod+"cms/households?role=user");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260205027']|//td[text()='79260172279']");
        pageCMS.click("//a[contains(@href, '/cms/households/')]");
        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
        pageCMS.click("(//a[@role='button'])[2]");
        pageCMS.waitForSelector("//h3[text()=' Редактирование хаусхолда ']");

        pageCMS.selectOption("//select[@name='hypothesis_group']", "103");
        pageCMS.selectOption("//select[@id='ab_group']", "0");
        pageCMS.click("text=Сохранить");
        pageCMS.click("text=Запрос на пересчет ПГ");
//        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
//        pageCMS.click("//button[text()='Обновить ТП/ТО и бандлы']");
//        pageCMS.click("//button[text()='Запрос на пересчет ПГ']");
        pageCMS.close();
        page.bringToFront();
        page.reload();
    }

    public void startFiddlerSlowNetwork() throws IOException, InterruptedException, TimeoutException, ExecutionException {
        Process startSlowNetwork = Runtime.getRuntime().exec("cmd /c \"cd C:/Users/Mikhailnt/AppData/Local/Programs/Fiddler && ExecAction start\"");
    }

    public void stopFiddlerSlowNetwork() throws ExecutionException, InterruptedException, IOException {
        Process stopSlowNetwork = Runtime.getRuntime().exec("cmd /c \"cd C:/Users/Mikhailnt/AppData/Local/Programs/Fiddler && ExecAction stop\"");
    }

    public void clearCookies() {
        contextIncognitoModeHeadless.clearCookies();
    }

    public void openPlatformSmartTv() throws InterruptedException {
        pageSmartTv = contextIncognitoModeHeadless.newPage();
        pageSmartTv.navigate("http://staging-smart-nettv.megafon.tv");
        Thread.sleep(10000);
        pageSmartTv.waitForSelector("//span[text()='Закрыть']").click();
        pageSmartTv.waitForSelector("//span[text()='Закрыть']").click();
        pageSmartTv.waitForSelector("//div[text()='Меню']").click();
        pageSmartTv.waitForSelector("//div[text()='Настройки']").click();
//        pageSmartTv.waitForSelector("//span[text()='Очистить хранилище']").click();
        pageSmartTv.waitForSelector("//span[text()='Изменить настройки']").click();
        pageSmartTv.waitForSelector("//span[text()='Окружение bmp-api']").click();
        String onlyPreprod = frontend.substring(12, frontend.length() - 12);
        pageSmartTv.waitForSelector("//span[text()='"+onlyPreprod+"']").click();
        if(pageSmartTv.querySelectorAll("(//span[text()='Назад'])[2]").size()>0){
            pageSmartTv.click("(//span[text()='Назад'])[2]");
        }
        if(pageSmartTv.querySelectorAll("//span[text()='Назад']").size()>0){
            pageSmartTv.click("//span[text()='Назад']");
        }
        pageSmartTv.close();
        page.bringToFront();
    }

    public void stopCarouselBanners() throws InterruptedException, AWTException {
        sleep(3000);
        page.mouse().click(200,200, new Mouse.ClickOptions().setButton(MouseButton.RIGHT));
//        System.setProperty("java.awt.headless", "true");
//        Robot bot = new Robot();
//        bot.mouseMove(200,200);
//        bot.mousePress(InputEvent.BUTTON1_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_MASK);
//        bot.mouseMove(0,0);
//        page.keyboard().press("Escape");

        sleep(5000);
    }
}
