package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
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

public class CardTvProgram extends BasePage {
    public CardTvProgram(WebDriver driver) {
        super(driver);
    }
    String NIL_Page_PP5 = "https://web-preprod5.megafon.tv/";

    public void checkOpenCardTvProgram() {

        isElementDisplayed(By.xpath("(//a[@href='/tv']//span[1])"));
    }
    public void clickPaymentButtonInCardTvProgram() {
        click(By.xpath("(//button[@type='button']//span)[1]"));
    }

    public void checkPaymentComplete() {
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]|//h3[contains(text(),'Подключение услуги')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkAutoStartVideoPlayer() throws Exception {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void clickButtonFavorite() {
        isElementDisplayed(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
        click(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
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

    public void moveSliderRewindToVideoPlayer() throws Exception {
        Actions actions = new Actions(driver);
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = driver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 450, 0).perform();
        Thread.sleep(15000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        Thread.sleep(5000);
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void rewindOn10secondsToVideoPleer() throws InterruptedException {
        //перемотка на 10 секунд вперёд:
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[3]"));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
        //перемотка на 10 секунд назад:
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time3 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[2]"));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time4 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time3, time4);
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

    public void clickToButtonPlay() {
        click(By.className("_2fPMOlJJX5DRkSEypQ3sLc"));
    }

    public void checkTimeStopPleer() throws InterruptedException {
        Actions actions = new Actions(driver);
        //автозапуск тв-передачи:
        Thread.sleep(30000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time3 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        driver.get(NIL_Page_PP5);
        //Кликнуть на тайл этого фильма в подборке "Продолжить просмотр"
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/tv/channels/')])[1]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]")));
        click(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]"));
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time4 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time3, time4);
    }

    public void checkElementsInCardTvProgram() {
        isElementDisplayed(By.className("_1rev14Qo58_GNSeeC-Rh2V"));
        isElementDisplayed(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
        isElementDisplayed(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]"));
        isElementDisplayed(By.className("_3DKCWpmCv7Gf2hQA0mQQ2g"));
        isElementDisplayed(By.xpath("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq _2JcPAFyPdrCLgIuTHxDufK']"));
        isElementDisplayed(By.className("_1v_D6wOANknQeJMBPo_rKK"));
        isElementDisplayed(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'])[1]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_39Yp8LSFDnN1PnBG2_NFLL')]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_2e92e-_RzKCZ4VypEl02Kj')]"));
    }

    public void checkImageDifferCardTvProgramForUnauthorized() throws IOException {
        Set<By> daysSchedule = new HashSet<>();
        daysSchedule.add(By.xpath("//div[@class='_2g4yeSiNbxlU4wgd7X-sN2']"));
        Set<By> timeSchedule = new HashSet<>();
        timeSchedule.add(By.xpath("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']"));
        Screenshot screenshotCardTvProgramPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .ignoredElements(daysSchedule)
                .ignoredElements(timeSchedule)
                .addIgnoredElement(By.xpath("//div[@class='_1KLHFmaQkSgHohGyiuAR3i']")) //название передачи, сегодня возраст, описание передачи
                .addIgnoredElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]"))
                .addIgnoredElement(By.className("_1GgmNtEHj_XmeyaKNiKDz8"))
                .addIgnoredElement(By.xpath("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g' and text()]"))
                .addIgnoredElement(By.xpath("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6 V5gzWmx0AeSFNR9OCQRIz']"))
                .addIgnoredElement(By.className("_3U2-yKAj4IPU3tvIT6W2cl"))
                .addIgnoredElement(By.className("baGc44KXrkpgoHXV0vpsM"))
                .addIgnoredElement(By.xpath("(//div[@class='ch-trigger__container'])[4]"))
                .takeScreenshot(driver);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/TvPage/" + "cardTvProgramPp5" + ".png");
        ImageIO.write(screenshotCardTvProgramPp5.getImage(), "png", actualFile1);

//        //Сделать новый эталонный скриншот:
//        Screenshot screenshotCardTvProgramPp5Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .ignoredElements(daysSchedule)
//                .ignoredElements(timeSchedule)
//                .addIgnoredElement(By.xpath("//div[@class='_1KLHFmaQkSgHohGyiuAR3i']")) //название передачи, сегодня возраст, описание передачи
//                .addIgnoredElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]"))
//                .addIgnoredElement(By.className("_1GgmNtEHj_XmeyaKNiKDz8"))
//                .addIgnoredElement(By.xpath("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g' and text()]"))
//                .addIgnoredElement(By.xpath("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6 V5gzWmx0AeSFNR9OCQRIz']"))
//                .addIgnoredElement(By.className("_3U2-yKAj4IPU3tvIT6W2cl"))
//                .addIgnoredElement(By.className("baGc44KXrkpgoHXV0vpsM"))
//                .addIgnoredElement(By.xpath("(//div[@class='ch-trigger__container'])[4]"))
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/TvPage/"+"cardTvProgramPp5Standard"+".png");
//        ImageIO.write(screenshotCardTvProgramPp5Standard.getImage(), "png", expectedFile1);
//        screenshotCardTvProgramPp5Standard.setIgnoredAreas(screenshotCardTvProgramPp5.getIgnoredAreas());

        // Взять старый эталон скриншота:
        Screenshot screenshotCardTvProgramPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/TvPage/" + "cardTvProgramPp5Standard" + ".png")));
        screenshotCardTvProgramPp5Standard.setIgnoredAreas(screenshotCardTvProgramPp5.getIgnoredAreas());

        //Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCardTvProgramPp5Standard, screenshotCardTvProgramPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/TvPage/" + "diffCardTvProgram" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 15);
    }

    public void checkButtonFavoriteNotAdded() {
        isElementDisplayed(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
        String colorButtonFavoriteNotAdded = driver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-]")).getCssValue("background-color");
        System.out.println(colorButtonFavoriteNotAdded);
        Assert.assertEquals("Не тот цвет","rgba(237, 237, 237, 1)",colorButtonFavoriteNotAdded);
        isElementDisplayed(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg"));
        String colorIconFavoriteNotAdded = driver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg > path[fill]")).getCssValue("fill");
        System.out.println(colorIconFavoriteNotAdded);
        Assert.assertEquals("Не тот цвет","rgb(153, 153, 153)",colorIconFavoriteNotAdded);
    }

    public void checkButtonFavoriteAdded() {
        String colorButtonFavoriteAdded = driver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-]")).getCssValue("background-color");
        System.out.println(colorButtonFavoriteAdded);
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorButtonFavoriteAdded);
        isElementDisplayed(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg"));
        String colorIconFavoriteAdded = driver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg > path[fill]")).getCssValue("fill");
        System.out.println(colorIconFavoriteAdded);
        Assert.assertEquals("Не тот цвет","rgb(255, 255, 255)",colorIconFavoriteAdded);
    }

    public void clickOnTvChannelInCardProgram() {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
    }

    public void checkElementsPlayerUnrecordedTvProgram() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        isElementDisplayed(By.className("_2GPoEznIkBV65Iqkud1teP"));
        isElementDisplayed(By.xpath("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']"));
        Assert.assertEquals("не совпадает число элемеантов", 2, driver.findElements(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']")).size());
    }

    public void checkElementsPlayerRecordedTvProgram() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        isElementDisplayed(By.className("_2GPoEznIkBV65Iqkud1teP"));
        isElementDisplayed(By.xpath("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']"));
        Assert.assertEquals("не совпадает число элемеантов", 7, driver.findElements(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']")).size());
    }




    public void testFullScreenPlayer() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//div[@data-for='FullScreenButton']"));
        actions.moveToElement(driver.findElement(By.xpath("//div[@data-for='FullScreenButton']"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='Выйти из полноэкранного режима']"));
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println(time1);
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();

        click(By.xpath("//div[@data-for='FullScreenButton']"));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[@data-for='FullScreenButton']"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='На весь экран']"));
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //System.out.println(time2);
        Assert.assertNotEquals(time1, time2);
    }

    public void testOnAndOffAudioInPlayer() throws InterruptedException {
        //включить звук:
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        actions.moveToElement(driver.findElement(By.className("_1esD56qNtjqeNN5gjleArE"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='Включить звук']"));
        click(By.className("_1esD56qNtjqeNN5gjleArE"));
        System.out.println(driver.findElement(By.cssSelector("div[class='_3uP0ihiEVqMOuIXkcIlhiL']")).getCssValue("width"));
//        Assert.assertEquals("звук не включен", "47%", driver.findElement(By.xpath("//div[@class='_3TlgpcuUvhiTmYXuvW6X6I' and @style]")).getCssValue("width"));

        //отключить звук:
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        isElementDisplayed(By.className("_1esD56qNtjqeNN5gjleArE"));
        actions.moveToElement(driver.findElement(By.className("_1esD56qNtjqeNN5gjleArE"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='Отключить звук']"));
        click(By.className("_1esD56qNtjqeNN5gjleArE"));
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("div[class='_3uP0ihiEVqMOuIXkcIlhiL']")).getCssValue("width"));

//        Assert.assertEquals("звук не отключен", "0%", driver.findElement(By.xpath("(//div[@class='_3uP0ihiEVqMOuIXkcIlhiL'])[1]")).getCssValue("width"));
    }

    public void clickOnScheduleInPlayerUnrecordedAndCheckeElements() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[3]"));
        isElementDisplayed(By.xpath("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[text()='Сегодня']"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='_2F06JEFCaBoh-jQ-JAfmAN'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='DSoUWlplI4m8T5WSf-XxC'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')])[1]"));
    }

    public void clickOnScheduleInPlayerInRecordedAndCheckeElements() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]"));
        isElementDisplayed(By.xpath("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[text()='Сегодня']"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='_2F06JEFCaBoh-jQ-JAfmAN'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='DSoUWlplI4m8T5WSf-XxC'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')])[1]"));
        Assert.assertEquals("не тот цвет элемента", "rgba(0, 185, 86, 1)", driver.findElement(By.xpath("(//div[@class='_9zLB0lWoiPV1ec0DJCkgd'])[1]")).getCssValue("color"));
        isElementDisplayed(By.xpath("(//div[@class='_2TfjWnFcko5fM6N6iIDjho'])[1]"));
    }

    public void swithOtherTvChannelInsidePlayer() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        String nameTvChannel = driver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//div[@class='_1wbag-kQ46Rgp9vIssZF16 _2yqndJWOuX36UWc1F5T19w'])[2]]"));
//        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[2]"));
        Thread.sleep(3000);
        Assert.assertNotEquals("канал не переключен", nameTvChannel, driver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
    }

    public void swithOtherTvProgramInsidePlayer() throws InterruptedException {
        //нажать на перемотку назад:
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[4]"));
        String nameTvChannel = driver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[4]"));
        Thread.sleep(3000);
        Assert.assertNotEquals("передача не переключена", nameTvChannel, driver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void clickOnLinkNextTvProgramInRecording() {
        String nameTvChannel = driver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText();
        click(By.xpath("(//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']//div)[2]"));
        Assert.assertNotEquals("передача не переключена", nameTvChannel, driver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void checkOpenPopUp18plus() {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
    }

    public void clickOnPlayInPlayer() {
        isElementDisplayed(By.xpath("(//button[@type='button'])[1]"));
        click(By.xpath("(//button[@type='button'])[1]"));
    }

    public void checkAbsentPopUp18plus() {
        Assert.assertEquals("есть попап 18+", 0, driver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']")).size());
    }

    public void swithOnTvProgramNon18plusInsidePlayer() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        String genreTvChannel = driver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]")).getText();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        isElementDisplayed(By.xpath("//div[@class='_1wbag-kQ46Rgp9vIssZF16 _2yqndJWOuX36UWc1F5T19w']"));
        click(By.xpath("(//div[@class='_1wbag-kQ46Rgp9vIssZF16 _2yqndJWOuX36UWc1F5T19w'])[5]"));
        driver.navigate().refresh();
        Thread.sleep(3000);
        Assert.assertNotEquals("канал не переключен", genreTvChannel, driver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]")).getText());
    }

    public void swithOnTvProgram18PlusInsidePlayer() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        String genreTvChannel = driver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]")).getText();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//div[@class='_3rG-uZRT_8O5npnrboEkUD'])[1]"));
        isElementDisplayed(By.xpath("//div[@class='_1wbag-kQ46Rgp9vIssZF16 _2yqndJWOuX36UWc1F5T19w']"));
        click(By.xpath("(//div[@class='_1wbag-kQ46Rgp9vIssZF16 _2yqndJWOuX36UWc1F5T19w'])[1]"));
        driver.navigate().refresh();
        Thread.sleep(3000);
        Assert.assertNotEquals("канал не переключен", genreTvChannel, driver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]")).getText());
    }
}
      
