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


public class CollectionsPagePW extends BasePagePlaywright {
    private Page page;

    public CollectionsPagePW(Page page) {
        this.page = page;
    }

    public void checkImagePageCollection() throws IOException, InterruptedException {
        ElementHandle nameCrums = page.querySelector("(//span[@itemprop='name'])[3]");
        nameCrums.evaluate("nC => nC.innerText='Название подборки'");

        ElementHandle titleCollection = page.querySelector("//h1[@class='_3W3PS0IzT79NKILnbaFQEi']");
        titleCollection.evaluate("tC => tC.innerText='Название подборки'");

        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackage1All;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Season/b2/60/1b62a33263f9c687aa3bfd6e5be70c80511d/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("tP => tP.innerText='Название контента'", titlePackageAll.get(i));
            descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.textContent='2021, Жанр'", descriptionTextPackage1All.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        // делаем скриншот полной страницы "PageCollectionsScrollForUnauthorized":
        vrt.track(
                    "PageCollectionScrollForUnauthorized",
                    Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                    TestRunOptions.builder()
                            .device("Acer")
                            .os("Win10 Pro")
                            .browser("Chrome")
                            .diffTollerancePercent(0.3f)
                            .build());
    }


    public void checkImagePageCollectionForKids() throws IOException, InterruptedException {
        List<ElementHandle> posterPackageForKidsAll;
        List<ElementHandle> titlePackageForKidsAll;
        List<ElementHandle> descriptionTextPackageForKidsAll;
        List<ElementHandle> ageForKidsAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterPackageForKidsAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/38/f6/ec90bf85a036c70427172b4e6c96e82ee7ea/tile__web-wp.webp);')", posterPackageForKidsAll.get(i));
            titlePackageForKidsAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название контента'", titlePackageForKidsAll.get(i));
            descriptionTextPackageForKidsAll = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.textContent='2021, Жанр'", descriptionTextPackageForKidsAll.get(i));
            ageForKidsAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='6+'", ageForKidsAll.get(i));
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
        for(ElementHandle stiker : stickerAll){
            stiker.evaluate("s => s.remove();");
        }

        ElementHandle numberPage = page.querySelector("(//a[@class='_321YEvw8w6G20aKg-N8nNe'])[last()]");
        page.evaluate("a => a.innerText='34'", numberPage);
        // делаем скриншот полной страницы "PageCollectionsForKidsScrollForUnauthorized":
        vrt.track(
                    "PageCollectionForKidsScrollForUnauthorized",
                    Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                    TestRunOptions.builder()
                            .device("Acer")
                            .os("Win10 Pro")
                            .browser("Chrome")
                            .diffTollerancePercent(0.3f)
                            .build());
        }

    public void checkBackgroundPageCollectionForKids() {
        String Background = page.querySelector("//div[contains(@class,'_3c9FjHVIHIuT3fX6yTP3IO')]").getAttribute("background-image");
        System.out.println(page.querySelector("//div[contains(@class,'_3c9FjHVIHIuT3fX6yTP3IO')]").getAttribute("background-image"));
        System.out.println(Background.substring(0,3));
        Assert.assertEquals("нет детского фона", "url", Background.substring(0,3));
    }
}

