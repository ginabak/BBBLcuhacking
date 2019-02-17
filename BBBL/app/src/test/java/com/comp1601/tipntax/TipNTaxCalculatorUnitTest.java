package com.comp1601.tipntax;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class TipNTaxCalculatorUnitTest {

    public static double toleranceforRealNumbers = 0.01;


    // This tests if the amount used is negative
    @Test
    public void negativeAmountTest() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        double amount = -100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, TipNTaxCalculator.mInvalidResult, tolerance);
    }


    // This Tests if the amount used for calculation is too large
    @Test
    public void tooLargeTest() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        double amount = 100000.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, TipNTaxCalculator.mInvalidResult, tolerance);
    }

    // This Tests if the tax percentage is less than zero
    @Test
    public void invalidTaxPercentage() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        testCalculator.setmTaxRate(0);
        double amount = 100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, TipNTaxCalculator.mInvalidResult, tolerance);
    }


    // This Tests if the tax percentage is greater than 100%
    @Test
    public void tooLargeTaxPercentage() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        testCalculator.setmTaxRate(101);
        double amount = 100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, TipNTaxCalculator.mInvalidResult, tolerance);
    }


    // This tests if the tip percentage is less than zero
    @Test
    public void invalidTipPercentage() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        testCalculator.setmTipPercentage(-1);
        double amount = 100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, TipNTaxCalculator.mInvalidResult, tolerance);
    }

    // This tests if the tip percentage is greater than 100%
    @Test
    public void tooLargeTipPercentage() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        testCalculator.setmTipPercentage(101);
        double amount = 100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, TipNTaxCalculator.mInvalidResult, tolerance);
    }

    // This tests the calculation of JUST the tax (to make sure it's correct)
    @Test
    public void calculatingTax() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        testCalculator.setmTaxRate(15.00);
        double amount = 100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, 132.25, tolerance);
    }

    // This tests the calculation of JUST the tip (to make sure it's correct)
    @Test
    public void calculatingTip() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        testCalculator.setmTipPercentage(30.00);
        double amount = 100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, 146.90, tolerance);
    }

    // This tests that the calculation of the tax and tip is correct.
    @Test
    public void calculatingTipNTax() throws Exception{
        TipNTaxCalculator testCalculator = new TipNTaxCalculator();
        testCalculator.setmTipPercentage(30.00);
        testCalculator.setmTaxRate(15.00);
        double amount = 100.00;
        double result = testCalculator.calculate(amount);
        double tolerance = toleranceforRealNumbers;
        assertEquals(result, 149.50, tolerance);
    }




    /**
     * Amount used for calculation is negative
     * Amount used for calculation is too large (pick a reasonable value for a restaurant bill).
     * The tax percentage is less than zero
     * The tax percentage is greater than 100%
     * The tip percentage is less than zero
     * The tip percentage is greater than 100%
     * The calculation of just the tax is correct
     * The calculation of just the tip is correct
     * The calculation of the tax and tip is correct.
     * Note here you should decided what the correct calculation should be.
     * That is, does one tip on the amount or the amount including tax?
     */
}
