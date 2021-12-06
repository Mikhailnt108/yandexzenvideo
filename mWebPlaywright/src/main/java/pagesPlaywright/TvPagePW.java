package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;
import static java.lang.Thread.sleep;

public class TvPagePW extends BasePagePlaywright {
    private Page page;
    private String frontend;
    private Statement statement;

    public TvPagePW(Page page, String frontend, Statement statement) {
        this.page = page;
        this.frontend = frontend;
        this.statement = statement;
    }

    public void checkImageTvPageForGuestMWEB() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate(frontend + "tv");
        // подготовка полной страницы "TvPageTabProgramTvForGuest" к скриншот-тесту:
        List<ElementHandle> imgTvAll = page.querySelectorAll("//div[@class='_23E9FFV9LhyYMGP2R_4Hjv']");
        for (ElementHandle imgTv : imgTvAll) {
            imgTv.evaluate("iT => iT.setAttribute('style', 'background-image: url(http://static.cdn.megafon.tv/images/Channel/27/3d/b7235e2c57e71de7283e923dec5feedfb69b/logo_on_air__iphone-x.png);')");
        }
        List<ElementHandle> nameTvChannelAll = page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko']");
        for (ElementHandle nameTvChannel : nameTvChannelAll) {
            nameTvChannel.evaluate("n => n.innerText='Название канала'");
        }
        List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//a[contains(@class,'_2kFyYGffe-aoW_cqXclDoD')]");
        for (ElementHandle nameTvProgram : nameTvProgramAll) {
            nameTvProgram.evaluate("d => d.textContent='Название передачи'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> timeAll = page.querySelectorAll("//a[@class='_3S1RJTAMPdfXwKpE8keuSk _2vXRFPIn0aB5dHsDcWV_MP']");
        for (ElementHandle time : timeAll) {
            time.evaluate("t => t.innerText='00:00'");
        }


        // делаем скриншот видимой части страницы "TvPageForGuest":
        vrt.track(
                "TvPageForGuestAndroidMWEB",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageTabTvProgramInAirForGuestMWEB() throws IOException, InterruptedException {
        page.navigate(frontend + "tv/tv_catalog");
        // подготовка полной страницы "TvPageTabTvProgramInAirForGuest" к скриншот-тесту:
        List<ElementHandle> tailAll = page.querySelectorAll("(//a[contains(@href,'/tv/channels/')])[position()>18]");
        for (ElementHandle tailRemove : tailAll) {
            tailRemove.evaluate("t => t.remove();");
        }

        List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//h3[@class='hhYBfS5SYd9UjRyn3tWgw']");
        for (ElementHandle nameTvProgram : nameTvProgramAll) {
            nameTvProgram.evaluate("nP => nP.textContent='Название передачи'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> timeNameTvChannelAll = page.querySelectorAll("//div[@class='_3jrfnhGV2HAWEcqDrup1qU']");
        for (ElementHandle timeNameTvChannel : timeNameTvChannelAll) {
            timeNameTvChannel.evaluate("tN => tN.innerText='00:00, Discovery Channel HD'");
        }
        List<ElementHandle> progressAll = page.querySelectorAll("//span[@class='L3rzdT7KYzyE1ClBQKxNL']");
        for (ElementHandle progress : progressAll) {
            progress.evaluate("pR => pR.setAttribute('style', 'width: 50%; height: 4px; background-color: var(--color-base);')");
        }
        List<ElementHandle> posterTvProgramAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC']");
        for (ElementHandle posterTvProgram : posterTvProgramAll) {
            posterTvProgram.evaluate("pP => pP.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/31/25/f8f17fb50a914336ac35561afc290db5fe8f/tile__web-wp.webp);')");
        }
        // делаем скриншот видимой части страницы "TvPageTabTvProgramInAirForGuest":
        vrt.track(
                "TvPageTabTvProgramInAirForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToTailTvProgram() {
        page.click("(//a[@class='_3qpWWwbv1F2VcSRTSjiIgS'])[3]");
    }

    public void clickOnTabInRecording() {
        page.click("//a[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA') and text()='В записи']");
    }

    public void checkImageTvPageTabProgramTvForAuthorizedMWEB() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate(frontend + "tv");
        // подготовка полной страницы "TvPageTabProgramTv" к скриншот-тесту:
        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        page.evaluate("uL => uL.innerText='+79260010101'", userLogin);
        List<ElementHandle> imgTvAll;
        List<ElementHandle> nameTvChannelAll;
        List<ElementHandle> nameTvProgramAll;
        List<ElementHandle> ageAll;
        List<ElementHandle> timeAll;
        for (int i = 0; i < page.querySelectorAll("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]").size(); i++) {
            imgTvAll = page.querySelectorAll("//div[@class='_3xplzuhwSABoqCYH8ffVtJ']//img[@src]");
            page.evaluate("p => p.setAttribute('src', 'https://static-sesure.cdn.megafon.tv/images/Channel/27/3d/b7235e2c57e71de7283e923dec5feedfb69b/logo_tv_guide__web-wp.png')", imgTvAll.get(i));
            nameTvChannelAll = page.querySelectorAll("//div[@class='_16fO5taSmblh91J9Prw7TV']");
            page.evaluate("n => n.innerText='Название канала'", nameTvChannelAll.get(i));
            nameTvProgramAll = page.querySelectorAll("//a[@class='_19SojadR5Q0BvNZTu4HCi1']");
            page.evaluate("d => d.textContent='Название передачи'", nameTvProgramAll.get(i));
            ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
            page.evaluate("a => a.innerText='18+'", ageAll.get(i));
            timeAll = page.querySelectorAll("//div[@class='y-1kJx0MnmrSqtKC7fdK0']");
            page.evaluate("t => t.innerText='00:00'", timeAll.get(i));
        }

        // делаем скриншот видимой части страницы "TvPageTabProgramTvForAuthorized":
        vrt.track(
                "TvPageTabProgramTvForAuthorized",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsTvPageGuest() {
        page.waitForSelector("//div[contains(@class,'smartbanner-android')]");
        page.waitForSelector("//div[@class='YZBWFgwJ_YIq52D_M0HUz']");
        page.waitForSelector("//a[@class='_2lyBKIjmUqLXlMuC-NbqUe _3h6ZZnjTUm-EUZUfiI5SOR']//span[text()='ТВ']");
        page.waitForSelector("//div[@class='zcd66G8sCa_vpFpPNWBNz']");
        page.waitForSelector("//a[@class='_39I3V1X9nHf1r_IzNeqphS _1Ue0f9dD5er3cByaAe2IwI']//div[text()='Все']");
        page.waitForSelector("//a[@class='PaDvSJkfKmpUlUemAC5ex' and @href]//div[text()]");
        page.waitForSelector("//div[contains(@class,'programs')]");
        page.waitForSelector("//div[@class='_2H8yToCwb1zXChwX6l7ZNT']");
//        page.waitForSelector("//a[contains(@class,'LayoutBottomMenu_linkActive')]//span[text()='Главная']");
        // чек проверки коллекции элементов в блоках расписания:
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("._23E9FFV9LhyYMGP2R_4Hjv").size());
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//a[contains(@class,'3S1RJTAMPdfXwKpE8keuSk') and text()]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//a[contains(@class,'_2kFyYGffe-aoW_cqXclDoD') and text() and @href]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ') and text()]").size());
        Assert.assertEquals(page.querySelectorAll("//div[contains(@class,'programs')]").size(), page.querySelectorAll("//a[contains(@class,'showAll') and text()='Показать все']").size());
        Assert.assertEquals(page.querySelectorAll("//div[contains(@class,'programs')]").size(), page.querySelectorAll("._2mLz14ja1zCBwrRv-RM7lg").size());
    }

    public void checkElementsTvPageUser() {
        page.waitForSelector("//div[contains(@class,'smartbanner-android')]");
        page.waitForSelector(".Ml_oz1fhp-oa2a75_b9Tp");
        page.waitForSelector("//div[@class='YZBWFgwJ_YIq52D_M0HUz']");
        page.waitForSelector("//a[@class='_2lyBKIjmUqLXlMuC-NbqUe _3h6ZZnjTUm-EUZUfiI5SOR']//span[text()='ТВ']");
        page.waitForSelector("//div[@class='zcd66G8sCa_vpFpPNWBNz']");
        page.waitForSelector("//a[@class='_39I3V1X9nHf1r_IzNeqphS _1Ue0f9dD5er3cByaAe2IwI']//div[text()='Все']");
        page.waitForSelector("//a[@class='PaDvSJkfKmpUlUemAC5ex' and @href]//div[text()]");
        page.waitForSelector("//div[contains(@class,'programs')]");
        page.waitForSelector("//div[@class='_2H8yToCwb1zXChwX6l7ZNT']");
//        page.waitForSelector("//a[contains(@class,'LayoutBottomMenu_linkActive')]//span[text()='Главная']");
        // чек проверки коллекции элементов в блоках расписания:
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("._23E9FFV9LhyYMGP2R_4Hjv").size());
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//a[contains(@class,'3S1RJTAMPdfXwKpE8keuSk') and text()]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//a[contains(@class,'_2kFyYGffe-aoW_cqXclDoD') and text() and @href]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ') and text()]").size());
        Assert.assertEquals(page.querySelectorAll("//div[contains(@class,'programs')]").size(), page.querySelectorAll("//a[contains(@class,'showAll') and text()='Показать все']").size());
        Assert.assertEquals(page.querySelectorAll("//div[contains(@class,'programs')]").size(), page.querySelectorAll("//a[@class='_1nNLUKHkEqjSZVxbjx3w8z']//*[@fill]").size());
    }

    public void checkImageTvPageForUserMWEB() throws IOException, InterruptedException {
        // Сделать тестовый скриншот таба программы передач:
        page.navigate(frontend + "tv");
        // подготовка полной страницы "TvPageTabProgramTvForUser" к скриншот-тесту:
        List<ElementHandle> imgTvAll = page.querySelectorAll("//div[@class='_23E9FFV9LhyYMGP2R_4Hjv']");
        for (ElementHandle imgTv : imgTvAll) {
            imgTv.evaluate("iT => iT.setAttribute('style', 'background-image: url(http://static.cdn.megafon.tv/images/Channel/27/3d/b7235e2c57e71de7283e923dec5feedfb69b/logo_on_air__iphone-x.png);')");
        }
        List<ElementHandle> nameTvChannelAll = page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko']");
        for (ElementHandle nameTvChannel : nameTvChannelAll) {
            nameTvChannel.evaluate("n => n.innerText='Название канала'");
        }
        List<ElementHandle> nameTvProgramAll = page.querySelectorAll("//a[contains(@class,'_2kFyYGffe-aoW_cqXclDoD')]");
        for (ElementHandle nameTvProgram : nameTvProgramAll) {
            nameTvProgram.evaluate("d => d.textContent='Название передачи'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ')]");
        for (ElementHandle age : ageAll) {
            age.evaluate("a => a.innerText='18+'");
        }
        List<ElementHandle> timeAll = page.querySelectorAll("//a[@class='_3S1RJTAMPdfXwKpE8keuSk _2vXRFPIn0aB5dHsDcWV_MP']");
        for (ElementHandle time : timeAll) {
            time.evaluate("t => t.innerText='00:00'");
        }
        // делаем скриншот видимой части страницы "TvPageForUser":
        vrt.track(
                "TvPageForUserAndroidMWEB",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions())),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void scrollTvPage() throws InterruptedException {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        page.waitForSelector("//footer");
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        page.waitForSelector("//div[contains(@class,'smartbanner-android')]");
        // чек проверки коллекции элементов в блоках расписания:
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("._23E9FFV9LhyYMGP2R_4Hjv").size());
        Assert.assertEquals(page.querySelectorAll("._3_ze5yHEf0jULbEILiu0Dy").size(), page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//a[contains(@class,'3S1RJTAMPdfXwKpE8keuSk') and text()]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//a[contains(@class,'_2kFyYGffe-aoW_cqXclDoD') and text() and @href]").size());
        Assert.assertEquals(page.querySelectorAll("._2t7rDZjUkG3P1KbzR9IaaB").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ') and text()]").size());
        Assert.assertEquals(page.querySelectorAll("//div[contains(@class,'programs')]").size(), page.querySelectorAll("//a[contains(@class,'showAll') and text()='Показать все']").size());
        Assert.assertEquals(page.querySelectorAll("//div[contains(@class,'programs')]").size(), page.querySelectorAll("//a[@class='_1nNLUKHkEqjSZVxbjx3w8z']//*[@fill]").size());
    }

    public void goToCardTvProgram() throws InterruptedException {
        page.waitForSelector("//a[@class='_1nNLUKHkEqjSZVxbjx3w8z']//*[@fill]");
        page.click("//a[@class='_1nNLUKHkEqjSZVxbjx3w8z']//*[@fill]");
//        page.waitForSelector("//h1[text()]");
        Assert.assertTrue("bug: not opened card program", page.url().contains("/programs/"));
        // подключить пакет:
//        page.click("//span[contains(text(),'Смотреть за') or contains(text(),'Подключить за ')]");
//        page.waitForSelector("//div[contains(text(),'Подключение')]");
//        page.click("//div[text()='Подтвердить']");
        page.navigate(frontend + "tv");

        page.click("._2t7rDZjUkG3P1KbzR9IaaB");
        Assert.assertTrue("bug: not opened card program", page.url().contains("/programs/"));
        page.navigate(frontend + "tv");

        page.click("//a[contains(@class,'showAll') and text()='Показать все']");
        Assert.assertTrue("bug: not opened card channel", page.url().contains("/channels/"));
        page.navigate(frontend + "tv");

        page.click("._23E9FFV9LhyYMGP2R_4Hjv");
        Assert.assertTrue("bug: not opened card channel", page.url().contains("/channels/"));

    }

    public void clickOnPaymentFilter() {
        page.waitForSelector(".Ml_oz1fhp-oa2a75_b9Tp").click();
        page.waitForSelector("(//div[@role='presentation'])[1]");
        Assert.assertTrue("bug: no found element", page.querySelectorAll("//div[text()='Все телеканалы']").size() > 0);
        Assert.assertTrue("bug: no found element", page.querySelectorAll("//div[text()='Доступные телеканалы']").size() > 0);
        Assert.assertTrue("bug: no found element", page.querySelectorAll("//div[text()='Вам будут отображаться каналы, доступные по акциям и по подписке']").size() > 0);
        Assert.assertTrue("bug: no found element", page.querySelectorAll("//div[@class='_1MQ2iRagx2iMw03u_SNzhY']/following-sibling::div[text()='Все телеканалы']").size() > 0);
    }

    public void chooseFilterAvailableTvChannels() {
        ElementHandle popUp = page.waitForSelector("(//div[@role='presentation'])[1]");
        page.click("//div[text()='Доступные телеканалы']");
        Assert.assertTrue("bug: no found element", page.querySelectorAll("//div[@class='_1MQ2iRagx2iMw03u_SNzhY']/following-sibling::div[text()='Все телеканалы']").size() == 0);
        popUp.waitForElementState(ElementState.HIDDEN);
        if (page.querySelectorAll("//div[text()='Вы еще не подключили ни одного ТВ-канала']").size() != 0) {
            Assert.assertEquals(page.querySelectorAll("//div[contains(@class,'programs')]").size(), page.querySelectorAll("._2mLz14ja1zCBwrRv-RM7lg").size());
        }
        ElementHandle filter = page.waitForSelector("(//div[@class='Ml_oz1fhp-oa2a75_b9Tp']//*[@fill])[2]");
        System.out.println(filter.evaluate("e => window.getComputedStyle(e).fill"));
        Assert.assertEquals("bug: the color of the element is not white", filter.evaluate("e => window.getComputedStyle(e).fill"), "rgb(0, 185, 86)");
    }

    public void chooseFilterAllTvChannels() {
        page.waitForSelector(".Ml_oz1fhp-oa2a75_b9Tp").click();
        page.waitForSelector("(//div[@role='presentation'])[1]");
        Assert.assertTrue("bug: no found element", page.querySelectorAll("//div[@class='_1MQ2iRagx2iMw03u_SNzhY']/following-sibling::div[text()='Доступные телеканалы']").size() == 1);
        page.click("//div[text()='Все телеканалы']");
        ElementHandle popUp2 = page.waitForSelector("(//div[@role='presentation'])[1]");
        popUp2.waitForElementState(ElementState.HIDDEN);
        ElementHandle filter2 = page.waitForSelector("(//div[@class='Ml_oz1fhp-oa2a75_b9Tp']//*[@fill])[2]");
        System.out.println(filter2.evaluate("e => window.getComputedStyle(e).fill"));
        Assert.assertEquals("bug: the color of the element is not white", filter2.evaluate("e => window.getComputedStyle(e).fill"), "rgb(74, 74, 74)");
    }

    public void scrollTabsFiltersTvGenres() throws InterruptedException {
        List<ElementHandle> tabFilters = page.querySelectorAll("//a[contains(@class,'_39I3V1X9nHf1r_IzNeqphS')]//div[text()]");
        tabFilters.get(tabFilters.size() - 1).hover();
        tabFilters.get(0).hover();
        List listNameTab = new ArrayList();
        listNameTab.addAll(Arrays.asList("Все", "HD", "Для детей", "Спорт", "В записи", "Кино", "Развлекательные", "Новости", "Музыкальные", "Познавательные", "Федеральные", "Эротика", "Радио"));
        for (int i = 0; i < tabFilters.size(); i++) {
            Assert.assertEquals("bug: diff names tabs", tabFilters.get(i).innerText(), listNameTab.get(i));
        }
    }

    public void chooseTabFiltersTvGenres() throws ClassNotFoundException, SQLException, InterruptedException {
        List<ElementHandle> tabFilters = page.querySelectorAll("//a[contains(@class,'_39I3V1X9nHf1r_IzNeqphS')]//div[text()]");
        tabFilters.get(2).tap();
        Assert.assertTrue("bug: size elements more 1", page.querySelectorAll("//a[@class='_39I3V1X9nHf1r_IzNeqphS _1Ue0f9dD5er3cByaAe2IwI']").size() == 1);

//        List listNameTvChannelForKids = new ArrayList(Arrays.asList("Карусель", "Канал Disney", "Уникум", "Капитан Фантастика", "Nick Jr.", "Мульт HD", "Cartoon Network", "Boomerang", "Nickelodeon", "Nickelodeon HD", "NickToons", "Мультиландия", "Ani", "Рыжий", "СТС Kids", "Gulli Girl", "В гостях у сказки", "Радость моя", "Мультимузыка", "Мульт", "О!", "Tiji", "JimJam", "Детский мир", "Малыш", "BabyTV"));

        Class.forName("org.postgresql.Driver");
        ResultSet onlyKidsTvChannel = statement.executeQuery("select * from packages p where kind = 'Channel' and 47=any(genres)");
        onlyKidsTvChannel.next();
        System.out.println(onlyKidsTvChannel.getString(1));
        List<String> listNameTvKids = new ArrayList<>();
        while (onlyKidsTvChannel.next()) {
            String data = onlyKidsTvChannel.getString(1);
            listNameTvKids.add(data);
        }

        List<ElementHandle> nameTvChannel = page.querySelectorAll("//div[@class='_3alQqB-Yd285L1GTPwG2ko']");
        for (int i = 0; i < nameTvChannel.size(); i++) {
            listNameTvKids.contains(nameTvChannel.get(i).innerText());
        }
    }

    public void checkElementsScheduleNonRecordedTv() {
        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(currentTime);
        LocalTime afterTime = LocalTime.parse(page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]/following::a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')][1]").innerText());
        System.out.println(afterTime);
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
    }

    public void checkElementsScheduleRecordedTv() {
        LocalTime currentTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(currentTime);
        LocalTime afterTime = LocalTime.parse(page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]/following::a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')][1]").innerText());
        System.out.println(afterTime);
        LocalTime timeProgram = LocalTime.parse(page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]").innerText());
        page.waitForSelector("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]");
        System.out.println(currentTime.isAfter(timeProgram) && currentTime.isBefore(afterTime));
        Assert.assertTrue(currentTime.isAfter(timeProgram) && currentTime.isBefore(afterTime));

        // чек элементов расписания:
        Assert.assertEquals("diff size elements", page.querySelectorAll("//div[contains(@class,'_1kXtsoTZpkqxm3UN7jrPUb')]").size(), page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]").size());
        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("._2mLz14ja1zCBwrRv-RM7lg").size());
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
        // Сделать тестовый скриншот карточки тв канала незаписываемого:
//        // чек элементов расписания:
//        Assert.assertEquals("diff size elements", page.querySelectorAll("//div[contains(@class,'_1kXtsoTZpkqxm3UN7jrPUb')]").size(), page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]").size());
//        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']").size());
//        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]").size());
//        Assert.assertEquals("bug: diff size elements", 8, page.querySelectorAll("//div[@class='_3JIMZ3_-3sPOGT1g7YUGmq']//div[text()]").size());
//        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']").size());
//        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='_3JIMZ3_-3sPOGT1g7YUGmq']//div[text()]").size());
//
//        // чек элементов текущей передачи:
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_30m0cUyqnN7hnERn4tZUhK')]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_3PEf1_q_VA09pRAKJq-lNW') and text()]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ') and text()]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]").size()==1);



        List<ElementHandle> imgTvAll = page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]");
        for (ElementHandle imgTv : imgTvAll) {
            imgTv.evaluate("iT => iT.setAttribute('style', 'background-image: url(http://static.cdn.megafon.tv/images/img/8f/98/876e39d28e86ef02bf81830bb8062cecf762/secondary_poster__aphone-xxhdpi.webp);')");
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
//        Assert.assertEquals("diff size elements", page.querySelectorAll("//div[contains(@class,'_1kXtsoTZpkqxm3UN7jrPUb')]").size(), page.querySelectorAll("//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO') and text()]").size());
//        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("._2mLz14ja1zCBwrRv-RM7lg").size());
//        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//a[@class='_3PEf1_q_VA09pRAKJq-lNW ApSqJlNSgQ0N0HzFbdLNL']").size());
//        Assert.assertEquals("bug: diff size elements", page.querySelectorAll("._1kXtsoTZpkqxm3UN7jrPUb").size(), page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _2i8vQnMC7E5ESPMlsA')]").size());
//        Assert.assertEquals("bug: diff size elements", 8, page.querySelectorAll("//div[@class='_3JIMZ3_-3sPOGT1g7YUGmq']//div[text()]").size());
//        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='Cl6_9tQmsP2zIDeWDecmQ']").size());
//        Assert.assertEquals("bug: diff size elements", 5, page.querySelectorAll("//div[@class='_3JIMZ3_-3sPOGT1g7YUGmq']//div[text()]").size());
//
//        // чек элементов текущей передачи:
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_2nbsgDk-YRyquxiD5jEpKO')]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_30m0cUyqnN7hnERn4tZUhK')]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//a[contains(@class,'_3PEf1_q_VA09pRAKJq-lNW') and text()]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ') and text()]").size()==1);
//        Assert.assertTrue("bug: not found elements", page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]").size()==1);

        List<ElementHandle> imgTvAll = page.querySelectorAll("//div[contains(@class,'secondaryPoster')]//div[contains(@style,'background-image: url')]");
        for (ElementHandle imgTv : imgTvAll) {
            imgTv.evaluate("iT => iT.setAttribute('style', 'background-image: url(http://static.cdn.megafon.tv/images/img/8f/98/876e39d28e86ef02bf81830bb8062cecf762/secondary_poster__aphone-xxhdpi.webp);')");
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
        // делаем скриншот видимой части страницы "CardTvChannelNonRecAndroidMWEB":
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

    public void openCardTvChannelInRecord() {
        page.waitForSelector("//a[contains(@class,'_39I3V1X9nHf1r_IzNeqphS')]//div[text()='В записи']").tap();
        page.waitForSelector("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]");
        page.tap("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]");
    }

    public void openCardTvChannelNoRecord() {
        page.waitForSelector("//a[contains(@class,'_39I3V1X9nHf1r_IzNeqphS')]//div[text()='Для детей']").tap();
        page.waitForSelector("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]");
        page.tap("//div[@class='_3alQqB-Yd285L1GTPwG2ko' and text()]");
    }

    public void scrollDownPageAndCheckFooter() {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        page.waitForSelector("//footer");
        page.waitForSelector("//a[@href and text()='Условия оказания услуги']");
        page.waitForSelector("//a[@href and text()='Политика конфидециальности']");
        page.waitForSelector("//a[@href and text()='Правила оказания телематических услуг связи']");
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        page.waitForSelector("//div[contains(@class,'smartbanner-android')]");
    }

    public void checkImageFooterMWEB() {

    }
}

