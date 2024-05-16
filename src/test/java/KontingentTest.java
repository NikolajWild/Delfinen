import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KontingentTest {

    @Test
    void beregningAfKontingent() {
        Kontingent kontingent = new Kontingent(new DelfinenMedlemmer());


        // Tager udgangspunkt i vores faktiske fil. Med disse medlemmer

        /*sadsad,21,true,false,2000.0,Maria Clausen,Seniorhold;[];[];[];[];[];[];[]
asdsad,21,true,false,2000.0,Maria Clausen,Seniorhold;[SvÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂ¸mmedisciplinOgResultater@17a7cec2];[];[];[];[];[];[]
asdsad,21,true,false,2000.0,Maria Clausen,Seniorhold;[SvÃÂÃÂÃÂÃÂ¸mmedisciplinOgResultater@27973e9b];[];[];[];[];[]
sad,21,true,false,2000.0,Maria Clausen,Seniorhold;[SvÃÂÃÂÃÂÃÂ¸mmedisciplinOgResultater@27973e9b];[];[];[];[]
sadsad,21,true,false,2000.0,Maria Clausen,Seniorhold;[SvÃÂÃÂ¸mmedisciplinOgResultater{svÃÂÃÂ¸mmedisciplin='butterfly';[];[];[]
asdasd,21,true,false,2000.0,Maria Clausen,Seniorhold;[svÃÂ¸mmedisciplinbutterflyTid i sekunder: 12.0 Dato: 12/12-12];[];[]
asda,1,true,true,2000.0
asda,1,true,true,200.0*/
        double actualValue = kontingent.beregningAfKontingent();
        double expectedValue = 11600;

        assertEquals(expectedValue, actualValue);
    }
}