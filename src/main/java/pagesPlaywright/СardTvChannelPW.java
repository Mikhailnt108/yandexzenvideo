package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class СardTvChannelPW extends BasePagePlaywright {
    private Page page;


    public СardTvChannelPW(Page page) {
        this.page = page;
    }

    public void checkImageCardTvChannelForGuest() throws IOException, InterruptedException {
        page.navigate("https://web-preprod2.megafon.tv/tv");
        page.waitForSelector("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.waitForSelector("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[3]");
        page.click("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[3]");
        // подготовка полной страницы "сardTvChannel" к скриншот-тесту:
        page.waitForSelector("(//span[@itemprop='name'])[3]");
        ElementHandle nameTvChannelCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs.evaluate("n => n.innerText='Название канала'");

        ElementHandle imgTvChannel = page.querySelector("//div[@class='_h4q05gE1H5zxLK-Zl3ym']//img[@src]");
        imgTvChannel.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle nameTvChannel = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameTvChannel.evaluate("nC => nC.innerText='Название канала'");

        ElementHandle dateTimeAge = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        dateTimeAge.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle genres = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        genres.evaluate("g => g.innerText='Жанр'");

        ElementHandle nameTvProgram = page.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle agePoster = page.querySelector("(//div[@class='_3vBdLAs_q6zHDlAspM6kFN'])[2]");
        agePoster.evaluate("aP => aP.innerText='18+'");

        ElementHandle posterTvProgram = page.querySelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2FslsQhbQ8YUGzqjYdejYu']");
        posterTvProgram.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/c8/f9/65467a9cb1db598036537f85514828af0b0d/secondary_poster__web-wp.webp);')");

        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle text1SubscribeButton = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        text1SubscribeButton.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'");

        ElementHandle text2SubscribeButton = page.querySelector("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]//div[text()]");
        text2SubscribeButton.evaluate("t2B => t2B.innerText='В пакете «Основной+»'");

        ElementHandle text1SubscribeButtonSecond = page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')])[2]");
        text1SubscribeButtonSecond.evaluate("tBS => tBS.innerText='Другие варианты'");

        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        dayAgo.evaluate("dA => dA.innerText='Вс, 1'");

        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow.evaluate("aT => aT.innerText='Чт, 4'");

        List<ElementHandle> listTvProgramInSchedule = page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']");
        if (listTvProgramInSchedule.size() > 4) {
            while (page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
                page.evaluate("dU => dU.remove();", page.querySelector("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']"));
                System.out.println(page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size());
            }
        }
        List<ElementHandle> timeInScheduleAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
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
        page.waitForTimeout(5000);
        // делаем скриншот полной страницы "сardTvChannelForGuest":
        vrt.track(
                "cardTvChannelForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCardTvChannelForUser() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate("https://web-preprod2.megafon.tv/tv");
        page.waitForSelector("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.waitForSelector("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[3]");
        page.click("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[3]");
        // подготовка полной страницы "сardTvChannel" к скриншот-тесту:
        page.waitForSelector("(//span[@itemprop='name'])[3]");
        ElementHandle nameTvChannelCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        nameTvChannelCrumbs.evaluate("n => n.innerText='Название канала'");

        ElementHandle imgTvChannel = page.querySelector("//div[@class='_h4q05gE1H5zxLK-Zl3ym']//img[@src]");
        imgTvChannel.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')");

        ElementHandle nameTvChannel = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        nameTvChannel.evaluate("nC => nC.innerText='Название канала'");

        ElementHandle dateTimeAge = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        dateTimeAge.evaluate("d => d.innerText='Сегодня, 00:00, 18+'");

        ElementHandle genres = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        genres.evaluate("g => g.innerText='Жанр'");

        ElementHandle nameTvProgram = page.querySelector("//a[@class='_1nAXLMkHN0PXnwvulfBvK0']");
        nameTvProgram.evaluate("nP => nP.innerText='Название передачи'");

        ElementHandle agePoster = page.querySelector("(//div[@class='_3vBdLAs_q6zHDlAspM6kFN'])[2]");
        agePoster.evaluate("aP => aP.innerText='18+'");

        ElementHandle posterTvProgram = page.querySelector("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _2FslsQhbQ8YUGzqjYdejYu']");
        posterTvProgram.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/c8/f9/65467a9cb1db598036537f85514828af0b0d/secondary_poster__web-wp.webp);')");

        ElementHandle descriptionTvProgram = page.querySelector("//div[@class='_3DKCWpmCv7Gf2hQA0mQQ2g']");
        descriptionTvProgram.evaluate("dP => dP.innerText='С помощью последних научных данных и потрясающей трёхмерной " +
                "компьютерной графики вы проникнете внутрь звёзд, планет и галактик и исследуете тайны " +
                "происхождения и будущего Вселенной.'");

        ElementHandle descriptionTvChannel = page.querySelector("//div[contains(@class,'_3DKCWpmCv7Gf2hQA0mQQ2g _2Ky-vuB268MfKpaMD8X9K6')]");
        descriptionTvChannel.evaluate("dP => dP.innerText='Канал находится на острие научного и технологического поиска, рассказывает об изобретениях, " +
                "показывая, как наука воздействует на нашу жизнь. Охватывается весь спектр научных интересов – от изучения нашей Вселенной " +
                "до практической науки вокруг нас.'");

        ElementHandle text1SubscribeButton = page.querySelector("(//button//span[@class='_1Kps2hNPLZGQ3H2Sf5NYID']//span)[1]");
        text1SubscribeButton.evaluate("t1B => t1B.innerText='Подключить бесплатно на 21 день'");

        ElementHandle text2SubscribeButton = page.querySelector("//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V _1FfeR84AXAbi63sErW3rma')]//div[text()]");
        text2SubscribeButton.evaluate("t2B => t2B.innerText='В пакете «Основной+»'");

        ElementHandle text1SubscribeButtonSecond = page.querySelector("(//button[contains(@class,'M2wxcFvZLf83aNlb6Ab1V')])[2]");
        text1SubscribeButtonSecond.evaluate("tBS => tBS.innerText='Другие варианты'");

        ElementHandle dayAgo = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[1]");
        dayAgo.evaluate("dA => dA.innerText='Вс, 1'");

        ElementHandle afterTomorrow = page.querySelector("(//div[@class='_29P6Zrf7K1Dx_N1l0bKL45'])[last()]");
        afterTomorrow.evaluate("aT => aT.innerText='Чт, 4'");

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        List<ElementHandle> listTvPrograminSchedule = page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']");
        if (listTvPrograminSchedule.size() > 4) {
            while (page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size() != 4) {
                page.evaluate("dU => dU.remove();", page.querySelector("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']"));
                System.out.println(page.querySelectorAll("//div[@class='QZwrBDUP5ZmIJsZL6bopi _1J7Bd53tGM88cshwxVlWNF']").size());
            }
        }
        List<ElementHandle> timeInScheduleAll = page.querySelectorAll("//div[@class='_2F06JEFCaBoh-jQ-JAfmAN']");
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
        page.waitForTimeout(5000);
        // делаем скриншот полной части страницы "сardTvChannelForUser":
        vrt.track(
                "cardTvChannelForUser",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
}

