package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Base64;

import static base.TestBasePlaywright.vrt;

public class AuthPagePW extends BasePagePlaywright {
    private Page page;
    private BrowserContext contextIncognitoModeHeadless;
    private String frontend;

    public AuthPagePW(Page page, String frontend) {
        this.page = page;
        this.frontend = frontend;
    }

    public void checkElementsPageAuthFormInputPhone() {
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(),"not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(),"not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");

        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Введите номер телефона']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[text()='Чтобы зарегистрироваться или войти в онлайн-кинотеатр МегаФон ТВ']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@value='+7']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[@disabled and text()='Далее']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[text()='Закрыть']").size(), "not visible element");
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
        Assertions.assertFalse(page.url().contains("/auth"), "bug: not opened page nil");
    }

    public void inputValidNumberAndCheckActiveButtonNext(String login) {
        page.fill("//input[@type='tel']", login);
        Assertions.assertEquals(0, page.querySelectorAll("//button[@disabled and text()='Далее']").size(),"not active button 'Next'");
    }

    public void checkImagePageAuthWithValidNumber() throws IOException, InterruptedException {
        Thread.sleep(3000);
        ElementHandle formAuthWithValidNumber = page.waitForSelector("//div[contains(@class,'AuthStepInputPhone')]");
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
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible(),"not open form 'create password'");
    }

    public void checkElementsPageAuthFormCreatePassword() {
        // page:
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");

        // form:
        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Придумайте пароль']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[text()='Для регистрации в МегаФон ТВ']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@placeholder='Придумайте пароль']").size(), "not visible element");
        Assertions.assertTrue(page.querySelectorAll("//span[text()='От 6 цифр']").size()==1, "not found element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[@disabled and text()='Далее']").size(),"not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//a[@href and text()='Я согласен с условиями оферты']").size(),"not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@type='checkbox' and @name='accept']").size(), "not visible element");
    }

    public void checkOpenPopUpInputPhone() {
        page.waitForSelector("//h1[text()='Введите номер телефона']|//div[text()='Введите номер телефона']");
    }

    public void inputLoginAdWeb(String login) {
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
    }
    public void inputLoginNonAdWeb(String login) {
        page.focus("//input[@name='login']");
        page.fill("//input[@name='login']", login);
    }

    public void clickOnButtonBackAndCheckOpenFormInputPhone() throws InterruptedException {
        Thread.sleep(3000);
        page.click("//button[contains(@class,'buttonBack')]");
        Thread.sleep(15000);
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Введите номер телефона']|//div[text()='Введите номер телефона']").isVisible(), "not visible element");
    }

    public void clickOnOffertaAndCheckOpenDoc() {
        Page newPage = contextIncognitoModeHeadless.waitForPage(() -> {
            page.waitForSelector("//a[@href and text()='Я согласен с условиями оферты']").click();
        });
        newPage.waitForLoadState();
        System.out.println(newPage.url());
        Assertions.assertTrue(newPage.url().contains("/download/~federal/oferts/mediaportal_oferta.pdf"),"bug: not opened pdf 'mediaportal_oferta.pdf'");
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
        Assertions.assertFalse(page.waitForSelector("//label[contains(@class,'Checkbox')]").isChecked(), "not unChecked box");
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[@disabled and text()='Далее']");
    }

    public void checkBoxAndInputPasswordSixSimbols(String password) {
        page.check("//label[contains(@class,'Checkbox')]");
        Assertions.assertTrue(page.waitForSelector("//label[contains(@class,'Checkbox')]").isChecked(), "not checked box");
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        Assertions.assertEquals(0, page.querySelectorAll("//button[@disabled and text()='Далее']").size(),"not active button");
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
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Введите код']").isVisible(), "not visible element");
    }

    public void inputValidPasswordRegister(String password) {
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
    }

    public void checkElementsPageAuthFormInputCode() {
// page:
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(),"not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");
// form:
        Assertions.assertTrue(page.querySelectorAll("//button[contains(@class,'buttonBack')]").size()==1, "not found element");
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Введите код']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'CheckConfirmation_desc') and text()='На номер ']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//span[contains(@class,'CheckConfirmation_phone') and text()='+79260010101']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'CheckConfirmation_desc') and text()=' отправлено sms с кодом подтверждения']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@placeholder='Введите код из sms']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//span[contains(@class,'timer')]").size(), "not visible element");

        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'submitButton') and @disabled and text()='Войти']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[@disabled and text()='Получить новый код']").size(), "not visible element");
        }

    public void checkTimerFormInputCode() {
        LocalTime currentTimer = LocalTime.parse(page.querySelector("//span[contains(@class,'timer')]").innerText());
        LocalTime beforeTimer = LocalTime.parse("10:00");
        LocalTime afterTimer = LocalTime.parse("09:00");
        System.out.println(currentTimer);
        System.out.println(beforeTimer);
        System.out.println(afterTimer);
        System.out.println(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));
        Assertions.assertTrue(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));
    }

    public void clickOnButtonBackAndCheckOpenFormInputPassword() {
        page.waitForSelector("//button[contains(@class,'buttonBack')]").click();
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible(), "not visible element");
    }

    public void checkInputInvalidCodeInFormInputCode(String login, String password, String code) {
        page.navigate(frontend);
        page.querySelector("//button[contains(@class,'ch-account-controller')]");
        page.click("//button[contains(@class,'ch-account-controller')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
        page.click("//button[text()='Далее']");
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible(), "not open form 'create password'");
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[text()='Далее']").click();
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Введите код']").isVisible(), "not visible element");
        page.fill("//input[@placeholder='Введите код из sms']", code);
        page.click("//button[text()='Войти']");
        ElementHandle errorText = page.waitForSelector("//span[contains(@class,'FormInput_error') and text()='Неверный код']");
        Assertions.assertEquals(1, page.querySelectorAll("//span[contains(@class,'FormInput_error') and text()='Неверный код']").size(), "not visible element");
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assertions.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
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
        page.navigate(frontend);
        page.querySelector("//button[contains(@class,'ch-account-controller')]");
        page.click("//button[contains(@class,'ch-account-controller')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
        page.click("//button[text()='Далее']");
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Придумайте пароль']").isVisible(), "not open form 'create password'");
        page.querySelector("//div[text()='Придумайте пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[text()='Далее']").click();
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Введите код']").isVisible(), "not visible element");
        Thread.sleep(10000); // ожидание истечения таймера
        page.waitForSelector("//span[contains(@class,'FormInput_error') and text()='Время истекло']");
        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'submitButton') and @disabled and text()='Войти']").size());
        Assertions.assertEquals(0, page.querySelectorAll("//button[@disabled and text()='Получить новый код']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[text()='Отправить повторно']").size(), "not visible element");
    }

    public void clickResendCodeAndCheckСompletionAuth() {
        page.click("//button[text()='Отправить повторно']");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'CheckConfirmation_desc') and text()=' отправлено sms с кодом подтверждения']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@placeholder='Введите код из sms']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//span[contains(@class,'timer')]").size(), "not visible element");

    }

    public void loginOut() {
        page.click("(//span[contains(text(),'+792')])[2]");
        page.waitForSelector("(//span[text()='Выйти'])[1]").click();
        page.waitForSelector("(//span[text()='Вход'])[1]");
    }

    public void checkOpenPageAuthFormInputPassword(String login) {
        page.navigate(frontend);
        page.querySelector("//button[contains(@class,'ch-account-controller')]");
        page.click("//button[contains(@class,'ch-account-controller')]");
        page.waitForSelector("//h1[text()='Введите номер телефона']");
        page.focus("//input[@name='phone']");
        page.fill("//input[@name='phone']", login);
        page.click("//button[text()='Далее']");
        Assertions.assertTrue(page.waitForSelector("//h1[text()='Введите пароль']").isVisible(), "not visible element");
    }

    public void checkElementsPageAuthFormInputPassword() {
        // page:
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");

        // form:
        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Введите пароль']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[text()='Для авторизации в МегаФон ТВ']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@placeholder='Введите пароль']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[@disabled and text()='Войти']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[text()='Я не помню пароль']").size(), "not visible element");
    }

    public void clickOnButtonForgotPasswordInFormInputPhone() throws InterruptedException {
        page.waitForSelector("//button[text()='Я не помню пароль']");
        page.click("//button[text()='Я не помню пароль']");
        Thread.sleep(3000);
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Смена пароля']").size(), "not visible element");
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
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");

        // form:
        Assertions.assertTrue(page.querySelectorAll("//button[contains(@class,'buttonBack')]").size()==1, "not found element");
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Смена пароля']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[text()='После смены пароля будет автоматически произведена деавторизация аккаунта на всех подключенных устройствах']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[text()='Сменить пароль']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[text()='Спасибо, не надо']").size(), "not visible element");
    }

    public void clickOnButtonNoAndCheckOpenFormInputPassword() {
        page.waitForSelector("//button[text()='Спасибо, не надо']").click();
        Assertions.assertTrue(page.waitForSelector("//input[@placeholder='Введите пароль']").isVisible(), "not visible element");
    }

    public void inputPasswordAuthLessThanSixSimbol(String password) {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        page.waitForSelector("//button[@disabled and text()='Далее']");
    }

    public void checkInputValidPasswordAuth(String password) throws InterruptedException {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        Assertions.assertEquals(0, page.querySelectorAll("//button[@disabled and text()='Войти']").size(), "bug: not visible element");
        ElementHandle buttonComeIn = page.waitForSelector("//button[text()='Войти']");
        Thread.sleep(6000);
        String background = (String) buttonComeIn.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assertions.assertTrue(background.contains("rgb(0, 215, 86)"), "bug: the color of the element is not green");
    }
    public void checkInputInvalidPasswordAuth(String password) throws InterruptedException {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        Assertions.assertEquals(0, page.querySelectorAll("//button[@disabled and text()='Войти']").size(), "bug: not visible element");
        Thread.sleep(3000);
        ElementHandle buttonNext = page.waitForSelector("//button[text()='Войти']");
        String background = (String) buttonNext.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assertions.assertTrue(background.contains("rgb(0, 215, 86)"), "bug: the color of the element is not green");
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

    public void clickOnButtonEnterForInvalidPasswordAndCheckElements() throws InterruptedException {
        page.click("//button[text()='Войти']");
        ElementHandle errorText = page.waitForSelector("//span[contains(@class,'FormInput_error') and text()='Неверный пароль']");
        Assertions.assertEquals(1, page.querySelectorAll("//span[contains(@class,'FormInput_error') and text()='Неверный пароль']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'buttonClear')]").size(), "not visible element");
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assertions.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
        Thread.sleep(2000);
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

    public void checkInputThreeTimesInvalidPasswordAuth(String login, String password) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
        page.querySelector("//div[text()='Введите пароль']");
        page.click("//button[contains(@class,'buttonClear')]");
        Thread.sleep(3000);
        ElementHandle input = page.waitForSelector("//input[@placeholder='Введите пароль']");
        input.fill("1");
        page.keyboard().press("Control+A");
        page.keyboard().press("Delete");
        input.fill(password);
        Thread.sleep(3000);
        page.waitForSelector("//button[text()='Войти']").click();
        page.waitForSelector("//button[contains(@class,'buttonClear')]");
        }
        ElementHandle errorText = page.waitForSelector("//span[contains(@class,'FormInput_error') and contains(text(),'Повторите ввод пароля через')]");
        Assertions.assertEquals(1, page.querySelectorAll("//span[contains(@class,'FormInput_error') and contains(text(),'Повторите ввод пароля через')]").size(), "not visible element");
        System.out.println(errorText.evaluate("e => window.getComputedStyle(e).color"));
        Assertions.assertEquals("bug: the color of the element is not red", errorText.evaluate("e => window.getComputedStyle(e).color"), "rgb(255, 58, 64)");
        LocalTime currentTimer = LocalTime.parse(page.querySelector("//span[contains(@class,'timer')]").innerText());
        LocalTime beforeTimer = LocalTime.parse("10:00");
        LocalTime afterTimer = LocalTime.parse("09:00");
        System.out.println(currentTimer);
        System.out.println(beforeTimer);
        System.out.println(afterTimer);
        System.out.println(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));
        Assertions.assertTrue(currentTimer.isAfter(afterTimer) && currentTimer.isBefore(beforeTimer));
    }

    public void checkImageInputThreeTimesInvalidPasswordAuth() throws IOException, InterruptedException {
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
        ElementHandle messageWait = page.waitForSelector("//span[contains(@class,'FormInput_error') and contains(text(),'Повторите ввод пароля через')]");
        messageWait.waitForElementState(ElementState.HIDDEN);
        page.fill("//input[@type='password']", password);
        page.click("//button[text()='Войти']");
        page.waitForSelector("(//span[contains(text(),'+792')])[2]");

    }

    public void checkElementsPageAuthFormSuccessfullyAuth() {
        // page:
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");

        // form:
        Assertions.assertTrue(page.querySelectorAll("//button[contains(@class,'buttonBack')]").size()==1, "not visible element");
        Assertions.assertTrue(page.querySelectorAll("//h1[text()='Вы успешно авторизовались']").size()==1, "not visible element");
        Assertions.assertTrue(page.querySelectorAll("//p[text()='Желаем приятного просмотра и надеемся, что вы останитесь довольны!']").size()==1, "not visible element");
    }

    public void checkElementsPageAuthFormSuccessfullyRegist() {
        // page:
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");

        // form:
        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Вы успешно зарегестрировались']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[text()='Желаем приятного просмотра и надеемся, что вы останитесь довольны!']").size(), "not visible element");
    }

    public void clickOnButtonChangePassAndCheckFormCreateNewPassword() throws InterruptedException {
        page.click("//button[text()='Сменить пароль']");
        Thread.sleep(2000);
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Придумайте новый пароль']").size(), "not visible element");
    }

    public void checkElementsPageAuthFormCreateNewPassword() {
        // page:
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");

        // form:
        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h1[text()='Придумайте новый пароль']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[text()='Для авторизации в МегаФон ТВ']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@placeholder='Придумайте пароль']").size(), "not visible element");
        Assertions.assertTrue(page.querySelectorAll("//span[text()='От 6 цифр']").size()==1, "not found element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[@disabled and text()='Далее']").size(), "not visible element");
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
        Assertions.assertEquals(0, page.querySelectorAll("//button[@disabled and text()='Далее']").size(), "not visible element");
        ElementHandle buttonNext = page.waitForSelector("//button[text()='Далее']");
        Thread.sleep(6000);
        String background = (String) buttonNext.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assertions.assertTrue(background.contains("rgb(0, 215, 86)"), "bug: the color of the element is not green");
    }

    public void checkElementsPageAuthFormInputEmail() {
        // page:
        Assertions.assertEquals(1, page.querySelectorAll("//div[@class='ch-cherdak']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//picture//img[@src='/assets/images/mftv-poster.png']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//footer").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите на Smart TV')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Доступно на всех телевизорах с функцией Smart и Android TV, приставках']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Отличное качество и звук')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Смотрите кино в отличном качестве на любом удобном для вас устройстве']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//h3[contains(@class,'FeaturesSection_featureTitle') and contains(text(),'Смотрите без доступа к интернету')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[contains(@class,'FeaturesSection_featureDesc') and text()='Скачивайте на свой смартфон фильмы, серии прямо в приложении МегаФон ТВ']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//span[text()='Я согласен получать новости и подарки от МегаФон ТВ']").size(), "not visible element");
        Assertions.assertTrue(page.querySelectorAll("//label[contains(@class,'Checkbox')]").size()>0, "not visible element");
        Assertions.assertTrue(page.waitForSelector("//label[contains(@class,'Checkbox')]").isChecked(), "not visible element");
        // form:
        Assertions.assertEquals(1, page.querySelectorAll("//button[contains(@class,'buttonBack')]").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//p[text()='E-mail будет использоваться для отправки чеков по операциям']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@placeholder='Введите e-mail']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//input[@type='checkbox']").size(), "not visible element");
        Assertions.assertEquals(1, page.querySelectorAll("//button[@disabled and text()='Далее']").size(), "not visible element");
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
        page.querySelector("//h1[text()='Введите E-mail']");
        page.fill("//input[@placeholder='Введите e-mail']", email);
        Assertions.assertEquals(1, page.querySelectorAll("//button[@disabled and text()='Далее']").size(), "not visible element");
    }

    public void checkInputValidPasswordRegist(String password) throws InterruptedException {
        page.querySelector("//div[text()='Введите пароль']");
        page.fill("//input[@type='password']", password);
        Assertions.assertEquals(0, page.querySelectorAll("//button[@disabled and text()='Далее']").size(), "not visible element");
        ElementHandle buttonComeIn = page.waitForSelector("//button[text()='Далее']");
        Thread.sleep(3000);
        String background = (String) buttonComeIn.evaluate("e => window.getComputedStyle(e).background");
        System.out.println(background);
        Assertions.assertTrue(background.contains("rgb(0, 215, 86)"), "bug: the color of the element is not green");
    }
}
