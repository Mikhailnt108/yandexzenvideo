package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class SerialsPagePW extends BasePagePlaywright {
    private Page page;
    private Page pageCMS;
    private BrowserContext context;
    private Browser browser;

    public SerialsPagePW (Page page, Page pageCMS, BrowserContext context) {
        this.page = page;
        this.pageCMS = pageCMS;
        this.context = context;
        this.browser = context.browser();
    }
    public void screenshotSerialsPagePW () {
        page.navigate("https://web-preprod5.megafon.tv/shows");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + ".png")));
        page.click("text=Новые серии");
        page.navigate("https://web-preprod5.megafon.tv/shows");
        page.click("text=Веб-сериалы");
    }
}
