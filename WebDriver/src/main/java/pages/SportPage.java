package pages;

import base.BasePageWebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SportPage extends BasePageWebDriver {
    public SportPage(WebDriver driver) {
        super(driver);
    }

    public void clickToTailTvChannel() throws InterruptedException {
        click(By.xpath("(//div[@class='lJKP8B9lCUmBeUxpmi06D'])[1]"));
        isElementDisplayed(By.xpath("//a[@href='/tv']//span[1]"));
    }

    public void clickToTailTvProgram() throws InterruptedException {
        click(By.xpath("(//div[@class='X6AUS0SWkRBAkOSrXkHMg _2yqndJWOuX36UWc1F5T19w'])[1]"));
        isElementDisplayed(By.xpath("(//a[@href='/tv']//span[1])"));
    }

    public void checkElementsOnPageSport() {
        Assertions.assertEquals(1, webDriver.findElements(By.xpath("//div[@data-test='BannerCarousel']")).size(), "Нет баннеров");
        Assertions.assertEquals("Нет перехода в раздел 'Спорт'", "Спорт", webDriver.findElement(By.xpath("//span[@itemprop='name' and text()='Спорт']")).getText());
        Assertions.assertEquals("Нет заголовка 'Спорт'", "Спорт", webDriver.findElement(By.tagName("h1")).getText());
        Assertions.assertEquals(1, webDriver.findElements(By.className("_1c-IybNhlrK5uOrNZTDwKw")).size(), "Нет фильтров по видам спорта");
        Assertions.assertEquals(1, webDriver.findElements(By.xpath("//h3[text()='Спортивные телеканалы']")).size(), "Нет подборки 'Спортивные каналы'");
        Assertions.assertEquals(1, webDriver.findElements(By.xpath("//h3[text()='Прямой эфир']")).size(), "Нет подборки 'Прямой эфир'");

    }

    public void scrollCollectionSportChannelsToRight() throws InterruptedException {
        String tail1 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[1]")).getText();
        String tail2 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[2]")).getText();
        String tail3 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[3]")).getText();
        String tail4 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[4]")).getText();

        click(By.xpath("(//button[@class='_2GRIyQ3Rb7C4Rjj6YcDvG5'])[2]"));
        String tail5 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[5]")).getText();
        String tail6 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[6]")).getText();
        String tail7 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[7]")).getText();
        String tail8 = webDriver.findElement(By.xpath("(//div[@class='voBSETKBvzwGQenpoI2Vt'])[8]")).getText();

        Assertions.assertNotEquals(tail1, tail5);
        Assertions.assertNotEquals(tail2, tail6);
        Assertions.assertNotEquals(tail3, tail7);
        Assertions.assertNotEquals(tail4, tail8);

        click(By.xpath("(//button[@class='_2KOIeQVzqQqBKuxqSCaF8p'])[2]"));
        Assertions.assertNotEquals(tail5, tail1);
        Assertions.assertNotEquals(tail6, tail2);
        Assertions.assertNotEquals(tail7, tail3);
        Assertions.assertNotEquals(tail8, tail4);

        //click(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[2]//button[@class='_2GRIyQ3Rb7C4Rjj6YcDvG5']"));

        //click(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[1]//button[@class='_2GRIyQ3Rb7C4Rjj6YcDvG5']//g"));
        System.out.println(webDriver.findElements(By.cssSelector("svg>g[fill='#CCC']")).size());
        System.out.println(webDriver.findElements(By.cssSelector("._3rqfV1yVNWseL50GG3hr8z:nth-child(2) ._2GRIyQ3Rb7C4Rjj6YcDvG5>svg>g[fill='#CCC']")).size());


        while (webDriver.findElements(By.cssSelector("._3rqfV1yVNWseL50GG3hr8z:nth-child(2) ._2GRIyQ3Rb7C4Rjj6YcDvG5>svg>g[fill='#CCC']")).size()>0) {
        click(By.xpath("(//button[@class='_2GRIyQ3Rb7C4Rjj6YcDvG5'])[2]"));}
        }


    public void scrollCollectionSportChannelsToLeft() throws InterruptedException {
        while (webDriver.findElements(By.cssSelector("._3rqfV1yVNWseL50GG3hr8z:nth-child(2) ._2KOIeQVzqQqBKuxqSCaF8p>svg>g[fill='#CCC']")).size()>0) {
            click(By.xpath("(//button[@class='_2KOIeQVzqQqBKuxqSCaF8p'])[2]"));}
    }

    public void autoScrollBanners() throws InterruptedException {
        String banner1 = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[2]")).getText();
        System.out.println(banner1);
        Thread.sleep(5000);
        String banner2 = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[3]")).getText();
        System.out.println(banner2);
        Assertions.assertNotEquals(banner1, banner2);
        Thread.sleep(5000);
        String banner3 = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[3]")).getText();
        System.out.println(banner3);
        Assertions.assertNotEquals(banner2, banner3);
        Thread.sleep(5000);
        String banner4 = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[3]")).getText();
        System.out.println(banner4);
        Assertions.assertNotEquals(banner3, banner4);
        Thread.sleep(5000);
        String banner5 = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[3]")).getText();
        System.out.println(banner5);
        Assertions.assertNotEquals(banner4, banner5);
    }

    public void scrollBannersToLeft() throws InterruptedException {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        Thread.sleep(2000);
        String bannerFirst = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[2]")).getText();
        System.out.println(bannerFirst);
        click(By.xpath("//button[@data-test='leftCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton'][last()]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
        Thread.sleep(2000);
        String bannerLast = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[2]")).getText();
        System.out.println(bannerLast);
        Assertions.assertNotEquals(bannerFirst, bannerLast);
    }

    public void scrollBannersToRight() throws InterruptedException {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][last()]"));
        String bannerLast = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[2]")).getText();
        System.out.println(bannerLast);
        click(By.xpath("//button[@data-test='rightCarouselButton']"));
        //isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton'][1]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
        Thread.sleep(2000);
        String bannerFirst = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[3]")).getText();
        System.out.println(bannerFirst);
        Assertions.assertNotEquals(bannerLast, bannerFirst);
    }

    public void chooseDotCarouselBanners() throws InterruptedException {
        click(By.xpath("(//button[@data-test='CarouselDotButton'])[1]"));
        Thread.sleep(2000);
        String bannerFirst = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[3]")).getText();
        System.out.println(bannerFirst);
        click(By.xpath("(//button[@data-test='CarouselDotButton'])[2]"));
        Thread.sleep(2000);
        String bannerSecond = webDriver.findElement(By.xpath("(//div[@class='_2yqndJWOuX36UWc1F5T19w'])[3]")).getText();
        System.out.println(bannerSecond);
        Assertions.assertNotEquals(bannerFirst, bannerSecond);
    }

    public void clickToBanner() throws InterruptedException {
        click(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("(//a[@href='/tv']//span[1])"));
    }

    public void checkLogoTvOnTailTvChannel() {
        List<WebElement> CollectionTailsTvProgram = webDriver.findElements(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[1]//div[@class='lJKP8B9lCUmBeUxpmi06D']"));
        List<WebElement> CollectionLogo = webDriver.findElements(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[1]//div[@class='lJKP8B9lCUmBeUxpmi06D']//div[@class='GN5qPNB7tnGPtasCnMw86']"));
        Assertions.assertEquals(CollectionTailsTvProgram.size(), CollectionLogo.size());
    }

    public void checkElementsOnTailTvProgram() {
        List<WebElement> CollectionTailsTvProgram = webDriver.findElements(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[2]//div[@class='voBSETKBvzwGQenpoI2Vt']"));
        List<WebElement> CollectionProgressBar = webDriver.findElements(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[2]//div[@class='voBSETKBvzwGQenpoI2Vt']//span[@class='L3rzdT7KYzyE1ClBQKxNL']"));
        Assertions.assertEquals(CollectionTailsTvProgram.size(), CollectionProgressBar.size());
        List<WebElement> CollectionHeaderTvProgram = webDriver.findElements(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[2]//div[@class='voBSETKBvzwGQenpoI2Vt']//div[@class='_2rsztz1qemD80Zstv2vf1r _2WHJ0mxvsyUpaq7xjCrF72 _2ceA_oHeT5HMQWXKneFypZ']"));
        Assertions.assertEquals(CollectionTailsTvProgram.size(), CollectionHeaderTvProgram.size());
    }

    public void chooseFilterSportAndCheckTvChannels() throws InterruptedException {
        Assertions.assertEquals(1, webDriver.findElements(By.className("_1c-IybNhlrK5uOrNZTDwKw")).size(), "Нет фильтров по видам спорта");
        List<WebElement> AllFiltersSport = webDriver.findElements(By.xpath("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[@class='aAWiTSjN5rwlfrcv3oj8g']"));
        for (int i = 1; i <= AllFiltersSport.size(); i++) {
            AllFiltersSport = webDriver.findElements(By.xpath("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[@class='aAWiTSjN5rwlfrcv3oj8g']"));
            String sport = AllFiltersSport.get(i-1).getText();
            AllFiltersSport.get(i-1).click();
            System.out.println(sport);
            List<WebElement> CollectionSportTvChannel = webDriver.findElements(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='lJKP8B9lCUmBeUxpmi06D']"));
            for (int a = 1; a <= CollectionSportTvChannel.size(); a++) {
                CollectionSportTvChannel = webDriver.findElements(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld']//div[@class='lJKP8B9lCUmBeUxpmi06D']"));
                CollectionSportTvChannel.get(a-1).click();
                if (sport.equals("Хоккей")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//h1[text()='КХЛ HD']|//h1[text()='КХЛ']")).getText(), webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
                    System.out.println("Хоккей канал пройден");
                } else if (sport.equals("Футбол")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//h1[text()='Матч! Футбол 1 HD']|//h1[text()='Матч! Футбол 3 HD']")).getText(), webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
                    System.out.println("Футбол канал пройден");
                } else if (sport.equals("Баскетбол")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//h1[text()='Мир Баскетбола']")).getText(), webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
                    System.out.println("Баскетбол канал пройден");
                } else if (sport.equals("Бокс")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//h1[text()='Бокс ТВ']")).getText(), webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
                    System.out.println("Бокс канал пройден");
                } else if (sport.equals("Мотоспорт")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//h1[text()='Моторспорт ТВ']")).getText(), webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
                    System.out.println("Моторспорт ТВ канал пройден");
                }
                webDriver.navigate().back();
            }
        }
    }

    public void chooseFilterSportAndCheckTvProgram() throws InterruptedException {
        webDriver.navigate().refresh();
        List<WebElement> AllFiltersSport1 = webDriver.findElements(By.xpath("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[@class='aAWiTSjN5rwlfrcv3oj8g']"));
        for (int q = 1; q <=4; q++) {
            AllFiltersSport1 = webDriver.findElements(By.xpath("//div[@class='YZBWFgwJ_YIq52D_M0HUz']//div[@class='aAWiTSjN5rwlfrcv3oj8g']"));
            AllFiltersSport1.get(q).click();
            String sport1 = AllFiltersSport1.get(q).getText();
            System.out.println(sport1);
            List<WebElement> CollectionSportTvProgram = webDriver.findElements(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[2]//div[@class='voBSETKBvzwGQenpoI2Vt']"));
            for (int b = 1; b <= CollectionSportTvProgram.size(); b++) {
                CollectionSportTvProgram = webDriver.findElements(By.xpath("(//div[@class='_3rqfV1yVNWseL50GG3hr8z'])[2]//div[@class='voBSETKBvzwGQenpoI2Vt']"));
                CollectionSportTvProgram.get(b-1).click();
                if (sport1.equals("Хоккей")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//a[text()='КХЛ HD']|//a[text()='КХЛ']")).getText(), webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
                    System.out.println("Хоккей передача пройдена");
                }
                else if (sport1.equals("Футбол")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//a[text()='Матч! Футбол 1 HD']|//a[text()='Матч! Футбол 3 HD']")).getText(), webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
                    System.out.println("Футбол передача пройдена");
                }
                else if (sport1.equals("Баскетбол")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//a[text()='Мир Баскетбола']")).getText(), webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
                    System.out.println("Баскетбол передача пройдена");
                }
                else if (sport1.equals("Бокс")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//a[text()='Бокс ТВ']")).getText(), webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
                    System.out.println("Бокс передача пройдена");
                }
                else if (sport1.equals("Мотоспорт")) {
                    Assertions.assertEquals(webDriver.findElement(By.xpath("//a[text()='Моторспорт ТВ']")).getText(), webDriver.findElement(By.className("_1nAXLMkHN0PXnwvulfBvK0")).getText());
                    System.out.println("Мотоспорт передача пройдена");
                }
                webDriver.navigate().back();

            }
        }
    }
}






