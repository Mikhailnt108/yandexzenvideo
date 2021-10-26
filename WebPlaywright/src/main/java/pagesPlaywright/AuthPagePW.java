package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.Assert;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Base64;

import static base.TestBasePlaywright.vrt;

public class AuthPagePW extends BasePagePlaywright {
    private Page page;
    private BrowserContext contextIncognitoModeHeadless;

    public AuthPagePW(Page page) {
        this.page = page;
    }

    public void checkElementsPageAuthFormInputPhone() {
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Введите номер телефона']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='Чтобы зарегистрироваться или войти в онлайн-кинотеатр МегаФон ТВ']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@value='+7']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[text()='Закрыть']").size());
    }

    public void checkImagePageAuth() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        vrt.track(
                "PageAuthFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnButtonCloseAuthAndCheckOpenNil() {
        page.waitForSelector("//button[text()='Закрыть']").click();
        Assert.assertFalse("bug: not opened page nil", page.url().contains("/auth"));
    }

    public void inputValidNumberAndCheckActiveButtonNext(String login) {
        page.fill("//input[@type='tel']", login);
        Assert.assertEquals("not active button 'Next'", 0, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
    }

    public void checkImagePageAuthWithValidNumber() throws IOException, InterruptedException {
        Thread.sleep(3000);
        ElementHandle formAuthWithValidNumber = page.waitForSelector("//div[contains(@class,'AuthPage_stepsWrap')]");
        vrt.track(
                "formAuthWithValidNumber",
                Base64.getEncoder().encodeToString(formAuthWithValidNumber.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.1f)
                        .build());
    }

    public void clickOnButtonNextAndCheckOpenFormCreatePassword() {
        page.click("//button[text()='Далее']");
        Assert.assertTrue("not open form 'create password'", page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible());
    }

    public void checkElementsPageAuthFormCreatePassword() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Придумайте пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='Для регистрации в МегаФон ТВ']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Придумайте пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[text()='От 6 цифр']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//a[@href and text()='Я согласен с условиями оферты']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@type='checkbox' and @name='accept']").size());
    }

    public void checkOpenPopUpInputPhone() {
        page.waitForSelector("//h1[text()='Введите номер телефона']");
    }

    public void inputLogin(String login) {
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
    }

    public void clickOnButtonBackAndCheckOpenFormInputPhone() throws InterruptedException {
        Thread.sleep(3000);
        page.click("//button[contains(@class,'buttonBack')]");
        page.click("//button[contains(@class,'buttonBack')]");
        Thread.sleep(15000);
        Assert.assertTrue("not visible element", page.waitForSelector("//h1[text()='Введите номер телефона']").isVisible());
    }

    public void clickOnOffertaAndCheckOpenDoc() {
        Page newPage = contextIncognitoModeHeadless.waitForPage(() -> {
            page.waitForSelector("//a[@href and text()='Я согласен с условиями оферты']").click();
        });
        newPage.waitForLoadState();
        System.out.println(newPage.url());
        Assert.assertTrue("bug: not opened pdf 'mediaportal_oferta.pdf'", newPage.url().contains("/download/~federal/oferts/mediaportal_oferta.pdf"));
        page.bringToFront();

    }

    public void inputPasswordRegisterLessThanSixSimbol(String password) {
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[@disabled and text()='Далее']");
    }

    public void unCheckBoxAndInputPasswordSixSimbols(String password) throws InterruptedException {
        page.waitForSelector("//label[contains(@class,'Checkbox')]").isChecked();
        page.uncheck("//label[contains(@class,'Checkbox')]");
        Assert.assertFalse("not unChecked box", page.waitForSelector("//label[contains(@class,'Checkbox')]").isChecked());
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[@disabled and text()='Далее']");
    }

    public void checkBoxAndInputPasswordSixSimbols(String password) {
        page.check("//label[contains(@class,'Checkbox')]");
        Assert.assertTrue("not checked box", page.waitForSelector("//label[contains(@class,'Checkbox')]").isChecked());
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        Assert.assertEquals("not active button", 0, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
    }

    public void checkImagePageAuthFormCreatePassword() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        vrt.track(
                "PageAuthFormCreatePasswordValidPassword",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnButtonNextAndCheckOpenFormInputCode() {
        page.waitForSelector("//button[text()='Далее']").click();
        Assert.assertTrue("not visible element", page.waitForSelector("//h1[text()='Введите код']").isVisible());
    }

    public void inputValidPasswordRegister(String password) {
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
    }

    public void checkElementsPageAuthFormInputCode() {
// page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());
// form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Введите код']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'CheckConfirmation_desc') and text()='На номер ']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[contains(@class,'CheckConfirmation_phone') and text()='+79260010101']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'CheckConfirmation_desc') and text()=' отправлено sms с кодом подтверждения']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Введите код из sms']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[contains(@class,'timer')]").size());

        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'submitButton') and @disabled and text()='Войти']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Получить новый код']").size());
        }

    public void checkTimerFormInputCode() {
        LocalTime currentTimer = LocalTime.parse(page.querySelector("//span[contains(@class,'timer')]").innerText());
        LocalTime beforeTimer = LocalTime.parse("10:00");
        LocalTime afterTimer = LocalTime.parse("09:00");
        System.out.println(currentTimer);
        System.out.println(beforeTimer);
        System.out.println(afterTimer);
        System.out.println(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));
        Assert.assertTrue(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));
    }

    public void clickOnButtonBackAndCheckOpenFormInputPassword() {
        page.waitForSelector("//button[contains(@class,'buttonBack')]").click();
        Assert.assertTrue("not visible element", page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible());
    }

    public void checkInputInvalidCodeInFormInputCode(String login, String password, String code) {
        page.navigate("https://web-preprod6.megafon.tv/");
        page.querySelector("//button[contains(@class,'ch-account-controller')]");
        page.click("//button[contains(@class,'ch-account-controller')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
        page.click("//button[text()='Далее']");
        Assert.assertTrue("not open form 'create password'", page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible());
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[text()='Далее']").click();
        Assert.assertTrue("not visible element", page.waitForSelector("//h1[text()='Введите код']").isVisible());
        page.fill("//input[@placeholder='Введите код из sms']", code);
        page.click("//button[text()='Войти']");
        ElementHandle errorText = page.waitForSelector("//span[contains(@class,'FormInput_error') and text()='Неверный код']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[contains(@class,'FormInput_error') and text()='Неверный код']").size());
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assert.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
    }

    public void checkImageFormInputCodeForInvalidCode() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        ElementHandle formInputCodeForInvalidCode = page.waitForSelector("//div[contains(@class,'AuthPage_stepsWrap')]");
        page.querySelector("//span[contains(@class,'timer')]").evaluate("t => t.innerText='00:05'");
        vrt.track(
                "PageAuthFormInputCodeForInvalidCode",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkFinishTimerFormInputCode(String login, String password) throws InterruptedException {
        page.navigate("https://web-preprod6.megafon.tv/");
        page.querySelector("//button[contains(@class,'ch-account-controller')]");
        page.click("//button[contains(@class,'ch-account-controller')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
        page.click("//button[text()='Далее']");
        Assert.assertTrue("not open form 'create password'", page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible());
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[text()='Далее']").click();
        Assert.assertTrue("not visible element", page.waitForSelector("//h1[text()='Введите код']").isVisible());
        Thread.sleep(10000); // ожидание истечения таймера
        page.waitForSelector("//span[contains(@class,'FormInput_error') and text()='Время истекло']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'submitButton') and @disabled and text()='Войти']").size());
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Получить новый код']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[text()='Отправить повторно']").size());
    }

    public void clickResendCodeAndCheckСompletionAuth() {
        page.click("//button[text()='Отправить повторно']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'CheckConfirmation_desc') and text()=' отправлено sms с кодом подтверждения']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Введите код из sms']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[contains(@class,'timer')]").size());

    }

    public void loginOut() {
        page.click("(//span[contains(text(),'+792')])[2]");
        page.waitForSelector("(//span[text()='Выйти'])[1]").click();
        page.waitForSelector("(//span[text()='Вход'])[1]");
    }

    public void checkOpenPageAuthFormInputPassword(String login) {
        page.navigate("https://web-preprod6.megafon.tv/");
        page.querySelector("//button[contains(@class,'ch-account-controller')]");
        page.click("//button[contains(@class,'ch-account-controller')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
        page.click("//button[text()='Далее']");
        Assert.assertTrue("not visible element", page.waitForSelector("//h1[text()='Введите пароль']").isVisible());
    }

    public void checkElementsPageAuthFormInputPassword() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Введите пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='Для авторизации в МегаФон ТВ']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Введите пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Войти']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[text()='Я не помню пароль']").size());
    }

    public void clickOnButtonForgotPasswordInFormInputPhone() throws InterruptedException {
        page.waitForSelector("//button[text()='Я не помню пароль']");
        page.click("//button[text()='Я не помню пароль']");
        Thread.sleep(3000);
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Смена пароля']").size());
    }

    public void checkImagePageAuthFormChangePassword() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        vrt.track(
                "PageAuthFormChangePasswordFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkElementsPageAuthFormChangePassword() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Смена пароля']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='После смены пароля будет автоматически произведена деавторизация аккаунта на всех подключенных устройствах']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[text()='Сменить пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[text()='Спасибо, не надо']").size());
    }

    public void clickOnButtonNoAndCheckOpenFormInputPassword() {
        page.waitForSelector("//button[text()='Спасибо, не надо']").click();
        Assert.assertTrue("not visible element", page.waitForSelector("//input[@placeholder='Введите пароль']").isVisible());
    }

    public void inputPasswordAuthLessThanSixSimbol(String password) {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[@disabled and text()='Далее']");
    }

    public void checkInputValidPasswordAuth(String password) throws InterruptedException {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Войти']").size());
        ElementHandle buttonComeIn = page.waitForSelector("//button[text()='Войти']");
        Thread.sleep(6000);
        String background = (String) buttonComeIn.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: the color of the element is not green", background.contains("rgb(0, 215, 86)"));
    }
    public void checkInputInvalidPasswordAuth(String password) throws InterruptedException {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Войти']").size());
        Thread.sleep(3000);
        ElementHandle buttonNext = page.waitForSelector("//button[text()='Войти']");
        String background = (String) buttonNext.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: the color of the element is not green", background.contains("rgb(0, 215, 86)"));
    }

    public void checkImageInputValidPasswordAuth() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        vrt.track(
                "PageWithInputValidPasswordAuthFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickOnButtonEnterForInvalidPasswordAndCheckElements() {
        page.click("//button[text()='Войти']");
        ElementHandle errorText = page.waitForSelector("//span[contains(@class,'FormInput_error') and text()='Неверный пароль']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[contains(@class,'FormInput_error') and text()='Неверный пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonClear')]").size());
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assert.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
    }


    public void checkImageInputInvalidPasswordAuth() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        vrt.track(
                "PageWithInputInvalidPasswordAuthFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkInputThreeTimesInvalidPasswordAuth(String login, String password) {
        for (int i = 0; i <= 3; i++) {
        page.querySelector("//div[text()='Введите пароль']");
        page.click("//button[contains(@class,'buttonClear')]");
        page.fill("//input[@type='password']", password);
        page.click("//button[text()='Войти']");
        page.waitForSelector("//button[contains(@class,'buttonClear')]");
        }
        ElementHandle errorText = page.waitForSelector("//span[contains(@class,'FormInput_error') and contains(text(),'Повторите ввод пароля через')]");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[contains(@class,'FormInput_error') and contains(text(),'Повторите ввод пароля через')]").size());
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assert.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
//        LocalTime currentTimer = LocalTime.parse(page.querySelector("//span[contains(@class,'timer')]").innerText());
//        LocalTime beforeTimer = LocalTime.parse("10:00");
//        LocalTime afterTimer = LocalTime.parse("09:00");
//        System.out.println(currentTimer);
//        System.out.println(beforeTimer);
//        System.out.println(afterTimer);
//        System.out.println(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));
//        Assert.assertTrue(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));

    }

    public void checkImageInputThreeTimesInvalidPasswordAuth() throws IOException, InterruptedException {
        page.waitForSelector("//span[contains(@class,'FormInput_error') and contains(text(),'Повторите ввод пароля через')]").evaluate("t => t.innerText='00:60'");
        Thread.sleep(3000);
        vrt.track(
                "PageInputThreeTimesInvalidPasswordAuthFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void waitReEnterPasswordAndCheckValidPassword(String password) throws InterruptedException {
        page.wait(60000);
        page.fill("//input[@type='password']", password);
        page.click("//button[text()='Войти']");
        page.waitForSelector("(//span[contains(text(),'+792')])[2]");

    }

    public void checkElementsPageAuthFormSuccessfullyAuth() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Вы успешно авторизовались']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='Желаем приятного просмотра и надеемся, что вы останитесь довольны!']").size());
    }

    public void checkElementsPageAuthFormSuccessfullyRegist() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Вы успешно зарегестрировались']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='Желаем приятного просмотра и надеемся, что вы останитесь довольны!']").size());
    }

    public void clickOnButtonChangePassAndCheckFormCreateNewPassword() {
        page.click("//button[text()='Сменить пароль']");
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Придумайте новый пароль']").size());
    }

    public void checkElementsPageAuthFormCreateNewPassword() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());

        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h1[text()='Придумайте новый пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='Для авторизации в МегаФон ТВ']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Придумайте пароль']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[text()='От 6 цифр']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
    }

    public void checkImagePageAuthFormCreateNewPassword() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        vrt.track(
                "PageAuthFormCreateNewPasswordFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkInputNewValidPasswordAuth(String password) throws InterruptedException {
        page.querySelector("//h1[text()='Придумайте новый пароль']");
        page.fill("//input[@type='password']", password);
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
        ElementHandle buttonNext = page.waitForSelector("//button[text()='Далее']");
        Thread.sleep(6000);
        String background = (String) buttonNext.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: the color of the element is not green", background.contains("rgb(0, 215, 86)"));
    }

    public void checkElementsPageAuthFormInputEmail() {
        // page:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//div[@class='ch-cherdak']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//footer").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//span[text()='Я согласен получать новости и подарки от МегаФон ТВ']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@type='checkbox' and @name='accept']").size());
        // form:
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//p[text()='E-mail будет использоваться для отправки чеков по операциям']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@placeholder='Введите e-mail']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//input[@type='checkbox']").size());
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
    }

    public void checkImagePageAuthFormInputEmail() throws IOException, InterruptedException {
        // делаем скриншот полной страницы "PageAuthFull":
        Thread.sleep(3000);
        vrt.track(
                "PageAuthFormInputEmailFull",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkInputInvalidEmailInFormInputEmail(String email) {
        page.querySelector("//div[text()='Введите E-mail']");
        page.fill("//input[@placeholder='E-mail']", email);
        Assert.assertEquals("not visible element", 1, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
    }

    public void checkInputValidPasswordRegist(String password) throws InterruptedException {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        Assert.assertEquals("not visible element", 0, page.querySelectorAll("//button[@disabled and text()='Далее']").size());
        ElementHandle buttonComeIn = page.waitForSelector("//button[text()='Далее']");
        Thread.sleep(3000);
        String background = (String) buttonComeIn.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assert.assertTrue("bug: the color of the element is not green", background.contains("rgb(0, 215, 86)"));
    }
}
