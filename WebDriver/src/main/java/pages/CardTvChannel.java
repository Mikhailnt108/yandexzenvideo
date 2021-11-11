package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardTvChannel extends BasePageWebDriver {
    public CardTvChannel(WebDriver driver) {
        super(driver);
    }

    public void checkOpenCardTvProgram() {
        String urlCardTvProgram = webDriver.getCurrentUrl();
        urlCardTvProgram.equals("/programs/");
    }

    public void clickOnTvProgramInCardChannel() throws InterruptedException {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
    }

    public void clickPaymentButtonInCardTvChannel() throws InterruptedException {
        click(By.xpath("(//button[@type='button']//span)[1]"));
    }

    public void clickToLinkCardPackage() throws InterruptedException {click(By.linkText("Максимальный")); }

    public void checkOpenScheduleOnCardTvChannel() { isElementDisplayed(By.xpath("//div[text()='Сегодня']")); }

    public void checkOpenCardTvChannel() {
        isElementDisplayed(By.xpath("//a[@href='/tv']//span[1]"));
    }

    public void chooseTvChannel18Plus() throws Exception {
        Actions actions = new Actions(webDriver);
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        Thread.sleep(5000);
        //click(By.xpath("//div[@class='_1wbag-kQ46Rgp9vIssZF16 _2yqndJWOuX36UWc1F5T19w'][221]"));
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[5]"));
        //click(By.cssSelector(".\\_1wbag-kQ46Rgp9vIssZF16:nth-child(221) .\\_3GXxXiLb1VN6fU0CRO3ta8"));
    }


    public void clickYesInPopUp18Plus() throws Exception {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Да']"));
        Actions actions = new Actions(webDriver);
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void backToNewsTvChannel() {
        webDriver.navigate().back();

    }

    public void clickNoInPopUp18Plus() throws InterruptedException {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Нет']"));
        isElementDisplayed(By.xpath("//div[text()='Новости']"));
    }

    public void chooseTvChannelNews() throws Exception {
        Actions actions = new Actions(webDriver);
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[2]"));
    }

    public void checkPaymentComplete() throws InterruptedException {
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void clickToButtonPlay() throws InterruptedException {
        click(By.xpath("(//span[contains(text(),'Смотреть бесплатно')])[1]|(//span[contains(text(),'Подключить бесплатно')])[1]"));
    }

    public void clickTvProgramRecordInCardTvChannel() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]")));
        Thread.sleep(5000);
        click(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]"));
    }

    public void checkElementsInCardTvChannel() throws InterruptedException {
        Thread.sleep(3000);
        isElementDisplayed(By.className("_1rev14Qo58_GNSeeC-Rh2V"));
        isElementDisplayed(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
        isElementDisplayed(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]"));
        isElementDisplayed(By.className("_3DKCWpmCv7Gf2hQA0mQQ2g"));
        isElementDisplayed(By.className("_1-ZY27a7Isb9dohjRr0mXq"));
        isElementDisplayed(By.className("_3lvyrUkaGN_QANJMIvjX5c"));
        isElementDisplayed(By.className("_1v_D6wOANknQeJMBPo_rKK"));
        isElementDisplayed(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]"));
        isElementDisplayed(By.className("_2KIN0FxuoXVTLyzpxPtNGz"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_39Yp8LSFDnN1PnBG2_NFLL')]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_2e92e-_RzKCZ4VypEl02Kj')]"));
    }

    public void checkAutoStartVideoPlayer() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void checkButtonFavoriteNotAdded() {
        isElementDisplayed(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
        String colorButtonFavoriteNotAdded = webDriver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-]")).getCssValue("background-color");
        System.out.println(colorButtonFavoriteNotAdded);
        Assert.assertEquals("Не тот цвет","rgba(237, 237, 237, 1)",colorButtonFavoriteNotAdded);
        isElementDisplayed(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg"));
        String colorIconFavoriteNotAdded = webDriver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg > path[fill]")).getCssValue("fill");
        System.out.println(colorIconFavoriteNotAdded);
        Assert.assertEquals("Не тот цвет","rgb(153, 153, 153)",colorIconFavoriteNotAdded);
    }

    public void clickOnButtonFavorite() throws InterruptedException {
        isElementDisplayed(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
        click(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
    }

    public void checkButtonFavoriteAdded() {
        String colorButtonFavoriteAdded = webDriver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-]")).getCssValue("background-color");
        System.out.println(colorButtonFavoriteAdded);
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorButtonFavoriteAdded);
        isElementDisplayed(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg"));
        String colorIconFavoriteAdded = webDriver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg > path[fill]")).getCssValue("fill");
        System.out.println(colorIconFavoriteAdded);
        Assert.assertEquals("Не тот цвет","rgb(255, 255, 255)",colorIconFavoriteAdded);
    }

    public void goToTvProgram18Plus() throws InterruptedException {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        }
    }


