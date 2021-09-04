package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class PreconditionPW extends BasePagePlaywright {
    private Page page;
    private Statement statement;

    public PreconditionPW(Page page, Statement statement) {
        this.page = page;
        this.statement = statement;
    }

    public void createSaleInCMS() {
        // Создание стандартной скидки в CMS:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("description", "Sale AutoTest").
                multiPart("type", "percent").
                multiPart("mechanic_type","common").
                multiPart("amount","30").
                multiPart("ownership_types","rent2").
                multiPart("ownership_types","est").
                multiPart("valid_since","2021-08-01 09:09:24").
                multiPart("valid_until","2021-09-30 09:09:24").
                multiPart("sticker_text","AutoTest -30%").
                when().post("https://bmp-preprod5.megafon.tv/cms/discounts/new").
                then().statusCode(anyOf(is(200),is(302)));
    }
    public void editSaleInCMS() {
        // Редактирование имеющейся скидки в CMS:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("description", "Sale AutoTest").
                multiPart("type", "percent").
                multiPart("mechanic_type","common").
                multiPart("amount","30").
                multiPart("ownership_types","rent2").
                multiPart("ownership_types","est").
                multiPart("valid_since","2021-08-01 09:09:24").
                multiPart("valid_until","2021-09-30 09:09:24").
                multiPart("sticker_text","AutoTest -30%").
                when().post("https://bmp-preprod5.megafon.tv/cms/discounts/1/edit").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void deletePackageFromSaleCMS() {
        // Удаление пакета из скидки:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                when().post("https://bmp-preprod5.megafon.tv/cms/discounts/1/packages/delete").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void archiveOldPricePackageVseISrazuSubsNmegafon() {
        // Архивация цены SubsN megafon на пакет "Все и сразу":
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get("https://bmp-preprod5.megafon.tv/cms/packages/vse_i_srazu/package_prices/66379/archive").
                then().statusCode(anyOf(is(200), is(400), is(500)));
    }

    public void createNewPricePackageVseISrazuSubsNmegafon() throws IOException {
        // Создание цены SubsN megafon на пакет "Все и сразу":
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=vse_i_srazu&starts_at=2021-09-01+00%3A00%3A00&ends_at=2023-12-31+00%3A00%3A00&payment_type=megafon&ownership_type=subsn&price=3500&payment_interval=30&service_id=1&price_additional_attribute=none&ab_group=0&partners=megafon_tv").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/packages/vse_i_srazu/package_prices/create").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void archiveOldPricePackageVseISrazuSubsNcard() {
        // Архивация цены SubsN megafon на пакет "Все и сразу":
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get("https://bmp-preprod5.megafon.tv/cms/packages/vse_i_srazu/package_prices/66378/archive").
                then().statusCode(anyOf(is(200), is(400), is(500)));
    }

    public void createNewPricePackageVseISrazuSubsNcard() {
        // Создание цены SubsN card на пакет "Все и сразу":
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=vse_i_srazu&starts_at=2021-08-01+00%3A00%3A00&ends_at=2023-12-31+00%3A00%3A00&payment_type=card&ownership_type=subsn&price=3500&payment_interval=30&template_id=1&price_additional_attribute=none&ab_group=0&partners=megafon_tv").
                when().
                post("https://bmp-preprod5.megafon.tv/cms/packages/vse_i_srazu/package_prices/create").
                then().statusCode(anyOf(is(200),is(302)));
    }

    public void changePricePackageVseISrazuSubsNmegafon() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("update package_prices set price ='3500' where package_id ='vse_i_srazu' and ownership_type ='subsn'");
    }

    public void changePriceFilmDovodEstAndRent2() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("update package_prices set price ='100' where package_id ='Dovod_2020'");
    }

    public void changePriceEstAndRent2FirstFilm() throws SQLException, ClassNotFoundException {
        page.navigate("https://web-preprod5.megafon.tv/movies/vods");
        String urlFilm = page.waitForSelector("//a[@data-test='PackageLink' and @href]").getAttribute("href");
        System.out.println(urlFilm);
        System.out.println(urlFilm.substring(13));
        String sql = "update package_prices set price ='100' where package_id ='".concat(urlFilm.substring(13)).concat("'");
        System.out.println(sql);
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate(sql);
    }
}
