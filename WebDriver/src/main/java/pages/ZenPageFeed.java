package pages;

import base.BasePageWebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZenPageFeed extends BasePageWebDriver {
    public ZenPageFeed(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("checkElementsZenPageFeed")
    public void checkElementsZenPageFeed() {
        isElementDisplayed(By.xpath("//div[contains(@class,'sidebar-item-view _active _size')]//div[text()='Лента' or 'Feed']"));
        isElementDisplayed(By.xpath("//h1[text()='Ваша лента' or 'Your feed']"));
        isElementDisplayed(By.xpath("//div[contains(@class,'channelsCarousel')]"));
        By channels_card = By.xpath("//div[contains(@class,'channels-card__card')]//a[@href]");
        By channels_card_logo = By.xpath("//div[contains(@class,'channels-card__card')]//div[contains(@class,'logo')]");
        By channels_card_title = By.xpath("//div[contains(@class,'channels-card__card')]//span[contains(@class,'title')]");
        By channels_card_description = By.xpath("//div[contains(@class,'channels-card__card')]//div[contains(@class,'description') and text()]");
        By channels_card_subscribeButton = By.xpath("//div[contains(@class,'channels-card__card')]//button[contains(@class,'subscribeButton')]//span[text()='Подписаться' or text()='Subscribe']");
        checkMatchCount(channels_card, channels_card_logo);
        checkMatchCount(channels_card, channels_card_title);
        checkMatchCount(channels_card, channels_card_description);
        checkMatchCount(channels_card, channels_card_subscribeButton);
        System.out.println("size card: "+webDriver.findElements(channels_card).size());
        System.out.println("size card_description: "+webDriver.findElements(channels_card_description).size());
    }
    @Step("goToZenPageVideo")
    public void goToZenPageVideo() {
        click(By.xpath("//a[@class='nav-menu-item' and @href='/video']//div[text()='Видео' or 'Video']"));
        checkOpenUrl(zen+"video");
    }
}
