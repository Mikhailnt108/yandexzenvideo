package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TvPage extends BasePage {
    public TvPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenTabTvPageSchedule() {
        isElementDisplayed(By.xpath("//div[text()='Программа передач']"));
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
        click(By.xpath("//a[@class='_3gAIIPQjtWSKeQ00BZcMjA' and text()='В записи']"));
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
}
