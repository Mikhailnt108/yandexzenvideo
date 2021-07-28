package base;

import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pagesPlaywright.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TestBasePlaywright extends BasePagePlaywright{
    public static Playwright playwright;
    public static Browser browserIncognitoModeHeadless;
    public static BrowserContext contextNormalModeHeadfull;
    public static BrowserContext contextIncognitoModeHeadless;
    public static Page page;
    public static Page pageFull;
    public static Page pageCMS;
    public static Path userDataDir;
    public static HeaderMenuPW headerMenuPW;
    public static FilmsPagePW filmsPagePW;
    public static SerialsPagePW serialsPagePW;
    public static NiLPagePW niLPagePW;
    public static CollectionsPagePW collectionsPagePW;
    public static TvPagePW tvPagePW;
    public static СardTvChannelPW сardTvChannelPW;
    public static СardTvProgramPW cardTvProgramPW;
    public static CardFilmPW cardFilmPW;
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
                    .builder()
                    .apiUrl("http://localhost:4200")
                    .apiKey("7S8B9YA3TQMTP1J0QR939B88RAXB")
                    .project("MFTV_Web")
                    .branchName("master")
                    .httpTimeoutInSeconds(30)
                    .enableSoftAssert(false)
                    .build());

    @BeforeAll
    static void launchBrowser() throws IOException, InterruptedException, AWTException {
        playwright = Playwright.create();
        userDataDir = Paths.get("C:\\Users\\mtabunkov\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        contextNormalModeHeadfull = playwright.chromium().launchPersistentContext(userDataDir,
                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(false)
                        .setViewportSize(null).setArgs(Arrays.asList("--start-maximized")));
        contextNormalModeHeadfull.clearCookies();
        page = contextNormalModeHeadfull.pages().get(0);
        page.setDefaultNavigationTimeout(60000);
        browserIncognitoModeHeadless = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        contextIncognitoModeHeadless = browserIncognitoModeHeadless.newContext(new Browser.NewContextOptions().setViewportSize(null));
        headerMenuPW = new HeaderMenuPW(page,pageCMS);
        filmsPagePW = new FilmsPagePW(page);
        serialsPagePW = new SerialsPagePW(page,pageCMS);
        niLPagePW = new NiLPagePW(page, pageFull);
        collectionsPagePW = new CollectionsPagePW(page);
        tvPagePW = new TvPagePW(page);
        сardTvChannelPW = new СardTvChannelPW(page);
        cardTvProgramPW = new СardTvProgramPW(page);
        cardFilmPW = new CardFilmPW(page);
        vrt.start();
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterAll
    static void closeBrowser() throws IOException, InterruptedException {
        contextNormalModeHeadfull.close();
        playwright.close();
        vrt.stop();
    }
}
