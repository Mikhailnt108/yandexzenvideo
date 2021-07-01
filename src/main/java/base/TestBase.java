package base;

import com.automation.remarks.junit.VideoRule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Rule;
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
    public static WebDriver webDriver;
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
        webDriver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        headerMenu = PageFactory.initElements(webDriver, HeaderMenu.class);
        popUpInputPhone = PageFactory.initElements(webDriver, PopUpInputPhone.class);
        popUpInputPassword = PageFactory.initElements(webDriver, PopUpInputPassword.class);
        filmsPage = PageFactory.initElements(webDriver, FilmsPage.class);
        popUpInputPromoCod = PageFactory.initElements(webDriver, PopUpInputPromoCod.class);
        cardSerial = PageFactory.initElements(webDriver, CardSerial.class);
        serialsPage = PageFactory.initElements(webDriver, SerialsPage.class);
        packagesPage = PageFactory.initElements(webDriver, PackagesPage.class);
        cardPackage = PageFactory.initElements(webDriver, CardPackage.class);
        cardTvChannel = PageFactory.initElements(webDriver, CardTvChannel.class);
        cardTvProgram = PageFactory.initElements(webDriver, CardTvProgram.class);
        popUpCreatePassword = PageFactory.initElements(webDriver, PopUpCreatePassword.class);
        popUpInputCod = PageFactory.initElements(webDriver, PopUpInputCod.class);
        pageCMS = PageFactory.initElements(webDriver, PageCMS.class);
        resultsSearchPage = PageFactory.initElements(webDriver, ResultsSearchPage.class);
        collectionsPage = PageFactory.initElements(webDriver, CollectionPage.class);
        cardFilm = PageFactory.initElements(webDriver, CardFilm.class);
        footer = PageFactory.initElements(webDriver, Footer.class);
        tvPage = PageFactory.initElements(webDriver, TvPage.class);
        myPage = PageFactory.initElements(webDriver, MyPage.class);
        nilPage = PageFactory.initElements(webDriver, NilPage.class);
        paymentContent = PageFactory.initElements(webDriver, PaymentContent.class);
        kidsPage = PageFactory.initElements(webDriver, KidsPage.class);
        sportPage = PageFactory.initElements(webDriver, SportPage.class);
        allCollectionsPage = PageFactory.initElements(webDriver, AllCollectionsPage.class);
        promoPage = PageFactory.initElements(webDriver, PromoPage.class);
        popUpInputEmail = PageFactory.initElements(webDriver, PopUpInputEmail.class);
        popUpNotification = PageFactory.initElements(webDriver, PopUpNotification.class);
        promoCode = PageFactory.initElements(webDriver, PromoCode.class);
        personalOffer = PageFactory.initElements(webDriver, PersonalOffer.class);
        ratingPage = PageFactory.initElements(webDriver, RatingPage.class);

        webDriver.manage().deleteAllCookies();

        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterAll
    public static void finish() {
        webDriver.quit();
    }
}
