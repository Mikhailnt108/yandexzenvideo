package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPackage extends BasePage {

    public CardPackage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenCardPackageSerials() {
        isElementDisplayed(By.xpath("//div[contains(text(),' сериал')]"));
    }
    public void clickPaymentButtonInCardPackage() {
       click(By.xpath("//button[@type='button']//div[1]"));
    }

    public void checkOpenCardPackageTvChannel() {
        isElementDisplayed(By.xpath("//div[contains(text(),' канал')]"));
    }



    public void checkOpenCardPackage() {
        isElementDisplayed(By.xpath("//a[@href='/packages']//span[1]"));
        //Assert.assertEquals("Не тот пакет",driver.findElement(By.xpath("//div[@class='uCaVLp73F3t8zT0sYCoBh']//span[1]")).getText(),driver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText());
    }

    public void paymentPackageTnB() {
        click(By.xpath("//span[contains(text(), 'Подключить бесплатно')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
        //isElementDisplayed(By.xpath("//button[text()='Отключить']"));
    }

    public void disablePackageTnB() {
        click(By.xpath("//button[text()='Отключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("//button[text()='Отключить']"));
        click(By.xpath("(//button[text()='Отключить'])[2]"));
        isElementDisplayed(By.xpath("//div[text()='Причина отписки']"));
        click(By.xpath("//span[text()='Пользуюсь другим пакетом']"));
        click(By.xpath("//button[text()='Отправить']"));
        isElementDisplayed(By.xpath("//span[contains(text(), 'Подключить за')]"));
    }


    public void paymentPackageSubs1() {
        click(By.xpath("//span[contains(text(), 'Подключить за')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Пакет подключен']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//button[text()='Отключить']"));
    }

    public void disablePackageSubs1() {
        click(By.xpath("//button[text()='Отключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("//button[text()='Отключить']"));
        click(By.xpath("(//button[text()='Отключить'])[2]"));
        isElementDisplayed(By.xpath("//span[contains(text(), 'Подключить за')]"));
    }

    public void paymentPackageSubsN() {
        click(By.xpath("//span[contains(text(), 'Подключить за ')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Пакет подключен']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//button[text()='Отключить']"));
    }

    public void disablePackageSubsN() {
        click(By.xpath("//button[text()='Отключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("//button[text()='Отключить']"));
        click(By.xpath("(//button[text()='Отключить'])[2]"));
        isElementDisplayed(By.xpath("//div[@class = '_3cHfelPdXMGwUxDpiRBrb3' and text()='Оплачено']"));
    }

    public void checkOpenCardPackage18Plus() {
        isElementDisplayed(By.xpath("//div[text()='18+']"));
    }

    public void chooseUnrecordedTvChannel18Plus() {
        click(By.xpath("(//div[@class='_3htFDYhBDJd36aHUvW3Sfh']//div)[1]"));
    }

    public void chooseRecordedTvChannel18Plus() {
        click(By.xpath("(//div[@class='_3htFDYhBDJd36aHUvW3Sfh'])[3]"));
    }

    public void clickOnTailFirstCardFilm() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void clickOnTailCardSerial() {
        click(By.xpath("(//div[text()='Сериалы'])[3]"));
        click(By.xpath("(//a[@class='_8m5mByCjTuND14zuGKagi'])[1]"));
    }

    public void clickOnTailCardChannel() throws InterruptedException {
        click(By.xpath("//div[text()='ТВ-каналы']"));
        click(By.xpath("(//a[@class='_2SBFkKqCGAQ96AZk-0n_uA'])[1]"));
        Thread.sleep(65000);
//        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
    }

    public void clickOnTailSecondCardFilm() {
        click(By.xpath("(//a[@data-test='PackageLink'])[2]"));
    }

    public void clickOnTailCardChannel18Plus() throws InterruptedException {
        click(By.xpath("(//a[@class='_2SBFkKqCGAQ96AZk-0n_uA'])[3]"));
        click(By.xpath("//button[text()='Да']"));
        Thread.sleep(65000);
    }

    public void clickOnTailFirstCardFilm18Plus() {
        click(By.xpath("(//div[text()='Фильмы'])[3]"));
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }
}
