package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

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
        driver.get(NIL_Page_PP1);
    }

    public void goToTvPage() {
        driver.get(TV_Page_PP1);
    }


    public void goToFilmsPage() {driver.get(Films_Page_PP1);
    isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
    }

    public void goToSerialsPage() {
        driver.get(Serials_Page_PP1);
        isElementDisplayed(By.xpath("//h1[text()='Сериалы']"));
    }

    public void goToKidsPage() {
        driver.get(Kids_Page_PP1);
        isElementDisplayed(By.xpath("//span[text()='Детям']"));
    }
    public void goToSportPage() {
        driver.get(Sport_Page_PP1);
        isElementDisplayed(By.xpath("//h1[text()='Спорт']"));
    }
        public void goToPackagesPage() {
        driver.get(Packages_Page_PP1);
        isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
        }
        public void goToAllCollectionsPage() {
        driver.get(Collections_Page_PP1);
        isElementDisplayed(By.xpath("//span[text()='Подборки']"));
        isElementDisplayed(By.xpath("//button[contains(text(), 'Следующая')]"));
    }

    public void checkOpenFrameCreatePassword(String login, String password) {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']"));
        if (driver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
            ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod1.megafon.tv/cms/households?role=user')");
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

        public void checkOpenFrameCreatePasswordForMf(String login, String password){
            isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']"));
            if (driver.findElements(By.xpath("//div[text()='Введите пароль']")).size() != 0) {
                ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod1.megafon.tv/cms/households?role=user')");
                ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
                driver.switchTo().window((String) tabs2.get(1));
                click(By.xpath("//form[@method='GET']//input[1]"));
                writeText(By.xpath("//form[@method='GET']//input[1]"), "79267644248");
                click(By.xpath("//button[text()='Поиск']"));
                isElementDisplayed(By.xpath("//td[text()='79267644248']"));
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
            }
            else {
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
        Assert.assertEquals("Нет текста 'Неверный код'","Неверный код1", driver.findElement(By.xpath("//div[text()='Неверный код']")).getText());
        click(By.className("_1bciqjt58pgm0il2tiJTtp"));

    }

    public void connectSmartTv() {
        ((JavascriptExecutor) driver).executeScript("window.open('http://staging-smart-nettv.megafon.tv/#scene/start')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//div[@data-type='preprod1']"));
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

    public void checkLoginUserIsCorrect() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        driver.navigate().refresh();
        if (driver.findElements(By.xpath("//h3[contains(text(), 'Хочешь')]")).size()!=0)
        {
            //isElementDisplayed(By.xpath("//h3[contains(text(), 'Хочешь')]"));
            click(By.xpath("//button[text()='Нет']"));
            driver.navigate().refresh();
        }

        isElementDisplayed(By.xpath("//h3[contains(text(), 'Вам доступно')]|//div[text()='Акция недоступна']"));
        click(By.xpath("//button[text()='Закрыть']"));

    }

    public void checkLoginUserIsCorrectForBlockingMf() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
        driver.navigate().refresh();
        if (driver.findElements(By.xpath("//h3[contains(text(), 'Хочешь')]")).size()!=0)
        {
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

    public void clickToTabPackages() {
        click(By.xpath("(//div[text()='Пакеты'])[1]"));
    }

    public void clickToSearchButton(){click(By.xpath("(//div[@class='ch-trigger__container'])[1]"));}

    public void checkOpenFieldSearch(){isElementDisplayed(By.xpath("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]"));}

    public void inputInvalidRequestSearch(){writeText(By.xpath("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]")," ,#");}

    public void checkResponseOnInvalidSearch(){
        isElementDisplayed(By.xpath("//div[text()='Ничего не найдено']"));
    }

    public void inputValidRequestSearch() {writeText(By.xpath("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]"),"мир");
        }
    public void checkResponseOnValidSearch(){
        isElementDisplayed(By.xpath("(//div[text()='Фильмы'])[2]"));
        isElementDisplayed(By.xpath("(//div[text()='Сериалы'])[2]"));
        isElementDisplayed(By.xpath("//div[text()='ТВ-каналы']"));
        isElementDisplayed(By.xpath("//div[text()='ТВ-передачи']"));
        isElementDisplayed(By.linkText("Все результаты"));
    }

    public void clickToLinkShowAll() {
        click(By.linkText("Все результаты"));
    }

    public void clickToLinkAll() {click(By.partialLinkText("Все"));
    }

    public void checkOpenPopUpInputPhone() {
        isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
    }

    public void checkOpenPopUpPromoCod() {
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
        Assert.assertEquals("Нет заголовока 'Способы оплаты'","Способы оплаты", driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals("Нет текста 'Счет основного номера телефона'","Счет основного номера телефона",driver.findElement(By.xpath("//div[text()='Счет основного номера телефона']")).getText());
        Assert.assertEquals("Нет текста '+7 926 019 21 44'","+7 926 019 21 44", driver.findElement(By.xpath("//span[text()='+7 926 019 21 44']")).getText());
    }




    public void checkOpenFrameInputPhone() {
        isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
    }

    public void inputLogin(String login) {
        WebElement element = driver.findElement(By.xpath("//input[@value='+7 ']"));
        element.sendKeys(login);
    }

    public void clickToNext(String button) {
        click(By.xpath("//button[text()='Далее']"));
    }

    public void checkOpenFrameInputPassword() {
        isElementDisplayed(By.xpath("//div[text()='Введите пароль']"));
    }

    public void inputPassword(String password) {
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(password);
    }

    public void clickToComeIn(String button) {
        click(By.xpath("//button[text()='Войти']"));
    }

    public void inputEmail() {
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Email'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Email']"));
        Assert.assertEquals("Отмечен чек-бокс",0, driver.findElements(By.xpath("//div[@class='_1EDH3fad4oU0crhGTzvo74 _1ZpTJSYmF419gKUU8fRgU9']")).size());
        Assert.assertEquals("Кнопка 'Сохранить' не дизейбл",1, driver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        writeText(By.xpath("//input[@type='email']"), "email@invalid");
        Assert.assertEquals("Кнопка 'Сохранить' не дизейбл",1, driver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        writeText(By.xpath("//input[@type='email']"), "ispolnitel1mt@ya.ru");
        Assert.assertEquals("Кнопка 'Сохранить' не активна",0, driver.findElements(By.xpath("//div[@role='dialog']//button[@type='button' and @disabled]")).size());
        click(By.xpath("//div[@role='presentation']//div[1]"));
        Assert.assertEquals("Не отмечен чек-бокс",1, driver.findElements(By.xpath("//div[@class='_1EDH3fad4oU0crhGTzvo74 _1ZpTJSYmF419gKUU8fRgU9']")).size());
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



    public void checkOpenFrameInputCod() {
        isElementDisplayed(By.xpath("//div[text()='Введите код']"));
    }

    public void clickToButtonForgetPassword() {click(By.xpath("//button[text()='Я не помню пароль']"));
    }

    public void checkLoginUserIsCorrectAfterForgetPassword() {
        isElementDisplayed(By.xpath("(//span[contains(text(),'+792')])[2]"));
    }


    public void closePopUpNotDefinedTariff() {
        driver.navigate().refresh();
        isElementDisplayed(By.xpath("//div[text()='Акция недоступна']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }
}


