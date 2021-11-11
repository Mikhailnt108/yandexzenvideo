package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

public class TvPage extends BasePageWebDriver {
    public TvPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenTvPageTabScheduleTv() {
        isElementDisplayed(By.xpath("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Программа передач']"));
    }

    public void checkColorButtonAllGenres() {
        String color = webDriver.findElement(By.xpath("//a[@href='/tv/tv_guide']")).getCssValue("background-color");
        System.out.println(color);

    }

    public void checkСhannelsСorrespondGenres() throws InterruptedException {
        isElementDisplayed(By.xpath("//span[text()='В записи']"));
        WebElement element = webDriver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[1]"));
        isElementDisplayed(By.xpath("//div[contains(text(),'В записи')]"));
    }

    public void clickToTailCardTvProgram() throws InterruptedException {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/tv/channels/')][4]"));
    }

    public void clickShowAllToTailTvChannelAndCheckOpenCardTvChannel() throws InterruptedException {
        String nameTvChannel = webDriver.findElement(By.xpath("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]")).getText();
        System.out.println(nameTvChannel);
        WebElement element = webDriver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Сегодня']"));
        Assert.assertEquals("открыта карточка другого тв канала", nameTvChannel, webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void clickOnTabTvProgramInAir() throws InterruptedException {
        click(By.xpath("//div[text()='Передачи в эфире']"));
    }

    public void checkElementsTailsTvProgramInAir() throws IOException {

        //проверка отображения простера на всех тайлах:
        List<WebElement> collectTails2 = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_3H6SpMZcck2BFXiKBB5gtC']"));
        for (WebElement poster : collectTails2) {
            String urlImage = poster.getCssValue("background-image");
            Assert.assertEquals("нет постера в тайле", urlImage.contains("tile__web-wp.webp"), true);
            System.out.println(urlImage);
        }

        //проверка отображения прогресс-бара на всех тайлах:
        List<WebElement> progressBars = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//span[@class='L3rzdT7KYzyE1ClBQKxNL']"));
        Assert.assertEquals("не равно количество элементов", 18, progressBars.size());

        //проверка отображения названия тв передачи на всех тайлах:
        List<WebElement> nameTvPrograms = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//h3[@class='hhYBfS5SYd9UjRyn3tWgw']"));
        Assert.assertEquals("не равно количество элементов", 18, nameTvPrograms.size());

        //проверка отображения времени и навзания тв канала на всех тайлах:
        List<WebElement> timeAndNameChannel = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_3jrfnhGV2HAWEcqDrup1qU']"));
        Assert.assertEquals("не равно количество элементов", 18, timeAndNameChannel.size());

        //проверка отображения возрастной маркировки на всех тайлах:
        List<WebElement> ageMarking = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')]"));
        Assert.assertEquals("не равно количество элементов", 18, ageMarking.size());
    }

    public void clickToTailTvProgram() throws InterruptedException {
//        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Thread.sleep(3000);
        click(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC'])[6]"));
    }

    public void clickToglePaymentForOff() throws InterruptedException {
        isElementDisplayed(By.xpath("//button[@class='XUA0mURCPEQ3aaut8nLLA QwZF5ZAhb56XWdU_Hta3z']//div[1]"));
        click(By.xpath("//div[text()='₽']"));
    }

    public void checkTvChannelsOnlyPlugged() throws InterruptedException {
        List<WebElement> CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(3000);
            CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
            CollectionAvailable.get(i).click();
            Thread.sleep(3000);
            Assert.assertEquals(0, webDriver.findElements(By.xpath("(//button[@type='button']//span)[1]")).size());
            webDriver.navigate().back();
        }
    }

    public void clickToTailTvChannel() throws InterruptedException {
        Thread.sleep(3000);
//        waitVisibility(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//img[@alt]"));
        click(By.xpath("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]"));
    }

    public void clickOnTabInRecording() throws InterruptedException {
        Thread.sleep(3000);
//        waitVisibility(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt])[1]"));
        click(By.xpath("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']"));
    }

    public void checkColorButtonChooseGenre() {
        String colorButtonGenre = webDriver.findElement(By.cssSelector("a[class='_3gAIIPQjtWSKeQ00BZcMjA _3Svh8L_4naDJIO2C6fl7oz']")).getCssValue("border-color");
        System.out.println(colorButtonGenre);
        Assert.assertEquals("Кнопка не зелёного цвета", "rgb(0, 185, 86)", colorButtonGenre);
    }

    public void checkUnrecordedСhannelsСorrespondGenres18Plus() throws InterruptedException {
        isElementDisplayed(By.xpath("//span[text()='Эротика']"));
        WebElement element = webDriver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[1]"));
        isElementDisplayed(By.xpath("//div[contains(text(),'Эротика')]"));
    }

    public void clickOnTabErotica() throws Exception {
        click(By.xpath("//button[@class='_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1']"));
        Thread.sleep(2000);
        click(By.xpath("//button[@class='_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1']"));
        Thread.sleep(2000);
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Эротика']"));
    }

    public void checkRecordedСhannelsСorrespondGenres18Plus() throws InterruptedException {
        isElementDisplayed(By.xpath("//span[text()='Эротика']"));
        WebElement element = webDriver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[3]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[3]"));
        isElementDisplayed(By.xpath("//div[contains(text(),'Эротика')]"));
    }

    public void clickOnTabNews() throws Exception {
        Thread.sleep(5000);
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Новости']"));
    }

    public void clickOnTabForKids() throws InterruptedException {
        Thread.sleep(5000);
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Для детей']"));
    }

    public void clickOnTabKino() throws InterruptedException {
        Thread.sleep(5000);
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Кино']"));
    }

    public void checkСhannelsСorrespondGenresNews() throws InterruptedException {
        click(By.xpath("//div[text()='Телеканал 360° Новости']"));
        //isElementDisplayed(By.xpath("//div[contains(text(),'Новости')]"));
    }

    public void clickOnTabHD() throws InterruptedException {
        Thread.sleep(5000);
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='HD']"));
    }

    public void clickToglePaymentForOn() throws InterruptedException {
        click(By.xpath("//div[text()='₽']"));
    }

    public void checkTvChannelsAll() throws InterruptedException {
        List<WebElement> CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(3000);
            CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
            CollectionAvailable.get(i).click();
            Thread.sleep(3000);
            Assert.assertNotEquals(0, webDriver.findElements(By.xpath("(//span[contains(text(),'Смотреть бесплатно')])[1]|(//span[contains(text(),'Подключить бесплатно')])[1]|//span[contains(text(),'Смотреть за')]")).size());
            webDriver.navigate().back();
        }
    }

