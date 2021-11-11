package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardTvProgram extends BasePageWebDriver {
    public CardTvProgram(WebDriver driver) {
        super(driver);
    }
    String NIL_Page_PP3 = "https://web-preprod3.megafon.tv/";
    String NIL_Page_PP4 = "https://web-preprod4.megafon.tv/";
    String NIL_Page_PP6 = "https://web-preprod6.megafon.tv/";
    public void checkOpenCardTvProgram() throws InterruptedException {
        Thread.sleep(3000);
        isElementDisplayed(By.xpath("(//a[@href='/tv']//span[1])"));
    }
    public void clickPaymentButtonInCardTvProgram() throws InterruptedException {
        if(webDriver.findElements(By.xpath("(//button[@type='button']//span)[1]")).size()>0){
        click(By.xpath("(//button[@type='button']//span)[1]"));
        }
    }

    public void checkPaymentComplete() throws InterruptedException {
        if(webDriver.findElements(By.xpath("//h3[contains(text(), 'Подписка на пакет')]|//h3[contains(text(),'Подключение услуги')]")).size()==1){
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));}
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

    public void clickButtonFavorite() throws InterruptedException {
        isElementDisplayed(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
        click(By.xpath("(//button[@class='_1OuDMhv3SzdZRyhRGbhkr-'])[1]"));
    }
    public void clickToLinkCardPackage() throws InterruptedException {click(By.linkText("Максимальный")); }

    public void clickToPauseVideoPleer() throws Exception {
        Thread.sleep(7000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        //нажал на паузу - видео остановилось
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time3 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
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
        Thread.sleep(7000);
        //нажал на левую клавишу мыши - видео остановилось
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).click().build().perform();
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).click().build().perform();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time9 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Thread.sleep(7000);
        String time10 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time9, time10);
        //нажал на левую клавишу мыши - видео запустилось
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).click().build().perform();
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time11 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time10, time11);
    }

    public void clickOnLinkTvProgramInRecording() throws InterruptedException {
        click(By.xpath("(//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF'])[1]"));
    }

    public void moveSliderRewindToVideoPlayer() throws Exception {
        Actions actions = new Actions(webDriver);
        Thread.sleep(7000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        WebElement slider = webDriver.findElement(By.xpath("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]"));
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        actions.dragAndDropBy(slider, 450, 0).perform();
        Thread.sleep(15000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        Thread.sleep(5000);
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
        Thread.sleep(7000);
    }

    public void rewindOn10secondsToVideoPleer() throws InterruptedException {
        //перемотка на 10 секунд вперёд:
        Actions actions = new Actions(webDriver);
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time1 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[3]"));
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time2 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time1, time2);
        //перемотка на 10 секунд назад:
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time3 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[2]"));
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        String time4 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertNotEquals(time3, time4);
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

    public void clickNoInPopUp18Plus() throws InterruptedException {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Нет']"));
        isElementDisplayed(By.xpath("(//button[@type='button'])[1]"));
    }

    public void goToCardTvProgram18Plus() throws InterruptedException {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
    }

    public void clickToButtonPlay() throws InterruptedException {
        click(By.className("_2fPMOlJJX5DRkSEypQ3sLc"));
    }

    public void checkTimeStopPleer() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        //автозапуск тв-передачи:
        Thread.sleep(30000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time3 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        webDriver.get(NIL_Page_PP3);
        //Кликнуть на тайл этого фильма в подборке "Продолжить просмотр"
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/tv/channels/')])[1]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]")));
        click(By.xpath("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]"));
        Thread.sleep(3000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']"));
        String time4 = webDriver.findElement(By.xpath("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]")).getText();
        Assert.assertEquals(time3, time4);
    }

    public void checkElementsInCardTvProgram() {
        isElementDisplayed(By.className("_1rev14Qo58_GNSeeC-Rh2V"));
        isElementDisplayed(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
        isElementDisplayed(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]"));
        isElementDisplayed(By.className("_3DKCWpmCv7Gf2hQA0mQQ2g"));
        isElementDisplayed(By.xpath("//ol[contains(@class,'_1-ZY27a7Isb9dohjRr0mXq')]"));
        isElementDisplayed(By.className("_1v_D6wOANknQeJMBPo_rKK"));
        isElementDisplayed(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'])[1]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_39Yp8LSFDnN1PnBG2_NFLL')]"));
        isElementDisplayed(By.xpath("//div[contains(@class,'_2e92e-_RzKCZ4VypEl02Kj')]"));
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

    public void checkButtonFavoriteAdded() {
        String colorButtonFavoriteAdded = webDriver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-]")).getCssValue("background-color");
        System.out.println(colorButtonFavoriteAdded);
        Assert.assertEquals("Не тот цвет","rgba(51, 51, 51, 1)",colorButtonFavoriteAdded);
        isElementDisplayed(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg"));
        String colorIconFavoriteAdded = webDriver.findElement(By.cssSelector("button[class=_1OuDMhv3SzdZRyhRGbhkr-] > svg > path[fill]")).getCssValue("fill");
        System.out.println(colorIconFavoriteAdded);
        Assert.assertEquals("Не тот цвет","rgb(255, 255, 255)",colorIconFavoriteAdded);
    }

    public void clickOnTvChannelInCardProgram() throws InterruptedException {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
    }

    public void checkElementsPlayerUnrecordedTvProgram() {
//        driver.get("https://web-preprod3.megafon.tv/tv/channels/Channel_Rossia24/");
//        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        isElementDisplayed(By.className("_2GPoEznIkBV65Iqkud1teP"));
        isElementDisplayed(By.xpath("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']"));
        Assert.assertEquals("не совпадает число элемеантов", 2, webDriver.findElements(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']")).size());
    }

    public void checkElementsPlayerRecordedTvProgram() {
        webDriver.navigate().refresh();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        isElementDisplayed(By.className("_2GPoEznIkBV65Iqkud1teP"));
        isElementDisplayed(By.xpath("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']"));
        Assert.assertEquals("не совпадает число элементов", 7, webDriver.findElements(By.xpath("//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk']")).size());
    }


    public void testFullScreenPlayer() throws InterruptedException {
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

    public void testOnAndOffAudioInPlayer() throws InterruptedException {
        //включить звук:
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        actions.moveToElement(webDriver.findElement(By.className("_1esD56qNtjqeNN5gjleArE"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='Включить звук']"));
        click(By.className("_1esD56qNtjqeNN5gjleArE"));
        System.out.println(webDriver.findElement(By.cssSelector("div[class='_3uP0ihiEVqMOuIXkcIlhiL']")).getCssValue("width"));
//        Assert.assertEquals("звук не включен", "47%", driver.findElement(By.xpath("//div[@class='_3TlgpcuUvhiTmYXuvW6X6I' and @style]")).getCssValue("width"));

        //отключить звук:
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        isElementDisplayed(By.className("_1esD56qNtjqeNN5gjleArE"));
        actions.moveToElement(webDriver.findElement(By.className("_1esD56qNtjqeNN5gjleArE"))).build().perform();
        isElementDisplayed(By.xpath("//div[text()='Отключить звук']"));
        click(By.className("_1esD56qNtjqeNN5gjleArE"));
        Thread.sleep(5000);
        System.out.println(webDriver.findElement(By.cssSelector("div[class='_3uP0ihiEVqMOuIXkcIlhiL']")).getCssValue("width"));

//        Assert.assertEquals("звук не отключен", "0%", driver.findElement(By.xpath("(//div[@class='_3uP0ihiEVqMOuIXkcIlhiL'])[1]")).getCssValue("width"));
    }

    public void clickOnScheduleInPlayerUnrecordedAndCheckeElements() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[1]"));
        Thread.sleep(2000);
        isElementDisplayed(By.xpath("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[text()='Сегодня']"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='_2F06JEFCaBoh-jQ-JAfmAN'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='DSoUWlplI4m8T5WSf-XxC'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')])[1]"));
    }

    public void clickOnScheduleInPlayerInRecordedAndCheckeElements() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]"));
        Thread.sleep(5000);
        isElementDisplayed(By.xpath("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[text()='Сегодня']"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='_2F06JEFCaBoh-jQ-JAfmAN'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[@class='DSoUWlplI4m8T5WSf-XxC'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3Pw3DImx_GWRGGCEPoHcED']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')])[1]"));
        Assert.assertEquals("не тот цвет элемента", "rgba(0, 185, 86, 1)", webDriver.findElement(By.xpath("(//div[@class='_9zLB0lWoiPV1ec0DJCkgd'])[1]")).getCssValue("color"));
        isElementDisplayed(By.xpath("(//div[@class='_2TfjWnFcko5fM6N6iIDjho'])[1]"));
    }

    public void swithOtherTvChannelInsidePlayerForRecording() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(webDriver);
        String nameTvChannel = webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        Thread.sleep(3000);
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[position()=33]"));
        Thread.sleep(3000);
        System.out.println(webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
        Assert.assertNotEquals("канал не переключен", nameTvChannel, webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
    }

    public void swithOtherTvProgramInsidePlayerCarousel() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        Thread.sleep(5000);
        String nameTvProgram = webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText();
        // нажать на перемотку "вперёд" (перекл на следующую передачу):
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[5]"));
        Thread.sleep(3000);
        Assert.assertNotEquals("передача не переключена", nameTvProgram, webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
        String nameTvProgram2 = webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText();
        // нажать на перемотку "назад" (перекл на предыдущую передачу):
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//button[@type='button' and @class='_1y2MwvAuO97Xb0-8ccbmkk'])[4]"));
        Thread.sleep(3000);
        Assert.assertNotEquals("передача не переключена", nameTvProgram2, webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
        Thread.sleep(3000);
    }

    public void clickOnLinkNextTvProgramInRecording() throws InterruptedException {
        String nameTvProgram = webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText();
        click(By.xpath("(//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF'])[1]"));
        Assert.assertNotEquals("передача не переключена", nameTvProgram, webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void checkOpenPopUp18plus() {
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
    }

    public void clickOnPlayInPlayer() throws InterruptedException {
        isElementDisplayed(By.xpath("(//button[@type='button'])[1]"));
        click(By.xpath("(//button[@type='button'])[1]"));
    }

    public void checkAbsentPopUp18plus() {
        Assert.assertEquals("есть попап 18+", 0, webDriver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']")).size());
    }

    public void swithOnTvProgramNon18plusInsidePlayer() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(webDriver);
        String genreTvChannel = webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]")).getText();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[4]"));
        Thread.sleep(3000);
        webDriver.navigate().refresh();
        Assert.assertNotEquals("канал не переключен", genreTvChannel, webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]")).getText());
    }

    public void swithOnUnrecordedTvChannel18PlusInsidePlayer() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(webDriver);
        String genreTvChannel = webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]")).getText();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//div[@class='_3rG-uZRT_8O5npnrboEkUD'])[1]"));
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Да']"));
        Thread.sleep(3000);
        Assert.assertNotEquals("канал не переключен", genreTvChannel, webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]")).getText());
    }

    public void swithOnRecordedTvChannel18PlusInsidePlayer() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(webDriver);
        String genreTvChannel = webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]")).getText();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//div[@class='_3rG-uZRT_8O5npnrboEkUD'])[1]"));
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[2]"));
        Thread.sleep(3000);
        Assert.assertNotEquals("канал не переключен", genreTvChannel, webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]")).getText());
    }

    public void swithOnRecordedTvChannel18PlusInsidePlayer2() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        String genreTvChannel = webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]")).getText();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        click(By.xpath("(//div[@class='_3rG-uZRT_8O5npnrboEkUD'])[1]"));
        click(By.xpath("(//div[@class='_3rG-uZRT_8O5npnrboEkUD'])[1]"));
        click(By.xpath("(//div[@class='_3rG-uZRT_8O5npnrboEkUD'])[1]"));
        Thread.sleep(3000);
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[2]"));
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        click(By.xpath("//button[text()='Да']"));
        Thread.sleep(3000);
        Assert.assertNotEquals("канал не переключен", genreTvChannel, webDriver.findElement(By.xpath("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]")).getText());
    }

    public void switchOtherTvProgramInsidePleerSchedule() throws Exception {
        String nameTvProgram = webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText();
        click(By.xpath("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']"));
        Thread.sleep(3000);
        Assert.assertNotEquals("передача не переключена", nameTvProgram, webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void swithOtherTvChannelInsidePlayerForUnrecorded() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(webDriver);
        String nameTvChannel = webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']"))).build().perform();
        Thread.sleep(3000);
        click(By.xpath("(//div[@class='oog6D4ljOTvbih-_NivDx'])[3]"));
        System.out.println(webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
        Assert.assertNotEquals("канал не переключен", nameTvChannel, webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
    }
}
      
