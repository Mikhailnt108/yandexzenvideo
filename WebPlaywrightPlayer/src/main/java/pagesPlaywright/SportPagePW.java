package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class SportPagePW extends BasePagePlaywright {
    private Page page;
    private String backend;
    private String frontend;

    public SportPagePW(Page page, String frontend, String backend) {
        this.page = page;
        this.backend = this.backend;
        this.frontend = frontend;
    }

    public void checkImageSportPageScrollForGuest() throws IOException, InterruptedException {
        page.navigate(frontend+"sport");
        // подготовка элемента блоки подборок к скриншот-тесту:
        List<ElementHandle> titleCollectionAll = page.querySelectorAll("//h3[@data-test='PackageListWrapperName']//a");
        for(ElementHandle titleCollection : titleCollectionAll){
            titleCollection.evaluate("t => t.innerText='Название подборки'");
        }
        List<ElementHandle> counterCollectionAll = page.querySelectorAll("//a[@data-test='PackageListWrapperMoreText']");
        for(ElementHandle counterCollection : counterCollectionAll) {
            counterCollection.evaluate("c => c.innerText='Все 100'");
        }
        List<ElementHandle> posterPackageAll = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh']");
        for(ElementHandle posterPackage : posterPackageAll){
            posterPackage.evaluate("p => p.setAttribute('style', 'background-size: cover; background-color: rgb(238, 238, 238); background-image: url(https://static-sesure.cdn.megafon.tv/images/Film/2b/69/225873adc4106412821db4043d511119118e/tile__web-wp.webp);')");
        }
        List<ElementHandle> titlePackageAll = page.querySelectorAll("//h3[@data-test='PackageDescriptionTitle']");
        for(ElementHandle titlePackage : titlePackageAll){
            titlePackage.evaluate("t => t.innerText='Название контента'");
        }
        List<ElementHandle> descriptionTextPackage1All = page.querySelectorAll("//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span");
        for(ElementHandle descriptionTextPackage1 : descriptionTextPackage1All){
            descriptionTextPackage1.evaluate("d => d.textContent='2021, Жанр'");
        }
        List<ElementHandle> ageAll = page.querySelectorAll("//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]");
        for(ElementHandle age : ageAll){
            age.evaluate("a => a.innerText='18+'");
        }

        // подготовка элемента "cherdakPageKidsForGuest" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");

        page.focus("//div[@data-test='BannerCarousel']");
        ElementHandle banners = page.querySelector("//div[@class='_3VpQMliI0kzCfTPxfHPOa- _2RpZ3dJ5og17m8Uf5So1cd poster']");

        // подготовка элемента "bannersPageKidsForGuest" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 5) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 5) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 5) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 5) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
//        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
//        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/bf/39/1be6dc78d61a95edf41452088a68fd7c7ff3/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
//        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
//        for(ElementHandle stiker : stikers){
//            stiker.evaluate("s => s.innerText='Автотест'");
//        }
//        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
//        for(ElementHandle colorStiker : colorStikers){
//            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
//        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='дата, время'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(3000);


        // делаем скриншот полной страницы "PageSportScrollForGuest":
        vrt.track(
                "PageSportScrollForGuest",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsOnPageSport() {
        Assertions.assertEquals("Нет заголовка 'Спорт'", "Спорт", page.querySelector("h1").innerText());
        Assertions.assertEquals(1, page.querySelectorAll("//div[@data-test='BannerCarousel']").size(), "Нет баннеров");
        Assertions.assertEquals(1, page.querySelectorAll("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq']//span[text()='Главная']").size(), "Нет хлебных крошек");
        Assertions.assertEquals(1, page.querySelectorAll("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq']//span[text()='Спорт']").size(), "Нет хлебных крошек");
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='_3q_f0EzH81Dg0CRPqxq8mh']").size(), "Нет фильтров по видам спорта");
        Assertions.assertEquals(1, page.querySelectorAll("//h3//div[ text()='Спортивные телеканалы']").size(), "Нет заголовка подборки 'Спортивные телеканалы'");
        Assertions.assertEquals(1, page.querySelectorAll("//div[text()='Спортивные телеканалы']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(), "Нет подборки 'Спортивные телеканалы'");
        Assertions.assertEquals(1, page.querySelectorAll("//h3//div[ text()='Прямой эфир']").size(), "Нет заголовка подборки 'Прямой эфир'");
        Assertions.assertEquals(1, page.querySelectorAll("//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(), "Нет подборки 'Прямой эфир'");
    }

    public void checkImageCherdakAndBannersSportPageGuest() throws IOException, InterruptedException {
        page.navigate(frontend+"sport");
        // подготовка элемента "cherdakPageKidsForGuest" к скриншот-тесту:
        page.focus("//div[@class='ch-cherdak']");
        ElementHandle cherdak = page.querySelector("//div[@class='ch-cherdak']");
        // делаем скриншот элемента "cherdakPageKidsForGuest":
        vrt.track(
                "cherdakPageKidsForGuest",
                Base64.getEncoder().encodeToString(cherdak.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());

        page.focus("//div[@data-test='BannerCarousel']");
        ElementHandle banners = page.querySelector("//div[@class='_3VpQMliI0kzCfTPxfHPOa- _2RpZ3dJ5og17m8Uf5So1cd poster']");
        // подготовка элемента "bannersPageKidsForGuest" к скриншот-тесту:
        List<ElementHandle> dotBefore = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        if (dotBefore.size() > 5) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 5) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//button[@data-test='CarouselDotButton'])[last()]"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        if (dotBefore.size() < 5) {
            while (page.querySelectorAll("//button[@data-test='CarouselDotButton']").size() != 5) {
                page.evaluate("newDot => newDot.appendChild(document.getElementsByClassName('_3Na2_ekd58nusdf4LI3vt0')[0].cloneNode(true));", page.querySelector("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']"));
                System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
            }
        }
        ElementHandle changeTransform = page.querySelector("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']");
        changeTransform.evaluate("ch => ch.setAttribute('style', 'transition-duration: 0s;')");

        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");

        List<ElementHandle> posters = page.querySelectorAll("//div[@class='_3H6SpMZcck2BFXiKBB5gtC dc5b4FeyE5AXbLbUa66RW']");
        for(ElementHandle poster : posters){
            poster.evaluate("p => p.setAttribute('style', 'background-image: url(https://static-sesure.cdn.megafon.tv/images/img/bf/39/1be6dc78d61a95edf41452088a68fd7c7ff3/poster__web-wp.webp);')");
        }
        List<ElementHandle> titleBanners = page.querySelectorAll("//div[@data-test='SlideTitle']");
        for(ElementHandle titleBanner : titleBanners){
            titleBanner.evaluate("t => t.innerText='Название контента'");
        }
//        List<ElementHandle> stikers = page.querySelectorAll("//div[@class='kjFUbLahFxqq2AjHY8j2R']");
//        for(ElementHandle stiker : stikers){
//            stiker.evaluate("s => s.innerText='Автотест'");
//        }
//        List<ElementHandle> colorStikers = page.querySelectorAll("//div[@class='_33eseRmm5G3s8cqfYtR0dR _1AqbFwoLFYTG_y6SmXKfYb']");
//        for(ElementHandle colorStiker : colorStikers){
//            colorStiker.evaluate("c => c.setAttribute('style', 'background-color: rgb(36, 181, 109); color: rgb(255, 255, 255); box-shadow: none;')");
//        }
        List<ElementHandle> yearAndGenres = page.querySelectorAll("//div[@data-test='SlideDescription']");
        for(ElementHandle yearAndGenre : yearAndGenres){
            yearAndGenre.evaluate("yG => yG.innerText='дата, время'");
        }
        List<ElementHandle> ages = page.querySelectorAll("//div[contains(@class,'_2lExk7vBwXdikRmrmW8iJ_ _3ee886k9ILen72-SjCqCR6')]");
        for(ElementHandle age : ages){
            age.evaluate("yG => yG.innerText='18+'");
        }
        System.out.println(page.querySelectorAll("//button[@data-test='CarouselDotButton']").size());
        page.click("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]");
        page.waitForTimeout(3000);

        // делаем скриншот элемента "bannersPageKidsForGuest":
        vrt.track(
                "bannersPageSportForGuest",
                Base64.getEncoder().encodeToString(banners.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
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
        Assertions.assertEquals(1, page.querySelectorAll("._1c-IybNhlrK5uOrNZTDwKw").size(), "Нет фильтров по видам спорта");
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
                Assertions.assertTrue(titleChannel.contains("KHL"));
                System.out.println("Хоккей канал проверен");
                page.goBack();
                page.reload();
            } else if (sportKind.equals("Футбол")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assertions.assertTrue(titleChannel.contains("МАТЧ"));
                System.out.println("Футбол канал проверен");
                page.goBack();
                page.reload();
                Assertions.assertEquals(1, page.querySelectorAll("._1c-IybNhlrK5uOrNZTDwKw").size(), "Нет фильтров по видам спорта");
            } else if (sportKind.equals("Баскетбол")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assertions.assertTrue(titleChannel.contains("Мир Баскетбола"));
                System.out.println("Баскетбол канал проверен");
                page.goBack();
                page.reload();
            } else if (sportKind.equals("Боевые искусства")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assertions.assertTrue(titleChannel.contains("Бокс"));
                System.out.println("Боевые искусства канал проверен");
                page.goBack();
                page.reload();
            } else if (sportKind.equals("Мотоспорт")) {
                String titleChannel = page.waitForSelector("._1v_D6wOANknQeJMBPo_rKK").innerText();
                Assertions.assertTrue(titleChannel.contains("Моторспорт"), "Не содержит 'Моторспорт'");
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
                    Assertions.assertTrue(nameChannel.contains("KHL"));
                    System.out.println("Хоккей передача проверена");
                } else if (sportKind.equals("Футбол")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assertions.assertTrue(nameChannel.contains("МАТЧ"));
                    System.out.println("Футбол передача проверена");
                } else if (sportKind.equals("Баскетбол")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assertions.assertTrue(nameChannel.contains("Мир Баскетбола"));
                    System.out.println("Баскетбол передача проверена");
                } else if (sportKind.equals("Боевые искусства")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assertions.assertTrue(nameChannel.contains("Бокс"));
                    System.out.println("Бокс передача проверена");
                } else if (sportKind.equals("Мотоспорт")) {
                    String nameChannel = tailSportTvProgram.innerText();
                    System.out.println(nameChannel);
                    Assertions.assertTrue(nameChannel.contains("Мотоpспорт"));
                    System.out.println("Мотоспорт передача проверена");
                }
            }
        }

    public void checkImageBlockCollectionSportChannelsFofUser() {
    }

    public void checkElementsBlockCollectionLiveBroadcast() throws InterruptedException {
        Thread.sleep(5000);
        Assertions.assertEquals(1, page.querySelectorAll("//h3//div[ text()='Прямой эфир']").size(), "Нет заголовка подборки 'Прямой эфир'");
        Assertions.assertEquals(1, page.querySelectorAll("//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(), "Нет подборки 'Прямой эфир'");
//        page.waitForSelector("//h3//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']");
//        page.waitForSelector("//h3[@class='B5LYgjhfyG3wLcjaaFyLM']//div[text()='Прямой эфир']");
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

    public void checkImageFooterSportPageForGuest() throws IOException, InterruptedException {
        page.navigate(frontend+"sport");
        ElementHandle footer = page.querySelector("//footer[@class='uy6cMg76OlWzJbrz5UGzE']");
        // делаем скриншот элемента "footerPageKidsForGuest":
        vrt.track(
                "footerPageSportForGuest",
                Base64.getEncoder().encodeToString(footer.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsBlockSportsChannels() {
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='_3q_f0EzH81Dg0CRPqxq8mh']").size(), "Not found filters kinds sport");
        Assertions.assertEquals(1, page.querySelectorAll("//h3//div[ text()='Спортивные телеканалы']").size(), "Not found title collection 'Sport Tv channels'");
        Assertions.assertEquals(1, page.querySelectorAll("//div[text()='Спортивные телеканалы']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(), "Not found title collection 'Sport Tv channels'");
    }

    public void checkElementsBlockSportsEvents() {
        Assertions.assertEquals(1, page.querySelectorAll("//h3//div[ text()='Футбол']").size(), "Not found title collection events 'Football'");
        Assertions.assertEquals(1, page.querySelectorAll("//div[text()='Футбол']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(), "Not found title collection events 'Football'");
    }

    public void checkElementsBlockSportsCompetition() {
        Assertions.assertEquals(1, page.querySelectorAll("//h3//div[ text()='Футбол']").size(), "Not found title collection competition 'Football'");
        Assertions.assertEquals(1, page.querySelectorAll("//div[text()='Футбол']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']").size(), "Not found title collection competition 'Football'");
    }

    public void clickOnBannerSportEvent() {
        page.click("//div[@data-test='BannerCarousel']");
        page.waitForSelector("(//div[text()='Спорт'])[3]");
        Assertions.assertTrue(page.url().contains("/programs/"), "bug: not opened card tv program");
        page.navigate(frontend+"sport");
        page.waitForSelector("//h1[text()='Спорт']");
        }

    public void clickOnTileSportTvChannel() {
        page.click("//div[text()='Спортивные телеканалы']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_3xyyocXFfnpUO17TYraLov']");
        page.waitForSelector("//div[contains(text(),'Спорт')]");
        Assertions.assertTrue(page.url().contains("/tv/channels/"), "bug: not opened card tv channel");
        page.navigate(frontend+"sport");
        page.waitForSelector("//h1[text()='Спорт']");
    }

    public void clickOnTileSportTvProgram() {
        page.click("//div[text()='Прямой эфир']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_3xyyocXFfnpUO17TYraLov']");
        page.waitForSelector("//div[contains(text(),'Спорт')]");
        Assertions.assertTrue(page.url().contains("/tv/channels/"), "bug: not opened card tv program");
        page.navigate(frontend+"sport");
        page.waitForSelector("//h1[text()='Спорт']");
    }

    public void scrollSportPageDownAndUp() {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
        Assertions.assertTrue(page.isVisible("//footer"));
        page.evaluate("window.scrollTo(0, -document.body.scrollHeight);");
        Assertions.assertTrue(page.isVisible("//h1[text()='Спорт']"));
    }

    public void scrollSportPageBannersToLeft() {
        page.waitForTimeout(5000);
        List<ElementHandle> BannerForSport = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        System.out.println(BannerForSport.size());
        page.click("//button[@data-test='CarouselDotButton'][1]");
        String bannerFirst = page.waitForSelector("(//div[@data-test='SlideTitle'])[2]").innerText();
        System.out.println(bannerFirst);
        page.click("//button[@data-test='leftCarouselButton']");
        page.waitForSelector("//button[@data-test='CarouselDotButton'][last()]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']");
        String bannerLast = page.waitForSelector("(//div[@data-test='SlideTitle'])[2]").innerText();
        System.out.println(bannerLast);
        Assertions.assertNotEquals(bannerFirst, bannerLast);

    }

    public void autoScrollBannersSportPage() {
        page.waitForSelector("//div[@data-test='BannerCarousel']");
        page.waitForSelector("//button[@data-test='CarouselDotButton']");
        page.waitForSelector("//button[@data-test='rightCarouselButton']");
        page.waitForSelector("//button[@data-test='leftCarouselButton']");

        String banner1 = page.waitForSelector("(//div[@data-test='SlideTitle'])[2]").innerText();
        System.out.println(banner1);
        page.waitForTimeout(5000);
        String banner2 = page.waitForSelector("(//div[@data-test='SlideTitle'])[3]").innerText();
        System.out.println(banner2);
        Assertions.assertNotEquals(banner1, banner2);
        page.waitForTimeout(5000);
        String banner3 = page.waitForSelector("(//div[@data-test='SlideTitle'])[3]").innerText();
        System.out.println(banner3);
        Assertions.assertNotEquals(banner2, banner3);
        page.waitForTimeout(5000);
        String banner4 = page.waitForSelector("(//div[@data-test='SlideTitle'])[3]").innerText();
        System.out.println(banner4);
        Assertions.assertNotEquals(banner3, banner4);
        page.waitForTimeout(5000);
        String banner5 = page.waitForSelector("(//div[@data-test='SlideTitle'])[3]").innerText();
        System.out.println(banner5);
        Assertions.assertNotEquals(banner4, banner5);
    }

    public void scrollSportPageBannersToRight() {
        page.waitForTimeout(5000);
        List<ElementHandle> BannerForSport = page.querySelectorAll("//button[@data-test='CarouselDotButton']");
        System.out.println(BannerForSport.size());
        page.click("//button[@data-test='CarouselDotButton'][last()]");
        String bannerLast = page.waitForSelector("(//div[@data-test='SlideTitle'])[2]").innerText();
        System.out.println(bannerLast);
        page.click("//button[@data-test='rightCarouselButton']");
        page.waitForSelector("//button[@data-test='CarouselDotButton']//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']");
        String bannerFirst = page.waitForSelector("(//div[@data-test='SlideTitle'])[3]").innerText();
        System.out.println(bannerFirst);
        Assertions.assertNotEquals(bannerLast, bannerFirst);
    }
}