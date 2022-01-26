package Preconditions;
import base.TestBasePlaywright;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;

public class ExecutePreconditions extends TestBasePlaywright {
    @Test
    public void executePreconditions() throws IOException, SQLException, ClassNotFoundException {
        // Создать скидку для цены EST и Rent2 на фильм в CMS: Описание - "Sale AutoTest", механика - стандарт скидка, величина - 30%, стикер - "AutoTest -30%"
        preconditionPW.editSaleInCMS();
        preconditionPW.deletePackageFromSaleCMS();
        // Изменить на минимальную цену (45р) EST megafon/card и (1р) Rent2 megafon/card первого фильма в разделе "Фильмы"
        preconditionPW.changePriceEstAndRent2FirstFilmSectionFilms();

        // Изменить на минимальную цену (45р) EST megafon/card и (1р) Rent2 megafon/card второго фильма в разделе "Фильмы"
        preconditionPW.changePriceEstAndRent2SecondFilmSectionFilms();

        // Изменить на минимальную цену (1р) EST megafon/card и (1р) Rent2 megafon/card первого фильма в разделе "Детям"
        preconditionPW.changePriceEstAndRent2FirstFilmSectionKids();

        // Изменить на минимальную цену (1р) EST megafon/card и (1р) Rent2 megafon/card второго фильма в разделе "Детям"
        preconditionPW.changePriceEstAndRent2SecondFilmSectionKids();

        // Изменить на минимальную цену (1р) EST и (1р) Rent2 фильма "Довод"
        preconditionPW.changePriceFilmDovodEstAndRent2();
        // Изменить на минимальную цену (35р) SubsN megafon и SubsN card пакета "Все и сразу"
        // SubsN megafon, card
        preconditionPW.changePricePackageVseISrazuSubsNmegafon();
        // В CMS созданы 4 любые персональные предложения
        preconditionPW.checkCountAndAddPersonal_Offers();

        // удаление старых и создание новых видов спорта
        preconditionPW.deleteOldAndCreateNewSportKind();
        // добавление тв каналов в созданные виды спорта:
        preconditionPW.addSportTvChannels();
        // добавление спортивных соревнований:
        preconditionPW.deleteOldAndAddNewSportCompetitions();
        // добавление спортивных событий:
        preconditionPW.deleteOldAndAddNewSportEvents();
        // добавление тв программ в спортивные события:
        preconditionPW.addTvProgramsInSportEvents();
        // добавление баннеров в раздел спорт:
        preconditionPW.addBannersInSectionSport();
    }

}
