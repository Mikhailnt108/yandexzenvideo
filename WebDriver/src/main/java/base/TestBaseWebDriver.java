package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestBaseWebDriver {
    public WebDriver webDriver;
    public YandexPageMain yandexPageMain;
    public ZenPageFeed zenPageFeed;
    public ZenPageVideo zenPageVideo;
    public ZenPageSearch zenPageSearch;
    public ZenPlayer zenPlayer;
    public String yandex = "https://yandex.ru/";
    public String zen = "https://zen.yandex.ru/";

    @BeforeEach
    public void start() throws MalformedURLException {
        // start remote browser:
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        Configuration.browserCapabilities = options;
//        WebDriver webDriver = new RemoteWebDriver(new URL("http://192.168.1.139:4444"), options);
//        Configuration.pageLoadTimeout = 10000;
//        webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
//        WebDriverRunner.setWebDriver(webDriver);

//        start local browser:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        yandexPageMain = new YandexPageMain(webDriver);
        zenPageFeed = new ZenPageFeed(webDriver);
        zenPageVideo = new ZenPageVideo(webDriver);
        zenPageSearch = new ZenPageSearch(webDriver);
        zenPlayer = new ZenPlayer(webDriver);
//        disabled for docker:
//        Robot bot = new Robot();
//        bot.mouseMove(0, 0);
    }

    @AfterEach
    public void finish() {
//      remote browser:
//        Optional.ofNullable(WebDriverRunner.getWebDriver()).ifPresent(WebDriver::quit);
//        local browser:
        webDriver.quit();
    }
}
