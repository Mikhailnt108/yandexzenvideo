package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
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

    public final String USER_NAME = "bmp";
    public final String PASSWORD = "bmp";
    public final String URL = "jdbc:postgresql://10.236.24.176:5432/bmp";
    public Statement statement;
    public Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
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
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "96.0");
//        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
//        Configuration.pageLoadTimeout = 60000;
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));
        RemoteWebDriver webDriver = new RemoteWebDriver(
                URI.create("http://192.168.1.139:4444/wd/hub").toURL(),
                capabilities
        );
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

        headerMenu = PageFactory.initElements(webDriver, HeaderMenu.class);
        filmsPage = PageFactory.initElements(webDriver, FilmsPage.class);
        cardSerial = PageFactory.initElements(webDriver, CardSerial.class);
        serialsPage = PageFactory.initElements(webDriver, SerialsPage.class);
        packagesPage = PageFactory.initElements(webDriver, PackagesPage.class);
        cardPackage = PageFactory.initElements(webDriver, CardPackage.class);
        cardTvChannel = PageFactory.initElements(webDriver, CardTvChannel.class);
        cardTvProgram = PageFactory.initElements(webDriver, CardTvProgram.class);
        pageCMS = PageFactory.initElements(webDriver, PageCMS.class);
        resultsSearchPage = PageFactory.initElements(webDriver, ResultsSearchPage.class);
        collectionsPage = PageFactory.initElements(webDriver, CollectionPage.class);
        cardFilm = new CardFilm(webDriver, statement);
        footer = PageFactory.initElements(webDriver, Footer.class);
        tvPage = PageFactory.initElements(webDriver, TvPage.class);
        myPage = PageFactory.initElements(webDriver, MyPage.class);
        nilPage = PageFactory.initElements(webDriver, NilPage.class);
        kidsPage = PageFactory.initElements(webDriver, KidsPage.class);
        sportPage = PageFactory.initElements(webDriver, SportPage.class);
        allCollectionsPage = PageFactory.initElements(webDriver, AllCollectionsPage.class);
        promoPage = PageFactory.initElements(webDriver, PromoPage.class);
        popUpNotification = PageFactory.initElements(webDriver, PopUpNotification.class);
        promoCode = PageFactory.initElements(webDriver, PromoCode.class);
        personalOffer = PageFactory.initElements(webDriver, PersonalOffer.class);
        ratingPage = PageFactory.initElements(webDriver, RatingPage.class);
        paymentContent = PageFactory.initElements(webDriver, PaymentContent.class);
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
