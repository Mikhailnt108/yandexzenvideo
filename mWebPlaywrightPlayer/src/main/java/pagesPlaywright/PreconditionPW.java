package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class PreconditionPW extends BasePagePlaywright {
    private Page page;
    private Statement statement;
    private String frontend;
    private String backend;

    public PreconditionPW(Page page, Statement statement, String frontend, String backend) {
        this.page = page;
        this.statement = statement;
        this.frontend = frontend;
        this.backend = backend;
    }

    public void createSaleInCMS() {
        // Создание стандартной скидки в CMS:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("description", "Sale AutoTest").
                multiPart("type", "percent").
                multiPart("mechanic_type", "common").
                multiPart("amount", "30").
                multiPart("ownership_types", "rent2").
                multiPart("ownership_types", "est").
                multiPart("valid_since", "2021-08-01 09:09:24").
                multiPart("valid_until", "2021-09-30 09:09:24").
                multiPart("sticker_text", "AutoTest -30%").
                when().post(backend+"cms/discounts/new").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void editSaleInCMS() {
        // Редактирование имеющейся скидки в CMS:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("description", "Sale AutoTest").
                multiPart("type", "percent").
                multiPart("mechanic_type", "common").
                multiPart("amount", "10").
                multiPart("ownership_types", "rent2").
                multiPart("ownership_types", "est").
                multiPart("valid_since", "2021-08-01 09:09:24").
                multiPart("valid_until", "2022-09-30 09:09:24").
                multiPart("sticker_text", "AutoTest -10%").
                when().post(backend+"cms/discounts/1/edit").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void deletePackageFromSaleCMS() {
        // Удаление пакета из скидки:
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                when().post(backend+"cms/discounts/1/packages/delete").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void archiveOldPricePackageVseISrazuSubsNmegafon() {
        // Архивация цены SubsN megafon на пакет "Все и сразу":
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get(backend+"cms/packages/vse_i_srazu/package_prices/66379/archive").
                then().statusCode(anyOf(is(200), is(400), is(500)));
    }

    public void createNewPricePackageVseISrazuSubsNmegafon() throws IOException {
        // Создание цены SubsN megafon на пакет "Все и сразу":
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=vse_i_srazu&starts_at=2021-09-01+00%3A00%3A00&ends_at=2023-12-31+00%3A00%3A00&payment_type=megafon&ownership_type=subsn&price=3500&payment_interval=30&service_id=1&price_additional_attribute=none&ab_group=0&partners=megafon_tv").
                when().
                post(backend+"cms/packages/vse_i_srazu/package_prices/create").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void archiveOldPricePackageVseISrazuSubsNcard() {
        // Архивация цены SubsN megafon на пакет "Все и сразу":
        given().auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").when().
                get(backend+"cms/packages/vse_i_srazu/package_prices/66378/archive").
                then().statusCode(anyOf(is(200), is(400), is(500)));
    }

    public void createNewPricePackageVseISrazuSubsNcard() {
        // Создание цены SubsN card на пакет "Все и сразу":
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=vse_i_srazu&starts_at=2021-08-01+00%3A00%3A00&ends_at=2023-12-31+00%3A00%3A00&payment_type=card&ownership_type=subsn&price=3500&payment_interval=30&template_id=1&price_additional_attribute=none&ab_group=0&partners=megafon_tv").
                when().
                post(backend+"cms/packages/vse_i_srazu/package_prices/create").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void changePricePackageVseISrazuSubsNmegafon() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("update package_prices set price ='3500' where package_id ='vse_i_srazu' and ownership_type ='subsn'");
    }

    public void changePriceFilmDovodEstAndRent2() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("update package_prices set price ='100' where package_id ='Dovod_2020'");
    }

    public void changePriceEstAndRent2FirstFilmSectionFilms() throws SQLException, ClassNotFoundException {
        page.navigate(frontend+"movies/vods");
        page.reload();
        String urlFilm = page.waitForSelector("(//a[@data-test='PackageLink' and @href])[2]").getAttribute("href");
        System.out.println(urlFilm);
        System.out.println(urlFilm.substring(13));
        String sql = "update package_prices set price ='4500' where package_id ='".concat(urlFilm.substring(13)).concat("'");
        System.out.println(sql);
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate(sql);
    }

    public void checkCountAdvertisingCampaign() throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        System.out.println(statement.executeQuery("select count(*) from ad_campaigns"));
//        int i = Integer.parseInt(String.valueOf(statement.executeQuery("select count(*) from ad_campaigns")));
//        while (i < 1) {
//            Class.forName("org.postgresql.Driver");
//            statement.executeUpdate("INSERT INTO code_groups (id,name,max_usages,created_at,updated_at,partner) " +
//                    "value('Test','Test', 0, 2021-08-26 00:40:35, 2021-08-26 00:40:35, megafon_tv)");
    }

    public void checkCountAndAddPersonal_Offers() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("update personal_offers set valid_until = '2020-05-01'");
        Class.forName("org.postgresql.Driver");
        ResultSet countCG = statement.executeQuery("SELECT COUNT(*) FROM personal_offers");
            countCG.next();
//            int count = countCG.getInt(1);
            System.out.println(countCG.getInt(1));
            if (countCG.getInt(1) < 4) {
                statement.executeUpdate("INSERT INTO personal_offers (name, description, cms_description, mechanics, processed_images_id, questions, params, valid_since, valid_until, created_at, updated_at, color, activation_type) VALUES('POPartner2', 'text for description', NULL, 'partner_offer', 'personal_offer/e6/e8/cf452abe8109ed0b04fcfb6b4a079bb8e07d', '{}', '{\"tnb\": {\"tnb_type\": \"\", \"package_id\": \"\", \"expiration_type\": \"\"}, \"subscription\": {\"price\": 0, \"package_id\": \"\", \"payment_interval\": 0}, \"user_filters\": {\"partners\": [\"megafon_tv\"], \"device_filter\": {\"os_types\": null, \"device_types\": null, \"manufacturers\": null}, \"msisdn_filter\": false, \"vk_only_filter\": false, \"auth_filter_multiple\": [\"megafon\"]}, \"partner_offer\": {\"partner_link\": \"https://okko.tv/\", \"partner_button\": \"OkkoTv\"}}'::jsonb::jsonb, '2021-09-11 22:28:54.000', '2021-09-14 10:57:33.000', '2021-09-03 13:44:12.000', '2021-09-14 10:57:33.000', '#310062', 'segment');");
            }
            ResultSet countCgCurrent = statement.executeQuery("SELECT COUNT(*) FROM personal_offers");
            countCgCurrent.next();
            System.out.println(countCgCurrent.getInt(1));
            if (countCgCurrent.getInt(1) < 4) {
                statement.executeUpdate("INSERT INTO personal_offers (name, description, cms_description, mechanics, processed_images_id, questions, params, valid_since, valid_until, created_at, updated_at, color, activation_type) VALUES('POPartner2', 'text for description', NULL, 'partner_offer', 'personal_offer/e6/e8/cf452abe8109ed0b04fcfb6b4a079bb8e07d', '{}', '{\"tnb\": {\"tnb_type\": \"\", \"package_id\": \"\", \"expiration_type\": \"\"}, \"subscription\": {\"price\": 0, \"package_id\": \"\", \"payment_interval\": 0}, \"user_filters\": {\"partners\": [\"megafon_tv\"], \"device_filter\": {\"os_types\": null, \"device_types\": null, \"manufacturers\": null}, \"msisdn_filter\": false, \"vk_only_filter\": false, \"auth_filter_multiple\": [\"megafon\"]}, \"partner_offer\": {\"partner_link\": \"https://okko.tv/\", \"partner_button\": \"OkkoTv\"}}'::jsonb::jsonb, '2021-09-11 22:28:54.000', '2021-09-14 10:57:33.000', '2021-09-03 13:44:12.000', '2021-09-14 10:57:33.000', '#310062', 'segment');");
            }
                ResultSet countCgCurrent2 = statement.executeQuery("SELECT COUNT(*) FROM personal_offers");
                countCgCurrent2.next();
                System.out.println(countCgCurrent2.getInt(1));

            if (countCgCurrent2.getInt(1) < 4){
                statement.executeUpdate("INSERT INTO personal_offers (name, description, cms_description, mechanics, processed_images_id, questions, params, valid_since, valid_until, created_at, updated_at, color, activation_type) VALUES('POPartner2', 'text for description', NULL, 'partner_offer', 'personal_offer/e6/e8/cf452abe8109ed0b04fcfb6b4a079bb8e07d', '{}', '{\"tnb\": {\"tnb_type\": \"\", \"package_id\": \"\", \"expiration_type\": \"\"}, \"subscription\": {\"price\": 0, \"package_id\": \"\", \"payment_interval\": 0}, \"user_filters\": {\"partners\": [\"megafon_tv\"], \"device_filter\": {\"os_types\": null, \"device_types\": null, \"manufacturers\": null}, \"msisdn_filter\": false, \"vk_only_filter\": false, \"auth_filter_multiple\": [\"megafon\"]}, \"partner_offer\": {\"partner_link\": \"https://okko.tv/\", \"partner_button\": \"OkkoTv\"}}'::jsonb::jsonb, '2021-09-11 22:28:54.000', '2021-09-14 10:57:33.000', '2021-09-03 13:44:12.000', '2021-09-14 10:57:33.000', '#310062', 'segment');");
            }
            ResultSet countCgCurrent3 = statement.executeQuery("SELECT COUNT(*) FROM personal_offers");
            countCgCurrent3.next();
            System.out.println(countCgCurrent3.getInt(1));

            if (countCgCurrent3.getInt(1) < 4){
                statement.executeUpdate("INSERT INTO personal_offers (name, description, cms_description, mechanics, processed_images_id, questions, params, valid_since, valid_until, created_at, updated_at, color, activation_type) VALUES('POPartner2', 'text for description', NULL, 'partner_offer', 'personal_offer/e6/e8/cf452abe8109ed0b04fcfb6b4a079bb8e07d', '{}', '{\"tnb\": {\"tnb_type\": \"\", \"package_id\": \"\", \"expiration_type\": \"\"}, \"subscription\": {\"price\": 0, \"package_id\": \"\", \"payment_interval\": 0}, \"user_filters\": {\"partners\": [\"megafon_tv\"], \"device_filter\": {\"os_types\": null, \"device_types\": null, \"manufacturers\": null}, \"msisdn_filter\": false, \"vk_only_filter\": false, \"auth_filter_multiple\": [\"megafon\"]}, \"partner_offer\": {\"partner_link\": \"https://okko.tv/\", \"partner_button\": \"OkkoTv\"}}'::jsonb::jsonb, '2021-09-11 22:28:54.000', '2021-09-14 10:57:33.000', '2021-09-03 13:44:12.000', '2021-09-14 10:57:33.000', '#310062', 'segment');");
            }
            ResultSet countCgCurrent4 = statement.executeQuery("SELECT COUNT(*) FROM personal_offers");
            countCgCurrent4.next();
            System.out.println(countCgCurrent4.getInt(1));
        }

    public void changePriceEstAndRent2FirstFilmSectionKids() throws ClassNotFoundException, SQLException {
        page.navigate(frontend+"kids");
        page.reload();
        String urlFilm = page.waitForSelector("(//a[@data-test='PackageLink' and contains(@href,'/movies/vods/')])[1]").getAttribute("href");
        System.out.println(urlFilm);
        System.out.println(urlFilm.substring(13));
        String sql = "update package_prices set price ='100' where package_id ='".concat(urlFilm.substring(13)).concat("'");
        System.out.println(sql);
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate(sql);
    }
}







