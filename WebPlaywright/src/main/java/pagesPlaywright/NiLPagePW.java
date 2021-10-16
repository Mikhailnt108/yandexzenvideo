package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NiLPagePW extends BasePagePlaywright {
    private Page page;

    public NiLPagePW(Page page) {
        this.page = page;

    }

    public void screenshotNiLPagePW() {
        page.navigate("https://web-preprod6.megafon.tv/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + ".png")));
        page.click("text=Премьеры");
        page.navigate("https://web-preprod6.megafon.tv/");
        page.click("text=Русские фильмы");
    }

    public void screenshotsNiLPagePwUsingVRT() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
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

    public void checkImageCherdakAndBannersGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подготовка элемента "cherdakPageNil" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageNilGuest":
        vrt.track(
                "cherdakPageNilGuest",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[contains(@class,'carousel')]");
        // подготовка элемента "bannersPageNil" к скриншот-тесту:        }
//        крутилка:
//        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
//        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");
        page.click("//button[@aria-label='previous']");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }

        // делаем скриншот элемента "bannersPageNilGuest":
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        vrt.track(
                "bannersPageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWidePageNil() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        Thread.sleep(3000);
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("//section[contains(@class,'HomePage_collection')]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("//section[contains(@class,'HomePage_collection')]");


//        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
//        List<ElementHandle> posterPackage1All = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]");
//        for (ElementHandle posterPackage1 : posterPackage1All) {
//            posterPackage1.evaluate("p1 => p1.remove()");
//        }

        ElementHandle titleBlockCollectionFilmsOrSerial = page.querySelector("//h2[contains(@class,'MediaScroller_title')]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionFilmsOrSerial);

        List<ElementHandle> titlePackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titlePackage : titlePackageAll) {
            titlePackage.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackage : descriptionTextPackageAll) {
            descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> posterPackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }

        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvWidePageNilGuestOrUser",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        // подборки тв каналов:
        ElementHandle blockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");
        ElementHandle titleBlockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionTv);
        List<ElementHandle> collectionTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        for (int i = 0; i < collectionTvChannelAll.size(); i++) {
            collectionTvChannelAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//img");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }


        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvWidePageNilGuestOrUser",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithoutHeader() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        page.focus("(//a[contains(@class,'TileTriple')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");
        ElementHandle blockCollectionWithoutHeader = page.querySelector("(//a[contains(@class,'TileTriple')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");
//        Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
//        Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
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

    public void checkImageFooterGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle footer = page.querySelector("//footer");
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

    public void checkImageNilPageScrollGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подготовка страницы "NilPage" к скриншот-тесту:
        // подготовка блоков подборок с заголовком:
        // подборки пакетов и коллекций MixedEST:
        Thread.sleep(5000);
        page.querySelector("//footer").scrollIntoViewIfNeeded();
//        page.querySelector("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]").scrollIntoViewIfNeeded();
        // подборки фильмов / сериалов / тв передач:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[24]").scrollIntoViewIfNeeded();
        List<ElementHandle> posterPackage24All = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[24]//picture[contains(@class,'TilePackageCommon_image')]");
        for (ElementHandle posterPackage24 : posterPackage24All) {
            posterPackage24.evaluate("p24 => p24.remove()");
        }

        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionFilmsOrSerialsOrTvProgram : titleCollectionFilmsOrSerialsOrTvProgramAll) {
            titleCollectionFilmsOrSerialsOrTvProgram.evaluate("t => t.innerText='Название подборки'");
        }

        for (int i = 0; i < titleCollectionFilmsOrSerialsOrTvProgramAll.size(); i++) {
            titleCollectionFilmsOrSerialsOrTvProgramAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/') or contains(@href, '/tv/channels/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterFilmsOrSerialsOrTvProgram : posterFilmsOrSerialsOrTvProgramAll) {
                posterFilmsOrSerialsOrTvProgram.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
        }

        List<ElementHandle> titleFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titleFilmsOrSerials : titleFilmsOrSerialsAll) {
            titleFilmsOrSerials.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextFilmsOrSerials : descriptionTextFilmsOrSerialsAll) {
            descriptionTextFilmsOrSerials.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> ageFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageFilmsOrSerialsAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> titleCollectionPackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionPackageOrMixedEst : titleCollectionPackageOrMixedEstAll) {
            titleCollectionPackageOrMixedEst.evaluate("t => t.innerText='Название подборки'");
        }
        // Подборки тв каналов:
        List<ElementHandle> collectionTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        for (int i = 0; i < collectionTvChannelAll.size(); i++) {
            collectionTvChannelAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//img");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }

        for (int i = 0; i < titleCollectionPackageOrMixedEstAll.size(); i++) {
            titleCollectionPackageOrMixedEstAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterPackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterPackageOrMixedEst : posterPackageOrMixedEstAll) {
                posterPackageOrMixedEst.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/MixedEst/ac/06/de807ef0bbe1f5dfd169144f19085474f890/tile__atablet-xhdpi.webp')");
            }
        }
        List<ElementHandle> titlePackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titlePackageOrMixedEst : titlePackageOrMixedEstAll) {
            titlePackageOrMixedEst.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackageOrMixedEst : descriptionTextPackageOrMixedEstAll) {
            descriptionTextPackageOrMixedEst.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> agePackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle agePackageOrMixedEst : agePackageOrMixedEstAll) {
            agePackageOrMixedEst.evaluate("a => a.innerText='18+'");
        }
//        page.querySelector("(//section[contains(@class,'HomePage_collection')])[24]").scrollIntoViewIfNeeded();
//        List<ElementHandle> posterPackage24All = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[24]//picture[contains(@class,'TilePackageCommon_image')]//source");
//        for (ElementHandle posterPackage24 : posterPackage24All) {
//            posterPackage24.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__aphone-xxhdpi.webp')");
//        }
//        List<ElementHandle> stickerAll = page.querySelectorAll("(//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//div[contains(@class,'TilePackageCommon_sticker')])[position()>1]");
//        for (ElementHandle stickerRemove : stickerAll) {
//            stickerRemove.evaluate("s => s.remove();");
//        }
//        List<ElementHandle> stickerFirst = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//div[contains(@class,'TilePackageCommon_sticker')]");
//        for (ElementHandle sticker : stickerFirst) {
//            sticker.evaluate("sC => sC.setAttribute('style', 'color:black;background-color:#24B56D')");
//            sticker.evaluate("sT => sT.innerText='Автотест'");
//        }

//            // подготовка блоков подборок без заголовка:
//            Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
//            Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
//            List<ElementHandle> posterCollection2All;
//            List<ElementHandle> titleCollection2All;
//            for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(); i++) {
//                posterCollection2All = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']");
//                page.evaluate("pC => pC.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection2All.get(i));
//                titleCollection2All = page.querySelectorAll("//h3[@data-test='CollectionName']");
//                page.evaluate("t => t.innerText='Название подборки (18+)'", titleCollection2All.get(i));
//            }


        // подготовка баннеров:
        page.querySelector("//button[@aria-label='previous']");
//        ElementHandle poster1 = page.querySelector("(//picture[contains(@class,'BannerCarousel')])[1]//source[@media='(min-width: 1440px)' and @type='image/webp']");
//        poster1.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
//        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
//        for(ElementHandle stiker : stikers){
//            stiker.evaluate("s => s.innerText='Автотест'");
//        }
//        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
//        for(ElementHandle colorStiker : colorStikers){
//            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
//        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }


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
        page.navigate("https://web-preprod6.megafon.tv/");
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

    public void checkImageNilPageScrollUser() throws InterruptedException, IOException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подготовка страницы "NilPage" к скриншот-тесту:
        // подготовка блоков подборок с заголовком:
        // подборки пакетов и коллекций MixedEST:
        Thread.sleep(5000);
        page.querySelector("//footer").scrollIntoViewIfNeeded();
//        page.querySelector("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]").scrollIntoViewIfNeeded();
        // подборки фильмов / сериалов / тв передач:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[24]").scrollIntoViewIfNeeded();

        List<ElementHandle> posterPackage24All = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[24]//picture[contains(@class,'TilePackageCommon_image')]");
        for (ElementHandle posterPackage24 : posterPackage24All) {
            posterPackage24.evaluate("p24 => p24.remove()");
        }

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionFilmsOrSerialsOrTvProgram : titleCollectionFilmsOrSerialsOrTvProgramAll) {
            titleCollectionFilmsOrSerialsOrTvProgram.evaluate("t => t.innerText='Название подборки'");
        }

        for (int i = 0; i < titleCollectionFilmsOrSerialsOrTvProgramAll.size(); i++) {
            titleCollectionFilmsOrSerialsOrTvProgramAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/') or contains(@href, '/tv/channels/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterFilmsOrSerialsOrTvProgram : posterFilmsOrSerialsOrTvProgramAll) {
                posterFilmsOrSerialsOrTvProgram.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
        }

        List<ElementHandle> titleFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titleFilmsOrSerials : titleFilmsOrSerialsAll) {
            titleFilmsOrSerials.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextFilmsOrSerials : descriptionTextFilmsOrSerialsAll) {
            descriptionTextFilmsOrSerials.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> ageFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageFilmsOrSerialsAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> titleCollectionPackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionPackageOrMixedEst : titleCollectionPackageOrMixedEstAll) {
            titleCollectionPackageOrMixedEst.evaluate("t => t.innerText='Название подборки'");
        }
        // Подборки тв каналов:
        List<ElementHandle> collectionTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        for (int i = 0; i < collectionTvChannelAll.size(); i++) {
            collectionTvChannelAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//img");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }

        for (int i = 0; i < titleCollectionPackageOrMixedEstAll.size(); i++) {
            titleCollectionPackageOrMixedEstAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterPackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterPackageOrMixedEst : posterPackageOrMixedEstAll) {
                posterPackageOrMixedEst.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/MixedEst/ac/06/de807ef0bbe1f5dfd169144f19085474f890/tile__atablet-xhdpi.webp')");
            }
        }
        List<ElementHandle> titlePackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titlePackageOrMixedEst : titlePackageOrMixedEstAll) {
            titlePackageOrMixedEst.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackageOrMixedEst : descriptionTextPackageOrMixedEstAll) {
            descriptionTextPackageOrMixedEst.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> agePackageOrMixedEstAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle agePackageOrMixedEst : agePackageOrMixedEstAll) {
            agePackageOrMixedEst.evaluate("a => a.innerText='18+'");
        }

