package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class SportPagePW extends BasePagePlaywright {
    private Page page;

    public SportPagePW(Page page) {
        this.page = page;
    }

    public void checkImageSportPageScrollForGuest() {

    }

    public void checkElementsOnPageSport() {
        Assert.assertEquals("Нет заголовка 'Спорт'", "Спорт", page.querySelector("h1").innerText());
//        Assert.assertEquals("Нет баннеров", 1, page.querySelectorAll("//div[@data-test='BannerCarousel']").size());
        Assert.assertEquals("Нет хлебных крошек", 1, page.querySelectorAll("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq']//span[text()='Главная']").size());
        Assert.assertEquals("Нет хлебных крошек", 1, page.querySelectorAll("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq']//span[text()='Спорт']").size());
        Assert.assertEquals("Нет фильтров по видам спорта", 1, page.querySelectorAll("//div[@class='_3q_f0EzH81Dg0CRPqxq8mh']").size());
        Assert.assertEquals("Нет заголовка подборки 'Спортивные телеканалы'", 1, page.querySelectorAll("//h3//div[ text()='Спортивные телеканалы']").size());
        Assert.assertEquals("Нет подборки 'Спортивные телеканалы'", 1, page.querySelectorAll("//div[text()='Спортивные телеканалы']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size());
        Assert.assertEquals("Нет заголовка подборки 'Прямой эфир'", 1, page.querySelectorAll("//h3//div[ text()='Прямой эфир']").size());
        Assert.assertEquals("Нет подборки 'Прямой эфир'", 1, page.querySelectorAll("//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size());
    }

    public void checkImageCherdakAndBannersSportPageGuest() {
    }

    public void checkImageBlockFastFiltersSportPageForGuest() {
    }

    public void checkImageBlocksCollectionSportPageFofGuest() {
    }

    public void scrollCollectionSportChannelsToRightAndLeft() throws IOException, InterruptedException {
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[1]");
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[2]");
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[3]");

        page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']");
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[4]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[5]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[6]").isVisible();

        page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev']");
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[1]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[2]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[3]").isVisible();

        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[4]").isHidden();
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[5]").isHidden();
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D'])[6]").isHidden();

        // скоролл подборки вправо до упора:
        while (page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext' and @disabled]").size() < 1) {
            page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']");
        }
        // скоролл подборки влево до упора:
        while (page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev' and @disabled]").size() < 1) {
            page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev']");
        }
    }

    public void scrollCollectionSportVodsToRightAndLeft() throws InterruptedException {
        // разовый скролл подборки вправо:
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[1]");
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[2]");
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[3]");

        page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[3]//button[@data-test='ArrowButtonNext']");
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[4]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[5]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[6]").isVisible();
// тайлы скрыты:
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[1]").isHidden();
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[2]").isHidden();
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[3]").isHidden();

        page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[3]//button[@data-test='ArrowButtonPrev']");
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[1]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[2]").isVisible();
        page.waitForSelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[3]").isVisible();
// тайлы скрыты:
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[4]").isHidden();
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[5]").isHidden();
        page.querySelector("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][3]//h3[@data-test='PackageDescriptionTitle'])[6]").isHidden();

        // скоролл подборки вправо до упора:
        while (page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[3]//button[@data-test='ArrowButtonNext' and @disabled]").size() < 1) {
            page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[3]//button[@data-test='ArrowButtonNext']");
        }
        // скоролл подборки влево до упора:
        while (page.querySelectorAll("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[3]//button[@data-test='ArrowButtonPrev' and @disabled]").size() < 1) {
            page.click("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[3]//button[@data-test='ArrowButtonPrev']");
        }
    }

    public void chooseFilterSportAndCheckTvChannels() throws Exception {
        Assert.assertEquals("Нет фильтров по видам спорта", 1, page.querySelectorAll("._1c-IybNhlrK5uOrNZTDwKw").size());
        List<ElementHandle> filterSport;
        for (int i = 1; i < page.querySelectorAll("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[contains(@class,'aAWiTSjN5rwlfrcv3oj8g')]").size(); i++) {
            Thread.sleep(5000);
            filterSport = page.querySelectorAll("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[contains(@class,'aAWiTSjN5rwlfrcv3oj8g')]");
            String sportKind = filterSport.get(i).innerText();
            System.out.println(sportKind);
            filterSport.get(i).click();
            Thread.sleep(5000);
            ElementHandle tailSportTvChannel = page.querySelector("//div[@class='_3UmDZyX05ClTVRp6p2xAZj'][1]//div[@class='lJKP8B9lCUmBeUxpmi06D']");
            tailSportTvChannel.click();
            if (sportKind.equals("Хоккей")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assert.assertTrue(titleChannel.contains("KHL"));
                System.out.println("Хоккей канал проверен");
                page.goBack();
                page.reload();
            } else if (sportKind.equals("Футбол")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assert.assertTrue(titleChannel.contains("МАТЧ"));
                System.out.println("Футбол канал проверен");
                page.goBack();
                page.reload();
                Assert.assertEquals("Нет фильтров по видам спорта", 1, page.querySelectorAll("._1c-IybNhlrK5uOrNZTDwKw").size());
            } else if (sportKind.equals("Баскетбол")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assert.assertTrue(titleChannel.contains("Мир Баскетбола"));
                System.out.println("Баскетбол канал проверен");
                page.goBack();
                page.reload();
            } else if (sportKind.equals("Боевые искусства")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assert.assertTrue(titleChannel.contains("Бокс"));
                System.out.println("Боевые искусства канал проверен");
                page.goBack();
                page.reload();
            } else if (sportKind.equals("Мотоспорт")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assert.assertTrue("не содержит 'Моторспорт'",titleChannel.contains("Моторспорт"));
                System.out.println("Моторспорт ТВ канал проверен");
                page.goBack();
                page.reload();
            }
        }
    }


    public void chooseFilterSportAndCheckTvProgram() throws Exception {
        page.reload();
        List<ElementHandle> filterSport;
        for (int i = 1; i < page.querySelectorAll("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[contains(@class,'aAWiTSjN5rwlfrcv3oj8g')]").size(); i++) {
            filterSport = page.querySelectorAll("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[contains(@class,'aAWiTSjN5rwlfrcv3oj8g')]");
            String sportKind = filterSport.get(i).innerText();
            System.out.println(sportKind);
            filterSport.get(i).click();
            Thread.sleep(3000);
            ElementHandle tailSportTvProgram = page.waitForSelector("//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//span[@class='_1VOD2HVjO24JlwN9I3tRYd']");
                if (sportKind.equals("Хоккей")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assert.assertTrue(nameChannel.contains("KHL"));
                    System.out.println("Хоккей передача проверена");
                } else if (sportKind.equals("Футбол")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assert.assertTrue(nameChannel.contains("МАТЧ"));
                    System.out.println("Футбол передача проверена");
                } else if (sportKind.equals("Баскетбол")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assert.assertTrue(nameChannel.contains("Мир Баскетбола"));
                    System.out.println("Баскетбол передача проверена");
                } else if (sportKind.equals("Боевые искусства")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assert.assertTrue(nameChannel.contains("Бокс"));
                    System.out.println("Бокс передача проверена");
                } else if (sportKind.equals("Мотоспорт")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assert.assertTrue(nameChannel.contains("Мотоpспорт"));
                    System.out.println("Мотоспорт передача проверена");
                }
            }
        }

    public void checkImageBlockCollectionSportChannelsFofUser() {
    }

    public void checkElementsBlockCollectionLiveBroadcastForUser() {
        page.waitForSelector("//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']");
        page.waitForSelector("//h3[@class='B5LYgjhfyG3wLcjaaFyLM']//div[text()='Прямой эфир']");
        // tail1
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3)[1]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span)[1]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')])[1]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='FCoKPl8Il5RNSPo2CDFAk'])[1]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]");

        // tail2
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3)[2]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span)[2]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')])[2]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='FCoKPl8Il5RNSPo2CDFAk'])[2]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m'])[2]");

        // tail3
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3)[3]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span)[3]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')])[3]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='FCoKPl8Il5RNSPo2CDFAk'])[3]");
        page.waitForSelector("(//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m'])[3]");
    }

    public void checkImageBlockCollectionLiveBroadcastForUser() {

    }

    public void createSportKindsAndAddChannels() {
        // Создание 'вид спорта - футбол':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%A4%D1%83%D1%82%D0%B1%D0%BE%D0%BB&alias=football&title=%D0%A4%D1%83%D1%82%D0%B1%D0%BE%D0%BB&description=%D0%A4%D1%83%D1%82%D0%B1%D0%BE%D0%BB&weight=1&is_hidden=false").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - хоккей':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%A5%D0%BE%D0%BA%D0%BA%D0%B5%D0%B9&alias=hockey&title=%D0%A5%D0%BE%D0%BA%D0%BA%D0%B5%D0%B9&description=%D0%A5%D0%BE%D0%BA%D0%BA%D0%B5%D0%B9&weight=2&is_hidden=false").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - баскетбол':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%91%D0%B0%D1%81%D0%BA%D0%B5%D1%82%D0%B1%D0%BE%D0%BB&alias=basketball&title=%D0%91%D0%B0%D1%81%D0%BA%D0%B5%D1%82%D0%B1%D0%BE%D0%BB&description=%D0%91%D0%B0%D1%81%D0%BA%D0%B5%D1%82%D0%B1%D0%BE%D0%BB&weight=4&is_hidden=false").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - моторспорт':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%9C%D0%BE%D1%82%D0%BE%D1%80%D1%81%D0%BF%D0%BE%D1%80%D1%82&alias=motorsport&title=%D0%9C%D0%BE%D1%82%D0%BE%D1%80%D1%81%D0%BF%D0%BE%D1%80%D1%82&description=%D0%9C%D0%BE%D1%82%D0%BE%D1%80%D1%81%D0%BF%D0%BE%D1%80%D1%82&weight=6&is_hidden=false").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - боевые искусства':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%91%D0%BE%D0%B5%D0%B2%D1%8B%D0%B5+%D0%B8%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%B0&alias=fight&title=%D0%91%D0%BE%D0%B5%D0%B2%D1%8B%D0%B5+%D0%B8%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%B0&description=%D0%91%D0%BE%D0%B5%D0%B2%D1%8B%D0%B5+%D0%B8%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%B0&weight=6&is_hidden=false").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));


    }
}








