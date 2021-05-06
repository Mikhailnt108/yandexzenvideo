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
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

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

    public void checkOpenTabTvPageSchedule() {
        isElementDisplayed(By.xpath("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Программа передач']"));
    }

    public void checkColorButtonAllGenres() {
        String color = driver.findElement(By.xpath("//a[@href='/tv/tv_guide']")).getCssValue("background-color");
        System.out.println(color);

    }

    public void checkСhannelsСorrespondGenres() {
        isElementDisplayed(By.xpath("//span[text()='В записи']"));
        WebElement element = driver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[1]"));
        isElementDisplayed(By.xpath("//div[contains(text(),'В записи')]"));
    }

    public void clickToTailCardTvProgram() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/tv/channels/')][4]"));
    }

    public void clickShowAllToTailCardTvChannel() {

        WebElement element = driver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[1]"));
        isElementDisplayed(By.xpath("//div[text()='Сегодня']"));
    }

    public void clickOnTabTvProgramInAir() {
        click(By.xpath("//div[text()='Передачи в эфире']"));
    }

    public void checkAllTvProgramInAir() {
        List<WebElement> tails = driver.findElements(By.xpath("//div[@class='_6wQglJGVD-_mrTQLT_Ul7']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));

        for (WebElement tail : tails) {
            tail.findElement(By.xpath("//span[@class='L3rzdT7KYzyE1ClBQKxNL']"));
        }
    }


    public void clickToTailTvProgram() {
        //click(By.linkText("Кино"));
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Кино']"));
        isElementDisplayed(By.xpath("//span[text()='Кино']"));
        click(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC'])[1]"));
    }

    public void clickToglPaymentForOff() {
        isElementDisplayed(By.xpath("//button[@class='XUA0mURCPEQ3aaut8nLLA QwZF5ZAhb56XWdU_Hta3z']//div[1]"));
        click(By.xpath("//div[text()='₽']"));
    }

    public void checkTvChannelsOnlyAvailable() {
        List<WebElement> CollectionAvailable = driver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
        Assert.assertEquals(CollectionAvailable.size(), driver.findElements(By.xpath("//div[@class='_2mLz14ja1zCBwrRv-RM7lg']")).size());
        for (int i = 0; i <= 5; i++) {
            CollectionAvailable = driver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
            CollectionAvailable.get(i).click();
            Assert.assertEquals(0, driver.findElements(By.xpath("(//button[@type='button']//span)[1]")).size());
            //Assert.assertNull(driver.findElement(By.xpath("(//span[contains(text(), 'Смотреть'])[1]")));
            driver.navigate().back();
        }
    }

    public void clickToTailTvChannel() {
        click(By.xpath("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]"));
    }
    //(//a[@class='_19SojadR5Q0BvNZTu4HCi1'])[1]

    public void clickOnTabInRecording() {
        click(By.xpath("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']"));
    }

    public void checkColorButtonChooseGenre() {
        String colorButtonGenre = driver.findElement(By.cssSelector("a[class='_3gAIIPQjtWSKeQ00BZcMjA _3Svh8L_4naDJIO2C6fl7oz']")).getCssValue("border-color");
        System.out.println(colorButtonGenre);
        Assert.assertEquals("Кнопка не зелёного цвета", "rgb(0, 185, 86)", colorButtonGenre);
    }

    public void checkUnrecordedСhannelsСorrespondGenres18Plus() {
        isElementDisplayed(By.xpath("//span[text()='Эротика']"));
        WebElement element = driver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]"));
        Actions actions = new Actions(driver);
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
        WebElement element = driver.findElement(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        click(By.xpath("(//a[.='Показать все'])[3]"));
        isElementDisplayed(By.xpath("//div[contains(text(),'Эротика')]"));
    }

    public void clickOnTabNews() throws Exception {
        click(By.xpath("//button[@class='_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1']"));
        Thread.sleep(2000);
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='Новости']"));
    }

    public void checkСhannelsСorrespondGenresNews() {
        click(By.xpath("//div[text()='Телеканал 360° Новости']"));
        //isElementDisplayed(By.xpath("//div[contains(text(),'Новости')]"));
    }

    public void clickOnTabHD() {
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='HD']"));
    }

    public void clickToglPaymentForOn() {
        click(By.xpath("//div[text()='₽']"));
    }

    public void checkTvChannelsOnlyPayment() {
        List<WebElement> CollectionAvailable = driver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
        Assert.assertEquals(0, driver.findElements(By.xpath("//div[@class='_2mLz14ja1zCBwrRv-RM7lg']")).size());
        for (int i = 0; i <= 5; i++) {
            CollectionAvailable = driver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//a[@class='PEjJzf6sWszN-NzQn1eqH']"));
            CollectionAvailable.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("(//button[@type='button']//span)[1]")).size());
            //Assert.assertNull(driver.findElement(By.xpath("(//span[contains(text(), 'Смотреть'])[1]")));
            driver.navigate().back();
        }
    }

    public void navigateMouseToToglPaymentOn() {
        WebElement element = driver.findElement(By.xpath("//div[text()='₽']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Assert.assertNotNull(driver.findElement(By.xpath("(//button[@title='Отображаются все телеканалы']//div)[2]")));
    }

    public void navigateMouseToToglPaymentOff() {
        WebElement element = driver.findElement(By.xpath("//div[text()='₽']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Assert.assertNotNull(driver.findElement(By.xpath("(//button[@title='Отображаются только доступные телеканалы']//div)[2]")));
    }

    public void checkImageDifferTvPage() throws IOException, InterruptedException {
        driver.get("https://web-preprod5.megafon.tv/tv");
        //проскроллить страницу вниз до упора:
        JavascriptExecutor jsDown = (JavascriptExecutor) driver;
        jsDown.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);
        jsDown.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);
        jsDown.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);

        //проскроллить страницу вверх до упора:
        JavascriptExecutor jsUp = (JavascriptExecutor) driver;
        jsUp.executeScript("window.scrollTo(50000, 0);");

        Set<By> posterTailsTvChannel = new HashSet<>();
        posterTailsTvChannel.add(By.xpath("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]"));
        Set<By> nameTvChannel = new HashSet<>();
        nameTvChannel.add(By.xpath("//div[@class='_16fO5taSmblh91J9Prw7TV' and text()]"));
        Set<By> timeNameAgeTvProgram = new HashSet<>();
        timeNameAgeTvProgram.add(By.xpath("//div[contains(@class,'_30G8CREWABmIqI_RCIwLSb')]"));
        Screenshot screenshotAllTvPagePp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(1))
                .ignoredElements(posterTailsTvChannel)
                .ignoredElements(nameTvChannel)
                .ignoredElements(timeNameAgeTvProgram)
                .takeScreenshot(driver);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/TvPage/" + "allTvPagePp5" + ".png");
        ImageIO.write(screenshotAllTvPagePp5.getImage(), "png", actualFile1);

        driver.get("https://web-preprod5.megafon.tv/tv");
        //проскроллить страницу вниз до упора:
        JavascriptExecutor jsDown2 = (JavascriptExecutor) driver;
        jsDown2.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);
        jsDown2.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);
        jsDown2.executeScript("window.scrollTo(0, 25000);");
        Thread.sleep(5000);

        //проскроллить страницу вверх до упора:
        JavascriptExecutor jsUp2 = (JavascriptExecutor) driver;
        jsUp2.executeScript("window.scrollTo(50000, 0);");

        //Сделать новый эталонный скриншот:
        Screenshot screenshotAllTvPagePp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(1))
                .ignoredElements(posterTailsTvChannel)
                .ignoredElements(nameTvChannel)
                .ignoredElements(timeNameAgeTvProgram)
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/TvPage/"+"allTvPagePp5Standard"+".png");
        ImageIO.write(screenshotAllTvPagePp5Standard.getImage(), "png", expectedFile1);
        screenshotAllTvPagePp5Standard.setIgnoredAreas(screenshotAllTvPagePp5.getIgnoredAreas());
