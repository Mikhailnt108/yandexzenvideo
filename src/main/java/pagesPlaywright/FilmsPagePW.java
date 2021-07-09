package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;

import static base.TestBasePlaywright.vrt;

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
    public void screenshotsFilmsPagePwUsingVRT() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        vrt.track("Films Page", Base64.getEncoder().encodeToString(page.screenshot()));
        page.click("text=Премьеры");
        vrt.track(
                "Collection Page",
                Base64.getEncoder().encodeToString(page.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .viewport("1240x1024")
                        .diffTollerancePercent(0.0f)
                        .build());
    }

}





