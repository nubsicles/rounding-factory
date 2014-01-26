/*
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.math.roundingfactory.accuracytests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.DownAsymmetricRounding;

import junit.framework.TestCase;

/**
 * Accuracy tests for DownAsymmetricRounding.
 *
 * All numbers decrease.  Truncate everything after the accuracy digit. If the given number is negative, the value of
 * number will decrease(the absolute value of the number increases); if the given number is positive, the number will
 * decrease. if the input is a "round number", return itself with proper precision. That is, if the input given would
 * result from a call to round(), then do nothing except the truncation.
 *
 * Example:
 * round(3.21234, 2, x) -> 3.21
 * round(-2.61234, 2, x) -> -2.62
 *
 * @author alanSunny
 * @version 1.0
 */
public class DownAsymmetricRoundingAccuracyTest extends TestCase implements RoundingAccuracyTestConstants {
    /** The DownAsymmetricRounding used for testing. */
    private Algorithm rounding = null;

    /** Create a DownAsymmetricRounding instance.*/
    public void setUp() {
        rounding = new DownAsymmetricRounding();
    }

    /**
     * Test of round(String number, int accuracyDigit, int comparisonDigit) in normal case for positive number.
     * 
     * simple remove the digit that is after the accuracy digit.
     */
    public void testRoundingNormalPositive() {
        final String number = "3.21234";
        final String result = "3.21";

        // Rounding the positive number in different comparison digit cases and default accuracy digit(2)
        assertEquals("Fails to rounding the positive number", result, rounding.round(number, DEFAULT_ROUNDING, MAX_COMPARISON));
        assertEquals("Fails to rounding the positive number", result, rounding.round(number, DEFAULT_ROUNDING, DEFAULT_COMPARISON));
        assertEquals("Fails to rounding the positive number", result, rounding.round(number, DEFAULT_ROUNDING, MIN_COMPARISON));
    }

    /**
     * Test of round(String number, int accuracyDigit, int comparisonDigit) in normal case for negative number.
     * 
     * simple remove the digit that is after the accuracy digit.
     */
    public void testRoundingNormalNegative() {
        final String number = "-2.61234";
        final String result = "-2.62";

        // Rounding the negative number in different comparison digit cases and default accuracy digit(2)
        assertEquals("Fails to rounding the negative number", result, rounding.round(number, DEFAULT_ROUNDING, MAX_COMPARISON));
        assertEquals("Fails to rounding the negative number", result, rounding.round(number, DEFAULT_ROUNDING, DEFAULT_COMPARISON));
        assertEquals("Fails to rounding the negative number", result, rounding.round(number, DEFAULT_ROUNDING, MIN_COMPARISON));
    }
    
    /**
     * Test of round(String, int, int) method.
     * normal cases
     */
    public void testRoundThreeArgsNormalCases() {
        assertEquals("Fails to rounding in normal cases", rounding.round("3.21234", 2, 3), "3.21");
        assertEquals("Fails to rounding in normal cases", rounding.round("-2.61234", 2, 3), "-2.62");

        assertEquals("Fails to rounding in normal cases", rounding.round("3.145", 1, 3), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145", 1, 3), "-3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.151", 1, 3), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.151", 1, 3), "-3.2");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme cases
     */
    public void testRoundThreeArgsExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.49999", 1, 3), "3.4");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999", 1, 3), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.500001", 1, 3), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.500001", 1, 3), "-3.6");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.000000", 1, 3), "3.0");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000000", 1, 3), "-3.0");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme forms
     */
    public void testRoundThreeArgsExtremeForm() {
        assertEquals("Fails to rounding in extreme forms", rounding.round(".12345", 3, 3), "0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("+.12345", 3, 3), "0.123");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-.12345", 3, 3), "-0.124");
        assertEquals("Fails to rounding in extreme forms", rounding.round("12345.", 3, 3), "12345.000");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-12345.", 3, 3), "-12345.000");
        assertEquals("Fails to rounding in extreme forms", rounding.round("0.000000", 3, 3), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-0.000000", 3, 3), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("0", 3, 3), "0");
    }

    /**
     * Test of round(String) method.
     * normal cases
     */
    public void testRoundStringNormalCases() {
        rounding.setAccuracyDigit(2);
        assertEquals("Fails to rounding in normal cases", rounding.round("3.21234"), "3.21");
        assertEquals("Fails to rounding in normal cases", rounding.round("-2.61234"), "-2.62");

        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in normal cases", rounding.round("3.145"), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145"), "-3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.151"), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.151"), "-3.2");
    }

    /**
     * Test of round(String) method.
     * extreme cases
     */
    public void testRoundStringExtremeCases() {
        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.49999"), "3.4");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999"), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.51"), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.51"), "-3.6");
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
        assertEquals("Fails to rounding in extreme forms", rounding.round("-.12345"), "-0.124");
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
        rounding.setAccuracyDigit(2);
        assertEquals("Fails to rounding in normal cases", rounding.round(3.21234), "3.21");
        assertEquals("Fails to rounding in normal cases", rounding.round(-2.61234), "-2.62");

        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in normal cases", rounding.round(3.145), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.145), "-3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round(3.151), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.151), "-3.2");
    }

    /**
     * Test of round(double) method.
     * extreme cases
     */
    public void testRoundExtremeCases() {
        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.49999), "3.4");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.49999), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.51), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.51), "-3.6");
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
        assertEquals("Fails to rounding in extreme form", rounding.round(-.12345), "-0.124");
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

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.21234, 2, 3), 3.21, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-2.61234, 2, 3), -2.62, DELTA);

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.145, 1, 3), 3.1, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.145, 1, 3), -3.2, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.151, 1, 3), 3.1, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.151, 1, 3), -3.2, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme cases
     */
    public void testRoundDoubleExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.49999, 1, 3), 3.4, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.49999, 1, 3), -3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.51, 1, 3), 3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.51, 1, 3), -3.6, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.000000, 1, 3), 3.0, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.000000, 1, 3), -3.0, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme form
     */
    public void testRoundDoubleExtremeForm() {
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(.12345, 3, 3), 0.123, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(+.12345, 3, 3), 0.123, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-.12345, 3, 3), -0.124, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(12345., 3, 3), 12345.000, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-12345., 3, 3), -12345.000, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0.000000, 3, 3), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-0.000000, 3, 3), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0, 3, 3), 0, DELTA);
    }    
}
