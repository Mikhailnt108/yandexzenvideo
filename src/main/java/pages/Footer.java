package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Footer extends BasePage {
    public Footer(WebDriver driver) {
        super(driver);
    }
    public void clickToLinkFromDevices() {
        click(By.linkText("Компьютер"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//span[text()='Компьютеры']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
        click(By.linkText("Смартфоны и планшеты"));
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//span[text()='планшеты и смартфоны']"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
        click(By.linkText("Smart TV"));
        ArrayList tabs3 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs3.get(1));
        isElementDisplayed(By.xpath("//span[text()='Smart TV']"));
        driver.close();
        driver.switchTo().window((String) tabs3.get(0));
        click(By.linkText("Android TV"));
        ArrayList tabs4 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs4.get(1));
        isElementDisplayed(By.xpath("//span[text()='Smart TV']"));
        driver.close();
        driver.switchTo().window((String) tabs4.get(0));
        click(By.linkText("Apple TV"));
        ArrayList tabs5 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs5.get(1));
        isElementDisplayed(By.xpath("//span[text()='Apple TV']"));
        driver.close();
        driver.switchTo().window((String) tabs5.get(0));
        click(By.linkText("Все устройства"));
        ArrayList tabs6 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs6.get(1));
        isElementDisplayed(By.xpath("//span[text()='5 устройств']"));
        driver.close();
        driver.switchTo().window((String) tabs6.get(0));
    }

    public void clickToLinkFromSupport() {
        isElementDisplayed(By.xpath("//a[@href='tel:+78005509065']"));
        click(By.xpath("//span[text()='Задайте нам вопрос']"));
        isElementDisplayed(By.xpath("//div[text()='Отправить вопрос']"));
        click(By.cssSelector("html>body>div:nth-of-type(9)>div>div>button"));
        click(By.linkText("Вопросы и ответы"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='Часто задаваемые вопросы']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
        click(By.linkText("Карта Сайта"));
        isElementDisplayed(By.xpath("//h1[text()='Карта сайта']"));
        driver.navigate().back();
        click(By.linkText("О нас"));
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//span[text()='5 устройств']"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
        }
    public void clickToLinkFromSocialNetworks() {
        click(By.xpath("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='МегаФон ТВ в Мессенджерах!']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
        click(By.xpath("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]"));
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//h1[text()='МегаФон ТВ в Мессенджерах!']"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
    }

    public void clickToLinkFromDownloadApp() {
        click(By.xpath("//img[@alt='mftv-app-store']"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//span[text()='App Store']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
        click(By.xpath("//img[@alt='mftv-google-play']"));
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//a[@title='Google Play Logo']//img[1]"));
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
        click(By.xpath("//img[@alt='mftv-smart-tv']"));
        ArrayList tabs3 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs3.get(1));
        isElementDisplayed(By.xpath("//span[text()='Smart TV']"));
        driver.close();
        driver.switchTo().window((String) tabs3.get(0));
    }

    public void clickToLinkDocsAndRules() {
        String url1 = "https://web-preprod1.megafon.tv/docs/rules-provide-telematic-services.pdf";
        click(By.linkText("Правила оказания телематических услуг связи"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        String url2 = driver.getCurrentUrl();
        Assert.assertEquals(url1,url2);
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));

        String url3 = "https://web-preprod1.megafon.tv/docs/rules-ktv.pdf";
        click(By.linkText("Правила оказания услуг телевизионного вещания"));
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        String url4 = driver.getCurrentUrl();
        Assert.assertEquals(url3,url4);
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));

        String url5 = "https://moscow.megafon.ru/download/~federal/oferts/mediaportal_oferta.pdf";
        click(By.linkText("Условия оказания услуг"));
        ArrayList tabs3 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs3.get(1));
        String url6 = driver.getCurrentUrl();
        Assert.assertEquals(url5,url6);
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));

        String url7 = "https://web-preprod1.megafon.tv/static/privacy.pdf";
        click(By.linkText("Политика конфидециальности"));
        ArrayList tabs4 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs4.get(1));
        String url8 = driver.getCurrentUrl();
        Assert.assertEquals(url7,url8);
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
    }
}
