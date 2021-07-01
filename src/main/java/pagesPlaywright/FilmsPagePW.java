package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class FilmsPagePW extends BasePagePlaywright {
    private Page page;

    public FilmsPagePW(Page page){
        this.page = page;
    }

    public void screenshotFilmsPagePW() {
            page.navigate("https://web-preprod5.megafon.tv/movies/vods");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + ".png")));
            page.click("text=Премьеры");
            page.navigate("https://web-preprod5.megafon.tv/movies/vods");
            page.click("text=Русские фильмы");
        }
    }




