package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.pageHeadfull;
import static base.TestBasePlaywright.vrt;

public class CardTvProgramPW extends BasePagePlaywright {
    private Page page;
    private String frontend;

    public CardTvProgramPW(Page page, String frontend) {
        this.page = page;
        this.frontend = frontend;
    }

    public void checkImageCardCurrentTvProgramForGuest() throws IOException, InterruptedException {
        // подготовка видимой части страницы "CardTvProgram" к скриншот-тесту:
        page.waitForSelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _17D0GCdbbIdXkUxy-YT76O' and contains(@style,'url')]");
        ElementHandle imgTvProgram = page.querySelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _17D0GCdbbIdXkUxy-YT76O' and contains(@style,'url')]");
        page.evaluate("i => i.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/e7/fa/90062b0e28545455fb4c14768bb78c86318c/poster__aphone-xxhdpi.webp)')", imgTvProgram);

        ElementHandle nameTvProgram = page.querySelector("//h1[text()]");
        page.evaluate("nP => nP.innerText='Название передачи'", nameTvProgram);

        ElementHandle agePoster = page.querySelector("(//div[@class='_3vBdLAs_q6zHDlAspM6kFN' and text()])[2]");
        page.evaluate("aP => aP.innerText='18+'", agePoster);

        ElementHandle progressBar = page.querySelector("//span[@class='L3rzdT7KYzyE1ClBQKxNL' and contains(@style,'background-color')]");
        page.evaluate("i => i.setAttribute('style', 'width: 50%; height: 3px; background-color: var(--color-base);')", progressBar);

        ElementHandle dayTimeNameChannel = page.querySelector("//div[@class='_2xMMkjxj45XkX1x1g8ZxMm']//div[contains(text(),'Сегодня') or contains(text(),'Вчера')]");
        page.evaluate("d => d.innerText='Сегодня, 00:00, Название канала'", dayTimeNameChannel);

        ElementHandle description = page.querySelector("//span[contains(@class,'_3mmoBhU2y-bKK_rbQlrtvM') and text()]");
        page.evaluate("g => g.innerText='Фильм посвящен первым шагам человечества на пути освоения космоса и непосредственно " +
                "судьбе первого космонавта Ю. А. Гагарина. Основной лейтмотив - борьба за право быть первым: соревнование в первом отряде космонавтов; " +
                "конкуренция технологий в ракетостроении; противостояние сверхдержав - СССР и США. В первый отряд космонавтов отбирали из трёх тысяч " +
                "летчиков-истребителей по всей стране. В легендарную двадцатку попали лучшие из лучших. Кто из них полетит первым, не знал никто. " +
                "На этом пути пришлось бороться не только с земным притяжением...'", description);

        List<ElementHandle> timeInScheduleAll= page.querySelectorAll("//a[@class='_3S1RJTAMPdfXwKpE8keuSk _2vXRFPIn0aB5dHsDcWV_MP']");
        for(ElementHandle timeInSchedule : timeInScheduleAll){
            timeInSchedule.evaluate("t => t.innerText='00:00'");
        }

        List<ElementHandle> nameTvProgramInScheduleAll = page.querySelectorAll("//a[@class='_2kFyYGffe-aoW_cqXclDoD _2vXRFPIn0aB5dHsDcWV_MP']");
        for(ElementHandle nameTvProgramInSchedule : nameTvProgramInScheduleAll){
            nameTvProgramInSchedule.evaluate("nP => nP.textContent='Название передачи'");
        }

        List<ElementHandle> ageInScheduleAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle ageInSchedule : ageInScheduleAll){
            ageInSchedule.evaluate("a => a.innerText='18+'");
        }