//        // Взять старый эталон скриншота:
//        Screenshot screenshotAllTvPagePp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/TvPage/" + "allTvPagePp5Standard" + ".png")));
//        screenshotAllTvPagePp5Standard.setIgnoredAreas(screenshotAllTvPagePp5.getIgnoredAreas());

        //Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotAllTvPagePp5Standard, screenshotAllTvPagePp5);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/TvPage/" + "diffTvPageAll" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 15);
    }

    public void checkElementsTvPage() {
        List<WebElement> tailsTvChannel = driver.findElements(By.xpath("//div[@class='_38V9gchkmq2z8GLojNjL_D']//div[@class='_49iS4BqS64BCC4wpE8GQ7']"));
        System.out.println("количество тайлов "+ tailsTvChannel.size());
        System.out.println(driver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
        Assert.assertEquals("количество элементов не равно", tailsTvChannel.size(), driver.findElements(By.xpath("//div[@class='_49iS4BqS64BCC4wpE8GQ7']//img[@alt]")).size());
        System.out.println(driver.findElements(By.xpath("//div[@class='_16fO5taSmblh91J9Prw7TV']")).size());
        Assert.assertEquals("количество элементов не равно", tailsTvChannel.size(), driver.findElements(By.xpath("//div[@class='_16fO5taSmblh91J9Prw7TV' and text()]")).size());

        System.out.println(driver.findElements(By.xpath("//div[@class='_2mLz14ja1zCBwrRv-RM7lg']")).size());
        Assert.assertEquals("количество элементов не равно", tailsTvChannel.size(), driver.findElements(By.xpath("//div[@class='_2mLz14ja1zCBwrRv-RM7lg']")).size());
        for (WebElement tail : tailsTvChannel) {
            tail.findElement(By.xpath("//a[@class='_19SojadR5Q0BvNZTu4HCi1']")).getCssValue("font-weight");
            Assert.assertEquals("не соответствует значение", "500", tail.findElement(By.xpath("//a[@class='_19SojadR5Q0BvNZTu4HCi1']")).getCssValue("font-weight"));
        }
        Assert.assertEquals("количество элементов не равно", 3, driver.findElements(By.xpath("(//div[@class='_49iS4BqS64BCC4wpE8GQ7'])[1]//div[contains(@class,'_30G8CREWABmIqI_RCIwLSb')]")).size());

        String nameTvProgram = driver.findElement(By.xpath("(//a[@class='_19SojadR5Q0BvNZTu4HCi1'])[1]")).getText();
        click(By.xpath("//div[text()='Передачи в эфире']"));
        Assert.assertEquals("значение не равно", nameTvProgram, driver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText());
    }


}

