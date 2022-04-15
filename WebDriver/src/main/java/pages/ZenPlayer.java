package pages;

import base.BasePageWebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalTime;

public class ZenPlayer extends BasePageWebDriver {

    public ZenPlayer(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("checkStartPlayVideo")
    public void checkStartPlayVideo() throws InterruptedException {
        Actions actionProvider = new Actions(webDriver);
        isElementDisplayed(By.xpath("//video[contains(@src,'blob:https://zen.yandex.ru/')]"));
        WebElement activateScreen = webDriver.findElement(By.xpath("//div[@class='video-viewer-player__controls']"));
        actionProvider.moveToElement(activateScreen).build().perform();
        //время до
        WebElement time1 = webDriver.findElement(By.xpath("//div[@class='zen-ui-video-video-controls__time']//span[text()]"));
        LocalTime timeBefore = LocalTime.parse(time1.getText());
        System.out.println("time Before: "+timeBefore);
        Thread.sleep(2000);
        //время после
        WebElement activateScreen2 = webDriver.findElement(By.xpath("//div[@class='video-viewer-player__controls']"));
        actionProvider.moveToElement(activateScreen2).build().perform();
        WebElement time2 = webDriver.findElement(By.xpath("//div[@class='zen-ui-video-video-controls__time']//span[text()]"));
        LocalTime timeAfter = LocalTime.parse(time2.getText());
        System.out.println("time After: "+timeAfter);
        checkTimeProgressPlayer(timeBefore, timeAfter);
    }
    @Step("checkControlsPlayer")
    public void checkControlsPlayer() throws InterruptedException {
        Actions actionProvider = new Actions(webDriver);
        WebElement activateScreen = webDriver.findElement(By.xpath("//div[@class='video-viewer-player__controls']"));
        actionProvider.moveToElement(activateScreen).build().perform();
        By controls = By.xpath("//div[contains(@class,'video-viewer-player__controls _is-visible')]");
        isElementDisplayed(controls);
        Thread.sleep(4000);
        isElementNotDisplayed(controls);
    }
    @Step("checkFullScreenPlayer")
    public void checkFullScreenPlayer() {
        Actions actionProvider = new Actions(webDriver);
        WebElement activateScreen = webDriver.findElement(By.xpath("//div[@class='video-viewer-player__controls']"));

        By fullscreen = By.xpath("//div[contains(@class,'template_desktop-fullscreen _is-visible-controls')]");
        By toggleFullscreen = By.xpath("//button[@aria-label='Полноэкранный просмотр' and @aria-pressed='true']");

        actionProvider.moveToElement(activateScreen).build().perform();
        isElementNotDisplayed(fullscreen);

        actionProvider.moveToElement(activateScreen).build().perform();
        click(By.xpath("//div[contains(@class,'video-controls__fullscreen')]"));
        isElementDisplayed(fullscreen);
        isElementDisplayed(toggleFullscreen);
    }
}
