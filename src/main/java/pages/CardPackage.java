package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPackage extends BasePage {

    public CardPackage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenCardPackageSerials() {
        isElementDisplayed(By.xpath("//div[text()='Сериалы, входящие в пакет:']"));
    }
    public void clickPaymentButtonInCardPackage() {
       click(By.xpath("//button[@type='button']//div[1]"));
    }

    public void checkOpenCardPackageTvChannel() {
        isElementDisplayed(By.xpath("//div[text()='Каналы, входящие в пакет:']"));
    }

    public void clickTailCardChannel() {
        click(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _1KvwrX35EWldN95GzLjNvr'])[1]"));
    }

    public void checkOpenCardPackage() {
        isElementDisplayed(By.xpath("//a[@href='/packages']//span[1]"));
    }

    public void paymentPackageTnB() {
        click(By.xpath("//span[contains(text(), 'Подключить бесплатно')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет')]"));
        click(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//h3[text()='Пакет подключен']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//button[text()='Отключить']"));
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

        //isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        //click(By.className("_1bciqjt58pgm0il2tiJTtp"));
    }

    public void goToTvProgram18Plus() {
        click(By.className("_1nAXLMkHN0PXnwvulfBvK0"));
        isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
    }

    public void chooseRecordedTvChannel18Plus() {
        click(By.xpath("(//div[@class='_3htFDYhBDJd36aHUvW3Sfh']//div)[5]"));
        //isElementDisplayed(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']"));
        //click(By.className("_1bciqjt58pgm0il2tiJTtp"));
    }
}
