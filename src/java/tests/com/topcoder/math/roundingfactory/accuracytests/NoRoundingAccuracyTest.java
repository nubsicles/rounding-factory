/*
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.math.roundingfactory.accuracytests;

import com.topcoder.math.roundingfactory.algorithms.NoRounding;
import com.topcoder.math.roundingfactory.algorithms.Algorithm;

import junit.framework.TestCase;

/**
 * Accuracy tests for NoRounding.
 * 
 * This algorithm will take the given input and simply return it (If the number contains the sign ¡°+¡±, remove it, and
 * then, return it.), ignoring both the accuracy and comparison digits.
 *
 * @author alanSunny
 * @version 1.0
 */
public class NoRoundingAccuracyTest extends TestCase implements RoundingAccuracyTestConstants {
    /** The NoRounding used for testing. */
    private Algorithm rounding = null;

    /** Create a NoRounding instance.*/
    public void setUp() {
        rounding = new NoRounding();
    }

    /**
     * Test of round(String number, int accuracyDigit, int comparisonDigit) in normal case.
     * 
     * The original will be returned.
     */
    public void testRoundingNormal() {
        final String number = "1.050";
        final String result = number;

        // Rounding the number with + sign in different accuracy digit and comparison digit cases
        assertEquals("Fails to rounding the normal number", result, rounding.round(number, MIN_ROUNDING, MAX_COMPARISON));
        assertEquals("Fails to rounding the normal number", result, rounding.round(number, LARGER_ROUNDING, MAX_COMPARISON));
        assertEquals("Fails to rounding the normal number", result, rounding.round(number, DEFAULT_ROUNDING, MAX_COMPARISON));

        assertEquals("Fails to rounding the normal number", result, rounding.round(number, MIN_ROUNDING, DEFAULT_COMPARISON));
        assertEquals("Fails to rounding the normal number", result, rounding.round(number, LARGER_ROUNDING, DEFAULT_COMPARISON));
        assertEquals("Fails to rounding the normal number", result, rounding.round(number, DEFAULT_ROUNDING, DEFAULT_COMPARISON));

        assertEquals("Fails to rounding the normal number", result, rounding.round(number, MIN_ROUNDING, MIN_COMPARISON));
        assertEquals("Fails to rounding the normal number", result, rounding.round(number, LARGER_ROUNDING, MIN_COMPARISON));
        assertEquals("Fails to rounding the normal number", result, rounding.round(number, DEFAULT_ROUNDING, MIN_COMPARISON));
    }

    /**
     * Test of round(String number, int accuracyDigit, int comparisonDigit) with + sign.
     * 
     * The + sign will be removed in return value.
     */
    public void testRoundingWithPlusSign() {
        final String number = "+1.050";
        final String result = "1.050";

        // Rounding the number with + sign in different accuracy digit and comparison digit cases
        assertEquals("Fails to rounding with + sign", result, rounding.round(number, MIN_ROUNDING, MAX_COMPARISON));
        assertEquals("Fails to rounding with + sign", result, rounding.round(number, LARGER_ROUNDING, MAX_COMPARISON));
        assertEquals("Fails to rounding with + sign", result, rounding.round(number, DEFAULT_ROUNDING, MAX_COMPARISON));

        assertEquals("Fails to rounding with + sign", result, rounding.round(number, MIN_ROUNDING, DEFAULT_COMPARISON));
        assertEquals("Fails to rounding with + sign", result, rounding.round(number, LARGER_ROUNDING, DEFAULT_COMPARISON));
        assertEquals("Fails to rounding with + sign", result, rounding.round(number, DEFAULT_ROUNDING, DEFAULT_COMPARISON));

        assertEquals("Fails to rounding with + sign", result, rounding.round(number, MIN_ROUNDING, MIN_COMPARISON));
        assertEquals("Fails to rounding with + sign", result, rounding.round(number, LARGER_ROUNDING, MIN_COMPARISON));
        assertEquals("Fails to rounding with + sign", result, rounding.round(number, DEFAULT_ROUNDING, MIN_COMPARISON));
    }

