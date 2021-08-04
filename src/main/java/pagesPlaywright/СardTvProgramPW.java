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

public class СardTvProgramPW extends BasePagePlaywright {
    private Page page;
    private Page pageHeadfull;


    public СardTvProgramPW(Page page) {
        this.page = page;
        this.pageHeadfull = page;

    }

    public void checkImageCardTvProgramForUnauthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/tv");
        page.waitForSelector("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]");
        page.click("._1nAXLMkHN0PXnwvulfBvK0");
        // подготовка видимой части страницы "CardTvProgram" к скриншот-тесту:
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

        ElementHandle posterTvProgram = page.querySelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2FslsQhbQ8YUGzqjYdejYu']");
        page.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/c8/f9/65467a9cb1db598036537f85514828af0b0d/secondary_poster__web-wp.webp);')", posterTvProgram);

        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        page.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'", descriptionTvProgram);

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        page.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'", descriptionTvChannel);

        ElementHandle text1SubscribeButton = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        page.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'", text1SubscribeButton);

        ElementHandle text2SubscribeButton = page.querySelector("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]//div[text()]");
        page.evaluate("t2B => t2B.innerText='В пакете «Основной+»'", text2SubscribeButton);

        ElementHandle text1SubscribeButtonSecond = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[2]");
        page.evaluate("tBS => tBS.innerText='Другие варианты'", text1SubscribeButtonSecond);

        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgo);

        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrow);

        List<ElementHandle> timeAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']").size(); i++) {
            timeAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }

        // делаем скриншот видимой части страницы "СardTvProgram":
        vrt.track(
                "СardTvProgramForUnauthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCardTvProgramForAuthorized() throws IOException, InterruptedException {
        page.navigate("https://web-preprod5.megafon.tv/tv");
        page.waitForSelector("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]");
        page.click("._1nAXLMkHN0PXnwvulfBvK0");
        // подготовка видимой части страницы "CardTvProgram" к скриншот-тесту:
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

        ElementHandle posterTvProgram = page.querySelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2FslsQhbQ8YUGzqjYdejYu']");
        page.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/c8/f9/65467a9cb1db598036537f85514828af0b0d/secondary_poster__web-wp.webp);')", posterTvProgram);

        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        page.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'", descriptionTvProgram);

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        page.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'", descriptionTvChannel);

        ElementHandle text1SubscribeButton = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        page.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'", text1SubscribeButton);

        ElementHandle text2SubscribeButton = page.querySelector("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]//div[text()]");
        page.evaluate("t2B => t2B.innerText='В пакете «Основной+»'", text2SubscribeButton);

        ElementHandle text1SubscribeButtonSecond = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[2]");
        page.evaluate("tBS => tBS.innerText='Другие варианты'", text1SubscribeButtonSecond);

        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgo);

        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrow);

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        List<ElementHandle> timeAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']").size(); i++) {
            timeAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }

        // делаем скриншот видимой части страницы "СardTvProgram":
        vrt.track(
                "СardTvProgramForAuthorized",
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
        if(page.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]").size()!=0) {
            page.click("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]");
            page.waitForSelector("//button[text()='Подтвердить']|//button[text()='Принять и подключить']");
            page.click("//button[text()='Подтвердить']");
            page.waitForSelector("//button[text()='Закрыть']");
            page.click("//button[text()='Закрыть']");
            page.reload();
        }
        Thread.sleep(7000);
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        String timeStart = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Thread.sleep(7000);
        String timeEnd = page.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Assert.assertNotEquals(timeStart, timeEnd);
    }

    public void checkImagePlayerСardTvProgramUnrecorded(String login, String password) throws IOException, InterruptedException {
        pagePlayer = contextIncognitoModeHeadfull.newPage();
        pagePlayer.setDefaultNavigationTimeout(60000);
        pagePlayer.navigate("https://web-preprod5.megafon.tv/tv/tv_catalog");
        pagePlayer.click("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC'])[3]");
        //////////////////////////////////////////////////////////////////
        //авторизация:
        pagePlayer.click("(//span[text()='Вход'])[1]");
        pagePlayer.fill("//input[@name='login']", login);
        pagePlayer.click("//button[text()='Далее']");
        pagePlayer.fill("//input[@type='password']",password);
        pagePlayer.click("//button[text()='Войти']");
        pagePlayer.waitForSelector("(//span[contains(text(),'+792')])[2]");
        pagePlayer.reload();
        if (pagePlayer.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            pagePlayer.click("//button[text()='Закрыть']");
        }
        pagePlayer.reload();
        if (pagePlayer.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            pagePlayer.click("//button[text()='Закрыть']");
        }
        pagePlayer.reload();
        /////////////////////////////////////////////////////////////////
        // подключение пакета:
        if(pagePlayer.querySelectorAll("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]").size()!=0) {
            pagePlayer.click("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]");
            pagePlayer.waitForSelector("//button[text()='Подтвердить']|//button[text()='Принять и подключить']");
            pagePlayer.click("//button[text()='Подтвердить']");
            pagePlayer.waitForSelector("//button[text()='Закрыть']");
            pagePlayer.click("//button[text()='Закрыть']");
            pagePlayer.reload();
        }
        // проверка автозапуска плеера:
        Thread.sleep(5000);
        pagePlayer.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        String timeStart = pagePlayer.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Thread.sleep(5000);
        String timeEnd = pagePlayer.querySelector("(//div[@class='TbJLLkMJ2e-Mv2C1zXAvV']//div)[1]").innerText();
        Assert.assertNotEquals(timeStart, timeEnd);

        //подготовка страницы к скриншот-тесту:
        ElementHandle nameTvChannelCrumbs = pagePlayer.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs.evaluate("n => n.innerText='Название канала'");

        ElementHandle nameTvProgramCrumbs = pagePlayer.querySelector("(//span[@itemprop='name'])[4]");
        nameTvProgramCrumbs.evaluate("n => n.innerText='Название передачи'");

        ElementHandle imgTvChannel = pagePlayer.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        imgTvChannel.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle nameTvChannel = pagePlayer.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameTvChannel.evaluate("nC => nC.innerText='Название канала'");

        ElementHandle genres = pagePlayer.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        genres.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle dateTimeAge = pagePlayer.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        dateTimeAge.evaluate("g => g.innerText='Познавательные, HD, В записи'");

        ElementHandle nameTvProgram = pagePlayer.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle videoTvProgram = pagePlayer.querySelector("//video[@src]");
        videoTvProgram.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle descriptionTvProgram = pagePlayer.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel = pagePlayer.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle userLogin = pagePlayer.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        pagePlayer.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameProgramInPlayer = pagePlayer.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        nameProgramInPlayer.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle numberNameTvChannelInPlayer = pagePlayer.querySelector("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']");
        numberNameTvChannelInPlayer.evaluate("nNC => nNC.innerText='01 - Название канала'");

        List<ElementHandle> timeProgressVideoAll = pagePlayer.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
        for(ElementHandle timeProgressVideo : timeProgressVideoAll){
            timeProgressVideo.evaluate("pV => pV.innerText='0'");
        }
        List<ElementHandle> posterOtherTvBackgroundAll = pagePlayer.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]");
        for(ElementHandle posterOtherTvBackground : posterOtherTvBackgroundAll){
            posterOtherTvBackground.evaluate("pB => pB.setAttribute('style', 'background-color: rgb(89, 156, 183); background-image: linear-gradient(rgba(0, 0, 0, 0.5), " +
                    "rgba(0, 0, 0, 0.5)), url(https://static-sesure.cdn.megafon.tv/images/img/52/05/38adc5d8194094c15f274d89761e4d5231a6/tile_player__web-wp.webp);')");
        }

        List<ElementHandle> posterOtherTvLogoAll = pagePlayer.querySelectorAll("//div[@class='_3GXxXiLb1VN6fU0CRO3ta8']");
        for(ElementHandle posterOtherTvLogo : posterOtherTvLogoAll){
            posterOtherTvLogo.evaluate("pL => pL.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_trp_tv__web-wp.png);')");
        }

        List<ElementHandle> progressOtherTvProgramAll = pagePlayer.querySelectorAll("//div[@class='_7W5pMNsmv3tCx5NSCdKzC']");
        for(ElementHandle progressOtherTvProgram : progressOtherTvProgramAll){
            progressOtherTvProgram.evaluate("pOT => pOT.setAttribute('style', 'width: 50%;')");
        }

        ElementHandle progressPlayerTvProgram = pagePlayer.querySelector("//div[@class='_3uP0ihiEVqMOuIXkcIlhiL']");
        pagePlayer.evaluate("pP => pP.setAttribute('style', 'width: 50%;')", progressPlayerTvProgram);

        List<ElementHandle> timeAll = pagePlayer.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
        for (ElementHandle time : timeAll){
            time.evaluate("t => t.innerText='00:00'");
        }

        List<ElementHandle> nameTvProgramInScheduleAll = pagePlayer.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
        for(ElementHandle nameTvProgramInSchedule : nameTvProgramInScheduleAll){
            nameTvProgramInSchedule.evaluate("nP => nP.textContent='Название передачи'");
        }

        List<ElementHandle> ageAll = pagePlayer.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }

        ElementHandle dayAgo = pagePlayer.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        dayAgo.evaluate("dA => dA.innerText='Вс, 1'");

        ElementHandle afterTomorrow = pagePlayer.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow.evaluate("aT => aT.innerText='Чт, 4'");

        // делаем скриншот видимой части страницы "VideoPlayerUnrecordedTvProgram":
        pagePlayer.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "PlayerСardTvProgramUnrecorded",
                Base64.getEncoder().encodeToString(pagePlayer.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
        ///////////////////////////////////////////////////////////////////////////////////////////////
        //расписание:
        pagePlayer.click("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[1]");
        pagePlayer.waitForSelector("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']");
        // подготовка расписания в плеере к скриншот-тесту:
        ElementHandle nameTvChannelCrumbs2 = pagePlayer.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs2.evaluate("n => n.innerText='Название канала'");

        ElementHandle nameTvProgramCrumbs2 = pagePlayer.querySelector("(//span[@itemprop='name'])[4]");
        nameTvProgramCrumbs2.evaluate("n => n.innerText='Название передачи'");

        ElementHandle imgTvChannel2 = pagePlayer.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        imgTvChannel2.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle genres2 = pagePlayer.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        genres2.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle dateTimeAge2 = pagePlayer.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        dateTimeAge2.evaluate("g => g.innerText='Познавательные, HD, В записи'");

        ElementHandle nameTvProgram2 = pagePlayer.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram2.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle videoTvProgram2 = pagePlayer.querySelector("//video[@src]");
        videoTvProgram2.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')");

        ElementHandle descriptionTvProgram2 = pagePlayer.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram2.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel2 = pagePlayer.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel2.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle userLogin2 = pagePlayer.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin2.evaluate("uL => uL.innerText='+79260010101'");

        pagePlayer.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        List<ElementHandle> timeInPlayerAll = pagePlayer.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
        for(ElementHandle timeInPlayer : timeInPlayerAll){
            timeInPlayer.evaluate("t => t.innerText='00:00'");
        }

        List<ElementHandle> nameTvProgramInSchedulePlayerAll = pagePlayer.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
        for(ElementHandle nameTvProgramInSchedulePlayer : nameTvProgramInSchedulePlayerAll){
            nameTvProgramInSchedulePlayer.evaluate("nP => nP.textContent='Название передачи'");
        }


        List<ElementHandle> ageInPlayerAll = pagePlayer.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle ageInPlayer : ageInPlayerAll){
            ageInPlayer.evaluate("a => a.innerText='18+'");
        }

        ElementHandle dayAgoInPlayer = pagePlayer.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        dayAgoInPlayer.evaluate("dA => dA.innerText='Вс, 1'");
        ElementHandle afterTomorrowInPlayer = pagePlayer.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[5]");
        afterTomorrowInPlayer.evaluate("aT => aT.innerText='Чт, 4'");

        ElementHandle dayAgo2 = pagePlayer.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        dayAgo2.evaluate("dA => dA.innerText='Вс, 1'");
        ElementHandle afterTomorrow2 = pagePlayer.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow2.evaluate("aT => aT.innerText='Чт, 4'");

        // делаем скриншот видимой части страницы "PlayerUnrecordedTvProgramWithSchedule":
        pagePlayer.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "ScheduleСardTvProgramUnrecorded",
                Base64.getEncoder().encodeToString(pagePlayer.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageScheduleСardTvProgramUnrecorded() throws IOException, InterruptedException {
        page.click("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[1]");
        page.waitForSelector("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']");
        // подготовка расписания в плеере к скриншот-тесту:
        ElementHandle nameTvChannelCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название канала'", nameTvChannelCrumbs);

        ElementHandle nameTvProgramCrumbs = page.querySelector("(//span[@itemprop='name'])[4]");
        page.evaluate("n => n.innerText='Название передачи'", nameTvProgramCrumbs);

        ElementHandle imgTvChannel = page.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        page.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')", imgTvChannel);

        ElementHandle genres = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        page.evaluate("d => d.innerText='Сегодня, 00:00, 18+'", genres);

        ElementHandle dateTimeAge = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        page.evaluate("g => g.innerText='Познавательные, HD, В записи'", dateTimeAge);

        ElementHandle nameTvProgram = page.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        page.evaluate("nP => nP.innerText='Название передачи'", nameTvProgram);

        ElementHandle videoTvProgram = page.querySelector("//video[@src]");
        page.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')", videoTvProgram);

        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        page.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'", descriptionTvProgram);

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        page.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'", descriptionTvChannel);

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameProgramInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("nP => nP.innerText='Название передачи'", nameProgramInPlayer);

        ElementHandle numberNameTvChannelInPlayer = page.querySelector("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("nNC => nNC.innerText='01 - Название канала'", numberNameTvChannelInPlayer);

        List<ElementHandle> progressVideoAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']").size(); i++) {
            progressVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
            page.evaluate("pV => pV.innerText='0'", progressVideoAll.get(i));
        }

        List<ElementHandle> posterOtherTvBackgroundAll;
        List<ElementHandle> posterOtherTvLogoAll;
        List<ElementHandle> progressOtherTvProgramAll;
        for (int i = 0; i < page.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]").size(); i++) {
            posterOtherTvBackgroundAll = page.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]");
            page.evaluate("pB => pB.setAttribute('style', 'background-color: rgb(89, 156, 183); background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(https://static-sesure.cdn.megafon.tv/images/img/52/05/38adc5d8194094c15f274d89761e4d5231a6/tile_player__web-wp.webp);')", posterOtherTvBackgroundAll.get(i));
            posterOtherTvLogoAll = page.querySelectorAll("//div[@class='_3GXxXiLb1VN6fU0CRO3ta8']");
            page.evaluate("pL => pL.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_trp_tv__web-wp.png);')", posterOtherTvLogoAll.get(i));
            progressOtherTvProgramAll = page.querySelectorAll("//div[@class='_7W5pMNsmv3tCx5NSCdKzC']");
            page.evaluate("pOT => pOT.setAttribute('style', 'width: 50%;')", progressOtherTvProgramAll.get(i));
        }
        ElementHandle progressPlayerTvProgram = page.querySelector("//div[@class='_3uP0ihiEVqMOuIXkcIlhiL']");
        page.evaluate("pP => pP.setAttribute('style', 'width: 50%;')", progressPlayerTvProgram);

        List<ElementHandle> timeInPlayerAll;
        List<ElementHandle> nameTvProgramInPlayerAll;
        List<ElementHandle> ageInPlayerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']").size(); i++) {
            timeInPlayerAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
            page.evaluate("t => t.innerText='00:00'", timeInPlayerAll.get(i));
            nameTvProgramInPlayerAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramInPlayerAll.get(i));
            ageInPlayerAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageInPlayerAll.get(i));
        }
        List<ElementHandle> timeAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']").size(); i++) {
            timeAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        ElementHandle dayAgoInPlayer = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgoInPlayer);
        ElementHandle afterTomorrowInPlayer = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[5]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrowInPlayer);

        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgo);
        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrow);

        // делаем скриншот видимой части страницы "PlayerUnrecordedTvProgramWithSchedule":
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "ScheduleСardTvProgramUnrecorded",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImagePlayerСardTvProgramRecorded() throws IOException, InterruptedException {
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

        ElementHandle videoTvProgram = page.querySelector("//video[@src]");
        page.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')", videoTvProgram);

        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        page.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'", descriptionTvProgram);

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        page.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'", descriptionTvChannel);

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameProgramInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("nP => nP.innerText='Название передачи'", nameProgramInPlayer);

        ElementHandle numberNameTvChannelInPlayer = page.querySelector("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("nNC => nNC.innerText='01 - Название канала'", numberNameTvChannelInPlayer);

        List<ElementHandle> progressTimeVideoAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']").size(); i++) {
            progressTimeVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
            page.evaluate("pV => pV.innerText='0'", progressTimeVideoAll.get(i));
        }
        ElementHandle progressPlayerTvProgram = page.querySelector("//div[@class='_3uP0ihiEVqMOuIXkcIlhiL']");
        page.evaluate("pP => pP.setAttribute('style', 'width: 50%;')", progressPlayerTvProgram);

        List<ElementHandle> posterOtherTvBackgroundAll;
        List<ElementHandle> posterOtherTvLogoAll;
        List<ElementHandle> progressOtherTvProgramAll;
        for (int i = 0; i < page.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]").size(); i++) {
            posterOtherTvBackgroundAll = page.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]");
            page.evaluate("pB => pB.setAttribute('style', 'background-color: rgb(89, 156, 183); background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(https://static-sesure.cdn.megafon.tv/images/img/52/05/38adc5d8194094c15f274d89761e4d5231a6/tile_player__web-wp.webp);')", posterOtherTvBackgroundAll.get(i));
            posterOtherTvLogoAll = page.querySelectorAll("//div[@class='_3GXxXiLb1VN6fU0CRO3ta8']");
            page.evaluate("pL => pL.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_trp_tv__web-wp.png);')", posterOtherTvLogoAll.get(i));
            progressOtherTvProgramAll = page.querySelectorAll("//div[@class='_7W5pMNsmv3tCx5NSCdKzC']");
            page.evaluate("pOT => pOT.setAttribute('style', 'width: 50%;')", progressOtherTvProgramAll.get(i));
        }

        List<ElementHandle> timeAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']").size(); i++) {
            timeAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }
        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgo);

        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrow);

        // делаем скриншот видимой части страницы "VideoPlayerUnrecordedTvProgram":
