package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@ExtendWith(TestRailReportExtension.class)
public class TestBaseWebDriver {
    public static WebDriver webDriver;
    public static HeaderMenu headerMenu;
    public static PopUpInputPhone popUpInputPhone;
    public static PopUpInputPassword popUpInputPassword;
    public static FilmsPageWebDriver filmsPage;
    public static PopUpInputPromoCod popUpInputPromoCod;
    public static CardSerial cardSerial;
    public static SerialsPageWebDriver serialsPage;
    public static PackagesPageWebDriver packagesPage;
    public static CardPackage cardPackage;
    public static CardTvChannel cardTvChannel;
    public static CardTvProgram cardTvProgram;
    public static PopUpCreatePassword popUpCreatePassword;
    public static PopUpInputCod popUpInputCod;
    public static PageWebDriverCMS pageCMS;
    public static ResultsSearchPageWebDriver resultsSearchPage;
    public static CollectionPageWebDriver collectionsPage;
    public static CardFilm cardFilm;
    public static Footer footer;
    public static TvPageWebDriver tvPage;
    public static MyPageWebDriver myPage;
    public static NilPageWebDriver nilPage;
    public static PaymentContent paymentContent;
    public static KidsPageWebDriver kidsPage;
    public static SportPageWebDriver sportPage;
    public static AllCollectionsPageWebDriver allCollectionsPage;
    public static PromoPageWebDriver promoPage;
    public static PopUpInputEmail popUpInputEmail;
    public static PopUpNotification popUpNotification;
    public static PromoCode promoCode;
    public static PersonalOffer personalOffer;
    public static RatingPageWebDriver ratingPage;

    @BeforeAll
    public static void start() throws AWTException {
        WebDriverManager.chromedriver().setup();
        //запуск браузера в режиме инкогнито:
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("-incognito");
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new ChromeDriver(capabilities);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--window-size=1900,1000");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("start-maximized");
        //запуск браузера в фоне:
        //options.setHeadless(true);
        webDriver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
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

        webDriver.manage().deleteAllCookies();

        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterAll
    public static void finish() {
        webDriver.quit();
    }
}
