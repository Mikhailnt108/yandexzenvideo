package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PromoPage extends BasePageWebDriver {
    public PromoPage(WebDriver driver) {
        super(driver);
    }

    public void checkNotDefinedTariff() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[4]"));
        isElementDisplayed(By.xpath("//div[text()='Ошибка определения тарифного плана']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Из-за проблемы определения Вашего тарифного плана участие в акциях временно недоступно.Если проблема повторяется, обратитесь в службу поддержки - help@megafon.tv')]"));
    }

    public void checkNotMegafon() {
        isElementDisplayed(By.xpath("//div[contains(text(),'Переходите в МегаФон с')]"));
        isElementDisplayed((By.xpath("//button[text()='Перейти']")));
        Assert.assertEquals("Нет кнопки 'Перейти'",1, webDriver.findElements(By.xpath("//button[text()='Перейти']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void clickToButtonGoOver() {
        click(By.xpath("//button[text()='Перейти']"));
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h2[text()='Перейти в МегаФон со своим номером']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
    }

    public void checkBlockingMegafon() {
        isElementDisplayed(By.xpath("//div[text()='Вы абонент МегаФон']"));
        isElementDisplayed(By.xpath("//div[text()='Ваш номер МегаФон заблокирован']"));
        isElementDisplayed(By.xpath("//div[text()='Для просмотра пополните баланс']"));
        isElementDisplayed(By.xpath("//button[text()='Пополнить баланс телефона']"));
        click(By.linkText("Ваш МегаФон ТВ может больше! Хочу больше!"));
        isElementDisplayed(By.xpath("(//div[text()='VIP'])[2]"));
        isElementDisplayed(By.xpath("//a[@href='https://megafon.ru/go/vip_tariff']"));
        click(By.linkText("Скрыть"));
        Assert.assertEquals(0, webDriver.findElements(By.xpath("(//div[text()='VIP'])[2]")).size());
    }

    public void clickToButtonTopUpPhoneBalance() {
        click(By.xpath("//button[text()='Пополнить баланс телефона']"));
        ArrayList tabs1 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='Пополнить баланс']"));
        webDriver.close();
        webDriver.switchTo().window((String) tabs1.get(0));
    }

    public void checkVipUser() {
        isElementDisplayed(By.xpath("//div[text()='Ошибка определения тарифного плана']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Из-за проблемы определения Вашего тарифного плана участие в акциях временно недоступно.Если проблема повторяется, обратитесь в службу поддержки - help@megafon.tv')]"));
        Assert.assertEquals("Не найден текст: 'Вам доступны акции'","Вам доступны акции", webDriver.findElement(By.xpath("//div[text()='Вам доступны акции']")).getText());
        Assert.assertEquals("Не найден текст: 'Услуга без абонентской платы'","Услуга без абонентской платы", webDriver.findElement(By.xpath("//div[text()='Услуга без абонентской платы']")).getText());
    }

    public void clickButtonGoToFilms() {
        click(By.linkText("Перейти к фильмам"));
        Assert.assertEquals("Нет заголовока 'Фильмы' на странице","Фильмы", webDriver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals("Нет таба 'По акции' на странице","По акции", webDriver.findElement(By.xpath("//div[text()='По акции']")).getText());
        //isElementDisplayed(By.xpath("//div[text()='По акции']"));
    }

    public void clickButtonGoToPackage() {
        String namePackage = webDriver.findElement(By.xpath("//div[@class='_2C38LroXma7dSeUA2dhUD3' and contains(text(),'Пакет')]")).getText();
        String onlyName = namePackage.substring(7,namePackage.length() - 1);
        System.out.println(onlyName);
        click(By.xpath("(//div[contains(text(),'Пакет')]/following-sibling::div//a[@href])[1]"));
        Assert.assertEquals("не карточка пакета/не тот пакет",onlyName, webDriver.findElement(By.xpath("//div[@class='_3JWCAjonEZRvpx1iIk6Y0n']")).getText());
        isElementDisplayed(By.xpath("//div[contains(text(), 'Входит')]"));
    }

    public void checkListOfTariff() {
        click(By.linkText("Ваш МегаФон ТВ может больше! Хочу больше!"));
        isElementDisplayed(By.xpath("(//div[text()='VIP'])[2]"));
        isElementDisplayed(By.xpath("//a[@href='https://megafon.ru/go/vip_tariff']"));
        click(By.linkText("Скрыть"));
        Assert.assertEquals(0, webDriver.findElements(By.xpath("(//div[text()='VIP'])[2]")).size());
    }

    public void checkElementsWithoutBlockPersonalOffer() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
        Assert.assertEquals("Не отображается заголовок 'Акции'","Акции", webDriver.findElement(By.tagName("h1")).getText());
    }

    public void checkBundleBezPereplatMax() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Максимум']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Максимум'", "Ваш тарифный план в МегаФоне Без переплат. Максимум", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", webDriver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 020 50 27 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", webDriver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «Амедиатека»'","Сервис «Амедиатека»", webDriver.findElement(By.xpath("//div[text()='Сервис «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", webDriver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «START»'","Сервис «START»", webDriver.findElement(By.xpath("//div[text()='Сервис «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «more.tv»'","Сервис «morе.tv»", webDriver.findElement(By.xpath("//div[text()='Сервис «morе.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4, webDriver.findElements(By.xpath("//div[@class='_2C1XmA8AHRa6Twr5YKUkuU' and text()='Без дополнительной платы на 180 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundleBezPereplatVse() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Всё']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", webDriver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 020 50 27 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", webDriver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «Амедиатека»'","Сервис «Амедиатека»", webDriver.findElement(By.xpath("//div[text()='Сервис «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", webDriver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «START»'","Сервис «START»", webDriver.findElement(By.xpath("//div[text()='Сервис «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «more.tv»'","Сервис «morе.tv»", webDriver.findElement(By.xpath("//div[text()='Сервис «morе.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4, webDriver.findElements(By.xpath("//div[@class='_2C1XmA8AHRa6Twr5YKUkuU' and text()='Без дополнительной платы на 90 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundleBezPereplatInternet() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Интернет']|//div[contains(text(),'Персональный')]"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", webDriver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 020 50 27 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", webDriver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «Амедиатека»'","Сервис «Амедиатека»", webDriver.findElement(By.xpath("//div[text()='Сервис «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", webDriver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «START»'","Сервис «START»", webDriver.findElement(By.xpath("//div[text()='Сервис «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «more.tv»'","Сервис «morе.tv»", webDriver.findElement(By.xpath("//div[text()='Сервис «morе.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4, webDriver.findElements(By.xpath("//div[@class='_2C1XmA8AHRa6Twr5YKUkuU' and text()='Без дополнительной платы на 90 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundleBezPereplatZvonki() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Звонки']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", webDriver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 020 50 27 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", webDriver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «Амедиатека»'","Сервис «Амедиатека»", webDriver.findElement(By.xpath("//div[text()='Сервис «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", webDriver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «START»'","Сервис «START»", webDriver.findElement(By.xpath("//div[text()='Сервис «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «more.tv»'","Сервис «morе.tv»", webDriver.findElement(By.xpath("//div[text()='Сервис «morе.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4, webDriver.findElements(By.xpath("//div[@class='_2C1XmA8AHRa6Twr5YKUkuU' and text()='Без дополнительной платы на 90 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundlePremium() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Премиум']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", webDriver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 020 50 27 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", webDriver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «Амедиатека»'","Сервис «Амедиатека»", webDriver.findElement(By.xpath("//div[text()='Сервис «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", webDriver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «START»'","Сервис «START»", webDriver.findElement(By.xpath("//div[text()='Сервис «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Сервис «more.tv»'","Сервис «morе.tv»", webDriver.findElement(By.xpath("//div[text()='Сервис «morе.tv»']")).getText());
        Assert.assertEquals("Не найдено:",0, webDriver.findElements(By.xpath("//div[@class='_2C1XmA8AHRa6Twr5YKUkuU' and text()='Без дополнительной платы на 90 дней']")).size());
        //isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        //isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
        Assert.assertEquals("Не найден текст: 'Вам доступны акции'","Вам доступны акции", webDriver.findElement(By.xpath("//div[text()='Вам доступны акции']")).getText());
        Assert.assertEquals("Не найден текст: 'Услуга без абонентской платы'","Услуга без абонентской платы", webDriver.findElement(By.xpath("//div[text()='Услуга без абонентской платы']")).getText());
    }

    public void checkBundleCorpBezlimit() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[contains(text(),'Управляй!')]|//div[contains(text(),'Корпоративный безлимит')]"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", webDriver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 020 50 27 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон Бизнес»'","Пакет «МегаФон Бизнес»", webDriver.findElement(By.xpath("//div[text()='Пакет «МегаФон Бизнес»']")).getText());
        Assert.assertEquals("Не найдено:",0, webDriver.findElements(By.xpath("//div[@class='_2C1XmA8AHRa6Twr5YKUkuU' and text()='Без дополнительной платы на 90 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundleOsnovnoy() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Основной']"));
        isElementDisplayed(By.xpath("//div[text()='Вы абонент МегаФон']"));
        isElementDisplayed(By.xpath("//div[text()='Ваш МегаФон.ТВ может больше!']"));
    }

    public void checkOpenPromoPage() throws InterruptedException {
        Thread.sleep(3000);
        isElementDisplayed(By.xpath("//h1//span[text()='Акции']"));
    }

    public void checkExpandDiscriptionPromo() {
        click(By.xpath("(//a[@class='aeD2NhkcvTTw9nWXBCWBE' and text()='Подробнее'])[1]"));
        Assert.assertEquals("Текст не расскрыт" ,0, webDriver.findElements(By.xpath("(//div[@class='_10O7cpAXDpA_ApTVdk3tJq']//a[@role and text()='Подробнее'])[1]")).size());
        Assert.assertEquals("Текст не расскрыт" ,1, webDriver.findElements(By.xpath("(//div[@class='_10O7cpAXDpA_ApTVdk3tJq']//a[@role and text()='Скрыть'])[1]")).size());
    }

    public void checkHideDiscriptionPromo() {
        click(By.linkText("Скрыть"));
        Assert.assertEquals("Текст не скрыт" ,1, webDriver.findElements(By.xpath("(//div[@class='_10O7cpAXDpA_ApTVdk3tJq']//a[@role and text()='Подробнее'])[1]")).size());
        Assert.assertEquals("Текст не скрыт" ,0, webDriver.findElements(By.xpath("(//div[@class='_10O7cpAXDpA_ApTVdk3tJq']//a[@role and text()='Скрыть'])[1]")).size());
    }

    public void goToBackInSectionProfile() {
        webDriver.navigate().back();
        isElementDisplayed(By.xpath("//h1//span[text()='Акции']"));
    }

    public void checkElementsBlockPersonalOffers() {
        isElementDisplayed(By.xpath("//div[text()='Персональные предложения']"));
        isElementDisplayed(By.xpath("//div[@class='_2KrejOHVRy9GEczCkwro9O']"));
        List<WebElement> blockPersonalOffers = webDriver.findElements(By.xpath("//div[@class='_2ss8pvzkbGoSAF-E8M3ZaJ _2yqndJWOuX36UWc1F5T19w']"));
        Assert.assertEquals("значения не равны", blockPersonalOffers.size(), webDriver.findElements(By.xpath("//div[@class='_2KrejOHVRy9GEczCkwro9O']")).size());
        isElementDisplayed(By.xpath("//div[@class='kjFUbLahFxqq2AjHY8j2R' and contains(text(),'Осталось')]"));
        Assert.assertEquals("значения не равны", blockPersonalOffers.size(), webDriver.findElements(By.xpath("//div[@class='kjFUbLahFxqq2AjHY8j2R' and contains(text(),'Осталось')]")).size());
        isElementDisplayed(By.xpath("//div[@class='_23caaINKblFrnd9q5d4958' and text()]"));
        Assert.assertEquals("значения не равны", blockPersonalOffers.size(), webDriver.findElements(By.xpath("//div[@class='_23caaINKblFrnd9q5d4958' and text()]")).size());
        isElementDisplayed(By.xpath("//button[contains(@class,'_32FrwmXzMbl_kYjSgmRpQV undefined')]"));
    }

    public void scrollPersonalOffers() {
        WebElement positionBlockPO = webDriver.findElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"));
//        System.out.println(positionBlockPO.getCssValue("transform"));
//        Assert.assertEquals("значение не равно","translateX(0px)",positionBlockPO.getCssValue("transform"));
        // проскроллить блок РО вправо (кликнуть на стелку вправо):
        click(By.xpath("//button[contains(@class,'_32FrwmXzMbl_kYjSgmRpQV undefined')]"));
//        Assert.assertEquals("значение не равно","translateX(-400px)",positionBlockPO.getCssValue("transform"));
        Assert.assertEquals("стрелка вправо не пропала", 0, webDriver.findElements(By.xpath("//button[contains(@class,'_32FrwmXzMbl_kYjSgmRpQV undefined')]")).size());
        // проскроллить блок РО влево (кликнуть на стелку влево):
        click(By.xpath("//button[@class='_1oKGCqFlMvVD-dJjsZcmEk _32FrwmXzMbl_kYjSgmRpQV']"));
//        Assert.assertEquals("значение не равно","translateX(0px)",positionBlockPO.getCssValue("transform"));
        Assert.assertEquals("стрелка вправо не пропала", 0, webDriver.findElements(By.xpath("//button[@class='_1oKGCqFlMvVD-dJjsZcmEk _32FrwmXzMbl_kYjSgmRpQV']")).size());
    }

    public void clickToBlockPersonalOfferTypeSubscription() {
        click(By.xpath("//div[text()='POSubscription']"));
    }

    public void clickToBlockPersonalOfferTypePartner() {
        click(By.xpath("//div[text()='POPartner1']"));
    }

    public void checkAbsentBlockPoNotInterested() {
        Assert.assertEquals("отображается неинтересный блок ПП", 0, webDriver.findElements(By.xpath("//div[text()='POPartner1']")).size());
    }

    public void clickToBlockPersonalOfferTypePackageForZeroRublesForMF() {
        click(By.xpath("//div[text()='POPackageForZeroRubles']"));
    }
}
