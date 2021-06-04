package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

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
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]"));
        click(By.xpath("//button[text()='Подтвердить' or text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void disablePackageTnB() {
        String nameConnectedPackage = driver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText();
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Управление пакетами и сервисами'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Управление пакетами и сервисами'])[3]"));
        Assert.assertEquals("не тот пакет", driver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText(),nameConnectedPackage);
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Повторное подключение по акции недоступно.')]"));
        click(By.xpath("//button[text()='Отключить']"));
        isElementDisplayed(By.xpath("//div[text()='Причина отписки']"));
        click(By.xpath("//span[text()='Пользуюсь другим пакетом']"));
        click(By.xpath("//button[text()='Отправить']"));
        isElementDisplayed(By.xpath("(//span[contains(text(),'Отключен')])[last()]"));
    }

    public void paymentPackageSubs1() {
        click(By.xpath("(//span[contains(text(), 'Подключить за')])[1]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]"));
        click(By.xpath("//button[text()='Подтвердить' or text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void disablePackageSubs1() {
        String nameConnectedPackage = driver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText();
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Управление пакетами и сервисами'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Управление пакетами и сервисами'])[3]"));
        Assert.assertEquals("не тот пакет", driver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText(),nameConnectedPackage);
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        click(By.xpath("//button[text()='Отключить']"));
        isElementDisplayed(By.xpath("//div[text()='Причина отписки']"));
        click(By.xpath("//span[text()='Пользуюсь другим пакетом']"));
        click(By.xpath("//button[text()='Отправить']"));
        isElementDisplayed(By.xpath("(//span[contains(text(),'Отключен')])[last()]"));
    }

    public void paymentPackageSubsN() {
        click(By.xpath("//span[contains(text(), 'Подключить за')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]"));
        click(By.xpath("//button[text()='Подтвердить' or text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void disablePackageSubsN() {
        String nameConnectedPackage = driver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText();
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Управление пакетами и сервисами'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Управление пакетами и сервисами'])[3]"));
        Assert.assertEquals("не тот пакет", driver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText(),nameConnectedPackage);
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        click(By.xpath("//button[text()='Отключить']"));
        isElementDisplayed(By.xpath("//div[text()='Причина отписки']"));
        click(By.xpath("//span[text()='Пользуюсь другим пакетом']"));
        click(By.xpath("//button[text()='Отправить']"));
        isElementDisplayed(By.xpath("(//span[contains(text(),'Оплачено до')])[last()]"));
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

    public void paymentPackageTnBForNonMFBankCardNotLinked(String numberBankCard, String dataValidity, String codeCVV) {
        click(By.xpath("//span[contains(text(), 'Подключить бесплатно')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]"));
        click(By.xpath("//button[text()='Подтвердить' or text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Привязать банковскую карту']"));
        writeText(By.xpath("//input[@placeholder='Номер карты']"), numberBankCard);
        writeText(By.xpath("//input[@placeholder='Срок действия']"), dataValidity);
        writeText(By.xpath("//input[@placeholder='Код безопасности']"), codeCVV);
        click(By.xpath("//span[text()='Подключить сервис']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void paymentPackageSubsNForNonMFBankCardLinked() {
        click(By.xpath("//span[contains(text(), 'Подключить за')]"));
        isElementDisplayed(By.xpath("//h1[text()='Выберите способ оплаты']"));
        click(By.className("_143gEPPDQeFDE8SQpNRUlN"));
        isElementDisplayed(By.xpath("//h1[contains(text(),'Подписка на сервис') or contains(text(),'Подписка на пакет')]"));
        click(By.xpath("//span[text()='Подключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }
}