    public void navigateMouseToToglPaymentOn() {
        WebElement element = webDriver.findElement(By.xpath("//div[text()='₽']"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        Assert.assertNotNull(webDriver.findElement(By.xpath("(//button[@title='Отображаются все телеканалы']//div)[2]")));
    }

    public void navigateMouseToToglePaymentOff() {
        WebElement element = webDriver.findElement(By.xpath("//div[text()='₽']"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        Assert.assertNotNull(webDriver.findElement(By.xpath("(//button[@title='Отображаются только подключенные телеканалы']//div)[2]")));
    }

    public void checkElementsTvPage() throws InterruptedException {
        List<WebElement> tailsTvChannel = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//div[@class='_49iS4BqS64BCC4wpE8GQ7']"));
        System.out.println("количество тайлов " + tailsTvChannel.size());
        System.out.println(webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
        Assert.assertEquals("количество элементов не равно", tailsTvChannel.size(), webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
        System.out.println(webDriver.findElements(By.xpath("//div[@class='_16fO5taSmblh91J9Prw7TV']")).size());
        Assert.assertEquals("количество элементов не равно", tailsTvChannel.size(), webDriver.findElements(By.xpath("//div[@class='_16fO5taSmblh91J9Prw7TV' and text()]")).size());

        System.out.println(webDriver.findElements(By.xpath("//div[@class='_2mLz14ja1zCBwrRv-RM7lg']")).size());
        Assert.assertEquals("количество элементов не равно", tailsTvChannel.size(), webDriver.findElements(By.xpath("//div[@class='_2mLz14ja1zCBwrRv-RM7lg']")).size());
        for (WebElement tail : tailsTvChannel) {
            tail.findElement(By.xpath("//a[@class='_19SojadR5Q0BvNZTu4HCi1']")).getCssValue("font-weight");
            Assert.assertEquals("не соответствует значение", "500", tail.findElement(By.xpath("//a[@class='_19SojadR5Q0BvNZTu4HCi1']")).getCssValue("font-weight"));
        }
        Assert.assertEquals("количество элементов не равно", 3, webDriver.findElements(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]//div[contains(@class,'_30G8CREWABmIqI_RCIwLSb')]")).size());

        String nameTvProgram = webDriver.findElement(By.xpath("(//a[@class='_19SojadR5Q0BvNZTu4HCi1'])[1]")).getText();
        click(By.xpath("//div[text()='Передачи в эфире']"));
        Assert.assertEquals("значение не равно", nameTvProgram, webDriver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText());
    }

    public void clickToLinkTvProgram() throws InterruptedException {
        click(By.xpath("(//a[@class='_19SojadR5Q0BvNZTu4HCi1'])[1]"));
    }

    public void checkGenreInRecordingTvProgramInAir() throws InterruptedException {
        webDriver.navigate().refresh();
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(3000);
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
            Thread.sleep(3000);
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2' and contains(text(),'В записи')]")).size());
            webDriver.navigate().back();
        }
    }

    public void checkGenreHDTvProgramInAir() throws InterruptedException {
        webDriver.navigate().refresh();
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(3000);
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
            Thread.sleep(3000);
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2' and contains(text(),'HD')]")).size());
            webDriver.navigate().back();
        }
    }

    public void checkGenreForKidsTvProgramInAir() throws InterruptedException {
        webDriver.navigate().refresh();
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(3000);
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
            Thread.sleep(3000);
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2' and contains(text(),'Для детей')]")).size());
            webDriver.navigate().back();
        }
    }

    public void checkGenreKinoTvProgramInAir() throws InterruptedException {
        webDriver.navigate().refresh();
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(3000);
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
            Thread.sleep(3000);
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2' and contains(text(),'Кино')]")).size());
            webDriver.navigate().back();
        }
    }

    public void scrollTvPageTabTvProgram() throws InterruptedException {
        // проскроллить страницу вниз до упора:
        JavascriptExecutor jsDown = (JavascriptExecutor) webDriver;
        List <WebElement> tailsTvChannel = webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]"));
        jsDown.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);
        System.out.println(tailsTvChannel.size());
        Assert.assertNotEquals("количество элементов равно", tailsTvChannel.size(), webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
        System.out.println(webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
        List <WebElement> tailsTvChannel2 = webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]"));
        jsDown.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);
        System.out.println(tailsTvChannel2.size());
        Assert.assertNotEquals("количество элементов равно", tailsTvChannel.size(), webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
        System.out.println(webDriver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
    }
}

