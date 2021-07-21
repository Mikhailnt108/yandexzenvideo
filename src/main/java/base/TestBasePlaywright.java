package base;

import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.CardTvProgram;
import pagesPlaywright.*;
import java.awt.*;
import java.io.IOException;

public class TestBasePlaywright extends BasePagePlaywright{
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static Page pageCMS;
    public static HeaderMenuPW headerMenuPW;
    public static FilmsPagePW filmsPagePW;
    public static SerialsPagePW serialsPagePW;
    public static NiLPagePW niLPagePW;
    public static CollectionsPagePW collectionsPagePW;
    public static TvPagePW tvPagePW;
    public static СardTvChannelPW сardTvChannelPW;
    public static СardTvProgramPW cardTvProgramPW;
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
                    .builder()
                    .apiUrl("http://localhost:4200")
                    .apiKey("P8J6EDQ989M51HPVFCDJAC13YV2X")
                    .project("MFTV_Web")
                    .branchName("master")
                    .httpTimeoutInSeconds(30)
                    .enableSoftAssert(false)
                    .build());

    @BeforeAll
    static void launchBrowser() throws IOException, InterruptedException, AWTException {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        page = browser.newPage(new Browser.NewPageOptions());
        context = browser.newContext();
        headerMenuPW = new HeaderMenuPW(page,pageCMS,context);
        filmsPagePW = new FilmsPagePW(page);
        serialsPagePW = new SerialsPagePW(page);
        niLPagePW = new NiLPagePW(page);
        collectionsPagePW = new CollectionsPagePW(page);
        tvPagePW = new TvPagePW(page);
        сardTvChannelPW = new СardTvChannelPW(page);
        cardTvProgramPW = new СardTvProgramPW(page);

//        page.waitForTimeout(60000);
        vrt.start();
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterAll
    static void closeBrowser() throws IOException, InterruptedException {
        browser.close();
        playwright.close();
        vrt.stop();
    }
}