        List<ElementHandle> text1SubscribeButtonAll = page.querySelectorAll("//button[contains(@class,'YIGqY8KbmzH5WB_hWI-Tp')]//span");
        for(ElementHandle text1SubscribeButton : text1SubscribeButtonAll){
            text1SubscribeButton.evaluate("a => a.innerText='Подключить бесплатно на 7 дней'");
        }
        List<ElementHandle> text2SubscribeButtonAll = page.querySelectorAll("//div[contains(@class,'_2PYJbU0RSIrOhl6lHhAs-O')]");
        for(ElementHandle text2SubscribeButton : text2SubscribeButtonAll){
            text2SubscribeButton.evaluate("a => a.innerText='В пакете «Основной+»'");
        }

        // делаем скриншот видимой части страницы "cardTvProgramForGuest":
        vrt.track(
                "cardCurrentTvProgramForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Honor")
                        .os("Android")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCardTvProgramForUserMWEB() throws IOException, InterruptedException {
        page.navigate(frontend +"tv");
        page.waitForSelector("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.waitForSelector("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]");
        page.click("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]");
        page.waitForSelector("._1nAXLMkHN0PXnwvulfBvK0");
        page.click("._1nAXLMkHN0PXnwvulfBvK0");
        // подготовка видимой части страницы "cardTvProgramForUser" к скриншот-тесту:
        page.waitForSelector("(//span[@itemprop='name'])[4]");

        ElementHandle nameTvChannelCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название канала'", nameTvChannelCrumbs);

        ElementHandle nameTvProgramCrumbs = page.querySelector("(//span[@itemprop='name'])[4]");
        page.evaluate("n => n.innerText='Название передачи'", nameTvProgramCrumbs);

        ElementHandle imgTvChannel = page.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        page.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')", imgTvChannel);

        ElementHandle nameTvChannel = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("nC => nC.innerText='Название канала'", nameTvChannel);

        ElementHandle genres = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        page.evaluate("d => d.innerText='Сегодня, 00:00, 18+'", genres);

        ElementHandle dateTimeAge = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        page.evaluate("g => g.innerText='Познавательные, HD, В записи'", dateTimeAge);

        ElementHandle nameTvProgram = page.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        page.evaluate("nP => nP.innerText='Название передачи'", nameTvProgram);

        ElementHandle agePoster = page.querySelector("(//div[@class='_3vBdLAs_q6zHDlAspM6kFN'])[2]");
        page.evaluate("aP => aP.innerText='18+'", agePoster);



        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        page.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'", descriptionTvProgram);

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        page.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'", descriptionTvChannel);

        ElementHandle text1SubscribeButton = page.waitForSelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        page.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'", text1SubscribeButton);

        ElementHandle text2SubscribeButton = page.querySelector("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]//div[text()]");
        page.evaluate("t2B => t2B.innerText='В пакете «Основной+»'", text2SubscribeButton);

        ElementHandle text1SubscribeButtonSecond = page.querySelector("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _3f0wpWSLNwEn9_twVy01wx')]");
        text1SubscribeButtonSecond.evaluate("tBS => tBS.innerText='Другие варианты'");

        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgo);

        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrow);

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        ElementHandle posterTvProgram = page.querySelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2FslsQhbQ8YUGzqjYdejYu']");
        page.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/c8/f9/65467a9cb1db598036537f85514828af0b0d/secondary_poster__web-wp.webp);')", posterTvProgram);

        page.waitForSelector("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']");
        List<ElementHandle> listTvPrograminSchedule = page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']");
        if (listTvPrograminSchedule.size() > 4) {
            while (page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
                page.evaluate("dU => dU.remove();", page.querySelector("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']"));
                System.out.println(page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size());
            }
        }
        List<ElementHandle> timeInScheduleAll= page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
        for(ElementHandle timeInSchedule : timeInScheduleAll){
            timeInSchedule.evaluate("t => t.innerText='00:00'");
        }
        List<ElementHandle> nameTvProgramInScheduleAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
        for(ElementHandle nameTvProgramInSchedule : nameTvProgramInScheduleAll){
            nameTvProgramInSchedule.evaluate("nP => nP.textContent='Название передачи'");
        }
        List<ElementHandle> ageInScheduleAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle ageInSchedule : ageInScheduleAll){
            ageInSchedule.evaluate("a => a.innerText='18+'");
        }
        page.querySelector("._3lvyrUkaGN_QANJMIvjX5c").hover();
        // делаем скриншот видимой части страницы "cardTvProgramForUser":
        vrt.track(
                "cardTvProgramForUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkOpenCardTvProgram() {
        page.waitForSelector("(//span[@itemprop='name'])[4]");
    }

    public void clickPaymentButtonInCardTvProgram() {
        page.click("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]");
    }

    public void checkAutoStartVideoPlayer() throws InterruptedException {
        // автозапуск плеера:
        pageHeadfull.waitForTimeout(5000);
        pageHeadfull.waitForSelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']");
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        String timeStart = pageHeadfull.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        pageHeadfull.waitForTimeout(5000);
        String timeEnd = pageHeadfull.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Assert.assertNotEquals(timeStart, timeEnd);
    }

    public void checkImagePlayerСardTvProgramUnrecordedUser() throws IOException, InterruptedException {
        // подготовка страницы к скриншот-тесту:
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        ElementHandle nameTvChannelCrumbs = pageHeadfull.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs.evaluate("n => n.innerText='Название канала'");

        ElementHandle nameTvProgramCrumbs = pageHeadfull.querySelector("(//span[@itemprop='name'])[4]");
        nameTvProgramCrumbs.evaluate("n => n.innerText='Название передачи'");

        ElementHandle imgTvChannel = pageHeadfull.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        imgTvChannel.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle nameTvChannel = pageHeadfull.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameTvChannel.evaluate("nC => nC.innerText='Название канала'");

        ElementHandle genres = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        genres.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle dateTimeAge = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        dateTimeAge.evaluate("g => g.innerText='Познавательные, HD, В записи'");

        ElementHandle nameTvProgram = pageHeadfull.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle videoTvProgram = pageHeadfull.querySelector("//video[@src]");
        videoTvProgram.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle descriptionTvProgram = pageHeadfull.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel = pageHeadfull.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle userLogin = pageHeadfull.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");


        ElementHandle nameProgramInPlayer = pageHeadfull.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        nameProgramInPlayer.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle numberNameTvChannelInPlayer = pageHeadfull.querySelector("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']");
        numberNameTvChannelInPlayer.evaluate("nNC => nNC.innerText='01 - Название канала'");

        List<ElementHandle> timeProgressVideoAll = pageHeadfull.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
        for (ElementHandle timeProgressVideo : timeProgressVideoAll) {
            timeProgressVideo.evaluate("pV => pV.innerText='0'");
        }
        List<ElementHandle> posterOtherTvBackgroundAll = pageHeadfull.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]");
        for (ElementHandle posterOtherTvBackground : posterOtherTvBackgroundAll) {
            posterOtherTvBackground.evaluate("pB => pB.setAttribute('style', 'background-color: rgb(89, 156, 183); background-image: linear-gradient(rgba(0, 0, 0, 0.5), " +
                    "rgba(0, 0, 0, 0.5)), url(https://static-sesure.cdn.megafon.tv/images/img/52/05/38adc5d8194094c15f274d89761e4d5231a6/tile_player__web-wp.webp);')");
        }

        List<ElementHandle> posterOtherTvLogoAll = pageHeadfull.querySelectorAll("//div[@class='_3GXxXiLb1VN6fU0CRO3ta8']");
        for (ElementHandle posterOtherTvLogo : posterOtherTvLogoAll) {
            posterOtherTvLogo.evaluate("pL => pL.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_trp_tv__web-wp.png);')");
        }

        List<ElementHandle> progressOtherTvProgramAll = pageHeadfull.querySelectorAll("//div[@class='_7W5pMNsmv3tCx5NSCdKzC']");
        for (ElementHandle progressOtherTvProgram : progressOtherTvProgramAll) {
            progressOtherTvProgram.evaluate("pOT => pOT.setAttribute('style', 'width: 50%;')");
        }

        ElementHandle progressPlayerTvProgram = pageHeadfull.querySelector("//div[@class='_3uP0ihiEVqMOuIXkcIlhiL']");
        pageHeadfull.evaluate("pP => pP.setAttribute('style', 'width: 50%;')", progressPlayerTvProgram);

        List<ElementHandle> listTvPrograminSchedule = pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']");
        if (listTvPrograminSchedule.size() > 4) {
            while (pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
                pageHeadfull.evaluate("dU => dU.remove();", pageHeadfull.querySelector("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']"));
                System.out.println(pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size());
            }
        }

        List<ElementHandle> timeInScheduleAll = pageHeadfull.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
        for (ElementHandle time : timeInScheduleAll) {
            time.evaluate("t => t.innerText='00:00'");
        }

        List<ElementHandle> nameTvProgramInScheduleAll = pageHeadfull.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
        for (ElementHandle nameTvProgramInSchedule : nameTvProgramInScheduleAll) {
            nameTvProgramInSchedule.evaluate("nP => nP.textContent='Название передачи'");
        }

        List<ElementHandle> ageInScheduleAll = pageHeadfull.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for (ElementHandle age : ageInScheduleAll) {
            age.evaluate("a => a.innerText='18+'");
        }

        ElementHandle dayAgo = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        dayAgo.evaluate("dA => dA.innerText='Вс, 1'");

        ElementHandle afterTomorrow = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow.evaluate("aT => aT.innerText='Чт, 4'");

        // делаем скриншот видимой части страницы "VideoPlayerUnrecordedTvProgram":
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "PlayerСardTvProgramUnrecorded",
                Base64.getEncoder().encodeToString(pageHeadfull.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageScheduleСardTvProgramUnrecorded() throws IOException, InterruptedException {
        // открыть рассписание в плеере:
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        pageHeadfull.click("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[1]");
        pageHeadfull.waitForSelector("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']");
        // подготовка расписания в плеере к скриншот-тесту:
        ElementHandle nameTvChannelCrumbs2 = pageHeadfull.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs2.evaluate("n => n.innerText='Название канала'");

        ElementHandle nameTvProgramCrumbs2 = pageHeadfull.querySelector("(//span[@itemprop='name'])[4]");
        nameTvProgramCrumbs2.evaluate("n => n.innerText='Название передачи'");

        ElementHandle imgTvChannel2 = pageHeadfull.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        imgTvChannel2.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle genres2 = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        genres2.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle dateTimeAge2 = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        dateTimeAge2.evaluate("g => g.innerText='Познавательные, HD, В записи'");

        ElementHandle nameTvProgram2 = pageHeadfull.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram2.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle videoTvProgram2 = pageHeadfull.querySelector("//video[@src]");
        videoTvProgram2.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle descriptionTvProgram2 = pageHeadfull.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram2.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel2 = pageHeadfull.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel2.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle userLogin2 = pageHeadfull.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin2.evaluate("uL => uL.innerText='+79260010101'");

        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

//        List<ElementHandle> listTvProgramInSchedule = pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']");
//        if (listTvProgramInSchedule.size() > 4) {
//            while (pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
//                pageHeadfull.evaluate("dU => dU.remove();", pageHeadfull.querySelector("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']"));
//                System.out.println(pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size());
//            }
//        }
        List<ElementHandle> listTvProgramInPlayer = pageHeadfull.querySelectorAll("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']");
        if (listTvProgramInPlayer.size() > 4) {
            while (pageHeadfull.querySelectorAll("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
                pageHeadfull.evaluate("dU => dU.remove();", pageHeadfull.querySelector("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']"));
                System.out.println(pageHeadfull.querySelectorAll("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']").size());
            }
        }

        List<ElementHandle> timeInPlayerAll = pageHeadfull.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
        for (ElementHandle timeInPlayer : timeInPlayerAll) {
            timeInPlayer.evaluate("t => t.innerText='00:00'");
        }

        List<ElementHandle> nameTvProgramInSchedulePlayerAll = pageHeadfull.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
        for (ElementHandle nameTvProgramInSchedulePlayer : nameTvProgramInSchedulePlayerAll) {
            nameTvProgramInSchedulePlayer.evaluate("nP => nP.textContent='Название передачи'");
        }


        List<ElementHandle> ageInPlayerAll = pageHeadfull.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for (ElementHandle ageInPlayer : ageInPlayerAll) {
            ageInPlayer.evaluate("a => a.innerText='18+'");
        }

        ElementHandle dayAgoInPlayer = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        dayAgoInPlayer.evaluate("dA => dA.innerText='Вс, 1'");
        ElementHandle afterTomorrowInPlayer = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[5]");
        afterTomorrowInPlayer.evaluate("aT => aT.innerText='Чт, 4'");

        ElementHandle dayAgo2 = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        dayAgo2.evaluate("dA => dA.innerText='Вс, 1'");
        ElementHandle afterTomorrow2 = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow2.evaluate("aT => aT.innerText='Чт, 4'");
        // делаем скриншот видимой части страницы "PlayerUnrecordedTvProgramWithSchedule":
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "ScheduleСardTvProgramUnrecorded",
                Base64.getEncoder().encodeToString(pageHeadfull.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImagePlayerСardTvProgramRecordedUser() throws IOException, InterruptedException {
        //подготовка к скриншот-тесту страницы с плеером:
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']");
        ElementHandle nameTvChannelCrumbs = pageHeadfull.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs.evaluate("n => n.innerText='Название канала'");

        ElementHandle nameTvProgramCrumbs = pageHeadfull.querySelector("(//span[@itemprop='name'])[4]");
        nameTvProgramCrumbs.evaluate("n => n.innerText='Название передачи'");

        ElementHandle imgTvChannel = pageHeadfull.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        imgTvChannel.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle nameTvChannel = pageHeadfull.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameTvChannel.evaluate("nC => nC.innerText='Название канала'");

        ElementHandle genres = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        genres.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle dateTimeAge = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        dateTimeAge.evaluate("g => g.innerText='Познавательные, HD, В записи'");

        ElementHandle nameTvProgram = pageHeadfull.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle videoTvProgram = pageHeadfull.querySelector("//video[@src]");
        videoTvProgram.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle descriptionTvProgram = pageHeadfull.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel = pageHeadfull.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle userLogin = pageHeadfull.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        ElementHandle nameProgramInPlayer = pageHeadfull.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        nameProgramInPlayer.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle numberNameTvChannelInPlayer = pageHeadfull.querySelector("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']");
        numberNameTvChannelInPlayer.evaluate("nNC => nNC.innerText='01 - Название канала'");

        List<ElementHandle> posterOtherTvBackgroundAll = pageHeadfull.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]");
        for (ElementHandle posterOtherTvBackground : posterOtherTvBackgroundAll) {
            posterOtherTvBackground.evaluate("pB => pB.setAttribute('style', 'background-color: rgb(89, 156, 183); " +
                    "background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(https://static-sesure.cdn.megafon.tv/images/img/52/05/38adc5d8194094c15f274d89761e4d5231a6/tile_player__web-wp.webp);')");
        }

        List<ElementHandle> posterOtherTvLogoAll = pageHeadfull.querySelectorAll("//div[@class='_3GXxXiLb1VN6fU0CRO3ta8']");
        for (ElementHandle posterOtherTvLogo : posterOtherTvLogoAll) {
            posterOtherTvLogo.evaluate("pL => pL.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_trp_tv__web-wp.png);')");
        }

        List<ElementHandle> progressOtherTvProgramAll;
        for (int i = 0; i < pageHeadfull.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]").size(); i++) {
            posterOtherTvLogoAll = pageHeadfull.querySelectorAll("//div[@class='_3GXxXiLb1VN6fU0CRO3ta8']");
            pageHeadfull.evaluate("pL => pL.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_trp_tv__web-wp.png);')", posterOtherTvLogoAll.get(i));
            progressOtherTvProgramAll = pageHeadfull.querySelectorAll("//div[@class='_7W5pMNsmv3tCx5NSCdKzC']");
            pageHeadfull.evaluate("pOT => pOT.setAttribute('style', 'width: 50%;')", progressOtherTvProgramAll.get(i));
        }


        List<ElementHandle> listTvPrograminSchedule = pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']");
        if (listTvPrograminSchedule.size() > 4) {
            while (pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
                pageHeadfull.evaluate("dU => dU.remove();", pageHeadfull.querySelector("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']"));
                System.out.println(pageHeadfull.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size());
            }
        }

        List<ElementHandle> timeInScheduleAll = pageHeadfull.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
        for (ElementHandle timeInSchedule : timeInScheduleAll) {
            timeInSchedule.evaluate("t => t.innerText='00:00'");
        }

        List<ElementHandle> nameTvProgramInScheduleAll = pageHeadfull.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
        for (ElementHandle nameTvProgramInSchedule : nameTvProgramInScheduleAll) {
            nameTvProgramInSchedule.evaluate("nP => nP.textContent='Название передачи'");
        }

        List<ElementHandle> ageInScheduleAll = pageHeadfull.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for (ElementHandle ageInSchedule : ageInScheduleAll) {
            ageInSchedule.evaluate("a => a.innerText='18+'");
        }

        ElementHandle dayAgo = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        dayAgo.evaluate("dA => dA.innerText='Вс, 1'");

        ElementHandle afterTomorrow = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow.evaluate("aT => aT.innerText='Чт, 4'");

        List<ElementHandle> progressTimeVideoAll = pageHeadfull.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
        for (ElementHandle progressTimeVideo : progressTimeVideoAll) {
            progressTimeVideo.evaluate("pV => pV.innerText='0'");
        }
        ElementHandle progressPlayerTvProgram = pageHeadfull.querySelector("//div[@class='_3uP0ihiEVqMOuIXkcIlhiL']");
        progressPlayerTvProgram.evaluate("pP => pP.setAttribute('style', 'width: 50%;')");

        // делаем скриншот видимой части страницы "VideoPlayerRecordedTvProgram":
//        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "PlayerСardTvProgramRecorded",
                Base64.getEncoder().encodeToString(pageHeadfull.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageScheduleСardTvProgramRecorded() throws IOException, InterruptedException {
        // открыть расписание в плеере:
        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        pageHeadfull.waitForSelector("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]");
        pageHeadfull.click("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]");
        pageHeadfull.waitForSelector("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']");
        // подготовка расписания в плеере к скриншот-тесту:
        ElementHandle nameTvChannelCrumbs2 = pageHeadfull.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs2.evaluate("n => n.innerText='Название канала'");

        ElementHandle nameTvProgramCrumbs2 = pageHeadfull.querySelector("(//span[@itemprop='name'])[4]");
        nameTvProgramCrumbs2.evaluate("n => n.innerText='Название передачи'");

        ElementHandle imgTvChannel2 = pageHeadfull.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        imgTvChannel2.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle genres2 = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        genres2.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle dateTimeAge2 = pageHeadfull.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        dateTimeAge2.evaluate("g => g.innerText='Познавательные, HD, В записи'");

        ElementHandle nameTvProgram2 = pageHeadfull.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram2.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle videoTvProgram2 = pageHeadfull.querySelector("//video[@src]");
        videoTvProgram2.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle descriptionTvProgram2 = pageHeadfull.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram2.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel2 = pageHeadfull.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel2.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle userLogin2 = pageHeadfull.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin2.evaluate("uL => uL.innerText='+79260010101'");

        pageHeadfull.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        pageHeadfull.click("(//div[@class='_2PTjd7wVQg-DJZQcg2IqIO _2BeyjGisf12UNX8mPALW98']//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        List<ElementHandle> listTvProgramInPlayer = pageHeadfull.querySelectorAll("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']");
        if (listTvProgramInPlayer.size() > 4) {
            while (pageHeadfull.querySelectorAll("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
                pageHeadfull.evaluate("dU => dU.remove();", pageHeadfull.querySelector("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']"));
                System.out.println(pageHeadfull.querySelectorAll("//div[@class='_2SOEapoa-Kc5Wc978Nni5I _1J7Bd53tGM88cshwxVlWNF']").size());
            }
        }
        List<ElementHandle> timeInPlayerAll = pageHeadfull.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
        for (ElementHandle timeInPlayer : timeInPlayerAll) {
            timeInPlayer.evaluate("t => t.innerText='00:00'");
        }
        List<ElementHandle> nameTvProgramInSchedulePlayerAll = pageHeadfull.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
        for (ElementHandle nameTvProgramInSchedulePlayer : nameTvProgramInSchedulePlayerAll) {
            nameTvProgramInSchedulePlayer.evaluate("nP => nP.textContent='Название передачи'");
        }
        List<ElementHandle> ageInPlayerAll = pageHeadfull.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for (ElementHandle ageInPlayer : ageInPlayerAll) {
            ageInPlayer.evaluate("a => a.innerText='18+'");
        }
        ElementHandle dayAgoInPlayer = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        dayAgoInPlayer.evaluate("dA => dA.innerText='Вс, 1'");
        ElementHandle afterTomorrowInPlayer = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[5]");
        afterTomorrowInPlayer.evaluate("aT => aT.innerText='Чт, 4'");

        ElementHandle dayAgo2 = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        dayAgo2.evaluate("dA => dA.innerText='Вс, 1'");
        ElementHandle afterTomorrow2 = pageHeadfull.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow2.evaluate("aT => aT.innerText='Чт, 4'");
        // делаем скриншот видимой части страницы "PlayerUnrecordedTvProgramWithSchedule":
//        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "ScheduleСardTvProgramRecorded",
                Base64.getEncoder().encodeToString(pageHeadfull.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnRecordedTvProgramTwoDaysAgo() {
        pageHeadfull.waitForSelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        pageHeadfull.click("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        pageHeadfull.waitForSelector("(//div[@class='_11haELF4WsXnADUPWeRX8I _2BeyjGisf12UNX8mPALW98']//div[@class='DSoUWlplI4m8T5WSf-XxC'])[2]");
        pageHeadfull.click("(//div[@class='_11haELF4WsXnADUPWeRX8I _2BeyjGisf12UNX8mPALW98']//div[@class='DSoUWlplI4m8T5WSf-XxC'])[2]");
        pageHeadfull.waitForTimeout(25000);
        pageHeadfull.click("(//div[@class='_11haELF4WsXnADUPWeRX8I _2BeyjGisf12UNX8mPALW98']//div[@class='DSoUWlplI4m8T5WSf-XxC'])[1]");
        pageHeadfull.click("._2fPMOlJJX5DRkSEypQ3sLc");
    }

    public void moveSliderRewindToVideoPlayerHeadfull() {
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

    public void subscribeToPackageTvProgram() {
        page.waitForSelector("//span[contains(text(),'Подключить')]");
        page.tap("//span[contains(text(),'Подключить')]");
        page.waitForSelector("//button//div[text()='Подтвердить']");
        page.tap("//button//div[text()='Подтвердить']");
        page.waitForSelector("//span[text()='Смотреть']");
    }

    public void chooseTailTvProgramTabInRecorder() {
        pageHeadfull.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        pageHeadfull.click("(//a[@class='_3qpWWwbv1F2VcSRTSjiIgS'])[3]");
    }

    public void chooseTailTvProgramTabAll() {
        pageHeadfull.click("(//a[@class='_3qpWWwbv1F2VcSRTSjiIgS'])[3]");
    }

    public void goToPackagesPageHeadfull() {
        pageHeadfull.navigate(frontend +"packages");
    }

    public void openCardTvProgramInRecordFromPackageKinoPoPodpiskeHeadfull() {
        // открыть карточку тв канала:
        pageHeadfull.click("//div[text()='ТВ-каналы']");
        pageHeadfull.click("(//a[@class='_2SBFkKqCGAQ96AZk-0n_uA'])[1]");
        // открыть карточку тв передачи в записи:
        pageHeadfull.waitForSelector("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]");
        pageHeadfull.waitForTimeout(5000);
        pageHeadfull.click("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]");
    }

    public void checkImageBlockCollectHistoryWatchOnNilPage() throws IOException, InterruptedException {
        pageHeadfull.navigate(frontend);
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

    public void checkElementsCardTvProgram() {
        // чек элементов страницы текущей передачи:
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _17D0GCdbbIdXkUxy-YT76O' and contains(@style,'url')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//h1[text()]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("(//div[@class='_3vBdLAs_q6zHDlAspM6kFN' and text()])[2]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//span[@class='L3rzdT7KYzyE1ClBQKxNL' and contains(@style,'background-color')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[@class='_2xMMkjxj45XkX1x1g8ZxMm']//div[contains(text(),'Сегодня') or contains(text(),'Вчера')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//span[contains(@class,'_3mmoBhU2y-bKK_rbQlrtvM') and text()]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//button[text()='Прочитать описание']").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[@class='_30aTB-cIGKUf7rNZoi9JUA' and text()='Далее в эфире']").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[@class='_2H8yToCwb1zXChwX6l7ZNT']//div[text()='Главная']").size()==1);
        Assert.assertTrue("bug: diff size", page.querySelectorAll("//div[@class='_2t7rDZjUkG3P1KbzR9IaaB']").size()==3);
        Assert.assertTrue("bug: diff size", page.querySelectorAll("//a[@href and text()='Открыть расписание']").size()==1);
        Assert.assertTrue("bug: diff size", page.querySelectorAll("//footer").size()==1);
    }

    public void openFullDiscription() {
        page.waitForSelector("//button[text()='Прочитать описание']");
        page.tap("//button[text()='Прочитать описание']");
        page.waitForSelector("//span[contains(@class,'_3mmoBhU2y-bKK_rbQlrtvM') and text()]");
        page.waitForSelector("//button[text()='Свернуть']");
    }

    public void closeFullDiscription() {
        page.tap("//span[contains(@class,'_3mmoBhU2y-bKK_rbQlrtvM') and text()]");
        page.waitForSelector("//button[text()='Прочитать описание']");
    }

    public void openFullSchedule() {
        page.waitForSelector("//a[@href and text()='Открыть расписание']");
        page.tap("//a[@href and text()='Открыть расписание']");
        Assert.assertFalse("bug: not opened page /programs/", page.url().contains("/programs/"));
        Assert.assertTrue("bug: not opened page /channels/", page.url().contains("/channels/"));
    }

    public void tapWatch() {
        page.waitForSelector("//button//span[text()='Смотреть']");
        page.tap("//button//span[text()='Смотреть']");
        page.waitForTimeout(3000);
    }

    public void checkStartPlayer() {
        //время до
        page.waitForSelector("//span[@class='VjAWZi0qU4-zNzFJGxuq1 _2D2Qz2yDUj11pGyjzicrYZ' and text()]");
        ElementHandle timeBeforeString = page.querySelector("//span[@class='VjAWZi0qU4-zNzFJGxuq1 _2D2Qz2yDUj11pGyjzicrYZ' and text()]");
        LocalTime timeBefore = LocalTime.parse(timeBeforeString.innerText());
        System.out.println(timeBefore);
        page.waitForTimeout(7000);
        page.tap("._6mYGF-1LO-lpUY7yeOnck");
        //время после
        page.waitForSelector("//span[@class='VjAWZi0qU4-zNzFJGxuq1 _2D2Qz2yDUj11pGyjzicrYZ' and text()]");
        ElementHandle timeAfterString = page.querySelector("//span[@class='VjAWZi0qU4-zNzFJGxuq1 _2D2Qz2yDUj11pGyjzicrYZ' and text()]");
        LocalTime timeAfter = LocalTime.parse(timeAfterString.innerText());
        System.out.println(timeAfter);
        Assert.assertTrue("time After NO more time Before", timeBefore.isBefore(timeAfter));
    }
}



