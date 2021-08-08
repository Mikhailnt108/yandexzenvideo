package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.visual_regression_tracker.sdk_java.TestRunOptions;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static base.TestBasePlaywright.vrt;

public class PromoPagePW extends BasePagePlaywright {
    private Page page;

    public PromoPagePW (Page page) {
        this.page = page;
    }

    public void checkImagePromoPageWithoutPersonalOffers() throws IOException, InterruptedException {
        page.navigate("https://web-preprod4.megafon.tv/profile/promotions");

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        ElementHandle nameTarifMF = page.querySelector("._1euSoCawCqa9mH8vBqUrAD");
        nameTarifMF.evaluate("nT => nT.innerText='Название тарифа'");

        ElementHandle numberPhone = page.querySelector("(//div[@class='_1B0lnE5auiAsmJdPHRfPOq'])[1]");
        numberPhone.evaluate("nP => nP.innerText='При просмотре видео контента через мобильную сеть МегаФона " +
                "интернет трафик для номера + 7 926 001 01 01 не тарифицируется'");
        if (page.querySelectorAll("//div[@class='_21KKyuE8LKHEcXtTdfv3wl']").size() > 1) {
            while (page.querySelectorAll("//div[@class='_21KKyuE8LKHEcXtTdfv3wl']").size() != 1) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//div[@class='_21KKyuE8LKHEcXtTdfv3wl'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='_21KKyuE8LKHEcXtTdfv3wl']").size());
            }
        }
        List<ElementHandle> blockPromoAll = page.querySelectorAll("(//div[@class='_1roPetKby_jKdS5ggJNlFx'])[2]//div[@class='_1OdPMwhbIJZwIzJl24pqkj']");
        if (blockPromoAll.size() > 10) {
            while (page.querySelectorAll("//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size() != 10) {
                page.evaluate("bP => bP.remove();", page.querySelector("(//div[@class='_1OdPMwhbIJZwIzJl24pqkj'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size());
            }
        }
        if (blockPromoAll.size() < 10) {
            while (page.querySelectorAll("(//div[@class='_1roPetKby_jKdS5ggJNlFx'])[2]//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size() != 10) {
                page.evaluate("bP => bP.appendChild(document.querySelector('._1OdPMwhbIJZwIzJl24pqkj:nth-child(5)').cloneNode(true));", page.querySelector("(//div[@class='_1roPetKby_jKdS5ggJNlFx'])[2]"));
                System.out.println(page.querySelectorAll("//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size());
            }
        }
        List<ElementHandle> namePromoAll = page.querySelectorAll("//div[@class='r6H6NK5mC_vc0zd0SmO-H']");
        for(ElementHandle namePromo : namePromoAll){
            namePromo.evaluate("bP => bP.innerText='Название акции'");
        }
        List<ElementHandle> freshAll = page.querySelectorAll("//div[@class='_3K5IFXt1w5ykpRm221zGVE']");
        for (ElementHandle fresh : freshAll){
            fresh.evaluate("f => f.remove();");
        }

        // делаем скриншот полной страницы "PagePromoScrollWithoutPersonalOffers":
        vrt.track(
                "PagePromoScrollWithoutPersonalOffers",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }
    public void checkImagePromoPageWithPersonalOffers() throws IOException, InterruptedException {
        page.navigate("https://web-preprod4.megafon.tv/profile/promotions");

        ElementHandle userLogin = page.querySelector("(//span[@class='ch-trigger__title ch-trigger__title_view_lk'])[2]");
        userLogin.evaluate("uL => uL.innerText='+79260010101'");

        ElementHandle nameTarifMF = page.querySelector("._1euSoCawCqa9mH8vBqUrAD");
        nameTarifMF.evaluate("nT => nT.innerText='Название тарифа'");

        ElementHandle numberPhone = page.querySelector("(//div[@class='_1B0lnE5auiAsmJdPHRfPOq'])[1]");
        numberPhone.evaluate("nP => nP.innerText='При просмотре видео контента через мобильную сеть МегаФона " +
                "интернет трафик для номера + 7 926 001 01 01 не тарифицируется'");
        if (page.querySelectorAll("//div[@class='_21KKyuE8LKHEcXtTdfv3wl']").size() > 1) {
            while (page.querySelectorAll("//div[@class='_21KKyuE8LKHEcXtTdfv3wl']").size() != 1) {
                page.evaluate("dU => dU.remove();", page.querySelector("(//div[@class='_21KKyuE8LKHEcXtTdfv3wl'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='_21KKyuE8LKHEcXtTdfv3wl']").size());
            }
        }
        List<ElementHandle> blockPromoAll = page.querySelectorAll("(//div[@class='_1roPetKby_jKdS5ggJNlFx'])[2]//div[@class='_1OdPMwhbIJZwIzJl24pqkj']");
        if (blockPromoAll.size() > 10) {
            while (page.querySelectorAll("//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size() != 10) {
                page.evaluate("bP => bP.remove();", page.querySelector("(//div[@class='_1OdPMwhbIJZwIzJl24pqkj'])[last()]"));
                System.out.println(page.querySelectorAll("//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size());
            }
        }
        if (blockPromoAll.size() < 10) {
            while (page.querySelectorAll("(//div[@class='_1roPetKby_jKdS5ggJNlFx'])[2]//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size() != 10) {
                page.evaluate("bP => bP.appendChild(document.querySelector('._1OdPMwhbIJZwIzJl24pqkj:nth-child(5)').cloneNode(true));", page.querySelector("(//div[@class='_1roPetKby_jKdS5ggJNlFx'])[2]"));
                System.out.println(page.querySelectorAll("//div[@class='_1OdPMwhbIJZwIzJl24pqkj']").size());
            }
        }
        List<ElementHandle> namePromoAll = page.querySelectorAll("//div[@class='r6H6NK5mC_vc0zd0SmO-H']");
        for(ElementHandle namePromo : namePromoAll){
            namePromo.evaluate("bP => bP.innerText='Название акции'");
        }
        List<ElementHandle> freshAll = page.querySelectorAll("//div[@class='_3K5IFXt1w5ykpRm221zGVE']");
        for (ElementHandle fresh : freshAll){
            fresh.evaluate("f => f.remove();");
        }

        // делаем скриншот полной страницы "PagePromoScrollWithPersonalOffers":
        vrt.track(
                "PagePromoScrollWithPersonalOffers",
                Base64.getEncoder().encodeToString(page.screenshot(new Page.ScreenshotOptions().setFullPage(true))),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void checkImageBlockPersonalOffers() throws IOException, InterruptedException {
        page.navigate("https://web-preprod4.megafon.tv/profile/promotions");
        ElementHandle blockPersonalOffers = page.querySelector("//div[@class='_3R8XGpsY2Ysyw8LfWl_ItN']");
        // делаем скриншот элемента "blockPersonalOffers":
        vrt.track(
                "blockPersonalOffers",
                Base64.getEncoder().encodeToString(blockPersonalOffers.screenshot()),
                TestRunOptions.builder()
                        .device("Acer")
                        .os("Win10 Pro")
                        .browser("Chrome")
                        .diffTollerancePercent(0.3f)
                        .build());
    }

    public void clickToBlockPersonalOfferTypeSubscription() {
        page.click("//div[text()='POSubscription']");
        page.waitForSelector("//button[text()='Активировать']");
    }
}
