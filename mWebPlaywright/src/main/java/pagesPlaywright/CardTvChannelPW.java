package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class CardTvChannelPW extends BasePagePlaywright {
    private Page page;
    private String frontend;

    public CardTvChannelPW(Page page) {
        this.page = page;
        this.frontend = frontend;
    }

    public void checkImageCardTvChannelForGuestMWEB() throws IOException, InterruptedException {
        page.navigate(frontend +"tv");
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

    public void checkImageCardTvChannelForUserMWEB() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate(frontend +"tv");
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
    public void clickTvProgramRecordInCardTvChannel() {
        page.waitForSelector("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]");
        page.waitForTimeout(5000);
        page.click("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]");
    }
    public void checkElementsScheduleNonRecordedTv() {
//        // Getting the current date and time
//        Date currentDate = new Date();

//        // Creating simple date formatter to 24 hours
//        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");
//
//        // getting the time in 24 hours format
//        String timeIn24Hours = formatter.format(currentDate);

        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(currentTime);
        LocalTime afterTime = LocalTime.parse(page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]/following::a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')][1]").innerText());
        System.out.println(afterTime.format(DateTimeFormatter.ofPattern("HH:mm")));
        LocalTime timeProgram = LocalTime.parse(page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]").innerText());
        page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]");
        System.out.println(currentTime.isAfter(timeProgram) && currentTime.isBefore(afterTime));
        Assert.assertTrue(currentTime.isAfter(timeProgram) && currentTime.isBefore(afterTime));

        // чек элементов расписания:
        Assert.assertEquals("diff size elements", page.querySelectorAll("//div[contains(@class,'_1kXtsoTZpkqxm3UN7jrPUb')]").size(), page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]").size());
        Assert.assertEquals("bug: diff size elements", 3, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U' and text()]").size());
        Assert.assertEquals("bug: diff size elements", 3, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U']/following-sibling::div[text()]").size());
        Assert.assertEquals("bug: diff size elements", 3, page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']").size());

        // чек элементов текущей передачи:
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_30m0cUyqnN7hnERn4tZUhK')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_3PEf1_q_VA09pRAKJq-lNW') and text()]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ') and text()]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//span[@class='L3rzdT7KYzyE1ClBQKxNL']").size()==1);
    }

    public void checkElementsScheduleRecordedTv() {
        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(currentTime);
        LocalTime afterTime = LocalTime.parse(page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]/following::a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')][1]").innerText());
        System.out.println(afterTime.format(DateTimeFormatter.ofPattern("HH:mm")));
        LocalTime timeProgram = LocalTime.parse(page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]").innerText());
        page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]");
        System.out.println(currentTime.isAfter(timeProgram) && currentTime.isBefore(afterTime));
        Assert.assertTrue(currentTime.isAfter(timeProgram) && currentTime.isBefore(afterTime));

        // чек элементов расписания:
        Assert.assertEquals("diff size elements", page.querySelectorAll("//div[contains(@class,'_1kXtsoTZpkqxm3UN7jrPUb')]").size(), page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]").size());
//      Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("._2mLz14ja1zCBwrRv-RM7lg").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]").size());
        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U' and text()]").size());
        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U']/following-sibling::div[text()]").size());
        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']").size());

        // чек элементов текущей передачи:
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_30m0cUyqnN7hnERn4tZUhK')]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_3PEf1_q_VA09pRAKJq-lNW') and text()]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ') and text()]").size()==1);
        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]").size()==1);
    }


    public void checkImageCardTvChannelNonRecorded() throws IOException, InterruptedException {
        // Сделать тестовый скриншот карточки тв канала записываемого:
        // чек элементов расписания:
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("//div[contains(@class,'_1kXtsoTZpkqxm3UN7jrPUb')]").size(), page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]").size());
        Assert.assertEquals("bug: diff size elements", 3, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U' and text()]").size());
        Assert.assertEquals("bug: diff size elements", 3, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U']/following-sibling::div[text()]").size());
        Assert.assertEquals("bug: diff size elements", 3, page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']").size());

        List<ElementHandle> programBlock1All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[1]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>3]");
        for (ElementHandle programBlock1 : programBlock1All) {
            programBlock1.evaluate("s => s.remove();");
        }
        List<ElementHandle> programBlock2All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[2]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>3]");
        for (ElementHandle programBlock2 : programBlock2All) {
            programBlock2.evaluate("s => s.remove();");
        }
        List<ElementHandle> programBlock3All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[3]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>3]");
        for (ElementHandle programBlock3 : programBlock3All) {
            programBlock3.evaluate("s => s.remove();");
        }
