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
public class TestBase {

    public static WebDriver driver;
    public static HeaderMenu headerMenu;
    public static PopUpInputPhone popUpInputPhone;
    public static PopUpInputPassword popUpInputPassword;
    public static FilmsPage filmsPage;
    public static PopUpInputPromoCod popUpInputPromoCod;
    public static CardSerial cardSerial;
    public static SerialsPage serialsPage;
    public static PackagesPage packagesPage;
    public static CardPackage cardPackage;
    public static CardTvChannel cardTvChannel;
    public static CardTvProgram cardTvProgram;
    public static PopUpCreatePassword popUpCreatePassword;
    public static PopUpInputCod popUpInputCod;
    public static PageCMS pageCMS;
    public static ResultsSearchPage resultsSearchPage;
    public static CollectionPage collectionsPage;
    public static CardFilm cardFilm;
    public static Footer footer;
    public static TvPage tvPage;
    public static MyPage myPage;
    public static NilPage nilPage;
    public static PaymentContent paymentContent;
    public static KidsPage kidsPage;
    public static SportPage sportPage;
    public static AllCollectionsPage allCollectionsPage;
    public static PromoPage promoPage;
    public static PopUpInputEmail popUpInputEmail;
    public static PopUpNotification popUpNotification;
    public static PromoCode promoCode;
    public static PersonalOffer personalOffer;
    public static RatingPage ratingPage;

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
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        headerMenu = PageFactory.initElements(driver, HeaderMenu.class);
        popUpInputPhone = PageFactory.initElements(driver, PopUpInputPhone.class);
        popUpInputPassword = PageFactory.initElements(driver, PopUpInputPassword.class);
        filmsPage = PageFactory.initElements(driver, FilmsPage.class);
        popUpInputPromoCod = PageFactory.initElements(driver, PopUpInputPromoCod.class);
        cardSerial = PageFactory.initElements(driver, CardSerial.class);
        serialsPage = PageFactory.initElements(driver, SerialsPage.class);
        packagesPage = PageFactory.initElements(driver, PackagesPage.class);
        cardPackage = PageFactory.initElements(driver, CardPackage.class);
        cardTvChannel = PageFactory.initElements(driver, CardTvChannel.class);
        cardTvProgram = PageFactory.initElements(driver, CardTvProgram.class);
        popUpCreatePassword = PageFactory.initElements(driver, PopUpCreatePassword.class);
        popUpInputCod = PageFactory.initElements(driver, PopUpInputCod.class);
        pageCMS = PageFactory.initElements(driver, PageCMS.class);
        resultsSearchPage = PageFactory.initElements(driver, ResultsSearchPage.class);
        collectionsPage = PageFactory.initElements(driver, CollectionPage.class);
        cardFilm = PageFactory.initElements(driver, CardFilm.class);
        footer = PageFactory.initElements(driver, Footer.class);
        tvPage = PageFactory.initElements(driver, TvPage.class);
        myPage = PageFactory.initElements(driver, MyPage.class);
        nilPage = PageFactory.initElements(driver, NilPage.class);
        paymentContent = PageFactory.initElements(driver, PaymentContent.class);
        kidsPage = PageFactory.initElements(driver, KidsPage.class);
        sportPage = PageFactory.initElements(driver, SportPage.class);
        allCollectionsPage = PageFactory.initElements(driver, AllCollectionsPage.class);
        promoPage = PageFactory.initElements(driver, PromoPage.class);
        popUpInputEmail = PageFactory.initElements(driver, PopUpInputEmail.class);
        popUpNotification = PageFactory.initElements(driver, PopUpNotification.class);
        promoCode = PageFactory.initElements(driver, PromoCode.class);
        personalOffer = PageFactory.initElements(driver, PersonalOffer.class);
        ratingPage = PageFactory.initElements(driver, RatingPage.class);

        driver.manage().deleteAllCookies();

        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterAll
    public static void finish() {
        driver.quit();
    }
}
