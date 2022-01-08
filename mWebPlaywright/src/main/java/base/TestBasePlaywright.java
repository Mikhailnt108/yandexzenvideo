package base;

import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import pagesPlaywright.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//@ExtendWith(TestRailReportExtension.class)
public class TestBasePlaywright extends BasePagePlaywright{

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
    public String frontend = "https://web-preprod6.megafon.tv/";
    public String backend = "https://bmp-preprod6.megafon.tv/";
    public String numberBankCard = "4847 0000 6602 5312";
    public String dataValidity = "12 / 25";
    public String codeCVV = "258";
    public static VisualRegressionTracker vrt = new VisualRegressionTracker(VisualRegressionTrackerConfig
            .builder()
            .apiUrl("http://192.168.1.139:4200")
            .apiKey("GVDZMJKMBM4D5BNMZN57AEBVBKM0")
            .project("MFTV_mWeb_Android_Chrome")
            .branchName("master")
            .enableSoftAssert(false)
            .httpTimeoutInSeconds(60)
            .build());
    public static final String USER_NAME = "bmp";
    public static final String PASSWORD = "bmp";
    public static final String PP1 = "jdbc:postgresql://10.236.24.174:5432/bmp";
    public static final String PP2 = "jdbc:postgresql://10.236.24.175:5432/bmp";
    public static final String PP3 = "jdbc:postgresql://10.236.24.176:5432/bmp";
    public static final String PP4 = "jdbc:postgresql://10.236.24.177:5432/bmp";
    public static final String PP5 = "jdbc:postgresql://10.236.24.178:5432/bmp";
    public static final String PP6 = "jdbc:postgresql://10.236.24.196:5432/bmp";
    public static final String PP7 = "jdbc:postgresql://10.236.24.197:5432/bmp";
    public Statement statement;
    public Connection connection;
    {
        try {
            connection = DriverManager.getConnection(PP6,USER_NAME,PASSWORD);
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
        browserIncognitoModeHeadless = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false)
                .setArgs(Arrays.asList("--disable-dev-shm-usage"))
                .setArgs(Arrays.asList("--whitelisted-ips")));
        browserIncognitoModeHeadfull = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false)
                .setArgs(Arrays.asList("--disable-dev-shm-usage"))
                .setArgs(Arrays.asList("--whitelisted-ips")));
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
//                .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1")
                .setUserAgent("Mozilla/5.0 (Linux; Android 10; HRY-LX1T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Mobile Safari/537.36")
                .setViewportSize(360, 640) // смартфорн
                .setIsMobile(true)
                .setHasTouch(true));
//                .setViewportSize(1360, 760));  // ноутбук
        contextIncognitoModeHeadfull = browserIncognitoModeHeadfull.newContext(new Browser.NewContextOptions()
//               .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1")
                .setUserAgent("Mozilla/5.0 (Linux; Android 10; HRY-LX1T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Mobile Safari/537.36")
                .setViewportSize(360, 640) // смартфон
                .setIsMobile(true)
                .setHasTouch(true));
        contextIncognitoModeHeadless.clearCookies();
        contextIncognitoModeHeadfull.clearCookies();
        page = contextIncognitoModeHeadless.newPage();
        page.setDefaultTimeout(40000);
        headerMenuPW = new HeaderMenuPW(page, pageCMS, contextIncognitoModeHeadless, frontend, backend);
        filmsPagePW = new FilmsPagePW(page, frontend);
        serialsPagePW = new SerialsPagePW(page,pageCMS, frontend);
        nilPagePW = new NiLPagePW(page, pageSmartTv, contextIncognitoModeHeadless, frontend);
        collectionPagePW = new CollectionsPagePW(page);
        tvPagePW = new TvPagePW(page, frontend, statement);
        cardTvChannelPW = new CardTvChannelPW(page);
        cardTvProgramPW = new CardTvProgramPW(page, frontend);
        cardFilmPW = new CardFilmPW(page, statement, frontend);
        cardSerialPW = new CardSerialPW(page, frontend);
        kidsPagePW = new KidsPagePW(page, frontend);
        allCollectionsPagePW = new AllCollectionsPagePW(page, frontend);
        promoPagePW = new PromoPagePW(page, frontend, backend);
        personalOfferPW = new PersonalOfferPW(page, backend);
        packagesPagePW = new PackagesPagePW(page);
        cardPackagePW = new CardPackagePW(page, numberBankCard, dataValidity, codeCVV);
        cardTvChannelPW = new CardTvChannelPW(page);
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
