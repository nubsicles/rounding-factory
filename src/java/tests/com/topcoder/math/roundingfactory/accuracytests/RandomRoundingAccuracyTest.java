/*
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.math.roundingfactory.accuracytests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.RandomRounding;

import junit.framework.TestCase;

/**
 * Accuracy tests for RandomRounding.
 *
 * If b is greater than c, round up.  If b is less than c, round down.  Otherwise, randomly choose whether to round up
 * or down.It is dependent with the random().
 *
 * In this section, round up means the absolute value of number increases. round down means the absolute value of
 * number decreases.
 * 
 * Example:
 *  round(1.26, 1, 5) -> 1.2 or 1.3
 *  round(1.251, 1, 5) -> 1.2 or 1.3
 *  round(1.25, 1, 5) -> 1.2 or 1.3
 *  round(1.249, 1, 5) -> 1.2
 *
 * @author alanSunny
 * @version 1.0
 */
public class RandomRoundingAccuracyTest extends TestCase implements RoundingAccuracyTestConstants {
    /** The RandomRounding used for testing. */
    private Algorithm rounding = null;

    /** Create a RandomRounding instance.*/
    public void setUp() {
        rounding = new RandomRounding();
    }

    /**
     * Test of round(String, int, int) method.
     * normal cases
     */
    public void testRoundThreeArgsNormalCases() {
        String result = rounding.round("1.25", 1, 5);
        assertTrue("Fails to rounding in normal cases", result.equals("1.2") || result.equals("1.3"));
        result = rounding.round("-1.25", 1, 5);
        assertTrue("Fails to rounding in normal cases", result.equals("-1.2") || result.equals("-1.3"));

        assertEquals("Fails to rounding in normal cases", rounding.round("1.26", 1, 5), "1.3");
        assertEquals("Fails to rounding in normal cases", rounding.round("-1.21", 1, 5), "-1.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-1.29", 1, 5), "-1.3");
        assertEquals("Fails to rounding in normal cases", rounding.round("-1.249", 1, 5), "-1.2");


        assertEquals("Fails to rounding in normal cases", rounding.round("3.21234", 2, 5), "3.21");
        assertEquals("Fails to rounding in normal cases", rounding.round("-2.61234", 2, 5), "-2.61");

