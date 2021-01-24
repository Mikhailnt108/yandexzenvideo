package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CardFilm extends BasePage {
    private Object Date;

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
        click(By.xpath("//span[text()='+7 926 019 21 44']"));
        isElementDisplayed(By.xpath("//h1[contains(text(), 'Подтверждение оплаты фильма')]"));
        click(By.xpath("//span[text()='Подтвердить']"));
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
        actions.dragAndDropBy(slider, 155, 0).perform();
        Thread.sleep(7000);
        String time2 = driver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
    }

    public void clickPaymentButtonInCardFilm() {
        click(By.xpath("(//button[@type='button']//span)[4]"));
    }
}

