package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(TestRailReportExtension.class)
public class TestBaseWebDriver {
    public WebDriver webDriver;
    public HeaderMenu headerMenu;
    public FilmsPage filmsPage;
    public CardSerial cardSerial;
    public SerialsPage serialsPage;
    public PackagesPage packagesPage;
    public CardPackage cardPackage;
    public CardTvChannel cardTvChannel;
    public CardTvProgram cardTvProgram;
    public PageCMS pageCMS;
    public ResultsSearchPage resultsSearchPage;
    public CollectionPage collectionsPage;
    public CardFilm cardFilm;
    public Footer footer;
    public TvPage tvPage;
    public MyPage myPage;
    public NilPage nilPage;
    public KidsPage kidsPage;
    public SportPage sportPage;
    public AllCollectionsPage allCollectionsPage;
    public PromoPage promoPage;
    public PopUpNotification popUpNotification;
    public PromoCode promoCode;
    public PersonalOffer personalOffer;
    public RatingPage ratingPage;
    public PaymentContent paymentContent;
    public String frontend = "https://web-preprod6.megafon.tv/";
    public String backend = "https://bmp-preprod6.megafon.tv/";

    public String numberBankCard = "4847 0000 6602 5312";
    public String dataValidity = "12 / 25";
    public String codeCVV = "258";
    public final String USER_NAME = "bmp";
    public final String PASSWORD = "bmp";
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
    @BeforeEach
    public void start() throws MalformedURLException {
        // start remote browser:
//        System.setProperty("http.proxyHost", "proxy.megalabs.ru");
//        System.setProperty("http.proxyPort", "8808");
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("http://proxy.megalabs.ru:8808");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("goog:chromeOptions",chromeOptions);
        chromeOptions.setCapability("browserName","chrome");
        chromeOptions.setCapability("browserVersion", "97.0");
        chromeOptions.setCapability("platformName", "linux");
        chromeOptions.setCapability("pageLoadStrategy","normal");
        chromeOptions.setHeadless(false);
//        chromeOptions.addArguments("--proxy-pac-url=http://myPacFile.com");
        WebDriver webDriver = new RemoteWebDriver(new URL("http://192.168.1.139:4444"), chromeOptions);
        Configuration.pageLoadTimeout = 60000;
        webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        WebDriverRunner.setWebDriver(webDriver);

//        // start local browser:
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        options.addArguments("start-maximized");
//
//        // запуск браузера в фоне:
//        options.setHeadless(false);
//        webDriver = new ChromeDriver(options);
//        WebDriverRunner.setWebDriver(webDriver);

        headerMenu = new HeaderMenu(webDriver, frontend, backend);
        filmsPage = new FilmsPage(webDriver, frontend, backend);
        cardSerial = new CardSerial(webDriver, frontend, backend);
        serialsPage = new SerialsPage(webDriver, frontend, backend);
        packagesPage = new PackagesPage(webDriver);
        cardPackage = new CardPackage(webDriver, frontend, backend, numberBankCard, dataValidity, codeCVV);
        cardTvChannel = new CardTvChannel(webDriver);
        cardTvProgram = new CardTvProgram(webDriver, frontend, backend);
        pageCMS = new PageCMS(webDriver, frontend, backend);
        resultsSearchPage = new ResultsSearchPage(webDriver);
        collectionsPage = new CollectionPage(webDriver);
        cardFilm = new CardFilm(webDriver, statement, frontend, backend);
        footer = new Footer(webDriver, frontend, backend);
        tvPage = new TvPage(webDriver);
        myPage = new MyPage(webDriver, frontend, backend);
        nilPage = new NilPage(webDriver, frontend, backend);
        kidsPage = new KidsPage(webDriver, frontend, backend);
        sportPage = new SportPage(webDriver);
        allCollectionsPage = new AllCollectionsPage(webDriver, frontend, backend);
        promoPage = new PromoPage(webDriver);
        popUpNotification = new PopUpNotification(webDriver, frontend, backend);
        promoCode = new PromoCode(webDriver, frontend, backend);
        personalOffer = new PersonalOffer(webDriver, frontend, backend);
        ratingPage = new RatingPage(webDriver);
        paymentContent = new PaymentContent(webDriver);
        personalOffer.archivePersonalOfferTypePartnerOfferForNonMF();
        personalOffer.archivePersonalOfferSubscription();
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOffer.archivePersonalOfferPartnerOfferOkkoTvForMF();
        popUpNotification.deletePopUpNotifScreenNilPayFilm();
    }

    @AfterEach
    public void finish() {
        Optional.ofNullable(WebDriverRunner.getWebDriver()).ifPresent(WebDriver::quit);
//        webDriver.quit();
    }
}
