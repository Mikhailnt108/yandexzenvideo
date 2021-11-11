package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HeaderMenu extends BasePageWebDriver {
    //ПП1
    String NIL_Page_PP1 = "https://web-preprod1.megafon.tv/";
    String TV_Page_PP1 = "https://web-preprod1.megafon.tv/tv/";
    String Films_Page_PP1 = "https://web-preprod1.megafon.tv/movies/vods";
    String Serials_Page_PP1 = "https://web-preprod1.megafon.tv/shows";
    String Kids_Page_PP1 = "https://web-preprod1.megafon.tv/kids";
    String Sport_Page_PP1 = "https://web-preprod1.megafon.tv/sport";
    String Packages_Page_PP1 = "https://web-preprod1.megafon.tv/packages";
    String Collections_Page_PP1 = "https://web-preprod1.megafon.tv/collection";
    String CMS_PP1_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod1.megafon.tv/cms/households?role=user";
    String Promo_Page_PP1 = "https://web-preprod1.megafon.tv/profile/promotions";

    //ПП2
    String NIL_Page_PP2 = "https://web-preprod2.megafon.tv/";
    String TV_Page_PP2 = "https://web-preprod2.megafon.tv/tv/";
    String Films_Page_PP2 = "https://web-preprod2.megafon.tv/movies/vods";
    String Serials_Page_PP2 = "https://web-preprod2.megafon.tv/shows";
    String Kids_Page_PP2 = "https://web-preprod2.megafon.tv/kids";
    String Sport_Page_PP2 = "https://web-preprod2.megafon.tv/sport";
    String Packages_Page_PP2 = "https://web-preprod2.megafon.tv/packages";
    String Collections_Page_PP2 = "https://web-preprod2.megafon.tv/collection";
    String CMS_PP2_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod2.megafon.tv/cms/households?role=user";
    String Promo_Page_PP2 = "https://web-preprod2.megafon.tv/profile/promotions";

    //ПП3
    String NIL_Page_PP3 = "https://web-preprod3.megafon.tv/";
    String TV_Page_PP3 = "https://web-preprod3.megafon.tv/tv/";
    String Films_Page_PP3 = "https://web-preprod3.megafon.tv/movies/vods";
    String Serials_Page_PP3 = "https://web-preprod3.megafon.tv/shows";
    String Kids_Page_PP3 = "https://web-preprod3.megafon.tv/kids";
    String Sport_Page_PP3 = "https://web-preprod3.megafon.tv/sport";
    String Packages_Page_PP3 = "https://web-preprod3.megafon.tv/packages";
    String Collections_Page_PP3 = "https://web-preprod3.megafon.tv/collection";
    String CMS_PP3_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod3.megafon.tv/cms/households?role=user";
    String Promo_Page_PP3 = "https://web-preprod3.megafon.tv/profile/promotions";

    //ПП4
    String NIL_Page_PP4 = "https://web-preprod4.megafon.tv/";
    String TV_Page_PP4 = "https://web-preprod4.megafon.tv/tv/";
    String Films_Page_PP4 = "https://web-preprod4.megafon.tv/movies/vods";
    String Serials_Page_PP4 = "https://web-preprod4.megafon.tv/shows";
    String Kids_Page_PP4 = "https://web-preprod4.megafon.tv/kids";
    String Sport_Page_PP4 = "https://web-preprod4.megafon.tv/sport";
    String Packages_Page_PP4 = "https://web-preprod4.megafon.tv/packages";
    String Collections_Page_PP4 = "https://web-preprod4.megafon.tv/collection";
    String CMS_PP4_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod4.megafon.tv/cms/households?role=user";
    String Promo_Page_PP4 = "https://web-preprod4.megafon.tv/profile/promotions";


    //ПП5
    String NIL_Page_PP5 = "https://web-preprod5.megafon.tv/";
    String TV_Page_PP5 = "https://web-preprod5.megafon.tv/tv/";
    String Films_Page_PP5 = "https://web-preprod5.megafon.tv/movies/vods";
    String Serials_Page_PP5 = "https://web-preprod5.megafon.tv/shows";
    String Kids_Page_PP5 = "https://web-preprod5.megafon.tv/kids";
    String Sport_Page_PP5 = "https://web-preprod5.megafon.tv/sport";
    String Packages_Page_PP5 = "https://web-preprod5.megafon.tv/packages";
    String Collections_Page_PP5 = "https://web-preprod5.megafon.tv/collection";
    String CMS_PP5_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user";
    String Promo_Page_PP5 = "https://web-preprod5.megafon.tv/profile/promotions";

    //ПП6
    String NIL_Page_PP6 = "https://web-preprod6.megafon.tv/";
    String TV_Page_PP6 = "https://web-preprod6.megafon.tv/tv/";
    String Films_Page_PP6 = "https://web-preprod6.megafon.tv/movies/vods";
    String Serials_Page_PP6 = "https://web-preprod6.megafon.tv/shows";
    String Kids_Page_PP6 = "https://web-preprod6.megafon.tv/kids";
    String Sport_Page_PP6 = "https://web-preprod6.megafon.tv/sport";
    String Packages_Page_PP6 = "https://web-preprod6.megafon.tv/packages";
    String Collections_Page_PP6 = "https://web-preprod6.megafon.tv/collection";
    String CMS_PP6_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod6.megafon.tv/cms/households?role=user";
    String Promo_Page_PP6 = "https://web-preprod6.megafon.tv/profile/promotions";

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void goToNilPage() {
        open(NIL_Page_PP3);
    }

    public void goToTvPage() {
        webDriver.get(TV_Page_PP3);
    }


    public void goToFilmsPage() {
        webDriver.get(Films_Page_PP3);
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
    }

    public void goToSerialsPage() {
        webDriver.get(Serials_Page_PP3);
        isElementDisplayed(By.xpath("//h1[text()='Сериалы']"));
    }

    public void goToKidsPage() {
        webDriver.get(Kids_Page_PP3);
        isElementDisplayed(By.xpath("//span[text()='Детям']"));
    }

    public void goToSportPage() {
        webDriver.get(Sport_Page_PP3);
        isElementDisplayed(By.xpath("//h1[text()='Спорт']"));
    }

    public void goToPackagesPage() {
        webDriver.get(Packages_Page_PP3);
        isElementDisplayed(By.xpath("//span[text()='Магазин']"));
    }

    public void goToAllCollectionsPage() {
        webDriver.get(Collections_Page_PP3);

    }

    public void checkOpenPopUpCreatePasswordForFlowRegistrationMF(String login, String password) throws InterruptedException {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']"));
        if (webDriver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) webDriver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod3.megafon.tv/cms/households?role=user')");
            ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
            webDriver.switchTo().window((String) tabs2.get(1));
            click(By.xpath("//form[@method='GET']//input[1]"));
            writeText(By.xpath("//form[@method='GET']//input[1]"), login);
            click(By.xpath("//button[text()='Поиск']"));
            isElementDisplayed(By.xpath("//td[text()='79250110166']|//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']|//td[text()='79267644248']"));
            click(By.xpath("//a[contains(@href, '/cms/households/')]"));
            isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
            click(By.xpath("//button[text()='Удалить']"));
            webDriver.switchTo().alert().accept();
            webDriver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Список хаусхолдов']")));
            webDriver.close();
            webDriver.switchTo().window((String) tabs2.get(0));
            webDriver.navigate().refresh();
            isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
            click(By.xpath("(//span[text()='Вход'])[1]"));
            isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
            WebElement element = webDriver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
            element.click();
            for (int i = 0; i < login.length(); i++){
                char c = login.charAt(i);
                String s = new StringBuilder().append(c).toString();
                element.sendKeys(s);
            }
            click(By.xpath("//button[text()='Далее']"));
            isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
            WebElement element1 = webDriver.findElement(By.xpath("//input[@type='password']"));
            element1.sendKeys(password);
        } else {
            WebElement element1 = webDriver.findElement(By.xpath("//input[@type='password']"));
            element1.sendKeys(password);
        }
    }

    public void checkOpenPopUpCreatePasswordForFlowRegistrationNonMF(String login, String password) throws InterruptedException {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']"));
        if (webDriver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) webDriver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod3.megafon.tv/cms/households?role=user')");
            ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
            webDriver.switchTo().window((String) tabs2.get(1));
            click(By.xpath("//form[@method='GET']//input[1]"));
            writeText(By.xpath("//form[@method='GET']//input[1]"), login);
            click(By.xpath("//button[text()='Поиск']"));
            isElementDisplayed(By.xpath("//td[text()='79261184972']"));
            click(By.xpath("//a[contains(@href, '/cms/households/')]"));
            isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
            click(By.xpath("//button[text()='Удалить']"));
            webDriver.switchTo().alert().accept();
            webDriver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Список хаусхолдов']")));
            webDriver.close();
            webDriver.switchTo().window((String) tabs2.get(0));
            webDriver.navigate().refresh();
            isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
            click(By.xpath("(//span[text()='Вход'])[1]"));
            isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
            WebElement element = webDriver.findElement(By.xpath("//input[@value='+7']"));
            element.click();
            for (int i = 0; i < login.length(); i++){
                char c = login.charAt(i);
                String s = new StringBuilder().append(c).toString();
                element.sendKeys(s);
            }
            click(By.xpath("//button[text()='Далее']"));
            isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
            WebElement element1 = webDriver.findElement(By.xpath("//input[@type='password']"));
            element1.sendKeys(password);
        } else {
            WebElement element1 = webDriver.findElement(By.xpath("//input[@type='password']"));
            element1.sendKeys(password);
        }
    }

    public void noConnectSmartTv() throws InterruptedException {
        String invalidСodSmartTv = "12345";
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Подключить SmartTV'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Подключение Smart TV']"));
        webDriver.findElement(By.xpath("//input[@placeholder='Код подтверждения']")).sendKeys(invalidСodSmartTv);
        click(By.xpath("//button[text()='Подключить Smart TV']"));
        Assert.assertEquals("Нет текста 'Неверный код'", "Неверный код", webDriver.findElement(By.xpath("//div[text()='Неверный код']")).getText());
        click(By.className("_1bciqjt58pgm0il2tiJTtp"));
    }

    public void connectSmartTv() throws InterruptedException {
        ((JavascriptExecutor) webDriver).executeScript("window.open('http://smart-viera.megafon.tv/#scene/start')");
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//div[text()='Очистить настройки']"));
        click(By.xpath("//div[@data-type='preprod3']"));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();"
                , webDriver.findElement(By.xpath("//div[text()='Войти']")));
        click(By.xpath("//div[text()='Войти']"));
        click(By.xpath("//span[text()='Скрыть']"));
        String codSmartTv = webDriver.findElement(By.xpath("//div[@class='enter-msisdn-pair__code js-code']")).getText();
        // здесь переключаемся опять на вкладку с мегафонТВ, закрываем вкладку CMS и далее вставляем взятый код из CMS в открытый попап в поле подтверждения регистрации
        webDriver.close();
        webDriver.switchTo().window((String) tabs2.get(0));
        // перезалогиниться тем же юзером:
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Выйти'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
        click(By.xpath("(//span[text()='Вход'])[1]"));
        WebElement element = webDriver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        element.sendKeys("9260205027");
        click(By.xpath("//button[text()='Далее']"));
        WebElement element2 = webDriver.findElement(By.xpath("//input[@type='password']"));
        element2.sendKeys("111111");
        click(By.xpath("//button[text()='Войти']"));
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));}
        webDriver.navigate().refresh();
        // подключить смарт тв:
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Подключить SmartTV'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Подключение Smart TV']"));
        writeText(By.xpath("//input[@placeholder='Код подтверждения']"), codSmartTv);
        click(By.xpath("//button[text()='Подключить Smart TV']"));
        isElementDisplayed(By.xpath("//div[text()='SmartTV подключен!']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkNotLoggedIsCorrect() throws InterruptedException {
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));}
        webDriver.navigate().refresh();
        isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
    }

    public void clickToEnter(String buttonEnter) throws InterruptedException {
        click(By.xpath("(//span[text()='Вход'])[1]"));
    }

    public void checkLoginUserIsCorrectFlowForMF() throws InterruptedException {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
    }

    public void checkLoginUserIsCorrectFlowForMFFast() throws InterruptedException {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
    }

    public void checkLoginUserIsCorrectFlowForAPINotif() throws InterruptedException {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//h3[text()='Специальное предложение для Вас!']|//h3[text()='Специально для Вас!']|//h3[contains(text(),'Вам доступно')]|//div[text()='Акция недоступна']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
    }


    public void checkLoginUserIsCorrectForBlockingMf() throws InterruptedException {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
    }


    public void clickToButtonPromo() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[2]"));
    }

    public void clickToTabFilms() throws InterruptedException {
        click(By.xpath("(//div[text()='Фильмы'])[1]"));
    }

    public void clickToTabSerials() throws InterruptedException {
        click(By.xpath("(//div[text()='Сериалы'])[1]"));
    }

    public void clickToTabShop() throws InterruptedException {
        click(By.xpath("(//div[text()='Магазин'])[1]"));
    }

    public void clickToSearchButton() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[1]"));
    }

    public void checkOpenFieldSearch() {
        isElementDisplayed(By.xpath("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]"));
    }

    public void inputInvalidRequestSearch() {
        writeText(By.xpath("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]"), " ,#");
    }

    public void checkResponseOnInvalidSearch() {
        isElementDisplayed(By.xpath("//div[text()='Ничего не найдено']"));
    }

    public void inputValidRequestSearch() {
        writeText(By.xpath("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]"), "мир");
    }

    public void checkResponseOnValidSearch() {
        isElementDisplayed(By.xpath("(//div[text()='Фильмы'])[2]"));
        isElementDisplayed(By.xpath("(//div[text()='Сериалы'])[2]"));
        isElementDisplayed(By.xpath("//div[text()='ТВ-каналы']"));
        isElementDisplayed(By.xpath("//div[text()='ТВ-передачи']"));
        isElementDisplayed(By.linkText("Все результаты"));
    }

    public void clickToLinkShowAll() throws InterruptedException {
        click(By.linkText("Все результаты"));
    }

    public void clickToLinkAll() throws InterruptedException {
        click(By.partialLinkText("Все"));
    }

    public void checkOpenPopUpPromoCode() {
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
    }

    public void checkPopUpPromotionNotAvailable() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[text()='Акция недоступна']"));
        click(By.xpath("//button[text()='Закрыть']"));

    }

    public void clickToPhoneNumber() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
    }

    public void openSubsectionPromo() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("(//span[contains(text(),'+79')])[2]"));
        click(By.xpath("(//span[text()='Акции'])[1]"));
        Thread.sleep(3000);
    }

    public void checkLoginUserIsCorrectFlowForNonMF() throws InterruptedException {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        webDriver.navigate().refresh();
    }

    public void openSubsectionPaymentMethod() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Способы оплаты'])[1]"));
        Assert.assertEquals("Нет заголовока 'Способы оплаты'", "Способы оплаты", webDriver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals("Нет текста 'Счет основного номера телефона'", "Счет основного номера телефона", webDriver.findElement(By.xpath("//div[text()='Счет основного номера телефона']")).getText());
        Assert.assertEquals("Нет текста '+7 926 019 21 44'", "+7 926 019 21 44", webDriver.findElement(By.xpath("//span[text()='+7 926 019 21 44']")).getText());
    }


    public void checkOpenPageInputPhone() {
        isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
    }

    public void checkElementsPopUpInputPhone() {
        isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Чтобы смотреть ТВ-каналы,сериалы и фильмы')]"));
        isElementDisplayed(By.xpath("//input[@placeholder='Номер телефона']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Далее']"));
    }

    public void inputLogin(String login) throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath("//input[@value='+7']"));
        element.click();
        for (int i = 0; i < login.length(); i++){
            char c = login.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }

    public void checkActiveButtonNext() {
        Assert.assertEquals("Кнопка 'Далее' НЕ активна", 1, webDriver.findElements(By.xpath("//button[text()='Далее']")).size());
        Assert.assertEquals("Кнопка 'Далее' НЕ активна", 0, webDriver.findElements(By.xpath("//button[@disabled and text()='Далее']")).size());
    }

    public void clickToNext(String button) throws InterruptedException {
        click(By.xpath("//button[text()='Далее']"));
    }

    public void checkOpenPopUpInputPassword() {

        isElementDisplayed(By.xpath("//div[text()='Введите пароль']"));
    }

    public void checkElementsPopUpCreatePassword() {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
        isElementDisplayed(By.xpath("//span[text()='Для регистрации в МегаФон ТВ']"));
        isElementDisplayed(By.xpath("//input[@placeholder='Пароль']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
        isElementDisplayed(By.xpath("(//input[@type='checkbox']/following-sibling::div/*[@viewBox])[1]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Я согласен с')]//a[@href='//www.megafon.ru/ad/offer_mediaportal' and contains(text(), 'условиями оказания услуги')]"));
    }

    public void checkElementsPopUpInputPassword() {
        isElementDisplayed(By.xpath("//div[text()='Введите пароль']"));
        isElementDisplayed(By.xpath("//span[text()='Для авторизации в МегаФон ТВ']"));
        isElementDisplayed(By.xpath("//input[@placeholder='Пароль']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
        isElementDisplayed(By.xpath("//button[text()='Я не помню пароль']"));
    }

    public void inputSixSimbolPassword(String password) {
        WebElement element = webDriver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(password);
    }

    public void inputLessThanSixSimbolPassword(String lessthansix) {
        WebElement element = webDriver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(lessthansix);
    }

    public void checkDisabledButtonComeIn() {
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
    }

    public void clickToLinkOffer() throws InterruptedException {
        click(By.xpath("//a[@href='//www.megafon.ru/ad/offer_mediaportal']"));
    }

    public void checkOpenPageOffer() {
        String url1 = "https://moscow.megafon.ru/download/~federal/oferts/mediaportal_oferta.pdf";
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.switchTo().window((String) tabs1.get(1));
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        String url2 = webDriver.getCurrentUrl();
        System.out.println(url2);
        Assert.assertEquals(url1, url2);
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
    }

    public void checkActiveButtonComeIn() {
        Assert.assertEquals("Кнопка 'Войти' НЕ активна", 1, webDriver.findElements(By.xpath("//button[text()='Войти']")).size());
        Assert.assertEquals("Кнопка 'Войти' НЕ активна", 0, webDriver.findElements(By.xpath("//button[@disabled and text()='Войти']")).size());
    }

    public void clickToComeIn(String button) throws InterruptedException {
        click(By.xpath("//button[text()='Войти']"));
    }

    public void inputEmail() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Email'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Email']"));
        Assert.assertEquals("Отмечен чек-бокс", 0, webDriver.findElements(By.xpath("//div[@class='_1EDH3fad4oU0crhGTzvo74 _1ZpTJSYmF419gKUU8fRgU9']")).size());
        Assert.assertEquals("Кнопка 'Сохранить' не дизейбл", 1, webDriver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        writeText(By.xpath("//input[@type='email']"), "email@invalid");
        Assert.assertEquals("Кнопка 'Сохранить' не дизейбл", 1, webDriver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        writeText(By.xpath("//input[@type='email']"), "ispolnitel1mt@ya.ru");
        Assert.assertEquals("Кнопка 'Сохранить' не активна", 0, webDriver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        click(By.xpath("//div[@role='presentation']//div[1]"));
        Assert.assertEquals("Не отмечен чек-бокс", 1, webDriver.findElements(By.xpath("//div[@class='_1EDH3fad4oU0crhGTzvo74 _1ZpTJSYmF419gKUU8fRgU9']")).size());
        click(By.xpath("//div[text()='СОХРАНИТЬ']"));
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Email'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Email']"));
        isElementDisplayed(By.xpath("//input[@value='ispolnitel1mt@ya.ru']"));
        click(By.xpath("(//div[@role='dialog']//button)[2]"));
    }

    public void logOut() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[3]"));
        click(By.xpath("(//span[text()='Выйти'])[1]"));
    }


    public void checkOpenPopUpInputCode() {
        isElementDisplayed(By.xpath("//div[text()='Введите код']"));
    }

    public void checkElementsPopUpInputCode() {
        isElementDisplayed(By.xpath("//div[text()='Введите код']"));
        isElementDisplayed(By.xpath("//i[text()='+7 926 019 21 44']|//i[text()='+7 926 017 22 79']|/i[text()='+7 926 020 50 27']"));
        isElementDisplayed(By.xpath("//span[text()='На номер ' and text()=' отправлено sms с кодом подтверждения']"));
        isElementDisplayed(By.xpath("//input[@placeholder='Код подтверждения']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Получить новый код']"));
    }

    public void inputInvalidCodeСonfirmation(String code) {
        WebElement element = webDriver.findElement(By.xpath("//input[@placeholder='Код подтверждения']"));
        element.click();
        element.clear();
        element.sendKeys(code);

    }

    public void checkErrorMessage1() {
        isElementDisplayed(By.xpath("//div[text()='Неверный код']"));
        String errorMessage1 = webDriver.findElement(By.cssSelector("div[data-test='CodeError']")).getCssValue("color");
        System.out.println(errorMessage1);
        Assert.assertEquals("Сообщение об ошибке не красного цвета", "rgba(255, 51, 51, 1)", errorMessage1);
        String borderInput = webDriver.findElement(By.cssSelector("input[name='code-confirm']")).getCssValue("border-color");
        System.out.println(borderInput);
        Assert.assertEquals("Не красный цвет рамки поля ввода", "rgb(255, 51, 51)", borderInput);
    }

    public void checkErrorMessage2() {
        isElementDisplayed(By.xpath("//div[text()='Неверный пароль']"));
        String errorMessage2 = webDriver.findElement(By.cssSelector("div._3IFyMnnL8xI6B0oOiNOlSp")).getCssValue("color");
        System.out.println(errorMessage2);
        Assert.assertEquals("Сообщение об ошибке не красного цвета", "rgba(255, 51, 51, 1)", errorMessage2);
        String borderInput = webDriver.findElement(By.cssSelector("input[type='password']")).getCssValue("border-color");
        System.out.println(borderInput);
        Assert.assertEquals("Не красный цвет рамки поля ввода", "rgb(255, 51, 51)", borderInput);
    }

    public void inputInvalidCodeMoreThanThreeTimes() throws InterruptedException {
        for (int i = 0; i <= 2; i++) {
            click(By.xpath("//button[text()='Войти']"));
        }
    }

    public void checkElementsPopUpForInvalidCodeMoreThanThreeTimes() {
        isElementDisplayed(By.xpath("//div[text()='Код более не действителен']"));
        isElementDisplayed(By.xpath("//input[@placeholder='Код подтверждения' and @disabled]"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
        isElementDisplayed(By.xpath("//button[text()='Получить новый код']"));
        Assert.assertEquals("Кнопка 'Получить новый код' НЕ активна", 0, webDriver.findElements(By.xpath("//button[@disabled and text()='Получить новый код']")).size());
    }

    public void clickToButtonGetNewCode() throws InterruptedException {
        click(By.xpath("//button[text()='Получить новый код']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Получить новый код']")));
        click(By.xpath("//button[text()='Получить новый код']"));
    }

    public void clickToButtonForgetPassword() throws InterruptedException {
        click(By.xpath("//button[text()='Я не помню пароль']"));
    }

    public void checkLoginUserIsCorrectAfterForgetPassword() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
    }

    public void closePopUpNotDefinedTariff() throws InterruptedException {
        webDriver.navigate().refresh();
        isElementDisplayed(By.xpath("//div[text()='Акция недоступна']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkOpenPopUpCreatePasswordForCaseRegistrationMF(String login) throws InterruptedException {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']"));
        if (webDriver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) webDriver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod3.megafon.tv/cms/households?role=user')");
            ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
            webDriver.switchTo().window((String) tabs2.get(1));
            click(By.xpath("//form[@method='GET']//input[1]"));
            writeText(By.xpath("//form[@method='GET']//input[1]"), login);
            click(By.xpath("//button[text()='Поиск']"));
            isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
            click(By.xpath("//a[contains(@href, '/cms/households/')]"));
            isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
            click(By.xpath("//button[text()='Удалить']"));
            webDriver.switchTo().alert().accept();
            webDriver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Список хаусхолдов']")));
            webDriver.close();
            webDriver.switchTo().window((String) tabs2.get(0));
            webDriver.navigate().refresh();
            isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
            click(By.xpath("(//span[text()='Вход'])[1]"));
            isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
            WebElement element = webDriver.findElement(By.xpath("//input[@value='+7']"));
            element.click();
            for (int i = 0; i < login.length(); i++){
                char c = login.charAt(i);
                String s = new StringBuilder().append(c).toString();
                element.sendKeys(s);
            }
            click(By.xpath("//button[text()='Далее']"));
            isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
        }
    }

    public void checkOpenPopUpInputEmail(String login) throws InterruptedException {
        isElementDisplayed(By.xpath("//div[text()='Введите E-mail']|//div[text()='Введите пароль']"));
        if (webDriver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) webDriver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod3.megafon.tv/cms/households?role=user')");
            ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
            webDriver.switchTo().window((String) tabs2.get(1));
            click(By.xpath("//form[@method='GET']//input[1]"));
            writeText(By.xpath("//form[@method='GET']//input[1]"), login);
            click(By.xpath("//button[text()='Поиск']"));
            isElementDisplayed(By.xpath("//td[text()='79261184972']"));
            click(By.xpath("//a[contains(@href, '/cms/households/')]"));
            isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
            click(By.xpath("//button[text()='Удалить']"));
            webDriver.switchTo().alert().accept();
            webDriver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Список хаусхолдов']")));
            webDriver.close();
            webDriver.switchTo().window((String) tabs2.get(0));
            webDriver.navigate().refresh();
            isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
            click(By.xpath("(//span[text()='Вход'])[1]"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Введите номер телефона']")));
            WebElement element = webDriver.findElement(By.xpath("//input[@value='+7']"));
            element.click();
            for (int i = 0; i < login.length(); i++){
                char c = login.charAt(i);
                String s = new StringBuilder().append(c).toString();
                element.sendKeys(s);
            }
            click(By.xpath("//button[text()='Далее']"));
            isElementDisplayed(By.xpath("//div[text()='Введите E-mail']"));
        }
    }

    public void inputValidEmailInPopUpInputEmail(String email) {
        isElementDisplayed(By.xpath("//div[text()='Введите E-mail']"));
        WebElement element = webDriver.findElement(By.xpath("//input[@placeholder='E-mail']"));
        element.clear();
        element.sendKeys(email);

    }

    public void checkElementsPopUpInputEmail() {
        isElementDisplayed(By.xpath("//div[text()='Введите E-mail']"));
        isElementDisplayed(By.xpath("//span[text()='E-mail будет использоваться для отправки чеков по операциям']"));
        isElementDisplayed(By.xpath("//input[@placeholder='E-mail']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Далее']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Я согласен получать новости и подарки')]"));
        isElementDisplayed(By.xpath("//span[contains(.,'от МегаФон ТВ')]"));
        isElementDisplayed(By.xpath("//input[@type='checkbox']/following-sibling::div[1]"));
    }

    public void inputInvalidEmailInPopUp(String email) {
        isElementDisplayed(By.xpath("//div[text()='Введите E-mail']"));
        WebElement element = webDriver.findElement(By.xpath("//input[@placeholder='E-mail']"));
        element.sendKeys(email);
    }

    public void checkDisabledButtonNext() {
        isElementDisplayed(By.xpath("//button[@disabled and text()='Далее']"));
    }

    public void clickToCheckBoxInPopUpEmail() throws InterruptedException {
        click(By.xpath("//input[@type='checkbox']/following-sibling::div[1]"));
    }

    public void checkOpenPopUpCreatePasswordForNonMF() {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
    }


    public void inputInvalidPassword(String invalidpass) {
        WebElement element = webDriver.findElement(By.xpath("//input[@type='password']"));
        element.clear();
        element.sendKeys(invalidpass);
    }


    public void closePopUpInputPassword() throws InterruptedException {
        click(By.xpath("(//div[@role='dialog']//button)[3]"));
    }

    public void checkOpenPopUpNewPasswordForMF() {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
    }

    public void checkElementsPopUpNewPasswordForMF() {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
        isElementDisplayed(By.xpath("//span[text()='Для авторизации в МегаФон ТВ']"));
        isElementDisplayed(By.xpath("//input[@placeholder='Пароль']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
    }

    public void clickUncheckCheckBox() throws InterruptedException {
        click(By.xpath("(//input[@type='checkbox']/following-sibling::div)[1]"));
        Assert.assertEquals("Не отжат чекбокс", 0, webDriver.findElements(By.xpath("(//input[@type='checkbox']/following-sibling::div/*[@viewBox])[1]")).size());
    }

    public void clickCheckCheckBox() throws InterruptedException {
        click(By.xpath("(//input[@type='checkbox']/following-sibling::div)[1]"));
        Assert.assertEquals("Не прожат чекбокс", 1, webDriver.findElements(By.xpath("(//input[@type='checkbox']/following-sibling::div/*[@viewBox])[1]")).size());
    }

    public void checkAbsencePopUpNotifToNilPage() {
        Assert.assertEquals("Отображается ВУ на НиЛ с фильтром раздел Фильмы", 0, webDriver.findElements(By.xpath("//div[@aria-label='Notification']//h3[text()='автотест ВУ для экрана Фильмы']")).size());
    }


    public void checkElementsPopUpBundleUserMF() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        webDriver.navigate().refresh();
        webDriver.findElement(By.xpath("//h3[contains(text(),'Вам доступно')]"));
        isElementDisplayed(By.xpath("//div[@aria-label='Notification']"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//button)[2]"));
        isElementDisplayed(By.xpath("(//div[@role='dialog']//div)[4]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Вам доступно')]"));
        isElementDisplayed(By.xpath("//button[text()='Смотреть']"));
        isElementDisplayed(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkElementsPopUpPromoCode() {
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
        isElementDisplayed(By.className("_1uIaIlXYEWVJVnh2J-OqTc"));
        isElementDisplayed(By.xpath("//input[@placeholder='Промокод']"));
        //кнопка 'активировать' задизейблена:
        isElementDisplayed(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _3F3oxTbj4-jqVDNzy0QEFS') and text()='Активировать']"));
        String colorButton = webDriver.findElement(By.cssSelector("._3F3oxTbj4-jqVDNzy0QEFS")).getCssValue("background-color");
        System.out.println(colorButton);
        Assert.assertEquals("Не серый цвет кнопки 'Активировать'", "rgba(204, 204, 204, 1)", colorButton);
    }

    public void inputInvalidPromoCode(String anycode) {
        WebElement element = webDriver.findElement(By.xpath("//input[@placeholder='Промокод']"));
        element.clear();
        element.sendKeys(anycode);

    }

    public void checkActiveButtonActivatePromoCode() {
        isElementDisplayed(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma') and text()='Активировать']"));
        String colorButton = webDriver.findElement(By.cssSelector("._1FfeR84AXAbi63sErW3rma")).getCssValue("background-color");
        System.out.println(colorButton);
        Assert.assertEquals("Не зелёный цвет кнопки 'Активировать'", "rgba(0, 185, 86, 1)", colorButton);

    }

    public void clickToButtonActivatePromoCode() throws InterruptedException {
        click(By.xpath("//button[text()='Активировать']"));
    }

    public void checkErrorMessage3() {
        isElementDisplayed(By.xpath("//div[text()='Неверный промокод. Пожалуйста, проверьте правильность введенного промокода.']"));
        String errorMessage1 = webDriver.findElement(By.cssSelector("._335HUB331-UCZHFsv1zJ5I")).getCssValue("color");
        System.out.println(errorMessage1);
        Assert.assertEquals("Сообщение об ошибке не красного цвета", "rgba(255, 51, 51, 1)", errorMessage1);
        String borderInput = webDriver.findElement(By.cssSelector(".kRGHaNYHoMa7dRsR-LJtP")).getCssValue("border-color");
        System.out.println(borderInput);
        Assert.assertEquals("Не красный цвет рамки поля ввода", "rgb(255, 51, 51)", borderInput);
    }

    public void inputValidPromoCode(String validCod) {
        WebElement element = webDriver.findElement(By.xpath("//input[@placeholder='Промокод']"));
        element.clear();
        element.sendKeys(validCod);
    }

    public void checkOpenPopUpBeforeActivation() {
        waitVisibility(By.xpath("//h3[contains(text(),' бесплатно по промокоду')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),' бесплатно по промокоду')]"));
    }

    public void checkElementsPopUpBeforeActivationPackageStartSoftTnB() {
        isElementDisplayed(By.xpath("//h3[text()='«START» бесплатно по промокоду!']"));
        isElementDisplayed(By.xpath("//div//*[@class='_38mZjUWD1k5VLnjhj0vj8T']"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Бесплатный доступ к пакету «START» по промокоду предоставляется до')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'По окончании срока бесплатного доступа пакет будет отключен автоматически.')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Сервис предоставляется ООО «Старт.ру».')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Подтверждая подписку, вы принимаете условия оферты ООО «Старт.ру»:')]"));
        isElementDisplayed(By.xpath("//a[@href='https://start.ru/termsofuse']"));
        isElementDisplayed(By.xpath("//button[text()='Активировать']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));

    }

    public void checkOpenPopUpAfterActivation() {
        isElementDisplayed(By.xpath("//h3[text()='Промокод активирован!']"));
    }

    public void checkElementsPopUpAfterActivationPackageStartSoftTnB() {
        isElementDisplayed(By.xpath("//h3[text()='Промокод активирован!']"));
        isElementDisplayed(By.className("_2VizWvlDNzA0Ud_F09jJco"));
        isElementDisplayed(By.className("wEpDEZzWIj5YGechGyzkl"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступно:']"));
        isElementDisplayed(By.xpath("//span[text()='\"START\"']"));
        isElementDisplayed(By.xpath("//span[text()='текст для описания']"));
        isElementDisplayed(By.linkText("Подробнее"));
    }

    public void clickToButtonCancel() throws InterruptedException {
        click(By.xpath("//button[text()='Отменить']"));
    }

    public void checkClosePopUpBeforeActivationPackageStartSoftTnB() {
        Assert.assertEquals("Не закрылся попап 'до активации'", 0, webDriver.findElements(By.xpath("//h3[text()='«START» бесплатно по промокоду!']")).size());
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
    }

    public void clickToButtonMoreDetailedAndCheckOpenCardPackageStart() throws InterruptedException {
        String name = webDriver.findElement(By.className("uCaVLp73F3t8zT0sYCoBh")).getText();
        String namePackage = name.replace("\"", "");
        System.out.println(namePackage);
        click(By.linkText("Подробнее"));
        isElementDisplayed(By.xpath("//a[@href='/packages']//span[1]"));
        Assert.assertEquals("Не тот пакет", namePackage, webDriver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText());
    }

    public void checkElementsPopUpBeforeActivationPackageMoreTvHardTnB() {
        isElementDisplayed(By.xpath("//h3[text()='«morе.tv» бесплатно по промокоду!']"));
        isElementDisplayed(By.xpath("//div//*[@class='_38mZjUWD1k5VLnjhj0vj8T']"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Бесплатный доступ к пакету по промокоду предоставляется по 30.09.2021.')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Начиная с 01.10.2021 стоимость пакета составит')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Сервис предоставляется ООО «M3».')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Подтверждая подписку, вы принимаете условия оферты ООО «M3»:')]"));
        isElementDisplayed(By.xpath("//a[@href='https://more.tv/useragreement']"));
        isElementDisplayed(By.xpath("//button[text()='Активировать']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));
    }

    public void checkElementsPopUpAfterActivationPackageMoreTvHardTnB() {
        isElementDisplayed(By.xpath("//h3[text()='Промокод активирован!']"));
        isElementDisplayed(By.className("_2VizWvlDNzA0Ud_F09jJco"));
        isElementDisplayed(By.className("wEpDEZzWIj5YGechGyzkl"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступно:']"));
        isElementDisplayed(By.xpath("//span[text()='\"morе.tv\"']"));
        isElementDisplayed(By.xpath("//span[text()='текст для описания']"));
        isElementDisplayed(By.linkText("Подробнее"));
    }

    public void clickToButtonCloseInPopUpAfterActivation() throws InterruptedException {
        click(By.className("_2VizWvlDNzA0Ud_F09jJco"));
    }

    public void checkClosePopUpAfterActivation() {
        Assert.assertEquals("Не закрылся попап 'после активации'", 0, webDriver.findElements(By.xpath("//h3[text()='Промокод активирован!']")).size());
    }

    public void checkElementsPopUpBeforeActivationFilmOnRent() {
        isElementDisplayed(By.xpath("//h3[text()='Фильм «Довод» бесплатно по промокоду']"));
        isElementDisplayed(By.xpath("//div//*[@class='_38mZjUWD1k5VLnjhj0vj8T']"));
        isElementDisplayed(By.xpath("//span[text()='Смотри бесплатно до 01.11.2021.']"));
        isElementDisplayed(By.xpath("//button[text()='Активировать']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));
    }

    public void checkElementsPopUpAfterActivationFilmOnRent() {
        isElementDisplayed(By.xpath("//h3[text()='Промокод активирован!']"));
        isElementDisplayed(By.className("_3E3Ou4BLw1i_TQHV34ofs6"));
        isElementDisplayed(By.className("_2o8kH-If8mc-reHlaOHfFH"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступно:']"));
        isElementDisplayed(By.xpath("//span[text()='\"Довод\"']"));
        isElementDisplayed(By.xpath("//span[text()='текст для описания']"));
        isElementDisplayed(By.linkText("Подробнее"));
    }

    public void clickToButtonMoreDetailedAndCheckOpenCardFilmOnRent() throws InterruptedException {
        String name = webDriver.findElement(By.className("_1Euevex6MnqG-kMnzDFzTx")).getText();
        String namePackage = name.replace("\"", "");
        System.out.println(namePackage);
        click(By.linkText("Подробнее"));
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Смотреть до')]"));
        Assert.assertEquals("Не тот фильм", namePackage, webDriver.findElement(By.tagName("h1")).getText());
    }

    public void checkElementsPopUpBeforeActivationFilmOnEST() {
        isElementDisplayed(By.xpath("//h3[text()='Фильм «Довод» бесплатно по промокоду']"));
        isElementDisplayed(By.xpath("//div//*[@class='_38mZjUWD1k5VLnjhj0vj8T']"));
        isElementDisplayed(By.xpath("//span[text()='Смотри бесплатно.']"));
        isElementDisplayed(By.xpath("//button[text()='Активировать']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));
    }

    public void checkElementsPopUpAfterActivationFilmOnEST() {
        isElementDisplayed(By.xpath("//h3[text()='Промокод активирован!']"));
        isElementDisplayed(By.className("_3E3Ou4BLw1i_TQHV34ofs6"));
        isElementDisplayed(By.className("_2o8kH-If8mc-reHlaOHfFH"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступно:']"));
        isElementDisplayed(By.xpath("//span[text()='\"Довод\"']"));
        isElementDisplayed(By.xpath("//span[text()='текст для описания']"));
        isElementDisplayed(By.linkText("Подробнее"));
    }

    public void clickToButtonMoreDetailedAndCheckOpenCardFilmOnEST() throws InterruptedException {
        String name = webDriver.findElement(By.className("_1Euevex6MnqG-kMnzDFzTx")).getText();
        String namePackage = name.replace("\"", "");
        System.out.println(namePackage);
        click(By.linkText("Подробнее"));
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
        Assert.assertEquals("Не тот фильм", namePackage, webDriver.findElement(By.tagName("h1")).getText());
    }

    public void goToBack() {
        webDriver.navigate().back();
    }

    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    public void deleteCookies() {
        webDriver.manage().deleteAllCookies();
    }

    public void waitElement3seconds() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void checkElementsFilmsPage() {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq']"));
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
        isElementDisplayed(By.xpath("//div[@class='_10lCh4uWCss6HRDZrOjSEk']"));
        isElementDisplayed(By.xpath("//div[@class='_3SqVO95D45Gj6EpowjScAG']"));
    }

    public void goToManageSubscriptions() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Управление пакетами и сервисами'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Управление пакетами и сервисами'])[3]"));
    }

    public void goToPromoPage() {
        webDriver.get(Promo_Page_PP3);
    }

    public void inputPassword(String password) {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
        WebElement element1 = webDriver.findElement(By.xpath("//input[@type='password']"));
        element1.sendKeys(password);

    }

    public void scrollDownPage() {
        JavascriptExecutor jsDown = (JavascriptExecutor) webDriver;
        jsDown.executeScript("window.scrollTo(0, 1500);");
    }

    public void closePopUpNotif() throws InterruptedException {
        webDriver.navigate().refresh();
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
    }

    public void waitElement60seconds() throws InterruptedException {
        Thread.sleep(60000);
    }
}