//        List<ElementHandle> stickerAll = page.querySelectorAll("(//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//div[contains(@class,'TilePackageCommon_sticker')])[position()>1]");
//        for (ElementHandle stickerRemove : stickerAll) {
//            stickerRemove.evaluate("s => s.remove();");
//        }
//        List<ElementHandle> stickerFirst = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//div[contains(@class,'TilePackageCommon_sticker')]");
//        for (ElementHandle sticker : stickerFirst) {
//            sticker.evaluate("sC => sC.setAttribute('style', 'color:black;background-color:#24B56D')");
//            sticker.evaluate("sT => sT.innerText='Автотест'");
//        }

//            // подготовка блоков подборок без заголовка:
//            Assert.assertNotEquals("нет элемента - posterCollection", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(), 0);
//            Assert.assertNotEquals("нет элемента - collectionName", page.querySelectorAll("//h3[@data-test='CollectionName']").size(), 0);
//            List<ElementHandle> posterCollection2All;
//            List<ElementHandle> titleCollection2All;
//            for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']").size(); i++) {
//                posterCollection2All = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2wlpAXpsfCG6-Gto_H43-B']");
//                page.evaluate("pC => pC.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Collection/44/c9/3b579a939eed7a7301285886d33dc68bcdb8/tile_collection_group__web-wp.webp);')", posterCollection2All.get(i));
//                titleCollection2All = page.querySelectorAll("//h3[@data-test='CollectionName']");
//                page.evaluate("t => t.innerText='Название подборки (18+)'", titleCollection2All.get(i));
//            }

        // подготовка баннеров:
        page.querySelector("//button[@aria-label='previous']");

        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
