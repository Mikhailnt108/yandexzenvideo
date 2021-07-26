package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HeaderMenuPW extends BasePagePlaywright {
    private Page page;
    private Page pageCMS;
    private BrowserContext context;
    private Browser browserHeadless;
    private Browser browserHeadfull;


    public HeaderMenuPW(Page page, Page pageCMS, BrowserContext context) {
        this.page = page;
        this.pageCMS = pageCMS;
        this.context = context;
        this.browserHeadfull = context.browser();;
        this.browserHeadless = context.browser();
    }

    public void checkNotLoggedIsCorrect() {
        page.waitForSelector("(//span[text()='Вход'])[1]");
    }

    public void clickToEnter() {
        page.click("(//span[text()='Вход'])[1]");
    }

    public void checkOpenPopUpInputPhone() {
        page.waitForSelector("//div[text()='Введите номер телефона']");
    }

    public void inputLogin(String login) {
        page.focus("//input[@name='login']");
        page.fill("//input[@name='login']", login);
    }

    public void clickToNext() {
        page.click("//button[text()='Далее']");
    }

    public void checkOpenPopUpCreatePasswordForFlowRegistrationMF(String login, String password) {
        page.waitForSelector("//div[text()='Придумайте пароль']|//div[text()='Введите пароль']");
        if (page.querySelectorAll("//div[text()='Введите пароль']").size() != 0) {

            pageCMS = browserHeadfull.newPage(new Browser.NewPageOptions().setViewportSize(1880,930));
            pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user");
            pageCMS.click("//form[@method='GET']//input[1]");
            pageCMS.fill("//form[@method='GET']//input[1]", login);
            pageCMS.click("//button[text()='Поиск']");
            pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']");
            pageCMS.click("//a[contains(@href, '/cms/households/')]");
            pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.onDialog(dialog -> dialog.accept());
            pageCMS.click("//button[text()='Удалить']");
            pageCMS.close();
            page.bringToFront();
            page.reload();
            page.waitForSelector("(//span[text()='Вход'])[1]");
            page.click("(//span[text()='Вход'])[1]");
            page.waitForSelector("//div[text()='Введите номер телефона']");
            page.focus("//input[@name='login']");
            page.fill("//input[@name='login']", login);
            page.click("//button[text()='Далее']");
            page.waitForSelector("//div[text()='Придумайте пароль']");
            page.fill("//input[@type='password']",password);
        } else {
            page.waitForSelector("//div[text()='Придумайте пароль']");
            page.fill("//input[@type='password']",password);
        }

    }

    public void goToNilPage() {
        page.navigate("https://web-preprod5.megafon.tv/");
    }

    public void clickToComeIn(String button) {
        page.click("//button[text()='Войти']");
    }

    public void checkOpenPopUpInputCode() {
        page.waitForSelector("//div[text()='Введите код']");
    }

    public void copyPasteCodMsisdn(String login) {
        pageCMS = browserHeadless.newPage(new Browser.NewPageOptions().setViewportSize(1880,930));
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/msisdn_confirmations");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        String codMsisdn = pageCMS.waitForSelector("(//td[text()='79260192144']/following-sibling::td)[4]|(//td[text()='79260172279']/following-sibling::td)[4]|(//td[text()='79260205027']/following-sibling::td)[4]").innerText();
        pageCMS.close();
        page.waitForSelector("//input[@placeholder='Код подтверждения']");
        page.fill("//input[@placeholder='Код подтверждения']",codMsisdn);
    }

    public void checkLoginUserIsCorrectFlowForMF() {
        page.waitForSelector("(//span[contains(text(),'+792')])[2]");
        page.reload();
        page.waitForLoadState();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        page.waitForLoadState();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        page.waitForLoadState();
        if (page.querySelectorAll("//div[@aria-label='Notification']").size() != 0) {
            page.click("//button[text()='Закрыть']");
        }
        page.reload();
        page.waitForLoadState();
    }

    public void deleteAccountMF(String login) {
        pageCMS = browserHeadless.newPage(new Browser.NewPageOptions());
        pageCMS.navigate("https://mc2soft:wkqKy2sWwBGFDR@bmp-preprod5.megafon.tv/cms/households?role=user");
        pageCMS.click("//form[@method='GET']//input[1]");
        pageCMS.fill("//form[@method='GET']//input[1]", login);
        pageCMS.click("//button[text()='Поиск']");
        pageCMS.waitForSelector("//td[text()='79260192144']|//td[text()='79260172279']|//td[text()='79260205027']");
        pageCMS.click("//a[contains(@href, '/cms/households/')]");
        pageCMS.waitForSelector("//h3[text()=' Информация о хаусхолде ']");
        pageCMS.click("//button[text()='Удалить']");
        pageCMS.onDialog(dialog -> dialog.accept());
        pageCMS.click("//button[text()='Удалить']");
        pageCMS.close();
    }

    public void goToTvTabTvProgramInAir() {
        page.navigate("https://web-preprod5.megafon.tv/tv/tv_catalog");
    }

    public void goToTvTabProgramTv() {
        page.navigate("https://web-preprod5.megafon.tv/tv");
    }

    public void goToFilmsPage() {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
    }
}