    /**
     * Test of round(String, int, int) method.
     * normal cases
     */
    public void testRoundThreeArgsNormalCases() {
        assertEquals("Fails to rounding in normal cases", rounding.round("3.145", 3, 3), "3.145");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.145332", 3, 3), "3.145332");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.1", 3, 3), "3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("3145", 3, 3), "3145");

        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145", 3, 3), "-3.145");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145332", 3, 3), "-3.145332");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.1", 3, 3), "-3.1");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3145", 3, 3), "-3145");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme cases
     */
    public void testRoundThreeArgsExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.49999", 3, 3), "3.49999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.99999", 3, 3), "3.99999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.500001", 3, 3), "3.500001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.000001", 3, 3), "3.000001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("+3.000000", 3, 3), "3.000000");

        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999", 9, 3), "-3.49999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.99999", 9, 3), "-3.99999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.500001", 9, 3), "-3.500001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000001", 9, 3), "-3.000001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000000", 9, 3), "-3.000000");
    }

    /**
     * Test of round(String, int, int) method.
     * extreme forms
     */
    public void testRoundThreeArgsExtremeForm() {
        assertEquals("Fails to rounding in extreme forms", rounding.round("0.000000", 3, 3), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-0.000000", 3, 3), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("0", 3, 3), "0");
    }

    /**
     * Test of round(String) method.
     * normal cases
     */
    public void testRoundStringNormalCases() {
        assertEquals("Fails to rounding in normal cases", rounding.round("3.145"), "3.145");
        assertEquals("Fails to rounding in normal cases", rounding.round("3.145332"), "3.145332");
        assertEquals("Fails to rounding in normal cases", rounding.round("+3.9"), "3.9");
        assertEquals("Fails to rounding in normal cases", rounding.round("+3145"), "3145");

        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145"), "-3.145");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.145332"), "-3.145332");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3.9"), "-3.9");
        assertEquals("Fails to rounding in normal cases", rounding.round("-3145"), "-3145");
    }

    /**
     * Test of round(String) method.
     * extreme cases
     */
    public void testRoundStringExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.49999"), "3.49999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.99999"), "3.99999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.500001"), "3.500001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.000001"), "3.000001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("3.000000"), "3.000000");

        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.49999"), "-3.49999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.99999"), "-3.99999");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.500001"), "-3.500001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000001"), "-3.000001");
        assertEquals("Fails to rounding in extreme cases", rounding.round("-3.000000"), "-3.000000");
    }

    /**
     * Test of round(String) method.
     * extreme forms
     */
    public void testRoundStringExtremeForm() {
        assertEquals("Fails to rounding in extreme forms", rounding.round("+0.000000"), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("-0.000000"), "0");
        assertEquals("Fails to rounding in extreme forms", rounding.round("+0"), "0");
    }

    /**
     * Test of round(double) method.
     * normal cases
     */
    public void testRoundNormalCases() {
        assertEquals("Fails to rounding in normal cases", rounding.round(3.145), "3.145");
        assertEquals("Fails to rounding in normal cases", rounding.round(3.145332), "3.145332");
        assertEquals("Fails to rounding in normal cases", rounding.round(+3.9), "3.9");

        assertEquals("Fails to rounding in normal cases", rounding.round(-3.145), "-3.145");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.145332), "-3.145332");
        assertEquals("Fails to rounding in normal cases", rounding.round(-3.9), "-3.9");
    }

    /**
     * Test of round(double) method.
     * extreme cases
     */
    public void testRoundExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.round(3.49999), "3.49999");
        assertEquals("Fails to rounding in extreme cases", rounding.round(3.99999), "3.99999");
        assertEquals("Fails to rounding in extreme cases", rounding.round(3.500001), "3.500001");
        assertEquals("Fails to rounding in extreme cases", rounding.round(+3.000001), "3.000001");

        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.49999), "-3.49999");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.99999), "-3.99999");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.500001), "-3.500001");
        assertEquals("Fails to rounding in extreme cases", rounding.round(-3.000001), "-3.000001");
    }

    /**
     * Test of round(double) method.
     * extreme form
     */
    public void testRoundExtremeForm() {
        assertEquals("Fails to rounding in extreme form", rounding.round(0.000000), "0");
        assertEquals("Fails to rounding in extreme form", rounding.round(-0.000000), "0");
        assertEquals("Fails to rounding in extreme form", rounding.round(0), "0");
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * normal cases
     */
    public void testRoundDoubleNormalCases() {
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.145, 3, 3), 3.145, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.145332, 3, 3), 3.145332, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3.1, 3, 3), 3.1, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(3145, 3, 3), 3145, DELTA);

        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.145, 3, 3), -3.145, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.145332, 3, 3), -3.145332, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3.1, 3, 3), -3.1, DELTA);
        assertEquals("Fails to rounding in normal cases", rounding.roundDouble(-3145, 3, 3), -3145, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme cases
     */
    public void testRoundDoubleExtremeCases() {
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(3.49999, 3, 3), 3.49999, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(3.99999, 3, 3), 3.99999, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(3.500001, 3, 3), 3.500001, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(3.000001, 3, 3), 3.000001, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(3.000000, 3, 3), 3.000000, DELTA);

        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.49999, 9, 3), -3.49999, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.99999, 9, 3), -3.99999, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.500001, 9, 3), -3.500001, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.000001, 9, 3), -3.000001, DELTA);
        assertEquals("Fails to rounding in extreme cases", rounding.roundDouble(-3.000000, 9, 3), -3.000000, DELTA);
    }

    /**
     * Test of roundDouble(double, int, int) method.
     * extreme form
     */
    public void testRoundDoubleExtremeForm() {
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(.12345, 3, 3), 0.12345, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(12345., 3, 3), 12345, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0.000000, 3, 3), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(-0.000000, 3, 3), 0, DELTA);
        assertEquals("Fails to rounding in extreme form", rounding.roundDouble(0, 3, 3), 0, DELTA);
    }
}
