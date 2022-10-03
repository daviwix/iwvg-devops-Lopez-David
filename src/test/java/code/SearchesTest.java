package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        Fraction searchedFraction = new Searches().findFractionMultiplicationByUserFamilyName("Blanco");
        assertEquals(0,searchedFraction.getNumerator());
        assertEquals(-360,searchedFraction.getDenominator());
    }
    @Test
    void testFindFirstDecimalFractionByUserName() {
        Double decimal = new Searches().findFirstDecimalFractionByUserName("Paula");
        assertEquals(1,decimal);
    }
    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        Stream<Double> doubleStream = new Searches().findDecimalFractionByNegativeSignFraction();
        assertEquals(List.of(-0.2,-0.5),doubleStream.collect(Collectors.toList()));
    }
}
