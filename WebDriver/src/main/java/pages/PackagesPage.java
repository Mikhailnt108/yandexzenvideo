package pages;

import base.BasePageWebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PackagesPage extends BasePageWebDriver {
    public PackagesPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenShopPage() {
        isElementDisplayed(By.xpath("//div[text()='Все пакеты']"));
    }

    public void clickToTabSerialsInMenuShopPage() throws InterruptedException {
        click(By.xpath("(//div[text()='Сериалы'])[3]"));
    }

    public void clickToTailCardPackageSerials() throws InterruptedException {
        click(By.xpath("//h3[text()='START']"));
    }

    public void clickToTabTvСhannelInMenuShopPage() throws InterruptedException {
        click(By.xpath("//div[text()='Телеканалы']"));
    }

    public void clickToTailCardPackageTvChannel() throws InterruptedException {
        click(By.xpath("//h3[text()='Базовый']"));
    }

    public void clickToTabKinoInMenuShopPage() throws InterruptedException {
        click(By.xpath("//div[text()='Кино']"));
    }

    public void clickToTabMixedInMenuShopPage() throws InterruptedException {
        click(By.xpath("//div[text()='Микс']"));
    }

    public void clickToTabConnectedInMenuShopPage() throws InterruptedException {
        click(By.xpath("//div[text()='Подключенные']"));
    }

    public void clickButtonOnTailCardPackage(String buttonСonnect) throws InterruptedException {
        click(By.xpath("(//button[text()='Подключить'])[1]"));
    }

    public void clickToFirstTailCardPackage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC'])[1]")));
        click(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC'])[1]"));
    }

    public void clickToTailCardPackageTnB() throws InterruptedException {
        click(By.xpath("(//span[text()='Бесплатно по акции'])[1]"));
    }

    public void clickToTailCardPackageSubsN() throws InterruptedException {
        click(By.xpath("(//span[contains(text(), 'за 30 дней')])[1]"));
    }

    public void clickToTailCardPackage18Plus() throws InterruptedException {
        click(By.xpath("//h3[text()='18+']"));
    }

    public void checkTabAllPackagesInMenuShopPage() {
        List<WebElement> countTails = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//a[@href]"));
        List<WebElement> packages = webDriver.findElements(By.xpath("//a[@href]//h3[not(text()='START' or text()='more.tv' or text()='Амедиатека')]"));
        System.out.println(countTails.size());
        System.out.println(packages.size());
        Assertions.assertEquals(countTails.size(), packages.size());
    }

    public void checkTypePackagesInTabAll() {
        List<WebElement> CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assertions.assertEquals(CollectionTailAllPackages.size(), webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            Assertions.assertEquals(1, webDriver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());

            if (webDriver.findElements(By.xpath("//div[text()='Фильмы, входящие в пакет:']")).size() != 0) {
                webDriver.navigate().back();
                break;
            } else {
                webDriver.navigate().back();
            }
        }
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));

            CollectionTailAllPackages.get(i).click();
            Assertions.assertEquals(1, webDriver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            if (webDriver.findElements(By.xpath("//div[text()='Сериалы, входящие в пакет:']")).size() != 0) {
                webDriver.navigate().back();
                break;
            } else {
                webDriver.navigate().back();
            }
        }
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            Assertions.assertEquals(1, webDriver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            if (webDriver.findElements(By.xpath("//div[text()='Каналы, входящие в пакет:']")).size() != 0) {
                webDriver.navigate().back();
                break;
            } else {
                webDriver.navigate().back();
            }
        }
    }

    public void checkAllPackegesWithoutOwnership() {
        List<WebElement> CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']//div[text()='Подключен']"));
        Assertions.assertEquals(0, CollectionTailAllPackages.size());
    }
    public void checkConnectedOnTailPackage() {
        List<WebElement> CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']//div[text()='Подключен']"));
        Assertions.assertEquals(2, CollectionTailAllPackages.size());
    }

    public void checkTypePackagesInTabTvChannel() throws InterruptedException {
        List<WebElement> CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            isElementDisplayed(By.xpath("//span[contains(text(),'Подключить')]"));
            isElementDisplayed(By.xpath("//a[@class='_2SBFkKqCGAQ96AZk-0n_uA' and contains(@href,'/tv/channels/')]"));
            click(By.xpath("(//div[text()='Магазин'])[1]"));
            click(By.xpath("//div[text()='Телеканалы']"));
        }
    }

    public void checkTypePackagesInTabSerials() throws InterruptedException {
        List<WebElement> CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            isElementDisplayed(By.xpath("//span[contains(text(),'Подключить')]"));
            if (webDriver.findElements(By.xpath("//a[@class='_8m5mByCjTuND14zuGKagi' and contains(@href,'/shows/')]")).size() != 0) {
                click(By.xpath("(//div[text()='Магазин'])[1]"));
                click(By.xpath("(//div[text()='Сериалы'])[3]"));
            } else {
                click(By.xpath("(//div[text()='Сериалы'])[3]"));
                isElementDisplayed(By.xpath("//a[@class='_8m5mByCjTuND14zuGKagi' and contains(@href,'/shows/')]"));
                click(By.xpath("(//div[text()='Магазин'])[1]"));
                click(By.xpath("(//div[text()='Сериалы'])[3]"));
            }
        }
    }

    public void checkTypePackagesInTabKino() throws InterruptedException {
        List<WebElement> CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            isElementDisplayed(By.xpath("//span[contains(text(),'Подключить')]"));
            if (webDriver.findElements(By.xpath("//a[@data-test='PackageLink' and contains(@href,'/movies/vods/')]")).size() != 0) {
                click(By.xpath("(//div[text()='Магазин'])[1]"));
                click(By.xpath("//div[text()='Кино']"));
            } else {
                click(By.xpath("(//div[text()='Фильмы'])[3]"));
                isElementDisplayed(By.xpath("//a[@data-test='PackageLink' and contains(@href,'/movies/vods/')]"));
                click(By.xpath("(//div[text()='Магазин'])[1]"));
                click(By.xpath("//div[text()='Кино']"));
            }
        }
    }

    public void checkTypePackagesInTabMixed() throws InterruptedException {
        List<WebElement> CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Подключить')]")));
            Assertions.assertEquals(1, webDriver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            Assertions.assertEquals(1, webDriver.findElements(By.xpath("(//div[text()='Фильмы'])[3]")).size());
            Assertions.assertEquals(1, webDriver.findElements(By.xpath("(//div[text()='Сериалы'])[3]")).size());
            if (webDriver.findElements(By.xpath("//div[text()='ТВ-каналы']")).size() != 0) {
                click(By.xpath("(//div[text()='Магазин'])[1]"));
                click(By.xpath("//div[text()='Микс']"));
            } else {
                click(By.xpath("(//div[text()='Магазин'])[1]"));
                click(By.xpath("//div[text()='Микс']"));
            }
        }
    }

    public void checkNotDisplayedTabConnectedInMenuShopPage() {
        Assertions.assertEquals(0, webDriver.findElements(By.xpath("//div[text()='Подключенные']")).size());
    }

    public void checkDisplayedTabConnectedInMenuShopPage() {
        Assertions.assertEquals(1, webDriver.findElements(By.xpath("//div[text()='Подключенные']")).size());
    }

    public void checkTypePackagesInTabConnectedInMenuShopPage() {
        List<WebElement> tails = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        System.out.println(tails.size());
        for (WebElement tail : tails) {
            tail.findElement(By.xpath("//div[text()='Подключен']"));
        }
    }

    public void clickToTabAllPackage() {
        isElementDisplayed(By.xpath("//div[text()='Все пакеты']"));
    }

    public void goToCardPackageTnBFlow() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[text()='Все пакеты']"));
        click(By.xpath("(//span[text()='Бесплатно по акции'])[1]"));
        isElementDisplayed(By.xpath("//a[@href='/packages']//span[1]"));
    }

    public void goToCardPackage18PlusFlow() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[text()='Все пакеты']"));
        click(By.xpath("//h3[text()='18+']"));
        isElementDisplayed(By.xpath("//a[@href='/packages']//span[1]"));
    }

    public void checkTabAllServiceInMenuShopPage() {
        isElementDisplayed(By.xpath("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _2efXVczynhUCLi_CJzGTuL' and text()='Все сервисы']"));
        List<WebElement> countTails = webDriver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//a[contains(@href,'/mixed_groups/')]"));
        List<WebElement> services = webDriver.findElements(By.xpath("//h3[text()='START']|//h3[text()='more.tv']|//h3[text()='Амедиатека']"));
        System.out.println(countTails.size());
        System.out.println(services.size());
        Assertions.assertEquals(countTails.size(),services.size());
    }

    public void clickToTailCardPackageSubs1() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("(//span[contains(text(),'в сутки')])[1]"));
    }

    public void clickToTabAllServices() throws InterruptedException {
        click(By.xpath("(//div[text()='Все сервисы'])[3]"));
    }

    public void clickToTailCardPackageKinoPoPodpiske() throws InterruptedException {
        click(By.xpath("//h3[text()='Кино по подписке']"));
    }
}
