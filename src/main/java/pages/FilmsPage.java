package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FilmsPage extends BasePage {
    String SITE_URL = "https://web-preprod1.megafon.tv/";

    public FilmsPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenFilmsPage() {
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
    }

    public void clickToTailCardFilmFromAvailable() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void clickToHeaderRent2Collection() {
        click(By.partialLinkText("аренд"));
    }

    public void clickOnFiltrPayment() {
        click(By.xpath("//button[text()='Оплачено']"));
    }

    public void chooseTabPromo() {
        driver.navigate().refresh();
        click(By.xpath("//div[text()='По акции']"));
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
        List<WebElement> Only2019years = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2019')]"));
        Assert.assertEquals(36, Only2019years.size());
    }

    public void choosePeriodOfYears() {
        click(By.xpath("//div[text()='2019 год']"));
        click(By.xpath("//span[text()='2018-2021']"));
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRequestResultPeriodOfYears() {
        List<WebElement> Period = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2018') or contains(text(),'2019') or contains(text(),'2020') or contains(text(),'2021')]"));
        Assert.assertEquals(36, Period.size());
    }

    public void clickOnGenreInput() {
        click(By.xpath("//div[text()='Жанр']"));

    }

    public void checkCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[1]//input[@type='checkbox']"));
        Assert.assertEquals(28, checkboxes.size());
    }

    public void chooseOneGenre() {
        click(By.xpath("//span[text()='Документальный']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultOneGenre() {
        List<WebElement> CollectionOneGenre = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный')]"));
        Assert.assertEquals(36, CollectionOneGenre.size());


    }

    public void chooseTwoGenre() {
        click(By.xpath("//div[text()='Документальный']"));
        click(By.xpath("//span[text()='Аниме']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultTwoGenre() {
        List<WebElement> CollectionTwoGenre = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный') or contains(text(),'Аниме')]"));
        Assert.assertEquals(36, CollectionTwoGenre.size());
    }

    public void clickOnCountryInput() {
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkCheckboxesInCountry() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[2]//input[@type='checkbox']"));
        Assert.assertEquals(18, checkboxes.size());
        //for (WebElement checkbox : checkboxes) {
        //  checkbox.click();
        //}
    }

    public void chooseOneCountry() {
        click(By.xpath("//span[text()='Россия']"));
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkRequestResultOneCountry() {
        List<WebElement> CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionOneCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//div[contains(text(),'Россия')]"));
            driver.navigate().back();
        }
    }


    public void chooseTwoCountry()  {
        click(By.xpath("//div[text()='Россия']"));
        click(By.xpath("//span[text()='Канада']"));
        click(By.xpath("//span[text()='Россия']"));
        click(By.xpath("//span[text()='Китай']"));
        click(By.xpath("//div[text()='Страна']"));
        driver.navigate().refresh();
    }

    public void checkRequestResultTwoCountry() {
        List<WebElement> CollectionTwoCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionTwoCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionTwoCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//div[contains(text(),'Китай') or contains(text(),'Канада')]"));
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

    public void clickToTailCardFilm2FromAll() {
        click(By.xpath("(//a[@data-test='PackageLink'])[2]"));
    }

    public void clickToTailCardFilm3FromAll() {
        click(By.xpath("(//a[@data-test='PackageLink'])[3]"));
    }

    public void clickToTailCardFilm4FromAll() {
        click(By.xpath("(//a[@data-test='PackageLink'])[5]"));
    }

    public void checkFilmsPromo() {
        List<WebElement> CollectionPackages = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionPackages = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionPackages.get(i).click();
            Assert.assertEquals("Нет кнопки 'По акции на 48 часов за 0 ₽' на странице","По акции на 48 часов за 0 ₽", driver.findElement(By.xpath("//span[text()='По акции на 48 часов за 0 ₽']")).getText());
            driver.navigate().back();
        }
    }

    public void clickToTailCardFilm() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }
}

