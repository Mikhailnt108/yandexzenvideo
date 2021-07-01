package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CardTvChannel extends BasePage {
    public CardTvChannel(WebDriver driver) {
        super(driver);
    }


    public void checkOpenCardTvProgram() {
        String urlCardTvProgram = webDriver.getCurrentUrl();
        urlCardTvProgram.equals("/programs/");
    }

    public void clickOnTvProgramInCardChannel() {
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

    public void clickNoInPopUp18Plus() {
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

    public void checkPaymentComplete() {
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void clickToButtonPlay() {
        click(By.xpath("(//span[contains(text(),'Смотреть бесплатно')])[1]|(//span[contains(text(),'Подключить бесплатно')])[1]"));
    }

    public void clickTvProgramRecordInCardTvChannel() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]")));
        click(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]"));

    }

    public void checkImageDifferCardTvChannelForUnauthorized() throws IOException {
        // Сделать тестовый скриншот:
        Screenshot screenshotCardTvChannel = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_2g4yeSiNbxlU4wgd7X-sN2']")) // игнор табы дней
                .addIgnoredElement(By.xpath("//li[@class='t6ks9YEMnxUV-aY0ikOPp']")) // игнор название тв канала в хлеб крошках
                .addIgnoredElement(By.xpath("//div[@class='_1KLHFmaQkSgHohGyiuAR3i']")) // игнор название передачи, сегодня возраст, описание передачи
                .addIgnoredElement(By.xpath("//img[@class='_3lvyrUkaGN_QANJMIvjX5c']")) // игнор лого тв канала
                .addIgnoredElement(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2']")) // игнор жанр тв канала
                .addIgnoredElement(By.xpath("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6 V5gzWmx0AeSFNR9OCQRIz']")) // игнор описание тв канала
                .addIgnoredElement(By.xpath("//button[@type='button' and contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]")) // игнор текстов в кнопках подписки
                .addIgnoredElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]")) // игнор день и время начала, возраст
                .addIgnoredElement(By.className("_1GgmNtEHj_XmeyaKNiKDz8")) //игнор название тв передачи
                .addIgnoredElement(By.xpath("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g' and text()]")) // игнор описание тв передачи
                .addIgnoredElement(By.className("_3U2-yKAj4IPU3tvIT6W2cl")) // игнор постер тв передачи с элементами на нем
                .addIgnoredElement(By.className("baGc44KXrkpgoHXV0vpsM")) // игнор область плеера
                .addIgnoredElement(By.xpath("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']")) // игнор расписание других передач
                .addIgnoredElement(By.xpath("//div[contains(@class,'_3QE1K8wDQNs7aOkpG23Vgf')]"))
                .addIgnoredElement(By.xpath("//div[contains(@class,'_2ROaLP-IKMp9XGVOrXGaPS') and @style]")) //
                .addIgnoredElement(By.xpath("//div[@class='_3hlRrGlC5ULyEotgmvIFpx _3urL5ggtAaYH0gwIBVZ3UC']"))
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/TvPage/" + "cardTvChannel" + ".png");
        ImageIO.write(screenshotCardTvChannel.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот:
//        Screenshot screenshotCardTvChannelStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/TvPage/"+"cardTvChannelStandard"+".png");
//        ImageIO.write(screenshotCardTvChannelStandard.getImage(), "png", expectedFile1);
//        screenshotCardTvChannelStandard.setIgnoredAreas(screenshotCardTvChannel.getIgnoredAreas());

        // Взять старый эталон скриншота:
        Screenshot screenshotCardTvChannelStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/TvPage/" + "cardTvChannelStandard" + ".png")));
        screenshotCardTvChannelStandard.setIgnoredAreas(screenshotCardTvChannel.getIgnoredAreas());

        // Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCardTvChannelStandard, screenshotCardTvChannel);
        System.out.println(diff1.getDiffSize());
        System.out.println(diff1.getDiffImage());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/TvPage/" + "diffCardTvChannel" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 3000);
    }

    public void checkElementsInCardTvChannel() {
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

    public void clickOnButtonFavorite() {
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

    public void goToTvProgram18Plus() {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        }
    }


