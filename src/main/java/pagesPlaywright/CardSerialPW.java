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

public class CardSerialPW extends BasePagePlaywright {
    private Page page;

    public CardSerialPW(Page page) {
        this.page = page;
    }

    public void checkOpenCardSerial() {
        page.waitForSelector("//a[@href='/shows']//span[1]");
        page.waitForTimeout(5000);
    }

    public void checkStartTrailerPlayer() throws InterruptedException {
        //автозапуск плеера:
        page.waitForTimeout(10000);
        if(page.querySelectorAll("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").size() < 1){
            page.click("//button[text()='Трейлер']");
        }
        String timeStart = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        page.waitForTimeout(5000);
        String timeEnd = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Assert.assertNotEquals(timeStart, timeEnd);
    }

    public void checkImageCardSerialForGuest() throws IOException, InterruptedException {
        // подготовка карточки сериала к скриншот-тесту:
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        if (page.querySelectorAll("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Сезон 1']").size() != 1) {
            page.click("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR' and text()='Сезон 1']");
        }
        List<ElementHandle> tabInactiveAll = page.querySelectorAll("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR']");
        for (ElementHandle tabInactive : tabInactiveAll) {
            tabInactive.evaluate("s => s.remove();");
        }
        // блок серий сезона:
        List<ElementHandle> posterEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for (ElementHandle posterEpisode : posterEpisodeAll) {
            posterEpisode.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Episode/65/b2/6782d0bff8b356624589f1ac7fa922d6916b/tile__web-wp.webp);')");
        }
        List<ElementHandle> titleEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//h3[@data-test='PackageDescriptionTitle']");
        for (ElementHandle titleEpisode : titleEpisodeAll) {
            titleEpisode.evaluate("t => t.innerText='Серия №'");
        }
        List<ElementHandle> descriptionTextEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
        for (ElementHandle descriptionTextEpisode : descriptionTextEpisodeAll) {
            descriptionTextEpisode.evaluate("d => d.textContent='Серия №'");
        }
        List<ElementHandle> ageEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for (ElementHandle ageEpisode : ageEpisodeAll) {
            ageEpisode.evaluate("a => a.innerText='18+'");
        }
        // блок подборки "Похожие":
        List<ElementHandle> posterSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for (ElementHandle posterSerial : posterSerialAll) {
            posterSerial.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Episode/b5/a8/e6ec08a5c91dc86d9a53d02c4a40f63bd8bc/tile__web-wp.webp);')");
        }
        List<ElementHandle> titleSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//h3[@data-test='PackageDescriptionTitle']");
        for (ElementHandle titleSerial : titleSerialAll) {
            titleSerial.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> descriptionTextSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
        for (ElementHandle descriptionTextSerial : descriptionTextSerialAll) {
            descriptionTextSerial.evaluate("d => d.textContent='1 сезон, Жанр'");
        }
        List<ElementHandle> ageSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        ;
        for (ElementHandle ageSerial : ageSerialAll) {
            ageSerial.evaluate("a => a.innerText='18+'");
        }
        ElementHandle nameSerialCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        nameSerialCrumbs.evaluate("n => n.innerText='Название сериала'");

        ElementHandle nameSerial = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameSerial.evaluate("nC => nC.innerText='Название сериала'");

        List<ElementHandle> ratingFilmCountAll = page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        if (ratingFilmCountAll.size() > 1) {
            while (page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size() != 1) {
                page.evaluate("dR => dR.remove();", page.querySelector("(//div[@class='SSy1FiFkrq7A1RhDYt-Xx'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size());
            }
        }
        ElementHandle ratingFilm = page.querySelector("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");

        ElementHandle ageYearGenres = page.querySelector("//div[@class='_1v_D6wOANknQeJMBPo_rKK']");
        ageYearGenres.evaluate("d => d.innerText='18+, 2021, 1 сезон, Жанр'");

        ElementHandle discriptionSerial = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        discriptionSerial.evaluate("g => g.innerText='Зрелищная фэнтези-драма от создателей «Баффи — истребительницы вампиров». Лондон Викторианской эпохи. " +
                "Героиням и героям сериала достаются сверхъестественные способности. Они объединяются, чтобы защитить себе подобных от преследований. " +
                "Однако вместе с большим даром приходит большая ответственность: великая сила может стать клеймом, а ее носители — изгоями. «Невероятные» " +
                "— это остроумный коктейль из красочного экшена и философской драмы, который предлагает новый взгляд на супергероику.'");

        ElementHandle text1SubscribeButton = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        text1SubscribeButton.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'");

        ElementHandle text2SubscribeButton = page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]//div[text()])[1]");
        text2SubscribeButton.evaluate("t2B => t2B.innerText='В сервисе «START»'");

        ElementHandle text1SubscribeButtonSecond = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[2]");
        text1SubscribeButtonSecond.evaluate("tBS => tBS.innerText='Смотреть за 200 ₽/30 дней'");

        ElementHandle text2SubscribeButtonSecond = page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]//div[text()])[2]");
        text2SubscribeButtonSecond.evaluate("t2B => t2B.innerText='В пакете «Всё и сразу»'");

        ElementHandle videoFilm = page.querySelector("//video[@src]");
        videoFilm.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        List<ElementHandle> textStickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for (ElementHandle textSticker : textStickerAll) {
            textSticker.evaluate("fP => fP.innerText='Автотест'");
        }

        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for (ElementHandle sticker : stickerAll) {
            sticker.evaluate("s => s.remove();");
        }
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameFilmInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        nameFilmInPlayer.evaluate("fP => fP.innerText='Название сериала'");

        List<ElementHandle> progressVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");;
        for(ElementHandle progressVideo : progressVideoAll){
            progressVideo.evaluate("pV => pV.innerText='0'");
        }

        // делаем скриншот страницы "CardSerialForGuest":
        vrt.track(
                "cardSerialForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void checkImageCardSerialForUser() throws IOException, InterruptedException {
        //подготовка карточки сериала к скриншот-тесту:
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        if (page.querySelectorAll("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Сезон 1']").size() != 1) {
            page.click("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR' and text()='Сезон 1']");
        }
        List<ElementHandle> tabInactiveAll = page.querySelectorAll("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR']");
        for (ElementHandle tabInactive : tabInactiveAll) {
            tabInactive.evaluate("s => s.remove();");
        }
        if(page.querySelectorAll("//span[@class='tAP2pLkM7Aktd4cKGGa5N']").size() !=0){
            page.querySelector("//span[@class='tAP2pLkM7Aktd4cKGGa5N']").evaluate("bT => bT.remove();");
        }
        // блок серий сезона:
        List<ElementHandle> posterEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for (ElementHandle posterEpisode : posterEpisodeAll) {
            posterEpisode.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Episode/65/b2/6782d0bff8b356624589f1ac7fa922d6916b/tile__web-wp.webp);')");
        }
        List<ElementHandle> titleEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//h3[@data-test='PackageDescriptionTitle']");
        for (ElementHandle titleEpisode : titleEpisodeAll) {
            titleEpisode.evaluate("t => t.innerText='Серия №'");
        }
        List<ElementHandle> descriptionTextEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
        for (ElementHandle descriptionTextEpisode : descriptionTextEpisodeAll) {
            descriptionTextEpisode.evaluate("d => d.textContent='Серия №'");
        }
        List<ElementHandle> ageEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for (ElementHandle ageEpisode : ageEpisodeAll) {
            ageEpisode.evaluate("a => a.innerText='18+'");
        }
        // блок подборки "Похожие":
        List<ElementHandle> posterSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for (ElementHandle posterSerial : posterSerialAll) {
            posterSerial.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Episode/b5/a8/e6ec08a5c91dc86d9a53d02c4a40f63bd8bc/tile__web-wp.webp);')");
        }
        List<ElementHandle> titleSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//h3[@data-test='PackageDescriptionTitle']");
        for (ElementHandle titleSerial : titleSerialAll) {
            titleSerial.evaluate("t => t.innerText='Название сериала'");
        }
        List<ElementHandle> descriptionTextSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
        for (ElementHandle descriptionTextSerial : descriptionTextSerialAll) {
            descriptionTextSerial.evaluate("d => d.textContent='1 сезон, Жанр'");
        }
        List<ElementHandle> ageSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        ;
        for (ElementHandle ageSerial : ageSerialAll) {
            ageSerial.evaluate("a => a.innerText='18+'");
        }
        ElementHandle nameSerialCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        nameSerialCrumbs.evaluate("n => n.innerText='Название сериала'");

        ElementHandle nameSerial = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameSerial.evaluate("nC => nC.innerText='Название сериала'");

        List<ElementHandle> ratingFilmCountAll = page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        if (ratingFilmCountAll.size() > 1) {
            while (page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size() != 1) {
                page.evaluate("dR => dR.remove();", page.querySelector("(//div[@class='SSy1FiFkrq7A1RhDYt-Xx'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size());
            }
        }
        ElementHandle ratingFilm = page.querySelector("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        ratingFilm.evaluate("fP => fP.innerText='IMDb: 8.8'");

        ElementHandle ageYearGenres = page.querySelector("//div[@class='_1v_D6wOANknQeJMBPo_rKK']");
        ageYearGenres.evaluate("d => d.innerText='18+, 2021, 1 сезон, Жанр'");

        ElementHandle discriptionSerial = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        discriptionSerial.evaluate("g => g.innerText='Зрелищная фэнтези-драма от создателей «Баффи — истребительницы вампиров». Лондон Викторианской эпохи. " +
                "Героиням и героям сериала достаются сверхъестественные способности. Они объединяются, чтобы защитить себе подобных от преследований. " +
                "Однако вместе с большим даром приходит большая ответственность: великая сила может стать клеймом, а ее носители — изгоями. «Невероятные» " +
                "— это остроумный коктейль из красочного экшена и философской драмы, который предлагает новый взгляд на супергероику.'");

        ElementHandle videoFilm = page.querySelector("//video[@src]");
        videoFilm.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        List<ElementHandle> textStickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for (ElementHandle textSticker : textStickerAll) {
            textSticker.evaluate("fP => fP.innerText='Автотест'");
        }

        List<ElementHandle> stickerAll = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for (ElementHandle sticker : stickerAll) {
            sticker.evaluate("s => s.remove();");
        }

        ElementHandle nameFilmInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        nameFilmInPlayer.evaluate("fP => fP.innerText='Название сериала'");

        List<ElementHandle> progressVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");;
        for(ElementHandle progressVideo : progressVideoAll){
            progressVideo.evaluate("pV => pV.innerText='0'");
        }
        // делаем скриншот страницы "CardSerialForUser":
        vrt.track(
                "cardSerialForUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void subscribeToPackageSerials() {
            page.waitForSelector("//span[contains(text(),'Смотреть за')]|//span[contains(text(),'Подключить за')]|//span[contains(text(),'Смотреть бесплатно')]");
            page.click("//span[contains(text(),'Смотреть за')]|//span[contains(text(),'Подключить за')]|//span[contains(text(),'Смотреть бесплатно')]");
            page.waitForSelector("//button[text()='Подтвердить']|//button[text()='Принять и подключить']");
            page.click("//button[text()='Подтвердить']|//button[text()='Принять и подключить']");
            page.waitForSelector("//button[text()='Закрыть']");
            page.click("//button[text()='Закрыть']");
            page.reload();
            page.waitForSelector("//span[text()='Смотреть']");
        }

    public void checkImageBlockSeason() throws IOException, InterruptedException {
        // блок серий сезона:
        if (page.querySelectorAll("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Сезон 1']").size() != 1) {
            page.click("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR' and text()='Сезон 1']");
        }
        ElementHandle blockSeason = page.querySelector("//div[@class='_1hdhJYYoLFCYFGUtF3teH1']");
        List<ElementHandle> tabSeasonAll;
        for (int i = 0; i < page.querySelectorAll("//div[contains(@class,'_3wMaR3IGI1XaT9LZR5skLR')]").size(); i++) {
            tabSeasonAll = page.querySelectorAll("//div[contains(@class,'_3wMaR3IGI1XaT9LZR5skLR')]");
            page.evaluate("t => t.innerText='Сезон №'", tabSeasonAll.get(i));
        }

        List<ElementHandle> posterEpisodelAll;
        List<ElementHandle> titleEpisodeAll;
        List<ElementHandle> descriptionTextEpisodeAll;
        List<ElementHandle> ageEpisodeAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterEpisodelAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: " +
                    "url(https://static-sesure.cdn.megafon.tv/images/Episode/65/b2/6782d0bff8b356624589f1ac7fa922d6916b/tile__web-wp.webp);')", posterEpisodelAll.get(i));
            titleEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Серия №'", titleEpisodeAll.get(i));
            descriptionTextEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
            page.evaluate("d => d.textContent='Серия №'", descriptionTextEpisodeAll.get(i));
            ageEpisodeAll = page.querySelectorAll("//div[@class='_1kMQpAljicp8DbFePR8tx5']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageEpisodeAll.get(i));
        }

        // делаем скриншот элемента "blockSeason":
        vrt.track(
                "blockSeason",
                Base64.getEncoder().encodeToString(blockSeason.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToButtonWatchHeadfull() {
        pageHeadfull.waitForSelector("//span[text()='Смотреть']");
        pageHeadfull.click("//span[text()='Смотреть']");
    }

    public void checkImageSwitchEpisodeInPlayerHeadfull() throws IOException, InterruptedException {
        ElementHandle videoSerial = pageHeadfull.querySelector("//video[@src]");
        videoSerial.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        pageHeadfull.waitForSelector("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]");
        pageHeadfull.click("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]");
        pageHeadfull.waitForTimeout(3000);
        List<ElementHandle> progressTimerVideoAll = pageHeadfull.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");;
        for(ElementHandle progressTimerVideo : progressTimerVideoAll){
            progressTimerVideo.evaluate("pV => pV.innerText='0'");
        }

        List<ElementHandle> tabSeasonInPlayerAll = pageHeadfull.querySelectorAll("//div[@class='_2pIs_2pQWfayxBenlBjOHG']");
        for(ElementHandle tabSeasonInPlayer : tabSeasonInPlayerAll){
            tabSeasonInPlayer.evaluate("pV => pV.innerText='Сезон №'");
        }

        ElementHandle progressBarVideoAll = pageHeadfull.querySelector("(//div[@class='_3uP0ihiEVqMOuIXkcIlhiL'])[1]");
        progressBarVideoAll.evaluate("pB => pB.setAttribute('style', 'width: 50%;')");


        List<ElementHandle> progressBar2VideoAll = pageHeadfull.querySelectorAll("//div[@class='_8P6azv71zJfQn_JeUD36Z']");
        for(ElementHandle progressBar2Video : progressBar2VideoAll){
            progressBar2Video.evaluate("pB2 => pB2.setAttribute('style', 'width: 50%;')");
        }
        List<ElementHandle> titleNameEpisodeAll = pageHeadfull.querySelectorAll("//div[@class='_11XQ2D9tsITknHC5rpvrbB']");
        for(ElementHandle titleNameEpisode : titleNameEpisodeAll){
            titleNameEpisode.evaluate("tNE => tNE.innerText='Серия №'");
        }
        List<ElementHandle> discriptionEpisodeAll = pageHeadfull.querySelectorAll("//div[@class='_3UzxwVei8FqE-DF7wGsanh']");
        for(ElementHandle discriptionEpisode : discriptionEpisodeAll){
            discriptionEpisode.evaluate("dE => dE.innerText='Cерия №, Сезон №'");
        }
        List<ElementHandle> posterEpisodeAll = pageHeadfull.querySelectorAll("//div[@class='_1xy-z0WAeLX75yKO6LzXLR']");
        for(ElementHandle posterEpisode : posterEpisodeAll){
            posterEpisode.evaluate("pB2 => pB2.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Episode/35/c7/25a6de33d807999dd39fc6e1f0c19d9be414/tile__web-wp.webp);')");
        }
        ElementHandle switchEpisodeInPlayer = pageHeadfull.querySelector("//div[@class='_225UkJHx_nI4_qaJ2XxLnH']");
        pageHeadfull.waitForTimeout(3000);
        // делаем скриншот элемента "switchEpisodeInPlayer":
        vrt.track(
                "switchEpisodeInPlayer",
                Base64.getEncoder().encodeToString(switchEpisodeInPlayer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImagePopUpSubscription() throws IOException, InterruptedException {
        page.evaluate("window.scrollTo(0, 500);");
        page.waitForTimeout(5000);
        if (page.querySelectorAll("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Сезон 1']").size() != 1) {
            page.click("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR' and text()='Сезон 1']");
        }
        page.click("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");

        List<ElementHandle> buttonSubscription = page.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _3f0wpWSLNwEn9_twVy01wx')]");
        if (buttonSubscription.size() > 2) {
            while (page.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _3f0wpWSLNwEn9_twVy01wx')]").size() != 3) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _3f0wpWSLNwEn9_twVy01wx')])[last()]"));
                System.out.println(page.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _3f0wpWSLNwEn9_twVy01wx')]").size());
            }
        }

        ElementHandle text1SubscribeButtonPopUp = page.querySelector("(//div[@aria-label='Popup']//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        page.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'", text1SubscribeButtonPopUp);

        ElementHandle text2SubscribeButtonPopUp = page.querySelector("(//div[@aria-label='Popup']//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]//div[text()])[1]");
        page.evaluate("t2B => t2B.innerText='В сервисе «START»'", text2SubscribeButtonPopUp);

        ElementHandle text1SubscribeButtonSecondPopUp = page.querySelector("(//div[@aria-label='Popup']//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[2]");
        page.evaluate("tBS => tBS.innerText='Смотреть за 200 ₽/30 дней'", text1SubscribeButtonSecondPopUp);

        ElementHandle text2SubscribeButtonSecondPopUp = page.querySelector("(//div[@aria-label='Popup']//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]//div[text()])[2]");
        page.evaluate("t2B => t2B.innerText='В пакете «Всё и сразу»'", text2SubscribeButtonSecondPopUp);


        ElementHandle popUpSubscription = page.querySelector("//div[@aria-label='Popup']");

        // делаем скриншот элемента "popUpSubscription":
        vrt.track(
                "popUpSubscription",
                Base64.getEncoder().encodeToString(popUpSubscription.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void moveSliderRewindToVideoPlayerHeadfull() {
        pageHeadfull.waitForTimeout(7000);
        //нажать "Смотреть" - видео запустилось
        pageHeadfull.click("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]");
        pageHeadfull.waitForTimeout(7000);
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        pageHeadfull.waitForTimeout(7000);
        //переместить слайдер на середину прогресс бара:
        ElementHandle progressBar = pageHeadfull.querySelector("(//div[@class='_1y3ojG7nWNTRJiI_87BjFx'])[1]");
        progressBar.click();
        //кликнуть в середину прогресс бара:
        pageHeadfull.click("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]");
        pageHeadfull.waitForTimeout(7000);
    }

    public void goToPackagesPageHeadfull() {
        pageHeadfull.navigate("https://web-preprod2.megafon.tv/packages");
    }

    public void openFirstCardSerialFromPackageKinoPoPodpiskeHeadfull() {
        // открыть первую карточку сериала:
        pageHeadfull.click("(//div[text()='Сериалы'])[3]");
        pageHeadfull.click("(//a[@class='_8m5mByCjTuND14zuGKagi'])[1]");
    }

    public void openSecondCardSerialFromPackageKinoPoPodpiskeHeadfull() {
        // открыть вторую карточку сериала:
        pageHeadfull.click("(//div[text()='Сериалы'])[3]");
        pageHeadfull.click("(//a[@class='_8m5mByCjTuND14zuGKagi'])[2]");
    }

    public void openThirdCardSerialFromPackageKinoPoPodpiskeHeadfull() {
        // открыть вторую карточку сериала:
        pageHeadfull.click("(//div[text()='Сериалы'])[3]");
        pageHeadfull.click("(//a[@class='_8m5mByCjTuND14zuGKagi'])[3]");
    }

    public void checkStartVideoPlayerHeadfull() {
        //запуск плеера:
        pageHeadfull.waitForTimeout(5000);
        if(pageHeadfull.querySelectorAll("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").size() < 1){
            pageHeadfull.click("//button[text()='Трейлер']");
        }
        String timeStart = pageHeadfull.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        pageHeadfull.waitForTimeout(5000);
        String timeEnd = pageHeadfull.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Assert.assertNotEquals(timeStart, timeEnd);
    }
}


