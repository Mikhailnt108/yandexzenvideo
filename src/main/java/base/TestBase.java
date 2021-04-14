package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public HeaderMenu headerMenu;
    public PopUpInputPhone popUpInputPhone;
    public PopUpInputPassword popUpInputPassword;
    public FilmsPage filmsPage;
    public PopUpInputPromoCod popUpInputPromoCod;
    public CardSerial cardSerial;
    public SerialsPage serialsPage;
    public PackagesPage packagesPage;
    public CardPackage cardPackage;
    public CardTvChannel cardTvChannel;
    public CardTvProgram cardTvProgram;
    public PopUpCreatePassword popUpCreatePassword;
    public PopUpInputCod popUpInputCod;
    public PageCMS pageCMS;
    public ResultsSearchPage resultsSearchPage;
    public CollectionPage collectionPage;
    public CardFilm cardFilm;
    public Footer footer;
    public TvPage tvPage;
    public MyPage myPage;
    public NilPage nilPage;
    public PaymentContent paymentContent;
    public KidsPage kidsPage;
    public SportPage sportPage;
    public AllCollectionsPage allCollectionsPage;
    public PromoPage promoPage;
    public PopUpInputEmail popUpInputEmail;
    public PopUpNotification popUpNotification;
    public PromoCode promoCode;





    @BeforeEach
    public void start() throws AWTException {

        WebDriverManager.chromedriver().setup();
        //запуск браузера в режиме инкогнито:
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("-incognito");
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new ChromeDriver(capabilities);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--window-size=1900,1000");
        //options.addArguments("enable-features=NetworkServiceInProcess");
        //options.addArguments("disable-features=NetworkService");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-browser-side-navigation");
//        options.addArguments("enable-automation");
        options.addArguments("--window-size=1920,1070");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--dns-prefetch-disable");
//        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //options.addArguments("start-maximized");
        //запуск браузера в фоне:
        //options.setHeadless(true);
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(32, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(32, TimeUnit.SECONDS);
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
        collectionPage = PageFactory.initElements(driver, CollectionPage.class);
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

        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @AfterEach
    public void finish() {

        driver.quit();
    }

}
