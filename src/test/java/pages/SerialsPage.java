package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SerialsPage extends BasePage {

    public SerialsPage(WebDriver driver) {
        super(driver);
    }
    public void checkOpenSerialsPage() {
        isElementDisplayed(By.xpath("//h1[text()='Сериалы']"));
    }
    public void clickToTailCardSerial() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/shows')][2]"));
            }
    public void chooseSeasonsMoreOneSeason() {
        driver.findElement(By.xpath("//div[@class='_3i1jxy4zPnL4htxPozakKI']//span[contains(text(),'3 сезона') or contains(text(), '4 сезона') or contains(text(), '7 сезонов')]")).click();
    }

    public void clickOnYearInput() {
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRadioButtons() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("(//div[@class='_TKVCKE7PL8voHtm8HP2j'])[1]//span[@class='AoSy93bShFe6C6hlZfxUE']"));
        Assert.assertEquals(15, radioButtons.size());
    }

    public void chooseOneYearOnly() {
        click(By.xpath("//span[text()='2019 год']"));
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRequestResultOneYearOnly() {
        List<WebElement> CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=5; i++)
        {
            CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionOneCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//dd[text()='2019']"));
            driver.navigate().back();
        }
    }

    public void choosePeriodOfYears() {
        click(By.xpath("//div[text()='2019 год']"));
        click(By.xpath("//span[text()='2018-2020']"));
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRequestResultPeriodOfYears() {
        List<WebElement> CollectionTwoCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=5; i++)
        {
            CollectionTwoCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionTwoCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//dd[text()='2018' or text()='2019' or text()='2020']"));
            driver.navigate().back();
        }
    }

    public void clickOnGenreInput() {
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[1]//input[@type='checkbox']"));
        Assert.assertEquals(28, checkboxes.size());
    }

    public void chooseOneGenre() {
        click(By.xpath("//span[text()='Комедия']"));
        click(By.xpath("//div[text()='Жанр']"));

    }

    public void checkRequestResultOneGenre() {
        List<WebElement> CollectionOneGenre = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//div[contains(text(),'Комедия')]"));
        Assert.assertEquals(36, CollectionOneGenre.size());
    }

    public void chooseTwoGenre() {
        click(By.xpath("//div[text()='Комедия']"));
        click(By.xpath("//span[text()='Драма']"));
        click(By.xpath("//div[text()='Жанр']"));

    }

    public void checkRequestResultTwoGenre() {
        List<WebElement> CollectionTwoGenre = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//div[contains(text(),'Комедия') or contains(text(),'Драма')]"));
        Assert.assertEquals(36, CollectionTwoGenre.size());

    }

    public void clickOnCountryInput() {
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkCheckboxesInCountry() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[2]//input[@type='checkbox']"));
        Assert.assertEquals(18, checkboxes.size());
    }

    public void chooseOneCountry() {
        click(By.xpath("//span[text()='Россия']"));
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkRequestResultOneCountry() {
        List<WebElement> CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=8; i++)
        {
            CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionOneCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//div[contains(text(),'Россия')]"));
            driver.navigate().back();
        }
    }

    public void chooseTwoCountry() {
        click(By.xpath("//div[text()='Россия']"));
        click(By.xpath("//span[text()='США']"));
        click(By.xpath("//div[text()='Страна']"));

    }

    public void checkRequestResultTwoCountry() {
        List<WebElement> CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=8; i++)
        {
            CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionOneCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//div[contains(text(),'Россия') or contains(text(),'США')]"));
            driver.navigate().back();
        }

    }

    public void clickOnResetFiltersButton() {
        click(By.xpath("//button[text()='Сбросить']"));
    }

    public void checkResetAllFilters() {
        List<WebElement> Filters = driver.findElements(By.xpath("//div[@class='_1RRLrdyUeRf97LW7DW4bHw']//div[text()='Жанр' or text()='Страна' or text()='Год' or text()='Рейтинг']"));
        Assert.assertEquals(4, Filters.size());
    }

    public void startVideoPleer() throws Exception {

    }
}
