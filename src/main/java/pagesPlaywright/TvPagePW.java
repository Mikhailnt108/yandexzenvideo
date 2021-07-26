package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class TvPagePW extends BasePagePlaywright {
    private Page page;


    public TvPagePW (Page page) {
        this.page = page;
    }

    public void checkImageTvPageTabProgramTvForUnauthorized() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate("https://web-preprod5.megafon.tv/tv");
        // подготовка полной страницы "TvPageTabProgramTv" к скриншот-тесту:
        List<ElementHandle> imgTvAll;
        List<ElementHandle> nameTvChannelAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        List<ElementHandle> timeAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]").size(); i++) {
            imgTvAll = page.querySelectorAll("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/27/3d/b7235e2c57e71de7283e923dec5feedfb69b/logo_tv_guide__web-wp.png')", imgTvAll.get(i));
            nameTvChannelAll = page.querySelectorAll("//div[@class='_16fO5taSmblh91J9Prw7TV']");
            page.evaluate("n => n.innerText='Название канала'", nameTvChannelAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//a[@class='_19SojadR5Q0BvNZTu4HCi1']");
            page.evaluate("d => d.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
            timeAll = page.querySelectorAll("//div[@class='y-1kJx0MnmrSqtKC7fdK0']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
        }

        // делаем скриншот видимой части страницы "TvPageTabProgramTv":
        vrt.track(
                "TvPageTabProgramTvForUnauthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TvPage.png")))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageTabTvProgramInAir() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/tv/tv_catalog");
        // подготовка полной страницы "TvPageTabTvProgramInAir" к скриншот-тесту:
        List<ElementHandle> posterTvProgramAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        List<ElementHandle> timeNameTvChannelAll;
        List<ElementHandle> progressAll;
        for (int i = 0; i < page.querySelectorAll("//a[@class='_3qpWWwbv1F2VcSRTSjiIgS']").size(); i++) {
            posterTvProgramAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']");
            page.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/31/25/f8f17fb50a914336ac35561afc290db5fe8f/tile__web-wp.webp);')", posterTvProgramAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//h3[@class='hhYBfS5SYd9UjRyn3tWgw']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
            timeNameTvChannelAll = page.querySelectorAll("//div[@class='_3jrfnhGV2HAWEcqDrup1qU']");
            page.evaluate("tN => tN.innerText='00:00, Discovery Channel HD'", timeNameTvChannelAll.get(i));
            progressAll = page.querySelectorAll("//span[@class='L3rzdT7KYzyE1ClBQKxNL']");
            page.evaluate("pR => pR.setAttribute('style', 'width: 50%; height: 4px; background-color: var(--color-base);')", progressAll.get(i));
        }

        // делаем скриншот видимой части страницы "TvPageTabTvProgramInAir":
        vrt.track(
                "TvPageTabTvProgramInAirForUnauthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToTailTvProgram() {
        page.click("(//a[@class='_3qpWWwbv1F2VcSRTSjiIgS'])[3]");
    }

    public void clickOnTabInRecording() {
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
    }

    public void checkImageTvPageTabProgramTvForAuthorized() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate("https://web-preprod5.megafon.tv/tv");
        // подготовка полной страницы "TvPageTabProgramTv" к скриншот-тесту:
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        List<ElementHandle> imgTvAll;
        List<ElementHandle> nameTvChannelAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        List<ElementHandle> timeAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]").size(); i++) {
            imgTvAll = page.querySelectorAll("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/27/3d/b7235e2c57e71de7283e923dec5feedfb69b/logo_tv_guide__web-wp.png')", imgTvAll.get(i));
            nameTvChannelAll = page.querySelectorAll("//div[@class='_16fO5taSmblh91J9Prw7TV']");
            page.evaluate("n => n.innerText='Название канала'", nameTvChannelAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//a[@class='_19SojadR5Q0BvNZTu4HCi1']");
            page.evaluate("d => d.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
            timeAll = page.querySelectorAll("//div[@class='y-1kJx0MnmrSqtKC7fdK0']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
        }

        // делаем скриншот видимой части страницы "TvPageTabProgramTvForAuthorized":
        vrt.track(
                "TvPageTabProgramTvForAuthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TvPage.png")))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}

