/*
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.math.roundingfactory.accuracytests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.UpAsymmetricRounding;

import junit.framework.TestCase;

/**
 * Accuracy tests for UpAsymmetricRounding.
 *
 * All numbers move to zero Truncate everything after the accuracy digit, if the given number is positive, the value of
 * it will increase; if the given number is negative, the value of it will descrease(The absolute value increase); if
 * the input is a "round number", return itself with proper precision.  That is, if the input given would result from a
 * call to round(), then do nothing except the truncation.
 *
 * Example:
 *  round(3.21234, 2, x) -> 3.22
 *  round(-2.61234, 2, x) -> -2.62
 * 
 * @author alanSunny
 * @version 1.0
 */
public class UpAsymmetricRoundingAccuracyTest extends TestCase implements RoundingAccuracyTestConstants {
    /** The UpAsymmetricRounding used for testing. */
    private Algorithm rounding = null;

    /** Create a UpAsymmetricRounding instance.*/
    public void setUp() {
        rounding = new UpAsymmetricRounding();
    }

    /**
     * Test of round(String, int, int) method.
     * normal cases
     */
    public void testRoundThreeArgsNormalCases() {
        assertEquals("Fails to rounding in normal cases", rounding.round("3.21234", 2, 3), "3.22");
        assertEquals("Fails to rounding in normal cases", rounding.round("-2.61234", 2, 3), "-2.61");

        assertEquals("Fails to rounding in normal cases", rounding.round("3.145", 1, 3), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145", 1, 3), "-3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.151", 1, 3), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.151", 1, 3), "-3.1");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme cases
     */
    public void testRoundThreeArgsExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.49999", 1, 3), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999", 1, 3), "-3.4");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.500001", 1, 3), "3.6");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.500001", 1, 3), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.000000", 1, 3), "3.0");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000000", 1, 3), "-3.0");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme forms
     */
    public void testRoundThreeArgsExtremeForm() {
        assertEquals("Fails to rounding in extreme forms", rounding.round(".12345", 3, 3), "0.124");
        assertEquals("Fails to rounding in extreme forms", rounding.round("+.12345", 3, 3), "0.124");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-.12345", 3, 3), "-0.123");
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
        assertEquals("Fails to rounding in normal cases", rounding.round("3.21234"), "3.22");
        assertEquals("Fails to rounding in normal cases", rounding.round("-2.61234"), "-2.61");

        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in normal cases", rounding.round("3.145"), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145"), "-3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.151"), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.151"), "-3.1");
    }

    /**
     * Test of round(String) method.
     * extreme cases
     */
    public void testRoundStringExtremeCases() {
        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.49999"), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999"), "-3.4");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.500001"), "3.6");
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
        assertEquals("Fails to rounding in extreme forms", rounding.round(".12345"), "0.124");
        assertEquals("Fails to rounding in extreme forms", rounding.round("+.12345"), "0.124");
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
        rounding.setAccuracyDigit(2);
        assertEquals("Fails to rounding in normal cases", rounding.round(3.21234), "3.22");
        assertEquals("Fails to rounding in normal cases", rounding.round(-2.61234), "-2.61");

        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in normal cases", rounding.round(3.145), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.145), "-3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round(3.151), "3.2");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.151), "-3.1");
    }

    /**
     * Test of round(double) method.
     * extreme cases
     */
    public void testRoundExtremeCases() {
        rounding.setAccuracyDigit(1);
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.49999), "3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.49999), "-3.4");
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.51), "3.6");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.51), "-3.5");
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.000000), "3.0");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.000000), "-3.0");
    }

    /**
     * Test of round(double) method.
     * extreme form
     */
    public void testRoundExtremeForm() {
        rounding.setAccuracyDigit(3);
        assertEquals("Fails to rounding in extreme form", rounding.round(.12345), "0.124");
        assertEquals("Fails to rounding in extreme form", rounding.round(+.12345), "0.124");
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

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.21234, 2, 3), 3.22, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-2.61234, 2, 3), -2.61, DELTA);

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.145, 1, 3), 3.2, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.145, 1, 3), -3.1, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.151, 1, 3), 3.2, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.151, 1, 3), -3.1, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme cases
     */
    public void testRoundDoubleExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.49999, 1, 3), 3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.49999, 1, 3), -3.4, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.51, 1, 3), 3.6, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.51, 1, 3), -3.5, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(+3.000000, 1, 3), 3.0, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.000000, 1, 3), -3.0, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme form
     */
    public void testRoundDoubleExtremeForm() {
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(.12345, 3, 3), 0.124, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(+.12345, 3, 3), 0.124, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-.12345, 3, 3), -0.123, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(12345., 3, 3), 12345.000, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-12345., 3, 3), -12345.000, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0.000000, 3, 3), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-0.000000, 3, 3), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0, 3, 3), 0, DELTA);
    }
}
