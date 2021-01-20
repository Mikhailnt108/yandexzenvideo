package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CardTvChannel extends BasePage {
    public CardTvChannel(WebDriver driver) {
        super(driver);
    }


    public void checkOpenCardTvProgram() {
        isElementDisplayed(By.xpath("//a[@href='/tv']//span[1]"));
    }

    public void clickTvProgramInCardChannel() {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
    }

    public void clickPaymentButtonInCardTvChannel() {
        click(By.xpath("(//button[@type='button']//span)[1]"));
    }

    public void clickToLinkCardPackage() {click(By.linkText("Максимальный")); }

    public void checkOpenScheduleOnCardTvChannel() { isElementDisplayed(By.xpath("//div[text()='Сегодня']")); }

    public void checkOpenCardTvChannel() {
        isElementDisplayed(By.xpath("//a[@href='/tv']//span[1]"));
    }

    public void chooseTvChannel18Plus() throws Exception {
        Actions actions = new Actions(driver);
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        Thread.sleep(5000);
        //click(By.xpath("//div[@class='_1wbag-kQ46Rgp9vIssZF16 _2yqndJWOuX36UWc1F5T19w'][221]"));
        click(By.xpath("//div[221]/div/div[2]"));



        //click(By.cssSelector(".\\_1wbag-kQ46Rgp9vIssZF16:nth-child(221) .\\_3GXxXiLb1VN6fU0CRO3ta8"));
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

    public void backToNewsTvChannel() {
        driver.navigate().back();

    }

    public void clickNoInPopUp18Plus() {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Нет']"));
        isElementDisplayed(By.xpath("//div[text()='Новости']"));
    }

    public void chooseTvChannelNews() throws Exception {
        Actions actions = new Actions(driver);
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//div[218]/div/div[2]"));
    }
}
