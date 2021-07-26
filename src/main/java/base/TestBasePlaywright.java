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
    public static Browser browserHeadless;
    public static Browser browserHeadfull;
    public static BrowserContext context;
    public static Page page;
    public static Page pageHeadfull;
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
                    .apiKey("SA30R7V6EQ4N0DHK4ZWFRV2BEPSS")
                    .project("MFTV_Web")
                    .branchName("master")
                    .httpTimeoutInSeconds(30)
                    .enableSoftAssert(false)
                    .build());

    @BeforeAll
    static void launchBrowser() throws IOException, InterruptedException, AWTException {
        playwright = Playwright.create();
        browserHeadless = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
        browserHeadfull = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        page = browserHeadless.newPage(new Browser.NewPageOptions().setViewportSize(1880, 930));
        page.setDefaultNavigationTimeout(60000);
        pageHeadfull.setDefaultNavigationTimeout(60000);
        context = browserHeadless.newContext();
        headerMenuPW = new HeaderMenuPW(page,pageCMS,context);
        filmsPagePW = new FilmsPagePW(page, context);
        serialsPagePW = new SerialsPagePW(page,pageCMS,context);
        niLPagePW = new NiLPagePW(page);
        collectionsPagePW = new CollectionsPagePW(page);
        tvPagePW = new TvPagePW(page);
        сardTvChannelPW = new СardTvChannelPW(page);
        cardTvProgramPW = new СardTvProgramPW(page);

        vrt.start();
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterAll
    static void closeBrowser() throws IOException, InterruptedException {
        browserHeadless.close();
        playwright.close();
        vrt.stop();
    }
}
