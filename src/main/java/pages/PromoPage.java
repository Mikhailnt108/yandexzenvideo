package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class PromoPage extends BasePage {
    public PromoPage(WebDriver driver) {
        super(driver);
    }

    public void checkNotDefinedTariff() {
        isElementDisplayed(By.xpath("//div[text()='Акция недоступна']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[4]"));
        isElementDisplayed(By.xpath("//div[text()='Ошибка определения тарифного плана']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Из-за проблемы определения Вашего тарифного плана участие в акциях временно недоступно.Если проблема повторяется, обратитесь в службу поддержки - help@megafon.tv')]"));
    }

    public void checkNotMegafon() {
        isElementDisplayed(By.xpath("//div[contains(text(),'Переходите в МегаФон с')]"));
        isElementDisplayed((By.xpath("//button[text()='Перейти']")));
    }

    public void clickToButtonGoOver() {
        click(By.xpath("//button[text()='Перейти']"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='Перейти в МегаФон со своим номером']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
    }

    public void checkBlockingMegafon() {
        isElementDisplayed(By.xpath("//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Ваш номер МегаФон заблокирован']"));
        isElementDisplayed(By.xpath("//div[text()='Для просмотра пополните баланс']"));
        isElementDisplayed(By.xpath("//button[text()='Пополнить баланс телефона']"));
        click(By.linkText("Ваш МегаФон ТВ может больше! Хочу больше!"));
        isElementDisplayed(By.xpath("(//div[text()='VIP'])[2]"));
        isElementDisplayed(By.xpath("//a[@href='https://megafon.ru/go/vip_tariff']"));
        click(By.linkText("Скрыть"));
        Assert.assertEquals(0, driver.findElements(By.xpath("(//div[text()='VIP'])[2]")).size());
    }

    public void clickToButtonTopUpPhoneBalance() {
        click(By.xpath("//button[text()='Пополнить баланс телефона']"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='Пополнить баланс']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
    }

    public void checkVipUser() {
        isElementDisplayed(By.xpath("//div[text()='Ошибка определения тарифного плана']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Из-за проблемы определения Вашего тарифного плана участие в акциях временно недоступно.Если проблема повторяется, обратитесь в службу поддержки - help@megafon.tv')]"));
    }

    public void clickButtonGoToFilms() {
        click(By.linkText("Перейти к фильмам"));
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
        isElementDisplayed(By.xpath("//div[text()='По акции']"));

    }

    public void clickButtonGoToPackage() {
        click(By.linkText("Перейти в пакет"));
        isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
        isElementDisplayed(By.xpath("//div[contains(text(), 'Входит')]"));
    }

    public void checkListOfTariff() {
        click(By.linkText("Ваш МегаФон ТВ может больше! Хочу больше!"));
        isElementDisplayed(By.xpath("(//div[text()='VIP'])[2]"));
        isElementDisplayed(By.xpath("//a[@href='https://megafon.ru/go/vip_tariff']"));
        click(By.linkText("Скрыть"));
        Assert.assertEquals(0, driver.findElements(By.xpath("(//div[text()='VIP'])[2]")).size());

    }

    public void imageDifferBlockTarif() throws AWTException, IOException {
    }

    public void imageDifferBlockPromotions() throws AWTException, IOException {
    }

    public void checkElementsWithoutBlockPersonalOffer() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        Assert.assertEquals("Акции", driver.findElement(By.tagName("h1")).getText());
        click(By.xpath("(//a[@class='aeD2NhkcvTTw9nWXBCWBE'])[1]"));
        Assert.assertEquals(1, driver.findElements(By.xpath("//div[@class='_3KtGW53ESdkgO-PeTDXkdm']//span")).size());
        Assert.assertEquals("Скрыть", driver.findElement(By.linkText("Скрыть")).getText());
        click(By.linkText("Скрыть"));
        Assert.assertEquals("Подробнее", driver.findElement(By.linkText("Подробнее")).getText());
        Assert.assertEquals(0, driver.findElements(By.xpath("//div[@class='_3KtGW53ESdkgO-PeTDXkdm']//span")).size());
    }
}
