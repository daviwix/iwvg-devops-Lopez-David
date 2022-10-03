package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void testProper(){
        assertFalse(fraction.isProper());
        assertTrue(fraction.isInProper());
    }
    @Test
    void testEquivalent(){
        assertTrue(fraction.isEquivalent(new Fraction(20,4)));
    }
    @Test
    void testAdd(){
        Fraction result= fraction.add(new Fraction(3,4));
        assertEquals(23,result.getNumerator());
        assertEquals(4,result.getDenominator());
    }
    @Test
    void testMultiply(){
        Fraction result= fraction.multiply(new Fraction(3,4));
        assertEquals(30,result.getNumerator());
        assertEquals(8,result.getDenominator());
    }
    @Test
    void testDivide(){
        Fraction result= fraction.divide(new Fraction(3,4));
        assertEquals(40,result.getNumerator());
        assertEquals(6,result.getDenominator());
    }
}
