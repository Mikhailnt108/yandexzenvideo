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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TestBasePlaywright extends BasePagePlaywright{
    public static Playwright playwright;
    public static Browser browserHeadfull;
    public static BrowserContext contextHeadfull;
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
                    .apiKey("BS5PATF1MYMW3XNARRC67FED4JHS")
                    .project("MFTV_Web")
                    .branchName("master")
                    .httpTimeoutInSeconds(30)
                    .enableSoftAssert(false)
                    .build());

    @BeforeAll
    static void launchBrowser() throws IOException, InterruptedException, AWTException {
        playwright = Playwright.create();
        Path userDataDir = Paths.get("C:\\Users\\mtabunkov\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        contextHeadfull = playwright.chromium().launchPersistentContext(userDataDir,
                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(false)
                        .setViewportSize(null).setArgs(Arrays.asList("--start-maximized")));
        page = contextHeadfull.pages().get(0);
        page.setDefaultNavigationTimeout(60000);
        headerMenuPW = new HeaderMenuPW(page,pageCMS);
        filmsPagePW = new FilmsPagePW(page);
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
        contextHeadfull.close();
        playwright.close();
        vrt.stop();
    }
}
