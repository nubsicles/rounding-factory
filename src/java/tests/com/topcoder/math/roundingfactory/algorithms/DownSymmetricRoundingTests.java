/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

import junit.framework.TestCase;

/**
 * <p>Tests the DownSymmetricRounding class.</p>
 *
 * @author TCSDEVELOPER
 *
 * @copyright (c) 2005, Topcoder, Inc. All Rights Reserved.
 *
 * @version 1.0
 */
public class DownSymmetricRoundingTests extends TestCase {

    /**
     * DELTA is used to compare double values.
     */
    private static final double DELTA = 1e-10;


    /**
     * A DownSymmetricRounding instance for tests.
     */
    private Algorithm algorithm = null;


    /**
     * Creates the rounding algorithm instance.
     */
    protected void setUp() {
        algorithm = new DownSymmetricRounding();
    }

    /**
     * Tests constructor.
     * DownSymmetricRounding().
     * The accuracy and comparison digits should be default value.
     */
    public void testDownSymmetricRounding1() {
        assertEquals("The accuracy digit should be 2", 2, algorithm.getAccuracyDigit());
        assertEquals("The comparison digit should be 5", 5, algorithm.getComparisonDigit());
    }

    /**
     * Tests constructor.
     * DownSymmetricRounding(int, int).
     * The accuracy and comparison digits should be given value.
     */
    public void testDownSymmetricRounding2() {

        algorithm = new DownSymmetricRounding(3, 9);

        assertEquals("The accuracy digit should be 2", 3, algorithm.getAccuracyDigit());
        assertEquals("The comparison digit should be 9", 9, algorithm.getComparisonDigit());
    }

