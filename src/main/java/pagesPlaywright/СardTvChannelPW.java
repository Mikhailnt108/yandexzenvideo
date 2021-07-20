package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class СardTvChannelPW extends BasePagePlaywright {
    private Page page;


    public СardTvChannelPW (Page page) {
        this.page = page;
    }

    public void checkImageCardTvChannelForUnauthorized() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate("https://web-preprod5.megafon.tv/tv");
        page.waitForSelector("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
        page.click("(//div[@class='_16fO5taSmblh91J9Prw7TV'])[1]");
        // подготовка полной страницы "CardTvChannel" к скриншот-тесту:
        page.waitForSelector("(//span[@itemprop='name'])[3]");
        ElementHandle nameTvChannelCrumbs = page.querySelector("(//span[@itemprop='name'])[3]");
        page.evaluate("n => n.innerText='Название канала'", nameTvChannelCrumbs);

        ElementHandle imgTvChannel = page.querySelector("//img[@src]");
        page.evaluate("i => i.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/7f/4e/62d9c9b6d708dcaf23d41a28c8b9b4b699a1/logo_tv_guide__web-wp.png')", imgTvChannel);

        ElementHandle nameTvChannel = page.querySelector("//h1[@class='_1v_D6wOANknQeJMBPo_rKK']");
        page.evaluate("nC => nC.innerText='Название канала'", nameTvChannel);

        ElementHandle dateTimeAge = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[1]");
        page.evaluate("d => d.innerText='Сегодня, 00:00, 18+'", dateTimeAge);

        ElementHandle genres = page.querySelector("(//div[@class='_364E2xRe8IGMOTfCluwbl2'])[2]");
        page.evaluate("g => g.innerText='Познавательные, HD, В записи'", genres);

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

        // делаем скриншот полной части страницы "СardTvChannel":
        vrt.track(
                "СardTvChannel",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("СardTvChannel.png")))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
   }

