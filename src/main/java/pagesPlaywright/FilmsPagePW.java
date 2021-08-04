package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.*;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.*;

public class FilmsPagePW extends BasePagePlaywright {
    private Page page;

    public FilmsPagePW (Page page){
        this.page = page;

    }

    public void checkImageCherdakAndBannersForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        // подготовка элемента "cherdakPageFilmsForUnauthorized" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageFilmsForUnauthorized":
        vrt.track(
                "cherdakPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[@data-test='BannerCarousel']");
        ElementHandle banners = page.querySelector("//div[@class='_3VpQMliI0kzCfTPxfHPOa- _2RpZ3dJ5og17m8Uf5So1cd poster']");
        // подготовка элемента "bannersPageFilmsForUnauthorized" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 22) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 22) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = page.querySelector("(//div[@data-test='SlideTitle'])[2]");
        page.evaluate("t => t.innerText='Название фильма'", titleBanner);
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
        // делаем скриншот элемента "bannersPageFilmsForUnauthorized":
        vrt.track(
                "bannersPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksFiltersForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        ElementHandle blockQuickFilters = page.querySelector("//div[@class='_10lCh4uWCss6HRDZrOjSEk']");

        // делаем скриншот элемента "blockQuickFiltersPageFilmsForUnauthorized":
        vrt.track(
                "blockQuickFiltersPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(blockQuickFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        ElementHandle blockBasesFilters = page.querySelector("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']");

        // делаем скриншот элемента "blockBasesFiltersPageFilmsForUnauthorized":
        vrt.track(
                "blockBasesFiltersPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(blockBasesFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImageBlocksCollectionWithHeaderForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        page.focus("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithHeader = page.querySelector("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        // подготовка элемента 'blockCollectionWithHeaderPageFilmsForUnauthorized' к скриншот-тесту:
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
            page.evaluate("t => t.innerText='Название фильма'", titlePackageAll.get(i));
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
        // делаем скриншот элемента "blockCollectionWithHeaderPageFilmsForUnauthorized":
        vrt.track(
                "blockCollectionWithHeaderPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImageBlocksCollectionWithoutHeaderForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
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
                "blockCollectionWithoutHeaderPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithoutHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFilmsPageScrollForUnauthorized() throws IOException, InterruptedException {
        contextNormalModeHeadfull.close();
        pageFull = contextIncognitoModeHeadless.newPage();
        pageFull.setDefaultNavigationTimeout(60000);
        pageFull.navigate("https://web-preprod5.megafon.tv/movies/vods");
        // подготовка страницы "FilmsPageScrollForUnauthorized" к скриншот-тесту:
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
            pageFull.evaluate("t => t.innerText='Название фильма'", titlePackageAll.get(i));
            descriptionTextPackage1All = pageFull.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            pageFull.evaluate("d => d.textContent='2021, Жанр'", descriptionTextPackage1All.get(i));
            ageAll = pageFull.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            pageFull.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }

        List<ElementHandle> stickerAll = pageFull.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
        for(ElementHandle stiker : stickerAll){
            stiker.evaluate("s => s.remove();");
        }

        // подготовка блоков подборок без заголовка:
        List<ElementHandle> posterCollection2All;
        List<ElementHandle> titleCollection2All;
        for (int i = 0; i < pageFull.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(); i++) {
            posterCollection2All = pageFull.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']");
            pageFull.evaluate("pC => pC.setAttribute('style', 'background-image: url(\"https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp\");')", posterCollection2All.get(i));
            titleCollection2All = pageFull.querySelectorAll("//h3[@data-test='CollectionName']");
            pageFull.evaluate("t => t.innerText='Название подборки (18+)'", titleCollection2All.get(i));
        }
        // подготовка баннеров:
        List<ElementHandle> dotBefore = pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 22) {
            while (pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                pageFull.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 22) {
            while (pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                pageFull.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", pageFull.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        pageFull.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[2]");
        ElementHandle changeTransform = pageFull.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        pageFull.evaluate("ch => ch.setAttribute('style', 'transform: translateX(0px); transition-duration: 0ms;')", changeTransform);
        pageFull.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = pageFull.querySelector("(//div[@data-test='SlideTitle'])[2]");
        pageFull.evaluate("t => t.innerText='Название фильма'", titleBanner);
        ElementHandle stiker = pageFull.querySelector("(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[2]");
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

        // делаем скриншот полной страницы "FilmsPageScrollForUnauthorized":
        vrt.track(
                "FilmsPageScrollForUnauthorized",
                Base64.getEncoder().encodeToString(pageFull.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void checkImageFooterForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        ElementHandle footer = page.querySelector("//footer[@class='uy6cMg76OlWzJbrz5UGzE']");
        // делаем скриншот элемента "footerPageFilmsForUnauthorized":
        vrt.track(
                "footerPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCherdakAndBannersForAuthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        // подготовка элемента "cherdakPageFilmsForAuthorized" к скриншот-тесту:
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageFilmsForAuthorized":
        vrt.track(
                "cherdakPageFilmsForAuthorized",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[@data-test='BannerCarousel']");
        ElementHandle banners = page.querySelector("//div[@class='_3VpQMliI0kzCfTPxfHPOa- _2RpZ3dJ5og17m8Uf5So1cd poster']");
        // подготовка элемента "bannersPageFilmsForAuthorized" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 22) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 22) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        // перематываем на первый баннер:
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = page.querySelector("(//div[@data-test='SlideTitle'])[2]");
        page.evaluate("t => t.innerText='Название фильма'", titleBanner);
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
        // делаем скриншот элемента "bannersPageFilmsForAuthorized":
        vrt.track(
                "bannersPageFilmsForAuthorized",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void checkImageBlocksFiltersForAuthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        //div[@class='_10lCh4uWCss6HRDZrOjSEk'] - block quick filters
        //div[@class='_3vWFiYltc8dtOgsuRbqAyX'] - block bases filters
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        ElementHandle blockQuickFilters = page.querySelector("//div[@class='_10lCh4uWCss6HRDZrOjSEk']");

        // делаем скриншот элемента "blockQuickFiltersPageFilmsForAuthorized":
        vrt.track(
                "blockQuickFiltersPageFilmsForAuthorized",
                Base64.getEncoder().encodeToString(blockQuickFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        ElementHandle blockBasesFilters = page.querySelector("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']");

        // делаем скриншот элемента "blockBasesFiltersPageFilmsForAuthorized":
        vrt.track(
                "blockBasesFiltersPageFilmsForAuthorized",
                Base64.getEncoder().encodeToString(blockBasesFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithHeaderForAuthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        page.focus("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithHeader = page.querySelector("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        // подготовка элемента 'blockCollectionWithHeaderPageFilmsForAuthorized' к скриншот-тесту:
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
            page.evaluate("t => t.innerText='Название фильма'", titlePackageAll.get(i));
            descriptionTextPackageAll = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            page.evaluate("d => d.textContent='2021, Жанр'", descriptionTextPackageAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        // делаем скриншот элемента "blockCollectionWithHeaderPageFilmsForAuthorized":
        vrt.track(
                "blockCollectionWithHeaderPageFilmsForAuthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithoutHeaderForAuthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']//text()").size(), 0);
        // подготовка элемента "blockCollectionWithoutHeaderPageFilmsForAuthorized" к скриншот-тесту:
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
                "blockCollectionWithoutHeaderPageFilmsForAuthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithoutHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooterForAuthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        ElementHandle footer = page.querySelector("//footer[@class='uy6cMg76OlWzJbrz5UGzE']");
        // делаем скриншот элемента "footerPageFilmsForForAuthorized":
        vrt.track(
                "footerPageFilmsForAuthorized",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFilmsPageScrollForAuthorized() throws IOException, InterruptedException {
        contextNormalModeHeadfull.close();
        pageFull = contextIncognitoModeHeadless.newPage();
        pageFull.setDefaultNavigationTimeout(60000);
        pageFull.navigate("https://web-preprod5.megafon.tv/movies/vods");
        // подготовка страницы "FilmsPageScrollForAuthorized" к скриншот-тесту:
        // подготовка блоков подборок с заголовком:
        ElementHandle userLogin = pageFull.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        pageFull.evaluate("uL => uL.innerText='+79260010101'", userLogin);
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
            pageFull.evaluate("t => t.innerText='Название фильма'", titlePackageAll.get(i));
            descriptionTextPackage1All = pageFull.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
            pageFull.evaluate("d => d.textContent='2021, Жанр'", descriptionTextPackage1All.get(i));
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
            pageFull.evaluate("pC => pC.setAttribute('style', 'background-image: url(\"https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp\");')", posterCollection2All.get(i));
            titleCollection2All = pageFull.querySelectorAll("//h3[@data-test='CollectionName']");
            pageFull.evaluate("t => t.innerText='Название подборки (18+)'", titleCollection2All.get(i));
        }
        // подготовка баннеров:
        List<ElementHandle> dotBefore = pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 22) {
            while (pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                pageFull.evaluate("dU => dU.remove();", pageFull.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 22) {
            while (pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 22) {
                pageFull.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", pageFull.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(pageFull.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        pageFull.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[2]");
        ElementHandle changeTransform = pageFull.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        pageFull.evaluate("ch => ch.setAttribute('style', 'transform: translateX(0px); transition-duration: 0ms;')", changeTransform);
        pageFull.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        ElementHandle titleBanner = pageFull.querySelector("(//div[@data-test='SlideTitle'])[2]");
        pageFull.evaluate("t => t.innerText='Название фильма'", titleBanner);
        ElementHandle stiker = pageFull.querySelector("(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[2]");
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

        // делаем скриншот полной страницы "FilmsPageScrollForUnauthorized":
        vrt.track(
                "FilmsPageScrollForAuthorized",
                Base64.getEncoder().encodeToString(pageFull.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToTailCardFilm() {
        page.click("(//a[@data-test='PackageLink'])[3]");
    }

    public void checkImageScrollQuickFiltersForUnauthorized() throws IOException, InterruptedException {
        page.click("//button[contains(@class,'_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1')]");
        page.waitForTimeout(3000);
        // делаем скриншот элемента "scrollQuickFiltersForUnauthorized":
        ElementHandle scrollQuickFiltersForUnauthorized = page.querySelector("//div[@class='_10lCh4uWCss6HRDZrOjSEk']");
        vrt.track(
                "scrollQuickFiltersPageFilmsForUnauthorized",
                Base64.getEncoder().encodeToString(scrollQuickFiltersForUnauthorized.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}





