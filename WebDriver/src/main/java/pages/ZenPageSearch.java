package pages;

import base.BasePageWebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ZenPageSearch extends BasePageWebDriver {
    public ZenPageSearch(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("openPlayer")
    public void openPlayer() {
        By search_tabs = By.xpath("//div[contains(@class,'search-tabs-view__list')]");
        By snippet_video = By.xpath("//div[text()='Видео' or text()='Video']/ancestor::div[@class='serp-section']//div[contains(@class,'search-snippet__serpSnippet')]");
        if (webDriver.findElements(search_tabs).isEmpty()) {
            click(snippet_video);
            ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.close();
            webDriver.switchTo().window(tabs2.get(1));
            checkOpenUrl(zen + "video/watch/");
        } else {
            isElementDisplayed(By.xpath("//div[contains(@class,'search-tabs-view__list')]"));
            click(By.xpath("//div[contains(@class,'search-tabs') and text()='Видео']|//div[contains(@class,'search-tabs') and text()='Video']"));
            click(By.xpath("(//div[contains(@class,'tab-content _is-active')]//div[@class='serp-video-desktop'])[1]"));
            ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.close();
            webDriver.switchTo().window(tabs2.get(1));
            checkOpenUrl(zen + "video/watch/");
        }
    }
}
