/*
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.math.roundingfactory.accuracytests;

/**
 * The interface used to define all accuracy testing contants.
 *
 * @author alanSunny
 * @version 1.0
 */
interface RoundingAccuracyTestConstants {
    /** the delta for assertEquals(double expected, double actual, double delta) method. */
    static final double DELTA = 1e-8;

    /** The constant of minimal comparison digit. */
    static final int MIN_COMPARISON = 1;

    /** The constant of maximal comparison digit. */
    static final int MAX_COMPARISON = 9;

    /** The constant of default comparison digit. */
    static final int DEFAULT_COMPARISON = 5;

    /** The constant of minimal rounding digit. */
    static final int MIN_ROUNDING = 0;

    /** The constant of rounding digit that is larger than the test number digit. */
    static final int LARGER_ROUNDING = 6;

    /** The constant of rounding digit that is equals to the test number digit. */
    static final int EQUAL_ROUNDING = 5;

    /** The constant of default rounding digit. */
    static final int DEFAULT_ROUNDING = 2;

    /** The constant of test negative number. */
    static final double TEST_NEGATIVE_NUMBER = -3.21234;

    /** The constant of test positive number. */
    static final double TEST_POSITIVE_NUMBER = 3.21234;
}
