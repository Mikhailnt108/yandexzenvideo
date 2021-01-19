package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PackagesPage extends BasePage {
    public PackagesPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenPackagesPage() {
        isElementDisplayed(By.xpath("//div[text()='Все пакеты']"));
    }

    public void clickToTabSerialsInMenuPackagesPage() {
        click(By.xpath("(//div[text()='Сериалы'])[3]"));
    }

    public void clickToTailCardPackageSerials() {
        click(By.xpath("//h3[text()='Русские сериалы']"));
    }

    public void clickToTabTvСannelInMenuPackagesPage() {
        click(By.xpath("//div[text()='Телеканалы']"));
    }
    public void clickToTailCardPackageTvChannel() {
        click(By.xpath("//h3[text()='Базовый']"));
    }

    public void clickButtonOnTailCardPackage(String buttonСonnect) {
        click(By.xpath("(//button[text()='Подключить'])[1]"));
    }

    public void clickToTailCardPackage() {
        click(By.xpath("(//div[@class='_1gajUi7CqFhf_qFGRX_c0_'])[1]"));
    }

    public void clickToTailCardPackageTnB() {
        click(By.xpath("(//span[text()='Бесплатно по акции'])[1]"));
    }

    public void clickToTailCardPackageSubsN() {
        click(By.xpath("(//span[contains(text(), 'за 30 дней')])[1]"));
    }

    public void choosePackage18Plus() {
        click(By.xpath("//h3[text()='18+']"));
    }
}