//        List<ElementHandle> programBlock4All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[4]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>3]");
//        for (ElementHandle programBlock4 : programBlock4All) {
//            programBlock4.evaluate("s => s.remove();");
//        }
//        List<ElementHandle> programAll = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[5]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>5]");
//        for (ElementHandle program : programAll) {
//            program.evaluate("s => s.remove();");
//        }

        List<ElementHandle> dateAll = page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']");
        for (ElementHandle date : dateAll) {
            date.evaluate("a => a.innerText='день, 1 января'");
        }
        List<ElementHandle> numberAll = page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U' and text()]");
        for (ElementHandle number : numberAll) {
            number.evaluate("a => a.innerText='1'");
        }

        List<ElementHandle> dayAll = page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U']/following-sibling::div[text()]");
        for (ElementHandle day : dayAll) {
            day.evaluate("a => a.innerText='день'");
        }

        List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']");
        for (ElementHandle nameTvProgram : nameTvProgramAll) {
            nameTvProgram.evaluate("d => d.textContent='Название передачи'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> timeAll = page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]");
        for (ElementHandle time : timeAll) {
            time.evaluate("t => t.innerText='00:00'");
        }
        page.evaluate("bar => bar.setAttribute('style', 'width: 50%; height: 3px; background-color: var(--color-base);')", page.waitForSelector("//span[@class='L3rzdT7KYzyE1ClBQKxNL']"));
        ElementHandle imgTv = page.waitForSelector("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]");
        imgTv.evaluate("iT => iT.setAttribute('style', 'background-image: url(http://static.cdn.megafon.tv/images/img/8e/fb/b0ce8dd748a7ccba9a7d4b3c7045d4647590/poster__aphone-xxhdpi.webp);')");
        Thread.sleep(3000);
        // делаем скриншот видимой части страницы "CardTvChannelNonRecAndroidMWEB":
        vrt.track(
                "CardTvChannelNonRecAndroidMWEB",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageCardTvChannelRecorded() throws IOException, InterruptedException {
        // Сделать тестовый скриншот карточки тв канала записываемого:
        // чек элементов расписания:
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("//div[contains(@class,'_1kXtsoTZpkqxm3UN7jrPUb')]").size(), page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]").size());
        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U' and text()]").size());
        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U']/following-sibling::div[text()]").size());
        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']").size());

        List<ElementHandle> programBlock1All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[1]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>4]");
        for (ElementHandle programBlock1 : programBlock1All) {
            programBlock1.evaluate("s => s.remove();");
        }
        List<ElementHandle> programBlock2All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[2]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>4]");
        for (ElementHandle programBlock2 : programBlock2All) {
            programBlock2.evaluate("s => s.remove();");
        }
        List<ElementHandle> programBlock3All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[3]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>4]");
        for (ElementHandle programBlock3 : programBlock3All) {
            programBlock3.evaluate("s => s.remove();");
        }
        List<ElementHandle> programBlock4All = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[4]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>4]");
        for (ElementHandle programBlock4 : programBlock4All) {
            programBlock4.evaluate("s => s.remove();");
        }
        List<ElementHandle> programAll = page.querySelectorAll("(//div[@class='Cl6_9tQmsP2zIDeWDecmQ'])[5]/following-sibling::div[@class='_1kXtsoTZpkqxm3UN7jrPUb'][position()>4]");
        for (ElementHandle program : programAll) {
            program.evaluate("s => s.remove();");
        }

        List<ElementHandle> dateAll = page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']");
        for (ElementHandle date : dateAll) {
            date.evaluate("a => a.innerText='день, 1 января'");
        }

        List<ElementHandle> numberAll = page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U' and text()]");
        for (ElementHandle number : numberAll) {
            number.evaluate("a => a.innerText='1'");
        }

        List<ElementHandle> dayAll = page.querySelectorAll("//div[@class='_1ah0vGf3vcwuK1q9sxCb7U']/following-sibling::div[text()]");
        for (ElementHandle day : dayAll) {
            day.evaluate("a => a.innerText='день'");
        }

        List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']");
        for (ElementHandle nameTvProgram : nameTvProgramAll) {
            nameTvProgram.evaluate("d => d.textContent='Название передачи'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> timeAll = page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]");
        for (ElementHandle time : timeAll) {
            time.evaluate("t => t.innerText='00:00'");
        }
        page.evaluate("bar => bar.setAttribute('style', 'width: 50%; height: 3px; background-color: var(--color-base);')", page.waitForSelector("//span[@class='L3rzdT7KYzyE1ClBQKxNL']"));

        ElementHandle imgTv = page.waitForSelector("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]");
        imgTv.evaluate("iT => iT.setAttribute('style', 'background-image: url(http://static.cdn.megafon.tv/images/img/8e/fb/b0ce8dd748a7ccba9a7d4b3c7045d4647590/poster__aphone-xxhdpi.webp);')");
        Thread.sleep(3000);
        // делаем скриншот видимой части страницы "CardTvChannelRecAndroidMWEB":
        vrt.track(
                "CardTvChannelRecAndroidMWEB",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void scrollScheduleRecUp() throws InterruptedException {
        while (page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]//div[text()='сегодня']").size()==1){
            page.evaluate("window.scrollBy(0, -1);");
        }
        Assert.assertTrue(page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]/following::div[@class='_3JIMZ3_-3sPOGT1g7YUGmq'][1]//div[text()='сегодня']").size()==1);

        while (page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]/following::div[@class='_3JIMZ3_-3sPOGT1g7YUGmq'][1]//div[text()='сегодня']").size()==1){
            page.evaluate("window.scrollBy(0, -1);");
        }
        Assert.assertTrue(page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]/following::div[@class='_3JIMZ3_-3sPOGT1g7YUGmq'][2]//div[text()='сегодня']").size()==1);
    }

    public void scrollScheduleRecDown() {
        while (page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]//div[text()='сегодня']").size()==1){
            page.evaluate("window.scrollBy(0, 1);");
        }
        Assert.assertTrue(page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]/following::div[@class='_3JIMZ3_-3sPOGT1g7YUGmq'][1]//div[text()='сегодня']").size()==1);

        while (page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]/following::div[@class='_3JIMZ3_-3sPOGT1g7YUGmq'][1]//div[text()='сегодня']").size()==1){
            page.evaluate("window.scrollBy(0, 1);");
        }
        Assert.assertTrue(page.querySelectorAll("//div[contains(@class,'zFq1_lqy3Y9oiMPABIdTx')]/following::div[@class='_3JIMZ3_-3sPOGT1g7YUGmq'][2]//div[text()='сегодня']").size()==1);

    }
}

