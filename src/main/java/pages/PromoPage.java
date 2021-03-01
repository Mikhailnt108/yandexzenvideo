package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class PromoPage extends BasePage {
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
        Assert.assertEquals("Нет кнопки 'Перейти'",1, driver.findElements(By.xpath("//button[text()='Перейти']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void clickToButtonGoOver() {
        click(By.xpath("//button[text()='Перейти']"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='Перейти в МегаФон со своим номером']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
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
        Assert.assertEquals(0, driver.findElements(By.xpath("(//div[text()='VIP'])[2]")).size());
    }

    public void clickToButtonTopUpPhoneBalance() {
        click(By.xpath("//button[text()='Пополнить баланс телефона']"));
        ArrayList tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs1.get(1));
        isElementDisplayed(By.xpath("//h1[text()='Пополнить баланс']"));
        driver.close();
        driver.switchTo().window((String) tabs1.get(0));
    }

    public void checkVipUser() {
        isElementDisplayed(By.xpath("//div[text()='Ошибка определения тарифного плана']"));
        isElementDisplayed(By.xpath("//span[contains(.,'Из-за проблемы определения Вашего тарифного плана участие в акциях временно недоступно.Если проблема повторяется, обратитесь в службу поддержки - help@megafon.tv')]"));
        Assert.assertEquals("Не найден текст: 'Вам доступны акции'","Вам доступны акции", driver.findElement(By.xpath("//div[text()='Вам доступны акции']")).getText());
        Assert.assertEquals("Не найден текст: 'Услуга без абонентской платы'","Услуга без абонентской платы", driver.findElement(By.xpath("//div[text()='Услуга без абонентской платы']")).getText());
    }

    public void clickButtonGoToFilms() {
        click(By.linkText("Перейти к фильмам"));
        Assert.assertEquals("Нет заголовока 'Фильмы' на странице","Фильмы", driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals("Нет таба 'По акции' на странице","По акции", driver.findElement(By.xpath("//div[text()='По акции']")).getText());
        //isElementDisplayed(By.xpath("//div[text()='По акции']"));

    }

    public void clickButtonGoToPackage() {
        click(By.linkText("Перейти в пакет"));
        Assert.assertEquals("Нет заголовка 'Пакеты' на стрвнице","Пакеты", driver.findElement(By.xpath("//span[text()='Пакеты']")).getText());
        //isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
        //Assert.assertEquals("Нет статуса 'Входит в ваш тариф' на стрвнице","Входит в ваш тариф", driver.findElement(By.xpath("//div[contains(text(),'Входит')]")).getText());
        isElementDisplayed(By.xpath("//div[contains(text(), 'Входит')]"));
    }

    public void checkListOfTariff() {
        click(By.linkText("Ваш МегаФон ТВ может больше! Хочу больше!"));
        isElementDisplayed(By.xpath("(//div[text()='VIP'])[2]"));
        isElementDisplayed(By.xpath("//a[@href='https://megafon.ru/go/vip_tariff']"));
        click(By.linkText("Скрыть"));
        Assert.assertEquals(0, driver.findElements(By.xpath("(//div[text()='VIP'])[2]")).size());

    }

    public void imageDifferBlockTarif() throws AWTException, IOException {
    }

    public void imageDifferBlockPromotions() throws AWTException, IOException {
    }

    public void checkElementsWithoutBlockPersonalOffer() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
        Assert.assertEquals("Не отображается заголовок 'Акции'","Акции", driver.findElement(By.tagName("h1")).getText());
        click(By.xpath("(//a[@class='aeD2NhkcvTTw9nWXBCWBE'])[1]"));
        Assert.assertEquals("Текст не расскрыт" ,1, driver.findElements(By.xpath("//div[@class='_3KtGW53ESdkgO-PeTDXkdm']//span")).size());
        Assert.assertEquals("Кнопка 'Скрыт' не отображается","Скрыть", driver.findElement(By.linkText("Скрыть")).getText());
        click(By.linkText("Скрыть"));
        Assert.assertEquals("Кнопка 'Подробнее' не отображается","Подробнее", driver.findElement(By.linkText("Подробнее")).getText());
        Assert.assertEquals("Текст не скрыт",0,driver.findElements(By.xpath("//div[@class='_3KtGW53ESdkgO-PeTDXkdm']//span")).size());
    }

    public void checkBundleBezPereplatMax() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Максимум']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Максимум'", "Ваш тарифный план в МегаФоне Без переплат. Максимум", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", driver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 019 21 44 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", driver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Амедиатека»'","Пакет «Амедиатека»", driver.findElement(By.xpath("//div[text()='Пакет «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", driver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «START»'","Пакет «START»", driver.findElement(By.xpath("//div[text()='Пакет «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «more.tv»'","Пакет «more.tv»", driver.findElement(By.xpath("//div[text()='Пакет «more.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4,driver.findElements(By.xpath("//div[@class='_2rMo3FpJGJLE6rvcA1kfjM']//div[text()='Без дополнительной платы на 30 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundleBezPereplatVse() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Всё']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", driver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 019 21 44 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", driver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Амедиатека»'","Пакет «Амедиатека»", driver.findElement(By.xpath("//div[text()='Пакет «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", driver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «START»'","Пакет «START»", driver.findElement(By.xpath("//div[text()='Пакет «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «more.tv»'","Пакет «more.tv»", driver.findElement(By.xpath("//div[text()='Пакет «more.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4,driver.findElements(By.xpath("//div[@class='_2rMo3FpJGJLE6rvcA1kfjM']//div[text()='Без дополнительной платы на 30 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundleBezPereplatInternet() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Интернет']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", driver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 019 21 44 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", driver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Амедиатека»'","Пакет «Амедиатека»", driver.findElement(By.xpath("//div[text()='Пакет «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", driver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «START»'","Пакет «START»", driver.findElement(By.xpath("//div[text()='Пакет «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «more.tv»'","Пакет «more.tv»", driver.findElement(By.xpath("//div[text()='Пакет «more.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4,driver.findElements(By.xpath("//div[@class='_2rMo3FpJGJLE6rvcA1kfjM']//div[text()='Без дополнительной платы на 30 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundleBezPereplatZvonki() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Без переплат. Звонки']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", driver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 019 21 44 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", driver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Амедиатека»'","Пакет «Амедиатека»", driver.findElement(By.xpath("//div[text()='Пакет «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", driver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «START»'","Пакет «START»", driver.findElement(By.xpath("//div[text()='Пакет «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «more.tv»'","Пакет «more.tv»", driver.findElement(By.xpath("//div[text()='Пакет «more.tv»']")).getText());
        Assert.assertEquals("Не найдено:",4,driver.findElements(By.xpath("//div[@class='_2rMo3FpJGJLE6rvcA1kfjM']//div[text()='Без дополнительной платы на 30 дней']")).size());
        isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
    }

    public void checkBundlePremium() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Премиум']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", driver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 019 21 44 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон»'","Пакет «МегаФон»", driver.findElement(By.xpath("//div[text()='Пакет «МегаФон»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Амедиатека»'","Пакет «Амедиатека»", driver.findElement(By.xpath("//div[text()='Пакет «Амедиатека»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «Мировое кино»'","Пакет «Мировое кино»", driver.findElement(By.xpath("//div[text()='Пакет «Мировое кино»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «START»'","Пакет «START»", driver.findElement(By.xpath("//div[text()='Пакет «START»']")).getText());
        Assert.assertEquals("Не найден текст: 'Пакет «more.tv»'","Пакет «more.tv»", driver.findElement(By.xpath("//div[text()='Пакет «more.tv»']")).getText());
        Assert.assertEquals("Не найдено:",0, driver.findElements(By.xpath("//div[@class='_2rMo3FpJGJLE6rvcA1kfjM']//div[text()='Без дополнительной платы на 30 дней']")).size());
        //isElementDisplayed(By.xpath("//div[text()='Вам доступны акции']"));
        //isElementDisplayed(By.xpath("//div[text()='Услуга без абонентской платы']"));
        Assert.assertEquals("Не найден текст: 'Вам доступны акции'","Вам доступны акции", driver.findElement(By.xpath("//div[text()='Вам доступны акции']")).getText());
        Assert.assertEquals("Не найден текст: 'Услуга без абонентской платы'","Услуга без абонентской платы", driver.findElement(By.xpath("//div[text()='Услуга без абонентской платы']")).getText());
    }

    public void checkBundleCorpBezlimit() {
        isElementDisplayed(By.xpath("(//span[text()='Акции'])[3]"));
        isElementDisplayed(By.xpath("//div[text()='Ваша тарифная опция в МегаФоне']|//div[text()='Ваш тарифный план в МегаФоне']"));
        isElementDisplayed(By.xpath("//div[text()='Корпоративный безлимит']"));
        //Assert.assertEquals("Не найден текст: 'Без переплат. Всё'", "Ваш тарифный план в МегаФоне Без переплат. Всё", driver.findElement(By.xpath("//div[text()='Без переплат. Максимум']")).getText());
        isElementDisplayed(By.xpath("//div[text()='Вам доступно без оплаты:']"));
        Assert.assertEquals("Не найден текст: 'Бесплатный видео трафик'","Бесплатный видео трафик", driver.findElement(By.xpath("//div[text()='Бесплатный видео трафик']")).getText());
        isElementDisplayed(By.xpath("//div[text()='При просмотре видео контента через мобильную сеть МегаФона интернет трафик для номера + 7 926 019 21 44 не тарифицируется']"));
        Assert.assertEquals("Не найден текст: 'Пакет «МегаФон Бизнес»'","Пакет «МегаФон Бизнес»", driver.findElement(By.xpath("//div[text()='Пакет «МегаФон Бизнес»']")).getText());
        Assert.assertEquals("Не найдено:",0, driver.findElements(By.xpath("//div[@class='_2rMo3FpJGJLE6rvcA1kfjM']//div[text()='Без дополнительной платы на 30 дней']")).size());
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
}