//        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "PlayerСardTvProgramRecorded",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageScheduleСardTvProgramRecorded() throws IOException, InterruptedException {
        page.click("(//button[@class='_1y2MwvAuO97Xb0-8ccbmkk'])[6]");
        page.waitForSelector("//div[@class='_3Pw3DImx_GWRGGCEPoHcED']");
        // подготовка расписания в плеере к скриншот-тесту:
        List<ElementHandle> timeInPlayerAll;
        List<ElementHandle> nameTvProgramInPlayerAll;
        List<ElementHandle> ageInPlayerAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']").size(); i++) {
            timeInPlayerAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
            page.evaluate("t => t.innerText='00:00'", timeInPlayerAll.get(i));
            nameTvProgramInPlayerAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramInPlayerAll.get(i));
            ageInPlayerAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageInPlayerAll.get(i));
        }
        ElementHandle nameTvChannelCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название канала'", nameTvChannelCrumbs);

        ElementHandle nameTvProgramCrumbs = page.querySelector("(//span[@itemprop='name'])[4]");
        page.evaluate("n => n.innerText='Название передачи'", nameTvProgramCrumbs);

        ElementHandle imgTvChannel = page.querySelector("._3lvyrUkaGN_QANJMIvjX5c");
        page.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')", imgTvChannel);

        ElementHandle genres = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        page.evaluate("d => d.innerText='Сегодня, 00:00, 18+'", genres);

        ElementHandle dateTimeAge = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        page.evaluate("g => g.innerText='Познавательные, HD, В записи'", dateTimeAge);

        ElementHandle nameTvProgram = page.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        page.evaluate("nP => nP.innerText='Название передачи'", nameTvProgram);

        ElementHandle videoTvProgram = page.querySelector("//video[@src]");
        page.evaluate("vP => vP.setAttribute('src', 'blob:notVideo')", videoTvProgram);

        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        page.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'", descriptionTvProgram);

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        page.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'", descriptionTvChannel);

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);

        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();

        ElementHandle nameProgramInPlayer = page.querySelector("//div[@class='_2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("nP => nP.innerText='Название передачи'", nameProgramInPlayer);

        ElementHandle numberNameTvChannelInPlayer = page.querySelector("//div[@class='_2BmzfS137HCY74Y40iGrLy _2GPoEznIkBV65Iqkud1teP']");
        page.evaluate("nNC => nNC.innerText='01 - Название канала'", numberNameTvChannelInPlayer);

        List<ElementHandle> progressTimeVideoAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']").size(); i++) {
            progressTimeVideoAll = page.querySelectorAll("//div[@class='_2wsl4lGkd8OHfFTRCpObeb _1EUAQDMdNFPAPHIXjrbxxi']");
            page.evaluate("pV => pV.innerText='0'", progressTimeVideoAll.get(i));
        }

        List<ElementHandle> posterOtherTvBackgroundAll;
        List<ElementHandle> posterOtherTvLogoAll;
        List<ElementHandle> progressOtherTvProgramAll;
        for (int i = 0; i < page.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]").size(); i++) {
            posterOtherTvBackgroundAll = page.querySelectorAll("//div[contains(@class,'oog6D4ljOTvbih-_NivDx')]");
            page.evaluate("pB => pB.setAttribute('style', 'background-color: rgb(89, 156, 183); background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(https://static-sesure.cdn.megafon.tv/images/img/52/05/38adc5d8194094c15f274d89761e4d5231a6/tile_player__web-wp.webp);')", posterOtherTvBackgroundAll.get(i));
            posterOtherTvLogoAll = page.querySelectorAll("//div[@class='_3GXxXiLb1VN6fU0CRO3ta8']");
            page.evaluate("pL => pL.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_trp_tv__web-wp.png);')", posterOtherTvLogoAll.get(i));
            progressOtherTvProgramAll = page.querySelectorAll("//div[@class='_7W5pMNsmv3tCx5NSCdKzC']");
            page.evaluate("pOT => pOT.setAttribute('style', 'width: 50%;')", progressOtherTvProgramAll.get(i));
        }

        ElementHandle progressPlayerTvProgram = page.querySelector("//div[@class='_3uP0ihiEVqMOuIXkcIlhiL']");
        page.evaluate("pP => pP.setAttribute('style', 'width: 50%;')", progressPlayerTvProgram);
        List<ElementHandle> timeAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']").size(); i++) {
            timeAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
            page.evaluate("nP => nP.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
        }

        ElementHandle dayAgoInPlayer = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgoInPlayer);

        ElementHandle afterTomorrowInPlayer = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[5]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrowInPlayer);

        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[6]");
        page.evaluate("dA => dA.innerText='Вс, 1'", dayAgo);

        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        page.evaluate("aT => aT.innerText='Чт, 4'", afterTomorrow);

        // делаем скриншот видимой части страницы "PlayerUnrecordedTvProgramWithSchedule":
        page.querySelector("//div[@class='_3oIAMUjIv-QAdeSq_k6cql']").hover();
        vrt.track(
                "ScheduleСardTvProgramRecorded",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnRecordedTvProgram() {
        page.click("//div[@class='DSoUWlplI4m8T5WSf-XxC']");
    }

    public void moveSliderRewindToVideoPlayer() {
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

