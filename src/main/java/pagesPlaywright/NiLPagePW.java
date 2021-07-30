package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.*;

public class NiLPagePW extends BasePagePlaywright {
    private Page page;
    private Page pageFull;
    public NiLPagePW (Page page, Page pageFull) {
        this.page = page;
        this.pageFull = pageFull;
    }

    public void screenshotNiLPagePW() {
        page.navigate("https://web-preprod5.megafon.tv/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + ".png")));
        page.click("text=Премьеры");
        page.navigate("https://web-preprod5.megafon.tv/");
        page.click("text=Русские фильмы");
    }

    public void screenshotsNiLPagePwUsingVRT() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/");
        vrt.track("NiL Page", Base64.getEncoder().encodeToString(page.screenshot()));
        page.click("text=Премьеры");
        vrt.track(
                "Collection Page",
                Base64.getEncoder().encodeToString(page.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.0f)
                        .build());
    }

    public void checkImageCherdakAndBanners() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/");
//        page.waitForSelector("(//div[text()='Новое и Лучшее'])[1]");
        // подготовка элемента "cherdakPageNil" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageNil":
        vrt.track(
                "cherdakPageNil",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[@data-test='BannerCarousel']");
        ElementHandle banners = page.querySelector("//div[@class='_3VpQMliI0kzCfTPxfHPOa- _2RpZ3dJ5og17m8Uf5So1cd poster']");
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 48) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 48) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 48) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 48) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = page.querySelector("(//div[@data-test='SlideTitle'])[2]");
        page.evaluate("t => t.innerText='Название контента'", titleBanner);
        ElementHandle stiker = page.querySelector("(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[2]");
        page.evaluate("s => s.innerText='Автотест'", stiker);
        ElementHandle colorStiker = page.querySelector("(//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb'])[2]");
        page.evaluate("c => c.setAttribute('style', 'background-color: rgb(247, 121, 28); color: rgb(255, 255, 255); box-shadow: none;')", colorStiker);
        ElementHandle yearAndGenre = page.querySelector("(//div[@data-test='SlideDescription'])[2]");
        page.evaluate("yG => yG.innerText='2021, Жанр'", yearAndGenre);
        ElementHandle age = page.querySelector("(//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')])[2]");
        page.evaluate("a => a.innerText='18+'", age);
        ElementHandle poster = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW'])[2]");
        page.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')", poster);
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        page.evaluate("ch => ch.setAttribute('style', 'transform: translateX(0px); transition-duration: 0ms;')", changeTransform);
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        // делаем скриншот элемента "bannersPageNil":
        vrt.track(
                "bannersPageNil",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImageBlocksCollectionWithHeader() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/");
        page.focus("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithHeader = page.querySelector("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        // подготовка элемента 'blockCollectionWithHeaderPageNil' к скриншот-тесту:
        ElementHandle counterCollection = page.querySelector("(//a[@data-test='PackageListWrapperMoreText'])[1]");
        page.evaluate("c => c.innerText='Все 10'", counterCollection);
        ElementHandle titleBlockCollection = page.querySelector("(//h3[@data-test='PackageListWrapperName']//a)[1]");
        page.evaluate("t => t.innerText='Автотест'", titleBlockCollection);
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
            page.evaluate("t => t.innerText='Автотест'", titlePackageAll.get(i));
            descriptionTextPackageAll = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.textContent='Автотест'", descriptionTextPackageAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        // делаем скриншот элемента "blockCollectionWithHeaderPageNil":
        vrt.track(
                "blockCollectionWithHeaderPageNil",
                Base64.getEncoder().encodeToString(blockCollectionWithHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithoutHeader() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/");
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']//text()").size(), 0);
        // подготовка элемента "blockCollectionWithoutHeader" к скриншот-тесту:
        ElementHandle posterCollection1 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[1]");
        page.evaluate("pW => pW.setAttribute('style', 'background-image: url(\"https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp\");')", posterCollection1);
        ElementHandle titleCollection1 = page.querySelector("(//h3[@data-test='CollectionName'])[1]");
        page.evaluate("tW => tW.innerText='Автотест (18+)'", titleCollection1);
        ElementHandle posterCollection2 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[2]");
        page.evaluate("p2 => p2.setAttribute('style', 'background-image: url(\"https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp\");')", posterCollection2);
        ElementHandle titleCollection2 = page.querySelector("(//h3[@data-test='CollectionName'])[2]");
        page.evaluate("t2 => t2.innerText='Автотест (18+)'", titleCollection2);
        // делаем скриншот элемента "blockCollectionWithoutHeaderPageNil":
        vrt.track(
                "blockCollectionWithoutHeaderPageNil",
                Base64.getEncoder().encodeToString(blockCollectionWithoutHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooter() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/");
        ElementHandle footer = page.querySelector("//footer[@class='uy6cMg76OlWzJbrz5UGzE']");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerPageNil",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageNilPageScroll() throws IOException, InterruptedException {
        contextNormalModeHeadfull.close();
        pageFull = contextIncognitoModeHeadless.newPage();
        pageFull.setDefaultNavigationTimeout(60000);
        pageFull.navigate("https://web-preprod5.megafon.tv/");
        // подготовка страницы "NilPage" к скриншот-тесту:
        // подготовка блоков подборок с заголовком:
        List<ElementHandle> titleCollectionAll;
        List<ElementHandle> counterCollectionAll;
        for (int i = 0; i < pageFull.querySelectorAll("//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(); i++) {
            titleCollectionAll = pageFull.querySelectorAll("//h3[@data-test='PackageListWrapperName']//a");
            pageFull.evaluate("t => t.innerText='Название подборки'", titleCollectionAll.get(i));
            counterCollectionAll = pageFull.querySelectorAll("//a[@data-test='PackageListWrapperMoreText']");
            pageFull.evaluate("c => c.innerText='Все 100'", counterCollectionAll.get(i));
        }
        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackage1All;
        List<ElementHandle> ageAll;
        for (int i = 0; i < pageFull.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterPackageAll = pageFull.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            pageFull.evaluate("p => p.setAttribute('style', 'background-size: cover; " +
                    "background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = pageFull.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            pageFull.evaluate("t => t.innerText='Название контента'", titlePackageAll.get(i));
            descriptionTextPackage1All = pageFull.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            pageFull.evaluate("d => d.textContent='Description'", descriptionTextPackage1All.get(i));
            ageAll = pageFull.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            pageFull.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        List<ElementHandle> stickerAll;
        for (int i = 0; i < pageFull.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']").size(); i++) {
            stickerAll = pageFull.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
            pageFull.evaluate("s => s.remove();", stickerAll.get(i));
        }
        // подготовка блоков подборок без заголовка:
        List<ElementHandle> posterCollection2All;
        List<ElementHandle> titleCollection2All;
        for (int i = 0; i < pageFull.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(); i++) {
            posterCollection2All = pageFull.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']");
            pageFull.evaluate("pC => pC.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection2All.get(i));
            titleCollection2All = pageFull.querySelectorAll("//h3[@data-test='CollectionName']");
            pageFull.evaluate("t => t.innerText='Название подборки (18+)'", titleCollection2All.get(i));
        }
        // подготовка баннеров:
        List<ElementHandle> dotBefore = pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 48) {
                while (pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 48) {
                    pageFull.evaluate("dU => dU.remove();", pageFull.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                    System.out.println(pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
                }
            }
        if (dotBefore.size() < 48) {
                while (pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 48) {
                    pageFull.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", pageFull.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                    System.out.println(pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
                }
            }
        pageFull.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[2]");
        ElementHandle changeTransform = pageFull.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        pageFull.evaluate("ch => ch.setAttribute('style', 'transform: translateX(0px); transition-duration: 0ms;')", changeTransform);
        pageFull.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = pageFull.querySelector("(//div[@data-test='SlideTitle'])[2]");
        pageFull.evaluate("t => t.innerText='Название контента'", titleBanner);
        ElementHandle stiker = pageFull.querySelector("(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[1]");
        pageFull.evaluate("s => s.innerText='Автотест'", stiker);
        ElementHandle colorStiker = pageFull.querySelector("(//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb'])[2]");
        pageFull.evaluate("c => c.setAttribute('style', 'background-color: rgb(247, 121, 28); color: rgb(255, 255, 255); box-shadow: none;')", colorStiker);
        ElementHandle yearAndGenre = pageFull.querySelector("(//div[@data-test='SlideDescription'])[2]");
        pageFull.evaluate("yG => yG.innerText='2021, Жанр'", yearAndGenre);
        ElementHandle age = pageFull.querySelector("(//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')])[2]");
        pageFull.evaluate("a => a.innerText='18+'", age);
        ElementHandle poster = pageFull.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW'])[2]");
        pageFull.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')", poster);
        System.out.println(pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size());

        // делаем скриншот полной страницы "NilPageFull":
        vrt.track(
                    "NilPageFull",
                    Base64.getEncoder().encodeToString(pageFull.screenshot(new Page.ScreenshotOptions().setFullPage(true).setTimeout(10000))),
                    TestRunOptions.builder()
                            .device("Acer")
                            .os("Win10 Pro")
                            .browser("Chrome")
                            .diffTollerancePercent(0.3f)
                            .build());
        }

    public void checkImageBlockCollectionSpecialForYou() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/");
        page.focus("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']");
        // подготовка элемента "blockCollectionSpecialForYou" к скриншот-тесту:
        List<ElementHandle> posterPackageAllSFU;
        List<ElementHandle> titlePackageAllSFU;
        List<ElementHandle> descriptionTextPackageAllSFU;
        List<ElementHandle> ageAllSFU;
        for (int i = 0; i <= 2; i++) {
            posterPackageAllSFU = page.querySelectorAll("//a[text()='Подобрали специально для вас']//following::div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAllSFU.get(i));
            titlePackageAllSFU = page.querySelectorAll("//a[text()='Подобрали специально для вас']//following::h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Автотест'", titlePackageAllSFU.get(i));
            descriptionTextPackageAllSFU = page.querySelectorAll("//a[text()='Подобрали специально для вас']//following::div[@class='_1byOct53kb4KlmAs0JuRSX']//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.innerText='Автотест'", descriptionTextPackageAllSFU.get(i));
            ageAllSFU = page.querySelectorAll("//a[text()='Подобрали специально для вас']//following::div[@class='_1byOct53kb4KlmAs0JuRSX']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAllSFU.get(i));
        }
        ElementHandle counterCollection = page.querySelector("(//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']/following::a[@data-test='PackageListWrapperMoreText'])[1]");
        page.evaluate("c => c.innerText='Все 100'", counterCollection);
        // делаем скриншот элемента "blockCollectionSpecialForYou":
        ElementHandle blockCollectionSpecialForYou = page.querySelector("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']");
        vrt.track(
                "blockCollectionSpecialForYou",
                Base64.getEncoder().encodeToString(blockCollectionSpecialForYou.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}








