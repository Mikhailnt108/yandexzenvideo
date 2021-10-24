package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.pageHeadfull;
import static base.TestBasePlaywright.vrt;


public class CardFilmPW extends BasePagePlaywright {
    private Page page;

    public CardFilmPW(Page page) {
        this.page = page;
    }

    public void checkOpenCardFilm() {
        page.waitForSelector("//span[@itemprop='name' and text()='Фильмы']");
    }

    public void paymentESTForFilm() {
        if (page.querySelectorAll("//span[contains(text(),'Навсегда за')]").size() != 0) {
            page.click("//span[contains(text(),'Навсегда за')]");
            page.waitForSelector("(//button[@class='_3W3bxW5DPDIV5i4O3588XI'])[1]");
            page.click("(//button[@class='_3W3bxW5DPDIV5i4O3588XI'])[1]");
            page.waitForSelector("//span[text()='Подтвердить']");
            page.click("//span[text()='Подтвердить']");
            page.reload();
            page.waitForSelector("//span[text()='Смотреть']");
        }
    }
    public void paymentRent2ForFilm() {
        page.waitForSelector("//span[contains(text(), 'На 48 часов за')]");
        page.click("//span[contains(text(), 'На 48 часов за')]");
        page.waitForSelector("//h2[text()='Аренда фильма на 48 часов']");
        page.click("//span[text()='+7 926 019 21 44']|//span[text()='+7 926 020 50 27']|//span[text()='+7 926 017 22 79']");
        page.waitForSelector("//h1[contains(text(), 'Подтверждение оплаты фильма')]");
        page.click("//span[text()='Подтвердить']");
        page.waitForSelector("//span[contains(text(), 'Смотреть до')]");
        }

    public void checkStartTrailerPlayer() throws InterruptedException {
        //автозапуск плеера:
        Thread.sleep(3000);
        if(page.querySelectorAll("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").size() < 1){
            page.click("//button[text()='Трейлер']");
        }
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        List<ElementHandle> timeBeforeAllElements = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi'][position()<7]");
        String[] timeBeforeText = new String[timeBeforeAllElements.size()];
        int a=0;
        for(ElementHandle textNumberTimeBefore : timeBeforeAllElements){
            timeBeforeText[a]= textNumberTimeBefore.innerText();
            a++;
        }
        Integer[] timeBeforeAllNumber=new Integer[timeBeforeText.length];
        int b=0;
        for(String numberTimeBefore :timeBeforeText){
            timeBeforeAllNumber[b]=Integer.parseInt(numberTimeBefore);
            b++;
            System.out.println("numberTimeBefore:" + numberTimeBefore);
        }
        Thread.sleep(7000);
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        List<ElementHandle> timeAfterAllElements = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi'][position()<7]");
        String[] timeAfterText = new String[timeAfterAllElements.size()];
        int c=0;
        for(ElementHandle textNumberTimeAfter : timeAfterAllElements){
            timeAfterText[c]= textNumberTimeAfter.innerText();
            c++;
        }
        Integer[] timeAfterAllNumber=new Integer[timeAfterText.length];
        int d=0;
        for(String numberTimeAfter :timeAfterText){
            timeAfterAllNumber[d]=Integer.parseInt(numberTimeAfter);
            d++;
            System.out.println("numberTimeAfter:" + numberTimeAfter);
        }
        for (int e = 0; e < timeBeforeAllNumber.length; e++){
            Assert.assertTrue("bug: время After НЕ больше времени Before",timeAfterAllNumber[timeBeforeAllNumber.length-1] > timeBeforeAllNumber[timeBeforeAllNumber.length-1]);
        }
    }

    public void moveSliderRewindToVideoPlayerHeadfull() {
        pageHeadfull.waitForTimeout(5000);
        //нажать "Смотреть" - видео запустилось
        pageHeadfull.click("//span[contains(text(), 'Смотреть')]|//span[(text()='Продолжить просмотр')]");
        pageHeadfull.waitForTimeout(5000);
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        pageHeadfull.waitForTimeout(5000);
        //переместить слайдер на середину прогресс бара:
        ElementHandle progressBar = pageHeadfull.querySelector("(//div[@class='_1y3ojG7nWNTRJiI_87BjFx'])[1]");
        progressBar.click();
        //кликнуть в середину прогресс бара:
        pageHeadfull.click("(//div[@class='_2xKeEBccHr0M7TaONTh33M'])[1]");
        pageHeadfull.waitForTimeout(5000);
    }

