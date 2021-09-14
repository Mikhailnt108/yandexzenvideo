package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Footer extends BasePageWebDriver {
    public Footer(WebDriver driver) {
        super(driver);
    }
    public void clickToLinkFromDevices() {
        click(By.linkText("Компьютер"));
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//span[text()='Компьютеры']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
        click(By.linkText("Смартфоны и планшеты"));
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//span[text()='планшеты и смартфоны']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs2.get(0));
        click(By.linkText("Smart TV"));
        ArrayList tabs3 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs3.get(1));
        isElementDisplayed(By.xpath("//span[text()='Smart TV']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs3.get(0));
        click(By.linkText("Android TV"));
        ArrayList tabs4 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs4.get(1));
        isElementDisplayed(By.xpath("//span[text()='Smart TV']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs4.get(0));
        click(By.linkText("Apple TV"));
        ArrayList tabs5 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs5.get(1));
        isElementDisplayed(By.xpath("//span[text()='Apple TV']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs5.get(0));
        click(By.linkText("Все устройства"));
        ArrayList tabs6 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs6.get(1));
        isElementDisplayed(By.xpath("//span[text()='5 устройств']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs6.get(0));
    }

    public void clickToLinkFromSupport() {
        isElementDisplayed(By.xpath("//a[@href='tel:+78005509065']"));
        click(By.xpath("//span[text()='Задайте нам вопрос']"));
        isElementDisplayed(By.xpath("//div[text()='Отправить вопрос']"));
        click(By.className("cUNRcCHPmylO_eFndFhLd"));
        click(By.linkText("Вопросы и ответы"));
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='Часто задаваемые вопросы']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
        click(By.linkText("Карта Сайта"));
        isElementDisplayed(By.xpath("//h1[text()='Карта сайта']"));
        webDriver.navigate().back();
        click(By.linkText("О нас"));
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//span[text()='5 устройств']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs2.get(0));
        }
    public void clickToLinkFromSocialNetworks() {
        click(By.xpath("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]"));
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='МегаФон ТВ в Мессенджерах!']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
        click(By.xpath("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]"));
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//h1[text()='МегаФон ТВ в Мессенджерах!']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs2.get(0));
    }

    public void clickToLinkFromDownloadApp() {
        click(By.xpath("//img[@alt='mftv-app-store']"));
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//span[text()='App Store']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
        click(By.xpath("//img[@alt='mftv-google-play']"));
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs2.get(1));
        isElementDisplayed(By.xpath("//a[@title='Google Play Logo']//img[1]"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs2.get(0));
        click(By.xpath("//img[@alt='mftv-huawei-store']"));
        ArrayList tabs3 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs3.get(1));
        isElementDisplayed(By.xpath("//div[text()='HUAWEI AppGallery']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs3.get(0));
        click(By.xpath("//img[@alt='mftv-smart-tv']"));
        ArrayList tabs4 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs4.get(1));
        isElementDisplayed(By.xpath("//span[text()='Smart TV']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs4.get(0));
    }

    public void clickToLinkDocsAndRules() {
        String url1 = "https://web-preprod2.megafon.tv/docs/rules-provide-telematic-services.pdf";
        click(By.linkText("Правила оказания телематических услуг связи"));
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs1.get(1));
        String url2 = webDriver.getCurrentUrl();
        Assert.assertEquals(url1,url2);
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));

        String url3 = "https://web-preprod2.megafon.tv/docs/rules-ktv.pdf";
        click(By.linkText("Правила оказания услуг телевизионного вещания"));
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs2.get(1));
        String url4 = webDriver.getCurrentUrl();
        Assert.assertEquals(url3,url4);
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));

        String url5 = "https://moscow.megafon.ru/download/~federal/oferts/mediaportal_oferta.pdf";
        click(By.linkText("Условия оказания услуги"));
        ArrayList tabs3 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs3.get(1));
        String url6 = webDriver.getCurrentUrl();
        Assert.assertEquals(url5,url6);
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));

        String url7 = "https://web-preprod2.megafon.tv/static/privacy.pdf";
        click(By.linkText("Политика конфидециальности"));
        ArrayList tabs4 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs4.get(1));
        String url8 = webDriver.getCurrentUrl();
        Assert.assertEquals(url7,url8);
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
    }
}
