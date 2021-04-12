package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HeaderMenu extends BasePage {
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

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void goToNilPage() {
        driver.get(NIL_Page_PP2);
    }

    public void goToTvPage() {
        driver.get(TV_Page_PP2);
    }


    public void goToFilmsPage() {
        driver.get(Films_Page_PP2);
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
    }

    public void goToSerialsPage() {
        driver.get(Serials_Page_PP2);
        isElementDisplayed(By.xpath("//h1[text()='Сериалы']"));
    }

    public void goToKidsPage() {
        driver.get(Kids_Page_PP2);
        isElementDisplayed(By.xpath("//span[text()='Детям']"));
    }

    public void goToSportPage() {
        driver.get(Sport_Page_PP2);
        isElementDisplayed(By.xpath("//h1[text()='Спорт']"));
    }

    public void goToPackagesPage() {
        driver.get(Packages_Page_PP2);
        isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
    }

    public void goToAllCollectionsPage() {
        driver.get(Collections_Page_PP2);
        isElementDisplayed(By.xpath("//span[text()='Подборки']"));
        isElementDisplayed(By.xpath("//button[contains(text(), 'Следующая')]"));
    }

    public void checkOpenPopUpCreatePasswordForFlowRegistrationMF(String login, String password) {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']"));
        if (driver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod2.megafon.tv/cms/households?role=user')");
            ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window((String) tabs2.get(1));
            click(By.xpath("//form[@method='GET']//input[1]"));
            writeText(By.xpath("//form[@method='GET']//input[1]"), "79260192144");
            click(By.xpath("//button[text()='Поиск']"));
            isElementDisplayed(By.xpath("//td[text()='79260192144']"));
            click(By.xpath("//a[contains(@href, '/cms/households/')]"));
            isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
            click(By.xpath("//button[text()='Удалить']"));
            driver.close();
            driver.switchTo().window((String) tabs2.get(0));
            driver.navigate().refresh();
            isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
            click(By.xpath("(//span[text()='Вход'])[1]"));
            isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
            WebElement element = driver.findElement(By.xpath("//input[@value='+7 ']"));
            element.sendKeys(login);
            click(By.xpath("//button[text()='Далее']"));
            isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
            WebElement element1 = driver.findElement(By.xpath("//input[@type='password']"));
            element1.sendKeys(password);
        } else {
            WebElement element1 = driver.findElement(By.xpath("//input[@type='password']"));
            element1.sendKeys(password);
        }
    }

    public void noConnectSmartTv() {
        String invalidСodSmartTv = "12345";
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Подключить SmartTV'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Подключение Smart TV']"));
        driver.findElement(By.xpath("//input[@placeholder='Код подтверждения']")).sendKeys(invalidСodSmartTv);
        click(By.xpath("//button[text()='Подключить Smart TV']"));
        Assert.assertEquals("Нет текста 'Неверный код'", "Неверный код1", driver.findElement(By.xpath("//div[text()='Неверный код']")).getText());
        click(By.className("_1bciqjt58pgm0il2tiJTtp"));

    }

    public void connectSmartTv() {
        ((JavascriptExecutor) driver).executeScript("window.open('http://staging-smart-nettv.megafon.tv/#scene/start')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//div[@data-type='preprod2']"));
        click(By.xpath("(//div[@data-action='back']//div)[1]"));
        waitVisibility(By.xpath("(//div[@data-action='tile'])[1]"));
        isElementDisplayed(By.xpath("//div[@data-action='openMainMenu']"));
        click(By.cssSelector("div#side-menu>div>div"));
        click(By.xpath("//div[@data-action='down']"));
        click(By.xpath("//div[@data-action='down']"));
        click(By.xpath("//div[@data-action='down']"));
        click(By.xpath("//div[@data-action='down']"));
        click(By.xpath("//div[text()[normalize-space()='Вход']]"));
        String codSmartTv = driver.findElement(By.xpath("//div[@class='enter-msisdn-pair__code js-code']")).getText();
        //здесь переключаемся опять на вкладку с мегафонТВ, закрываем вкладку CMS и далее вставляем взятый код из CMS в открытый попап в поле подтверждения регистрации
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
        //перезалогиниться тем же юзером
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Выйти'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
        click(By.xpath("(//span[text()='Вход'])[1]"));
        WebElement element = driver.findElement(By.xpath("//input[@value='+7 ']"));
        element.sendKeys("9260192144");
        click(By.xpath("//button[text()='Далее']"));
        WebElement element2 = driver.findElement(By.xpath("//input[@type='password']"));
        element2.sendKeys("111111");
        click(By.xpath("//button[text()='Войти']"));
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Вам доступно')]"));
        click(By.xpath("//button[text()='Закрыть']"));
        //подключить смарт тв
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Подключить SmartTV'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Подключение Smart TV']"));
        writeText(By.xpath("//input[@placeholder='Код подтверждения']"), codSmartTv);
        //driver.findElement(By.xpath("//input[@placeholder='Код подтверждения']")).sendKeys(codSmartTv);
        click(By.xpath("//button[text()='Подключить Smart TV']"));
        isElementDisplayed(By.xpath("//div[text()='SmartTV подключен!']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public HeaderMenu checkNotLoggedIsCorrect() {
        isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
        return this;
    }

    public HeaderMenu clickToEnter(String buttonEnter) {

        click(By.xpath("(//span[text()='Вход'])[1]"));
        return this;
    }

    public void checkLoginUserIsCorrectFlow() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        driver.navigate().refresh();
        if (driver.findElements(By.xpath("//h3[contains(text(), 'Хочешь')]")).size() != 0) {
            click(By.xpath("//button[text()='Нет']"));
            driver.navigate().refresh();
        }
        if (driver.findElements(By.xpath("//h3[text()='Специальное предложение для Вас!']|//h3[text()='Специально для Вас!']|//h3[contains(text(),'Вам доступно')]|//div[text()='Акция недоступна']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
            driver.navigate().refresh();
        }
        if (driver.findElements(By.xpath("//h3[text()='Специальное предложение для Вас!']|//h3[text()='Специально для Вас!']|//h3[contains(text(),'Вам доступно')]|//div[text()='Акция недоступна']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
            driver.navigate().refresh();
        }
        driver.navigate().refresh();
    }

    public void checkLoginUserIsCorrectForBlockingMf() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        driver.navigate().refresh();
        if (driver.findElements(By.xpath("//h3[contains(text(), 'Хочешь')]")).size() != 0) {
            //isElementDisplayed(By.xpath("//h3[contains(text(), 'Хочешь')]"));
            click(By.xpath("//button[text()='Нет']"));
            driver.navigate().refresh();
        }

        driver.navigate().refresh();
    }


    public void clickToButtonPromo() {
        click(By.xpath("(//div[@class='ch-trigger__container'])[2]"));
    }

    public void clickToTabFilms() {
        click(By.xpath("(//div[text()='Фильмы'])[1]"));
    }

    public void clickToTabSerials() {
        click(By.xpath("(//div[text()='Сериалы'])[1]"));
    }

    public void clickToTabShop() {
        click(By.xpath("(//div[text()='Магазин'])[1]"));
    }

    public void clickToSearchButton() {
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

    public void clickToLinkShowAll() {
        click(By.linkText("Все результаты"));
    }

    public void clickToLinkAll() {
        click(By.partialLinkText("Все"));
    }

    public void checkOpenPopUpPromoCode() {
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
    }

    public void checkPopUpPromotionNotAvailable() {
        isElementDisplayed(By.xpath("//div[text()='Акция недоступна']"));
        click(By.xpath("//button[text()='Закрыть']"));

    }

    public void clickToPhoneNumber() {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
    }

    public void openSubsectionPromo() throws InterruptedException {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Акции'])[1]"));
        Thread.sleep(3000);

    }

    public void checkLoginUserIsCorrectForNotMegafon() {
        isElementDisplayed(By.xpath("(//span[text()='+79261184972'])[2]"));
    }

    public void openSubsectionPaymentMethod() {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Способы оплаты'])[1]"));
        Assert.assertEquals("Нет заголовока 'Способы оплаты'", "Способы оплаты", driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals("Нет текста 'Счет основного номера телефона'", "Счет основного номера телефона", driver.findElement(By.xpath("//div[text()='Счет основного номера телефона']")).getText());
        Assert.assertEquals("Нет текста '+7 926 019 21 44'", "+7 926 019 21 44", driver.findElement(By.xpath("//span[text()='+7 926 019 21 44']")).getText());
    }


    public void checkOpenPopUpInputPhone() {
        isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
    }

    public void checkElementsPopUpInputPhone() {
        isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Чтобы смотреть ТВ-каналы,сериалы и фильмы')]"));
        isElementDisplayed(By.xpath("//input[@placeholder='Номер телефона']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Далее']"));
    }

    public void inputLogin(String login) {
        WebElement element = driver.findElement(By.xpath("//input[@value='+7 ']"));
        element.sendKeys(login);

    }

    public void checkActiveButtonNext() {
        Assert.assertEquals("Кнопка 'Далее' НЕ активна", 1, driver.findElements(By.xpath("//button[text()='Далее']")).size());
        Assert.assertEquals("Кнопка 'Далее' НЕ активна", 0, driver.findElements(By.xpath("//button[@disabled and text()='Далее']")).size());
    }

    public void clickToNext(String button) {
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
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(Keys.CONTROL,"a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(password);
    }

    public void inputLessThanSixSimbolPassword(String lessthansix) {
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(lessthansix);
    }

    public void checkDisabledButtonComeIn() {
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
    }

    public void clickToLinkOffer() {
        click(By.xpath("//a[@href='//www.megafon.ru/ad/offer_mediaportal']"));
    }

    public void checkOpenPageOffer() throws InterruptedException {
        String url1 = "https://moscow.megafon.ru/download/~federal/oferts/mediaportal_oferta.pdf";
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

    public void checkActiveButtonComeIn() {
        Assert.assertEquals("Кнопка 'Войти' НЕ активна", 1, driver.findElements(By.xpath("//button[text()='Войти']")).size());
        Assert.assertEquals("Кнопка 'Войти' НЕ активна", 0, driver.findElements(By.xpath("//button[@disabled and text()='Войти']")).size());
    }

    public void clickToComeIn(String button) {
        click(By.xpath("//button[text()='Войти']"));
    }

    public void inputEmail() {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Email'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Email']"));
        Assert.assertEquals("Отмечен чек-бокс", 0, driver.findElements(By.xpath("//div[@class='_1EDH3fad4oU0crhGTzvo74 _1ZpTJSYmF419gKUU8fRgU9']")).size());
        Assert.assertEquals("Кнопка 'Сохранить' не дизейбл", 1, driver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        writeText(By.xpath("//input[@type='email']"), "email@invalid");
        Assert.assertEquals("Кнопка 'Сохранить' не дизейбл", 1, driver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        writeText(By.xpath("//input[@type='email']"), "ispolnitel1mt@ya.ru");
        Assert.assertEquals("Кнопка 'Сохранить' не активна", 0, driver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        click(By.xpath("//div[@role='presentation']//div[1]"));
        Assert.assertEquals("Не отмечен чек-бокс", 1, driver.findElements(By.xpath("//div[@class='_1EDH3fad4oU0crhGTzvo74 _1ZpTJSYmF419gKUU8fRgU9']")).size());
        click(By.xpath("//div[text()='СОХРАНИТЬ']"));
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Email'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Email']"));
        isElementDisplayed(By.xpath("//input[@value='ispolnitel1mt@ya.ru']"));
        click(By.xpath("(//div[@role='dialog']//button)[2]"));
    }

    public void logOut() {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Выйти'])[1]"));
    }


    public void checkOpenPopUpInputCode() {
        isElementDisplayed(By.xpath("//div[text()='Введите код']"));
    }

    public void checkElementsPopUpInputCode() {
        isElementDisplayed(By.xpath("//div[text()='Введите код']"));
        isElementDisplayed(By.xpath("//i[text()='+7 926 019 21 44']"));
        isElementDisplayed(By.xpath("//span[text()='На номер ' and text()=' отправлено sms с кодом подтверждения']"));
        isElementDisplayed(By.xpath("//input[@placeholder='Код подтверждения']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Получить новый код']"));
    }

    public void inputInvalidCodeСonfirmation(String code) {
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Код подтверждения']"));
        element.click();
        element.clear();
        element.sendKeys(code);
        click(By.xpath("//button[text()='Войти']"));
    }

    public void checkErrorMessage1() {
        isElementDisplayed(By.xpath("//div[text()='Неверный код']"));
        String errorMessage1 = driver.findElement(By.cssSelector("div[data-test='CodeError']")).getCssValue("color");
        System.out.println(errorMessage1);
        Assert.assertEquals("Сообщение об ошибке не красного цвета", "rgba(255, 51, 51, 1)", errorMessage1);
        String borderInput = driver.findElement(By.cssSelector("input[name='code-confirm']")).getCssValue("border-color");
        System.out.println(borderInput);
        Assert.assertEquals("Не красный цвет рамки поля ввода", "rgb(255, 51, 51)", borderInput);
    }

    public void checkErrorMessage2() {
        isElementDisplayed(By.xpath("//div[text()='Неверный пароль']"));
        String errorMessage2 = driver.findElement(By.cssSelector("div._3IFyMnnL8xI6B0oOiNOlSp")).getCssValue("color");
        System.out.println(errorMessage2);
        Assert.assertEquals("Сообщение об ошибке не красного цвета", "rgba(255, 51, 51, 1)", errorMessage2);
        String borderInput = driver.findElement(By.cssSelector("input[type='password']")).getCssValue("border-color");
        System.out.println(borderInput);
        Assert.assertEquals("Не красный цвет рамки поля ввода", "rgb(255, 51, 51)", borderInput);
    }

    public void inputInvalidCodeMoreThanThreeTimes() {
        for (int i = 0; i <= 3; i++) {
            click(By.xpath("//button[text()='Войти']"));
        }
    }

    public void checkElementsPopUpForInvalidCodeMoreThanThreeTimes() {
        isElementDisplayed(By.xpath("//div[text()='Код более не действителен']"));
        isElementDisplayed(By.xpath("//input[@placeholder='Код подтверждения' and @disabled]"));
        isElementDisplayed(By.xpath("//button[@disabled and text()='Войти']"));
        isElementDisplayed(By.xpath("//button[text()='Получить новый код']"));
        Assert.assertEquals("Кнопка 'Получить новый код' НЕ активна", 0, driver.findElements(By.xpath("//button[@disabled and text()='Получить новый код']")).size());
    }

    public void clickToButtonGetNewCode() {
        click(By.xpath("//button[text()='Получить новый код']"));
        waitVisibility(By.xpath("//button[text()='Получить новый код']"));
        click(By.xpath("//button[text()='Получить новый код']"));

    }

    public void clickToButtonForgetPassword() {
        click(By.xpath("//button[text()='Я не помню пароль']"));
    }

    public void checkLoginUserIsCorrectAfterForgetPassword() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
    }

    public void closePopUpNotDefinedTariff() {
        driver.navigate().refresh();
        isElementDisplayed(By.xpath("//div[text()='Акция недоступна']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkOpenPopUpCreatePasswordForCaseRegistrationMF(String login) {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']"));
        if (driver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod2.megafon.tv/cms/households?role=user')");
            ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window((String) tabs2.get(1));
            click(By.xpath("//form[@method='GET']//input[1]"));
            writeText(By.xpath("//form[@method='GET']//input[1]"), "79260192144");
            click(By.xpath("//button[text()='Поиск']"));
            isElementDisplayed(By.xpath("//td[text()='79260192144']"));
            click(By.xpath("//a[contains(@href, '/cms/households/')]"));
            isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
            click(By.xpath("//button[text()='Удалить']"));
            driver.close();
            driver.switchTo().window((String) tabs2.get(0));
            driver.navigate().refresh();
            isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
            click(By.xpath("(//span[text()='Вход'])[1]"));
            isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
            WebElement element = driver.findElement(By.xpath("//input[@value='+7 ']"));
            element.sendKeys(login);
            click(By.xpath("//button[text()='Далее']"));
            isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
        }
    }

    public void checkOpenPopUpInputEmail(String login) {
        isElementDisplayed(By.xpath("//div[text()='Введите E-mail']|//div[text()='Введите пароль']"));
        if (driver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod2.megafon.tv/cms/households?role=user')");
            ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window((String) tabs2.get(1));
            click(By.xpath("//form[@method='GET']//input[1]"));
            writeText(By.xpath("//form[@method='GET']//input[1]"), "79261184972");
            click(By.xpath("//button[text()='Поиск']"));
            isElementDisplayed(By.xpath("//td[text()='79261184972']"));
            click(By.xpath("//a[contains(@href, '/cms/households/')]"));
            isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
            click(By.xpath("//button[text()='Удалить']"));
            driver.close();
            driver.switchTo().window((String) tabs2.get(0));
            driver.navigate().refresh();
            isElementDisplayed(By.xpath("(//span[text()='Вход'])[1]"));
            click(By.xpath("(//span[text()='Вход'])[1]"));
            isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
            WebElement element = driver.findElement(By.xpath("//input[@value='+7 ']"));
            element.sendKeys(login);
            click(By.xpath("//button[text()='Далее']"));
            isElementDisplayed(By.xpath("//div[text()='Введите E-mail']"));
        }
    }

    public void inputValidEmailInPopUpInputEmail(String email) {
        isElementDisplayed(By.xpath("//div[text()='Введите E-mail']"));
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='E-mail']"));
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
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='E-mail']"));
        element.sendKeys(email);
    }

    public void checkDisabledButtonNext() {
        isElementDisplayed(By.xpath("//button[@disabled and text()='Далее']"));
    }

    public void clickToCheckBoxInPopUpEmail() {
        click(By.xpath("//input[@type='checkbox']/following-sibling::div[1]"));
    }

    public void checkOpenPopUpCreatePasswordForNotMF() {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
    }


    public void inputInvalidPassword(String invalidpass) {
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        element.clear();
        element.sendKeys(invalidpass);
    }



    public void closePopUpInputPassword() {
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

    public void clickUncheckCheckBox() {
        click(By.xpath("(//input[@type='checkbox']/following-sibling::div)[1]"));
        Assert.assertEquals("Не отжат чекбокс", 0, driver.findElements(By.xpath("(//input[@type='checkbox']/following-sibling::div/*[@viewBox])[1]")).size());
    }

    public void clickCheckCheckBox() {
        click(By.xpath("(//input[@type='checkbox']/following-sibling::div)[1]"));
        Assert.assertEquals("Не прожат чекбокс", 1, driver.findElements(By.xpath("(//input[@type='checkbox']/following-sibling::div/*[@viewBox])[1]")).size());
    }

    public void checkAbsencePopUpNotifToNilPage() {
        Assert.assertEquals("Отображается ВУ на НиЛ с фильтром раздел Фильмы", 0, driver.findElements(By.xpath("//div[@aria-label='Notification']//h3[text()='автотест ВУ для экрана Фильмы']")).size());
    }


    public void checkLoginUserIsCorrect() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        driver.navigate().refresh();
        if (driver.findElements(By.xpath("//h3[text()='Специальное предложение для Вас!']|//h3[text()='Специально для Вас!']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
            driver.navigate().refresh();
        }
    }

    public void checkElementsPopUpPromoCode() {
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
        isElementDisplayed(By.className("_1uIaIlXYEWVJVnh2J-OqTc"));
        isElementDisplayed(By.xpath("//input[@placeholder='Промокод']"));
        //кнопка 'активировать' задизейблена:
        isElementDisplayed(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _3F3oxTbj4-jqVDNzy0QEFS') and text()='Активировать']"));
        String colorButton = driver.findElement(By.cssSelector("._3F3oxTbj4-jqVDNzy0QEFS")).getCssValue("background-color");
        System.out.println(colorButton);
        Assert.assertEquals("Не серый цвет кнопки 'Активировать'", "rgba(204, 204, 204, 1)", colorButton);
    }

    public void inputInvalidPromoCode(String anycode) {
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Промокод']"));
        element.clear();
        element.sendKeys(anycode);

    }

    public void checkActiveButtonActivatePromoCode() {
        isElementDisplayed(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma') and text()='Активировать']"));
        String colorButton = driver.findElement(By.cssSelector("._1FfeR84AXAbi63sErW3rma")).getCssValue("background-color");
        System.out.println(colorButton);
        Assert.assertEquals("Не зелёный цвет кнопки 'Активировать'", "rgba(0, 185, 86, 1)", colorButton);

    }

    public void clickToButtonActivatePromoCode() {
        click(By.xpath("//button[text()='Активировать']"));
    }

    public void checkErrorMessage3() {
        isElementDisplayed(By.xpath("//div[text()='Неверный промокод. Пожалуйста, проверьте правильность введенного промокода.']"));
        String errorMessage1 = driver.findElement(By.cssSelector("._335HUB331-UCZHFsv1zJ5I")).getCssValue("color");
        System.out.println(errorMessage1);
        Assert.assertEquals("Сообщение об ошибке не красного цвета", "rgba(255, 51, 51, 1)", errorMessage1);
        String borderInput = driver.findElement(By.cssSelector(".kRGHaNYHoMa7dRsR-LJtP")).getCssValue("border-color");
        System.out.println(borderInput);
        Assert.assertEquals("Не красный цвет рамки поля ввода", "rgb(255, 51, 51)", borderInput);
    }

    public void inputValidPromoCode(String validCod) {
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Промокод']"));
        element.clear();
        element.sendKeys(validCod);
    }

    public void checkOpenPopUpBeforeActivation() {
        isElementDisplayed(By.xpath("//h3[contains(text(),' бесплатно по промокоду!')]"));
    }

    public void checkElementsPopUpBeforeActivationPackageStartSoftTnB() {
        isElementDisplayed(By.xpath("//h3[text()='«START» бесплатно по промокоду!']"));
        isElementDisplayed(By.xpath("//div//*[@class='_38mZjUWD1k5VLnjhj0vj8T']"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Бесплатный доступ к пакету «START» по промокоду предоставляется до 01.10.2021.')]"));
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

    public void clickToButtonCancel() {
        click(By.xpath("//button[text()='Отменить']"));
    }

    public void checkClosePopUpBeforeActivationPackageStartSoftTnB() {
        Assert.assertEquals("Не закрылся попап 'до активации'",0,driver.findElements(By.xpath("//h3[text()='«START» бесплатно по промокоду!']")).size());
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
    }

    public void clickToButtonMoreDetailedAndCheckOpenPackageStart() {
        String name = driver.findElement(By.className("uCaVLp73F3t8zT0sYCoBh")).getText();
        String namePackage = name.replace("\"", "");
        System.out.println(namePackage);
        click(By.linkText("Подробнее"));
        isElementDisplayed(By.xpath("//a[@href='/packages']//span[1]"));
        Assert.assertEquals("Не тот пакет", namePackage, driver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText());
    }
}


