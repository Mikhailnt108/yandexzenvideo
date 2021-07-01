package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pagesPlaywright.FilmsPagePW;
import pagesPlaywright.SerialsPagePW;

public class TestBasePlaywright extends BasePagePlaywright{
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static FilmsPagePW filmsPagePW;
    public static SerialsPagePW serialsPagePW;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
        page = browser.newPage();
        filmsPagePW = new FilmsPagePW(page);
        serialsPagePW = new SerialsPagePW(page);
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

//    @BeforeEach
//    void createContextAndPage() {
//        context = browser.newContext();
//        page = context.newPage();
//    }

//    @AfterEach
//    void closeContext() {
//        context.close();
//    }
//    @BeforeClass
//    public void setUp(){
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
//        Page page = browser.newPage();
//        page.navigate("https://automationbookstore.dev/");
//
//    }
}
