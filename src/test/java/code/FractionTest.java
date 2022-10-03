package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction= new Fraction(10,2);
    }
    @Test
    void testFractionIntInt(){
        assertEquals(10, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }
    @Test
    void testFraction(){
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }
    @Test
    void testDecimal() {
        fraction.setNumerator(6);
        fraction.setDenominator(4);
        assertEquals(6, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
        assertEquals(1.5, fraction.decimal());
    }
}