    public void checkImageCardFilmForGuest() throws IOException, InterruptedException {
        // подготовка карточки фильма к скриншот-тесту:
        if(page.querySelectorAll("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']").size() > 1){
            ElementHandle blockSimilar = page.querySelector("//div[@class='_2YrnCSEViX2PQLwVrBYiS0']");
            blockSimilar.evaluate("bS => bS.remove();");
        }
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']");
        ElementHandle nameFilmCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        nameFilmCrumbs.evaluate("n => n.innerText='Название фильма'");

        ElementHandle nameFilm = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameFilm.evaluate("nC => nC.innerText='Название фильма'");

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
        ageYearGenres.evaluate("d => d.innerText='18+, 2021, Жанр'");

        ElementHandle discriptionFilm = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        discriptionFilm.evaluate("g => g.innerText='Кристина МакФерсон учится в консервативной католической школе в Сакраменто. " +
                "Она ищет себя; своё место в мире и пытается быть не похожей на других. Её волосы выкрашены в странный красно-розовый цвет; " +
                "а имя Леди Бёрд'");

        ElementHandle videoFilm = page.querySelector("//video[@src]");
        videoFilm.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle nameFilmInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        nameFilmInPlayer.evaluate("fP => fP.innerText='Название фильма'");

        List<ElementHandle> timeProgressVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
        for(ElementHandle timeProgressVideo : timeProgressVideoAll){
            timeProgressVideo.evaluate("pV => pV.innerText='0'");
        }
        if(page.querySelectorAll("//span[@class='tAP2pLkM7Aktd4cKGGa5N']").size()!=0){
            ElementHandle bottomText = page.querySelector("//span[@class='tAP2pLkM7Aktd4cKGGa5N']");
            bottomText.evaluate("bT => bT.remove();");
        }

        if(page.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')]").size() > 1){
            ElementHandle secondButton = page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')])[2]");
            secondButton.evaluate("sB => sB.remove();");
        }
        ElementHandle textPayButton = page.querySelector("//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']");
        textPayButton.evaluate("fP => fP.innerText='Навсегда за 100 ₽'");

        List<ElementHandle> textStickerAll = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle textSticker : textStickerAll){
            textSticker.evaluate("fP => fP.innerText='Автотест'");
        }
        List<ElementHandle> posterFilmAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for(ElementHandle posterFilm : posterFilmAll){
            posterFilm.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/d7/c5/ffb7d649f8a4cec74734d2effeb715f8e6e9/tile__web-wp.webp);')");
        }

