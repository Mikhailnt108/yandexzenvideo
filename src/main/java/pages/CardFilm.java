package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CardFilm extends BasePage {

    public CardFilm(WebDriver driver) {
        super(driver);
    }
    //String Films_Page = "https://web-preprod1.megafon.tv/movies/vods?only_bundle_prices=1&display_mode=catalog";

    public void checkOpenCardFilm() {
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]"));
    }

    public void paymentFilmAtEst() {
        click(By.xpath("//span[contains(text(), 'Навсегда за')]"));
        isElementDisplayed(By.xpath("//h2[text()='Покупка фильма']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 017 22 79']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void paymentFilmAtEstFromPopUpNotif() {
        isElementDisplayed(By.xpath("//h2[text()='Покупка фильма']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 017 22 79']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Смотреть']")));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void paymentButtonRent2InCardFilm() {
        click(By.xpath("//span[contains(text(), 'На 48 часов за')]"));
        isElementDisplayed(By.xpath("//h2[text()='Аренда фильма на 48 часов']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[contains(text(), 'Смотреть до')]"));
    }


    public void paymentFilmAtRent2Promo() {
        isElementDisplayed(By.xpath("//span[contains(text(),'по акции доступно фильмов: 2')]"));
        click(By.xpath("//span[text()='По акции на 48 часов за 0 ₽']"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'доступен Вам без дополнительной платы')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[contains(text(), 'Смотреть до')]"));
        driver.navigate().back();
        click(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[1]"));

    }

    public void checkСounterAvailableFilms() {
        driver.navigate().refresh();
        Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'по акции доступно фильмов: 1')]")).size());
    }

    public void clickButtonFavorites() {
        click(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[3]"));
        isElementDisplayed(By.xpath("//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB']"));
    }

    public void clickToLikeButton() {
        click(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[1]"));
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'])[1]"));
        //Assert.assertEquals(1, driver.findElements(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'][1])")).size());
    }

    public void clickToDisLikeButton() {
        click(By.xpath("(//button[2]/span)"));
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'])[1]"));
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[2]"));
        //Assert.assertEquals(1, driver.findElements(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'][1])")).size());
        //Assert.assertEquals(1, driver.findElements(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'][2])")).size());
    }


    public void checkStikerDiscount() {
        driver.navigate().refresh();
        isElementDisplayed(By.xpath("//div[text()='Автотест']"));
    }

    public void checkPriseEstDiscount() {
        isElementDisplayed(By.xpath("//span[contains(text(), 'Навсегда за')]/i"));
    }

    public void paymentFilmAtEstDiscount() {
        click(By.xpath("//span[contains(text(), 'Навсегда за')]/i"));
        isElementDisplayed(By.xpath("//h2[text()='Покупка фильма']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void checkUnavailabilityStikerDiscount() {
        Assert.assertEquals(0, driver.findElements(By.xpath("//div[text()='Скидка']")).size());
    }

    public void checkPriseRent2Discount() {
        isElementDisplayed(By.xpath("//span[contains(text(), 'На 48 часов за')]/i"));
    }


    public void paymentFilmAtRent2Discount() {
        click(By.xpath("//span[contains(text(), 'На 48 часов за')]/i"));
        isElementDisplayed(By.xpath("//h2[text()='Аренда фильма на 48 часов']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Смотреть до')]"));
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
        //Assert.assertEquals(time1,time2);
    }


    public void testFullScreenVideoPleer() throws Exception {
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[text()='Продолжить просмотр']"));
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
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
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

    public void moveSliderRewindToVideoPleer() throws Exception {
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

    public void clickPaymentButtonInCardFilm() {
        click(By.xpath("(//button[@type='button']//span)[4]"));
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
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));
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

    public void checkImageDifferCardFilm() throws IOException {
        // Сделать тестовый скриншот:
        Screenshot screenshotCardFilmPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']")) // игнор область плеера
                .addIgnoredElement(By.className("_36y3ZYWoC7rVzn6TEPp4oC")) // игнор текст описания
                .addIgnoredElement(By.className("_1v_D6wOANknQeJMBPo_rKK")) // игнор название фильма
                .addIgnoredElement(By.className("KQ2rb7ZP-tTmXFu9sn_34")) // игнотр блока рейтингов кинопоиск и IMDb
//                .addIgnoredElement(By.className("VJDIK5T7v2knDWeIbc1df")) // игнор цифры рейтинга кинопоиск/IMDb
                .addIgnoredElement(By.className("GRbXWlAwTd4ARHYlo21od")) // игнор количества лайков
                .addIgnoredElement(By.className("GRbXWlAwTd4ARHYlo21od")) // игнор количества дизлайков
                .addIgnoredElement(By.className("_1v_D6wOANknQeJMBPo_rKK")) // игнор возраст, год выпуска, жанр.
                .addIgnoredElement(By.className("kjFUbLahFxqq2AjHY8j2R")) // игнор плашки "новинка"
                .addIgnoredElement(By.className("_1Kps2hNPLZGQ3H2Sf5NYID")) // игнор текста в кнопке покупки
                .addIgnoredElement(By.xpath("(//span[@itemprop='name'])[3]")) // игнор названия фильма в хлебных крошках
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "cardFilmPp4" + ".png");
        ImageIO.write(screenshotCardFilmPp4.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот:
        driver.get("https://web-preprod4.megafon.tv/movies/vods/Robot_ya_lyublyu_tebya_2021");
        Screenshot screenshotCardFilmPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/"+"cardFilmPp4Standard"+".png");
        ImageIO.write(screenshotCardFilmPp4Standard.getImage(), "png", expectedFile1);
        screenshotCardFilmPp4Standard.setIgnoredAreas(screenshotCardFilmPp4.getIgnoredAreas());

//        // Взять старый эталон скриншота:
//        Screenshot screenshotCardFilmPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "cardFilmPp4Standard" + ".png")));
//        screenshotCardFilmPp4Standard.setIgnoredAreas(screenshotCardFilmPp4.getIgnoredAreas());

        // Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCardFilmPp4Standard, screenshotCardFilmPp4);
        System.out.println(diff1.getDiffSize());
        System.out.println(diff1.getDiffImage());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCardFilmPp4" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 3000);
    }

}