//        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
//        for(ElementHandle stiker : stikers){
//            stiker.evaluate("s => s.innerText='Автотест'");
//        }
//        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
//        for(ElementHandle colorStiker : colorStikers){
//            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
//        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }


        // делаем скриншот полной страницы "NilPageFullUser":
        vrt.track(
                "NilPageFullUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCherdakAndBannersUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подготовка элемента "cherdakPageNil" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        // делаем скриншот элемента "cherdakPageNilUser":
        vrt.track(
                "cherdakPageNilUser",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[contains(@class,'carousel')]");
        // подготовка элемента "bannersPageNil" к скриншот-тесту:        }
//        крутилка:
//        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
//        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");
        page.click("//button[@aria-label='previous']");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

//        ElementHandle poster1 = page.querySelector("(//picture[contains(@class,'BannerCarousel')])[1]//source[@media='(min-width: 1440px)' and @type='image/webp']");
//        poster1.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
//        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
//        for(ElementHandle stiker : stikers){
//            stiker.evaluate("s => s.innerText='Автотест'");
//        }
//        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
//        for(ElementHandle colorStiker : colorStikers){
//            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
//        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }

        // делаем скриншот элемента "bannersPageNilUser":
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        vrt.track(
                "bannersPageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWithHeaderUser() {
    }

    public void checkImageFooterUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNilUser":
        vrt.track(
                "footerPageNilUser",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkScrollPageDownGuest() throws IOException, InterruptedException {
        // скролл вниз:
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionFilmsOrSerialsOrTvProgram : titleCollectionFilmsOrSerialsOrTvProgramAll) {
            titleCollectionFilmsOrSerialsOrTvProgram.evaluate("t => t.innerText='Название подборки'");
        }

        for (int i = 0; i < titleCollectionFilmsOrSerialsOrTvProgramAll.size(); i++) {
            titleCollectionFilmsOrSerialsOrTvProgramAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/') or contains(@href, '/tv/channels/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterFilmsOrSerialsOrTvProgram : posterFilmsOrSerialsOrTvProgramAll) {
                posterFilmsOrSerialsOrTvProgram.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
        }

        List<ElementHandle> titleFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titleFilmsOrSerials : titleFilmsOrSerialsAll) {
            titleFilmsOrSerials.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextFilmsOrSerials : descriptionTextFilmsOrSerialsAll) {
            descriptionTextFilmsOrSerials.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> ageFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageFilmsOrSerialsAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        vrt.track(
                "NilPageScrollDownGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        }

    public void checkScrollPageUpGuest() throws IOException, InterruptedException {
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionFilmsOrSerialsOrTvProgram : titleCollectionFilmsOrSerialsOrTvProgramAll) {
            titleCollectionFilmsOrSerialsOrTvProgram.evaluate("t => t.innerText='Название подборки'");
        }

        for (int i = 0; i < titleCollectionFilmsOrSerialsOrTvProgramAll.size(); i++) {
            titleCollectionFilmsOrSerialsOrTvProgramAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/') or contains(@href, '/tv/channels/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterFilmsOrSerialsOrTvProgram : posterFilmsOrSerialsOrTvProgramAll) {
                posterFilmsOrSerialsOrTvProgram.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
        }

        List<ElementHandle> titleFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titleFilmsOrSerials : titleFilmsOrSerialsAll) {
            titleFilmsOrSerials.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextFilmsOrSerials : descriptionTextFilmsOrSerialsAll) {
            descriptionTextFilmsOrSerials.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> ageFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageFilmsOrSerialsAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        page.querySelector("//button[@aria-label='previous']");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        vrt.track(
                "NilPageScrollUpGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkScrollPageDownUser() throws IOException, InterruptedException {
        // скролл вниз:
        Thread.sleep(5000);
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionFilmsOrSerialsOrTvProgram : titleCollectionFilmsOrSerialsOrTvProgramAll) {
            titleCollectionFilmsOrSerialsOrTvProgram.evaluate("t => t.innerText='Название подборки'");
        }

        for (int i = 0; i < titleCollectionFilmsOrSerialsOrTvProgramAll.size(); i++) {
            titleCollectionFilmsOrSerialsOrTvProgramAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/') or contains(@href, '/tv/channels/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterFilmsOrSerialsOrTvProgram : posterFilmsOrSerialsOrTvProgramAll) {
                posterFilmsOrSerialsOrTvProgram.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
        }

        List<ElementHandle> titleFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titleFilmsOrSerials : titleFilmsOrSerialsAll) {
            titleFilmsOrSerials.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextFilmsOrSerials : descriptionTextFilmsOrSerialsAll) {
            descriptionTextFilmsOrSerials.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> ageFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageFilmsOrSerialsAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        vrt.track(
                "NilPageScrollDownUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkScrollPageUpUser() throws IOException, InterruptedException {
        Thread.sleep(5000);
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        for (ElementHandle titleCollectionFilmsOrSerialsOrTvProgram : titleCollectionFilmsOrSerialsOrTvProgramAll) {
            titleCollectionFilmsOrSerialsOrTvProgram.evaluate("t => t.innerText='Название подборки'");
        }

        for (int i = 0; i < titleCollectionFilmsOrSerialsOrTvProgramAll.size(); i++) {
            titleCollectionFilmsOrSerialsOrTvProgramAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/') or contains(@href, '/tv/channels/')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterFilmsOrSerialsOrTvProgram : posterFilmsOrSerialsOrTvProgramAll) {
                posterFilmsOrSerialsOrTvProgram.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
        }

        List<ElementHandle> titleFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titleFilmsOrSerials : titleFilmsOrSerialsAll) {
            titleFilmsOrSerials.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextFilmsOrSerials : descriptionTextFilmsOrSerialsAll) {
            descriptionTextFilmsOrSerials.evaluate("d => d.textContent='Текст описания'");
        }
        List<ElementHandle> ageFilmsOrSerialsAll = page.querySelectorAll("//a[contains(@href, '/movies/vods/') or contains(@href, '/shows/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageFilmsOrSerialsAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        page.querySelector("//button[@aria-label='previous']");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        vrt.track(
                "NilPageScrollUpUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkBlockCollectionFilmWithoutImagesGuest() throws IOException, InterruptedException {
        Thread.sleep(5000);
        page.reload();
        Thread.sleep(3000);
        ElementHandle blockCollectionFilmWithoutImages = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
//        подготовка элемента 'blockCollectionWithHeaderPageNil' к скриншот-тесту:

        ElementHandle titleBlockCollectionFilmsOrSerial = page.querySelector("(//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionFilmsOrSerial);

        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')][position()!=3]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titlePackage : titlePackageAll) {
            titlePackage.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackage : descriptionTextPackageAll) {
            descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')][24]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        page.querySelector("//button[@aria-label='previous']");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
// делаем скриншот части страницы:
        vrt.track(
                "BlockCollectionFilmWithoutImagesPageNilGuest",
                Base64.getEncoder().encodeToString(page.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkBlockCollectionFilmWithoutImagesUser() throws IOException, InterruptedException {
        Thread.sleep(5000);
        page.reload();
        Thread.sleep(3000);
        ElementHandle blockCollectionFilmWithoutImages = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
//        подготовка элемента 'blockCollectionWithHeaderPageNil' к скриншот-тесту:

        ElementHandle titleBlockCollectionFilmsOrSerial = page.querySelector("(//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionFilmsOrSerial);

        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')][position()!=3]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titlePackage : titlePackageAll) {
            titlePackage.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackage : descriptionTextPackageAll) {
            descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')][24]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        page.querySelector("//button[@aria-label='previous']");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
// делаем скриншот части страницы:
        vrt.track(
                "BlockCollectionFilmWithoutImagesPageNilUser",
                Base64.getEncoder().encodeToString(page.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageMenuMinPageNilGuest() throws IOException, InterruptedException {
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageNilGuest":
//        vrt.track(
//                "cherdakMinPageNilGuest",
//                Base64.getEncoder().encodeToString(cherdak.screenshot()),
//                TestRunOptions.builder()
//                        .device("Acer")
//                        .os("Win10 Pro")
//                        .browser("Chrome")
//                        .diffTollerancePercent(0.3f)
//                        .build());
    }

    public void checkElementsMenuMinPageNilGuest() {
        page.querySelector("//img[@alt='Мегафон ТВ']");
//        assertTrue(page.querySelector("(//div[text()='Все сервисы'])[1]").isVisible());
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller'])[1]");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
    }

    public void checkElementsMenuMediumPageNilGuest() throws InterruptedException {
        Thread.sleep(5000);
        page.querySelector("//img[@alt='Мегафон ТВ']");
//        assertTrue(page.querySelector("(//div[text()='Все сервисы'])[1]").isVisible());
        page.querySelector("ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller'])[1]");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
    }

    public void checkImageMenuMediumPageNilGuest() throws IOException, InterruptedException {
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageNilGuest":
        vrt.track(
                "cherdakMediumPageNilGuest",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openBlockMenuMegaFonAndCheckImageMinPageNil() throws IOException, InterruptedException {
        page.click("(//div[text()='Все сервисы'])[1]");
        ElementHandle blockMenuMegaFonMinPageNil = page.querySelector("//div[@class='ch-drop-down__popup']");
        vrt.track(
                "blockMenuMegaFonMinPageNilGuest",
                Base64.getEncoder().encodeToString(blockMenuMegaFonMinPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openBlockMenuMegaFonAndCheckImageMediumPageNilGuest() throws IOException, InterruptedException {
        page.querySelector("(//div[text()='Все сервисы'])[1]").hover();
        ElementHandle blockMenuMegaFonMediumPageNil = page.querySelector("(//div[@class='ch-drop-down__popup']//ul)[2]");
        vrt.track(
                "blockMenuMegaFonMediumPageNilGuest",
                Base64.getEncoder().encodeToString(blockMenuMegaFonMediumPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openBlockMenuMftvAndCheckImageMinPageNilGuest() throws IOException, InterruptedException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        ElementHandle blockMenuMftvMinPageNil = page.querySelector("//div[@class='ch-mobile-menu__container']");
        vrt.track(
                "blockMenuMftvMinPageNilGuest",
                Base64.getEncoder().encodeToString(blockMenuMftvMinPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openBlockMenuMftvAndCheckImageMediumPageNilGuest() throws IOException, InterruptedException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        ElementHandle blockMenuMftvMediumPageNil = page.querySelector("//div[@class='ch-mobile-menu__container']");
        vrt.track(
                "blockMenuMftvMediumPageNilGuest",
                Base64.getEncoder().encodeToString(blockMenuMftvMediumPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsMenuWidePageNilGuest() throws InterruptedException {
        Thread.sleep(5000);
        page.querySelector("//img[@alt='Мегафон ТВ']");
//        assertTrue(page.querySelector("(//div[text()='Все сервисы'])[1]").isVisible());
        page.querySelector("ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller'])[1]");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
    }

    public void checkImageMenuWidePageNilGuest() throws IOException, InterruptedException {
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageNilGuest":
        vrt.track(
                "cherdakWidePageNilGuest",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsMenuMinPageNilUser() {
        page.querySelector("//img[@alt='Мегафон ТВ']");
//        assertTrue(page.querySelector("(//div[text()='Все сервисы'])[1]").isVisible());
        page.querySelector("//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller__trigger']");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
    }

    public void checkImageMenuMinPageNilUser() throws IOException, InterruptedException {
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageNilUser":
        vrt.track(
                "cherdakMinPageNilUser",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openBlockMenuMftvMinPageNilUser() throws IOException, InterruptedException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        ElementHandle blockMenuMftvMinPageNil = page.querySelector("//div[@class='ch-mobile-menu__container']");
        vrt.track(
                "blockMenuMftvMinPageNilUser",
                Base64.getEncoder().encodeToString(blockMenuMftvMinPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("//div[@class='ch-mobile-menu__container']//*[@id='close-mobilemenu']");
    }

    public void checkElementsMenuMediumPageNilUser() throws InterruptedException {
        Thread.sleep(5000);
        page.querySelector("//img[@alt='Мегафон ТВ']");
        assertTrue(page.querySelector("(//div[text()='Все сервисы'])[1]").isVisible());
        page.querySelector("//button[@class='ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search']");
        page.querySelector("//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller__trigger']");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
    }

    public void checkImageMenuMediumPageNilUser() throws IOException, InterruptedException {
        Thread.sleep(5000);
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageNilUser":
        vrt.track(
                "cherdakMediumPageNilUser",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openBlockMenuMegaFonMediumPageNilUser() throws IOException, InterruptedException {
        page.click("(//div[text()='Все сервисы'])[1]");
        ElementHandle blockMenuMegaFonMediumPageNil = page.querySelector("(//div[@class='ch-drop-down__popup']//ul)[2]");
        vrt.track(
                "blockMenuMegaFonMediumPageNilGuest",
                Base64.getEncoder().encodeToString(blockMenuMegaFonMediumPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openBlockMenuMftvMediumPageNilUser() throws IOException, InterruptedException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        ElementHandle blockMenuMftvMediumPageNil = page.querySelector("//div[@class='ch-mobile-menu__container']");
        vrt.track(
                "blockMenuMftvMediumPageNilGuest",
                Base64.getEncoder().encodeToString(blockMenuMftvMediumPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("//div[@class='ch-mobile-menu__container']//*[@id='close-mobilemenu']");
    }

    public void openBlockMenuProfileMinPageNil() throws IOException, InterruptedException {
        page.click("//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller__trigger']");
        ElementHandle blockMenuProfileMinPageNil = page.querySelector("//div[@class='ch-mobile-menu__container']");
        ElementHandle userLogin = page.querySelector("//div[@class='ch-mobile-menu__container']//div[@class='ch-account__title']");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        vrt.track(
                "blockMenuProfileMinPageNil",
                Base64.getEncoder().encodeToString(blockMenuProfileMinPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("//div[@class='ch-mobile-menu__container']//*[@id='close-mobilemenu']");
    }

    public void openBlockMenuProfileMediumPageNil() throws IOException, InterruptedException {
        page.click("//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller__trigger']");
        ElementHandle blockMenuProfileMediumPageNil = page.querySelector("//div[@class='ch-mobile-menu__container']");
        ElementHandle userLogin = page.querySelector("//div[@class='ch-mobile-menu__container']//div[@class='ch-account__title']");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        vrt.track(
                "blockMenuProfileMediumPageNil",
                Base64.getEncoder().encodeToString(blockMenuProfileMediumPageNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("//div[@class='ch-mobile-menu__container']//*[@id='close-mobilemenu']");
    }

    public void checkImageMenuWidePageNilUser() throws IOException, InterruptedException {
        Thread.sleep(5000);
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        // делаем скриншот элемента "cherdakWidePageNilUse":
        vrt.track(
                "cherdakWidePageNilUser",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void goToTabsHeaderMenuMftvGuest() throws InterruptedException {
        page.click("(//div[text()='ТВ'])[1]");
        page.waitForSelector("//div[text()='Передачи в эфире']");
        page.waitForSelector("//div[text()='Программа передач']");
        Assert.assertTrue(page.url().contains("https://web-preprod6.megafon.tv/tv/tv_catalog"));

        page.click("(//div[text()='Новое и Лучшее'])[1]");
        page.reload();
        page.waitForSelector("//div[contains(@class,'BannerCarouselItem')]");
        Assert.assertEquals("https://web-preprod6.megafon.tv/", page.url());

        page.click("(//div[text()='Фильмы'])[1]");
        page.waitForSelector("//h1[text()='Фильмы']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/movies/vods", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Сериалы'])[1]");
        page.waitForSelector("//h1[text()='Сериалы']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/shows", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Детям'])[1]");
        page.waitForSelector("//span[text()='Детям']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/kids", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Спорт'])[1]");
        page.waitForSelector("//h1[text()='Спорт']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/sport", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Магазин'])[1]");
        page.waitForSelector("//span[text()='Магазин']");
        page.waitForSelector("//div[text()='Все пакеты']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/packages", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

//        page.click("(//div[text()='Подборки'])[1]");
//        page.waitForSelector("//h1[text()='Популярные подборки фильмов и сериалов']");
//        page.waitForSelector("//span[text()='Подборки']");
//        Assert.assertEquals("https://web-preprod6.megafon.tv/collection", page.url());
//        page.navigate("https://web-preprod6.megafon.tv/");
//        page.reload();

        page.click("(//div[text()='Моё'])[1]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        Assert.assertTrue(page.url().contains("https://web-preprod6.megafon.tv/auth"));
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();
    }

    public void chooseSearchAndCheckImageWibePageGuest() throws IOException, InterruptedException {
        page.click("//button[@class='ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search']");
        Thread.sleep(5000);
        ElementHandle searchForm = page.waitForSelector("//div[@class='ch-cherdak']");
        vrt.track(
                "searchFormWidePageNilGuest",
                Base64.getEncoder().encodeToString(searchForm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("(//div[@class='ch-search__icon']//*[@id='close-search'])[1]");
    }

    public void clickOnEnterButtonAndCheckImage() throws IOException, InterruptedException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller'])[1]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        Thread.sleep(5000);
        vrt.track(
                "pageAuthorizationAndRegistration",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void choosePromoCodeAndCheckImageWidePageNilGuest() throws IOException, InterruptedException {
        page.click("(//div[text()='Промокод'])[1]");
        page.waitForSelector("//h1[text()='Введите промокод']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/promocodes", page.url());
        Thread.sleep(5000);
        vrt.track(
                "widePagePromoCodeGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void choosePromoCodeAndCheckImageMinPageNilGuest() throws InterruptedException, IOException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        page.click("(//div[text()='Промокод'])[2]");
        Thread.sleep(5000);
        vrt.track(
                "minPagePromoCodeGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void choosePromoCodeAndCheckImageMediumPageNilGuest() throws InterruptedException, IOException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        page.click("(//div[text()='Промокод'])[2]");
        Thread.sleep(5000);
        vrt.track(
                "mediumPagePromoCodeGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void chooseSearchAndCheckImageMinPageGuest() throws InterruptedException, IOException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        ElementHandle searchForm = page.querySelector("//div[@class='ch-mobile-menu__container']");
        page.click("//button[contains(@class,'ch-mobile-menu__trigger_type_search')]");
        Thread.sleep(5000);
        vrt.track(
                "searchFormMinPageNilGuest",
                Base64.getEncoder().encodeToString(searchForm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void chooseSearchAndCheckImageMediumPageGuest() throws InterruptedException, IOException {
        page.click("//button[@class='ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search']");
        Thread.sleep(5000);
        ElementHandle searchForm = page.waitForSelector("//div[@class='ch-cherdak']");
        vrt.track(
                "searchFormMediumPageNilGuest",
                Base64.getEncoder().encodeToString(searchForm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("(//div[@class='ch-search__icon']//*[@id='close-search'])[1]");
    }

    public void goToTabsHeaderMenuMftvUser() throws InterruptedException {
        page.click("(//div[text()='ТВ'])[1]");
        Thread.sleep(5000);
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.waitForSelector("//div[text()='Передачи в эфире']");
        page.waitForSelector("//div[text()='Программа передач']");
        Assert.assertTrue(page.url().contains("https://web-preprod6.megafon.tv/tv/tv_catalog"));

        page.click("(//div[text()='Новое и Лучшее'])[1]");
        page.reload();
        page.waitForSelector("//div[contains(@class,'BannerCarouselItem')]");
        Assert.assertEquals("https://web-preprod6.megafon.tv/", page.url());

        page.click("(//div[text()='Фильмы'])[1]");
        page.waitForSelector("//h1[text()='Фильмы']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/movies/vods", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Сериалы'])[1]");
        page.waitForSelector("//h1[text()='Сериалы']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/shows", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Детям'])[1]");
        page.waitForSelector("//span[text()='Детям']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/kids", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Спорт'])[1]");
        page.waitForSelector("//h1[text()='Спорт']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/sport", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

        page.click("(//div[text()='Магазин'])[1]");
        page.waitForSelector("//span[text()='Магазин']");
        page.waitForSelector("//div[text()='Все пакеты']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/packages", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();

//        page.click("(//div[text()='Подборки'])[1]");
//        page.waitForSelector("//h1[text()='Популярные подборки фильмов и сериалов']");
//        page.waitForSelector("//span[text()='Подборки']");
//        Assert.assertEquals("https://web-preprod6.megafon.tv/collection", page.url());
//        page.navigate("https://web-preprod6.megafon.tv/");
//        page.reload();

        page.click("(//div[text()='Моё'])[1]");
        page.waitForSelector("//div[text()='Избранное']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/my/favorites",page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();
    }

    public void choosePromoCodeAndCheckImageMinPageNilUser() throws InterruptedException, IOException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        page.click("(//div[text()='Промокод'])[2]");
        Thread.sleep(5000);

        vrt.track(
                "minPagePromoCodeUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void choosePromoCodeAndCheckImageMediumPageNilUser() throws InterruptedException, IOException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        page.click("(//div[text()='Промокод'])[2]");
        Thread.sleep(5000);
        vrt.track(
                "mediumPagePromoCodeUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void choosePromoCodeAndCheckImageWidePageNilUser() throws InterruptedException, IOException {
        page.click("(//div[text()='Промокод'])[1]");
        page.waitForSelector("//h1[text()='Введите промокод']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/promocodes", page.url());
        Thread.sleep(5000);
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        vrt.track(
                "widePagePromoCodeUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void chooseSearchAndCheckImageMinPageUser() throws InterruptedException, IOException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        ElementHandle searchForm = page.querySelector("//div[@class='ch-mobile-menu__container']");
        page.click("//button[contains(@class,'ch-mobile-menu__trigger_type_search')]");
        Thread.sleep(5000);
        vrt.track(
                "searchFormMinPageNilUser",
                Base64.getEncoder().encodeToString(searchForm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void chooseSearchAndCheckImageMediumPageUser() throws IOException, InterruptedException {
        page.click("//button[@class='ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search']");
        Thread.sleep(5000);
        ElementHandle searchForm = page.waitForSelector("//div[@class='ch-cherdak']");
        vrt.track(
                "searchFormMediumPageNilUser",
                Base64.getEncoder().encodeToString(searchForm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("(//div[@class='ch-search__icon']//*[@id='close-search'])[1]");
    }

    public void chooseSearchAndCheckImageWidePageUser() throws IOException, InterruptedException {
        page.click("//button[@class='ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search']");
        Thread.sleep(5000);
        ElementHandle searchForm = page.waitForSelector("//div[@class='ch-cherdak']");
        vrt.track(
                "searchFormWidePageNilUser",
                Base64.getEncoder().encodeToString(searchForm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.click("(//div[@class='ch-search__icon']//*[@id='close-search'])[1]");
    }

    public void goToSectionsProfileMenu() throws InterruptedException {
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Акции'])[1]");
        Thread.sleep(3000);
        Thread.sleep(3000);
        page.querySelector("(//span[contains(text(),'+792')])[2]|//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller__trigger']");
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.waitForSelector("//h1//span[text()='Акции']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/profile/promotions", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");

        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Способы оплаты'])[1]");
        page.waitForSelector("//h1//span[text()='Способы оплаты']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/profile/payment_methods", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        Thread.sleep(3000);
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Подключить SmartTV'])[1]");
        page.waitForSelector("//h1[text()='Подключить ТВ']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/connect_smart_tv", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        Thread.sleep(3000);
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Управление пакетами и сервисами'])[1]");
        page.waitForSelector("(//span[text()='Управление пакетами и сервисами'])[3]");
        Assert.assertEquals("https://web-preprod6.megafon.tv/profile/subscription_management", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        Thread.sleep(3000);
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Email'])[1]");
        page.waitForSelector("//div[text()='Email']");
        page.waitForSelector("//div[@aria-label='Notification']");
        page.navigate("https://web-preprod6.megafon.tv/");
        Thread.sleep(3000);
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Выйти'])[1]");
        page.waitForSelector("//button[contains(@class,'ch-account-controller')]");
    }

    public void checkElementsBannerMediumPageNilGuest() {
        page.waitForSelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");

        List<ElementHandle> titleContentAll = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media='(min-width: 320px)' and @type='image/webp']");
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");

        Assert.assertEquals(titleContentAll.size(), banners.size());
        Assert.assertEquals(postersSourceWEBP.size(), banners.size());
        Assert.assertEquals(yearAndGenres.size(), banners.size());
        Assert.assertEquals(ages.size(), banners.size());
    }

    public void checkImageBannerMinPageNilGuest() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        Thread.sleep(2000);
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "bannersMinPageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsBannerMinPageNilGuest() {
      page.waitForSelector("//div[contains(@class,'carousel')]");
      List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");

      List<ElementHandle> titleContentAll = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
      List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media='(min-width: 320px)' and @type='image/webp']");
      List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
      List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");

      Assert.assertEquals(titleContentAll.size(), banners.size());
      Assert.assertEquals(postersSourceWEBP.size(), banners.size());
      Assert.assertEquals(yearAndGenres.size(), banners.size());
      Assert.assertEquals(ages.size(), banners.size());
    }

    public void checkImageBannerMediumPageNilGuest() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        Thread.sleep(2000);
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "bannersMediumPageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsBannerWidePageNilGuest() {
        page.waitForSelector("//div[contains(@class,'carousel')]");
        page.waitForSelector("//button[@aria-label='next']");
        page.waitForSelector("//button[@aria-label='previous']");
        page.waitForSelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");

        List<ElementHandle> titleContentAll = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media='(min-width: 320px)' and @type='image/webp']");
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        List<ElementHandle> buttonTrailer = page.querySelectorAll("//a[contains(@class,'buttonWatch' ) and text()='Трейлер']");
        List<ElementHandle> buttonFavorite = page.querySelectorAll("//button[contains(@class,'buttonFavourite')]");

        Assert.assertEquals(titleContentAll.size(), banners.size());
        Assert.assertEquals(postersSourceWEBP.size(), banners.size());
        Assert.assertEquals(yearAndGenres.size(), banners.size());
        Assert.assertEquals(ages.size(), banners.size());
        Assert.assertEquals(buttonTrailer.size(), banners.size());
        Assert.assertEquals(buttonFavorite.size(), banners.size());
    }

    public void checkImageBannerWidePageNilGuest() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        Thread.sleep(2000);
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "bannersWidePageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsBannerMinPageNilUser() {
        page.waitForSelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");

        List<ElementHandle> titleContentAll = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media='(min-width: 320px)' and @type='image/webp']");
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");

        Assert.assertEquals(titleContentAll.size(), banners.size());
        Assert.assertEquals(postersSourceWEBP.size(), banners.size());
        Assert.assertEquals(yearAndGenres.size(), banners.size());
        Assert.assertEquals(ages.size(), banners.size());
    }

    public void checkImageBannerMinPageNilUser() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        Thread.sleep(2000);
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "bannersMinPageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsBannerMediumPageNilUser() {
        page.waitForSelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");

        List<ElementHandle> titleContentAll = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media='(min-width: 320px)' and @type='image/webp']");
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");

        Assert.assertEquals(titleContentAll.size(), banners.size());
        Assert.assertEquals(postersSourceWEBP.size(), banners.size());
        Assert.assertEquals(yearAndGenres.size(), banners.size());
        Assert.assertEquals(ages.size(), banners.size());
    }

    public void checkImageBannerMediumPageNilUser() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        Thread.sleep(2000);
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "bannersMediumPageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsBannerWidePageNilUser() {
        page.waitForSelector("//div[contains(@class,'carousel')]");
        page.waitForSelector("//button[@aria-label='next']");
        page.waitForSelector("//button[@aria-label='previous']");
        page.waitForSelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");

        List<ElementHandle> titleContentAll = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media='(min-width: 320px)' and @type='image/webp']");
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        List<ElementHandle> buttonTrailer = page.querySelectorAll("//a[contains(@class,'buttonWatch' ) and text()='Трейлер']");
        List<ElementHandle> buttonFavorite = page.querySelectorAll("//button[contains(@class,'buttonFavourite')]");

        Assert.assertEquals(titleContentAll.size(), banners.size());
        Assert.assertEquals(postersSourceWEBP.size(), banners.size());
        Assert.assertEquals(yearAndGenres.size(), banners.size());
        Assert.assertEquals(ages.size(), banners.size());
        Assert.assertEquals(buttonTrailer.size(), banners.size());
        Assert.assertEquals(buttonFavorite.size(), banners.size());
    }

    public void checkImageBannerWidePageNilUser() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        Thread.sleep(2000);
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "bannersWidePageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkHoverTrailerImageGuest() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle buttonWatch = page.querySelector("//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        buttonWatch.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverButtonTrailerPageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.05f)
                        .build());
    }

    public void checkHoverFavoriteImageGuest() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle buttonFavourite = page.querySelector("//button[contains(@class,'buttonFavourite')]");
        buttonFavourite.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverButtonFavoritePageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.003f)
                        .build());
    }

    public void checkHoverBlockArrowNextImageGuest() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle arrowNext = page.querySelector("//button[@aria-label='next']");
        arrowNext.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverArrowNextPageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.003f)
                        .build());
    }

    public void checkHoverBlockArrowPreviousImageGuest() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle arrowPrevious = page.querySelector("//button[@aria-label='previous']");
        arrowPrevious.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverArrowPreviousPageNilGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.003f)
                        .build());
    }

    public void checkHoverTrailerImageUser() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle buttonWatch = page.querySelector("//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        buttonWatch.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverButtonTrailerPageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.05f)
                        .build());
    }

    public void checkHoverFavoriteImageUser() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle buttonFavourite = page.querySelector("//button[contains(@class,'buttonFavourite')]");
        buttonFavourite.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverButtonFavoritePageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.003f)
                        .build());
    }

    public void checkHoverBlockArrowNextImageUser() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle arrowNext = page.querySelector("//button[@aria-label='next']");
        arrowNext.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverArrowNextPageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.003f)
                        .build());
    }

    public void checkHoverBlockArrowPreviousImageUser() throws IOException, InterruptedException {
        // подготовка элемента "bannersPageNil" к скриншот-тесту:
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        ElementHandle changeTransform = page.querySelector("//ul[contains(@class,'sliderAnimation')]");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'display: flex; align-items: stretch; width: 3800%; transform: translateX(0%) translateX(0px); flex-direction: row;')");
        ElementHandle arrowPrevious = page.querySelector("//button[@aria-label='previous']");
        arrowPrevious.hover();
        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "hoverArrowPreviousPageNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.003f)
                        .build());
    }

    public void checkScrollBannersToRight() {
        List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");
        for (int i = 0; i < banners.size(); i++) {
            String nameContentCurrent = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
            page.click("//button[@aria-label='next']");
            String nameContentNext = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
            System.out.println(nameContentNext);
            Assert.assertNotEquals(nameContentCurrent, nameContentNext);
        }
    }

    public void checkScrollBannersToLeft() {
        List<ElementHandle> banners = page.querySelectorAll("//div[contains(@class,'BannerCarouselItem_bannerWrap')]");
        for (int i = 0; i < banners.size(); i++) {
            String nameContentCurrent = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
            page.click("//button[@aria-label='previous']");
            String nameContentPrevious = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
            System.out.println(nameContentPrevious);
            Assert.assertNotEquals(nameContentCurrent, nameContentPrevious);
        }
    }

    public void checkScrollLastBannerToRight() {
        page.navigate("https://web-preprod6.megafon.tv/");
        String nameContentFirst = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        page.click("//button[@aria-label='previous']");
        String nameContentLast = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        page.click("//button[@aria-label='next']");
        String nameContentCurrent = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertNotEquals(nameContentLast, nameContentCurrent);
        Assert.assertEquals(nameContentCurrent, nameContentFirst);
    }

    public void checkScrollFirstBannerToLeft() {
        page.navigate("https://web-preprod6.megafon.tv/");
        String nameContentFirst = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        page.click("//button[@aria-label='previous']");
        String nameContentLast = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertNotEquals(nameContentLast, nameContentFirst);
    }


    public void clickToFavoriteFilmOnBannerGuest() {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/movies/vods/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickToFavoriteSerialOnBannerGuest() {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void checkClickToFavoriteTvProgramOnBannerGuest() {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickToFavoriteTvChannelOnBannerGuest() {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void checkAddToFavoriteFilmFromBannerUser() throws IOException, InterruptedException {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/movies/vods/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        Thread.sleep(2000);
        String nameFilmAdd = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();

        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");

        List<ElementHandle> yearAndGenres = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_genre')]");
        for (ElementHandle yearAndGenre : yearAndGenres) {
            yearAndGenre.evaluate("yG => yG.innerText='2021, Жанр'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//span[contains(@class,'BannerCarouselItem_parentalRating')]");
        for (ElementHandle age : ages) {
            age.evaluate("yG => yG.innerText='18+'");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//h2[contains(@class,'BannerCarouselItem_title')]");
        for (ElementHandle titleBanner : titleBanners) {
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }

        // делаем скриншот элемента "bannersPageNilGuest":
        vrt.track(
                "bannerFavoriteFilmOnNilUser",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameFilmAdd, page.querySelector("//a[contains(@href,'/movies/vods/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }


    public void checkAddToFavoriteSerialFromBannerUser() throws IOException, InterruptedException {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        Thread.sleep(2000);
        String nameSerialAdd = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size()>0);
//        System.out.println(page.querySelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]").getAttribute("color"));
//        System.out.println(page.querySelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]").getAttribute("background"));

        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameSerialAdd, page.querySelector("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void checkAddToFavoriteTvProgramFromBannerUser() throws InterruptedException {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        String nameTvProgramAdd = page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size()>0);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameTvProgramAdd, page.querySelector("//a[contains(@href,'/programs/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void checkAddToFavoriteTvChannelFromBannerUser() {
        while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size()<1){
            page.click("//button[@aria-label='next']");
        }
        page.waitForSelector("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        String nameTvProgramAdd = page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size()>0);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameTvProgramAdd, page.querySelector("//a[contains(@href,'/tv/channels/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void checkRemoveToFavoriteFilmFromBannerUser() {
        if(page.querySelectorAll("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size()!=0){
            while(page.querySelectorAll("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size()<1){
            page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size()<1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/vods/')]//h3[@data-test='PackageDescriptionTitle']").size()<1);
    }

    public void checkRemoveToFavoriteSerialFromBannerUser() {
        if(page.querySelectorAll("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size()!=0){
            while(page.querySelectorAll("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size()<1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").size()<1);
    }

    public void checkRemoveToFavoriteTvProgramFromBannerUser() {
        if(page.querySelectorAll("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size()!=0){
            while(page.querySelectorAll("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size()<1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/programs/')]//h3[@data-test='PackageDescriptionTitle']").size()<1);
    }

    public void checkRemoveToFavoriteTvChannelFromBannerUser() {
        if(page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size()!=0){
            while(page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size()<1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/tv/channels/')]//h3[@data-test='PackageDescriptionTitle']").size()<1);
    }

    public void clickToButtonTrailerFilmOnBanner() {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/vods/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/vods/')]").size()<1){
            page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.click("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.waitForSelector("//span[text()='Фильмы']");
        Assert.assertTrue(page.url().contains("/movies/vods/"));
    }

    public void clickToButtonTrailerSerialOnBanner() throws InterruptedException {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/shows/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.click("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.waitForSelector("//span[text()='Сериалы']");
        Assert.assertTrue(page.url().contains("/shows/"));
    }

    public void clickToButtonTrailerTvProgramOnBanner() {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/programs/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.click("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.waitForSelector("//span[text()='ТВ']");
        Assert.assertTrue(page.url().contains("/programs/"));
        page.waitForSelector("//div[contains(@style,'background-image: url')]");
    }

    public void clickToButtonTrailerTvChannelOnBanner() {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/tv/channels/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size()!=0){
            page.click("//button[@aria-label='next']");
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.click("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.waitForSelector("//span[text()='ТВ']");
        Assert.assertTrue(page.url().contains("/tv/channels/"));
        page.waitForSelector("//div[contains(@style,'background-image: url')]");
    }

    public void clickOnBannerFilm() {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/vods/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/vods/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.click("//div[contains(@class,'BannerCarouselItem_bannerWrap')]//a[contains(@href,'/vods/')]");
        page.waitForSelector("//span[text()='Фильмы']");
        Assert.assertTrue(page.url().contains("/movies/vods/"));
    }

    public void clickOnBannerSerial() {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/shows/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.click("//div[contains(@class,'BannerCarouselItem_bannerWrap')]//a[contains(@href,'/shows/')]");
        page.waitForSelector("//span[text()='Сериалы']");
        Assert.assertTrue(page.url().contains("/shows/"));

    }

    public void clickOnBannerTvProgram() {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/programs/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.click("//div[contains(@class,'BannerCarouselItem_bannerWrap')]//a[contains(@href,'/programs/')]");
        page.waitForSelector("//span[text()='ТВ']");
        Assert.assertTrue(page.url().contains("/programs/"));
        page.waitForSelector("//div[contains(@style,'background-image: url')]");
    }

    public void clickOnBannerTvChannel() {
        if(page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/tv/channels/')]").size()!=0){
            while(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size()<1){
                page.click("//button[@aria-label='next']");
            }
        }
        page.click("//div[contains(@class,'BannerCarouselItem_bannerWrap')]//a[contains(@href,'/tv/channels/')]");
        page.waitForSelector("//span[text()='ТВ']");
        Assert.assertTrue(page.url().contains("/tv/channels/"));
        page.waitForSelector("//div[contains(@style,'background-image: url')]");
    }

    public void openBlockMenuMegaFonMinPageNilUser() {
    }

    public void checkElementsCollection() throws InterruptedException {
        List<ElementHandle> collectionAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]");
        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        Assert.assertEquals(titleCollectionFilmsOrSerialsOrTvProgramAll.size(), collectionAll.size());
        List<ElementHandle> arrowsPreviousAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//button[@aria-label='show previous content']");
        Assert.assertEquals(arrowsPreviousAll.size(), collectionAll.size());
        List<ElementHandle> arrowsNextAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//button[@aria-label='show next content']");
        Assert.assertEquals(arrowsNextAll.size(), collectionAll.size());
        page.querySelector("//section[contains(@class,'HomePage_collection')]");
        List<ElementHandle> tailAllExceptTV = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//a[@href and contains(@class,'TilePackageCommon_tile')]");
        List<ElementHandle> posterAllExceptTV = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[30]//picture[contains(@class,'TilePackageCommon_image')]");
        page.querySelector("//footer").scrollIntoViewIfNeeded();
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();

        for (int b = 0; b < tailAllExceptTV.size(); b++) {
            tailAllExceptTV.get(b).scrollIntoViewIfNeeded();
            tailAllExceptTV.get(b).waitForSelector("//picture[contains(@class,'TilePackageCommon_image')]");
            Assert.assertEquals(1, tailAllExceptTV.get(b).querySelectorAll("//picture[contains(@class,'TilePackageCommon_image')]").size());
            }
        }

    public void checkImageBlocksCollectionMinPageNil() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        ElementHandle blockCollectionExceptTv = page.querySelector("//section[contains(@class,'HomePage_collection')]");
        page.querySelector("//section[contains(@class,'HomePage_collection')]").scrollIntoViewIfNeeded();

//        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
//        List<ElementHandle> posterPackage1All = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]");
//        for (ElementHandle posterPackage1 : posterPackage1All) {
//            posterPackage1.evaluate("p1 => p1.remove()");
//        }

        ElementHandle titleBlockCollectionFilmsOrSerial = page.querySelector("//h2[contains(@class,'MediaScroller_title')]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionFilmsOrSerial);

        List<ElementHandle> posterPackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titlePackage : titlePackageAll) {
            titlePackage.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackage : descriptionTextPackageAll) {
            descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }

//        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _20sDPzuxbeD_zlQAuQfNyy']");
//        for(ElementHandle sticker : stickerAll){
//            sticker.evaluate("s => s.remove();");
//        }
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvMinPageNilGuestOrUser",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        // подборки тв каналов:
        ElementHandle blockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");
        ElementHandle titleBlockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionTv);
        List<ElementHandle> collectionTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        for (int i = 0; i < collectionTvChannelAll.size(); i++) {
            collectionTvChannelAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//img");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }


        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvMinPageNilGuestOrUser",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionMediumPageNil() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("//section[contains(@class,'HomePage_collection')]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("//section[contains(@class,'HomePage_collection')]");


//        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
//        List<ElementHandle> posterPackage1All = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]");
//        for (ElementHandle posterPackage1 : posterPackage1All) {
//            posterPackage1.evaluate("p1 => p1.remove()");
//        }

        ElementHandle titleBlockCollectionFilmsOrSerial = page.querySelector("//h2[contains(@class,'MediaScroller_title')]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionFilmsOrSerial);

        List<ElementHandle> titlePackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle titlePackage : titlePackageAll) {
            titlePackage.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackage : descriptionTextPackageAll) {
            descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");

            List<ElementHandle> posterPackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterPackage : posterPackageAll) {
                posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
            }
        }


        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvMediumPageNilGuestOrUser",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        // подборки тв каналов:
        ElementHandle blockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");
        ElementHandle titleBlockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionTv);
        List<ElementHandle> collectionTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        for (int i = 0; i < collectionTvChannelAll.size(); i++) {
            collectionTvChannelAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//img");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }


        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvMediumPageNilGuestOrUser",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}






















