//        List<ElementHandle> titleFilmAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
//        for(ElementHandle titleFilm : titleFilmAll){
//            titleFilm.evaluate("t => t.innerText='Название фильма'");
//        }
//        List<ElementHandle> descriptionTextFilmAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
//        for(ElementHandle descriptionTextFilm : descriptionTextFilmAll){
//            descriptionTextFilm.evaluate("d => d.textContent='2021, Жанр'");
//        }
//        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
//        for(ElementHandle age : ageAll){
//            age.evaluate("a => a.innerText='18+'");

        List<ElementHandle> stickerTailCollectAll = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stickerTailCollect : stickerTailCollectAll){
            stickerTailCollect.evaluate("s => s.remove();");
        }
        if(page.querySelectorAll("//div[@class='_1rFI0KDcQjaCwgg4CshFS8']").size()!=0){
            page.evaluate("s => s.remove();", page.querySelector("//div[@class='_1rFI0KDcQjaCwgg4CshFS8']"));
        }

        // делаем скриншот страницы "CardFilmForGuest":
        vrt.track(
                "cardFilmForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCardFilmForUser() throws IOException, InterruptedException {
        // подготовка карточки фильма к скриншот-тесту:
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']");
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");
        ElementHandle nameFilmCrumbsUser = page.querySelector("(//span[@itemprop='name'])[3]");
        nameFilmCrumbsUser.evaluate("n => n.innerText='Название фильма'");

        ElementHandle nameFilmUser = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameFilmUser.evaluate("nC => nC.innerText='Название фильма'");

        List<ElementHandle> ratingFilmCountAllUser = page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        if (ratingFilmCountAllUser.size() > 1) {
            while (page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size() != 1) {
                page.evaluate("dR => dR.remove();", page.querySelector("(//div[@class='SSy1FiFkrq7A1RhDYt-Xx'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']").size());
            }
        }
        ElementHandle ratingFilmUser = page.querySelector("//div[@class='SSy1FiFkrq7A1RhDYt-Xx']");
        ratingFilmUser.evaluate("fP => fP.innerText='IMDb: 8.8'");

        ElementHandle ageYearGenresUser = page.querySelector("//div[@class='_1v_D6wOANknQeJMBPo_rKK']");
        ageYearGenresUser.evaluate("d => d.innerText='18+, 2021, Жанр'");

        ElementHandle discriptionFilmUser = page.querySelector("//span[@class='_139cuGvs1A6AM-bkfvot7S']");
        discriptionFilmUser.evaluate("g => g.innerText='Кристина МакФерсон учится в консервативной католической школе в Сакраменто. " +
                "Она ищет себя; своё место в мире и пытается быть не похожей на других. Её волосы выкрашены в странный красно-розовый цвет; " +
                "а имя Леди Бёрд'");

        ElementHandle videoFilmUser = page.querySelector("//video[@src]");
        videoFilmUser.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle nameFilmInPlayerUser = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        nameFilmInPlayerUser.evaluate("fP => fP.innerText='Название фильма'");

        List<ElementHandle> timeProgressVideoAllUser = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
        for(ElementHandle timeProgressVideo : timeProgressVideoAllUser){
            timeProgressVideo.evaluate("pV => pV.innerText='0'");
        }

        List<ElementHandle> textStickerAllUser = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle textSticker : textStickerAllUser){
            textSticker.evaluate("fP => fP.innerText='Автотест'");
        }
        List<ElementHandle> posterFilmAllUser = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for(ElementHandle posterFilm : posterFilmAllUser){
            posterFilm.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); " +
                    "background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/d7/c5/ffb7d649f8a4cec74734d2effeb715f8e6e9/tile__web-wp.webp);')");
        }
        List<ElementHandle> titleFilmAllUser = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
        for(ElementHandle titleFilm : titleFilmAllUser){
            titleFilm.evaluate("t => t.innerText='Название фильма'");
        }
        List<ElementHandle> descriptionTextFilmAllUser = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for(ElementHandle descriptionTextFilm : descriptionTextFilmAllUser){
            descriptionTextFilm.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAllUser = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAllUser){
            age.evaluate("a => a.innerText='18+'");
        }
        ElementHandle textPayButton = page.querySelector("//span[@class='_3Y5HJDtaQ_RV6kFCsByyzz']//span[2]");
        textPayButton.evaluate("fP => fP.innerText='Смотреть'");

        List<ElementHandle> stickerTailCollectAllUser = page.querySelectorAll("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='kjFUbLahFxqq2AjHY8j2R']");
        for(ElementHandle stickerTailCollect : stickerTailCollectAllUser){
            stickerTailCollect.evaluate("s => s.remove();");
        }
        if(page.querySelectorAll("//div[@class='_1rFI0KDcQjaCwgg4CshFS8']").size()!=0){
            page.evaluate("s => s.remove();", page.querySelector("//div[@class='_1rFI0KDcQjaCwgg4CshFS8']"));
        }

        // делаем скриншот страницы "cardFilmForUser":
        vrt.track(
                "cardFilmForUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void openFirstCardFilmFromPackageKinoPoPodpiskeHeadfull() {
        // открыть карточку фильма:
        pageHeadfull.click("(//a[@data-test='PackageLink'])[1]");
    }
}

