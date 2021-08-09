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
    public NiLPagePW (Page page) {
        this.page = page;

    }

    public void screenshotNiLPagePW() {
        page.navigate("https://web-preprod4.megafon.tv/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + ".png")));
        page.click("text=Премьеры");
        page.navigate("https://web-preprod4.megafon.tv/");
        page.click("text=Русские фильмы");
    }

    public void screenshotsNiLPagePwUsingVRT() throws IOException, InterruptedException {
        page.navigate("https://web-preprod4.megafon.tv/");
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
        page.navigate("https://web-preprod4.megafon.tv/");
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
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название контента'");
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
        page.navigate("https://web-preprod4.megafon.tv/");
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
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.remove();");
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
        page.navigate("https://web-preprod4.megafon.tv/");
        page.focus("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]");
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
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
        page.navigate("https://web-preprod4.megafon.tv/");
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
        page.navigate("https://web-preprod4.megafon.tv/");
        // подготовка страницы "NilPage" к скриншот-тесту:
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
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Mixed/35/ee/4cb8df5e72d867ab46ba2da8169c56159b71/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageAll = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
        for(ElementHandle descriptionTextPackage : descriptionTextPackageAll){
            descriptionTextPackage.evaluate("d => d.textContent='Description'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
        for(ElementHandle sticker : stickerAll){
            sticker.evaluate("s => s.remove();");
        }

        // подготовка блоков подборок без заголовка:
        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
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
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название контента'");
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

        // делаем скриншот полной страницы "NilPageFull":
        vrt.track(
                "NilPageFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        }

    public void checkImageBlockCollectionSpecialForYou() throws IOException, InterruptedException {
        page.navigate("https://web-preprod4.megafon.tv/");
        page.waitForSelector("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']");
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








