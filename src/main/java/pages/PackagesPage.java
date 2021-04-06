package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PackagesPage extends BasePage {
    public PackagesPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenShopPage() {
        isElementDisplayed(By.xpath("(//div[text()='Все сервисы'])[3]"));
    }

    public void clickToTabSerialsInMenuShopPage() {
        click(By.xpath("(//div[text()='Сериалы'])[3]"));
    }

    public void clickToTailCardPackageSerials() {
        click(By.xpath("//h3[text()='Русские сериалы']"));
    }

    public void clickToTabTvСhannelInMenuShopPage() {
        click(By.xpath("//div[text()='Телеканалы']"));
    }

    public void clickToTailCardPackageTvChannel() {
        click(By.xpath("//h3[text()='Базовый']"));
    }

    public void clickToTabKinoInMenuPackagesPage() {
        click(By.xpath("//div[text()='Кино']"));
    }

    public void clickToTabMixedInMenuPackagesPage() {
        click(By.xpath("//div[text()='Микс']"));
    }

    public void clickToTabConnectedInMenuPackagesPage() {
        click(By.xpath("//div[text()='Подключенные']"));
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

    public void checkTabAllPackagesInMenuPackagesPage() {
        isElementDisplayed(By.xpath("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _2efXVczynhUCLi_CJzGTuL' and text()='Все пакеты']"));
    }

    public void checkTypePackagesInTabAll() {
        List<WebElement> CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTailAllPackages.size(), driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));

            CollectionTailAllPackages.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());

            if (driver.findElements(By.xpath("//div[text()='Фильмы, входящие в пакет:']")).size() != 0) {
                driver.navigate().back();
                break;
            } else {
                driver.navigate().back();
            }
        }
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));

            CollectionTailAllPackages.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            if (driver.findElements(By.xpath("//div[text()='Сериалы, входящие в пакет:']")).size() != 0) {
                driver.navigate().back();
                break;
            } else {
                driver.navigate().back();
            }
        }
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));

            CollectionTailAllPackages.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            if (driver.findElements(By.xpath("//div[text()='Каналы, входящие в пакет:']")).size() != 0) {
                driver.navigate().back();
                break;
            } else {
                driver.navigate().back();
            }
        }
    }

    public void checkAllPackegesWithoutOwnership() {
        List<WebElement> CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']//div[text()='Подключен']"));
        Assert.assertEquals(0, CollectionTailAllPackages.size());
    }
    public void checkConnectedOnTailPackage() {
        List<WebElement> CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']//div[text()='Подключен']"));
        Assert.assertEquals(2, CollectionTailAllPackages.size());
    }

    public void checkTypePackagesInTabTvChannel() {
        List<WebElement> CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTailAllPackages.size(), driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            Assert.assertEquals(1, driver.findElements(By.xpath("//div[text()='Каналы, входящие в пакет:']")).size());
            driver.navigate().back();
        }
    }

    public void checkTypePackagesInTabSerials() {
        List<WebElement> CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTailAllPackages.size(), driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            if (driver.findElements(By.xpath("//div[text()='Сериалы, входящие в пакет:']")).size() != 0) {
                driver.navigate().back();
            } else {
                click(By.xpath("(//div[text()='Сериалы'])[3]"));
                Assert.assertEquals(1, driver.findElements(By.xpath("//div[text()='Сериалы, входящие в пакет:']")).size());
                driver.navigate().back();
            }
        }
    }


    public void checkTypePackagesInTabKino() {
        List<WebElement> CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTailAllPackages.size(), driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            if (driver.findElements(By.xpath("//div[text()='Фильмы, входящие в пакет:']")).size() != 0) {
                driver.navigate().back();
            } else {
                click(By.xpath("(//div[text()='Фильмы'])[3]"));
                Assert.assertEquals(1, driver.findElements(By.xpath("//div[text()='Фильмы, входящие в пакет:']")).size());
                driver.navigate().back();
            }
        }
    }

    public void checkTypePackagesInTabMixed() {
        List<WebElement> CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        Assert.assertEquals(CollectionTailAllPackages.size(), driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']")).size());
        System.out.println(CollectionTailAllPackages.size());
        for (int i = 0; i < CollectionTailAllPackages.size(); i++) {
            CollectionTailAllPackages = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
            CollectionTailAllPackages.get(i).click();
            Assert.assertEquals(1, driver.findElements(By.xpath("//span[contains(text(),'Подключить')]")).size());
            Assert.assertEquals(1, driver.findElements(By.xpath("(//div[text()='Фильмы'])[3]")).size());
            Assert.assertEquals(1, driver.findElements(By.xpath("(//div[text()='Сериалы'])[3]")).size());
            if (driver.findElements(By.xpath("//div[text()='ТВ-каналы']")).size() != 0) {
                driver.navigate().back();
            } else {
                driver.navigate().back();
            }
        }
    }

    public void checkNotDisplayedTabConnectedInMenuPackagesPage() {
        Assert.assertEquals(0, driver.findElements(By.xpath("//div[text()='Подключенные']")).size());
    }

    public void checkDisplayedTabConnectedInMenuPackagesPage() {
        Assert.assertEquals(1, driver.findElements(By.xpath("//div[text()='Подключенные']")).size());
    }

    public void checkTypePackagesInTabConnectedInMenuPackagesPage() {
        List<WebElement> tails = driver.findElements(By.xpath("//div[@class='_1xL5v5jWDyGkjnMyil3_S5']//div[@class='_1gajUi7CqFhf_qFGRX_c0_']"));
        System.out.println(tails.size());
        for (WebElement tail : tails) {
            tail.findElement(By.xpath("//div[text()='Подключен']"));
        }
    }
}
