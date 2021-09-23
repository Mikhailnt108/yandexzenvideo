package base;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(CONCURRENT)
//@ExtendWith(TestRailReportExtension.class)
public class TestBaseWebDriver {
    public WebDriver webDriver;
    public HeaderMenu headerMenu;
    public PopUpInputPhone popUpInputPhone;
    public PopUpInputPassword popUpInputPassword;
    public FilmsPageWebDriver filmsPage;
    public PopUpInputPromoCod popUpInputPromoCod;
    public CardSerial cardSerial;
    public SerialsPageWebDriver serialsPage;
    public PackagesPageWebDriver packagesPage;
    public CardPackage cardPackage;
    public CardTvChannel cardTvChannel;
    public CardTvProgram cardTvProgram;
    public PopUpCreatePassword popUpCreatePassword;
    public PopUpInputCod popUpInputCod;
    public PageWebDriverCMS pageCMS;
    public ResultsSearchPageWebDriver resultsSearchPage;
    public CollectionPageWebDriver collectionsPage;
    public CardFilm cardFilm;
    public Footer footer;
    public TvPageWebDriver tvPage;
    public MyPageWebDriver myPage;
    public NilPageWebDriver nilPage;
    public PaymentContent paymentContent;
    public KidsPageWebDriver kidsPage;
    public SportPageWebDriver sportPage;
    public AllCollectionsPageWebDriver allCollectionsPage;
    public PromoPageWebDriver promoPage;
    public PopUpInputEmail popUpInputEmail;
    public PopUpNotification popUpNotification;
    public PromoCode promoCode;
    public PersonalOffer personalOffer;
    public RatingPageWebDriver ratingPage;


    @BeforeEach
    public void start() throws AWTException, MalformedURLException {
        // start remote browser:
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "93.0");
////        capabilities.setCapability("resolution","1920x1080");
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", false
//        ));
//        RemoteWebDriver webDriver = new RemoteWebDriver(
//                URI.create("http://192.168.1.139:4444/wd/hub").toURL(),
//                capabilities
//        );
//        webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
//        WebDriverRunner.setWebDriver(webDriver);

        // start local browser:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("start-maximized");
        //запуск браузера в фоне:
        //options.setHeadless(true);
        webDriver = new ChromeDriver(options);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(webDriver);
        headerMenu = PageFactory.initElements(webDriver, HeaderMenu.class);
        popUpInputPhone = PageFactory.initElements(webDriver, PopUpInputPhone.class);
        popUpInputPassword = PageFactory.initElements(webDriver, PopUpInputPassword.class);
        filmsPage = PageFactory.initElements(webDriver, FilmsPageWebDriver.class);
        popUpInputPromoCod = PageFactory.initElements(webDriver, PopUpInputPromoCod.class);
        cardSerial = PageFactory.initElements(webDriver, CardSerial.class);
        serialsPage = PageFactory.initElements(webDriver, SerialsPageWebDriver.class);
        packagesPage = PageFactory.initElements(webDriver, PackagesPageWebDriver.class);
        cardPackage = PageFactory.initElements(webDriver, CardPackage.class);
        cardTvChannel = PageFactory.initElements(webDriver, CardTvChannel.class);
        cardTvProgram = PageFactory.initElements(webDriver, CardTvProgram.class);
        popUpCreatePassword = PageFactory.initElements(webDriver, PopUpCreatePassword.class);
        popUpInputCod = PageFactory.initElements(webDriver, PopUpInputCod.class);
        pageCMS = PageFactory.initElements(webDriver, PageWebDriverCMS.class);
        resultsSearchPage = PageFactory.initElements(webDriver, ResultsSearchPageWebDriver.class);
        collectionsPage = PageFactory.initElements(webDriver, CollectionPageWebDriver.class);
        cardFilm = PageFactory.initElements(webDriver, CardFilm.class);
        footer = PageFactory.initElements(webDriver, Footer.class);
        tvPage = PageFactory.initElements(webDriver, TvPageWebDriver.class);
        myPage = PageFactory.initElements(webDriver, MyPageWebDriver.class);
        nilPage = PageFactory.initElements(webDriver, NilPageWebDriver.class);
        paymentContent = PageFactory.initElements(webDriver, PaymentContent.class);
        kidsPage = PageFactory.initElements(webDriver, KidsPageWebDriver.class);
        sportPage = PageFactory.initElements(webDriver, SportPageWebDriver.class);
        allCollectionsPage = PageFactory.initElements(webDriver, AllCollectionsPageWebDriver.class);
        promoPage = PageFactory.initElements(webDriver, PromoPageWebDriver.class);
        popUpInputEmail = PageFactory.initElements(webDriver, PopUpInputEmail.class);
        popUpNotification = PageFactory.initElements(webDriver, PopUpNotification.class);
        promoCode = PageFactory.initElements(webDriver, PromoCode.class);
        personalOffer = PageFactory.initElements(webDriver, PersonalOffer.class);
        ratingPage = PageFactory.initElements(webDriver, RatingPageWebDriver.class);
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterEach
    public void finish() {
//        Optional.ofNullable(WebDriverRunner.getWebDriver()).ifPresent(WebDriver::quit);
        webDriver.quit();
    }
}
