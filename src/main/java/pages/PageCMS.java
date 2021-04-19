package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class PageCMS extends BasePage {
    //ПП1
    String CMS_PP1_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod1.megafon.tv/cms/msisdn_confirmations";
    String CMS_PP1_URL2 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod1.megafon.tv/cms/households?role=user";
    String CMS_PP1_URL3 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod1.megafon.tv/cms/discounts";
    //ПП2
    String CMS_PP2_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod2.megafon.tv/cms/msisdn_confirmations";
    String CMS_PP2_URL2 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod2.megafon.tv/cms/households?role=user";
    String CMS_PP2_URL3 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod2.megafon.tv/cms/discounts";

    //ПП5
    String CMS_PP5_URL1 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/msisdn_confirmations";
    String CMS_PP5_URL2 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user";
    String CMS_PP5_URL3 = "https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/discounts";
    public PageCMS(WebDriver driver) {
        super(driver);
    }

    public void copyPasteCodMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/msisdn_confirmations')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        String codMsisdn = driver.findElement(By.xpath("(//td[text()='79260192144']/following-sibling::td)[4]|(//td[text()='79260172279']/following-sibling::td)[4]|(//td[text()='79260205027']/following-sibling::td)[4]")).getText();
        //здесь переключаемся опять на вкладку с мегафонТВ, закрываем вкладку CMS и далее вставляем взятый код из CMS в открытый попап в поле подтверждения регистрации
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
        driver.findElement(By.xpath("//input[@placeholder='Код подтверждения']")).sendKeys(codMsisdn); }

    public void chooseBundleInternetMFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Интернет M']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Интернет M"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseBundleBezPereplatMaxFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Без переплат. Максимум']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Без переплат. Максимум"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseBundleBezPereplatVseFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Без переплат. Всё']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Без переплат. Всё"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseBundleBezPereplatInternetFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Без переплат. Интернет']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Без переплат. Интернет"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseBundleBezPereplatZvonkiFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Без переплат. Звонки']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Без переплат. Звонки"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseBundlePremiumFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Премиум']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Премиум"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }
    public void chooseBundleCorpBezlimitFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Корпоративный безлимит']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Корпоративный безлимит"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void deleteAccountMF(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Удалить']"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void deleteAccountNonMF(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79261184972']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Удалить']"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void deleteAccountForBlockingMf(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79267644248']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Удалить']"));
    }

    public void createPriseEstOrRent2WithDiscount() {
        String nameFilm = driver.findElement(By.tagName("h1")).getText();
        System.out.println(nameFilm);
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/discounts')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//h3[text()='Скидки']"));
        //click(By.xpath("//input[@type='checkbox']"));
        click(By.linkText("Скидка автотест"));
        isElementDisplayed(By.xpath("//h4[text()='Пакеты']"));
        isElementDisplayed(By.cssSelector(".selectize-input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='selectize-control form-control single']"))).build().perform();
        //WebElement enterFilm = driver.findElement(By.xpath("//div[@class='selectize-control form-control single']"));
        //WebElement enterFilm = driver.findElement(By.xpath("//div[@class='selectize-input items required invalid not-full']"));
        //WebElement enterFilm = driver.findElement(By.xpath("//div[contains(@class,'selectize-input items')]"));
        WebElement enterFilm = driver.findElement(By.xpath("//input[@type='select-one']"));
        //click(By.xpath("//div[contains(@class,'selectize-input items')]"));
        //click(By.xpath("//div[@class='selectize-input items required invalid not-full']"));
        //driver.findElement(By.cssSelector(".selectize-input")).click();
        enterFilm.sendKeys(nameFilm);
        click(By.xpath("//div[@class='selectize-dropdown-content']"));
        click(By.xpath("//input[@value='Добавить']"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void deleteDiscount() {
        String nameFilm = driver.findElement(By.tagName("h1")).getText();
        System.out.println(nameFilm);
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/discounts')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//h3[text()='Скидки']"));
        //click(By.xpath("//input[@type='checkbox']"));
        click(By.linkText("Скидка автотест"));
        isElementDisplayed(By.xpath("//td[text()='Скидка автотест']"));
        click(By.xpath("//button[text()='Удалить все']"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseNotDefinedTariff(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Ошибка определения Тарифного плана/Тарифных опций']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Ошибка определения Тарифного плана/Тарифных опций"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void copyPasteCodMsisdnForNonMF(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/msisdn_confirmations')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        String codMsisdn = driver.findElement(By.xpath("(//td[text()='79261184972']/following-sibling::td)[4]")).getText();
        //здесь переключаемся опять на вкладку с мегафонТВ, закрываем вкладку CMS и далее вставляем взятый код из CMS в открытый попап в поле подтверждения регистрации
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));

        driver.findElement(By.xpath("//input[@placeholder='Код подтверждения']")).sendKeys(codMsisdn); }

    public void copyPasteCodMsisdnBlockingMf(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/msisdn_confirmations')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        String codMsisdn = driver.findElement(By.xpath("(//td[text()='79267644248']/following-sibling::td)[4]")).getText();
        //здесь переключаемся опять на вкладку с мегафонТВ, закрываем вкладку CMS и далее вставляем взятый код из CMS в открытый попап в поле подтверждения регистрации
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
        driver.findElement(By.xpath("//input[@placeholder='Код подтверждения']")).sendKeys(codMsisdn); }

    public void chooseRoleVip(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("role")).click();
        driver.findElement(By.xpath("//option[. = 'vip']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        isElementDisplayed(By.xpath("//td[text()='vip']"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseBundleOsnovnoyFromMsisdn(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = 'Основной']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        click(By.linkText("Пакеты/Бандлы"));
        isElementDisplayed(By.linkText("Основной"));
        //здесь переключаемся опять на вкладку с мегафонТВ
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void chooseBundleNotSelected(String login) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user')");
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        click(By.xpath("//form[@method='GET']//input[1]"));
        writeText(By.xpath("//form[@method='GET']//input[1]"), login);
        click(By.xpath("//button[text()='Поиск']"));
        isElementDisplayed(By.xpath("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']"));
        click(By.xpath("//a[contains(@href, '/cms/households/')]"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("(//a[@role='button'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()=' Редактирование хаусхолда ']"));
        driver.findElement(By.id("bundle")).click();
        driver.findElement(By.xpath("//option[. = '(не выбрано)']")).click();
        click(By.xpath("//input[@value='Сохранить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Информация о хаусхолде ']"));
        click(By.xpath("//button[text()='Обновить ТП/ТО и бандлы']"));
        driver.close();
    }
}





