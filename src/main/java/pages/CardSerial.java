package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CardSerial extends BasePage {

    public CardSerial(WebDriver driver) {
        super(driver);
    }

    public void checkOpenCardSerial() {
        isElementDisplayed(By.xpath("//a[@href='/shows']//span[1]"));
    }
    public void checkButtonFavoriteNotAdded() {
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[3]"));
        String colorButtonFavoriteNotAdded = driver.findElement(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[3]")).getCssValue("color");
        System.out.println(colorButtonFavoriteNotAdded);
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorButtonFavoriteNotAdded);
    }

    public void clickPaymentButtonInCardSerial() {
        click(By.xpath("(//button[@type='button']//span)[4]"));
    }

    public void clickNamePackage() {
        click(By.xpath("(//a[@class='-p8N6S_CgeVJCFj5VLmD0'])[1]"));
    }

    public void clickButtonFavorites() {
        click(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[3]"));
        isElementDisplayed(By.xpath("//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB']"));
    }

    public void clickTailEpisodeForStartVideoPleer() throws Exception {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
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

    public void clickToButtonSubscribePackage() {
        click(By.xpath("(//button[@type='button']//span)[4]"));
    }

    public void chooseOtherSeasonAndCheckPoster() throws Exception {
        WebElement trailerSeasonFirst = driver.findElement(By.xpath("//video[@src]"));
        WebElement seasonFirst = driver.findElement(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        System.out.println(seasonFirst.getAttribute("href"));
        System.out.println(trailerSeasonFirst.getAttribute("src"));
        //выбрать 2-ой сезон
        click(By.xpath("(//div[text()='Сезон 2'])[2]"));
        WebElement trailerSeasonSecond = driver.findElement(By.xpath("//video[@src]"));
        System.out.println(trailerSeasonSecond.getAttribute("src"));
        WebElement seasonSecond = driver.findElement(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        System.out.println(seasonSecond.getAttribute("href"));
        Assert.assertEquals("видео не одинаковы", trailerSeasonFirst, trailerSeasonSecond);
        Assert.assertNotEquals("нет переключения на другой сезон", seasonFirst, seasonSecond);
    }

    public void clickToButtonSubscribeInPopUp() {
        click(By.xpath("//button[@type='button_free']"));
    }

    public void checkPopUpSubscribeComplete() {
        isElementDisplayed(By.xpath("//h3[text()='Пакет подключен']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkButtonToWatch() {
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void startVideoPleer() throws Exception {
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println(time1);
        Thread.sleep(5000);
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println(time2);
        Assert.assertNotEquals(time1, time2);
    }

    public void clickToPauseVideoPleer() throws Exception {
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println("time1 " + time1);
        Thread.sleep(7000);
        //нажал на паузу - видео остановилось
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //System.out.println("time2 "+ time2);
        Assert.assertNotEquals(time1, time2);
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time3 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //System.out.println("time3 "+ time3);
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
        //нажал на левую клавишу мыши - видео остановилось
        click(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time9 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time10 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time9, time10);
        //нажал на левую клавишу мыши - видео запустилось
        click(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"));
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time11 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time10, time11);
    }

    public void episodeSliderRewindToVideoPleer() throws Exception {
        Actions actions = new Actions(driver);
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = driver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        //WebElement target = driver.findElement(By.id("container"));
        //new Actions(driver).dragAndDrop(slider, target).perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 155, 0).perform();
        Thread.sleep(7000);
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void moveSliderRewindToVideoPleer() throws InterruptedException {
        Actions actions = new Actions(driver);
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = driver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        //WebElement target = driver.findElement(By.id("container"));
        //new Actions(driver).dragAndDrop(slider, target).perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 450, 0).perform();
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void checkTimeStopPleer() throws InterruptedException {
        Actions actions = new Actions(driver);
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time3 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        driver.navigate().back();
        //Кликнуть на тайл этого фильма в подборке "Продолжить просмотр"
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/shows/')])[1]"));
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time4 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time3, time4);
    }

    public void moveSliderRewindToVideoPleer18Plus() throws InterruptedException {
        Actions actions = new Actions(driver);
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        click(By.xpath("//button[text()='Да']"));
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = driver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        //WebElement target = driver.findElement(By.id("container"));
        //new Actions(driver).dragAndDrop(slider, target).perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 450, 0).perform();
        Thread.sleep(7000);
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void checkAutoStartVideoPlayer() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void checkImageDifferCardSerial() throws IOException {
        // Сделать тестовый скриншот:
        Screenshot screenshotCardSerialPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.className("_3oIAMUjIv-QAdeSq_k6cql")) // игнор область плеера
                .addIgnoredElement(By.className("_36y3ZYWoC7rVzn6TEPp4oC")) // игнор текст описания
                .addIgnoredElement(By.className("_1v_D6wOANknQeJMBPo_rKK")) // игнор название фильма
                .addIgnoredElement(By.className("KQ2rb7ZP-tTmXFu9sn_34")) // игнотр блока рейтингов кинопоиск и IMDb
                .addIgnoredElement(By.className("GRbXWlAwTd4ARHYlo21od")) // игнор количества лайков
                .addIgnoredElement(By.className("GRbXWlAwTd4ARHYlo21od")) // игнор количества дизлайков
                .addIgnoredElement(By.className("_1v_D6wOANknQeJMBPo_rKK")) // игнор возраст, год выпуска, жанр.
                .addIgnoredElement(By.className("kjFUbLahFxqq2AjHY8j2R")) // игнор плашки "новинка"
                .addIgnoredElement(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]")) // игнор текст в кнопках покупки
                .addIgnoredElement(By.className("_1-ZY27a7Isb9dohjRr0mXq")) // игнор хлебных крошек
                .addIgnoredElement(By.className("_1hdhJYYoLFCYFGUtF3teH1")) // игнор блок сезоны
                .addIgnoredElement(By.className("_2YrnCSEViX2PQLwVrBYiS0")) // игнор блок "похожие"
                .addIgnoredElement(By.className("ch-trigger__container")) // игнор блока авторизации
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "cardSerialPp4" + ".png");
        ImageIO.write(screenshotCardSerialPp4.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот:
        driver.get("https://web-preprod4.megafon.tv/shows/Neobyknovennyj_plejlist_Zoi_2020/seasons/Neobyknovennyj_plejlist_Zoi_2020_se02");
        Screenshot screenshotCardSerialPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/" + "cardSerialPp4Standard" + ".png");
        ImageIO.write(screenshotCardSerialPp4Standard.getImage(), "png", expectedFile1);
        screenshotCardSerialPp4Standard.setIgnoredAreas(screenshotCardSerialPp4.getIgnoredAreas());

//        // Взять старый эталон скриншота:
//        Screenshot screenshotCardSerialPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "cardSerialPp4Standard" + ".png")));
//        screenshotCardSerialPp4Standard.setIgnoredAreas(screenshotCardSerialPp4.getIgnoredAreas());

        // Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCardSerialPp4Standard, screenshotCardSerialPp4);
        System.out.println(diff1.getDiffSize());
        System.out.println(diff1.getDiffImage());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffCardSerialPp4" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 3000);
    }

    public void checkElementsCardSerial() {
        isElementDisplayed(By.className("_3oIAMUjIv-QAdeSq_k6cql")); // область плеера
        isElementDisplayed(By.xpath("//button[text()='Трейлер']")); // кнопка трейлер
        isElementDisplayed(By.className("_36y3ZYWoC7rVzn6TEPp4oC")); // текст описания
        isElementDisplayed(By.xpath("//button[text()='Прочитать описание']")); // кнопка "прочитать описание"

        isElementDisplayed(By.className("_3v-cosMJBw3_KSQoU9M3Mq")); // блок плашек "новинка" и "full hd"
        isElementDisplayed(By.className("_1v_D6wOANknQeJMBPo_rKK")); // название фильма
//        isElementDisplayed(By.xpath("//div[@class='KQ2rb7ZP-tTmXFu9sn_34']|")); // блок рейтингов "кинопоиск" и "IMDb"
        isElementDisplayed(By.xpath("//div[@class='_1v_D6wOANknQeJMBPo_rKK']")); // возраст, год выпуска, жанр
        isElementDisplayed(By.className("_23uR5oR4uHT0fJvmMxNxmS")); // блок кнопкок: лайк, дизлайк, избранное
        isElementDisplayed(By.className("_2KIN0FxuoXVTLyzpxPtNGz")); // блок кнопок покупки

        isElementDisplayed(By.xpath("//div[@class='_3RenlHWpqv2tjN53MfarzN']//div[contains(text(),'Сезон')]")); // таб сезона
        isElementDisplayed(By.className("_1hdhJYYoLFCYFGUtF3teH1")); // блок тайлов серий сезона
    }

    public void clickToButtonReadDescription() {
        click(By.xpath("//button[text()='Прочитать описание']"));
    }

    public void checkOpenDescriptionAll() {
        isElementDisplayed(By.xpath("//button[text()='Свернуть']"));
        isElementDisplayed(By.xpath("//dt[text()='Возрастное ограничение']"));
    }

    public void clickToButtonRollUp() {
        click(By.xpath("//button[text()='Свернуть']"));
    }

    public void checkRollUpDescription() {
        isElementDisplayed(By.xpath("//button[text()='Прочитать описание']"));
        Assert.assertEquals("Текст описания не свернулся", 0, driver.findElements(By.xpath("//button[text()='Свернуть']")).size());
    }

    public void clickToLikeButton() throws InterruptedException {
        WebElement countLikeOld = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int oldCount = Integer.parseInt(countLikeOld.getText());
        System.out.println(oldCount);
        String colorToLike = driver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(153, 153, 153, 1)", colorToLike);
        String colorToCountLike = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(153, 153, 153, 1)", colorToCountLike);
        click(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]"));
        Thread.sleep(3000);
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'])[1]"));
        driver.navigate().refresh();
        WebElement countLikeNew = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int newCount = Integer.parseInt(countLikeNew.getText());
        System.out.println(newCount);
        Assert.assertTrue(oldCount < newCount);
        String colorMoveToButtonLike = driver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(38, 38, 38, 1)", colorMoveToButtonLike);
        String colorMoveToCountLike = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(38, 38, 38, 1)", colorMoveToCountLike);
    }

    public void clickToDisLikeButton() throws InterruptedException {
        WebElement countDisLikeOld = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]"));
        int oldCountDisLike = Integer.parseInt(countDisLikeOld.getText());
        WebElement countLikeOld = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int oldCountLike = Integer.parseInt(countLikeOld.getText());
        String colorToDisLike = driver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(153, 153, 153, 1)", colorToDisLike);
        String colorToCountDisLike = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(153, 153, 153, 1)", colorToCountDisLike);
        click(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]"));
        Thread.sleep(3000);
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'])[1]"));
        isElementDisplayed(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]"));
        driver.navigate().refresh();
        WebElement countDisLikeNew = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]"));
        int newCountDisLike = Integer.parseInt(countDisLikeNew.getText());
        Assert.assertTrue(oldCountDisLike < newCountDisLike);
        WebElement countLikeNew = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int newCountLike = Integer.parseInt(countLikeNew.getText());
        Assert.assertTrue(oldCountLike > newCountLike);
        String colorMoveToButtonDisLike = driver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(38, 38, 38, 1)", colorMoveToButtonDisLike);
        String colorMoveToCountDisLike = driver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет", "rgba(38, 38, 38, 1)", colorMoveToCountDisLike);
    }

    public void paymentSerialAtSubs() {
        click(By.xpath("(//button[@type='button']//span)[4]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Подписка')]"));
        click(By.xpath("//button[text()='Принять и подключить']|//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void checkSeasonAndEpisode() throws InterruptedException {
        String seasonAndEpisode1 = driver.findElement(By.xpath("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL')]")).getText();
        System.out.println(seasonAndEpisode1);
        driver.get("https://web-preprod5.megafon.tv/shows");
        isElementDisplayed(By.xpath("//h1[text()='Сериалы']"));
        driver.findElement(By.xpath("//div[@class='_3i1jxy4zPnL4htxPozakKI']//span[contains(text(),'3 сезона') or contains(text(), '5 сезонов') or contains(text(), '7 сезонов')]")).click();
        isElementDisplayed(By.xpath("//a[@href='/shows']//span[1]"));
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL')]")).getText());
        String seasonAndEpisode2 = driver.findElement(By.xpath("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL')]")).getText();
        Assert.assertEquals("отличается сезон", seasonAndEpisode1, seasonAndEpisode2);
    }

    public void checkImageDifferBlockEpisodes() throws IOException {
        // Сделать тестовый скриншот:
        Screenshot screenshotBlockEpisodesPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.className("_1xTt0LaoRnufuGkkLBsCPz")) // игнор область карточки до блока эпизодов
                .addIgnoredElement(By.className("_2YrnCSEViX2PQLwVrBYiS0")) // игнор блок "похожие"
                .addIgnoredElement(By.className("_7LRTnrwDy15pRyA2wKc1m")) // игнор постеров в блоке эпизодов
                .addIgnoredElement(By.xpath("//div[@class='_3RenlHWpqv2tjN53MfarzN']//div[text()]")) // игнор текста табов блока эпизодов
                .addIgnoredElement(By.className("ch-trigger__container")) // игнор блока авторизации
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "blockEpisodesPp4" + ".png");
        ImageIO.write(screenshotBlockEpisodesPp4.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот:
        driver.get("https://web-preprod4.megafon.tv/shows/Neobyknovennyj_plejlist_Zoi_2020/seasons/Neobyknovennyj_plejlist_Zoi_2020_se02");
        Screenshot screenshotBlockEpisodesPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/" + "blockEpisodesPp4Standard" + ".png");
        ImageIO.write(screenshotBlockEpisodesPp4Standard.getImage(), "png", expectedFile1);
        screenshotBlockEpisodesPp4Standard.setIgnoredAreas(screenshotBlockEpisodesPp4.getIgnoredAreas());

//        // Взять старый эталон скриншота:
//        Screenshot screenshotBlockEpisodesPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "blockEpisodesPp4Standard" + ".png")));
//        screenshotBlockEpisodesPp4Standard.setIgnoredAreas(screenshotBlockEpisodesPp4.getIgnoredAreas());

        // Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotBlockEpisodesPp4Standard, screenshotBlockEpisodesPp4);
        System.out.println(diff1.getDiffSize());
        System.out.println(diff1.getDiffImage());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffBlockEpisodesPp4" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 3000);
    }

    public void checkElementsBlockEpisodes() throws InterruptedException {
        isElementDisplayed(By.className("_1hdhJYYoLFCYFGUtF3teH1")); // сам блок эпизодов
        isElementDisplayed(By.xpath("//div[@class='_3RenlHWpqv2tjN53MfarzN']//div[contains(text(), 'Сезон')]")); // табы сезонов
        isElementDisplayed(By.xpath("(//a[@data-test='PackageLink'])[1]")); // тайлы эпизодов
        isElementDisplayed(By.xpath("(//button[contains(@class,'_1wQ5bvvwLY0Ds4jeZwcuiM _2mHCS2K0ddR3OTV1_79IIz')])[1]")); // кнопка скролла

        isElementDisplayed(By.xpath("(//a[@data-test='PackageLink']//div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]")); // постеры эпизодов
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")); // названия эпизодов
        isElementDisplayed(By.xpath("(//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span[text()])[1]")); // номер серий
    }

    public void clickTailEpisode() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void checkOpenPopUpPayment() {
        isElementDisplayed(By.xpath("//h3[text()='Выберите один из вариантов']"));
    }

    public void paymentSerialAtSubsInPoUp() {
        click(By.xpath("(//span[contains(text(),'Подключить бесплатно')])[2]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Подписка')]"));
        click(By.xpath("//button[text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void scrollBlockEpisode() throws InterruptedException {
        // разовый скролл блока эпизодов вправо:
        String tail1Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        System.out.println(tail1Right);
        System.out.println(tail2Right);
        System.out.println(tail3Right);

        click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']"));

        String tail4Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]"));
        System.out.println(tail4Right);
        System.out.println(tail5Right);
        System.out.println(tail6Right);
        Thread.sleep(5000);
        Assert.assertNotEquals(tail1Right, tail4Right);
        Assert.assertNotEquals(tail2Right, tail5Right);
        Assert.assertNotEquals(tail3Right, tail6Right);

        // разовый скролл подборки влево:
        String tail4Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev']"));
        String tail1Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        Thread.sleep(5000);
        Assert.assertNotEquals(tail1Left, tail4Left);
        Assert.assertNotEquals(tail2Left, tail5Left);
        Assert.assertNotEquals(tail3Left, tail6Left);

        // скоролл подборки вправо до упора:
        while (driver.findElements(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext' and @disabled]")).size() < 1) {
            for (int i = 0; i <= 10; i++) {
                click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']"));
            }
        }
        // скоролл подборки вдлево до упора:
        while (driver.findElements(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev' and @disabled]")).size() < 1) {
            for (int i = 0; i <= 10; i++) {
                click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev']"));
            }
        }
    }

}