    /**
     * Tests constructor.
     * DownSymmetricRounding(int, int).
     * Invalid accuracy digits, IllegalArgumentException should be thrown.
     */
    public void testDownSymmetricRounding3() {
        try {
            new DownSymmetricRounding(-1, 9);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests constructor.
     * DownSymmetricRounding(int, int).
     * Invalid comparison digits, IllegalArgumentException should be thrown.
     */
    public void testDownSymmetricRounding4() {
        try {
            new DownSymmetricRounding(3, 0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }



    /**
     * Tests constructor.
     * DownSymmetricRounding(int, int).
     * Invalid comparison digits, IllegalArgumentException should be thrown.
     */
    public void testDownSymmetricRounding5() {
        try {
            new DownSymmetricRounding(3, 10);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests round(String number, int accuracyDigit, int comparisonDigit).
     * The number is null, NullPointerException should be thrown.
     */
    public void testRound1() {
        try {
            // null is invalid
            algorithm.round(null, 2, 5);
            fail("NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // success
        }
    }

    /**
     * Tests round(String number, int accuracyDigit, int comparisonDigit).
     * The number is invalid, NumberFormatException should be thrown.
     */
    public void testRound2() {
        try {
            // empty string is invalid
            algorithm.round("", 2, 5);
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            // a single symbol is invalid
            algorithm.round("-", 2, 5);
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            // the number should contain one digit at least
            algorithm.round(".", 2, 5);
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            //the number should contain one digit at least
            algorithm.round("+.", 2, 5);
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            // scientific notion is not supported.
            algorithm.round("+1.3e10", 2, 5);
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }
    }

    /**
     * Tests round(String number, int accuracyDigit, int comparisonDigit).
     * The accuracyDigit is invalid, IllegalArgumentException should be thrown.
     */
    public void testRound3() {
        try {
            algorithm.round("1.1", -1, 5);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests round(String number, int accuracyDigit, int comparisonDigit).
     * The comparisonDigit is invalid, IllegalArgumentException should be thrown.
     */
    public void testRound4() {
        try {
            algorithm.round("1.1", 3, 0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            algorithm.round("1.1", 3, 10);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests round(String number, int accuracyDigit, int comparisonDigit).
     * Rounds zero. the result should always be "0".
     */
    public void testRound5() {

        // if the number is 0, the result should always be "0"
        assertEquals("result should be 0", "0", algorithm.round(".0", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round(".00000000", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("+.0", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("-.0", 3, 7));


        assertEquals("result should be 0", "0", algorithm.round("0.", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("000.", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("+0.", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("-0.", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("+0000.", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("-0000.", 3, 7));

        assertEquals("result should be 0", "0", algorithm.round("0", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("+0.", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("-0.", 3, 7));

        assertEquals("result should be 0", "0", algorithm.round("0.00", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("+0.00", 3, 7));
        assertEquals("result should be 0", "0", algorithm.round("-0.00", 3, 7));
    }

    /**
     * Tests round(String number, int accuracyDigit, int comparisonDigit).
     * Rounds strange numbers
     */
    public void testRound6() {

        assertEquals("result should be 1.000", "1.000", algorithm.round("1.0000000000", 3, 7));
        assertEquals("result should be 1.000", "1.000", algorithm.round("1.", 3, 7));
        assertEquals("result should be 1.000", "1.000", algorithm.round("+1.", 3, 7));
        assertEquals("result should be -1.000", "-1.000", algorithm.round("-1.", 3, 7));
        assertEquals("result should be 1.000", "1.000", algorithm.round("0001", 3, 7));

        assertEquals("result should be 0.001", "0.001", algorithm.round(".001", 3, 7));
        assertEquals("result should be 0.001", "0.001", algorithm.round(".00100", 3, 7));
        assertEquals("result should be 0.001", "0.001", algorithm.round("+.00100", 3, 7));
        assertEquals("result should be -0.001", "-0.001", algorithm.round("-.00100", 3, 7));

        assertEquals("result should be 0.010", "0.010", algorithm.round("0.01", 3, 7));
        assertEquals("result should be 0.010", "0.010", algorithm.round("+0.01", 3, 7));
        assertEquals("result should be -0.010", "-0.010", algorithm.round("-0.01", 3, 7));
        assertEquals("result should be 0.010", "0.010", algorithm.round("000.01", 3, 7));

        assertEquals("result should be 10.010", "10.010", algorithm.round("10.01", 3, 7));
        assertEquals("result should be 10.010", "10.010", algorithm.round("+010.010", 3, 7));
        assertEquals("result should be -10.010", "-10.010", algorithm.round("-010.010", 3, 7));
    }

    /**
     * Tests round(String number, int accuracyDigit, int comparisonDigit).
     * Rounds general numbers.
     */
    public void testRound7() {

        // up symmetric rounding
        assertEquals("result should be 1.12", "1.12", algorithm.round("1.12", 2, 5));
        assertEquals("result should be 1.12", "1.12", algorithm.round("1.12001", 2, 5));
        assertEquals("result should be -1.12", "-1.12", algorithm.round("-1.12001", 2, 5));


        // no rounding should be performed since the numbers are already rounded.
        assertEquals("result should be 123.456000", "123.456000", algorithm.round("123.456", 6, 5));
        assertEquals("result should be 123.456000", "123.456000", algorithm.round("+123.456", 6, 5));
        assertEquals("result should be -123.456000", "-123.456000", algorithm.round("-123.456", 6, 5));

        // boundary situation
        assertEquals("result should be 0.09", "0.09", algorithm.round("0.096", 2, 5));
        assertEquals("result should be -0.09", "-0.09", algorithm.round("-0.096", 2, 5));
        assertEquals("result should be 9.99", "9.99", algorithm.round("9.999", 2, 5));
        assertEquals("result should be -9.99", "-9.99", algorithm.round("-9.999", 2, 5));

        // when accuracy digit is 0
        assertEquals("result should be 0", "0", algorithm.round("0.01", 0, 5));
        assertEquals("result should be 0", "0", algorithm.round("-0.6", 0, 5));
        assertEquals("result should be 0", "0", algorithm.round(".4", 0, 5));
        assertEquals("result should be 10", "10", algorithm.round("10.01", 0, 5));
        assertEquals("result should be -10", "-10", algorithm.round("-10.6", 0, 5));
        assertEquals("result should be 10", "10", algorithm.round("10.5", 0, 5));
        assertEquals("result should be -10", "-10", algorithm.round("-10.5", 0, 5));

    }

    /**
     * Tests round(String number).
     * The number is null, NullPointerException should be thrown.
     */
    public void testRound8() {
        try {
            // null is invalid
            algorithm.round(null);
            fail("NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // success
        }
    }

    /**
     * Tests round(String number).
     * The number is invalid, NumberFormatException should be thrown.
     */
    public void testRound9() {
        try {
            // empty string is invalid
            algorithm.round("");
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            // a single symbol is invalid
            algorithm.round("-");
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            // the number should contain one digit at least
            algorithm.round(".");
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            //the number should contain one digit at least
            algorithm.round("+.");
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }

        try {
            // scientific notion is not supported.
            algorithm.round("+1.3e10");
            fail("NumberFormatException should be thrown");
        } catch (NumberFormatException e) {
            // success
        }
    }

    /**
     * Tests round(String number).
     * Rounds zero. the result should always be "0".
     */
    public void testRound10() {

        // if the number is 0, the result should always be "0"
        assertEquals("result should be 0", "0", algorithm.round(".0"));
        assertEquals("result should be 0", "0", algorithm.round(".00000000"));
        assertEquals("result should be 0", "0", algorithm.round("+.0"));
        assertEquals("result should be 0", "0", algorithm.round("-.0"));


        assertEquals("result should be 0", "0", algorithm.round("0."));
        assertEquals("result should be 0", "0", algorithm.round("000."));
        assertEquals("result should be 0", "0", algorithm.round("+0."));
        assertEquals("result should be 0", "0", algorithm.round("-0."));
        assertEquals("result should be 0", "0", algorithm.round("+0000."));
        assertEquals("result should be 0", "0", algorithm.round("-0000."));

        assertEquals("result should be 0", "0", algorithm.round("0"));
        assertEquals("result should be 0", "0", algorithm.round("+0."));
        assertEquals("result should be 0", "0", algorithm.round("-0."));

        assertEquals("result should be 0", "0", algorithm.round("0.00"));
        assertEquals("result should be 0", "0", algorithm.round("+0.00"));
        assertEquals("result should be 0", "0", algorithm.round("-0.00"));
    }

    /**
     * Tests round(String number).
     * Rounds strange numbers.
     */
    public void testRound11() {

        // set the accuracy digit befor tests.
        algorithm.setAccuracyDigit(3);

        assertEquals("result should be 1.000", "1.000", algorithm.round("1.0000000000"));
        assertEquals("result should be 1.000", "1.000", algorithm.round("1."));
        assertEquals("result should be 1.000", "1.000", algorithm.round("+1."));
        assertEquals("result should be -1.000", "-1.000", algorithm.round("-1."));
        assertEquals("result should be 1.000", "1.000", algorithm.round("0001"));

        assertEquals("result should be 0.001", "0.001", algorithm.round(".001"));
        assertEquals("result should be 0.001", "0.001", algorithm.round(".00100"));
        assertEquals("result should be 0.001", "0.001", algorithm.round("+.00100"));
        assertEquals("result should be -0.001", "-0.001", algorithm.round("-.00100"));

        assertEquals("result should be 0.010", "0.010", algorithm.round("0.01"));
        assertEquals("result should be 0.010", "0.010", algorithm.round("+0.01"));
        assertEquals("result should be -0.010", "-0.010", algorithm.round("-0.01"));
        assertEquals("result should be 0.010", "0.010", algorithm.round("000.01"));

        assertEquals("result should be 10.010", "10.010", algorithm.round("10.01"));
        assertEquals("result should be 10.010", "10.010", algorithm.round("+010.010"));
        assertEquals("result should be -10.010", "-10.010", algorithm.round("-010.010"));
    }

    /**
     * Tests round(String number).
     * Rounds general numbers.
     */
    public void testRound12() {

        // up symmetric rounding
        assertEquals("result should be 1.12", "1.12", algorithm.round("1.12"));
        assertEquals("result should be 1.12", "1.12", algorithm.round("1.12001"));
        assertEquals("result should be -1.12", "-1.12", algorithm.round("-1.12001"));


        assertEquals("result should be 0", "0", algorithm.round("0.00000001"));
        assertEquals("result should be 0", "0", algorithm.round("-0.00000001"));

        // boundary situation
        assertEquals("result should be 0.09", "0.09", algorithm.round("0.096"));
        assertEquals("result should be -0.09", "-0.09", algorithm.round("-0.096"));
        assertEquals("result should be 9.99", "9.99", algorithm.round("9.999"));
        assertEquals("result should be -9.99", "-9.99", algorithm.round("-9.999"));

    }

    /**
     * Tests round(double number).
     * The double number is not proper, IllegalArgumentException should be thrown.
     */
    public void testRound13() {

        try {
            // NaN is invalid
            algorithm.round(Double.NaN);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            // NEGATIVE_INFINITY is invalid
            algorithm.round(Double.NEGATIVE_INFINITY);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            // POSITIVE_INFINITY is invalid
            algorithm.round(Double.POSITIVE_INFINITY);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

    }

    /**
     * Tests round(double number).
     * Rounds general numbers.
     */
    public void testRound14() {

        // up symmetric rounding
        assertEquals("result should be 1.12", "1.12", algorithm.round(1.12));
        assertEquals("result should be 1.12", "1.12", algorithm.round(1.12001));
        assertEquals("result should be -1.12", "-1.12", algorithm.round(-1.12001));

        // the reslut should be "0"
        assertEquals("result should be 0", "0", algorithm.round(0.00000001));
        assertEquals("result should be 0", "0", algorithm.round(-0.00000001));

        // boundary situation
        assertEquals("result should be 0.09", "0.09", algorithm.round(0.096));
        assertEquals("result should be -0.09", "-0.09", algorithm.round(-0.096));
        assertEquals("result should be 9.99", "9.99", algorithm.round(9.999));
        assertEquals("result should be -9.99", "-9.99", algorithm.round(-9.999));

    }

    /**
     * Tests roundDouble(double number, int accuracyDigit, int comparisonDigit).
     * The double number is not proper, IllegalArgumentException should be thrown.
     */
    public void testRoundDouble1() {

        try {
            // NaN is invalid
            algorithm.roundDouble(Double.NaN, 3, 7);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            // NEGATIVE_INFINITY is invalid
            algorithm.roundDouble(Double.NEGATIVE_INFINITY, 3, 7);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            // POSITIVE_INFINITY is invalid
            algorithm.roundDouble(Double.POSITIVE_INFINITY, 3, 7);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

    }

    /**
     * Tests roundDouble(double number, int accuracyDigit, int comparisonDigit).
     * The accuracyDigit is invalid, IllegalArgumentException should be thrown.
     */
    public void testRoundDouble2() {
        try {
            algorithm.roundDouble(1.1, -1, 5);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests roundDouble(double number, int accuracyDigit, int comparisonDigit).
     * The comparisonDigit is invalid, IllegalArgumentException should be thrown.
     */
    public void testRoundDouble3() {
        try {
            algorithm.roundDouble(1.1, 3, 0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            algorithm.roundDouble(1.1, 3, 10);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests roundDouble(double number, int accuracyDigit, int comparisonDigit).
     * Rounds general numbers.
     */
    public void testRoundDouble4() {

        // up symmetric rounding
        assertEquals("result should be 1.12", 1.12, algorithm.roundDouble(1.12, 2, 5), DELTA);
        assertEquals("result should be 1.12", 1.12, algorithm.roundDouble(1.12001, 2, 5), DELTA);
        assertEquals("result should be -1.12", -1.12, algorithm.roundDouble(-1.12001, 2, 5), DELTA);

        // the reslut should be 0
        assertEquals("result should be 0", 0, algorithm.roundDouble(0.00000001, 2, 5), DELTA);
        assertEquals("result should be 0", 0, algorithm.roundDouble(-0.00000001, 2, 5), DELTA);

        // boundary situation
        assertEquals("result should be 0.09", 0.09, algorithm.roundDouble(0.096, 2, 5), DELTA);
        assertEquals("result should be -0.09", -0.09, algorithm.roundDouble(-0.096, 2, 5), DELTA);
        assertEquals("result should be 9.99", 9.99, algorithm.roundDouble(9.999, 2, 5), DELTA);
        assertEquals("result should be -9.99", -9.99, algorithm.roundDouble(-9.999, 2, 5), DELTA);

    }

    /**
     * Tests getAccuracyDigit method.
     */
    public void testGetAccuracyDigit() {
        assertEquals("The accuracy digit should be 2", 2, algorithm.getAccuracyDigit());
    }

    /**
     * Tests setAccuracyDigit method.
     * Invalid argument, IllegalArgumentException should be thrown.
     */
    public void testSetAccuracyDigit1() {
        try {
            algorithm.setAccuracyDigit(-1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests setAccuracyDigit method.
     * The accuracy digit should be set.
     */
    public void testSetAccuracyDigit2() {

        algorithm.setAccuracyDigit(10);

        assertEquals("The accuracy digit should be 10", 10, algorithm.getAccuracyDigit());
    }

    /**
     * Tests getComparisonDigit method.
     */
    public void testGetComparisonDigit() {
        assertEquals("The comparison digit should be 5", 5, algorithm.getComparisonDigit());
    }

    /**
     * Tests setComparisonDigit method.
     * Invalid argument, IllegalArgumentException should be thrown.
     */
    public void testSetComparisonDigit1() {
        try {
            algorithm.setComparisonDigit(-1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests setComparisonDigit method.
     * The comparison digit should be set.
     */
    public void testSetComparisonDigit2() {

        algorithm.setComparisonDigit(2);

        assertEquals("The comparison digit should be 2", 2, algorithm.getComparisonDigit());
    }

}
