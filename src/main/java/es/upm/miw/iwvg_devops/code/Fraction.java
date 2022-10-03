package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper(){
        return numerator < denominator;
    }

    public boolean isInProper(){
        return numerator > denominator;
    }

    public boolean isEquivalent(Fraction second){
        return numerator * second.denominator == denominator * second.numerator;
    }

    public Fraction add(Fraction second){
        Fraction[] fractions= reduceToCommonDenominator(this,second);
        return new Fraction(fractions[0].numerator + fractions[1].numerator, fractions[0].denominator);
    }

    public Fraction multiply(Fraction second){
        return new Fraction(numerator * second.numerator, denominator * second.denominator);
    }

    public Fraction divide(Fraction second){
        return new Fraction(numerator * second.denominator, denominator * second.numerator);
    }

    private int greatestCommonDivisor(int a, int b) {
        int temporal;
        while (b != 0) {
            temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    private int leastCommonMultiple(int a, int b) {
        return (a * b) / greatestCommonDivisor(a, b);
    }

    private Fraction[] reduceToCommonDenominator(Fraction a, Fraction b){
        int commonDenominator= leastCommonMultiple(a.denominator,b.denominator);
        a.numerator = a.numerator * (commonDenominator / a.denominator);
        a.denominator = commonDenominator;
        b.numerator = b.numerator * (commonDenominator / b.denominator);
        b.denominator = commonDenominator;
        return new Fraction[]{a, b};
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
