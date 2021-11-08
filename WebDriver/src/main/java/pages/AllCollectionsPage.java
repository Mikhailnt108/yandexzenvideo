package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AllCollectionsPage extends BasePageWebDriver {
    public AllCollectionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickToTailCollection() {
        webDriver.navigate().refresh();
        click(By.xpath("//a[contains(@href,'collection/')]"));
    }

    public void checkElementsPageCollections() {
        isElementDisplayed(By.xpath("//span[text()='Подборки']"));
        isElementDisplayed(By.xpath("//button[contains(text(), 'Следующая')]"));
        isElementDisplayed(By.xpath("//h1[text()='Популярные подборки фильмов и сериалов']"));
        isElementDisplayed(By.xpath("//p[contains(text(),'Мы собрали коллекции лучших фильмов, мультфильмов и сериалов, чтобы смотреть МегаФон ТВ где и когда удобно с любых устройств.')]"));
        isElementDisplayed(By.xpath("//a[@class='_2W-IRVg8nfmL65JjHBY-ly']"));
        isElementDisplayed(By.className("_7d-AKYRwQQezRB7rjcWEA"));
    }

    public void selectCollectionForKids() throws InterruptedException {
        webDriver.get("https://web-preprod6.megafon.tv/kids");
        String nameForKidsBlockCollect = webDriver.findElement(By.xpath("(//h3[@data-test='PackageListWrapperName'])[5]")).getText();
        System.out.println(nameForKidsBlockCollect);
        webDriver.get("https://web-preprod6.megafon.tv/collection");
        List<WebElement> collectNames = webDriver.findElements(By.xpath("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']"));
        List<WebElement> paginations = webDriver.findElements(By.xpath("//a[@class='_321YEvw8w6G20aKg-N8nNe']"));
        for (int a = 0; a < paginations.size(); a++) {
            for (int i = 0; i < collectNames.size(); i++) {
                collectNames = webDriver.findElements(By.xpath("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']"));
                String nameString = collectNames.get(i).getText();
                System.out.println("название подборки на стр коллекций: " + nameString);
                if (nameString.equals(nameForKidsBlockCollect)) {
                    collectNames.get(i).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
                    Assert.assertEquals(webDriver.findElement(By.tagName("h1")).getText(), nameForKidsBlockCollect);
//                    Assert.assertEquals("нет детского фона", 1, driver.findElements(By.xpath("//div[contains(@class,'_3c9FjHVIHIuT3fX6yTP3IO') and contains(@style,'background')]")).size());
                    return;
                }
                if (i == collectNames.size() - 1) {
                    break;
                }
            }
            click(By.xpath("//a[contains(@href,'/collection?page') and @rel='next']"));
            Thread.sleep(3000);
        }
    }
}
