package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[5]"));
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
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[2]"));
    }

    public void checkPaymentComplete() {
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Пакет подключен']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void clickToButtonPlay() {
        click(By.className("_2fPMOlJJX5DRkSEypQ3sLc"));
    }

    public void clickTvProgramRecordInCardTvChannel() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]")));
        click(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]"));

    }

    public void checkImageDifferCardTvChannel() throws IOException {
        Set<By> daysSchedule = new HashSet<>();
        daysSchedule.add(By.xpath("//div[@class='_2g4yeSiNbxlU4wgd7X-sN2']"));
        Set<By> timeSchedule = new HashSet<>();
        timeSchedule.add(By.xpath("//div[@class='_3hTg_sTNIhM5ALiEXQHPhj']"));
        Screenshot screenshotCardTvChannelPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(1))
                .ignoredElements(daysSchedule)
                .ignoredElements(timeSchedule)
                .addIgnoredElement(By.className("_1nAXLMkHN0PXnwvulfBvK0"))
                .addIgnoredElement(By.className("_3DKCWpmCv7Gf2hQA0mQQ2g"))
                .addIgnoredElement(By.className("_2tGh-AEMtExspQrxBI4_m0"))
                .addIgnoredElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]"))
                .addIgnoredElement(By.xpath("(//div[@class='ch-trigger__container'])[4]"))
                .takeScreenshot(driver);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/TvPage/" + "cardTvChannelPp5" + ".png");
        ImageIO.write(screenshotCardTvChannelPp5.getImage(), "png", actualFile1);

        driver.get("https://web-preprod5.megafon.tv/tv");

        //Сделать новый эталонный скриншот:
        Screenshot screenshotCardTvChannelPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(1))
                .ignoredElements(daysSchedule)
                .ignoredElements(timeSchedule)
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/TvPage/"+"cardTvChannelPp5Standard"+".png");
        ImageIO.write(screenshotCardTvChannelPp5Standard.getImage(), "png", expectedFile1);
        screenshotCardTvChannelPp5Standard.setIgnoredAreas(screenshotCardTvChannelPp5.getIgnoredAreas());
//        // Взять старый эталон скриншота:
//        Screenshot screenshotAllTvPagePp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/TvPage/" + "allTvPagePp5Standard" + ".png")));
//        screenshotAllTvPagePp5Standard.setIgnoredAreas(screenshotAllTvPagePp5.getIgnoredAreas());

        //Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCardTvChannelPp5Standard, screenshotCardTvChannelPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/TvPage/" + "diffCardTvChannel" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 15);
    }
}
