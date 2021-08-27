package base;

import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import pagesPlaywright.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(CONCURRENT)
//@ExtendWith(TestRailReportExtension.class)
public class TestBasePlaywright extends BasePagePlaywright{
    public static Playwright playwright;
    public static Browser browserIncognitoModeHeadfull;
    public static BrowserContext contextNormalModeHeadless;
    public static BrowserContext contextIncognitoModeHeadfull;
    public static Page page;
    public static Page pageCMS;
    public static Page pageHeadfull;
    public static Path userDataDir;
    public static HeaderMenuPW headerMenuPW;
    public static FilmsPagePW filmsPagePW;
    public static SerialsPagePW serialsPagePW;
    public static NiLPagePW niLPagePW;
    public static CollectionsPagePW collectionPagePW;
    public static TvPagePW tvPagePW;
    public static СardTvChannelPW сardTvChannelPW;
    public static СardTvProgramPW cardTvProgramPW;
    public static CardFilmPW cardFilmPW;
    public static CardSerialPW cardSerialPW;
    public static KidsPagePW kidsPagePW;
    public static SportPagePW sportPagePW;
    public static AllCollectionsPagePW allCollectionsPagePW;
    public static PromoPagePW promoPagePW;
    public static PersonalOfferPW personalOfferPW;
    public static PackagesPagePW packagesPagePW;
    public static CardPackagePW cardPackagePW;
    public static CardTvChannelPW cardTvChannelPW;
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
                    .builder()
                    .apiUrl("http://localhost:4200")
                    .apiKey("NA6N66H61HMZP4M0KMEVHTGMGE03")
                    .project("MFTV_Web")
                    .branchName("master")
                    .enableSoftAssert(false)
                    .httpTimeoutInSeconds(30)
                    .build());

    @BeforeAll
    void launchBrowser() throws IOException, InterruptedException, AWTException {
        playwright = Playwright.create();
        // ноут:
//        userDataDir = Paths.get("C:\\Users\\mtabunkov\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        // комп:
        userDataDir = Paths.get("C:\\Users\\Mikhailnt\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        // браузер Headfull:
//        contextNormalModeHeadfull = playwright.chromium().launchPersistentContext(userDataDir,
//                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(false)
//                        .setViewportSize(null).setArgs(Arrays.asList("--start-maximized")));
        // браузер Headless:
        contextNormalModeHeadless = playwright.chromium().launchPersistentContext(userDataDir,
                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(true)
                        .setViewportSize(1900, 920));
//        для ноута:                .setViewportSize(1366, 768));

        // браузер Headless с записью видео:
//        contextNormalModeHeadless = playwright.chromium().launchPersistentContext(userDataDir,
//                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(true)
//                        .setViewportSize(1900, 920).setRecordVideoDir(Paths.get("videos/"))
//                        .setRecordVideoSize(1900, 920));

        contextNormalModeHeadless.clearCookies();
        page = contextNormalModeHeadless.pages().get(0);
        page.setDefaultNavigationTimeout(60000);
//        contextIncognitoModeHeadfull = playwright.chromium().launchPersistentContext(userDataDir2,
//                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setHeadless(false)
//                        .setViewportSize(null).setArgs(Arrays.asList("--start-maximized")));
//        page = contextIncognitoModeHeadfull.pages().get(0);
//        browserIncognitoModeHeadfull = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
//        contextIncognitoModeHeadfull = browserIncognitoModeHeadfull.newContext(new Browser.NewContextOptions().setViewportSize(null));
        browserIncognitoModeHeadfull = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        headerMenuPW = new HeaderMenuPW(page,pageCMS);
        filmsPagePW = new FilmsPagePW(page);
        serialsPagePW = new SerialsPagePW(page,pageCMS);
        niLPagePW = new NiLPagePW(page);
        collectionPagePW = new CollectionsPagePW(page);
        tvPagePW = new TvPagePW(page);
        сardTvChannelPW = new СardTvChannelPW(page);
        cardTvProgramPW = new СardTvProgramPW(page);
        cardFilmPW = new CardFilmPW(page);
        cardSerialPW = new CardSerialPW(page);
        kidsPagePW = new KidsPagePW(page);
        allCollectionsPagePW = new AllCollectionsPagePW(page);
        promoPagePW = new PromoPagePW(page);
        personalOfferPW = new PersonalOfferPW(page);
        packagesPagePW = new PackagesPagePW(page);
        cardPackagePW = new CardPackagePW(page);
        cardTvChannelPW = new CardTvChannelPW(page);
        sportPagePW = new SportPagePW(page);
        vrt.start();
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterAll
    void closeBrowser() throws IOException, InterruptedException {
        contextNormalModeHeadless.close();
        playwright.close();
        vrt.stop();
    }
}
