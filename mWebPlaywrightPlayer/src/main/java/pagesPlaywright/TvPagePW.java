package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class TvPagePW extends BasePagePlaywright {
    private Page page;
    private String frontend;


    public TvPagePW(Page page, String frontend) {
        this.page = page;
        this.frontend = frontend;
    }

    public void checkImageTvPageForGuestMWEB() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate(frontend+"tv");
        // подготовка полной страницы "TvPageTabProgramTvForGuest" к скриншот-тесту:
        List<ElementHandle> imgTvAll = page.querySelectorAll("//div[@class='_23E9FFV9LhyYMGP2R_4Hjv']");
        for(ElementHandle imgTv : imgTvAll){
            imgTv.evaluate("iT => iT.setAttribute('style', 'background-image: url(http://static.cdn.megafon.tv/images/Channel/27/3d/b7235e2c57e71de7283e923dec5feedfb69b/logo_on_air__iphone-x.png);')");
        }
        List<ElementHandle> nameTvChannelAll = page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko']");
        for(ElementHandle nameTvChannel : nameTvChannelAll){
            nameTvChannel.evaluate("n => n.innerText='Название канала'");
        }
        List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//a[contains(@class,'_2kFyYGffe-aoW_cqXclDoD')]");
        for(ElementHandle nameTvProgram : nameTvProgramAll){
            nameTvProgram.evaluate("d => d.textContent='Название передачи'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> timeAll = page.querySelectorAll("//a[@class='_3S1RJTAMPdfXwKpE8keuSk _2vXRFPIn0aB5dHsDcWV_MP']");
        for(ElementHandle time : timeAll){
            time.evaluate("t => t.innerText='00:00'");
        }


        // делаем скриншот видимой части страницы "TvPageTabProgramTvForGuest":
        vrt.track(
                "TvPageTabProgramTvForGuestAndroidMWEB",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageTabTvProgramInAirForGuestMWEB() throws IOException, InterruptedException {
        page.navigate(frontend+"tv/tv_catalog");
        // подготовка полной страницы "TvPageTabTvProgramInAirForGuest" к скриншот-тесту:
        List<ElementHandle> tailAll = page.querySelectorAll("(//a[contains(@href,'/tv/channels/')])[position()>18]");
        for (ElementHandle tailRemove : tailAll) {
            tailRemove.evaluate("t => t.remove();");
        }

        List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//h3[@class='hhYBfS5SYd9UjRyn3tWgw']");
        for(ElementHandle nameTvProgram : nameTvProgramAll){
            nameTvProgram.evaluate("nP => nP.textContent='Название передачи'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> timeNameTvChannelAll = page.querySelectorAll("//div[@class='_3jrfnhGV2HAWEcqDrup1qU']");
        for(ElementHandle timeNameTvChannel : timeNameTvChannelAll){
            timeNameTvChannel.evaluate("tN => tN.innerText='00:00, Discovery Channel HD'");
        }
        List<ElementHandle> progressAll = page.querySelectorAll("//span[@class='L3rzdT7KYzyE1ClBQKxNL']");
        for(ElementHandle progress : progressAll){
            progress.evaluate("pR => pR.setAttribute('style', 'width: 50%; height: 4px; background-color: var(--color-base);')");
        }
        List<ElementHandle> posterTvProgramAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']");
        for(ElementHandle posterTvProgram : posterTvProgramAll){
            posterTvProgram.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/31/25/f8f17fb50a914336ac35561afc290db5fe8f/tile__web-wp.webp);')");
        }
        // делаем скриншот видимой части страницы "TvPageTabTvProgramInAirForGuest":
        vrt.track(
                "TvPageTabTvProgramInAirForGuest",
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

    public void checkImageTvPageTabProgramTvForAuthorizedMWEB() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate(frontend+"tv");
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
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsTvPage() {
        page.waitForSelector("//div[contains(@class,'smartbanner-android')]");
        page.waitForSelector("//div[@class='YZBWFgwJ_YIq52D_M0HUz']");
        page.waitForSelector("//a[@class='_2lyBKIjmUqLXlMuC-NbqUe _3h6ZZnjTUm-EUZUfiI5SOR']//span[text()='ТВ']");
        page.waitForSelector("//div[@class='zcd66G8sCa_vpFpPNWBNz']");
        page.waitForSelector("//a[@class='_39I3V1X9nHf1r_IzNeqphS _1Ue0f9dD5er3cByaAe2IwI']//div[text()='Все']");
        page.waitForSelector("//a[@class='PaDvSJkfKmpUlUemAC5ex' and @href]//div[text()]");
        page.waitForSelector("//div[contains(@class,'programs')]");
        page.waitForSelector("//div[@class='_2H8yToCwb1zXChwX6l7ZNT']");
        page.waitForSelector("//a[contains(@class,'LayoutBottomMenu_linkActive')]//span[text()='Главная']");
        // чек проверки коллекции элементов в блоках расписания:
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("._23E9FFV9LhyYMGP2R_4Hjv").size());
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]").size());
//        Assert.assertEquals(page.querySelectorAll());
    }
}

