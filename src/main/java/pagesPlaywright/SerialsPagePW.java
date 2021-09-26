package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.*;

public class SerialsPagePW extends BasePagePlaywright {
    private Page page;
    private Page pageCMS;

    public SerialsPagePW(Page page, Page pageCMS) {
        this.page = page;
        this.pageCMS = pageCMS;
    }

    public void checkImageCherdakAndBannersForGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        // подготовка элемента "cherdakPageSerialsForGuest" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageSerialsForGuest":
        vrt.track(
                "cherdakPageSerialsForGuest",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        // подготовка элемента "bannersPageSerialsForUnauthorized" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[2].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Season/aa/07/66b2b20d6fcbaa0e2fc7dbbc7b606e22c986/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название сериала'");
        }

        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.remove();");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }

        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

//        page.waitForTimeout(4000);
        ElementHandle banners = page.querySelector("//div[@data-test='BannerCarousel']");
        // делаем скриншот элемента "bannersPageSerialsForGuest":
        vrt.track(
                "bannersPageSerialsForGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksFiltersForGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        ElementHandle blockQuickFilters = page.querySelector("//div[@class='_10lCh4uWCss6HRDZrOjSEk']");

        // делаем скриншот элемента "blockQuickFiltersPageSerialsForUnauthorized":
        vrt.track(
                "blockQuickFiltersPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(blockQuickFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        ElementHandle blockBasesFilters = page.querySelector("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']");

        // делаем скриншот элемента "blockBasesFiltersPageSerialsForUnauthorized":
        vrt.track(
                "blockBasesFiltersPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(blockBasesFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithHeaderForGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        page.focus("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithHeader = page.querySelector("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        // подготовка элемента 'blockCollectionWithHeaderPageSerialsForUnauthorized' к скриншот-тесту:
        ElementHandle counterCollection = page.querySelector("(//a[@data-test='PackageListWrapperMoreText'])[1]");
        page.evaluate("c => c.innerText='Все 10'", counterCollection);
        ElementHandle titleBlockCollection = page.querySelector("(//h3[@data-test='PackageListWrapperName']//a)[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollection);

        List<ElementHandle> posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");;
        for(ElementHandle posterPackage : posterPackageAll){
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");;
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");;
        for(ElementHandle descriptionTextPackage1 : descriptionTextPackage1All){
            descriptionTextPackage1.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");;
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.remove();");
        }
        // делаем скриншот элемента "blockCollectionWithHeaderPageSerialsForUnauthorized":
        vrt.track(
                "blockCollectionWithHeaderPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithoutHeaderForGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
        // подготовка элемента "blockCollectionWithoutHeaderForUnauthorized" к скриншот-тесту:
        ElementHandle posterCollection1 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[1]");
        page.evaluate("pW => pW.setAttribute('style', 'background-image: " +
                "url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection1);
        ElementHandle titleCollection1 = page.querySelector("(//h3[@data-test='CollectionName'])[1]");
        page.evaluate("tW => tW.innerText='Название подборки (18+)'", titleCollection1);
        ElementHandle posterCollection2 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[2]");
        page.evaluate("p2 => p2.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection2);
        ElementHandle titleCollection2 = page.querySelector("(//h3[@data-test='CollectionName'])[2]");
        page.evaluate("t2 => t2.innerText='Название подборки (18+)'", titleCollection2);
        // делаем скриншот элемента "blockCollectionWithoutHeaderPageSerialsForUnauthorized":
        vrt.track(
                "blockCollectionWithoutHeaderPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithoutHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooterForGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        ElementHandle footer = page.querySelector("//footer[@class='uy6cMg76OlWzJbrz5UGzE']");
        // делаем скриншот элемента "footerPageSerialsForUnauthorized":
        vrt.track(
                "footerPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageSerialsPageScrollForGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        // подготовка страницы "SerialsPageScrollForGuest" к скриншот-тесту:
        // подготовка блоков подборок с заголовком:
        List<ElementHandle> titleCollectionAll = page.querySelectorAll("//h3[@data-test='PackageListWrapperName']//a");;
        for(ElementHandle titleCollection : titleCollectionAll){
            titleCollection.evaluate("t => t.innerText='Название подборки'");
        }
        List<ElementHandle> counterCollectionAll = page.querySelectorAll("//a[@data-test='PackageListWrapperMoreText']");;
        for(ElementHandle counterCollection : counterCollectionAll){
            counterCollection.evaluate("c => c.innerText='Все 100'");
        }
        List<ElementHandle> posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");;
        for(ElementHandle posterPackage : posterPackageAll){
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");;
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");;
        for(ElementHandle descriptionTextPackage1 : descriptionTextPackage1All){
            descriptionTextPackage1.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");;
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.remove();");
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
        if (dotBefore.size() > 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[2].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Season/aa/07/66b2b20d6fcbaa0e2fc7dbbc7b606e22c986/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.remove();");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(4000);
        // делаем скриншот полной страницы "SerialsPageScrollForGuest":
        vrt.track(
                "SerialsPageScrollForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCherdakAndBannersForUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        // подготовка элемента "cherdakPageSerialsForAuthorized" к скриншот-тесту:
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageSerialsForUser":
        vrt.track(
                "cherdakPageSerialsForUser",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        // подготовка элемента "bannersPageSerialsForAuthorized" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[2].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Season/aa/07/66b2b20d6fcbaa0e2fc7dbbc7b606e22c986/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

//        page.waitForTimeout(4000);
        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.remove;");
        }
        ElementHandle banners = page.querySelector("//div[@data-test='BannerCarousel']");
        // делаем скриншот элемента "bannersPageFilmsForUser":
        vrt.track(
                "bannersPageSerialsForUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksFiltersForUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        ElementHandle blockQuickFilters = page.querySelector("//div[@class='_10lCh4uWCss6HRDZrOjSEk']");

        // делаем скриншот элемента "blockQuickFiltersPageSerialsForAuthorized":
        vrt.track(
                "blockQuickFiltersPageSerialsForAuthorized",
                Base64.getEncoder().encodeToString(blockQuickFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        ElementHandle blockBasesFilters = page.querySelector("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']");

        // делаем скриншот элемента "blockBasesFiltersPageSerialsForAuthorized":
        vrt.track(
                "blockBasesFiltersPageSerialsForAuthorized",
                Base64.getEncoder().encodeToString(blockBasesFilters.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithHeaderForUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        page.focus("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithHeader = page.querySelector("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        // подготовка элемента 'blockCollectionWithHeaderPageSerialsForUser' к скриншот-тесту:
        ElementHandle counterCollection = page.querySelector("(//a[@data-test='PackageListWrapperMoreText'])[1]");
        page.evaluate("c => c.innerText='Все 10'", counterCollection);
        ElementHandle titleBlockCollection = page.querySelector("(//h3[@data-test='PackageListWrapperName']//a)[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollection);

        List<ElementHandle> posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");;
        for(ElementHandle posterPackage : posterPackageAll){
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");;
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");;
        for(ElementHandle descriptionTextPackage1 : descriptionTextPackage1All){
            descriptionTextPackage1.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");;
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.remove();");
        }
        // делаем скриншот элемента "blockCollectionWithHeaderPageSerialsForUser":
        vrt.track(
                "blockCollectionWithHeaderPageSerialsForUser",
                Base64.getEncoder().encodeToString(blockCollectionWithHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithoutHeaderForUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
        // подготовка элемента "blockCollectionWithoutHeaderForAuthorized" к скриншот-тесту:
        ElementHandle posterCollection1 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[1]");
        page.evaluate("pW => pW.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection1);
        ElementHandle titleCollection1 = page.querySelector("(//h3[@data-test='CollectionName'])[1]");
        page.evaluate("tW => tW.innerText='Название подборки (18+)'", titleCollection1);
        ElementHandle posterCollection2 = page.querySelector("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B'])[2]");
        page.evaluate("p2 => p2.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection2);
        ElementHandle titleCollection2 = page.querySelector("(//h3[@data-test='CollectionName'])[2]");
        page.evaluate("t2 => t2.innerText='Название подборки (18+)'", titleCollection2);
        // делаем скриншот элемента "blockCollectionWithoutHeaderPageSerialsForAuthorized":
        vrt.track(
                "blockCollectionWithoutHeaderPageSerialsForAuthorized",
                Base64.getEncoder().encodeToString(blockCollectionWithoutHeader.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooterForUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        ElementHandle footer = page.querySelector("//footer[@class='uy6cMg76OlWzJbrz5UGzE']");
        // делаем скриншот элемента "footerPageSerialsForAuthorized":
        vrt.track(
                "footerPageSerialsForAuthorized",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageSerialsPageScrollForUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/shows");
        // подготовка страницы "serialsPageScrollForUser" к скриншот-тесту:
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");
        // подготовка блоков подборок с заголовком:
        List<ElementHandle> titleCollectionAll = page.querySelectorAll("//h3[@data-test='PackageListWrapperName']//a");;
        for(ElementHandle titleCollection : titleCollectionAll){
            titleCollection.evaluate("t => t.innerText='Название подборки'");
        }
        List<ElementHandle> counterCollectionAll = page.querySelectorAll("//a[@data-test='PackageListWrapperMoreText']");;
        for(ElementHandle counterCollection : counterCollectionAll){
            counterCollection.evaluate("c => c.innerText='Все 100'");
        }
        List<ElementHandle> posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");;
        for(ElementHandle posterPackage : posterPackageAll){
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");;
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");;
        for(ElementHandle descriptionTextPackage1 : descriptionTextPackage1All){
            descriptionTextPackage1.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");;
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.remove();");
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
        if (dotBefore.size() > 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 25) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 25) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[2].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Season/aa/07/66b2b20d6fcbaa0e2fc7dbbc7b606e22c986/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stiker : stikers){
            stiker.evaluate("s => s.innerText='Автотест'");
        }
        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
        for(ElementHandle colorStiker : colorStikers){
            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(247, 121, 28); color: rgb(255, 255, 255); box-shadow: none;')");
        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(4000);

        // делаем скриншот полной страницы "serialsPageScrollForUser":
        vrt.track(
                "serialsPageScrollForUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToTailCardSerial() {
        page.click("(//a[@data-test='PackageLink'])[7]");
    }

    public void chooseSeasonsMoreOneSeason() {
        page.click("//div[@class='_3i1jxy4zPnL4htxPozakKI']//span[contains(text(),'3 сезона') or contains(text(), '5 сезонов') or contains(text(), '7 сезонов')]");
    }

    public void checkImageScrollQuickFiltersForUnauthorized() throws IOException, InterruptedException {
        page.click("//button[contains(@class,'_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1')]");
        page.waitForTimeout(3000);
        // делаем скриншот элемента "scrollQuickFiltersForUnauthorized":
        ElementHandle scrollQuickFiltersForUnauthorized = page.querySelector("//div[@class='_10lCh4uWCss6HRDZrOjSEk']");
        vrt.track(
                "scrollQuickFiltersPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(scrollQuickFiltersForUnauthorized.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsBlockCollectHistoryWatch() {
        page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']");
        page.querySelector("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']");
        page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/shows/')]");
        page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m']");
        page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3");
        page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span");
        page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_2I_pgomfMGx8HVFvHlZhKj']");
        page.querySelector("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText']");
        page.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        page.querySelector("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']");
        page.querySelector("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonPrev' and @disabled]");
    }

    public void checkImageBlockCollectHistoryWatchForMfHeadfull() throws IOException, InterruptedException {
        pageHeadfull.navigate("https://web-preprod6.megafon.tv/shows");
        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackageAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m']").size(); i++) {
            posterPackageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            pageHeadfull.evaluate("p => p.setAttribute('style', 'background-size: cover; " +
                    "background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//h3[@data-test='PackageDescriptionTitle']");
            pageHeadfull.evaluate("t => t.innerText='Название сериала'", titlePackageAll.get(i));
            descriptionTextPackageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span");
            pageHeadfull.evaluate("d => d.textContent='1 сезон, Жанр'", descriptionTextPackageAll.get(i));
            ageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            pageHeadfull.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        ElementHandle blockCollectHistoryWatchSerials = pageHeadfull.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']");

        // делаем скриншот элемента "blockCollectHistoryWatchSerialsForMF":
        vrt.track(
                "blockCollectHistoryWatchSerialsForMF",
                Base64.getEncoder().encodeToString(blockCollectHistoryWatchSerials.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        pageHeadfull.click("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']");
        pageHeadfull.waitForSelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@class='ArHiwAcYUlO8lYdGJYyYT']");
        pageHeadfull.waitForTimeout(10000);
        ElementHandle tailWatchAndEditCollectHistoryWatchSerials = pageHeadfull.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@class='ArHiwAcYUlO8lYdGJYyYT']");

        // делаем скриншот элемента "tailWatchAndEditCollectHistoryWatchSerialsForMF":
        vrt.track(
                "tailWatchAndEditCollectHistoryWatchSerialsForMF",
                Base64.getEncoder().encodeToString(tailWatchAndEditCollectHistoryWatchSerials.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlockCollectHistoryWatchForNonMFfHeadfull() throws IOException, InterruptedException {
        pageHeadfull.navigate("https://web-preprod6.megafon.tv/shows");
        List<ElementHandle> posterPackageAll;
        List<ElementHandle> titlePackageAll;
        List<ElementHandle> descriptionTextPackageAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m']").size(); i++) {
            posterPackageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            pageHeadfull.evaluate("p => p.setAttribute('style', 'background-size: cover; " +
                    "background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')", posterPackageAll.get(i));
            titlePackageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//h3[@data-test='PackageDescriptionTitle']");
            pageHeadfull.evaluate("t => t.innerText='Название сериала'", titlePackageAll.get(i));
            descriptionTextPackageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span");
            pageHeadfull.evaluate("d => d.textContent='1 сезон, Жанр'", descriptionTextPackageAll.get(i));
            ageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            pageHeadfull.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        ElementHandle blockCollectHistoryWatchSerials = pageHeadfull.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']");

        // делаем скриншот элемента "blockCollectHistoryWatchSerialsForNonMF":
        vrt.track(
                "blockCollectHistoryWatchSerialsForNonMF",
                Base64.getEncoder().encodeToString(blockCollectHistoryWatchSerials.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        pageHeadfull.click("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']");
        pageHeadfull.waitForSelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@class='ArHiwAcYUlO8lYdGJYyYT']");
        pageHeadfull.waitForTimeout(10000);
        ElementHandle tailWatchAndEditCollectHistoryWatchSerials = pageHeadfull.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@class='ArHiwAcYUlO8lYdGJYyYT']");

        // делаем скриншот элемента "tailWatchAndEditCollectHistoryWatchSerialsForNonMF":
        vrt.track(
                "tailWatchAndEditCollectHistoryWatchSerialsForNonMF",
                Base64.getEncoder().encodeToString(tailWatchAndEditCollectHistoryWatchSerials.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlockCollectHistoryWatchForMFHeadfull() {

    }

    public void clickToTailCardSerialHeadfull() {
        pageHeadfull.click("(//div[@data-test='PackageListWrapper'])[5]//a[@data-test='PackageLink']");
    }
}


