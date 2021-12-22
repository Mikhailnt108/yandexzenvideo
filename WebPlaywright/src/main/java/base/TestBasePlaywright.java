package base;

import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import pagesPlaywright.*;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    public String frontend = "https://web-preprod7.megafon.tv/";
    public String backend = "https://bmp-preprod7.megafon.tv/";
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
            .builder()
            .apiUrl("http://192.168.1.139:4200")
            .apiKey("GVDZMJKMBM4D5BNMZN57AEBVBKM0")
            .project("MFTV_Web_Chrome")
            .branchName("master")
            .enableSoftAssert(false)
            .httpTimeoutInSeconds(60)
            .build());
    public static final String USER_NAME = "bmp";
    public static final String PASSWORD = "bmp";
    public static final String PP3 = "jdbc:postgresql://10.236.24.176:5432/bmp";
    public static final String PP6 = "jdbc:postgresql://10.236.24.196:5432/bmp";
    public static final String PP7 = "jdbc:postgresql://10.236.24.197:5432/bmp";
    public Statement statement;
    public Connection connection;

    {
        try {
            connection = DriverManager.getConnection(PP7,USER_NAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    {
        try{
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browserIncognitoModeHeadless = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true).setArgs(Arrays.asList("--disable-dev-shm-usage")).setArgs(Arrays.asList("--whitelisted-ips")));
        browserIncognitoModeHeadfull = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true).setArgs(Arrays.asList("--disable-dev-shm-usage")).setArgs(Arrays.asList("--whitelisted-ips")));
    }
    @AfterAll
    void closeBrowser() {
        playwright.close();
    }
    public BrowserContext contextIncognitoModeHeadless;
    public BrowserContext contextIncognitoModeHeadfull;
    public Page page;
    public static Page pageCMS;
    public static Page pageSmartTv;

    @BeforeEach
    void createContextAndPage() throws IOException, InterruptedException{
        contextIncognitoModeHeadless = browserIncognitoModeHeadless.newContext(new Browser.NewContextOptions()
                .setViewportSize(1900, 920));    // моноблок
//                .setViewportSize(1360, 760));  // ноутбук
        contextIncognitoModeHeadfull = browserIncognitoModeHeadfull.newContext(new Browser.NewContextOptions()
                .setViewportSize(1900, 920));   // моноблок
//                .setViewportSize(1360, 760)); // ноутбук
        contextIncognitoModeHeadless.clearCookies();
        contextIncognitoModeHeadfull.clearCookies();
        page = contextIncognitoModeHeadless.newPage();
        page.setDefaultTimeout(160000);

        headerMenuPW = new HeaderMenuPW(page, pageCMS, contextIncognitoModeHeadless, frontend, backend);
        filmsPagePW = new FilmsPagePW(page, frontend);
        serialsPagePW = new SerialsPagePW(page,pageCMS, frontend);
        nilPagePW = new NiLPagePW(page, pageSmartTv, contextIncognitoModeHeadless, frontend);
        collectionPagePW = new CollectionsPagePW(page);
        tvPagePW = new TvPagePW(page, frontend);
        cardTvChannelPW = new CardTvChannelPW(page, frontend);
        cardTvProgramPW = new CardTvProgramPW(page, frontend);
        cardFilmPW = new CardFilmPW(page, statement, frontend);
        cardSerialPW = new CardSerialPW(page, frontend);
        kidsPagePW = new KidsPagePW(page, frontend);
        allCollectionsPagePW = new AllCollectionsPagePW(page, frontend);
        promoPagePW = new PromoPagePW(page, frontend);
        personalOfferPW = new PersonalOfferPW(page, backend);
        packagesPagePW = new PackagesPagePW(page);
        cardPackagePW = new CardPackagePW(page);
        preconditionPW = new PreconditionPW(page, statement, frontend, backend);
        sportPagePW = new SportPagePW(page, backend);
        authPagePW = new AuthPagePW(page, frontend);
        promoCodePW = new PromoCodePW(page, frontend, backend);
        vrt.start();
//        Robot bot = new Robot();
//        bot.mouseMove(0, 0);
    }

    @AfterEach
    void closeContext() throws IOException, InterruptedException {
        contextIncognitoModeHeadless.close();
        vrt.stop();
    }
}
