package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class KidsPagePW extends BasePagePlaywright {
    private Page page;

    public KidsPagePW (Page page) {
        this.page = page;
    }

    public void checkImageCherdakAndBannersForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/kids");
        // подготовка элемента "cherdakPageKidsForUnauthorized" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageKidsForUnauthorized":
        vrt.track(
                "cherdakPageKidsForUnauthorized",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[@data-test='BannerCarousel']");
        ElementHandle banners = page.querySelector("//div[@class='_3VpQMliI0kzCfTPxfHPOa- _2RpZ3dJ5og17m8Uf5So1cd poster']");
        // подготовка элемента "bannersPageKidsForUnauthorized" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 15) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 15) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 15) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 15) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = page.querySelector("(//div[@data-test='SlideTitle'])[2]");
        page.evaluate("t => t.innerText='Название фильма'", titleBanner);
        ElementHandle stiker = page.querySelector("(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[1]");
        page.evaluate("s => s.innerText='Автотест'", stiker);
        ElementHandle colorStiker = page.querySelector("(//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb'])[2]");
        page.evaluate("c => c.setAttribute('style', 'background-color: rgb(247, 121, 28); color: rgb(255, 255, 255); box-shadow: none;')", colorStiker);
        ElementHandle yearAndGenre = page.querySelector("(//div[@data-test='SlideDescription'])[2]");
        page.evaluate("yG => yG.innerText='2021, Жанр'", yearAndGenre);
        ElementHandle age = page.querySelector("(//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')])[2]");
        page.evaluate("a => a.innerText='18+'", age);
        ElementHandle poster = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW'])[2]");
        page.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/03/6e/6f9b25ed14b8bd50805d1810272952fbb0ae/poster__web-wp.webp);')", poster);
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        page.evaluate("ch => ch.setAttribute('style', 'transform: translateX(0px); transition-duration: 0ms;')", changeTransform);
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        // делаем скриншот элемента "bannersPageKidsForUnauthorized":
        vrt.track(
                "bannersPageKidsForUnauthorized",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithHeaderForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/kids");
        page.focus("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithHeader = page.querySelector("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        // подготовка элемента 'blockCollectionWithHeaderPageKidsForUnauthorized' к скриншот-тесту:
        ElementHandle counterCollection = page.querySelector("(//a[@data-test='PackageListWrapperMoreText'])[1]");
        page.evaluate("c => c.innerText='Все 10'", counterCollection);
        ElementHandle titleBlockCollection = page.querySelector("(//h3[@data-test='PackageListWrapperName']//a)[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollection);
        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackageAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i <= 2; i++) {
            posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; " +
                    "background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название контента'", titlePackageAll.get(i));
            descriptionTextPackageAll = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.textContent='2021, Жанр'", descriptionTextPackageAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        List<ElementHandle> stickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            stickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("s => s.innerText='Автотест'", stickerAll.get(i));
        }
        // делаем скриншот элемента "blockCollectionWithHeaderPageKidsForUnauthorized":
        vrt.track(
                "blockCollectionWithHeaderPageKidsForUnauthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithoutHeaderForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/kids");
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']//text()").size(), 0);
        // подготовка элемента "blockCollectionWithoutHeaderForUnauthorized" к скриншот-тесту:
        ElementHandle posterCollection1 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[1]");
        page.evaluate("pW => pW.setAttribute('style', 'background-image: url(\"https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp\");')", posterCollection1);
        ElementHandle titleCollection1 = page.querySelector("(//h3[@data-test='CollectionName'])[1]");
        page.evaluate("tW => tW.innerText='Название подборки (18+)'", titleCollection1);
        ElementHandle posterCollection2 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[2]");
        page.evaluate("p2 => p2.setAttribute('style', 'background-image: url(\"https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp\");')", posterCollection2);
        ElementHandle titleCollection2 = page.querySelector("(//h3[@data-test='CollectionName'])[2]");
        page.evaluate("t2 => t2.innerText='Название подборки (18+)'", titleCollection2);
        // делаем скриншот элемента "blockCollectionWithoutHeaderPageFilmsForUnauthorized":
        vrt.track(
                "blockCollectionWithoutHeaderPageKidsForUnauthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithoutHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooterForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/kids");
        ElementHandle footer = page.querySelector("//footer[@class='uy6cMg76OlWzJbrz5UGzE']");
        // делаем скриншот элемента "footerPageKidsForUnauthorized":
        vrt.track(
                "footerPageKidsForUnauthorized",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageKidsPageScrollForUnauthorized() throws IOException, InterruptedException {
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
//        page = browser.newPage(new Browser.NewPageOptions().setViewportSize(1880, 930));
        page.navigate("https://web-preprod5.megafon.tv/kids");
        // подготовка страницы "PageKidsScrollForUnauthorized" к скриншот-тесту:
        // подготовка блоков подборок с заголовком:
        List<ElementHandle> titleCollectionAll;
        List<ElementHandle> counterCollectionAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(); i++) {
            titleCollectionAll = page.querySelectorAll("//h3[@data-test='PackageListWrapperName']//a");
            page.evaluate("t => t.innerText='Название подборки'", titleCollectionAll.get(i));
            counterCollectionAll = page.querySelectorAll("//a[@data-test='PackageListWrapperMoreText']");
            page.evaluate("c => c.innerText='Все 100'", counterCollectionAll.get(i));
        }
        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackage1All;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; " +
                    "background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название контента'", titlePackageAll.get(i));
            descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.textContent='2021, Жанр'", descriptionTextPackage1All.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        List<ElementHandle> stickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']").size(); i++) {
            stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
            page.evaluate("s => s.remove();", stickerAll.get(i));
        }
        // подготовка блоков подборок без заголовка:
        List<ElementHandle> posterCollection2All;
        List<ElementHandle> titleCollection2All;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(); i++) {
            posterCollection2All = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']");
            page.evaluate("pC => pC.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection2All.get(i));
            titleCollection2All = page.querySelectorAll("//h3[@data-test='CollectionName']");
            page.evaluate("t => t.innerText='Название подборки (18+)'", titleCollection2All.get(i));
        }
        // подготовка баннеров:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 15) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 15) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 15) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 15) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[2]");
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        page.evaluate("ch => ch.setAttribute('style', 'transform: translateX(0px); transition-duration: 0ms;')", changeTransform);

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = page.querySelector("(//div[@data-test='SlideTitle'])[2]");
        page.evaluate("t => t.innerText='Название контента'", titleBanner);
        ElementHandle stiker = page.querySelector("(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[1]");
        page.evaluate("s => s.innerText='Автотест'", stiker);
        ElementHandle colorStiker = page.querySelector("(//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb'])[2]");
        page.evaluate("c => c.setAttribute('style', 'background-color: rgb(247, 121, 28); color: rgb(255, 255, 255); box-shadow: none;')", colorStiker);
        ElementHandle yearAndGenre = page.querySelector("(//div[@data-test='SlideDescription'])[2]");
        page.evaluate("yG => yG.innerText='2021, Жанр'", yearAndGenre);
        ElementHandle age = page.querySelector("(//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')])[2]");
        page.evaluate("a => a.innerText='18+'", age);
        ElementHandle poster = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW'])[2]");
        page.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/03/6e/6f9b25ed14b8bd50805d1810272952fbb0ae/poster__web-wp.webp);')", poster);
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());

        // делаем скриншот полной страницы "FilmsPageScrollForUnauthorized":
        vrt.track(
                "PageKidsScrollForUnauthorized",
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

    public void checkBackgroundKidsPage() {
        page.navigate("https://web-preprod5.megafon.tv/kids");
        String Background = page.querySelector("//div[@class='_35YQGs7aas93eRD-8vTLT- _26VUc9ouKb9F8gVK9Zokon']").getAttribute("background-image");
        System.out.println(page.querySelector("//div[@class='_35YQGs7aas93eRD-8vTLT- _26VUc9ouKb9F8gVK9Zokon']").getAttribute("background-image"));
        System.out.println(Background.substring(0,3));
        Assert.assertEquals("нет детского фона", "url", Background.substring(0,3));
    }

    public void clickToLinkAllOnCollectionBlock() {
        page.click("(//a[contains(@href, '/vods')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]");
        page.waitForTimeout(5000);
    }
}

