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

public class CardFilmPW extends BasePagePlaywright {
    private Page page;
    public CardFilmPW (Page page){
        this.page = page;
    }

    public void checkOpenCardFilm() {
        page.waitForSelector("//span[@itemprop='name' and text()='Фильмы']");
    }

    public void checkAutoStartVideoPlayer() throws InterruptedException {
        if(page.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]").size()!=0) {
            page.click("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]");
            page.waitForSelector("(//button[@class='_3W3bxW5DPDIV5i4O3588XI'])[1]");
            page.click("(//button[@class='_3W3bxW5DPDIV5i4O3588XI'])[1]");
            page.waitForSelector("//span[text()='Подтвердить']");
            page.click("//span[text()='Подтвердить']");
            page.reload();
        }
        Thread.sleep(7000);
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        String timeStart = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Thread.sleep(7000);
        String timeEnd = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Assert.assertNotEquals(timeStart, timeEnd);
    }

    public void checkImageCardFilmForUnauthorized() throws IOException, InterruptedException {
        page.reload();
        ElementHandle nameFilmCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название фильма'", nameFilmCrumbs);

        ElementHandle nameFilm = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("nC => nC.innerText='Название фильма'", nameFilm);

        ElementHandle ratingFilm = page.querySelector("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        page.evaluate("rF => rF.innerText='IMDb: 5.5'", ratingFilm);

        ElementHandle ageYearGenres = page.querySelector("//div[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("d => d.innerText='18+, 2021, Аниме, Мультфильм, Комедия, Фэнтези'", ageYearGenres);

        ElementHandle discriptionFilm = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        page.evaluate("g => g.innerText='Кристина МакФерсон учится в консервативной католической школе в Сакраменто. " +
                "Она ищет себя; своё место в мире и пытается быть не похожей на других. Её волосы выкрашены в странный красно-розовый цвет; " +
                "а имя Леди Бёрд'", discriptionFilm);

        ElementHandle posterFilm = page.querySelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']");
        page.evaluate("pF => pF.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/ba/cb/c68eb9f98803b40eb41f8b6e984f17953846/poster_2018__web-wp.webp);')", posterFilm);

        ElementHandle age = page.querySelector("(//div[@class='_3vBdLAs_q6zHDlAspM6kFN'])[2]");
        page.evaluate("d => d.innerText='18+'",age);

        ElementHandle textPayButton = page.querySelector("//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']");
        page.evaluate("fP => fP.innerText='Навсегда за 100 Р'", textPayButton);

        List<ElementHandle> textStickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            textStickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("fP => fP.innerText='Автотест'", textStickerAll.get(i));
        }
        List<ElementHandle> posterFilmAll;
        List<ElementHandle> titleFilmAll;
        List<ElementHandle> descriptionTextFilmAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterFilmAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/d7/c5/ffb7d649f8a4cec74734d2effeb715f8e6e9/tile__web-wp.webp);')", posterFilmAll.get(i));
            titleFilmAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название фильма'", titleFilmAll.get(i));
            descriptionTextFilmAll = page.querySelectorAll("//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
            page.evaluate("d => d.textContent='2021, Жанр'", descriptionTextFilmAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        List<ElementHandle> stickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            stickerAll = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("s => s.remove();", stickerAll.get(i));
        }
        // делаем скриншот страницы "CardFilmForUnauthorized":
        vrt.track(
                "cardFilmForUnauthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCardFilmForAuthorized() throws IOException, InterruptedException {
        page.reload();
        ElementHandle nameFilmCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название фильма'", nameFilmCrumbs);

        ElementHandle nameFilm = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("nC => nC.innerText='Название фильма'", nameFilm);

        ElementHandle ratingFilm = page.querySelector("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        page.evaluate("rF => rF.innerText='IMDb: 5.5'", ratingFilm);

        ElementHandle ageYearGenres = page.querySelector("//div[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("d => d.innerText='18+, 2021, Аниме, Мультфильм, Комедия, Фэнтези'", ageYearGenres);

        ElementHandle discriptionFilm = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        page.evaluate("g => g.innerText='Кристина МакФерсон учится в консервативной католической школе в Сакраменто. " +
                "Она ищет себя; своё место в мире и пытается быть не похожей на других. Её волосы выкрашены в странный красно-розовый цвет; " +
                "а имя Леди Бёрд'", discriptionFilm);

        List<ElementHandle> textStickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            textStickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("fP => fP.innerText='Автотест'", textStickerAll.get(i));
        }

        ElementHandle videoFilm = page.querySelector("//video[@src]");
        page.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')", videoFilm);

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameFilmInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("fP => fP.innerText='Название передачи'", nameFilmInPlayer);

        List<ElementHandle> progressVideoAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']").size(); i++) {
            progressVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
            page.evaluate("pV => pV.innerText='0'", progressVideoAll.get(i));
        }
        List<ElementHandle> posterFilmAll;
        List<ElementHandle> titleFilmAll;
        List<ElementHandle> descriptionTextFilmAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterFilmAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/d7/c5/ffb7d649f8a4cec74734d2effeb715f8e6e9/tile__web-wp.webp);')", posterFilmAll.get(i));
            titleFilmAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название фильма'", titleFilmAll.get(i));
            descriptionTextFilmAll = page.querySelectorAll("//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
            page.evaluate("d => d.textContent='2021, Жанр'", descriptionTextFilmAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        List<ElementHandle> stickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            stickerAll = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("s => s.remove();", stickerAll.get(i));
        }
        // делаем скриншот страницы "cardFilmForAuthorized":
        vrt.track(
                "cardFilmForAuthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setTimeout(10000))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}

