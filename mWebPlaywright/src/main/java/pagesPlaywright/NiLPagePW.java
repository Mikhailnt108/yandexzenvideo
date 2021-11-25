package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;
import com.microsoft.playwright.options.MouseButton;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.pageHeadfull;
import static base.TestBasePlaywright.vrt;
import static java.lang.Thread.sleep;

public class NiLPagePW extends BasePagePlaywright {
    private Page page;
    private Page pageSmartTv;
    private BrowserContext contextIncognitoModeHeadless;
    private BrowserContext contextIncognitoModeHeadfull;

    public NiLPagePW(Page page, Page pageSmartTv, BrowserContext contextIncognitoModeHeadless) {
        this.page = page;
        this.pageSmartTv = pageSmartTv;
        this.contextIncognitoModeHeadless = contextIncognitoModeHeadless;

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

    public void checkImageBlocksCollectionWidePageNilGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        sleep(3000);
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();


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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");
        sleep(3000);
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvWidePageNilGuest",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.5f)
                        .build());

        // подборки тв каналов:
        ElementHandle blockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");
        ElementHandle titleBlockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionTv);
        List<ElementHandle> collectionTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        for (int i = 0; i < collectionTvChannelAll.size(); i++) {
            collectionTvChannelAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }


        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvWidePageNilGuest",
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

    public void checkImageFooterWidePageGuest() throws IOException, InterruptedException {
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerWidePageNilGuest",
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
        sleep(5000);
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
        // Подборки тв каналов:
        List<ElementHandle> collectionTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        for (int i = 0; i < collectionTvChannelAll.size(); i++) {
            collectionTvChannelAll.get(i).scrollIntoViewIfNeeded();
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
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

        sleep(3000);
        // делаем скриншот полной страницы "NilPageFull":
        vrt.track(
                "NilPageFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.5f)
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
        sleep(5000);
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

        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
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
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
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

    public void checkImageBlocksCollectionWithHeaderUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        sleep(3000);
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();


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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");
        sleep(3000);
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvWidePageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.5f)
                        .build());
    }

    public void checkImageFooterWidePageUser() throws IOException, InterruptedException {
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNilUser":
        vrt.track(
                "footerWidePageNilUser",
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
        sleep(5000);
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
        sleep(5000);
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
        sleep(5000);
        page.reload();
        sleep(3000);
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();

        // подготовка элемента 'blockCollectionWithHeaderPageNil' к скриншот-тесту:
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
        // делаем скриншот части страницы:
        ElementHandle blockCollectionFilmWithoutImages = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");
        sleep(3000);
        vrt.track(
                "BlockCollectionFilmWithoutImagesPageNilGuest",
                Base64.getEncoder().encodeToString(blockCollectionFilmWithoutImages.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkBlockCollectionFilmWithoutImagesUser() throws IOException, InterruptedException {
        ElementHandle alert = page.waitForSelector("//span[text()='Идет загрузка контента...']");
        alert.waitForElementState(ElementState.HIDDEN);
        ElementHandle blockCollectionFilmWithoutImages = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        // подготовка элемента 'blockCollectionWithHeaderPageNil' к скриншот-тесту:

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
        // делаем скриншот blockCollectionFilmWithoutImages:
        vrt.track(
                "BlockCollectionFilmWithoutImagesPageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionFilmWithoutImages.screenshot()),
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
        sleep(5000);
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
        page.waitForSelector("(//div[text()='Все сервисы'])[1]").click();
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
        sleep(5000);
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
        sleep(5000);
        page.querySelector("//img[@alt='Мегафон ТВ']");
        assertTrue(page.querySelector("(//div[text()='Все сервисы'])[1]").isVisible());
        page.querySelector("//button[@class='ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search']");
        page.querySelector("//button[@class='ch-trigger ch-trigger_view_lk ch-account-controller__trigger']");
        page.querySelector("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
    }

    public void checkImageMenuMediumPageNilUser() throws IOException, InterruptedException {
        sleep(5000);
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
        sleep(5000);
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
    }

    public void chooseSearchAndCheckImageWibePageGuest() throws IOException, InterruptedException {
        page.click("//button[@class='ch-trigger ch-trigger_view_ ch-header__trigger ch-header__trigger_type_search']");
        sleep(5000);
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
        sleep(5000);
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
        sleep(5000);
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
        page.click("(//button[contains(@class,'ch-trigger_view_burger')])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        page.click("(//div[text()='Промокод'])[2]");
        sleep(5000);
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
        page.click("(//button[contains(@class,'ch-trigger_view_burger')])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        page.click("(//div[text()='Промокод'])[2]");
        sleep(5000);
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
        page.click("(//button[contains(@class,'ch-trigger_view_burger')])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        ElementHandle searchForm = page.querySelector("//div[@class='ch-mobile-menu__container']");
        page.click("//button[contains(@class,'ch-mobile-menu__trigger_type_search')]");
        sleep(3000);
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
        page.click("//button[contains(@class,'ch-header__trigger_type_search')]");
        sleep(5000);
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
//        page.click("(//div[@class='ch-search__icon']//*[@id='close-search'])[1]");
    }

    public void goToTabsHeaderMenuMftvUser() throws InterruptedException {
        page.click("(//div[text()='ТВ'])[1]");
        sleep(5000);
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
        Assert.assertEquals("https://web-preprod6.megafon.tv/my/favorites", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        page.reload();
    }

    public void choosePromoCodeAndCheckImageMinPageNilUser() throws InterruptedException, IOException {
        page.click("(//button[@class='ch-trigger ch-trigger_view_burger ch-header__trigger ch-header__trigger_type_burger'])[1]");
        page.waitForSelector("//div[@class='ch-mobile-menu__container']");
        page.click("(//div[text()='Промокод'])[2]");
        sleep(5000);

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
        sleep(5000);
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
        sleep(5000);
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
        sleep(5000);
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
        sleep(5000);
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
        sleep(5000);
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
//        page.click("(//div[@class='ch-search__icon']//*[@id='close-search'])[1]");
    }

    public void goToSectionsProfileMenu() throws InterruptedException {
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Акции'])[1]");
        sleep(3000);
        sleep(3000);
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
        sleep(3000);
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Подключить SmartTV'])[1]");
        page.waitForSelector("//h1[text()='Подключить ТВ']");
        Assert.assertEquals("https://web-preprod6.megafon.tv/connect_smart_tv", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        sleep(3000);
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Управление пакетами и сервисами'])[1]");
        page.waitForSelector("(//span[text()='Управление пакетами и сервисами'])[3]");
        Assert.assertEquals("https://web-preprod6.megafon.tv/profile/subscription_management", page.url());
        page.navigate("https://web-preprod6.megafon.tv/");
        sleep(3000);
        page.click("(//button[contains(@class,'ch-account-controller')])[2]");
        page.waitForSelector("(//div[@class='ch-drop-down__popup'])[3]");
        page.click("(//span[text()='Email'])[1]");
        page.waitForSelector("//div[text()='Email']");
        page.waitForSelector("//div[@aria-label='Notification']");
        page.navigate("https://web-preprod6.megafon.tv/");
        sleep(3000);
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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
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
        List<ElementHandle> postersSourceWEBP = page.querySelectorAll("//picture[contains(@class,'BannerCarousel')]//source[@media]");
        for (ElementHandle posterSourceWEBP : postersSourceWEBP) {
            posterSourceWEBP.evaluate("w => w.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster__web-wp.webp')");
        }
        // делаем скриншот элемента "bannersMinPageNilUser":
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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        ElementHandle buttonWatch = page.querySelector("//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        buttonWatch.hover();

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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        ElementHandle buttonFavourite = page.querySelector("//button[contains(@class,'buttonFavourite')]");
        buttonFavourite.hover();

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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        ElementHandle arrowNext = page.querySelector("//button[@aria-label='next']");
        arrowNext.hover();

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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        ElementHandle arrowPrevious = page.querySelector("//button[@aria-label='previous']");
        arrowPrevious.hover();
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
        ElementHandle buttonWatch = page.querySelector("//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        buttonWatch.hover();
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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        ElementHandle buttonFavourite = page.querySelector("//button[contains(@class,'buttonFavourite')]");
        buttonFavourite.hover();
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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        ElementHandle arrowNext = page.querySelector("//button[@aria-label='next']");
        arrowNext.hover();

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
        ElementHandle banners = page.querySelector("//div[contains(@class,'carousel')]");
        ElementHandle arrowPrevious = page.querySelector("//button[@aria-label='previous']");
        arrowPrevious.hover();

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
        if (page.querySelectorAll("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/movies/vods/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickToFavoriteSerialOnBannerGuest() {
        if (page.querySelectorAll("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void checkClickToFavoriteTvProgramOnBannerGuest() {
        if (page.querySelectorAll("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickToFavoriteTvChannelOnBannerGuest() {
        if (page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void checkAddToFavoriteFilmFromBannerUser() throws IOException, InterruptedException, AWTException {
        if (page.querySelectorAll("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/movies/vods/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.mouse().click(200,200, new Mouse.ClickOptions().setButton(MouseButton.RIGHT));
        Robot bot = new Robot();
        bot.mouseMove(200,200);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
        bot.mouseMove(0,0);
        sleep(5000);
        page.click("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        sleep(2000);
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
        if (page.querySelectorAll("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        sleep(2000);
        String nameSerialAdd = page.querySelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size() > 0);
//        System.out.println(page.querySelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]").getAttribute("color"));
//        System.out.println(page.querySelector("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]").getAttribute("background"));

        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameSerialAdd, page.querySelector("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void checkAddToFavoriteTvProgramFromBannerUser() throws InterruptedException {
        if (page.querySelectorAll("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        String nameTvProgramAdd = page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size() > 0);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameTvProgramAdd, page.querySelector("//a[contains(@href,'/programs/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void checkAddToFavoriteTvChannelFromBannerUser() {
        if (page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavourite')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        page.click("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]");
        String nameTvProgramAdd = page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//h2[contains(@class,'BannerCarouselItem_title')]").innerText();
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size() > 0);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameTvProgramAdd, page.querySelector("//a[contains(@href,'/tv/channels/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void checkRemoveToFavoriteFilmFromBannerUser() {
        if (page.querySelectorAll("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size() != 0) {
            while (page.querySelectorAll("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/vods/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size() < 1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/vods/')]//h3[@data-test='PackageDescriptionTitle']").size() < 1);
    }

    public void checkRemoveToFavoriteSerialFromBannerUser() {
        if (page.querySelectorAll("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size() != 0) {
            while (page.querySelectorAll("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/shows/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size() < 1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").size() < 1);
    }

    public void checkRemoveToFavoriteTvProgramFromBannerUser() {
        if (page.querySelectorAll("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size() != 0) {
            while (page.querySelectorAll("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/programs/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size() < 1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/programs/')]//h3[@data-test='PackageDescriptionTitle']").size() < 1);
    }

    public void checkRemoveToFavoriteTvChannelFromBannerUser() {
        if (page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide')]//*[contains(@class,'iconFavouriteActive')]").size() != 0) {
            while (page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        page.click("//a[contains(@href,'/tv/channels/')]/ancestor::li[contains(@class,'carousel__slide--visible')]//*[contains(@class,'iconFavouriteActive')]");
        Assert.assertTrue(page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//button[contains(@class,'buttonFavourite')]//*[contains(@class,'iconFavouriteActive')]").size() < 1);
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/tv/channels/')]//h3[@data-test='PackageDescriptionTitle']").size() < 1);
    }

    public void clickToButtonTrailerFilmOnBanner() {
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/vods/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/vods/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.click("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.waitForSelector("//span[text()='Фильмы']");
        Assert.assertTrue(page.url().contains("/movies/vods/"));
    }

    public void clickToButtonTrailerSerialOnBanner() throws InterruptedException {
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/shows/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.waitForSelector("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.click("//li[contains(@class,'carousel__slide--visible')]//a[contains(@class,'buttonWatch') and text()='Трейлер']");
        page.waitForSelector("//span[text()='Сериалы']");
        Assert.assertTrue(page.url().contains("/shows/"));
    }

    public void clickToButtonTrailerTvProgramOnBanner() {
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/programs/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size() < 1) {
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
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/tv/channels/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size() != 0) {
            page.click("//button[@aria-label='next']");
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size() < 1) {
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
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/vods/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/vods/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.click("//div[contains(@class,'BannerCarouselItem_bannerWrap')]//a[contains(@href,'/vods/')]");
        page.waitForSelector("//span[text()='Фильмы']");
        Assert.assertTrue(page.url().contains("/movies/vods/"));
    }

    public void clickOnBannerSerial() {
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/shows/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/shows/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.click("//div[contains(@class,'BannerCarouselItem_bannerWrap')]//a[contains(@href,'/shows/')]");
        page.waitForSelector("//span[text()='Сериалы']");
        Assert.assertTrue(page.url().contains("/shows/"));

    }

    public void clickOnBannerTvProgram() {
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/programs/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/programs/')]").size() < 1) {
                page.click("//button[@aria-label='next']");
            }
        }
        page.click("//div[contains(@class,'BannerCarouselItem_bannerWrap')]//a[contains(@href,'/programs/')]");
        page.waitForSelector("//span[text()='ТВ']");
        Assert.assertTrue(page.url().contains("/programs/"));
        page.waitForSelector("//div[contains(@style,'background-image: url')]");
    }

    public void clickOnBannerTvChannel() {
        if (page.querySelectorAll("//li[contains(@class,'carousel__slide')]//a[contains(@href,'/tv/channels/')]").size() != 0) {
            while (page.querySelectorAll("//li[contains(@class,'carousel__slide--visible')]//a[contains(@href,'/tv/channels/')]").size() < 1) {
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
        sleep(5000);
        List<ElementHandle> collectionAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]");
        List<ElementHandle> titleCollectionFilmsOrSerialsOrTvProgramAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        Assert.assertEquals(collectionAll.size(), titleCollectionFilmsOrSerialsOrTvProgramAll.size());
        List<ElementHandle> arrowsPreviousAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//button[@aria-label='show previous content']");
        Assert.assertEquals(arrowsPreviousAll.size(), collectionAll.size());
        List<ElementHandle> arrowsNextAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//button[@aria-label='show next content']");
        Assert.assertEquals(arrowsNextAll.size(), collectionAll.size());
        page.querySelector("//section[contains(@class,'HomePage_collection')]");
        List<ElementHandle> tailAllExceptTvAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//a[@href and contains(@class,'TilePackageCommon_tile')]");
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        sleep(3000);
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
//        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        sleep(5000);
        for (ElementHandle tailAllExceptTv : tailAllExceptTvAll) {
            tailAllExceptTv.scrollIntoViewIfNeeded();
            tailAllExceptTv.waitForSelector("//picture[contains(@class,'TilePackageCommon_image')]");
            Assert.assertEquals(1, tailAllExceptTv.querySelectorAll("//picture[contains(@class,'TilePackageCommon_image')]").size());
        }
    }

    public void checkImageBlocksCollectionMinPageNilGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }

        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvMinPageNilGuest",
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
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }

        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvMinPageNilGuest",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionMediumPageNilGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");


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

            List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle posterPackage : posterPackageAll) {
                posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
            }
        }


        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvMediumPageNilGuest",
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
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }


        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvMediumPageNilGuest",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionMinPageNilUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }

        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvMinPageNilUser",
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
        ElementHandle collectionTvChannel = page.querySelector("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        collectionTvChannel.scrollIntoViewIfNeeded();
        List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
        for (ElementHandle posterTvChannel : posterTvChannelAll) {
            posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
        }

        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvMinPageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionMediumPageNilUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }

        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvMediumPageNilUser",
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
        ElementHandle collectionTvChannel = page.querySelector("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        collectionTvChannel.scrollIntoViewIfNeeded();
        List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
        for (ElementHandle posterTvChannel : posterTvChannelAll) {
            posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
        }

        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvMediumPageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksCollectionWidePageNilUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        sleep(3000);
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }

        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "blockCollectionExceptTvWidePageNilUser",
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
            List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
            for (ElementHandle posterTvChannel : posterTvChannelAll) {
                posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
            }
        }


        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvWidePageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkHoverArrowPreviousCollectionPageNilGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]//button[@aria-label='show previous content']").hover();
        sleep(2000);
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "hoverArrowPreviousCollectionPageNilGuest",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.001f)
                        .build());
    }

    public void checkHoverArrowPreviousCollectionPageNilUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]//button[@aria-label='show previous content']").hover();
        sleep(2000);
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "hoverArrowPreviousCollectionPageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.001f)
                        .build());
    }

    public void checkHoverArrowNextCollectionPageNilGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]//button[@aria-label='show next content']").hover();
        sleep(2000);
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "hoverArrowNextCollectionPageNilGuest",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.001f)
                        .build());
    }

    public void checkHoverArrowNextCollectionPageNilUser() throws IOException, InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        // подборки фильмы/сериалы/пакеты/mixedEST коллекции:
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]").scrollIntoViewIfNeeded();
        ElementHandle blockCollectionExceptTv = page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]");

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
        List<ElementHandle> posterPackageAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle posterPackage : posterPackageAll) {
            posterPackage.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        }
        page.querySelector("(//section[contains(@class,'HomePage_collection')])[1]//button[@aria-label='show next content']").hover();
        sleep(2000);
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "hoverArrowNextCollectionPageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionExceptTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.1f)
                        .build());
    }

    public void checkScrollCollection() {
        page.querySelector("((//section[contains(@class,'HomePage_collection')])[1]//div[contains(@class,'TilePackageCommon')])[1]");
        List<ElementHandle> tileAll = page.querySelectorAll("(//section[contains(@class,'HomePage_collection')])[1]//div[contains(@class,'TilePackageCommon')]");
        for (ElementHandle tile : tileAll) {
            tile.hover();
            if (page.querySelectorAll("//span[contains(@class,'MediaScroller_lastChild')]//div[contains(@class,'TileOverlay')]").size() > 0) {
                Assert.assertTrue("bug: arrow next not disabled", page.waitForSelector("(//section[contains(@class,'HomePage_collection')])[1]//button[@aria-label='show next content']").isDisabled());
                break;
            }
            page.click("(//section[contains(@class,'HomePage_collection')])[1]//button[@aria-label='show next content']");
        }
    }

    public void checkElementsTileFilmFromCollection() throws InterruptedException {
        sleep(5000);
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/movies/vods/')][1]").scrollIntoViewIfNeeded();
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/movies/vods/')][1]//picture[contains(@class,'TilePackageCommon_image')]");
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_desc')]");
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
    }

    public void checkImageHoverOnTileFilmFromCollectionGust() throws IOException, InterruptedException {
        ElementHandle tileFilm = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]");
        tileFilm.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverFilm = page.querySelector("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverFilm = page.querySelector("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverFilm.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle poster : posterAll) {
            poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> nameFilmAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle nameFilm : nameFilmAll) {
            nameFilm.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("d => d.textContent='18+'");
        }
        List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionPackage : descriptionTextTileAll) {
            descriptionPackage.evaluate("t => t.innerText='Текст описания'");
        }
        tileFilm.hover();
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("(//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/movies/vods/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        sleep(2000);
        // подготовка контролов при ховере:
        ElementHandle duration = page.waitForSelector("//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'duration')]");
        duration.evaluate("d => d.innerText='100 мин.'");
        ElementHandle meta = page.waitForSelector("//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'meta')]");
        meta.evaluate("m => m.innerText='IMDb 7.7'");
        sleep(2000);
        tileFilm.hover();
        vrt.track(
                "HoverOnTileFilmFromCollectionGuest",
                Base64.getEncoder().encodeToString(collectionHoverFilm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageHoverOnTileFilmFromCollectionUser() throws IOException, InterruptedException {
        ElementHandle tileFilm = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]");
        tileFilm.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverFilm = page.querySelector("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverFilm = page.querySelector("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverFilm.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle poster : posterAll) {
            poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> nameFilmAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle nameTvProgram : nameFilmAll) {
            nameTvProgram.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("d => d.textContent='18+'");
        }
        List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionTextPackage : descriptionTextTileAll) {
            descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
        }
        tileFilm.hover();
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("(//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/movies/vods/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        sleep(2000);
        // подготовка контролов при ховере:
        ElementHandle duration = page.waitForSelector("//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'duration')]");
        duration.evaluate("d => d.innerText='100 мин.'");
        ElementHandle meta = page.waitForSelector("//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'meta')]");
        meta.evaluate("m => m.innerText='IMDb 7.7'");
        sleep(2000);
        tileFilm.hover();
        vrt.track(
                "HoverOnTileFilmFromCollectionUser",
                Base64.getEncoder().encodeToString(collectionHoverFilm.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsTileSerialFromCollection() throws InterruptedException {
        sleep(5000);
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/')][1]").scrollIntoViewIfNeeded();
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/')][1]//picture[contains(@class,'TilePackageCommon_image')]");
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_desc')]");
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
    }

    public void checkImageHoverOnTileSerialFromCollectionGust() throws InterruptedException, IOException {
        ElementHandle tileSerial = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]");
        tileSerial.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverSerial = page.querySelector("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverSerial = page.querySelector("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverSerial.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle poster : posterAll) {
            poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> nameSerialAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle nameSerial : nameSerialAll) {
            nameSerial.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("d => d.textContent='18+'");
        }
        List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionText : descriptionTextTileAll) {
            descriptionText.evaluate("t => t.innerText='Текст описания'");
        }
        tileSerial.hover();
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("(//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        sleep(2000);
        // подготовка контролов при ховере:
        ElementHandle meta = page.waitForSelector("//a[contains(@href, '/shows/')][1]//span[contains(@class,'TileOverlay_meta')]");
        meta.evaluate("m => m.innerText='IMDb 7.7'");
        ElementHandle seasonsCount = page.waitForSelector("//a[contains(@href, '/shows/')][1]//span[contains(@class,'seasonsCount')]");
        seasonsCount.evaluate("m => m.innerText='1 сезон'");
        tileSerial.hover();
        sleep(2000);
        vrt.track(
                "HoverOnTileSerialFromCollectionGuest",
                Base64.getEncoder().encodeToString(collectionHoverSerial.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageHoverOnTileSerialFromCollectionUser() throws InterruptedException, IOException {
        ElementHandle tileSerial = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]");
        tileSerial.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverSerial = page.querySelector("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverSerial = page.querySelector("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverSerial.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle poster : posterAll) {
            poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> nameSerialAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle nameSerial : nameSerialAll) {
            nameSerial.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("d => d.textContent='18+'");
        }
        List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionText : descriptionTextTileAll) {
            descriptionText.evaluate("t => t.innerText='Текст описания'");
        }
        tileSerial.hover();
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("(//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
        sleep(2000);
        // подготовка контролов при ховере:
        ElementHandle meta = page.waitForSelector("//a[contains(@href, '/shows/')][1]//span[contains(@class,'TileOverlay_meta')]");
        meta.evaluate("m => m.innerText='IMDb 7.7'");
        ElementHandle seasonsCount = page.waitForSelector("//a[contains(@href, '/shows/')][1]//span[contains(@class,'seasonsCount')]");
        seasonsCount.evaluate("m => m.innerText='1 сезон'");
        tileSerial.hover();
        sleep(2000);
        vrt.track(
                "HoverOnTileSerialFromCollectionUser",
                Base64.getEncoder().encodeToString(collectionHoverSerial.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsTileTvProgramInAirFromCollection() throws InterruptedException {
        sleep(5000);
        if (page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']").size() != 0) {
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]").scrollIntoViewIfNeeded();
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//picture[contains(@class,'TilePackageCommon_image')]");
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_title')]");
            page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']");
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        } else {
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]").scrollIntoViewIfNeeded();
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//picture[contains(@class,'TilePackageCommon_image')]");
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_title')]");
            page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]");
            page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        }
    }

    public void checkImageHoverOnTileTvProgramInAirFromCollectionGust() throws IOException, InterruptedException {
        if (page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]").size() != 0) {
            ElementHandle tileTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
            tileTvProgram.scrollIntoViewIfNeeded();
            ElementHandle collectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]");
            ElementHandle titleCollectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
            titleCollectionHoverTvProgram.evaluate("t => t.innerText='Название подборки'");
            List<ElementHandle> posterAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle poster : posterAll) {
                poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
            List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
            for (ElementHandle nameTvProgram : nameTvProgramAll) {
                nameTvProgram.evaluate("t => t.innerText='Название контента'");
            }
            List<ElementHandle> ageAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
            for (ElementHandle age : ageAll) {
                age.evaluate("d => d.textContent='18+'");
            }
            List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
            for (ElementHandle descriptionTextPackage : descriptionTextTileAll) {
                descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
            }
            tileTvProgram.hover();
            sleep(2000);
            // подготовка выделенного тайла:
            ElementHandle posterHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
            ElementHandle descriptionHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_desc')]");
            descriptionHoverTile.evaluate("t => t.innerText='В эфире'");
            sleep(2000);
            // подготовка контролов при ховере:
            ElementHandle progressText = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
            progressText.evaluate("pT => pT.innerText='Осталось 10 мин.'");
            ElementHandle progressBar = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
            progressBar.evaluate("pB => pB.setAttribute('style', 'width: 50.00%;')");
            sleep(2000);
            tileTvProgram.hover();
            vrt.track(
                    "HoverOnTileTvProgramInAirFromCollectionGuest",
                    Base64.getEncoder().encodeToString(collectionHoverTvProgram.screenshot()),
                    TestRunOptions.builder()
                            .device("Acer")
                            .os("Win10 Pro")
                            .browser("Chrome")
                            .diffTollerancePercent(0.3f)
                            .build());
        } else {
            ElementHandle tileTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
            tileTvProgram.scrollIntoViewIfNeeded();
            ElementHandle collectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]");
            ElementHandle titleCollectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
            titleCollectionHoverTvProgram.evaluate("t => t.innerText='Название подборки'");
            List<ElementHandle> posterAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle poster : posterAll) {
                poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
            List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
            for (ElementHandle nameTvProgram : nameTvProgramAll) {
                nameTvProgram.evaluate("t => t.innerText='Название контента'");
            }
            List<ElementHandle> ageAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
            for (ElementHandle age : ageAll) {
                age.evaluate("d => d.textContent='18+'");
            }
            List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
            for (ElementHandle descriptionTextPackage : descriptionTextTileAll) {
                descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
            }
            tileTvProgram.hover();
            sleep(2000);
            // подготовка выделенного тайла:
            ElementHandle posterHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
            ElementHandle descriptionHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_desc')]");
            descriptionHoverTile.evaluate("t => t.innerText='Сегодня в 12:00'");
            // подготовка контролов при ховере:
            ElementHandle progressText = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='Сегодня в 12:00']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
            progressText.evaluate("pT => pT.innerText='Осталось 10 мин.'");
            ElementHandle progressBar = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='Сегодня в 12:00']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
            progressBar.evaluate("pB => pB.setAttribute('style', 'width: 50.00%;')");
            sleep(2000);
            tileTvProgram.hover();
            vrt.track(
                    "HoverOnTileTvProgramTodayFromCollectionGuest",
                    Base64.getEncoder().encodeToString(collectionHoverTvProgram.screenshot()),
                    TestRunOptions.builder()
                            .device("Acer")
                            .os("Win10 Pro")
                            .browser("Chrome")
                            .diffTollerancePercent(0.3f)
                            .build());
        }
    }

    public void checkImageHoverOnTileTvProgramInAirFromCollectionUser() throws IOException, InterruptedException {
        if (page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]").size() != 0) {
            ElementHandle tileTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
            tileTvProgram.scrollIntoViewIfNeeded();
            ElementHandle collectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]");
            ElementHandle titleCollectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
            titleCollectionHoverTvProgram.evaluate("t => t.innerText='Название подборки'");
            List<ElementHandle> posterAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle poster : posterAll) {
                poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
            List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
            for (ElementHandle nameTvProgram : nameTvProgramAll) {
                nameTvProgram.evaluate("t => t.innerText='Название контента'");
            }
            List<ElementHandle> ageAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
            for (ElementHandle age : ageAll) {
                age.evaluate("d => d.textContent='18+'");
            }
            List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
            for (ElementHandle descriptionTextPackage : descriptionTextTileAll) {
                descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
            }
            tileTvProgram.hover();
            sleep(2000);
            // подготовка выделенного тайла:
            ElementHandle posterHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
            ElementHandle descriptionHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_desc')]");
            descriptionHoverTile.evaluate("t => t.innerText='В эфире'");
            sleep(2000);
            // подготовка контролов при ховере:
            ElementHandle progressText = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
            progressText.evaluate("pT => pT.innerText='Осталось 10 мин.'");
            ElementHandle progressBar = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='В эфире']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
            progressBar.evaluate("pB => pB.setAttribute('style', 'width: 50.00%;')");
            sleep(2000);
            tileTvProgram.hover();
            vrt.track(
                    "HoverOnTileTvProgramInAirFromCollectionUser",
                    Base64.getEncoder().encodeToString(collectionHoverTvProgram.screenshot()),
                    TestRunOptions.builder()
                            .device("Acer")
                            .os("Win10 Pro")
                            .browser("Chrome")
                            .diffTollerancePercent(0.3f)
                            .build());
        } else {
            ElementHandle tileTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
            tileTvProgram.scrollIntoViewIfNeeded();
            ElementHandle collectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]");
            ElementHandle titleCollectionHoverTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
            titleCollectionHoverTvProgram.evaluate("t => t.innerText='Название подборки'");
            List<ElementHandle> posterAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            for (ElementHandle poster : posterAll) {
                poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
            }
            List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
            for (ElementHandle nameTvProgram : nameTvProgramAll) {
                nameTvProgram.evaluate("t => t.innerText='Название контента'");
            }
            List<ElementHandle> ageAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
            for (ElementHandle age : ageAll) {
                age.evaluate("d => d.textContent='18+'");
            }
            List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
            for (ElementHandle descriptionTextPackage : descriptionTextTileAll) {
                descriptionTextPackage.evaluate("t => t.innerText='Текст описания'");
            }
            tileTvProgram.hover();
            sleep(2000);
            // подготовка выделенного тайла:
            ElementHandle posterHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
            posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");
            ElementHandle descriptionHoverTile = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_desc')]");
            descriptionHoverTile.evaluate("t => t.innerText='Сегодня в 12:00'");
            // подготовка контролов при ховере:
            ElementHandle progressText = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='Сегодня в 12:00']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
            progressText.evaluate("pT => pT.innerText='Осталось 10 мин.'");
            ElementHandle progressBar = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and text()='Сегодня в 12:00']/ancestor::section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
            progressBar.evaluate("pB => pB.setAttribute('style', 'width: 50.00%;')");
            sleep(2000);
            tileTvProgram.hover();
            vrt.track(
                    "HoverOnTileTvProgramTodayFromCollectionUser",
                    Base64.getEncoder().encodeToString(collectionHoverTvProgram.screenshot()),
                    TestRunOptions.builder()
                            .device("Acer")
                            .os("Win10 Pro")
                            .browser("Chrome")
                            .diffTollerancePercent(0.3f)
                            .build());
        }
    }

    public void checkElementsTileTvProgramTodayFromCollection() throws InterruptedException {
        sleep(5000);
        page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]").scrollIntoViewIfNeeded();
        page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//picture[contains(@class,'TilePackageCommon_image')]");
        page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_title')]");
        page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]");
        page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
    }

    public void checkImageHoverOnTileTvProgramTodayFromCollectionGust() throws InterruptedException, IOException {
        ElementHandle tileTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
        tileTvProgram.scrollIntoViewIfNeeded();
        ElementHandle poster = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
        ElementHandle nameTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_title')]");
        nameTvProgram.evaluate("t => t.innerText='Название контента'");
        ElementHandle age = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        age.evaluate("d => d.textContent='18+'");
        tileTvProgram.hover();
//        Thread.sleep(2000);
//        ElementHandle progressText = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'progressText')]");
//        progressText.evaluate("pT => pT.innerText='Осталось 10 мин.'");
//        ElementHandle progressBar = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'progressBar')]");
//        progressBar.evaluate("pB => pB.setAttribute('style', 'width: 50.00%;')");
        sleep(2000);
        tileTvProgram.hover();
        sleep(5000);
        vrt.track(
                "HoverOnTileTvProgramTodayFromCollectionGuest",
                Base64.getEncoder().encodeToString(tileTvProgram.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageHoverOnTileTvProgramTodayFromCollectionUser() throws IOException, InterruptedException {
        ElementHandle tileTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
        tileTvProgram.scrollIntoViewIfNeeded();
        ElementHandle poster = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//picture[contains(@class,'TilePackageCommon_image')]//source");
        poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/10/d9/18a8c62344729e872bd4a63df7e3cd7e6fdf/tile__atablet-xhdpi.webp')");
        ElementHandle nameTvProgram = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'TilePackageCommon_title')]");
        nameTvProgram.evaluate("t => t.innerText='Название контента'");
        ElementHandle age = page.querySelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        age.evaluate("d => d.textContent='18+'");
        tileTvProgram.hover();
//        Thread.sleep(2000);
//        ElementHandle progressText = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'progressText')]");
//        progressText.evaluate("pT => pT.innerText='Осталось 10 мин.'");
//        ElementHandle progressBar = page.waitForSelector("//span[contains(@class,'TilePackageCommon_desc') and contains(text(),'Сегодня')]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]//span[contains(@class,'progressBar')]");
//        progressBar.evaluate("pB => pB.setAttribute('style', 'width: 50.00%;')");
        sleep(2000);
        tileTvProgram.hover();
        sleep(5000);
        vrt.track(
                "HoverOnTileTvProgramTodayFromCollectionUser",
                Base64.getEncoder().encodeToString(tileTvProgram.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkLastTilePackageTvChannel() throws InterruptedException {
        sleep(3000);
        page.querySelector("//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]").scrollIntoViewIfNeeded();
        List<ElementHandle> tileAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/tv/channels/') and contains(@class,'TileChannelPackage')]");
        ElementHandle lastTile = page.querySelector("(//div[contains(@class,'TileChannelPackage')]/ancestor::section//span[contains(@class,'MediaScroller_lastChild')])[1]");
        for (ElementHandle tile : tileAll) {
            if (page.querySelectorAll("(//div[contains(@class,'TileChannelPackage')]/ancestor::section//span[contains(@class,'MediaScroller_lastChild')])[1]//a[contains(@href,'/mixed_groups/')]").size() > 0) {
                Assert.assertTrue("bug: there is no package TV channels", page.querySelectorAll("(//div[contains(@class,'TileChannelPackage')]/ancestor::section//span[contains(@class,'MediaScroller_lastChild')])[1]//a[contains(@href,'/mixed_groups/')]").size() > 0);
                Assert.assertTrue("bug: there is no package TV channels", page.querySelectorAll("(//div[contains(@class,'TileChannelPackage')]/ancestor::section//span[contains(@class,'MediaScroller_lastChild')])[1]//span[contains(@class,'desc') and contains(text(),'канал')]").size() > 0);
                break;
            }
            page.click("(//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//button[@aria-label='show next content'])[1]");
            sleep(7000);
        }
    }

    public void checkImageHoverTileTVChannelCollectionGust() throws InterruptedException, IOException {
        ElementHandle tileTvChannel = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//img)[1]");
        tileTvChannel.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverTvChannel = page.querySelector("//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverTvChannel = page.querySelector("//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverTvChannel.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
        for (ElementHandle posterTvChannel : posterTvChannelAll) {
            posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
        }
        tileTvChannel.hover();
        Assert.assertTrue("bug: no favorite button on TV channel tile hover", page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//button[contains(@class,'favouriteButton')]").size() > 0);
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'http://static.cdn.megafon.tv/images/Channel/f5/34/a2dc41fd5f908e47b0e915bd6fb4d0bbf795/logo_tile__web-wp.png')");
        sleep(2000);
        tileTvChannel.hover();
        vrt.track(
                "HoverOnTileTvChannelCollectionGuest",
                Base64.getEncoder().encodeToString(collectionHoverTvChannel.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageHoverTileTVChannelCollectionUser() throws IOException, InterruptedException {
        ElementHandle tileTvChannel = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//img)[1]");
        tileTvChannel.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverTvChannel = page.querySelector("//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverTvChannel = page.querySelector("//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverTvChannel.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
        for (ElementHandle posterTvChannel : posterTvChannelAll) {
            posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
        }
        tileTvChannel.hover();
        Assert.assertTrue("bug: no favorite button on TV channel tile hover", page.querySelectorAll("//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//button[contains(@class,'favouriteButton')]").size() > 0);
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'http://static.cdn.megafon.tv/images/Channel/f5/34/a2dc41fd5f908e47b0e915bd6fb4d0bbf795/logo_tile__web-wp.png')");
        sleep(2000);
        tileTvChannel.hover();
        vrt.track(
                "HoverOnTileTvChannelCollectionUser",
                Base64.getEncoder().encodeToString(collectionHoverTvChannel.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsCollectionPackages() throws InterruptedException {
        sleep(5000);
        List<ElementHandle> collectionPackagesAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]/ancestor::section[contains(@class,'HomePage_collection')]//a//h2[contains(@class,'MediaScroller_title')]");
        List<ElementHandle> titleCollectionPackagesAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        Assert.assertEquals(titleCollectionPackagesAll.size(), collectionPackagesAll.size());
        List<ElementHandle> arrowsPreviousAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]/ancestor::section[contains(@class,'HomePage_collection')]//button[@aria-label='show previous content']");
        Assert.assertEquals(arrowsPreviousAll.size(), collectionPackagesAll.size());
        List<ElementHandle> arrowsNextAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/')]/ancestor::section[contains(@class,'HomePage_collection')]//button[@aria-label='show next content']");
        Assert.assertEquals(arrowsNextAll.size(), collectionPackagesAll.size());

        List<ElementHandle> tailPackageAll = page.querySelectorAll("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/mixed_groups/') and contains(@class,'TilePackageCommon_tile')]");
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        sleep(3000);
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");

        sleep(5000);
        for (ElementHandle tailPackage : tailPackageAll) {
            tailPackage.scrollIntoViewIfNeeded();
            tailPackage.waitForSelector("//picture[contains(@class,'TilePackageCommon_image')]");
            Assert.assertEquals(1, tailPackage.querySelectorAll("//picture[contains(@class,'TilePackageCommon_image')]").size());
        }
    }

    public void checkHoverOnTilePackageCollectionGuest() throws IOException, InterruptedException {
        ElementHandle tilePackage = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]");
        tilePackage.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverPackage = page.querySelector("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverPackage = page.querySelector("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverPackage.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle poster : posterAll) {
            poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/MixedEst/ac/06/de807ef0bbe1f5dfd169144f19085474f890/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> namePackageAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle namePackage : namePackageAll) {
            namePackage.evaluate("t => t.innerText='Название пакета'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("d => d.textContent='18+'");
        }
        List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionText : descriptionTextTileAll) {
            descriptionText.evaluate("t => t.innerText='Текст описания'");
        }
        tilePackage.hover();
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/MixedEst/b1/68/ff9239391af64d5e7844e9fdac44cacce0bb/tile__atablet-xhdpi.webp')");
        sleep(2000);
        tilePackage.hover();
        vrt.track(
                "HoverOnTilePackageCollectionGuest",
                Base64.getEncoder().encodeToString(collectionHoverPackage.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkHoverOnTilePackageCollectionUser() throws IOException, InterruptedException {
        ElementHandle tilePackage = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]");
        tilePackage.scrollIntoViewIfNeeded();
        ElementHandle collectionHoverPackage = page.querySelector("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]");
        ElementHandle titleCollectionHoverPackage = page.querySelector("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')]");
        titleCollectionHoverPackage.evaluate("t => t.innerText='Название подборки'");
        List<ElementHandle> posterAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        for (ElementHandle poster : posterAll) {
            poster.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/MixedEst/ac/06/de807ef0bbe1f5dfd169144f19085474f890/tile__atablet-xhdpi.webp')");
        }
        List<ElementHandle> namePackageAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
        for (ElementHandle namePackage : namePackageAll) {
            namePackage.evaluate("t => t.innerText='Название пакета'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("d => d.textContent='18+'");
        }
        List<ElementHandle> descriptionTextTileAll = page.querySelectorAll("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')][1]/ancestor::section[contains(@class,'HomePage_collection')]//span[contains(@class,'TilePackageCommon_desc')]");
        for (ElementHandle descriptionText : descriptionTextTileAll) {
            descriptionText.evaluate("t => t.innerText='Текст описания'");
        }
        tilePackage.hover();
        sleep(2000);
        // подготовка выделенного тайла:
        ElementHandle posterHoverTile = page.querySelector("//a[contains(@href, '/mixed_groups/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/MixedEst/b1/68/ff9239391af64d5e7844e9fdac44cacce0bb/tile__atablet-xhdpi.webp')");
        sleep(2000);
        tilePackage.hover();
        vrt.track(
                "HoverOnTilePackageCollectionUser",
                Base64.getEncoder().encodeToString(collectionHoverPackage.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsCollectionInCollection() {
        // нет картинок в тайлах подборок в подбороке
        List<ElementHandle> tilesCinCall = page.querySelectorAll("//section//div[contains(@class,'TileTriple_children')]");
        List<ElementHandle> tilesCinCposterAll = page.querySelectorAll("//section//div[contains(@class,'TileTriple_children')]//source");
        Assert.assertEquals("bug: no poster on tile collection in collection", tilesCinCall.size(), tilesCinCposterAll.size());
    }

    public void clickOnButtonFavoriteFilmCollectionGuest() {
        ElementHandle tileFilm = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/vods/') and contains(@class,'TilePackageCommon')][1]");
        tileFilm.hover();
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickOnButtonFavoriteSerialCollectionGuest() {
        ElementHandle tileSerial = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')][1]");
        tileSerial.hover();
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickOnButtonFavoriteTvProgramCollectionGuest() {
        ElementHandle tileTvProgram = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
        tileTvProgram.hover();
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickOnButtonFavoriteTvChannelCollectionGuest() {
        ElementHandle tileTvChannel = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/tv/channels/') and contains(@class, 'TileChannelPackage')][1]");
        tileTvChannel.hover();
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void clickOnButtonFavoriteAndCheckAddFavoriteFilm() throws IOException, InterruptedException {
        sleep(2000);
        ElementHandle alert = page.waitForSelector("//span[text()='Подбираем контент для вас']");
        alert.waitForElementState(ElementState.HIDDEN);
        page.reload();
        ElementHandle tileFilm = page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/movies/vods/')][1]");
        ElementHandle tileFilmName = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        String nameFilmAdd = tileFilmName.innerText();
        tileFilm.hover();
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//button//*[contains(@class,'iconFavouriteActive')]");
        // подготовка тайла в фокусе
        ElementHandle posterHoverTile = page.querySelector("(//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/movies/vods/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");

        ElementHandle nameFilm = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/movies/vods/')]//span[contains(@class,'TilePackageCommon_title')]");
        nameFilm.evaluate("t => t.innerText='Название контента'");

        ElementHandle age = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/movies/vods/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        age.evaluate("d => d.textContent='18+'");

        ElementHandle tileFocus = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href,'/movies/vods/')]");
        ElementHandle descriptionTextTile = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/movies/vods/')]//span[contains(@class,'TilePackageCommon_desc')]");
        descriptionTextTile.evaluate("t => t.innerText='Текст описания'");
        sleep(2000);
        // подготовка контролов при ховере:
        ElementHandle duration = page.waitForSelector("//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TileOverlay_duration')]");
        duration.evaluate("d => d.innerText='100 мин.'");
        ElementHandle meta = page.waitForSelector("//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TileOverlay_meta')]");
        meta.evaluate("m => m.innerText='IMDb 7.7'");
        sleep(2000);
        tileFilm.hover();
        vrt.track(
                "ActiveFavoriteOnTileFilmFromCollectionUser",
                Base64.getEncoder().encodeToString(tileFocus.screenshot()),
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

    public void clickOnButtonFavoriteAndCheckAddFavoriteSerial() throws IOException, InterruptedException {
        ElementHandle tileSerial = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/')][1]");
        ElementHandle tileSerialName = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/shows/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        String nameSerialAdd = tileSerialName.innerText();
        tileSerial.hover();
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//button//*[contains(@class,'iconFavouriteActive')]");
        // подготовка тайла в фокусе
        ElementHandle posterHoverTile = page.querySelector("(//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/shows/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");

        ElementHandle nameSerial = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/shows/')]//span[contains(@class,'TilePackageCommon_title')]");
        nameSerial.evaluate("t => t.innerText='Название контента'");

        ElementHandle age = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/shows/')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        age.evaluate("d => d.textContent='18+'");

        ElementHandle tileFocus = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href,'/shows/')]");
        ElementHandle descriptionTextTile = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/shows/')]//span[contains(@class,'TilePackageCommon_desc')]");
        descriptionTextTile.evaluate("t => t.innerText='Текст описания'");
        sleep(2000);
        // подготовка контролов при ховере:
        ElementHandle meta = page.waitForSelector("//a[contains(@href, '/shows/')][1]//span[contains(@class,'TileOverlay_meta')]");
        meta.evaluate("m => m.innerText='IMDb 7.7'");
        sleep(2000);
        tileSerial.hover();
        vrt.track(
                "ActiveFavoriteOnTileSerialFromCollectionUser",
                Base64.getEncoder().encodeToString(tileFocus.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameSerialAdd, page.querySelector("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void clickOnButtonFavoriteAndCheckAddFavoriteTvProgram() throws IOException, InterruptedException {
        page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]").click();
        ElementHandle nameTvChannel = page.waitForSelector("//a[contains(@href,'/tv/channels/')]");
        String nameTvChannelAdd = nameTvChannel.innerText();
        page.navigate("https://web-preprod6.megafon.tv/");
        ElementHandle tileTvProgram = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')][1]");
        tileTvProgram.hover();
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//button//*[contains(@class,'iconFavouriteActive')]");
        // подготовка тайла в фокусе
        ElementHandle posterHoverTile = page.querySelector("(//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href, '/programs/') and contains(@class,'TilePackageCommon')]//picture[contains(@class,'TilePackageCommon_image')]//source)[1]");
        posterHoverTile.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Film/c0/12/68f976743175856b512dbe2f8d0412ab4dd6/tile__atablet-xhdpi.webp')");

        ElementHandle nameTvProgram = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/programs/') and contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_title')]");
        nameTvProgram.evaluate("t => t.innerText='Название контента'");

        ElementHandle age = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/programs/') and contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        age.evaluate("d => d.textContent='18+'");

        ElementHandle tileFocus = page.querySelector("//div[contains(@class,'TileOverlay')]/ancestor::a[contains(@href,'/programs/')]");
        ElementHandle descriptionTextTile = page.querySelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href,'/programs/') and contains(@class,'TilePackageCommon')]//span[contains(@class,'TilePackageCommon_desc')]");
        descriptionTextTile.evaluate("t => t.innerText='Текст описания'");
        sleep(2000);
        // подготовка контролов при ховере:
        ElementHandle progressText = page.waitForSelector("//section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
        progressText.evaluate("pT => pT.innerText='Осталось 10 мин.'");
        ElementHandle progressBar = page.waitForSelector("//section[contains(@class,'HomePage_collection')]//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
        progressBar.evaluate("pB => pB.setAttribute('style', 'width: 50.00%;')");
        sleep(2000);
        tileTvProgram.hover();
        vrt.track(
                "ActiveFavoriteOnTileTvProgramFromCollectionUser",
                Base64.getEncoder().encodeToString(tileFocus.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        // проверка добавления фильма в избранное:
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertEquals(nameTvChannelAdd, page.querySelector("//a[contains(@href,'/tv/channels/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void checkRemoveToFavoriteFilmFromCollection() throws InterruptedException {
        ElementHandle tileFilm = page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/movies/vods/')][1]");
        tileFilm.hover();
        Assert.assertTrue("bug: not active icon favorite", page.querySelector("//button//*[contains(@class,'iconFavouriteActive')]").isVisible());
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//button//*[contains(@class,'iconFavourite')]");
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/vods/')]//h3[@data-test='PackageDescriptionTitle']").size() < 1);
    }

    public void checkRemoveToFavoriteSerialFromCollection() {
        ElementHandle tileSerial = page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/shows/')][1]");
        tileSerial.hover();
        Assert.assertTrue("bug: not active icon favorite", page.querySelector("//button//*[contains(@class,'iconFavouriteActive')]").isVisible());
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//button[contains(@class,'buttonNoFocus')]//*[contains(@class,'iconFavourite')]");
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").size() < 1);
    }

    public void checkRemoveToFavoriteTvProgramFromCollection() {
        ElementHandle tileTvProgram = page.waitForSelector("//section[contains(@class,'HomePage_collection')]//a[contains(@href, '/programs/')][1]");
        tileTvProgram.hover();
        Assert.assertTrue("bug: not active icon favorite", page.querySelector("//button//*[contains(@class,'iconFavouriteActive')]").isVisible());
        page.click("//button[contains(@class,'buttonFavorite')]");
        page.waitForSelector("//button[contains(@class,'buttonNoFocus')]//*[contains(@class,'iconFavourite')]");
        page.navigate("https://web-preprod6.megafon.tv/my/favorites");
        Assert.assertTrue(page.querySelectorAll("//a[contains(@href,'/channels/')]//h3[@data-test='PackageDescriptionTitle']").size() < 1);
    }

    public void checkImageBlockCollectHistoryWatchOnNilPage() throws IOException, InterruptedException {
        pageHeadfull.navigate("https://web-preprod6.megafon.tv/");
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
            pageHeadfull.evaluate("t => t.innerText='Название контента'", titlePackageAll.get(i));
            descriptionTextPackageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span");
            pageHeadfull.evaluate("d => d.textContent='Description'", descriptionTextPackageAll.get(i));
            ageAll = pageHeadfull.querySelectorAll("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            pageHeadfull.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        ElementHandle blockCollectHistoryWatchNil = pageHeadfull.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']");
        // делаем скриншот элемента "blockCollectHistoryWatchNil":
        vrt.track(
                "blockCollectHistoryWatchNil",
                Base64.getEncoder().encodeToString(blockCollectHistoryWatchNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        ElementHandle tailWatchAndEditCollectHistoryWatchNil = pageHeadfull.querySelector("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@class='ArHiwAcYUlO8lYdGJYyYT']");
        // делаем скриншот элемента "tailWatchAndEditCollectHistoryWatchNil":
        vrt.track(
                "tailWatchAndEditCollectHistoryWatchNil",
                Base64.getEncoder().encodeToString(tailWatchAndEditCollectHistoryWatchNil.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkMessageContentIsBeingLoaded() {
        page.waitForSelector("//span[text()='Идет загрузка контента...']");
    }

    public void checkChangeContentOnColdPopular() throws InterruptedException {
        ElementHandle titleCollectionBeforeElement = page.waitForSelector("(//h2[@class='MediaScroller_title__3LXbw'])[1]");
        String titleCollectionBeforeName = titleCollectionBeforeElement.innerText();
        System.out.println(titleCollectionBeforeName);
//        page.reload();
//        Thread.sleep(2000);
        ElementHandle alert = page.waitForSelector("//span[text()='Идет загрузка контента...']");
        alert.waitForElementState(ElementState.HIDDEN);
        ElementHandle titleCollectionAfterElement = page.waitForSelector("(//h2[@class='MediaScroller_title__3LXbw'])[1]");
        String titleCollectionAfterName = titleCollectionAfterElement.innerText();
        System.out.println(titleCollectionAfterName);
        Assert.assertNotEquals("bug: not applied content cold popular vector", titleCollectionBeforeName, titleCollectionAfterName);
    }

    public void clickOnTitleEditCollectionAndCheckOpenCollectionPage() throws InterruptedException {
        sleep(3000);
        ElementHandle titleCollectionBeforeElement = page.waitForSelector("(//h2[contains(@class,'MediaScroller_title') and text()='Новое'])[1]");
        String titleCollectionBeforeName = titleCollectionBeforeElement.innerText();
        List<ElementHandle> tilesBeforeAll = page.querySelectorAll("(//h2[contains(@class,'MediaScroller_title') and text()='Новое'])[1]/ancestor::section[contains(@class,'HomePage_collection')][1]//a[@href]//span[contains(@class,'TilePackageCommon_title')]");
        page.click("(//h2[contains(@class,'MediaScroller_title') and text()='Новое'])[1]");
        ElementHandle titleCollectionAfterElement = page.waitForSelector("//h1[text()]");
        String titleCollectionAfterName = titleCollectionAfterElement.innerText();
        List<ElementHandle> tilesAfterAll = page.querySelectorAll("//a[@data-test='PackageLink']");
        Assert.assertEquals("bug: titles of the collections do not match", titleCollectionBeforeName, titleCollectionAfterName);
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/collection"));
        Assert.assertTrue("bug: size tiles collection do not match", tilesAfterAll.size() >= tilesBeforeAll.size());
    }

    public void clickToTileFilmCollectionAndCheckOpenCardFilm() {
        ElementHandle tileFilmName = page.querySelector("(//h2[contains(@class,'MediaScroller_title') and text()='Новое'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        String nameFilmAdd = tileFilmName.innerText();
        page.click("(//h2[contains(@class,'MediaScroller_title') and text()='Новое'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/vods/')]");
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/movies/vods/"));
        Assert.assertEquals("bug: name film do not match", nameFilmAdd, page.querySelector("//h1[text()]").innerText());
    }

    public void clickToTileSerialCollectionAndCheckOpenCardSerial() {
        ElementHandle tileSerialName = page.querySelector("(//h2[contains(@class,'MediaScroller_title') and text()='Новое'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/shows/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        String nameSerialText = tileSerialName.innerText();
        page.click("(//h2[contains(@class,'MediaScroller_title') and text()='Новое'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/shows/')]");
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/shows/"));
        Assert.assertEquals("bug: name serial do not match", nameSerialText, page.querySelector("//h1[text()]").innerText());
    }

    public void clickToTileTvProgramCollectionAndCheckOpenCardTvProgram() {
        ElementHandle tileTvProgramName = page.querySelector("(//h2[contains(@class,'MediaScroller_title') and text()='Детям'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/programs/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        String nameTvProgramText = tileTvProgramName.innerText();
        page.click("(//h2[contains(@class,'MediaScroller_title') and text()='Детям'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/programs/')]");
        Assert.assertTrue("bug: not opened page collection", page.url().contains("/programs/"));
        Assert.assertEquals("bug: name tv program do not match", nameTvProgramText, page.querySelector("//h1[text()]").innerText());
    }

    public void clickToTileTvChannelCollectionAndCheckOpenCardTvChannel() throws InterruptedException {
        ElementHandle tileTvProgramLink = page.querySelector("(//h2[contains(@class,'MediaScroller_title') and text()='Популярные телеканалы'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/channels/') and contains(@class,'TileChannelPackage_tile')][1]");
        String linkTvProgramText = tileTvProgramLink.getAttribute("href");
        page.click("(//h2[contains(@class,'MediaScroller_title') and text()='Популярные телеканалы'])[1]/ancestor::section[contains(@class,'HomePage_collection')]//a[contains(@href,'/channels/')]");
        Assert.assertTrue("bug: not opened page collection", page.url().contains("/channels/"));
        Assert.assertTrue("bug: tv channel do not match", page.url().contains(linkTvProgramText));
    }

    public void clickOnTitleAfCollectionAndCheckOpenCollectionPage() throws InterruptedException {
        sleep(3000);
        ElementHandle titleCollectionBeforeElement = page.waitForSelector("(//h2[contains(@class,'MediaScroller_title') and text()='Аниме'])[1]");
        String titleCollectionBeforeName = titleCollectionBeforeElement.innerText();
        List<ElementHandle> tilesBeforeAll = page.querySelectorAll("(//h2[contains(@class,'MediaScroller_title') and text()='Аниме'])[1]/ancestor::section[contains(@class,'HomePage_collection')][1]//a[@href]//span[contains(@class,'TilePackageCommon_title')]");
        page.click("(//h2[contains(@class,'MediaScroller_title') and text()='Аниме'])[1]");
        ElementHandle titleCollectionAfterElement = page.waitForSelector("//h1[text()]");
        String titleCollectionAfterName = titleCollectionAfterElement.innerText();
        List<ElementHandle> tilesAfterAll = page.querySelectorAll("//a[@data-test='PackageLink']");
        Assert.assertEquals("bug: titles of the collections do not match", titleCollectionBeforeName, titleCollectionAfterName);
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/collection"));
        Assert.assertTrue("bug: size tiles collection do not match", tilesAfterAll.size() >= tilesBeforeAll.size());
    }

    public void scrollAfCollectAndCheckLastTileShowAll() {
        page.querySelector("//h2[contains(@class,'MediaScroller_title') and text()='Лучшее в подписке']/ancestor::section");
        List<ElementHandle> tileAll = page.querySelectorAll("//h2[text()='Лучшее в подписке']/ancestor::section//div[contains(@class,'TilePackageCommon')]");
        for (ElementHandle tile : tileAll) {
            tile.hover();
            if (page.querySelector("//h2[text()='Лучшее в подписке']/ancestor::section//span[contains(@class,'lastChild')]").isVisible()) {
                Assert.assertTrue("bug: not visible element", page.querySelectorAll("//h2[text()='Лучшее в подписке']/ancestor::section//span[contains(@class,'lastChild') and text()='Смотреть все']").size() > 0);
                break;
            }
            page.click("(//section[contains(@class,'HomePage_collection')])[1]//button[@aria-label='show next content']");
        }
    }

    public void clickOnTitleCinCGenresAndCheckOpenPageCollect() {
        ElementHandle titleCollectionBeforeElement = page.waitForSelector("//h2[text()='Жанры']/ancestor::section//a[contains(@class,'TileTriple')]");
        String titleCollectionBeforeName = titleCollectionBeforeElement.innerText();
        page.click("//h2[text()='Жанры']/ancestor::section//a[contains(@class,'TileTriple')]");
        ElementHandle titleCollectionAfterElement = page.waitForSelector("//h1[text()]");
        String titleCollectionAfterName = titleCollectionAfterElement.innerText();
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/collection"));
        Assert.assertEquals("bug: titles of the collections do not match", titleCollectionBeforeName, titleCollectionAfterName);
    }

    public void clickOnTitleCinCNonGenresAndCheckOpenPageCollect() {
        ElementHandle titleCollectionBeforeElement = page.waitForSelector("//h2[text()='Акции']/ancestor::section//a[contains(@class,'TileTriple')]");
        String titleCollectionBeforeName = titleCollectionBeforeElement.innerText();
        page.click("//h2[text()='Акции']/ancestor::section//a[contains(@class,'TileTriple')]");
        ElementHandle titleCollectionAfterElement = page.waitForSelector("//h1[text()]");
        String titleCollectionAfterName = titleCollectionAfterElement.innerText();
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/collection"));
        Assert.assertEquals("bug: titles of the collections do not match", titleCollectionBeforeName, titleCollectionAfterName);
    }

    public void clickOnTitlePackagesCollectionAndCheckOpenCollectionPage() throws InterruptedException {
        sleep(3000);
        Assert.assertTrue("bug: not found element", page.querySelectorAll("//h2[text()='Попробуй бесплатно ']").size()>0);
        ElementHandle titleCollectionBeforeElement = page.waitForSelector("//h2[text()='Попробуй бесплатно ']");
        String titleCollectionBeforeName = titleCollectionBeforeElement.innerText();
        List<ElementHandle> tilesBeforeAll = page.querySelectorAll("//h2[text()='Попробуй бесплатно ']/ancestor::section//a[@href]//span[contains(@class,'TilePackageCommon_title')]");
        page.click("//h2[text()='Попробуй бесплатно ']");
        ElementHandle titleCollectionAfterElement = page.waitForSelector("//h1[text()]");
        String titleCollectionAfterName = titleCollectionAfterElement.innerText();
        List<ElementHandle> tilesAfterAll = page.querySelectorAll("//a[@data-test='PackageLink']");
        Assert.assertEquals("bug: titles of the collections do not match", titleCollectionBeforeName, titleCollectionAfterName);
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/collection"));
        Assert.assertTrue("bug: size tiles collection do not match", tilesAfterAll.size() >= tilesBeforeAll.size());
    }

    public void clickToTilePackageCollectionAndCheckOpenCardPackage() {
        ElementHandle tilePackageName = page.querySelector("//h2[text()='Попробуй бесплатно ']/ancestor::section//a[contains(@href,'/mixed_groups/')]//span[contains(@class,'TilePackageCommon_title')]");
        String namePackageText = tilePackageName.innerText();
        page.click("//h2[text()='Попробуй бесплатно ']/ancestor::section//a[contains(@href,'/mixed_groups/')]");
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/mixed_groups/"));
        System.out.println(namePackageText);
        System.out.println(page.querySelector("._3JWCAjonEZRvpx1iIk6Y0n").innerText());
        Assert.assertEquals("bug: name film do not match", namePackageText, page.querySelector("._3JWCAjonEZRvpx1iIk6Y0n").innerText());
    }

    public void clickOnTitleBhCollectionAndCheckOpenMyHistory() {
        pageHeadfull.waitForSelector("//h2[contains(@class,'MediaScroller_title') and text()='Продолжить просмотр']").scrollIntoViewIfNeeded();
        pageHeadfull.click("//h2[contains(@class,'MediaScroller_title') and text()='Продолжить просмотр']");
        Assert.assertTrue("bug: not opened page /my/history", pageHeadfull.url().contains("https://web-preprod6.megafon.tv/my/history"));
    }

    public void scrollBhCollectionAndCheckLastTileEditAndShowAll() {
        pageHeadfull.querySelector("//h2[text()='Продолжить просмотр']/ancestor::section[contains(@class,'HomePage_collection')]");
        List<ElementHandle> tileAll = pageHeadfull.querySelectorAll("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TilePackageCommon')]");
        for (ElementHandle tile : tileAll) {
            tile.hover();
            if (pageHeadfull.querySelectorAll("//span[contains(@class,'MediaScroller_lastChild')]//div[contains(@class,'TileOverlay')]").size() > 0) {
                Assert.assertTrue("bug: not tile 'Редактировать и показать всё'", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//span[contains(.,'Редактировать  и показать все')]").isVisible());
                break;
            }
            pageHeadfull.click("//h2[text()='Продолжить просмотр']/ancestor::section[contains(@class,'HomePage_collection')]//button[@aria-label='show next content']");
        }
    }

    public void hoverOnTileEditAndShowAllAndCheckImageTile() throws IOException, InterruptedException {
        ElementHandle tileEditAndShowAll = pageHeadfull.waitForSelector("//span[contains(.,'Редактировать  и показать все')]/ancestor::section//a[contains(@class,'EditHistoryCollectionTile')]");
        tileEditAndShowAll.hover();
        // делаем скриншот элемента "blockCollectionNonTvPageNil":
        vrt.track(
                "HoverOnTileEditAndShowAll",
                Base64.getEncoder().encodeToString(tileEditAndShowAll.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnTileEditAndShowAllAndCheckOpenPageMyHistory() {
        ElementHandle tileEditAndShowAll = pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//span[contains(@class,'MediaScroller_lastChild') and contains(text(),'Редактировать')]");
        tileEditAndShowAll.click();
        Assert.assertTrue("bug: not opened page /my/history", pageHeadfull.url().contains("https://web-preprod6.megafon.tv/my/history"));
    }

    public void checkTileFilmInBhCollection() {
        Assert.assertTrue("bug: not visible tile film in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/vods/')][1]").isVisible());
    }

    public void checkTileFilmAndElementsInBhCollection() throws InterruptedException {
        Assert.assertTrue("bug: not visible tile film in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/vods/')][1]").isVisible());
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/vods/')][1]").scrollIntoViewIfNeeded();
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/vods/')][1]//picture[contains(@class,'TilePackageCommon_image')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_desc')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        pageHeadfull.hover("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/vods/')][1]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'duration')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/movies/vods/')][1]//span[contains(@class,'meta')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconPlay')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconFavourite')]");
    }

    public void clickTileFilmFromBhCollectAndCheckOpenCardFilm() {
        ElementHandle tileFilmBhCollect = pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/vods/')][1]");
        tileFilmBhCollect.scrollIntoViewIfNeeded();
        ElementHandle titleFilmBhCollect = pageHeadfull.querySelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/vods/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        String titleFilmBhCollectText = titleFilmBhCollect.innerText();
        tileFilmBhCollect.hover();
        Assert.assertTrue("bug: not opened page collection", page.url().contains("https://web-preprod6.megafon.tv/movies/vods/"));
        Assert.assertEquals("bug: name film do not match", titleFilmBhCollectText, page.querySelector("//h1[text()]").innerText());
    }

    public void checkTileSerialInBhCollection() {
        Assert.assertTrue("bug: not visible tile serial in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]").isVisible());
    }

    public void checkTileSerialAndElementsInBhCollection() {
        Assert.assertTrue("bug: not visible tile serial in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]").isVisible());
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]//picture[contains(@class,'TilePackageCommon_image')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_desc')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        pageHeadfull.hover("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'duration')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'meta')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconPlay')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconFavourite')]");
    }

    public void checkTileTvProgramInBhCollection() {
        Assert.assertTrue("bug: not visible tile tv program in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/programs/')][1]").isVisible());
    }

    public void checkTileTvProgramAndElementsInBhCollection() {
        Assert.assertTrue("bug: not visible tile tv program in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/programs/')][1]").isVisible());
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/programs/')][1]//picture[contains(@class,'TilePackageCommon_image')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/programs/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/programs/')][1]//span[contains(@class,'TilePackageCommon_desc')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/programs/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        pageHeadfull.hover("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/programs/')][1]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/programs/')][1]//span[contains(@class,'duration')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/programs/')][1]//span[contains(@class,'meta')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconPlay')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconFavourite')]");
    }

    public void checkTileNewEpisodeInBhCollection() {
        Assert.assertTrue("bug: not visible tile serial in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]//*[text()='Новый эпизод']").isVisible());
    }

    public void checkTileNewEpisodeAndElementsInBhCollection() {
        Assert.assertTrue("bug: not visible tile serial in bh collection", pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]").isVisible());
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]//picture[contains(@class,'TilePackageCommon_image')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_title')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_desc')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'TilePackageCommon_parentalRating')]");
        pageHeadfull.hover("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href,'/shows/')][1]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'duration')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//a[contains(@href, '/shows/')][1]//span[contains(@class,'meta')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressText')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//span[contains(@class,'progressBar')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconPlay')]");
        pageHeadfull.waitForSelector("//h2[text()='Продолжить просмотр']/ancestor::section//div[contains(@class,'TileOverlay')]//*[contains(@class,'iconFavourite')]");
    }

    public void checkElementsFooterMinPage() throws IOException, InterruptedException {
        page.waitForSelector("//footer").scrollIntoViewIfNeeded();
        page.waitForSelector("//span[text()='Устройства']");
        page.waitForSelector("//span[text()='Поддержка']");
        page.waitForSelector("//div[text()='Скачайте приложение']");
        page.waitForSelector("//img[@alt='app-store']");
        page.waitForSelector("//img[@alt='google-store']");
        page.waitForSelector("//img[@alt='smart-tv-store']");
        page.waitForSelector("//div[text()='Мы в соцсетях']");
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[1]");
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]");
        page.waitForSelector("//a[@href and text()='Условия оказания услуг']");
        page.waitForSelector("//a[@href and text()='Политика конфидециальности']");
        page.waitForSelector("//a[@href and text()='Правила оказания телематических услуг связи']");
        page.waitForSelector("//a[@href and text()='Правила оказания услуг телевизионного вещания']");
    }

    public void checkElementsFooterMediumPage() throws IOException, InterruptedException {
        page.waitForSelector("//footer").scrollIntoViewIfNeeded();
        page.waitForSelector("//span[text()='Устройства']");
        page.waitForSelector("//span[text()='Поддержка']");
        page.waitForSelector("//div[text()='Скачайте приложение']");
        page.waitForSelector("//img[@alt='app-store']");
        page.waitForSelector("//img[@alt='google-store']");
        page.waitForSelector("//img[@alt='smart-tv-store']");
        page.waitForSelector("//div[text()='Мы в соцсетях']");
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[1]");
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]");
        page.waitForSelector("//a[@href and text()='Условия оказания услуг']");
        page.waitForSelector("//a[@href and text()='Политика конфидециальности']");
        page.waitForSelector("//a[@href and text()='Правила оказания телематических услуг связи']");
        page.waitForSelector("//a[@href and text()='Правила оказания услуг телевизионного вещания']");
    }

    public void checkElementsFooterWidePage() throws IOException, InterruptedException {
        page.waitForSelector("//footer").scrollIntoViewIfNeeded();
        page.waitForSelector("//div[contains(@class,'List_title') and text()='Устройства']");
        page.waitForSelector("(//a[@href='/devices#smartphone' and text()='Смартфоны и планшеты'])[2]");
        page.waitForSelector("(//a[@href='/devices#smart-tv' and text()='Smart TV'])[2]");
        page.waitForSelector("(//a[@href='/devices#smart-tv' and text()='Android TV'])[2]");
        page.waitForSelector("(//a[@href='/devices#appletv' and text()='Apple TV'])[2]");
        page.waitForSelector("(//a[@href='/devices#fmc' and text()='Медиаплееры'])[2]");
        page.waitForSelector("(//a[@href='/devices' and text()='Все устройства'])[2]");

        page.waitForSelector("//div[contains(@class,'List_title') and text()='Поддержка']");
        page.waitForSelector("(//a[@href='tel:+78005509065'])[2]");
        page.waitForSelector("(//a[@href='/' and text()='Задайте нам вопрос'])[2]");
        page.waitForSelector("(//a[@href='/help' and text()='Вопросы и ответы'])[2]");
        page.waitForSelector("(//a[@href='/sitemap' and text()='Карта сайта'])[2]");
        page.waitForSelector("(//a[@href='/devices' and text()='О нас'])[2]");

        page.waitForSelector("//div[text()='Скачайте приложение']");
        page.waitForSelector("//img[@alt='app-store']");
        page.waitForSelector("//img[@alt='google-store']");
        page.waitForSelector("//img[@alt='smart-tv-store']");
        page.waitForSelector("//div[text()='Мы в соцсетях']");
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[1]");
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]");
        page.waitForSelector("//a[@href and text()='Условия оказания услуг']");
        page.waitForSelector("//a[@href and text()='Политика конфидециальности']");
        page.waitForSelector("//a[@href and text()='Правила оказания телематических услуг связи']");
        page.waitForSelector("//a[@href and text()='Правила оказания услуг телевизионного вещания']");
    }

    public void checkImageFooterMinPageGuest() throws IOException, InterruptedException {
        // скриншот футер min page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerMinPageNilGuest",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooterMediumPageGuest() throws IOException, InterruptedException {
        // скриншот футер medium page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerMediumPageNilGuest",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooterMinPageUser() throws IOException, InterruptedException {
        // скриншот футер min page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerMinPageNilUser",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageFooterMediumPageUser() throws IOException, InterruptedException {
        // скриншот футер medium page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerMediumPageNilUser",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void checkImageOpenListsDevicesFooterMinPageGuest() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Устройства']").click();
        // скриншот футер min page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsDevicesMinPageNilGuest",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImageOpenListsSupportFooterMinPageGuest() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Поддержка']").click();
        // скриншот футер min page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsSupportMinPageNilGuest",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageOpenListsDevicesFooterMinPageUser() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Устройства']").click();
        // скриншот футер min page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsDevicesMinPageNilUser",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImageOpenListsSupportFooterMinPageUser() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Поддержка']").click();
        // скриншот футер min page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsSupportMinPageNilUser",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageOpenListsDevicesFooterMediumPageGuest() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Устройства']").click();
        // скриншот футер medium page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsDevicesMediumPageNilGuest",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImageOpenListsSupportFooterMediumPageGuest() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Поддержка']").click();
        // скриншот футер medium page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsSupportMediumPageNilGuest",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageOpenListsDevicesFooterMediumPageUser() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Устройства']").click();
        // скриншот футер medium page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsMediumPageNilUser",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImageOpenListsSupportFooterMediumPageUser() throws IOException, InterruptedException {
        page.waitForSelector("//span[text()='Поддержка']").click();
        // скриншот футер medium page:
        ElementHandle footer = page.querySelector("//footer");
        // делаем скриншот элемента "footerPageNil":
        vrt.track(
                "footerOpenListsSupportMediumPageNilUser",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void waitHiddenMessageContentIsBeingLoaded() throws InterruptedException {
        ElementHandle alert = page.waitForSelector("//span[text()='Идет загрузка контента...']");
        alert.waitForElementState(ElementState.HIDDEN);
    }

    public void hoverOnListBlockDevicesFooterAndCheckColor() throws InterruptedException {
        List<ElementHandle> deviceAll = page.querySelectorAll("//div[contains(@class,'LayoutFooter_devices')]//a[@href]");
        for (ElementHandle device : deviceAll) {
            device.hover();
            sleep(2000);
            System.out.println(device.evaluate("e => window.getComputedStyle(e).color"));
            Assert.assertEquals("bug: the color of the element is not white", device.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 255, 255)");
        }
    }

    public void hoverOnListBlockSupportFooterAndCheckColor() throws InterruptedException {
        List<ElementHandle> deviceAll = page.querySelectorAll("//div[contains(@class,'LayoutFooter_support')]//a[@href]");
        for (ElementHandle device : deviceAll) {
            device.hover();
            sleep(2000);
            System.out.println(device.evaluate("e => window.getComputedStyle(e).color"));
            Assert.assertEquals("bug: the color of the element is not white", device.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 255, 255)");
        }
    }

    public void goToLinksBlockDevicesFooter() {
        page.waitForSelector("(//a[@href='/devices#smartphone' and text()='Смартфоны и планшеты'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/devices#smartphone"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/devices#smart-tv' and text()='Smart TV'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/devices#smart-tv"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/devices#smart-tv' and text()='Android TV'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/devices#smart-tv"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/devices#appletv' and text()='Apple TV'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/devices#appletv"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/devices#fmc' and text()='Медиаплееры'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/devices#fmc"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/devices' and text()='Все устройства'])[2]").click();
        Assert.assertTrue("bug: not opened page devices", page.url().contains("https://web-preprod6.megafon.tv/devices"));
        page.navigate("https://web-preprod6.megafon.tv");
    }

    public void goToLinksBlockSupportFooter() {
        page.waitForSelector("(//a[@href='tel:+78005509065' and text()='8 800 550–90–65 (Бесплатно)'])[2]").click();
        page.onDialog(dialog -> dialog.dismiss());
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/' and text()='Задайте нам вопрос'])[2]").click();
        Assert.assertTrue("bug: not opened popUp form 'Send a question'", page.querySelectorAll("//div[text()='Отправить вопрос']").size() == 1);
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/help' and text()='Вопросы и ответы'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/help"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/sitemap' and text()='Карта сайта'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/sitemap"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='/devices' and text()='О нас'])[2]").click();
        Assert.assertTrue("bug: not opened page device", page.url().contains("https://web-preprod6.megafon.tv/devices"));
        page.navigate("https://web-preprod6.megafon.tv");
    }

    public void goToLinkBlockSocialNetworksFooter() {
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[1]").click();
        Assert.assertTrue("bug: not opened page 'MegaFon TV in Messengers!'", page.querySelectorAll("//h1[text()='МегаФон ТВ в Мессенджерах!']").size() == 1);
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("(//a[@href='https://ftlp.pw/lp/8KPQJMYU/'])[2]").click();
        Assert.assertTrue("bug: not opened page 'MegaFon TV in Messengers!'", page.querySelectorAll("//h1[text()='МегаФон ТВ в Мессенджерах!']").size() == 1);
        page.navigate("https://web-preprod6.megafon.tv");
    }

    public void goToLinkBlockStoresFooter() {
        page.waitForSelector("//img[@alt='app-store']").click();
        Assert.assertTrue("bug: not opened page appStore", page.url().contains("https://apps.apple.com/ru/app/megafon-tv"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("//img[@alt='google-store']").click();
        Assert.assertTrue("bug: not opened page googlePlay", page.url().contains("https://play.google.com/store/apps/"));
        Assert.assertTrue("bug: not opened page googlePlay", page.url().contains("megafon.tv"));
        page.navigate("https://web-preprod6.megafon.tv");
        page.waitForSelector("//img[@alt='smart-tv-store']").click();
        Assert.assertTrue("bug: not opened page devices", page.url().contains("https://web-preprod6.megafon.tv/devices"));
        page.navigate("https://web-preprod6.megafon.tv");
    }

    public void goToLinksBlockDocumentsFooter() {
        page.waitForSelector("//a[@href and text()='Правила оказания телематических услуг связи']").click();
        Assert.assertTrue("bug: not opened pdf 'rules-ktv.pdf'", page.url().contains("/docs/rules-ktv.pdf"));
        page.navigate("https://web-preprod6.megafon.tv");

        page.waitForSelector("//a[@href and text()='Правила оказания услуг телевизионного вещания']").click();
        Assert.assertTrue("bug: not opened pdf 'rules-provide-telematic-services.pdf'", page.url().contains("/docs/rules-provide-telematic-services.pdf"));
        page.navigate("https://web-preprod6.megafon.tv");

        page.waitForSelector("//a[@href and text()='Условия оказания услуг']").click();
        Assert.assertTrue("bug: not opened pdf 'mediaportal_oferta.pdf'", page.url().contains("https://moscow.megafon.ru/download/~federal/oferts/mediaportal_oferta.pdf"));
        page.navigate("https://web-preprod6.megafon.tv");

        page.waitForSelector("//a[@href and text()='Политика конфидециальности']").click();
        Assert.assertTrue("bug: not opened pdf 'privacy.pdf'", page.url().contains("/docs/privacy.pdf"));
        page.navigate("https://web-preprod6.megafon.tv");
    }

    public void clickToButtonSpeedtestInFooter() {
        page.waitForSelector("//a[@href='https://www.megafon.ru/go/s_4g']").click();
        Assert.assertTrue("bug: not opened 'https://www.megafon.ru/go/s_4g'", page.url().contains("https://moscow.megafon.ru/internet/4g/"));
        page.navigate("https://web-preprod6.megafon.tv");
    }

    public void checkImageBlockSocialLinkInFooterGuest() throws IOException, InterruptedException {
        ElementHandle blockSocialLink = page.querySelector("//div[contains(@class,'LayoutFooter_socials')]");
        page.waitForSelector("//div[contains(@class,'LayoutFooter_socials')]//a[@href][1]").hover();
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverViberInBlockSocialLinkGuest",
                Base64.getEncoder().encodeToString(blockSocialLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.waitForSelector("//div[contains(@class,'LayoutFooter_socials')]//a[@href][2]").hover();
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverTelegramInBlockSocialLinkGuest",
                Base64.getEncoder().encodeToString(blockSocialLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlockDownloadsInFooterGuest() throws IOException, InterruptedException {
        ElementHandle blockDownloadsLink = page.querySelector("//div[contains(@class,'LayoutFooter_downloads')]");
        page.waitForSelector("//div[contains(@class,'LayoutFooter_downloads')]//a[@href][1]").hover();
        sleep(2000);
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverAppStoreLinkInBlockDownloadsGuest",
                Base64.getEncoder().encodeToString(blockDownloadsLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.waitForSelector("//div[contains(@class,'LayoutFooter_downloads')]//a[@href][2]").hover();
        sleep(2000);
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverGooglePlayLinkInBlockDownloadsGuest",
                Base64.getEncoder().encodeToString(blockDownloadsLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.waitForSelector("//div[contains(@class,'LayoutFooter_downloads')]//a[@href][3]").hover();
        sleep(2000);
        // делаем скриншот элемента "blockDownloadsLink":
        vrt.track(
                "hoverSmartTVLinkInBlockDownloadsGuest",
                Base64.getEncoder().encodeToString(blockDownloadsLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void hoverOnListBlockDocsFooterAndCheckColor() throws InterruptedException {
        List<ElementHandle> docLinkAll = page.querySelectorAll("//div[contains(@class,'LayoutFooter_wrapDocumentLinks')]//a[@href]");
        for (ElementHandle docLink : docLinkAll) {
            docLink.hover();
            sleep(2000);
            System.out.println(docLink.evaluate("e => window.getComputedStyle(e).color"));
            Assert.assertEquals("bug: the color of the element is not white", docLink.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 255, 255)");
        }
    }

    public void checkImageBlockSocialLinkInFooterUser() throws IOException, InterruptedException {
        ElementHandle blockSocialLink = page.querySelector("//div[contains(@class,'LayoutFooter_socials')]");
        page.waitForSelector("//div[contains(@class,'LayoutFooter_socials')]//a[@href][1]").hover();
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverViberInBlockSocialLinkUser",
                Base64.getEncoder().encodeToString(blockSocialLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.waitForSelector("//div[contains(@class,'LayoutFooter_socials')]//a[@href][2]").hover();
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverTelegramInBlockSocialLinkUser",
                Base64.getEncoder().encodeToString(blockSocialLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlockDownloadsInFooterUser() throws IOException, InterruptedException {
        ElementHandle blockDownloadsLink = page.querySelector("//div[contains(@class,'LayoutFooter_downloads')]");
        page.waitForSelector("//div[contains(@class,'LayoutFooter_downloads')]//a[@href][1]").hover();
        sleep(2000);
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverAppStoreLinkInBlockDownloadsUser",
                Base64.getEncoder().encodeToString(blockDownloadsLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.waitForSelector("//div[contains(@class,'LayoutFooter_downloads')]//a[@href][2]").hover();
        sleep(2000);
        // делаем скриншот элемента "blockSocialLink":
        vrt.track(
                "hoverGooglePlayLinkInBlockDownloadsUser",
                Base64.getEncoder().encodeToString(blockDownloadsLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        page.waitForSelector("//div[contains(@class,'LayoutFooter_downloads')]//a[@href][3]").hover();
        sleep(2000);
        // делаем скриншот элемента "blockDownloadsLink":
        vrt.track(
                "hoverSmartTVLinkInBlockDownloadsUser",
                Base64.getEncoder().encodeToString(blockDownloadsLink.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsSearchFormForMinPage() {
        Assert.assertTrue("not found element", page.querySelectorAll("(//input[@placeholder='Поиск на МегаФон ТВ'])[2]").size()==1);
        Assert.assertEquals("not found element", 1, page.querySelectorAll("//*[@id='close-mobilemenu']").size()==1);
        Assert.assertEquals("not found element", 1, page.querySelectorAll("//*[@class='ch-mobile-menu__back']").size()==1);
    }

    public void checkCloseSearchFormMinPage() {
        page.click("//*[@id='close-mobilemenu']");
        Assert.assertEquals("not hidden element", 0, page.querySelectorAll("//div[contains(@class,'ch-search_open')]").size());
    }

    public void checkElementsSearchFormForMediumPage() {
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//*[@id='close-mobilemenu']").size());
    }

    public void checkCloseSearchFormMediumPage() {
        page.click("(//div[@class='ch-search__icon']//*[@id='close-search'])[1]");
        Assert.assertTrue("not hidden element", page.querySelector("//input[contains(@class,'ch-search__input')]").isHidden());
    }

    public void checkElementsSearchFormForWidePage() {
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[contains(@class,'ch-header__section_type_search')]//*[@id='close-search'][1]").size());
    }

    public void checkCloseSearchFormWidePage() {
        page.click("//div[contains(@class,'ch-header__section_type_search')]//*[@id='close-search'][1]");
        Assert.assertTrue("not hidden element", page.querySelector("//input[contains(@class,'ch-search__input')]").isHidden());
    }

    public void chooseSearchAndCheckImageWidePageGuest() throws IOException, InterruptedException {
        page.click("//button[contains(@class,'ch-header__trigger_type_search')]");
        sleep(5000);
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
    }

    public void checkInputOneSimbolInSearchForm() {
        page.click("//button[contains(@class,'ch-header__trigger_type_search')]");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Поиск на МегаФон ТВ'])[1]").size());
        page.fill("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]", "р");
        Assert.assertTrue("not visible element", page.waitForSelector("//div[text()='Ничего не найдено']").isVisible());
    }

    public void checkInputMultipleSimbolsInSearchForm() {
        page.click("//button[contains(@class,'ch-header__trigger_type_search')]");
        Assert.assertTrue("not found element", page.querySelectorAll("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]").size()==1);
        page.fill("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]", "робот");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-search__result']").size() == 1);
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Фильмы']").size() == 1);
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='Сериалы']").size() == 1);
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']").size() == 1);
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//a[@class='ch-search__all-result-link' and text()='Все результаты']").size() == 1);
    }

    public void checkResultSearchNothingFound() {
        page.click("//button[contains(@class,'ch-header__trigger_type_search')]");
        page.fill("(//input[@placeholder='Поиск на МегаФон ТВ'])[1]", "автотест");
        Assert.assertTrue("not visible element", page.waitForSelector("//div[text()='Ничего не найдено']").isVisible());
    }

    public void checkClickOnFilmFromResultSearch() {
        String nameFilmText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Фильмы']/following::div[@class='ch-search-item__title']").innerText();
        page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Фильмы']/following::div[@class='ch-search-item__title']").click();
        Assert.assertEquals("bug: names films don't match", nameFilmText, page.waitForSelector("//h1[text()]").innerText());
        Assert.assertTrue("bug: not opened page card film", page.url().contains("/movies/vods/"));
    }

    public void checkClickOnSerialFromResultSearch() {
        String nameSerialText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Сериалы']/following::div[@class='ch-search-item__title']").innerText();
        page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Сериалы']/following::div[@class='ch-search-item__title']").click();
        Assert.assertEquals("bug: names serials don't match", nameSerialText, page.waitForSelector("//h1[text()]").innerText());
        Assert.assertTrue("bug: not opened page card serial", page.url().contains("/shows/"));
    }

    public void checkClickOnTvProgramFromResultSearch() {
        String nameTvProgramText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']/following::div[@class='ch-search-item__title']").innerText();
        page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']/following::div[@class='ch-search-item__title']").click();
        Assert.assertEquals("bug: names tv programs don't match", nameTvProgramText, page.waitForSelector("//h1[text()]").innerText());
        Assert.assertTrue("bug: not opened page card tv program", page.url().contains("/programs/"));
    }

    public void clickOnButtonAllResultsInSearch() {
        String nameFilmText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Фильмы']/following::div[@class='ch-search-item__title']").innerText();
        String nameSerialText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Сериалы']/following::div[@class='ch-search-item__title']").innerText();
        String nameTvProgramText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']/following::div[@class='ch-search-item__title']").innerText();
        page.waitForSelector("//a[@class='ch-search__all-result-link' and text()='Все результаты']").click();
        Assert.assertTrue("bug: not opened page all results", page.url().contains("/search?q=робот"));
        Assert.assertEquals("bug: names films don't match", nameFilmText, page.waitForSelector("//a[contains(@href,'/movies/vods/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
        Assert.assertEquals("bug: names serials don't match", nameSerialText, page.waitForSelector("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
        Assert.assertEquals("bug: names tv programs don't match", nameTvProgramText, page.waitForSelector("//a[contains(@href,'/programs/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void pressEnterOnAllResultsInSearchForm() {
        String nameFilmText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Фильмы']/following::div[@class='ch-search-item__title']").innerText();
        String nameSerialText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='Сериалы']/following::div[@class='ch-search-item__title']").innerText();
        String nameTvProgramText = page.waitForSelector("//div[@class='ch-search__title-line']//div[text()='ТВ-передачи']/following::div[@class='ch-search-item__title']").innerText();
        page.keyboard().press("Enter");
        Assert.assertTrue("bug: not opened page all results", page.url().contains("/search?q=робот"));
        Assert.assertEquals("bug: names films don't match", nameFilmText, page.waitForSelector("//a[contains(@href,'/movies/vods/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
        Assert.assertEquals("bug: names serials don't match", nameSerialText, page.waitForSelector("//a[contains(@href,'/shows/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
        Assert.assertEquals("bug: names tv programs don't match", nameTvProgramText, page.waitForSelector("//a[contains(@href,'/programs/')]//h3[@data-test='PackageDescriptionTitle']").innerText());
    }

    public void clickOnButtonEnterAndCheckOpenPageAuth() {
        page.waitForSelector("(//span[text()='Вход'])[1]").click();
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        Assert.assertTrue("bug: not opened page auth", page.url().contains("/auth"));
    }

    public void inputValidNumberAndCheckActiveButtonNext(String login) {
        page.fill("//input[@type='tel']", login);
        Assert.assertEquals("not active button 'Next'", 0, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
    }

    public void clickOnTabPromocodeAndCheckOpenFormPromocode() {
        page.waitForSelector("(//div[text()='Промокод'])[1]").click();
        page.waitForSelector("//h1[text()='Введите промокод']");
        Assert.assertTrue("bug: not opened page promocodes", page.url().contains("/_promocodes"));
    }

    public void checkOpenPageConnectionSmartTV() throws InterruptedException {
        page.waitForSelector("(//span[contains(text(),'+79')])[2]").click();
        page.waitForSelector("(//span[text()='Подключить SmartTV'])[1]").click();
        sleep(3000);
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='Подключить ТВ']").size());
        Assert.assertTrue("bug: not opened page card tv program", page.url().contains("/connect_smart_tv"));
    }

    public void checkElementsPageConnectionSmartTV() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/smart-tv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='Подключить ТВ']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//p[text()='Введите код подключения, указанный на вашем телевизоре в приложении МегаФон ТВ в разделе “Подключить Smart TV”']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//input[@placeholder='Код подключения']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Подключить Smart TV']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//a[contains(@class,'closeButton') and text()='Закрыть']").size());
    }

    public void clickOnButtonCloseAndCheckOpenNilPage() {
        page.waitForSelector("//a[contains(@class,'closeButton') and text()='Закрыть']").click();
        Assert.assertEquals("bug: not visible element", 0, page.querySelectorAll("//h1[text()='E-mail']").size());
        page.waitForSelector("//div[contains(@class,'carousel')]");
    }

    public void checkImagePageConnectionSmartTV() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageConnectionSmartTVFull":
        sleep(3000);
        vrt.track(
                "PageConnectionSmartTVFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkInputInValidCode(String code) throws InterruptedException {
        page.querySelector("//h1[text()='Подключить ТВ']");
        page.fill("//input[@placeholder='Код подключения']", code);
        sleep(3000);
        ElementHandle buttonNext = page.waitForSelector("//button[text()='Подключить Smart TV']");
        String background = (String) buttonNext.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: the color of the element is not green", background.contains("rgb(0, 185, 86)"));
    }

    public void clickOnButtonConnectionAndCheckElementsInValidCode() {
        page.waitForSelector("//button[text()='Подключить Smart TV']").click();
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/smart-tv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='Подключить ТВ']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//p[text()='Введите код подключения, указанный на вашем телевизоре в приложении МегаФон ТВ в разделе “Подключить Smart TV”']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//input[@placeholder='Код подключения']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Подключить Smart TV']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//a[contains(@class,'closeButton') and text()='Закрыть']").size());

        ElementHandle errorText = page.waitForSelector("//span[text()='Неверный код']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[text()='Неверный код']").size());
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assert.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
    }

    public void checkInputValidCodeInPageConnectionSmartTV(String login, String password) throws InterruptedException {
        pageSmartTv = contextIncognitoModeHeadless.newPage();
        pageSmartTv.navigate("http://staging-smart-nettv.megafon.tv");
        sleep(15000);
        pageSmartTv.waitForSelector("//span[text()='Закрыть']").click();
        if(pageSmartTv.querySelectorAll("//span[text()='Закрыть']").size()>0){
            pageSmartTv.click("//span[text()='Закрыть']");
        }
        pageSmartTv.waitForSelector("//div[text()='Меню']").click();
        pageSmartTv.waitForSelector("//div[text()='Настройки']").click();
        pageSmartTv.waitForSelector("//span[text()='Очистить хранилище']").click();
        pageSmartTv.waitForSelector("//span[text()='Изменить настройки']").click();
        pageSmartTv.waitForSelector("//span[text()='Окружение bmp-api']").click();
        pageSmartTv.waitForSelector("//span[text()='preprod6']").click();
        if(pageSmartTv.querySelectorAll("(//span[text()='Назад'])[2]").size()>0){
            pageSmartTv.click("(//span[text()='Назад'])[2]");
        }
        if(pageSmartTv.querySelectorAll("//span[text()='Назад']").size()>0){
            pageSmartTv.click("//span[text()='Назад']");
        }
        sleep(2000);
//        pageSmartTv.waitForSelector("//span[text()='На главную']").click();
//        Thread.sleep(5000);
        pageSmartTv.waitForSelector("(//div[text()='Меню'])[2]").click();
        pageSmartTv.waitForSelector("//div[text()='Вход']").click();
        pageSmartTv.waitForSelector("//div[text()='Закрыть']").click();

        String validCode = pageSmartTv.waitForSelector("//div[contains(@class,'code') and text()]").innerText();
        pageSmartTv.close();
        page.bringToFront();
        page.reload();

        page.navigate("https://web-preprod6.megafon.tv/");
        page.click("//button[contains(@class,'ch-account-controller')]");
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
        page.click("//button[text()='Далее']");
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        page.click("//button[text()='Войти']");
        page.querySelector("(//span[contains(text(),'+792')])[2]");
        // подключить смарт тв:
        page.waitForSelector("(//span[contains(text(),'+79')])[2]").click();
        page.waitForSelector("(//span[text()='Подключить SmartTV'])[1]").click();
        sleep(3000);
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='Подключить ТВ']").size());
        Assert.assertTrue("bug: not opened page card tv program", page.url().contains("/connect_smart_tv"));
        page.fill("//input[@placeholder='Код подключения']", validCode);
        page.click("//button[text()='Подключить Smart TV']");

        page.waitForSelector("//h1[text()='Устройство привязано']");
        page.waitForSelector("//p[text()='Желаем приятного просмотра!']");
        page.waitForSelector("//a[contains(@class,'closeButton') and text()='Закрыть']");
        Assert.assertEquals("bug: not visible element", 0, page.querySelectorAll("//h1[text()='Устройство привязано']").size());
        page.waitForSelector("//div[contains(@class,'carousel')]");
    }

    public void checkOpenPageEmail() throws InterruptedException {
        page.waitForSelector("(//span[contains(text(),'+79')])[2]").click();
        page.waitForSelector("(//span[text()='Email'])[1]").click();
        sleep(3000);
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='E-mail']").size());
        Assert.assertTrue("bug: not opened page card tv program", page.url().contains("/subscribe"));
    }

    public void checkElementsPageEmail() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='E-mail']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//p[text()='Введите вашу электронную почту']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//input[@placeholder='Введите e-mail']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//span[text()='Хочу получать новости и подарки от МегаФон ТВ']").size());
        Assert.assertTrue("not checked box", page.waitForSelector("(//label[@for='acceptNewsletters'])[1]").isChecked());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Сохранить']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//a[contains(@class,'closeButton') and text()='Закрыть']").size());
    }

    public void checkImagePageEmail() throws IOException, InterruptedException {
    // делаем скриншот полной страницы "PageConnectionSmartTVFull":
        sleep(3000);
        vrt.track(
                "PageEmailFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkInputInvalidEmailInProfileMenu(String email) throws InterruptedException {
        page.querySelector("//h1[text()='E-mail']");
        page.fill("//input[@placeholder='Введите e-mail']", email);
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Сохранить']").size());
    }
    public void checkInputValidEmailInProfileMenu(String email) throws InterruptedException {
        page.querySelector("//h1[text()='E-mail']");
        page.fill("//input[@placeholder='Введите e-mail']", email);
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Сохранить']").size());
        sleep(3000);
        ElementHandle buttonSave = page.waitForSelector("//button[text()='Сохранить']");
        String background = (String) buttonSave.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: the color of the element is not green", background.contains("rgb(0, 185, 86)"));
    }

    public void clickOnButtonSaveAndCheckOpenPopUpNoNewsAndGifts() {
        page.click("//button[text()='Сохранить']");
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='Не получать новости и подарки']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//p[text()='Вы уверены, что не хотите получать новости и подарки?']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//button[text()='Да']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//button[text()='Отменить']").size());
    }

    public void checkImagePopUpNoNewsAndGifts() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageEmailPopUpNoNewsAndGiftsFull":
        sleep(3000);
        vrt.track(
                "PageEmailPopUpNoNewsAndGiftsFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnButtonCancelAndCheckOpenEmail() {
        page.click("//button[text()='Отменить']");
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='E-mail']").size());
    }

    public void clickOnButtonYesAndCheckOpenPopUpLinkedEmail() {
        page.click("//button[text()='Да']");
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='Почта привязана!']").size());
        Assert.assertEquals("bug: not visible element", 0, page.querySelectorAll("//p[text()='Следите за новинками и получайте подарки!']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//button[text()='Закрыть']").size());
    }

    public void checkImagePopUpLinkedEmail() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageEmailPopUpEmailLinkedFull":
        sleep(3000);
        vrt.track(
                "PageEmailPopUpEmailLinkedFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void unCheckedBoxEmailFormProfile() {
        Assert.assertTrue("not checked box", page.waitForSelector("(//label[@for='acceptNewsletters'])[1]").isChecked());
        page.waitForSelector("(//label[@for='acceptNewsletters'])[1]").uncheck();
        Assert.assertFalse("not checked box", page.waitForSelector("(//label[@for='acceptNewsletters'])[1]").isChecked());
    }

    public void checkedBoxEmailFormProfile() throws InterruptedException {
        sleep(3000);
        page.waitForSelector("(//label[@for='acceptNewsletters'])[1]").check();
        Assert.assertTrue("not checked box", page.waitForSelector("(//label[@for='acceptNewsletters'])[1]").isChecked());
    }

    public void clickOnButtonSaveAndCheckOpenPopUpLinkedEmail() throws InterruptedException {
        page.click("//button[text()='Сохранить']");
        sleep(3000);
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//h1[text()='Почта привязана!']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//p[text()='Следите за новинками и получайте подарки!']").size());
        Assert.assertEquals("bug: not visible element", 1, page.querySelectorAll("//button[text()='Закрыть']").size());
    }

    public void clickOnButtonCloseAndCheckOpenNilPageAndLinkedEmail() {
        page.click("//button[text()='Закрыть']");
        Assert.assertEquals("bug: not visible element", 0, page.querySelectorAll("//h1[text()='Почта привязана!']").size());
        page.waitForSelector("//div[contains(@class,'carousel')]");
    }

    public void checkImageBlockCollectionTvChannelWidePageNilGuest() throws IOException, InterruptedException {
        // подборки тв каналов:
        sleep(3000);
        ElementHandle collectionTvChannel = page.waitForSelector("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        collectionTvChannel.scrollIntoViewIfNeeded();
        ElementHandle blockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");

        ElementHandle titleBlockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionTv);

        List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
        for (ElementHandle posterTvChannel : posterTvChannelAll) {
            posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
        }
        sleep(3000);
        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvWidePageNilGuest",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlockCollectionTvChannelWidePageNilUser() throws IOException, InterruptedException {
        // подборки тв каналов:
        sleep(3000);
        ElementHandle collectionTvChannel = page.waitForSelector("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')]");
        collectionTvChannel.scrollIntoViewIfNeeded();
        ElementHandle blockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]/ancestor::section[contains(@class,'HomePage_collection')])[1]");

        ElementHandle titleBlockCollectionTv = page.querySelector("(//a[contains(@href,'/tv/channels/')]/ancestor::section[contains(@class,'HomePage_collection')]//h2[contains(@class,'MediaScroller_title')])[1]");
        page.evaluate("t => t.innerText='Название подборки'", titleBlockCollectionTv);

        List<ElementHandle> posterTvChannelAll = page.querySelectorAll("//a[contains(@href,'/tv/channels/') and contains(@class, 'TileChannelPackage')]//source");
        for (ElementHandle posterTvChannel : posterTvChannelAll) {
            posterTvChannel.evaluate("p => p.setAttribute('srcset', 'https://static-sesure.cdn.megafon.tv/images/Channel/00/bb/5a5b58325e9ca580a969154d740a62050ad6/logo_tile__web-wp.png')");
        }
        sleep(3000);
        // делаем скриншот элемента "blockCollectionTvPageNil":
        vrt.track(
                "blockCollectionTvWidePageNilUser",
                Base64.getEncoder().encodeToString(blockCollectionTv.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}
























































