package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;

public class PackagesPagePW extends BasePagePlaywright {
    private Page page;

    public PackagesPagePW(Page page) {
        this.page = page;
    }

    public void checkOpenShopPage() {
       page.waitForSelector("//div[text()='Все пакеты']");
    }

    public void clickToTailCardPackageKinoPoPodpiske() {
        page.click("//h3[text()='Кино по подписке']");
    }

    public void clickToFirstTailCardPackage() {
        page.click("(//div[@class='_1gajUi7CqFhf_qFGRX_c0_'])[1]");
    }

    public void clickToTabSerialsInMenuShopPage() {
        page.waitForSelector("(//div[text()='Сериалы'])[3]");
        page.click("(//div[text()='Сериалы'])[3]");
    }
}
