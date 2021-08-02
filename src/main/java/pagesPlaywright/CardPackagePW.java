package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;

public class CardPackagePW extends BasePagePlaywright {
    private Page page;

    public CardPackagePW(Page page) {
        this.page = page;
    }

    public void checkOpenCardPackage() {
        page.waitForSelector("//a[@href='/packages']//span[1]");
    }

    public void paymentPackageTnB() {
        page.click("//span[contains(text(), 'Подключить бесплатно')]");
        page.waitForSelector("//h3[contains(text(), 'Подписка на пакет') or contains(text(), 'Подписка на сервис')]");
        page.click("//button[text()='Подтвердить' or text()='Принять и подключить']");
        page.waitForSelector("//h3[text()='Подключение выполнено успешно']");
        page.click("//button[text()='Закрыть']");
    }

    public void clickOnTailFirstCardFilm() {
        page.click("(//a[@data-test='PackageLink'])[1]");
    }

    public void clickToFirstTailCardSerial() {
        page.click("(//div[text()='Сериалы'])[3]");
        page.click("(//a[@class='_8m5mByCjTuND14zuGKagi'])[1]");
    }

    public void clickOnTailCardChannel() {
        page.click("//div[text()='ТВ-каналы']");
        page.click("(//a[@class='_2SBFkKqCGAQ96AZk-0n_uA'])[1]");
    }
}
