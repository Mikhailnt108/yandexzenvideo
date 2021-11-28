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

public class FilmsPagePW extends BasePagePlaywright {
    private Page page;
    private String frontend;

    public FilmsPagePW (Page page, String frontend){
        this.page = page;
        this.frontend = frontend;
    }

    public void checkImageCherdakAndBannersForUnauthorized() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
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
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название фильма'");
        }

        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.innerText='Автотест'");
        }

        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
        for(ElementHandle colorStiker : colorStikers){
            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }

        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(2000);

        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());

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
        page.navigate(frontend +"movies/vods");
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
        page.navigate(frontend +"movies/vods");
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
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.innerText='Автотест'");
        }
        if(page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']").size()!=0){
            page.evaluate("s => s.remove();", page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']"));
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
        page.navigate(frontend +"movies/vods");
        // подготовка блоков подборок без заголовка:
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);

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

    public void checkImageFilmsPageScrollForGuest() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
        // подготовка страницы "FilmsPageScrollForGuest" к скриншот-тесту:
        // подготовка блоков подборок с заголовком:
        List<ElementHandle> titleCollectionAll = page.querySelectorAll("//h3[@data-test='PackageListWrapperName']//a");
        for(ElementHandle titleCollection : titleCollectionAll){
            titleCollection.evaluate("t => t.innerText='Название подборки'");
        }
        List<ElementHandle> counterCollectionAll = page.querySelectorAll("//a[@data-test='PackageListWrapperMoreText']");
        for(ElementHandle counterCollection : counterCollectionAll){
            counterCollection.evaluate("c => c.innerText='Все 100'");
        }
        List<ElementHandle> posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for(ElementHandle posterPackage : posterPackageAll){
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название фильма'");
        }
        List<ElementHandle> descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
        for(ElementHandle descriptionTextPackage1 : descriptionTextPackage1All){
            descriptionTextPackage1.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
        for(ElementHandle stiker : stickerAll){
            stiker.evaluate("s => s.remove();");
        }
        if(page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']").size()!=0){
            page.evaluate("s => s.remove();", page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']"));
        }

        // подготовка блоков подборок без заголовка:
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);

        List<ElementHandle> posterCollection2All = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']");
        for(ElementHandle posterCollection2 : posterCollection2All){
            posterCollection2.evaluate("pC => pC.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')");
        }
        List<ElementHandle> titleCollection2All = page.querySelectorAll("//h3[@data-test='CollectionName']");
        for(ElementHandle titleCollection2 : titleCollection2All){
            titleCollection2.evaluate("t => t.innerText='Название подборки (18+)'");
        }

        // подготовка баннеров:
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
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название фильма'");
        }
        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.innerText='Автотест'");
        }
        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
        for(ElementHandle colorStiker : colorStikers){
            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(3000);

        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());

        // делаем скриншот полной страницы "FilmsPageScrollForGuest":
        vrt.track(
                "FilmsPageScrollForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void checkImageFooterForUnauthorized() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
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

    public void checkImageCherdakAndBannersForUser() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
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
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название фильма'");
        }
        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.innerText='Автотест'");
        }
        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
        for(ElementHandle colorStiker : colorStikers){
            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(2000);

        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());

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


    public void checkImageBlocksFiltersForUser() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
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

    public void checkImageBlocksCollectionWithHeaderForUser() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
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
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.innerText='Автотест'");
        }

        if(page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']").size()!=0){
            page.evaluate("s => s.remove();", page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']"));
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

    public void checkImageBlocksCollectionWithoutHeaderForUser() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
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

    public void checkImageFooterForUser() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
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

    public void checkImageFilmsPageScrollForUser() throws IOException, InterruptedException {
        page.navigate(frontend +"movies/vods");
        // подготовка страницы "FilmsPageScrollForUser" к скриншот-тесту:
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        // подготовка блоков подборок с заголовком:
        List<ElementHandle> titleCollectionAll = page.querySelectorAll("//h3[@data-test='PackageListWrapperName']//a");
        for(ElementHandle titleCollection : titleCollectionAll){
            titleCollection.evaluate("t => t.innerText='Название подборки'");
        }
        List<ElementHandle> counterCollectionAll = page.querySelectorAll("//a[@data-test='PackageListWrapperMoreText']");
        for(ElementHandle counterCollection : counterCollectionAll){
            counterCollection.evaluate("c => c.innerText='Все 100'");
        }
        List<ElementHandle> posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for(ElementHandle posterPackage : posterPackageAll){
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название фильма'");
        }
        List<ElementHandle> descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
        for(ElementHandle descriptionTextPackage1 : descriptionTextPackage1All){
            descriptionTextPackage1.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
        for(ElementHandle stiker : stickerAll){
            stiker.evaluate("s => s.remove();");
        }

        if(page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']").size()!=0){
            page.evaluate("s => s.remove();", page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1rFI0KDcQjaCwgg4CshFS8']"));
        }

        // подготовка блоков подборок без заголовка:
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);

        List<ElementHandle> posterCollection2All = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']");
        for(ElementHandle posterCollection2 : posterCollection2All){
            posterCollection2.evaluate("pC => pC.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')");
        }
        List<ElementHandle> titleCollection2All = page.querySelectorAll("//h3[@data-test='CollectionName']");
        for(ElementHandle titleCollection2 : titleCollection2All){
            titleCollection2.evaluate("t => t.innerText='Название подборки (18+)'");
        }
        // подготовка баннеров:
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
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название фильма'");
        }
        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.innerText='Автотест'");
        }
        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
        for(ElementHandle colorStiker : colorStikers){
            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(3000);

        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());

        // делаем скриншот полной страницы "FilmsPageScrollForUser":
        vrt.track(
                "FilmsPageScrollForUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToTailCardFilm() throws InterruptedException {
        page.waitForSelector("(//a[@data-test='PackageLink'])[1]");
        page.click("(//a[@data-test='PackageLink'])[1]");
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





