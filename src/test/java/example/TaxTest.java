package example;

import org.example.Employe;
import org.example.Tax;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TaxTest {

    private Tax tax;
    public Employe input;
    public double expectedTax;
    public double expectedNet;

    public TaxTest(Employe input, double expectedTax, double expectedNet) {
        this.input = input;
        this.expectedTax = expectedTax;
        this.expectedNet = expectedNet;
    }

    @Before
    public void setUp() {
        tax = new Tax(input);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new Employe("ARNO", 30, 67000.0, 0), 10050.0, 56950.0},
                        {new Employe("ARNO", 30, 26000.0, 2), 0.0, 26000.0},
                        {new Employe("ARNO", 30, 50000.0, 2), 3750.0, 46250.0}
                }
        );
    }

    @Test
    public void test_calcul_tax() {
        assertEquals(expectedTax, tax.calculTax(), 0.0);
    }

    @Test
    public void test_calcul_net() {
        assertEquals(expectedNet, tax.calculNet(), 0.0);
    }
}