package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TvPage extends BasePage {
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

    public void checkСhannelsСorrespondGenres() {
        isElementDisplayed(By.xpath("//span[text()='В записи']"));
        WebElement element = webDriver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[1]"));
        isElementDisplayed(By.xpath("//div[contains(text(),'В записи')]"));
    }

    public void clickToTailCardTvProgram() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/tv/channels/')][4]"));
    }

    public void clickShowAllToTailTvChannelAndCheckOpenCardTvChannel() {
        String nameTvChannel = webDriver.findElement(By.xpath("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]")).getText();
        System.out.println(nameTvChannel);
        WebElement element = webDriver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Сегодня']"));
        Assert.assertEquals("открыта карточка другого тв канала", nameTvChannel, webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void clickOnTabTvProgramInAir() {
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

    public void clickToglePaymentForOff() {
        isElementDisplayed(By.xpath("//button[@class='XUA0mURCPEQ3aaut8nLLA QwZF5ZAhb56XWdU_Hta3z']//div[1]"));
        click(By.xpath("//div[text()='₽']"));
    }

    public void checkTvChannelsOnlyPlugged() {
        List<WebElement> CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
        for (int i = 0; i <= 5; i++) {
            CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
            CollectionAvailable.get(i).click();
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

    public void checkUnrecordedСhannelsСorrespondGenres18Plus() {
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

    public void checkRecordedСhannelsСorrespondGenres18Plus() {
        isElementDisplayed(By.xpath("//span[text()='Эротика']"));
        WebElement element = webDriver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[3]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[3]"));
        isElementDisplayed(By.xpath("//div[contains(text(),'Эротика')]"));
    }

    public void clickOnTabNews() throws Exception {
        waitVisibility(By.xpath("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']"));
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Новости']"));
    }

    public void clickOnTabForKids() {
        waitVisibility(By.xpath("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']"));
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Для детей']"));
    }

    public void clickOnTabKino() {
        waitVisibility(By.xpath("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']"));
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Кино']"));
    }

    public void checkСhannelsСorrespondGenresNews() {
        click(By.xpath("//div[text()='Телеканал 360° Новости']"));
        //isElementDisplayed(By.xpath("//div[contains(text(),'Новости')]"));
    }

    public void clickOnTabHD() {
        waitVisibility(By.xpath("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']"));
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='HD']"));
    }

    public void clickToglePaymentForOn() {
        click(By.xpath("//div[text()='₽']"));
    }

    public void checkTvChannelsAll() {
        List<WebElement> CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
        for (int i = 0; i <= 5; i++) {
            CollectionAvailable = webDriver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
            CollectionAvailable.get(i).click();
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

    public void checkImageDifferTvPageTabProgramTv() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        webDriver.get("https://web-preprod5.megafon.tv/tv");
        Set<By> posterTailsTvChannel = new HashSet<>();
        posterTailsTvChannel.add(By.xpath("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]"));
        Set<By> nameTvChannel = new HashSet<>();
        nameTvChannel.add(By.xpath("//div[@class='_16fO5taSmblh91J9Prw7TV' and text()]"));
        Set<By> timeNameAgeTvProgram = new HashSet<>();
        timeNameAgeTvProgram.add(By.xpath("//div[contains(@class,'_30G8CREWABmIqI_RCIwLSb')]"));
        Screenshot screenshotAllTvPage = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .ignoredElements(posterTailsTvChannel)
                .ignoredElements(nameTvChannel)
                .ignoredElements(timeNameAgeTvProgram)
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/TvPage/" + "allTvPage" + ".png");
        ImageIO.write(screenshotAllTvPage.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот таба программы передач:
//        driver.get("https://web-preprod5.megafon.tv/tv");
//        Screenshot screenshotAllTvPageStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/TvPage/" + "allTvPageStandard" + ".png");
//        ImageIO.write(screenshotAllTvPageStandard.getImage(), "png", expectedFile1);
//        screenshotAllTvPageStandard.setIgnoredAreas(screenshotAllTvPage.getIgnoredAreas());

        // Взять старый эталонный скриншота таба программы передач::
        Screenshot screenshotAllTvPageStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/TvPage/" + "allTvPageStandard" + ".png")));
        screenshotAllTvPageStandard.setIgnoredAreas(screenshotAllTvPage.getIgnoredAreas());

        // Сравнение скриншотов таба программы передач (эталонный и тестовый):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotAllTvPageStandard, screenshotAllTvPage);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/TvPage/" + "diffTvPageAll" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 15);
    }

    public void checkElementsTvPage() {
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

    public void clickToLinkTvProgram() {
        click(By.xpath("(//a[@class='_19SojadR5Q0BvNZTu4HCi1'])[1]"));
    }

    public void checkImageDifferTabTvProgramInAir() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        webDriver.get("https://web-preprod5.megafon.tv/tv/tv_catalog");
        waitVisibility(By.xpath("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']"));
        Screenshot screenshotTabTvProgramInAir = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"))
                .addIgnoredElement(By.xpath("//div[@class='_3NxFENQ0UKNN388aVimz5Y']"))
                .addIgnoredElement(By.xpath("//div[@class='_1RicrqOs_p0d08wcC9-c3G']"))
                .addIgnoredElement(By.xpath("//h3[@class='hhYBfS5SYd9UjRyn3tWgw']"))
                .addIgnoredElement(By.xpath("//div[@class='_2UHpP-xlu9DaTQUbJuPMEF']"))
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/TvPage/" + "tabTvProgramInAir" + ".png");
        ImageIO.write(screenshotTabTvProgramInAir.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот:
//        driver.get("https://web-preprod5.megafon.tv/tv/tv_catalog");
//        Screenshot screenshotTabTvProgramInAirStandard = new AShot()
//                       .coordsProvider(new WebDriverCoordsProvider())
//                       .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/TvPage/"+"tabTvProgramInAirStandard"+".png");
//        ImageIO.write(screenshotTabTvProgramInAirStandard.getImage(), "png", expectedFile1);
//        screenshotTabTvProgramInAirStandard.setIgnoredAreas(screenshotTabTvProgramInAir.getIgnoredAreas());

        // Взять старый эталон скриншота:
        Screenshot screenshotTabTvProgramInAirStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/TvPage/" + "tabTvProgramInAirStandard" + ".png")));
        screenshotTabTvProgramInAirStandard.setIgnoredAreas(screenshotTabTvProgramInAir.getIgnoredAreas());

        // Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotTabTvProgramInAirStandard, screenshotTabTvProgramInAir);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/TvPage/" + "diffTabTvProgramInAir" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 300);
    }

    public void checkGenreInRecordingTvProgramInAir() throws InterruptedException {
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2' and contains(text(),'В записи')]")).size());
            webDriver.navigate().back();
        }
    }

    public void checkGenreHDTvProgramInAir() {
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2' and contains(text(),'HD')]")).size());
            webDriver.navigate().back();
        }
    }

    public void checkGenreForKidsTvProgramInAir() {
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[@class='_364E2xRe8IGMOTfCluwbl2' and contains(text(),'Для детей')]")).size());
            webDriver.navigate().back();
        }
    }

    public void checkGenreKinoTvProgramInAir() {
        waitVisibility(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        List<WebElement> CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTvProgram.size(), webDriver.findElements(By.xpath("//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        for (int i = 0; i <= 5; i++) {
            CollectionTvProgram = webDriver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTvProgram.get(i).click();
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

    public void checkImageDifferToglPaymentOn() throws IOException {
        webDriver.get("https://web-preprod5.megafon.tv/tv");
        Screenshot screenshotTvPageToglPaymentOn = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.className("ch-drop-down__inner"))
                .addIgnoredElement(By.className("_3i74QDPniGqg7-0PwHKYQx"))
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/TvPage/" + "tvPageToglPaymentOn" + ".png");
        ImageIO.write(screenshotTvPageToglPaymentOn.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот:
//        driver.get("https://web-preprod5.megafon.tv/tv");
//        Screenshot screenshotTvPageToglPaymentOnStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/TvPage/"+"tvPageToglPaymentOnStandard"+".png");
//        ImageIO.write(screenshotTvPageToglPaymentOnStandard.getImage(), "png", expectedFile1);
//        screenshotTvPageToglPaymentOnStandard.setIgnoredAreas(screenshotTvPageToglPaymentOn.getIgnoredAreas());

        // Взять старый эталон скриншота:
        Screenshot screenshotTvPageToglPaymentOnStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/TvPage/" + "tvPageToglPaymentOnStandard" + ".png")));
        screenshotTvPageToglPaymentOnStandard.setIgnoredAreas(screenshotTvPageToglPaymentOn.getIgnoredAreas());

        // Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotTvPageToglPaymentOnStandard, screenshotTvPageToglPaymentOn);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/TvPage/" + "diffTvPageToglPaymentOn" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 300);
    }
}

