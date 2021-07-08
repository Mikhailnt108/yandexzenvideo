package base;

import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pagesPlaywright.FilmsPagePW;
import pagesPlaywright.SerialsPagePW;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBasePlaywright extends BasePagePlaywright{
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static FilmsPagePW filmsPagePW;
    public static SerialsPagePW serialsPagePW;
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
                    .builder()
                    .apiUrl("http://localhost:4200")
                    .apiKey("9DG7DHAQV94HK3KT7YZG1CQPMTCM")
                    .project("MFTV_Web")
                    .branchName("master")
                    .enableSoftAssert(true)
                    .build());

    @BeforeAll
    static void launchBrowser() throws IOException, InterruptedException {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
        page = browser.newPage(new Browser.NewPageOptions().setViewportSize(1860,900));
        filmsPagePW = new FilmsPagePW(page);
        serialsPagePW = new SerialsPagePW(page);
        vrt.start();
    }

    @AfterAll
    static void closeBrowser() throws IOException, InterruptedException {
        browser.close();
        playwright.close();
        vrt.stop();
    }
}
