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

public class CardSerialPW extends BasePagePlaywright {
    private Page page;

    public CardSerialPW(Page page) {
        this.page = page;
    }

    public void checkOpenCardSerial() {
        page.waitForSelector("//a[@href='/shows']//span[1]");
        page.waitForTimeout(5000);
    }

    public void checkAutoStartTrailerPlayer() throws InterruptedException {
        Thread.sleep(5000);
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        String timeStart = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Thread.sleep(5000);
        String timeEnd = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Assert.assertNotEquals(timeStart, timeEnd);
    }

    public void checkImageCardSerialForUnauthorized() throws IOException, InterruptedException {
        page.reload();
        if (page.querySelectorAll("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Сезон 1']").size() != 1) {
            page.click("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR' and text()='Сезон 1']");
        }
        List<ElementHandle> tabInactiveAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR']").size(); i++) {
            tabInactiveAll = page.querySelectorAll("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR']");
            page.evaluate("s => s.remove();", tabInactiveAll.get(i));
        }
        // блок серий сезона:
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

        // блок подборки "Похожие":
        List<ElementHandle> posterSerialAll;
        List<ElementHandle> titleSerialAll;
        List<ElementHandle> descriptionTextSerialAll;
        List<ElementHandle> ageSeriaLAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: " +
                    "url(https://static-sesure.cdn.megafon.tv/images/Episode/b5/a8/e6ec08a5c91dc86d9a53d02c4a40f63bd8bc/tile__web-wp.webp);')", posterSerialAll.get(i));
            titleSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название сериала'", titleSerialAll.get(i));
            descriptionTextSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
            page.evaluate("d => d.textContent='1 сезон, Жанр'", descriptionTextSerialAll.get(i));
            ageSeriaLAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageSeriaLAll.get(i));
        }

        ElementHandle nameSerialCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название сериала'", nameSerialCrumbs);

        ElementHandle nameSerial = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("nC => nC.innerText='Название сериала'", nameSerial);

        List<ElementHandle> ratingSerialAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size(); i++) {
            ratingSerialAll = page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
            page.evaluate("fP => fP.innerText='IMDb: 8.8'", ratingSerialAll.get(i));
        }
        List<ElementHandle> ratingSerialCountAll = page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        if (ratingSerialCountAll.size() > 2) {
            while (page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size() != 2) {
                page.evaluate("dR => dR.remove();", page.querySelector("(//div[@class='SSy1FiFkrq7A1RhDYt-Xx'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size());
            }
        }
        if (ratingSerialCountAll.size() < 2) {
            while (page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size() != 2) {
                page.evaluate("newDie => newDie.appendChild(document.getElementsByClassName('SSy1FiFkrq7A1RhDYt-Xx')[0].cloneNode(true));", page.querySelector("//div[@class='KQ2rb7ZP-tTmXFu9sn_34']"));
                System.out.println(page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size());
            }
        }

        ElementHandle ageYearGenres = page.querySelector("//div[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("d => d.innerText='18+, 2021, 1 сезон, Жанр'", ageYearGenres);

        ElementHandle discriptionSerial = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        page.evaluate("g => g.innerText='Зрелищная фэнтези-драма от создателей «Баффи — истребительницы вампиров». Лондон Викторианской эпохи. " +
                "Героиням и героям сериала достаются сверхъестественные способности. Они объединяются, чтобы защитить себе подобных от преследований. " +
                "Однако вместе с большим даром приходит большая ответственность: великая сила может стать клеймом, а ее носители — изгоями. «Невероятные» " +
                "— это остроумный коктейль из красочного экшена и философской драмы, который предлагает новый взгляд на супергероику.'", discriptionSerial);

        ElementHandle text1SubscribeButton = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        page.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'", text1SubscribeButton);

        ElementHandle text2SubscribeButton = page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]//div[text()])[1]");
        page.evaluate("t2B => t2B.innerText='В сервисе «START»'", text2SubscribeButton);

        ElementHandle text1SubscribeButtonSecond = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[2]");
        page.evaluate("tBS => tBS.innerText='Смотреть за 200 ₽/30 дней'", text1SubscribeButtonSecond);

        ElementHandle text2SubscribeButtonSecond = page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]//div[text()])[2]");
        page.evaluate("t2B => t2B.innerText='В пакете «Всё и сразу»'", text2SubscribeButtonSecond);

        ElementHandle videoFilm = page.querySelector("//video[@src]");
        page.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')", videoFilm);

        List<ElementHandle> textStickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            textStickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("fP => fP.innerText='Автотест'", textStickerAll.get(i));
        }

        List<ElementHandle> stickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            stickerAll = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("s => s.remove();", stickerAll.get(i));
        }

        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameFilmInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("fP => fP.innerText='Название сериала'", nameFilmInPlayer);

        List<ElementHandle> progressVideoAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']").size(); i++) {
            progressVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
            page.evaluate("pV => pV.innerText='0'", progressVideoAll.get(i));
        }


        // делаем скриншот страницы "CardSerialForUnauthorized":
        vrt.track(
                "cardSerialForUnauthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void checkImageCardSerialForAuthorized() throws IOException, InterruptedException {
        page.reload();

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        ElementHandle nameSerialCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название сериала'", nameSerialCrumbs);

        ElementHandle nameSerial = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("nC => nC.innerText='Название сериала'", nameSerial);

        List<ElementHandle> ratingSerialAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size(); i++) {
            ratingSerialAll = page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
            page.evaluate("fP => fP.innerText='IMDb: 8.8'", ratingSerialAll.get(i));
        }

        ElementHandle ageYearGenres = page.querySelector("//div[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("d => d.innerText='18+, 2021, 1 сезон, Жанр'", ageYearGenres);

        ElementHandle discriptionSerial = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        page.evaluate("g => g.innerText='Зрелищная фэнтези-драма от создателей «Баффи — истребительницы вампиров». Лондон Викторианской эпохи. " +
                "Героиням и героям сериала достаются сверхъестественные способности. Они объединяются, чтобы защитить себе подобных от преследований. " +
                "Однако вместе с большим даром приходит большая ответственность: великая сила может стать клеймом, а ее носители — изгоями. «Невероятные» " +
                "— это остроумный коктейль из красочного экшена и философской драмы, который предлагает новый взгляд на супергероику.'", discriptionSerial);

        ElementHandle videoFilm = page.querySelector("//video[@src]");
        page.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')", videoFilm);

        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameFilmInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("fP => fP.innerText='Название сериала'", nameFilmInPlayer);

        List<ElementHandle> progressVideoAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']").size(); i++) {
            progressVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
            page.evaluate("pV => pV.innerText='0'", progressVideoAll.get(i));
        }

        List<ElementHandle> textStickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            textStickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("fP => fP.innerText='Автотест'", textStickerAll.get(i));
        }

        ElementHandle bottomText = page.querySelector("//span[@class='tAP2pLkM7Aktd4cKGGa5N']");
        page.evaluate("tA => tA.innerText='Бесплатно по акции до 31 января 2021'", bottomText);

        if (page.querySelectorAll("//div[contains(@class,'_2efXVczynhUCLi_CJzGTuL') and text()='Сезон 1']").size() != 1) {
            page.click("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR' and text()='Сезон 1']");
        }

        List<ElementHandle> tabInactiveAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR']").size(); i++) {
            tabInactiveAll = page.querySelectorAll("//div[@class='_1LCYNI4dD8ao7p9rhd_Qcl _3wMaR3IGI1XaT9LZR5skLR']");
            page.evaluate("s => s.remove();", tabInactiveAll.get(i));
        }

        // блок серий сезона:
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

        // блок подборки "Похожие":
        List<ElementHandle> posterSerialAll;
        List<ElementHandle> titleSerialAll;
        List<ElementHandle> descriptionTextSerialAll;
        List<ElementHandle> ageSeriaLAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']").size(); i++) {
            posterSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
            page.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: " +
                    "url(https://static-sesure.cdn.megafon.tv/images/Episode/b5/a8/e6ec08a5c91dc86d9a53d02c4a40f63bd8bc/tile__web-wp.webp);')", posterSerialAll.get(i));
            titleSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//h3[@data-test='PackageDescriptionTitle']");
            page.evaluate("t => t.innerText='Название сериала'", titleSerialAll.get(i));
            descriptionTextSerialAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//span[@class='_3mvyhNdQM-dhsR11QU-BY9']//span");
            page.evaluate("d => d.textContent='1 сезон, Жанр'", descriptionTextSerialAll.get(i));
            ageSeriaLAll = page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageSeriaLAll.get(i));
        }

        List<ElementHandle> stickerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']").size(); i++) {
            stickerAll = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
            page.evaluate("s => s.remove();", stickerAll.get(i));
        }

        // делаем скриншот страницы "CardSerialForAuthorized":
        vrt.track(
                "cardSerialForAuthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }


    public void subscribeToPackageSerials() {
        if (page.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]").size() != 0) {
            page.click("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]");
            page.waitForSelector("//button[text()='Подтвердить']|//button[text()='Принять и подключить']");
            page.click("//button[text()='Подтвердить']|//button[text()='Принять и подключить']");
            page.waitForSelector("//button[text()='Закрыть']");
            page.click("//button[text()='Закрыть']");
            page.reload();
        }
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

    public void clickToButtonWatch() {
        page.click("//span[text()='Смотреть']");
    }

    public void checkImageSwitchEpisodeInPlayer() throws IOException, InterruptedException {
        ElementHandle videoFilm = page.querySelector("//video[@src]");
        page.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')", videoFilm);

        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        page.waitForSelector("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]");
        page.click("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]");

        List<ElementHandle> progressTimerVideoAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']").size(); i++) {
            progressTimerVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
            page.evaluate("pV => pV.innerText='0'", progressTimerVideoAll.get(i));
        }

        List<ElementHandle> tabSeasonInPlayerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2pIs_2pQWfayxBenlBjOHG']").size(); i++) {
            tabSeasonInPlayerAll = page.querySelectorAll("//div[@class='_2pIs_2pQWfayxBenlBjOHG']");
            page.evaluate("pV => pV.innerText='Сезон №'", tabSeasonInPlayerAll.get(i));
        }
        ElementHandle progressBarVideoAll = page.querySelector("(//div[@class='_3uP0ihiEVqMOuIXkcIlhiL'])[1]");
        page.evaluate("pB => pB.setAttribute('style', 'width: 50%;')", progressBarVideoAll);

        List<ElementHandle> progressBar2VideoAll;
        List<ElementHandle> titleNameEpisodeAll;
        List<ElementHandle> discriptionEpisodeAll;
        List<ElementHandle> posterEpisodeAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_8P6azv71zJfQn_JeUD36Z']").size(); i++) {
            progressBar2VideoAll = page.querySelectorAll("//div[@class='_8P6azv71zJfQn_JeUD36Z']");
            page.evaluate("pB2 => pB2.setAttribute('style', 'width: 50%;')", progressBar2VideoAll.get(i));
            titleNameEpisodeAll = page.querySelectorAll("//div[@class='_11XQ2D9tsITknHC5rpvrbB']");
            page.evaluate("tNE => tNE.innerText='Серия №'", titleNameEpisodeAll.get(i));
            discriptionEpisodeAll = page.querySelectorAll("//div[@class='_3UzxwVei8FqE-DF7wGsanh']");
            page.evaluate("dE => dE.innerText='Cерия №, Сезон №'", discriptionEpisodeAll.get(i));
            posterEpisodeAll = page.querySelectorAll("//div[@class='_1xy-z0WAeLX75yKO6LzXLR']");
            page.evaluate("pB2 => pB2.setAttribute('style', 'background-image: " +
                    "url(https://static-sesure.cdn.megafon.tv/images/Episode/35/c7/25a6de33d807999dd39fc6e1f0c19d9be414/tile__web-wp.webp);')", posterEpisodeAll.get(i));
        }
        ElementHandle switchEpisodeInPlayer = page.querySelector("//div[@class='_225UkJHx_nI4_qaJ2XxLnH']");

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

    public void moveSliderRewindToVideoPleer() {
        page.waitForTimeout(5000);
        //нажать "Смотреть" - видео запустилось
        page.click("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]");
        page.waitForTimeout(5000);
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        page.waitForTimeout(5000);
        //переместить слайдер на середину прогресс бара:
        ElementHandle progressBar = page.querySelector("(//div[@class='_1y3ojG7nWNTRJiI_87BjFx'])[1]");
        progressBar.click();
        //кликнуть в середину прогресс бара:
        page.click("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]");
        page.waitForTimeout(5000);
    }
}


