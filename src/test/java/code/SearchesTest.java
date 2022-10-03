package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        Fraction searchedFraction= new Searches().findFractionMultiplicationByUserFamilyName("Blanco");
        assertEquals(0,searchedFraction.getNumerator());
        assertEquals(-360,searchedFraction.getDenominator());
    }
}
