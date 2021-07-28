package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class SerialsPagePW extends BasePagePlaywright {
    private Page page;
    private Page pageCMS;

        public SerialsPagePW (Page page, Page pageCMS) {
        this.page = page;
        this.pageCMS = pageCMS;
    }

    public void checkImageCherdakAndBannersForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/shows");
        // подготовка элемента "cherdakPageSerialsForUnauthorized" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageSerialsForUnauthorized":
        vrt.track(
                "cherdakPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[@data-test='BannerCarousel']");
        ElementHandle banners = page.querySelector("//div[@class='_3VpQMliI0kzCfTPxfHPOa- _2RpZ3dJ5og17m8Uf5So1cd poster']");
        // подготовка элемента "bannersPageSerialsForUnauthorized" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 26) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 26) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 26) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 26) {
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
        // делаем скриншот элемента "bannersPageSerialsForUnauthorized":
        vrt.track(
                "bannersPageSerialsForUnauthorized",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlocksFiltersForUnauthorized() {
            
    }

    public void checkImageBlocksCollectionWithHeaderForUnauthorized() {
    }

    public void checkImageBlocksCollectionWithoutHeaderForUnauthorized() {
    }

    public void checkImageFooterForUnauthorized() {
    }

    public void checkImageSerialsPageScrollForUnauthorized() {
    }

    public void checkImageCherdakAndBannersForAuthorized() {
    }

    public void checkImageBlocksFiltersForAuthorized() {
    }

    public void checkImageBlocksCollectionWithHeaderForAuthorized() {
    }

    public void checkImageBlocksCollectionWithoutHeaderForAuthorized() {
    }

    public void checkImageFooterForAuthorized() {
    }

    public void checkImageSerialsPageScrollForAuthorized() {
    }
}

