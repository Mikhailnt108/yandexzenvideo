package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        click(By.xpath("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 020 50 27']|//span[text()='+7 926 017 22 79']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void paymentFilmAtEstFromPopUpNotif() {
        isElementDisplayed(By.xpath("//h2[text()='Покупка фильма']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 020 50 27']|//span[text()='+7 926 017 22 79']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Смотреть']")));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void paymentButtonRent2InCardFilm() {
        click(By.xpath("//span[contains(text(), 'На 48 часов за')]"));
        isElementDisplayed(By.xpath("//h2[text()='Аренда фильма на 48 часов']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 020 50 27']|//span[text()='+7 926 017 22 79']"));
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
    }

    public void checkСounterAvailableFilms() {
        webDriver.navigate().back();
        click(By.xpath("(//a[@data-test='PackageLink'])[2]"));
        webDriver.navigate().refresh();
        Assert.assertEquals(1, webDriver.findElements(By.xpath("//span[contains(text(),'по акции доступно фильмов: 1')]")).size());
    }

    public void clickButtonFavorites() {
        click(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[3]"));
        isElementDisplayed(By.xpath("//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB']"));
    }

    public void checkButtonFavoriteNotAdded() {
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[3]"));
        String colorButtonFavoriteNotAdded = webDriver.findElement(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK'])[3]")).getCssValue("color");
        System.out.println(colorButtonFavoriteNotAdded);
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorButtonFavoriteNotAdded);
    }

    public void checkButtonFavoriteAdded() {
        String colorButtonFavoriteAdded = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[3]")).getCssValue("color");
        System.out.println(colorButtonFavoriteAdded);
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorButtonFavoriteAdded);
    }

    public void moveToLikeButton() {
        String colorToLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToLike);
        String colorToCountLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToCountLike);
        // навести курсор на кнопку лайк:
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]"))).build().perform();
        String colorMoveToButtonLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorMoveToButtonLike);
        String colorMoveToCountLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorMoveToCountLike);
    }

    public void moveToDisLikeButton() {
        String colorToDisLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToDisLike);
        String colorToCountDisLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToCountDisLike);
        // навести курсор на кнопку дизлайк:
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]"))).build().perform();
        String colorMoveToButtonDisLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorMoveToButtonDisLike);
        String colorMoveToCountDisLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorMoveToCountDisLike);
    }

    public void clickToLikeButton() throws InterruptedException {
        WebElement countLikeOld = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int oldCount = Integer.parseInt(countLikeOld.getText());
        String colorToLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToLike);
        String colorToCountLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToCountLike);
        click(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]"));
        Thread.sleep(3000);
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'])[1]"));
        webDriver.navigate().refresh();
        WebElement countLikeNew = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int newCount = Integer.parseInt(countLikeNew.getText());
        Assert.assertTrue(oldCount < newCount);
        String colorMoveToButtonLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(38, 38, 38, 1)",colorMoveToButtonLike);
        String colorMoveToCountLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(38, 38, 38, 1)",colorMoveToCountLike);
    }

    public void clickToDisLikeButton() throws InterruptedException {
        WebElement countDisLikeOld = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]"));
        int oldCountDisLike = Integer.parseInt(countDisLikeOld.getText());
        WebElement countLikeOld = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int oldCountLike = Integer.parseInt(countLikeOld.getText());
        String colorToDisLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToDisLike);
        String colorToCountDisLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(153, 153, 153, 1)",colorToCountDisLike);
        click(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]"));
        Thread.sleep(3000);
        isElementDisplayed(By.xpath("(//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB'])[1]"));
        isElementDisplayed(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[1]"));
        webDriver.navigate().refresh();
        WebElement countDisLikeNew = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]"));
        int newCountDisLike = Integer.parseInt(countDisLikeNew.getText());
        Assert.assertTrue(oldCountDisLike < newCountDisLike);
        WebElement countLikeNew = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[1]"));
        int newCountLike = Integer.parseInt(countLikeNew.getText());
        Assert.assertTrue(oldCountLike > newCountLike);
        String colorMoveToButtonDisLike = webDriver.findElement(By.xpath("(//button[contains(@class,'_3TTcTpw6F5NxpSgIqK8AbK')])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(38, 38, 38, 1)",colorMoveToButtonDisLike);
        String colorMoveToCountDisLike = webDriver.findElement(By.xpath("(//span[@class='GRbXWlAwTd4ARHYlo21od'])[2]")).getCssValue("color");
        Assert.assertEquals("Не тот цвет","rgba(38, 38, 38, 1)",colorMoveToCountDisLike);
    }

    public void checkStikerDiscount() {
        webDriver.navigate().refresh();
        isElementDisplayed(By.xpath("//div[text()='Автотест']"));
    }

    public void checkPriseEstDiscount() {
        isElementDisplayed(By.xpath("//span[contains(text(), 'Навсегда за')]/i"));
    }

    public void paymentFilmAtEstDiscount() {
        click(By.xpath("//span[contains(text(), 'Навсегда за')]/i"));
        isElementDisplayed(By.xpath("//h2[text()='Покупка фильма']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 020 50 27']|//span[text()='+7 926 017 22 79']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));
    }

    public void checkUnavailabilityStikerDiscount() {
        Assert.assertEquals(0, webDriver.findElements(By.xpath("//div[text()='Скидка']")).size());
    }

    public void checkPriseRent2Discount() {
        isElementDisplayed(By.xpath("//span[contains(text(), 'На 48 часов за')]/i"));
    }


    public void paymentFilmAtRent2Discount() {
        click(By.xpath("//span[contains(text(), 'На 48 часов за')]/i"));
        isElementDisplayed(By.xpath("//h2[text()='Аренда фильма на 48 часов']"));
        click(By.xpath("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 020 50 27']|//span[text()='+7 926 017 22 79']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Смотреть до')]"));
    }

    public void startVideoPleer() throws Exception {
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println(time1);
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println(time2);
        Assert.assertNotEquals(time1, time2);
    }


    public void testFullScreenVideoPleer() throws Exception {
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[text()='Продолжить просмотр']"));
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//div[@data-for='FullScreenButton']"));
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@data-for='FullScreenButton']"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='Выйти из полноэкранного режима']"));
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println(time1);
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();

        click(By.xpath("//div[@data-for='FullScreenButton']"));
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@data-for='FullScreenButton']"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='На весь экран']"));
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //System.out.println(time2);
        Assert.assertNotEquals(time1, time2);
    }

    public void clickToPauseVideoPleer() throws Exception {
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        System.out.println("time1 " + time1);
        Thread.sleep(7000);
        //нажал на паузу - видео остановилось
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //System.out.println("time2 "+ time2);
        Assert.assertNotEquals(time1, time2);
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time3 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //System.out.println("time3 "+ time3);
        Assert.assertEquals(time2, time3);

    }

    public void clickToPlayVideoPleer() throws Exception {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time4 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        //нажал на плей - видео запустилось
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time5 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time4, time5);
        Thread.sleep(7000);


    }

    public void clickToSpaceToVideoPleer() throws Exception {
        Actions actions = new Actions(webDriver);
        //нажал на пробел - видео остановилось
        actions.sendKeys(Keys.chord(Keys.SPACE)).perform();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time6 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time7 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time6, time7);
        //нажал на пробел - видео запустилось
        actions.sendKeys(Keys.chord(Keys.SPACE)).perform();
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time8 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time7, time8);
    }

    public void clickToLeftButtonMouseToVideoPleer() throws Exception {
        Actions actions = new Actions(webDriver);
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        //нажал на левую клавишу мыши - видео остановилось
        click(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"));
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time9 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time10 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time9, time10);
        //нажал на левую клавишу мыши - видео запустилось
        click(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"));
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time11 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time10, time11);
    }

    public void moveSliderRewindToVideoPleer() throws Exception {
        Actions actions = new Actions(webDriver);
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = webDriver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        //WebElement target = driver.findElement(By.id("container"));
        //new Actions(driver).dragAndDrop(slider, target).perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 450, 0).perform();
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void clickPaymentButtonInCardFilm() {
        click(By.xpath("(//button[@type='button']//span)[4]"));
    }

    public void checkTimeStopPleer() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time3 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        webDriver.navigate().back();
        //Кликнуть на тайл этого фильма в подборке "Продолжить просмотр"
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        Thread.sleep(2000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time4 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time3, time4);
    }

    public void moveSliderRewindToVideoPleer18Plus() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        //нажал "Смотреть" - видео запустилось
        click(By.xpath("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]"));
        click(By.xpath("//button[text()='Да']"));
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = webDriver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        //WebElement target = driver.findElement(By.id("container"));
        //new Actions(driver).dragAndDrop(slider, target).perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 450, 0).perform();
        Thread.sleep(7000);
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void checkImageDifferCardFilm() throws IOException {
        // Сделать тестовый скриншот:
        Screenshot screenshotCardFilm = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.className("_3oIAMUjIv-QAdeSq_k6cql")) // игнор область плеера
                .addIgnoredElement(By.className("_36y3ZYWoC7rVzn6TEPp4oC")) // игнор текст описания
                .addIgnoredElement(By.className("_1v_D6wOANknQeJMBPo_rKK")) // игнор название фильма
                .addIgnoredElement(By.className("KQ2rb7ZP-tTmXFu9sn_34")) // игнотр блока рейтингов кинопоиск и IMDb
                .addIgnoredElement(By.className("GRbXWlAwTd4ARHYlo21od")) // игнор количества лайков
                .addIgnoredElement(By.className("GRbXWlAwTd4ARHYlo21od")) // игнор количества дизлайков
                .addIgnoredElement(By.className("_1v_D6wOANknQeJMBPo_rKK")) // игнор возраст, год выпуска, жанр.
                .addIgnoredElement(By.className("kjFUbLahFxqq2AjHY8j2R")) // игнор плашки "новинка"
                .addIgnoredElement(By.className("_1Kps2hNPLZGQ3H2Sf5NYID")) // игнор текста в кнопке покупки
                .addIgnoredElement(By.className("_1-ZY27a7Isb9dohjRr0mXq")) // игнор хлебных крошек
                .addIgnoredElement(By.className("_2YrnCSEViX2PQLwVrBYiS0")) // игнор блок "похожие"
                .addIgnoredElement(By.className("ch-trigger__container")) // игнор блока авторизации
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "cardFilm" + ".png");
        ImageIO.write(screenshotCardFilm.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот:
//        Screenshot screenshotCardFilmStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/"+"cardFilmStandard"+".png");
//        ImageIO.write(screenshotCardFilmStandard.getImage(), "png", expectedFile1);
//        screenshotCardFilmStandard.setIgnoredAreas(screenshotCardFilm.getIgnoredAreas());

        // Взять старый эталон скриншота:
        Screenshot screenshotCardFilmStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "cardFilmStandard" + ".png")));
        screenshotCardFilmStandard.setIgnoredAreas(screenshotCardFilm.getIgnoredAreas());

        // Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCardFilmStandard, screenshotCardFilm);
        System.out.println(diff1.getDiffSize());
        System.out.println(diff1.getDiffImage());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCardFilm" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 3000);
    }

    public void checkAutoStartVideoPlayer() throws Exception {
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void checkElementsCardFilm() {
        isElementDisplayed(By.className("_3oIAMUjIv-QAdeSq_k6cql")); // область плеера
        isElementDisplayed(By.xpath("//button[text()='Трейлер']")); // кнопка трейлер
        isElementDisplayed(By.className("_36y3ZYWoC7rVzn6TEPp4oC")); // текст описания
        isElementDisplayed(By.xpath("//button[text()='Прочитать описание']")); // кнопка "прочитать описание"

        isElementDisplayed(By.className("_3v-cosMJBw3_KSQoU9M3Mq")); // блок плашек "новинка" и "full hd"
        isElementDisplayed(By.className("_1v_D6wOANknQeJMBPo_rKK")); // название фильма
        isElementDisplayed(By.className("KQ2rb7ZP-tTmXFu9sn_34")); // блок рейтингов "кинопоиск" и "IMDb"
        isElementDisplayed(By.className("_1v_D6wOANknQeJMBPo_rKK")); // возраст, год выпуска, жанр
        isElementDisplayed(By.className("_23uR5oR4uHT0fJvmMxNxmS")); // блок кнопкок: лайк, дизлайк, избранное
        isElementDisplayed(By.className("_3ENPoHW7mBDX2n9ySpuZTE")); // блок кнопко покупки
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
        Assert.assertEquals("Текст описания не свернулся", 0, webDriver.findElements(By.xpath("//button[text()='Свернуть']")).size());
    }


}


