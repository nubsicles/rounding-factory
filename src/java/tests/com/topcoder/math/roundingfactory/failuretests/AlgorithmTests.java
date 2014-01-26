/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import junit.framework.TestCase;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;

/**
 * Base failure test class for all rounding algorithms
 * 
 * @author roma
 * @version 1.0
 */
public abstract class AlgorithmTests extends TestCase {

    /**
     * Valid value of accuracyDigit parameter
     */
    private static final int ACCURACY_DIGIT = 4;

    /**
     * Valid value of comparisonDigit parameter
     */
    private static final int COMPARISON_DIGIT = 5;

    /**
     * Some not invalid floating point numbers. Validaty is defined by designer.
     */
    private static final String[] INVALID_NUMBERS = new String[] { "++1", "+-1", "+1+", "1.1+", "1+.1",
            "1..1", "1-1", "-.", "+.", "  . ", "..", "1.00.00", ".11111.", ".123.456", "1E10", "1e10", "1/2", "PI",
            "(0.0)", "\"1.2\"", "0x0F", "0001A1", "A", "Invalid Number", "NaN", "Infinite", "-Inf", "null", "2^8",
            "2,3,4", "{1.2}", "[1.234]", "1&2", "-e-20", "+e+20", "1%2", "1$2", "--1", "-    -1", "1#009",
            "01/01/2005", "03:18", "-+1", "-1.1.", "0.000000000." };

    /**
     * Subclasses of this test case must create corresponding implementation of
     * Algorithm interface using parameter-less contructor.
     * 
     * @return new or existing Algorithm object instance that can be used for
     *         testing
     */
    public abstract Algorithm getAlgorithm();

    /**
     * Subclasses of this test case must create corresponding implementation of
     * Algorithm interface using (int,int) constructor.
     * 
     * @return new or existing Algorithm object instance that can be used for
     *         testing
     */
    public abstract Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit);

    /**
     * Test failure when using round(double) with a Double.NaN value
     */
    public void testRoundDoubleNaN() {
        try {
            getAlgorithm().round(Double.NaN);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException iae) {
            // Expected
        }
    }

    /**
     * Test failure when using round(double) with a Double.NEGATIVE_INFINITY
     * value
     */
    public void testRoundDoubleNegativeInfinity() {
        try {
            getAlgorithm().round(Double.NEGATIVE_INFINITY);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException iae) {
            // Expected
        }
    }

    /**
     * Test failure when using round(double) with a Double.POSITIVE_INFINITY
     * value
     */
    public void testRoundDoublePositiveInfinity() {
        try {
            getAlgorithm().round(Double.POSITIVE_INFINITY);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException iae) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String) with a null value
     */
    public void testRoundStringNull() {
        try {
            getAlgorithm().round(null);
            fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String) with a value "+"
     */
    public void testRoundStringPlus() {
        try {
            getAlgorithm().round("+");
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String) with a value "-+"
     */
    public void testRoundStringMinusPlus() {
        try {
            getAlgorithm().round("-+");
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String) with a value "0+"
     */
    public void testRoundStringZeroPlus() {
        try {
            getAlgorithm().round("0+");
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String) with a value "0.0.0"
     */
    public void testRoundStringZeroDotZeroDotZero() {
        try {
            getAlgorithm().round("0.0.0");
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String) with Extended Arabic-Indic digit
     * characters
     */
    public void testRoundStringExtendedArabicIndic() {
        for (char c = '\u06F0'; c <= '\u06F9'; c++) {
            try {
                getAlgorithm().round("" + c);
                fail("NumberFormatException expected for value " + c);
            } catch (NumberFormatException npe) {
                // Expected
            }
        }
    }

    /**
     * Test failure when using round(String) with other invalid
     * representatitions
     */
    public void testRoundStringMultiple() {
        StringBuffer error = new StringBuffer();
        for (int i = 0; i < INVALID_NUMBERS.length; i++) {
            try {
                getAlgorithm().round(INVALID_NUMBERS[i]);
                error.append("NumberFormatException expected for value '");
                error.append(INVALID_NUMBERS[i]);
                error.append("'\n");
            } catch (NumberFormatException npe) {
                // Expected
            }
        }
        // Fail with huge and usefull error message
        if(error.length()>0) {
            fail(error.toString());
        }
    }

    /**
     * Test failure when using round(String,int,int) with a value "+"
     */
    public void testRoundStringIntIntPlus() {
        try {
            getAlgorithm().round("+", ACCURACY_DIGIT, COMPARISON_DIGIT);
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String,int,int) with a value "-+"
     */
    public void testRoundStringIntIntMinusPlus() {
        try {
            getAlgorithm().round("-+", ACCURACY_DIGIT, COMPARISON_DIGIT);
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String,int,int) with a value "0+"
     */
    public void testRoundStringIntIntZeroPlus() {
        try {
            getAlgorithm().round("0+", ACCURACY_DIGIT, COMPARISON_DIGIT);
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String,int,int) with a value "0.0.0"
     */
    public void testRoundStringIntIntZeroDotZeroDotZero() {
        try {
            getAlgorithm().round("0.0.0", ACCURACY_DIGIT, COMPARISON_DIGIT);
            fail("NumberFormatException expected");
        } catch (NumberFormatException npe) {
            // Expected
        }
    }

    /**
     * Test failure when using round(String,int,int) with Arabic-Indic digit
     * characters
     */
    public void testRoundStringIntIntArabicIndic() {
        for (char c = '\u0660'; c <= '\u0669'; c++) {
            try {
                getAlgorithm().round("" + c, ACCURACY_DIGIT, COMPARISON_DIGIT);
                fail("NumberFormatException expected for value " + c);
            } catch (NumberFormatException npe) {
                // Expected
            }
        }
    }

    /**
     * Test failure when using round(String,int,int) with other invalid numeric
     * string representatitions
     */
    public void testRoundStringIntIntMultiple() {
        StringBuffer error = new StringBuffer();
        for (int i = 0; i < INVALID_NUMBERS.length; i++) {
            try {
                getAlgorithm().round(INVALID_NUMBERS[i], ACCURACY_DIGIT, COMPARISON_DIGIT);
                error.append("NumberFormatException expected for value '");
                error.append(INVALID_NUMBERS[i]);
                error.append("'\n");
            } catch (NumberFormatException npe) {
                // Expected
            }
        }
        // Fail with huge and usefull error message
        if(error.length()>0) {
            fail(error.toString());
        }
    }

    /**
     * Test failure when using setAccuracyDigit(int) with a negative value
     */
    public void testSetAccuracyDigitNegative() {
        try {
            getAlgorithm().setAccuracyDigit(-1);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException iae) {
            // Expected
        }
    }

    /**
     * Test failure when using setComparisonDigit(int) with a zero value
     */
    public void testSetComparisonDigitZero() {
        try {
            getAlgorithm().setComparisonDigit(0);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException iae) {
            // Expected
        }
    }

    /**
     * Test failure when using setComparisonDigit(int) with a 10 value
     */
    public void testSetComparisonDigitTen() {
        try {
            getAlgorithm().setComparisonDigit(10);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException iae) {
            // Expected
        }
    }
}