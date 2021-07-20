package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class SerialsPagePW extends BasePagePlaywright {
    private Page page;

    public SerialsPagePW (Page page) {
        this.page = page;
    }
    public void screenshotSerialsPagePW () {
        page.navigate("https://web-preprod5.megafon.tv/shows");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + ".png")));
        page.click("text=Новые серии");
        page.navigate("https://web-preprod5.megafon.tv/shows");
        page.click("text=Веб-сериалы");
    }
}
