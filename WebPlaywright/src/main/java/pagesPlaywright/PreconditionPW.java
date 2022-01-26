package pagesPlaywright;

import base.BasePagePlaywright;
import com.microsoft.playwright.Page;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static io.restassured.RestAssured.filters;
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
        String urlFilm = page.waitForSelector("(//a[@data-test='PackageLink' and @href])[1]").getAttribute("href");
        System.out.println(urlFilm);
        System.out.println(urlFilm.substring(13));
        String sql = "update package_prices set price ='4500' where package_id ='".concat(urlFilm.substring(13)).concat("'");
        System.out.println(sql);
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate(sql);
    }

    public void changePriceEstAndRent2SecondFilmSectionFilms() throws ClassNotFoundException, SQLException {
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
    public void changePriceEstAndRent2SecondFilmSectionKids() throws ClassNotFoundException, SQLException {
        page.navigate(frontend+"kids");
        page.reload();
        String urlFilm = page.waitForSelector("(//a[@data-test='PackageLink' and contains(@href,'/movies/vods/')])[2]").getAttribute("href");
        System.out.println(urlFilm);
        System.out.println(urlFilm.substring(13));
        String sql = "update package_prices set price ='100' where package_id ='".concat(urlFilm.substring(13)).concat("'");
        System.out.println(sql);
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate(sql);
    }

    public void deleteOldAndCreateNewSportKind() throws ClassNotFoundException, SQLException {
        // удалить все строки видов спорта из таблицы sport_kinds:
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("DELETE FROM sport_kinds");
        // Создание 'вид спорта - футбол':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%A4%D1%83%D1%82%D0%B1%D0%BE%D0%BB&alias=football&title=%D0%A4%D1%83%D1%82%D0%B1%D0%BE%D0%BB&description=%D0%A4%D1%83%D1%82%D0%B1%D0%BE%D0%BB&weight=1&is_hidden=false").
                when().
                post(backend+"cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - хоккей':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%A5%D0%BE%D0%BA%D0%BA%D0%B5%D0%B9&alias=hockey&title=%D0%A5%D0%BE%D0%BA%D0%BA%D0%B5%D0%B9&description=%D0%A5%D0%BE%D0%BA%D0%BA%D0%B5%D0%B9&weight=2&is_hidden=false").
                when().
                post(backend+"cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - баскетбол':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%91%D0%B0%D1%81%D0%BA%D0%B5%D1%82%D0%B1%D0%BE%D0%BB&alias=basketball&title=%D0%91%D0%B0%D1%81%D0%BA%D0%B5%D1%82%D0%B1%D0%BE%D0%BB&description=%D0%91%D0%B0%D1%81%D0%BA%D0%B5%D1%82%D0%B1%D0%BE%D0%BB&weight=4&is_hidden=false").
                when().
                post(backend+"cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - моторспорт':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%9C%D0%BE%D1%82%D0%BE%D1%80%D1%81%D0%BF%D0%BE%D1%80%D1%82&alias=motorsport&title=%D0%9C%D0%BE%D1%82%D0%BE%D1%80%D1%81%D0%BF%D0%BE%D1%80%D1%82&description=%D0%9C%D0%BE%D1%82%D0%BE%D1%80%D1%81%D0%BF%D0%BE%D1%80%D1%82&weight=6&is_hidden=false").
                when().
                post(backend+"cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // Создание 'вид спорта - боевые искусства':
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("id=0&name=%D0%91%D0%BE%D0%B5%D0%B2%D1%8B%D0%B5+%D0%B8%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%B0&alias=fight&title=%D0%91%D0%BE%D0%B5%D0%B2%D1%8B%D0%B5+%D0%B8%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%B0&description=%D0%91%D0%BE%D0%B5%D0%B2%D1%8B%D0%B5+%D0%B8%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%B0&weight=6&is_hidden=false").
                when().
                post(backend+"cms/sport/kinds/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

    }

    public void addSportTvChannels() throws SQLException {
        // футбол:
        ResultSet idFootball = statement.executeQuery("select id from sport_kinds where alias = 'football'");
        idFootball.next();
        System.out.println(idFootball.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_NashFootballHD").
                when().
                post(backend+"cms/sport/kinds/"+idFootball.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));
        System.out.println(backend+"cms/sport/kinds/"+idFootball.getInt(1)+"/channel/insert");

        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_match_footbal_1_HD").
                when().
                post(backend+"cms/sport/kinds/"+idFootball.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));

        // хоккей:
        ResultSet idHockey = statement.executeQuery("select id from sport_kinds where alias = 'hockey'");
        idHockey.next();
        System.out.println(idHockey.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_KHL").
                when().
                post(backend+"cms/sport/kinds/"+idHockey.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));

        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_KHL_HD").
                when().
                post(backend+"cms/sport/kinds/"+idHockey.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));

        // баскетбол:
        ResultSet idBasketball = statement.executeQuery("select id from sport_kinds where alias = 'basketball'");
        idBasketball.next();
        System.out.println(idBasketball.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_MirBasketballa").
                when().
                post(backend+"cms/sport/kinds/"+idBasketball.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));
        System.out.println(backend+"cms/sport/kinds/"+idBasketball.getInt(1)+"/channel/insert");

        // моторспорт:
        ResultSet idMotorsport = statement.executeQuery("select id from sport_kinds where alias = 'motorsport'");
        idMotorsport.next();
        System.out.println(idMotorsport.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_Motorsport").
                when().
                post(backend+"cms/sport/kinds/"+idMotorsport.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));
        System.out.println(backend+"cms/sport/kinds/"+idMotorsport.getInt(1)+"/channel/insert");

        // боевые искусства:
        ResultSet idFight = statement.executeQuery("select id from sport_kinds where alias = 'fight'");
        idFight.next();
        System.out.println(idFight.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_BoxTV").
                when().
                post(backend+"cms/sport/kinds/"+idFight.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));
        System.out.println(backend+"cms/sport/kinds/"+idFight.getInt(1)+"/channel/insert");

        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_M1_Global").
                when().
                post(backend+"cms/sport/kinds/"+idFight.getInt(1)+"/channel/insert").
                then().statusCode(anyOf(is(200), is(302)));
        System.out.println(backend+"cms/sport/kinds/"+idFight.getInt(1)+"/channel/insert");
    }

    public void deleteOldAndAddNewSportCompetitions() throws ClassNotFoundException, SQLException {
        // удалить все строки соревнований из таблицы sport_competitions:
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("DELETE FROM sport_competitions");
        // добавить новые спортивные события:
        // событие футбол:
        ResultSet idFootball = statement.executeQuery("select id from sport_kinds where alias = 'football'");
        idFootball.next();
        System.out.println(idFootball.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("name", "Football competition").
                multiPart("alias", "football_competition").
                multiPart("sport_kind_id", idFootball.getInt(1)).
//                multiPart("description", "text").
                multiPart("status", "active").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/competitions/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие хоккей:
        ResultSet idHockey = statement.executeQuery("select id from sport_kinds where alias = 'hockey'");
        idHockey.next();
        System.out.println(idHockey.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("name", "Hockey competition").
                multiPart("alias", "hockey_competition").
                multiPart("sport_kind_id", idHockey.getInt(1)).
//                multiPart("description", "text").
                multiPart("status", "active").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/competitions/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие баскетбол:
        ResultSet idBasketball = statement.executeQuery("select id from sport_kinds where alias = 'basketball'");
        idBasketball.next();
        System.out.println(idBasketball.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("name", "Basketball competition").
                multiPart("alias", "basketball_competition").
                multiPart("sport_kind_id", idBasketball.getInt(1)).
//                multiPart("description", "text").
                multiPart("status", "active").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/competitions/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие моторспорт:
        ResultSet idMotorsport = statement.executeQuery("select id from sport_kinds where alias = 'motorsport'");
        idMotorsport.next();
        System.out.println(idMotorsport.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("name", "Motorsport competition").
                multiPart("alias", "motorsport_competition").
                multiPart("sport_kind_id", idMotorsport.getInt(1)).
//                multiPart("description", "text").
                multiPart("status", "active").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/competitions/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие боевые искусства:
        ResultSet idFight = statement.executeQuery("select id from sport_kinds where alias = 'fight'");
        idFight.next();
        System.out.println(idFight.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("name", "Fight competition").
                multiPart("alias", "fight_competition").
                multiPart("sport_kind_id", idFight.getInt(1)).
//                multiPart("description", "text").
                multiPart("status", "active").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/competitions/0/edit").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void deleteOldAndAddNewSportEvents() throws SQLException, ClassNotFoundException {
        // удалить все строки соревнований из таблицы sport_competitions:
        Class.forName("org.postgresql.Driver");
        statement.executeUpdate("DELETE FROM sport_events");
        // добавить новые спортивные события:
        // событие футбол:
        ResultSet idFootball = statement.executeQuery("select id from sport_competitions where alias = 'football_competition'");
        idFootball.next();
        System.out.println(idFootball.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("starts_at", "2022-12-30 00:00:00").
                multiPart("name", "football_event").
                multiPart("alias", "football_event").
                multiPart("sport_competition_id", idFootball.getInt(1)).
                multiPart("competition_stage", "1").
//                multiPart("description", "text").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/events/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие хоккей:
        ResultSet idHockey = statement.executeQuery("select id from sport_competitions where alias = 'hockey_competition'");
        idHockey.next();
        System.out.println(idHockey.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("starts_at", "2022-12-30 00:00:00").
                multiPart("name", "hockey_event").
                multiPart("alias", "hockey_event").
                multiPart("sport_competition_id", idHockey.getInt(1)).
                multiPart("competition_stage", "2").
//                multiPart("description", "text").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/events/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие баскетбол:
        ResultSet idBasketball = statement.executeQuery("select id from sport_competitions where alias = 'basketball_competition'");
        idBasketball.next();
        System.out.println(idBasketball.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("starts_at", "2022-12-30 00:00:00").
                multiPart("name", "basketball_event").
                multiPart("alias", "basketball_event").
                multiPart("sport_competition_id", idBasketball.getInt(1)).
                multiPart("competition_stage", "3").
//                multiPart("description", "text").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/events/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие моторспорт:
        ResultSet idMotorsport = statement.executeQuery("select id from sport_competitions where alias = 'motorsport_competition'");
        idMotorsport.next();
        System.out.println(idMotorsport.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("starts_at", "2022-12-30 00:00:00").
                multiPart("name", "motorsport_event").
                multiPart("alias", "motorsport_event").
                multiPart("sport_competition_id", idMotorsport.getInt(1)).
                multiPart("competition_stage", "4").
//                multiPart("description", "text").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/events/0/edit").
                then().statusCode(anyOf(is(200), is(302)));

        // событие боевые искусства:
        ResultSet idFight = statement.executeQuery("select id from sport_competitions where alias = 'fight_competition'");
        idFight.next();
        System.out.println(idFight.getInt(1));
        given().contentType("multipart/form-data").
                auth().
                basic("mc2soft", "wkqKy2sWwBGFDR").
                multiPart("starts_at", "2022-12-30 00:00:00").
                multiPart("name", "fight_event").
                multiPart("alias", "fight_event").
                multiPart("sport_competition_id", idFight.getInt(1)).
                multiPart("competition_stage", "5").
//                multiPart("description", "text").
//                multiPart("poster_ratehelper", "http://static.cdn.megafon.tv/images/Mixed/19/bf/110f4125f8cca7c21a72ee5afc89d302ab19/Poster.png").
//                multiPart("poster_wideposter", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/WidePoster.jpeg").
//                multiPart("poster_tile", "http://static.cdn.megafon.tv/images/programme/51/9b/67d3647117ee4fa384fce379b9057e9b6f83/Tile.jpeg").
                when().post(backend+"cms/sport/events/0/edit").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void addTvProgramsInSportEvents() throws SQLException {
        // футбол:
        ResultSet idFootball = statement.executeQuery("select id from sport_events where alias = 'football_event'");
        idFootball.next();
        System.out.println(idFootball.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_NashFootballHD_576038363").
                when().
                post(backend+"cms/sport/events/"+idFootball.getInt(1)+"/programme/insert").
                then().statusCode(anyOf(is(200), is(302)));

        // хоккей:
        ResultSet idHockey = statement.executeQuery("select id from sport_events where alias = 'hockey_event'");
        idHockey.next();
        System.out.println(idHockey.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_KHL_575487869").
                when().
                post(backend+"cms/sport/events/"+idHockey.getInt(1)+"/programme/insert").
                then().statusCode(anyOf(is(200), is(302)));

        // баскетбол:
        ResultSet idBasketball = statement.executeQuery("select id from sport_events where alias = 'basketball_event'");
        idBasketball.next();
        System.out.println(idBasketball.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_MirBasketballa_574606692").
                when().
                post(backend+"cms/sport/events/"+idBasketball.getInt(1)+"/programme/insert").
                then().statusCode(anyOf(is(200), is(302)));

        // моторспорт:
        ResultSet idMotorsport = statement.executeQuery("select id from sport_events where alias = 'motorsport_event'");
        idMotorsport.next();
        System.out.println(idMotorsport.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_Motorsport_577356802").
                when().
                post(backend+"cms/sport/events/"+idMotorsport.getInt(1)+"/programme/insert").
                then().statusCode(anyOf(is(200), is(302)));

        // боевые искусства:
        ResultSet idFight = statement.executeQuery("select id from sport_events where alias = 'fight_event'");
        idFight.next();
        System.out.println(idFight.getInt(1));
        given().auth().basic("mc2soft", "wkqKy2sWwBGFDR").
                contentType("application/x-www-form-urlencoded").
                body("package_id=Channel_BoxTV_576546806").
                when().
                post(backend+"cms/sport/events/"+idFight.getInt(1)+"/programme/insert").
                then().statusCode(anyOf(is(200), is(302)));
    }

    public void addBannersInSectionSport() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        ResultSet countBanners = statement.executeQuery("select COUNT(*) from banners where screen = 'sport' and visible_until > now()");
        countBanners.next();
        System.out.println(countBanners.getInt(1));
        if (countBanners.getInt(1) < 5) {
            given().contentType("multipart/form-data").
                    auth().
                    basic("mc2soft", "wkqKy2sWwBGFDR").
                    multiPart("reference_mode", "package").
                    multiPart("package_id", "Channel_KHL_575487869").
                    multiPart("weight", "1").
                    multiPart("visible_at", "2022-01-22 23:57:17").
                    multiPart("visible_until", "2023-01-22 23:57:17").
                    multiPart("title", "Attack of the 60s").
                    multiPart("screen", "sport").
                    when().post(backend+"cms/banners/0/edit").
                    then().statusCode(anyOf(is(200), is(302)));
        }
        ResultSet countBannersUpdate = statement.executeQuery("select COUNT(*) from banners where screen = 'sport' and visible_until > now()");
        countBannersUpdate.next();
        System.out.println(countBannersUpdate.getInt(1));
        if (countBannersUpdate.getInt(1) < 5) {
            given().contentType("multipart/form-data").
                    auth().
                    basic("mc2soft", "wkqKy2sWwBGFDR").
                    multiPart("reference_mode", "package").
                    multiPart("package_id", "Channel_Motorsport_577356832").
                    multiPart("weight", "2").
                    multiPart("visible_at", "2022-01-22 23:57:17").
                    multiPart("visible_until", "2023-01-22 23:57:17").
                    multiPart("title", "FastZone. 28th episode").
                    multiPart("screen", "sport").
                    when().post(backend+"cms/banners/0/edit").
                    then().statusCode(anyOf(is(200), is(302)));
        }
        ResultSet countBannersUpdate2 = statement.executeQuery("select COUNT(*) from banners where screen = 'sport' and visible_until > now()");
        countBannersUpdate2.next();
        System.out.println(countBannersUpdate2.getInt(1));
        if (countBannersUpdate2.getInt(1) < 5) {
            given().contentType("multipart/form-data").
                    auth().
                    basic("mc2soft", "wkqKy2sWwBGFDR").
                    multiPart("reference_mode", "package").
                    multiPart("package_id", "Channel_NashFootballHD_576038343").
                    multiPart("weight", "3").
                    multiPart("visible_at", "2022-01-22 23:57:17").
                    multiPart("visible_until", "2023-01-22 23:57:17").
                    multiPart("title", "Football News").
                    multiPart("screen", "sport").
                    when().post(backend+"cms/banners/0/edit").
                    then().statusCode(anyOf(is(200), is(302)));
        }
        ResultSet countBannersUpdate3 = statement.executeQuery("select COUNT(*) from banners where screen = 'sport' and visible_until > now()");
        countBannersUpdate3.next();
        System.out.println(countBannersUpdate3.getInt(1));
        if (countBannersUpdate3.getInt(1) < 5) {
            given().contentType("multipart/form-data").
                    auth().
                    basic("mc2soft", "wkqKy2sWwBGFDR").
                    multiPart("reference_mode", "package").
                    multiPart("package_id", "Channel_MirBasketballa_574606692").
                    multiPart("weight", "4").
                    multiPart("visible_at", "2022-01-22 23:57:17").
                    multiPart("visible_until", "2023-01-22 23:57:17").
                    multiPart("title", "VTB League").
                    multiPart("screen", "sport").
                    when().post(backend+"cms/banners/0/edit").
                    then().statusCode(anyOf(is(200), is(302)));
        }
        ResultSet countBannersUpdate4 = statement.executeQuery("select COUNT(*) from banners where screen = 'sport' and visible_until > now()");
        countBannersUpdate4.next();
        System.out.println(countBannersUpdate4.getInt(1));
        if (countBannersUpdate4.getInt(1) < 5) {
            given().contentType("multipart/form-data").
                    auth().
                    basic("mc2soft", "wkqKy2sWwBGFDR").
                    multiPart("reference_mode", "package").
                    multiPart("package_id", "Channel_BoxTV_576546797").
                    multiPart("weight", "5").
                    multiPart("visible_at", "2022-01-22 23:57:17").
                    multiPart("visible_until", "2023-01-22 23:57:17").
                    multiPart("title", "Battle of the Brains").
                    multiPart("screen", "sport").
                    when().post(backend+"cms/banners/0/edit").
                    then().statusCode(anyOf(is(200), is(302)));
        }
    }


}