        assertEquals("Fails to rounding in normal cases", rounding.round("3.145", 1, 5), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145", 1, 5), "-3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.16", 1, 5), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.16", 1, 5), "-3.2");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme cases
     */
    public void testRoundThreeArgsExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.49999", 1, 5), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999", 1, 5), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.500001", 1, 5), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.500001", 1, 5), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.000000", 1, 5), "3.0");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000000", 1, 5), "-3.0");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme forms
     */
    public void testRoundThreeArgsExtremeForm() {
        assertEquals("Fails to rounding in extreme forms", rounding.round(".12345", 3, 5), "0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("+.12345", 3, 5), "0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-.12345", 3, 5), "-0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("12345.", 3, 5), "12345.000");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-12345.", 3, 5), "-12345.000");
        assertEquals("Fails to rounding in extreme forms", rounding.round("0.000000", 3, 5), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-0.000000", 3, 5), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("0", 3, 5), "0");
    }

    /**
     * Test of round(String) method.
     * normal cases
     */
    public void testRoundStringNormalCases() {
        rounding.setAccuracyDigit(1);
        rounding.setComparisonDigit(5);
        String result = rounding.round("1.25");
        assertTrue("Fails to rounding in normal cases", result.equals("1.2") || result.equals("1.3"));

        result = rounding.round("-1.25");
        assertTrue("Fails to rounding in normal cases", result.equals("-1.2") || result.equals("-1.3"));

        assertEquals("Fails to rounding in normal cases", rounding.round("1.26"), "1.3");
        assertEquals("Fails to rounding in normal cases", rounding.round("-1.21"), "-1.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-1.29"), "-1.3");
        assertEquals("Fails to rounding in normal cases", rounding.round("-1.249"), "-1.2");

        rounding.setAccuracyDigit(2);
        assertEquals("Fails to rounding in normal cases", rounding.round("3.21234"), "3.21");
        assertEquals(rounding.round("-2.61234"), "-2.61");

        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in normal cases", rounding.round("3.145"), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145"), "-3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.151"), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.151"), "-3.2");
    }

    /**
     * Test of round(String) method.
     * extreme cases
     */
    public void testRoundStringExtremeCases() {
        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.49999"), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999"), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.500001"), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.500001"), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.000000"), "3.0");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000000"), "-3.0");
    }

    /**
     * Test of round(String) method.
     * extreme forms
     */
    public void testRoundStringExtremeForm() {
        rounding.setAccuracyDigit(3);
        assertEquals("Fails to rounding in extreme forms", rounding.round(".12345"), "0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("+.12345"), "0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-.12345"), "-0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("12345."), "12345.000");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-12345."), "-12345.000");
        assertEquals("Fails to rounding in extreme forms", rounding.round("0.000000"), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-0.000000"), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("0"), "0");
    }

    /**
     * Test of round(double) method.
     * normal cases
     */
    public void testRoundNormalCases() {
        rounding.setAccuracyDigit(1);
        rounding.setComparisonDigit(5);
        String result = rounding.round(1.25);
        assertTrue("Fails to rounding in normal cases", result.equals("1.2") || result.equals("1.3"));

        result = rounding.round(-1.25);
        assertTrue("Fails to rounding in normal cases", result.equals("-1.2") || result.equals("-1.3"));

        assertEquals("Fails to rounding in normal cases", rounding.round(1.26), "1.3");
        assertEquals("Fails to rounding in normal cases", rounding.round(-1.21), "-1.2");
        assertEquals("Fails to rounding in normal cases", rounding.round(-1.29), "-1.3");
        assertEquals("Fails to rounding in normal cases", rounding.round(-1.249), "-1.2");

        rounding.setAccuracyDigit(2);
        assertEquals("Fails to rounding in normal cases", rounding.round(3.21234), "3.21");
        assertEquals("Fails to rounding in normal cases", rounding.round(-2.61234), "-2.61");

        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in normal cases", rounding.round(3.145), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.145), "-3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round(3.151), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.151), "-3.2");
    }

    /**
     * Test of round(double) method.
     * extreme cases
     */
    public void testRoundExtremeCases() {
        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.49999), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.49999), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.500001), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.500001), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.000000), "3.0");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.000000), "-3.0");
    }

    /**
     * Test of round(double) method.
     * extreme form
     */
    public void testRoundExtremeForm() {
        rounding.setAccuracyDigit(3);
        assertEquals("Fails to rounding in extreme form", rounding.round(.12345), "0.123");
        assertEquals("Fails to rounding in extreme form", rounding.round(+.12345), "0.123");
        assertEquals("Fails to rounding in extreme form", rounding.round(-.12345), "-0.123");
        assertEquals("Fails to rounding in extreme form", rounding.round(12345.), "12345.000");
        assertEquals("Fails to rounding in extreme form", rounding.round(-12345.), "-12345.000");
        assertEquals("Fails to rounding in extreme form", rounding.round(0.000000), "0");
        assertEquals("Fails to rounding in extreme form", rounding.round(-0.000000), "0");
        assertEquals("Fails to rounding in extreme form", rounding.round(0), "0");
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * normal cases
     */
    public void testRoundDoubleNormalCases() {
        double result = rounding.roundDouble(1.25, 1, 5);        
        assertTrue("Fails to rounding in normal cases", Math.abs(result - 1.2) < DELTA || Math.abs(result - 1.3) < DELTA);        
        result = rounding.roundDouble(-1.25, 1, 5);
        assertTrue("Fails to rounding in normal cases", Math.abs(result - (-1.2)) < DELTA || Math.abs(result - (-1.3)) < DELTA);

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(1.26, 1, 5), 1.3, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-1.21, 1, 5), -1.2, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-1.29, 1, 5), -1.3, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-1.249, 1, 5), -1.2, DELTA);

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.21234, 2, 5), 3.21, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-2.61234, 2, 5), -2.61, DELTA);

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.145, 1, 5), 3.1, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.145, 1, 5), -3.1, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.151, 1, 5), 3.2, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.151, 1, 5), -3.2, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme cases
     */
    public void testRoundDoubleExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.49999, 1, 5), 3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.49999, 1, 5), -3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.500001, 1, 5), 3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.500001, 1, 5), -3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.000000, 1, 5), 3.0, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.000000, 1, 5), -3.0, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme form
     */
    public void testRoundDoubleExtremeForm() {
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(.12345, 3, 5), 0.123, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(+.12345, 3, 5), 0.123, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-.12345, 3, 5), -0.123, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(12345., 3, 5), 12345.000, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-12345., 3, 5), -12345.000, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0.000000, 3, 5), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-0.000000, 3, 5), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0, 3, 5), 0, DELTA);
    }
   
}
