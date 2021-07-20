package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import static base.TestBasePlaywright.vrt;

public class CollectionsPagePW extends BasePagePlaywright {
    private Page page;
    public CollectionsPagePW (Page page){
        this.page = page;
    }

    public void checkImageCollectionsPage() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/");
        // подготовка страницы 'сollectionsPage' к скриншот-тесту:
        page.click("(//a[@data-test='PackageListWrapperMoreText'])[1]");
        page.waitForSelector("//h1[text()]");
        ElementHandle titleBlockCollection = page.querySelector("//h1[text()]");
        page.evaluate("h => h.innerText='Автотест'", titleBlockCollection);
        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackageAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//a[@data-test='PackageLink']").size(); i++) {
            posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; " +
                    "background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Автотест'", titlePackageAll.get(i));
            descriptionTextPackageAll = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.textContent='Автотест'", descriptionTextPackageAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        // делаем скриншот элемента "collectionsPage":
        vrt.track(
                "collectionsPage",
                Base64.getEncoder().encodeToString(page.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}

