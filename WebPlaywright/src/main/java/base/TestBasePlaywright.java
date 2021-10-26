package base;

import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import pagesPlaywright.*;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public //@ExtendWith(TestRailReportExtension.class)
class TestBasePlaywright extends BasePagePlaywright{
    public Playwright playwright;
    public Browser browserIncognitoModeHeadless;
    public static Browser browserIncognitoModeHeadfull;
    public static Page pageHeadfull;
    public HeaderMenuPW headerMenuPW;
    public FilmsPagePW filmsPagePW;
    public SerialsPagePW serialsPagePW;
    public NiLPagePW nilPagePW;
    public CollectionsPagePW collectionPagePW;
    public TvPagePW tvPagePW;
    public CardTvChannelPW cardTvChannelPW;
    public CardTvProgramPW cardTvProgramPW;
    public CardFilmPW cardFilmPW;
    public CardSerialPW cardSerialPW;
    public KidsPagePW kidsPagePW;
    public SportPagePW sportPagePW;
    public AllCollectionsPagePW allCollectionsPagePW;
    public PromoPagePW promoPagePW;
    public PersonalOfferPW personalOfferPW;
    public PackagesPagePW packagesPagePW;
    public CardPackagePW cardPackagePW;
    public PreconditionPW preconditionPW;
    public AuthPagePW authPagePW;
    public PromoCodePW promoCodePW;
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
            .builder()
            .apiUrl("http://localhost:4200")
            .apiKey("FHJV0S16FTMW50GT7GZR8RDJJSY0")
            .project("MFTV_Web")
            .branchName("master")
            .enableSoftAssert(false)
            .httpTimeoutInSeconds(60)
            .build());
//    public static final String USER_NAME = "bmp";
//    public static final String PASSWORD = "bmp";
//    public static final String URL = "jdbc:postgresql://10.236.24.178:5432/bmp";
//    public Statement statement;
//    public Connection connection;
//
//    {
//        try {
//            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
//        }
//    }
//    {
//        try{
//            statement = connection.createStatement();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
//        }
//    }
    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browserIncognitoModeHeadless = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(Arrays.asList("--disable-dev-shm-usage")));
        browserIncognitoModeHeadfull = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
    }
    @AfterAll
    void closeBrowser() {
        playwright.close();
    }
    public BrowserContext contextIncognitoModeHeadless;
    public BrowserContext contextIncognitoModeHeadfull;
    public Page page;
    public static Page pageCMS;

    @BeforeEach
    void createContextAndPage() throws IOException, InterruptedException, AWTException {
        contextIncognitoModeHeadless = browserIncognitoModeHeadless.newContext(new Browser.NewContextOptions()
                .setViewportSize(1900, 920));
//                .setViewportSize(1360, 760));
        contextIncognitoModeHeadfull = browserIncognitoModeHeadfull.newContext(new Browser.NewContextOptions()
                .setViewportSize(1900, 920));
//                .setViewportSize(1360, 760));
        contextIncognitoModeHeadless.clearCookies();
        contextIncognitoModeHeadfull.clearCookies();
        page = contextIncognitoModeHeadless.newPage();

        headerMenuPW = new HeaderMenuPW(page, pageCMS, contextIncognitoModeHeadless);
        filmsPagePW = new FilmsPagePW(page);
        serialsPagePW = new SerialsPagePW(page,pageCMS);
        nilPagePW = new NiLPagePW(page);
        collectionPagePW = new CollectionsPagePW(page);
        tvPagePW = new TvPagePW(page);
        cardTvChannelPW = new CardTvChannelPW(page);
        cardTvProgramPW = new CardTvProgramPW(page);
        cardFilmPW = new CardFilmPW(page);
        cardSerialPW = new CardSerialPW(page);
        kidsPagePW = new KidsPagePW(page);
        allCollectionsPagePW = new AllCollectionsPagePW(page);
        promoPagePW = new PromoPagePW(page);
        personalOfferPW = new PersonalOfferPW(page);
        packagesPagePW = new PackagesPagePW(page);
        cardPackagePW = new CardPackagePW(page);
        cardTvChannelPW = new CardTvChannelPW(page);
        //        preconditionPW = new PreconditionPW(page, statement);
        sportPagePW = new SportPagePW(page);
        authPagePW = new AuthPagePW(page);
        promoCodePW = new PromoCodePW(page);
        vrt.start();
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterEach
    void closeContext() throws IOException, InterruptedException {
        contextIncognitoModeHeadless.close();
        vrt.stop();
    }
}
