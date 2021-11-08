package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardPackage extends BasePageWebDriver {

    public CardPackage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenCardPackageSerials() {
        isElementDisplayed(By.xpath("//div[contains(text(),' сериал')]"));
    }

    public void clickOnPaymentButtonInCardPackageForGuest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]")));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();"
                , webDriver.findElement(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]")));
        click(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Введите номер телефона']")));
    }

    public void clickOnPaymentButtonInCardPackageForUser() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]")));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();"
                , webDriver.findElement(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]")));
        click(By.xpath("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]"));
    }

    public void checkOpenCardPackageTvChannel() {
        String urlCardTvPackage = webDriver.getCurrentUrl();
        urlCardTvPackage.equals("megafon.tv/tv1/packages/");
    }

    public void checkOpenCardPackage() {
        Assert.assertTrue("bug: not opened card package", webDriver.getCurrentUrl().contains("/mixed_groups/"));
    }

    public void paymentPackageTnB() {
        click(By.xpath("//span[contains(text(), 'Подключить бесплатно')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]"));
        click(By.xpath("//button[text()='Подтвердить' or text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void disablePackageTnB() {
        String nameConnectedPackage = webDriver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText();
        click(By.xpath("(//span[contains(text(),'+792')])[2]"));
        click(By.xpath("(//span[text()='Управление пакетами и сервисами'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Управление пакетами и сервисами'])[3]"));
        Assert.assertEquals("не тот пакет", webDriver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText(),nameConnectedPackage);
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

    public void disablePackageSubs1() throws InterruptedException {
        String nameConnectedPackage = webDriver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText();
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Управление пакетами и сервисами'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Управление пакетами и сервисами'])[3]"));
        Assert.assertEquals("не тот пакет", webDriver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText(),nameConnectedPackage);
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        click(By.xpath("//button[text()='Отключить']"));
//        isElementDisplayed(By.xpath("//div[text()='Причина отписки']"));
//        click(By.xpath("//span[text()='Пользуюсь другим пакетом']"));
//        click(By.xpath("//button[text()='Отправить']"));
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
        String nameConnectedPackage = webDriver.findElement(By.className("_3JWCAjonEZRvpx1iIk6Y0n")).getText();
        click(By.xpath("(//div[@class='ch-trigger__container'])[4]"));
        click(By.xpath("(//span[text()='Управление пакетами и сервисами'])[1]"));
        isElementDisplayed(By.xpath("(//span[text()='Управление пакетами и сервисами'])[3]"));
        Assert.assertEquals("не тот пакет", webDriver.findElement(By.xpath("(//h3[@class='hhYBfS5SYd9UjRyn3tWgw'])[1]")).getText(),nameConnectedPackage);
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        click(By.xpath("//button[text()='Отменить']"));
        click(By.xpath("(//div[@class='_3VZmmaWyKgMDD4r5JWyaEI'])[1]"));
        isElementDisplayed(By.xpath("//h3[text()='Подтвердить отключение']"));
        click(By.xpath("//button[text()='Отключить']"));
//        isElementDisplayed(By.xpath("//div[text()='Причина отписки']"));
//        click(By.xpath("//span[text()='Пользуюсь другим пакетом']"));
//        click(By.xpath("//button[text()='Отправить']"));
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

    public void clickToFirstTailCardSerial() {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();"
                , webDriver.findElement(By.xpath("(//a[@class='_8m5mByCjTuND14zuGKagi'])[1]")));
        click(By.xpath("(//a[@class='_8m5mByCjTuND14zuGKagi'])[1]"));
    }

    public void clickOnTailCardChannel() throws InterruptedException {
        click(By.xpath("//div[text()='ТВ-каналы']"));
        click(By.xpath("(//a[@class='_2SBFkKqCGAQ96AZk-0n_uA'])[1]"));
    }

    public void clickOnTailSecondCardFilm() {
        click(By.xpath("(//a[@data-test='PackageLink'])[2]"));
    }

    public void clickOnTailCardChannel18Plus() throws InterruptedException {
        click(By.xpath("(//a[@class='_2SBFkKqCGAQ96AZk-0n_uA'])[3]"));
        click(By.xpath("//button[text()='Да']"));
    }

    public void clickOnTailFirstCardFilm18Plus() {
        click(By.xpath("(//div[text()='Фильмы'])[3]"));
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void paymentPackageTnBForNonMFBankCardNotLinked(String numberBankCard, String dataValidity, String codeCVV) throws InterruptedException {
        click(By.xpath("//span[contains(text(),'Подключить бесплатно на')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]"));
        click(By.xpath("//button[text()='Добавить и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Привязать банковскую карту']"));
        writeText(By.xpath("//input[@placeholder='Номер карты']"), numberBankCard);
        writeText(By.xpath("//input[@placeholder='Срок действия']"), dataValidity);
        writeText(By.xpath("//input[@placeholder='Код безопасности']"), codeCVV);
        click(By.xpath("//span[text()='Подключить сервис']|//span[text()='Подключить пакет']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Подключение выполнено успешно']")));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void paymentPackageSubsNForNonMFBankCardLinked() {
        click(By.xpath("//span[contains(text(), 'Подключить за')]"));
        isElementDisplayed(By.xpath("//h1[text()='Выберите способ оплаты']"));
        click(By.className("_143gEPPDQeFDE8SQpNRUlN"));
        isElementDisplayed(By.xpath("//h1[contains(text(),'Подписка на сервис') or contains(text(),'Подписка на пакет')]"));
        click(By.xpath("//span[text()='Подключить']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Подключение выполнено успешно']")));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkElementsPopUpSubsPromoServiceForMF() {
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.className("_1bciqjt58pgm0il2tiJTtp"));
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Подписка на сервис')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'бесплатно на')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'стоимость подписки составит')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Подтверждая подписку, вы принимаете условия оферты')]"));
        isElementDisplayed(By.xpath("//button[text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));
    }

    public void clickOnButtonCancel() {

        click(By.xpath("//button[text()='Отменить']"));
    }

    public void checkClosePopUpSubsPromoService() {
        Assert.assertEquals("не закрыт поп-ап",0, webDriver.findElements(By.xpath("//h3[contains(text(),'Подписка на сервис')]")).size());
    }

    public void clickOnButtonAcceptAndConfirm() {
        click(By.xpath("//button[text()='Принять и подключить']"));
    }

    public void checkElementsPopUpСonnectionСompleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Подключение выполнено успешно']")));
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.className("_1bciqjt58pgm0il2tiJTtp"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        isElementDisplayed(By.xpath("//button[text()='Закрыть']"));
    }

    public void checkElementsPopUpSubsPromoServiceForNonMF() {
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.className("_1bciqjt58pgm0il2tiJTtp"));
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Подписка на сервис')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'бесплатно на')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'за 30 дней.')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Для завершения подписки необходимо добавить платежное средство. Подтверждая подписку, вы принимаете условия оферты')]"));
        isElementDisplayed(By.xpath("//button[text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));
    }

    public void inputDataBankCard(String numberBankCard, String dataValidity, String codeCVV) throws InterruptedException {
        isElementDisplayed(By.xpath("//h3[text()=' Привязать банковскую карту']"));
        writeText(By.xpath("//input[@placeholder='Номер карты']"), numberBankCard);
        writeText(By.xpath("//input[@placeholder='Срок действия']"), dataValidity);
        writeText(By.xpath("//input[@placeholder='Код безопасности']"), codeCVV);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Подключить сервис']")));
        click(By.xpath("//span[text()='Подключить сервис']"));
    }

    public void checkElementsPopUpSubsPromoPackageForMF() {
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.className("_1bciqjt58pgm0il2tiJTtp"));
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Подписка на пакет')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'бесплатно на')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'стоимость подписки составит')]"));
        isElementDisplayed(By.xpath("//button[text()='Подтвердить']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));
    }

    public void checkClosePopUpSubsPromoPackage() {
        Assert.assertEquals("не закрыт поп-ап",0, webDriver.findElements(By.xpath("//h3[contains(text(),'Подписка на пакет')]")).size());
    }

    public void clickOnButtonСonfirm() {

        click(By.xpath("//button[text()='Подтвердить']"));
    }

    public void checkElementsPopUpSubsPromoPackageForNonMF() {
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.className("_1bciqjt58pgm0il2tiJTtp"));
        isElementDisplayed(By.className("-VvyK7e3vEyvzulLP4eYQ"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Подписка на пакет')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'бесплатно на')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'стоимость составит')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'за 30 дней.')]"));
        isElementDisplayed(By.xpath("//span[contains(text(),'Оплата со счета банковской карты')]"));
        isElementDisplayed(By.xpath("//button[text()='Подключить']"));
        isElementDisplayed(By.xpath("//button[text()='Отменить']"));
    }

    public void clickOnButtonConnect() {
        click(By.xpath("//button[text()='Подключить']"));
    }

    public void clickOnButtonClosePoUpСonnectionСompleted() {
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void paymentPackageSubsNForNonMFBankCardNotLinked(String numberBankCard, String dataValidity, String codeCVV) throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Подключить за')]"));
        isElementDisplayed(By.xpath("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]"));
        click(By.xpath("//button[text()='Подтвердить' or text()='Добавить и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()=' Привязать банковскую карту']"));
        writeText(By.xpath("//input[@placeholder='Номер карты']"), numberBankCard);
        writeText(By.xpath("//input[@placeholder='Срок действия']"), dataValidity);
        writeText(By.xpath("//input[@placeholder='Код безопасности']"), codeCVV);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Оплатить подписку']")));
        click(By.xpath("//span[text()='Оплатить подписку']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Подключение выполнено успешно']")));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
    }

    public void clickToSecondTailCardSerial() {
        click(By.xpath("(//div[text()='Сериалы'])[3]"));
        click(By.xpath("(//div[@class='_1gajUi7CqFhf_qFGRX_c0_'])[2]"));
    }

    public void clickToThirdTailCardSerial() {
        click(By.xpath("(//div[text()='Сериалы'])[3]"));
        click(By.xpath("(//div[@class='_1gajUi7CqFhf_qFGRX_c0_'])[3]"));
    }

    public void chooseToTabFilms() {
        click(By.xpath("(//div[text()='Фильмы'])[3]"));
    }

    public void clickToTabSerials() {
        click(By.xpath("(//div[text()='Сериалы'])[3]"));
    }

    public void scrollCardPackage() {
        JavascriptExecutor jsDown = (JavascriptExecutor) webDriver;
        jsDown.executeScript("window.scrollTo(0, 200);");
    }


}
