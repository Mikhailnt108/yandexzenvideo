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

public class AllCollectionsPagePW extends BasePagePlaywright {
    private Page page;

    public AllCollectionsPagePW(Page page) {
        this.page = page;
    }

    public void checkImagePageAllCollections() throws IOException, InterruptedException {
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
//        page = browser.newPage(new Browser.NewPageOptions().setViewportSize(1880, 930));
        page.navigate("https://web-preprod5.megafon.tv/collection");
        // подготовка страницы "PageAllCollectionsScrollForUnauthorized" к скриншот-тесту:
        List<ElementHandle> posterCollectionAll;
        List<ElementHandle> titleCollectionAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='SyGW2hCPGu_qfnWbUa5V']").size(); i++) {
            posterCollectionAll = page.querySelectorAll("//img[@class='_3te-a1teTTW-lKUjvWVxkj']");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Season/32/f4/8a4df83b043313eafbb13874edd3bc3cd3db/tile__web-wp.webp')", posterCollectionAll.get(i));
            titleCollectionAll = page.querySelectorAll("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']");
            page.evaluate("t => t.innerText='Название подборки'", titleCollectionAll.get(i));
        }

        ElementHandle numberPage = page.querySelector("(//a[@class='_321YEvw8w6G20aKg-N8nNe'])[last()]");
        page.evaluate("a => a.innerText='60'", numberPage);

        // делаем скриншот полной страницы "PageAllCollectionsScrollForUnauthorized":
        vrt.track(
                "PageAllCollectionsScrollForUnauthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToTailCollection() {
        page.click("(//a[@class='_2W-IRVg8nfmL65JjHBY-ly'])[2]");
        page.waitForTimeout(5000);
    }

    public void selectCollectionForKids() {
        page.navigate("https://web-preprod5.megafon.tv/kids");
        String nameForKidsBlockCollect = page.querySelector("(//h3[@data-test='PackageListWrapperName'])[5]").innerText();
        System.out.println(nameForKidsBlockCollect);
        page.navigate("https://web-preprod5.megafon.tv/collection");
        List<ElementHandle> collectNames = page.querySelectorAll("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']");
        List<ElementHandle> paginations = page.querySelectorAll("//a[@class='_321YEvw8w6G20aKg-N8nNe']");
        for (int a = 0; a < paginations.size(); a++) {
            for (int i = 0; i < collectNames.size(); i++) {
                collectNames = page.querySelectorAll("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']");
                String nameString = collectNames.get(i).innerText();
                System.out.println("название подборки на стр коллекций: " + nameString);
                if (nameString.equals(nameForKidsBlockCollect)) {
                    collectNames.get(i).click();
                    Assert.assertEquals(page.querySelector("h1").innerText(), nameForKidsBlockCollect);
//                    Assert.assertEquals("нет детского фона", 1, page.querySelectorAll("//div[contains(@class,'_3c9FjHVIHIuT3fX6yTP3IO') and contains(@style,'background')]").size());
                    return;
                }
                if (i == collectNames.size() - 1) {
                    break;
                }
            }
            page.click("//a[contains(@href,'/collection?page') and @rel='next']");
            page.waitForTimeout(3000);
        }
    }

    public void checkElementsPageAllCollections() {
        page.querySelector("//span[text()='Подборки']");
        page.querySelector("//button[contains(text(), 'Следующая')]");
        page.querySelector("//h1[text()='Популярные подборки фильмов и сериалов']");
        page.querySelector("//p[contains(text(),'Мы собрали коллекции лучших фильмов, " +
        "мультфильмов и сериалов, чтобы смотреть МегаФон ТВ где и когда удобно с любых устройств.')]");
        page.querySelector("//a[@class='_2W-IRVg8nfmL65JjHBY-ly']");
        page.querySelector("_7d-AKYRwQQezRB7rjcWEA");
    }
}
