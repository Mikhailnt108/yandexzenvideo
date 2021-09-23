package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;

public class CardTvChannelPW extends BasePagePlaywright {
    private Page page;

    public CardTvChannelPW (Page page) {
        this.page = page;
    }

    public void clickTvProgramRecordInCardTvChannel() {
        page.waitForSelector("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]");
        page.waitForTimeout(5000);
        page.click("(//div[contains(@class,'QZwrBDUP5ZmIJsZL6bopi')])[1]");
    }
}
