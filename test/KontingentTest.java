import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KontingentTest {

    @Test
    void beregningAfKontingent() {
        Kontingent kontingent = new Kontingent(new DelfinenMedlemmer());


        // Tager udgangspunkt i vores faktiske fil. Med disse medlemmer

        /*Nikolaj,21,false,true, 499
        Anders,61,false,true, 1000
        Nikolaj,21,true,true,100000
        nikolaj,21,true,true, 100000*/
        double actualValue = kontingent.beregningAfKontingent();
        double expectedValue = 4200;

        assertEquals(expectedValue, actualValue);
    }
}