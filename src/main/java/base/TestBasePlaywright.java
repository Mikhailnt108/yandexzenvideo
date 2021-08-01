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
    public static CardSerialPW cardSerialPW;
    public static KidsPagePW kidsPagePW;
    public static AllCollectionsPagePW allCollectionsPagePW;
    public static PromoPagePW promoPagePW;
    public static PersonalOfferPW personalOfferPW;
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
                    .builder()
                    .apiUrl("http://localhost:4200")
                    .apiKey("QFAHS5427PMPTZPBWCDF9K5EM14A")
                    .project("MFTV_Web")
                    .branchName("master")
                    .httpTimeoutInSeconds(30)
                    .enableSoftAssert(false)
                    .build());

    @BeforeAll
    static void launchBrowser() throws IOException, InterruptedException, AWTException {
        playwright = Playwright.create();
//      // ноут:
//        userDataDir = Paths.get("C:\\Users\\mtabunkov\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        // комп:
        userDataDir = Paths.get("C:\\Users\\Mikhailnt\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        contextNormalModeHeadfull = playwright.chromium().launchPersistentContext(userDataDir,
                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(false)
                        .setViewportSize(null).setArgs(Arrays.asList("--start-maximized")));

//        contextNormalModeHeadfull = playwright.chromium().launchPersistentContext(userDataDir,
//                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(true)
//                        .setViewportSize(1930, 830));

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
        cardSerialPW = new CardSerialPW(page);
        kidsPagePW = new KidsPagePW(page);
        allCollectionsPagePW = new AllCollectionsPagePW(page);
        promoPagePW = new PromoPagePW(page);
        personalOfferPW = new PersonalOfferPW(page);
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
