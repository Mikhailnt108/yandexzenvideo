package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CardTvProgram extends BasePage {
    public CardTvProgram(WebDriver driver) {
        super(driver);
    }
    public void checkOpenCardTvProgram() {
        isElementDisplayed(By.xpath("(//a[@href='/tv']//span[1])"));
    }
    public void clickPaymentButtonInCardTvProgram() {
        click(By.xpath("(//button[@type='button']//span)[1]"));
    }

    public void checkPaymentComplete() {
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Пакет подключен']"));
        click(By.xpath("//button[text()='Закрыть']"));

    }


    public void startVideoPlayer() throws Exception {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void clickButtonFavorites() {
        //click(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[2]"));
        click(By.xpath("(//button[@type='button' and @style='background-color: rgb(237, 237, 237);'])[2]"));
        isElementDisplayed(By.xpath("(//button[@type='button' and @style='background-color: rgb(51, 51, 51);'])[2]"));
    }
    public void clickToLinkCardPackage() {click(By.linkText("Максимальный")); }

    public void clickToPauseVideoPleer() throws Exception {
        Thread.sleep(7000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        //нажал на паузу - видео остановилось
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time3 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time2, time3);
    }

    public void clickToPlayVideoPleer() throws Exception {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time4 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //нажал на плей - видео запустилось
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time5 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time4, time5);
        Thread.sleep(7000);
    }

    public void clickToSpaceToVideoPleer() throws Exception {
        Actions actions = new Actions(driver);
        //нажал на пробел - видео остановилось
        actions.sendKeys(Keys.chord(Keys.SPACE)).perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time6 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time7 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time6, time7);
        //нажал на пробел - видео запустилось
        actions.sendKeys(Keys.chord(Keys.SPACE)).perform();
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time8 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time7, time8);
    }

    public void clickToLeftButtonMouseToVideoPleer() throws Exception {
        Actions actions = new Actions(driver);
        Thread.sleep(7000);
        //нажал на левую клавишу мыши - видео остановилось
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).click().build().perform();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time9 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time10 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time9, time10);
        //нажал на левую клавишу мыши - видео запустилось
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).click().build().perform();
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time11 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time10, time11);
    }

    public void clickOnLinkTvProgramInRecording() {
        click(By.xpath("(//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']//div)[1]"));
    }

    public void moveSliderRewindToVideoPleer() throws Exception {
        Actions actions = new Actions(driver);
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = driver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 155, 0).perform();
        Thread.sleep(7000);
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void clickYesInPopUp18Plus() throws Exception {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Да']"));
        Actions actions = new Actions(driver);
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void clickNoInPopUp18Plus() {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Нет']"));
        isElementDisplayed(By.xpath("(//button[@type='button'])[1]"));
    }

    public void goToCardTvProgram18Plus() {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
    }

}
      
