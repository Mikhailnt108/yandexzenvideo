package Preconditions;

import base.TestBasePlaywright;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class EditPriceFirstFilmForSale extends TestBasePlaywright {
    @Test
    public void executePreconditions() throws IOException, SQLException, ClassNotFoundException {
        cardFilmPW.editPriceFirstFilmForSale(preprod);
    }
}
