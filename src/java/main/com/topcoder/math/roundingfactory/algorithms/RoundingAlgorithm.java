/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;


import java.text.NumberFormat;


/**
 * <p>An abstract class that represents an algorithm to perform rounding. This class keeps
 * default accuracy digit and comparison digit settings. The given accuracy and comparison
 * digits can be used by the concrete rounding algorithms.</p>
 *
 * <p>This class is thread safe.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public abstract class RoundingAlgorithm implements Algorithm {

    /**
     * <p>The accuracy digit, representing the level of precision that we want. Default is 2,
     * meaning two places after the decimal point. Any non-negative integer is allowable.</p>
     */
    private int accuracyDigit = 2;

    /**
     * <p>The comparison digit, representing the &quot;tie-breaker&quot; value. Default is 5.</p>
     * <p>Valid values are between 1 and 9, inclusive.</p>
     */
    private int comparisonDigit = 5;

    /**
     * <p>The protected constructor to prevent this class be instantiated.</p>
     * <p>This constructor is empty.</p>
     */
    protected RoundingAlgorithm() {
        // empty constructor
    }

    /**
     * <p>The protected constructor.</p>
     * <p>RoundingAlgorithms cannot actually be instantiated, but the constructor will set the
     * values of accuracyDigit and comparisonDigit.</p>
     *
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * if the accuracyDigit is negative.
     */
    protected RoundingAlgorithm(int accuracyDigit, int comparisonDigit) {
        this.accuracyDigit = accuracyDigit;
        this.comparisonDigit = comparisonDigit;
    }

    /**
     * <p>Rounds the given number based on the default accuracy and comparison digits.</p>
     *
     * @return the rounded result
     * @param number a number to round
     * @throws NullPointerException if number is null
     * @throws RoundingException if any exceptions occur when rounding.
     * @throws NumberFormatException if number is not a valid floating point number
     */
    public String round(String number) {
        return round(number, this.accuracyDigit, this.comparisonDigit);
    }

    /**
     * <p>Rounds the given number using the given accuracy and comparison digits, overriding the defaults.</p>
     * <p>Abstract because this is the method that needs to be implemented by concrete subclasses to
     * provide differing behavior.</p>
     *
     * @return the rounded result
     * @param number a number to round
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws NullPointerException if number is null
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     * @throws RoundingException if exceptions occur when rounding.
     * @throws NumberFormatException if number is not a valid floating point number
     */
    public abstract String round(String number, int accuracyDigit, int comparisonDigit);

    /**
     * <p>Convenience method that rounds doubles using the default accuracy and comparison digit.</p>
     * <p>Note: Because scientific notion is not supported, a very long string
     * maybe return if the exponent is large.</p>
     * @return the rounded number
     * @param number a number to round
     * @throws IllegalArgumentException if the number is not proper
     * @throws RoundingException if any exceptions occur when rounding
     */
    public String round(double number) {
        return roundDouble(number, this.accuracyDigit, this.comparisonDigit);
    }

    /**
     * <p>Convenience method that round doubles using the given accuracy and comparison digits,
     * overriding the defaults.</p>
     *
     * @return the rounded number
     * @param number a number to round
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws IllegalArgumentException if the number is not proper or comparisonDigit is less than 1 or
     * greater than 9 or the accuracyDigit is negative.
     * @throws RoundingException if any exceptions occur when rounding and when exception occurs
     * in converting the string to double.
     */
    public double roundDouble(double number, int accuracyDigit, int comparisonDigit) {
        // check arguments
        checkRoundingArguments(accuracyDigit, comparisonDigit);

        return 0.0;
    }

    /**
     * Converts double to String. Note: Because scientific notion is not supported, a very long string
     * maybe return if the exponent is large.
     *
     * @param number the double value to be converted.
     * @return the string value
     * @throws IllegalArgumentException if the number is not proper
     */
    private static String doubleToString(double number) {
        return "";
    }

    /**
     * <p>Get the accuracy digit representing the level of precision.</p>
     *
     * @return the accuracy digit representing the level of precision.
     */
    public int getAccuracyDigit() {
        return this.accuracyDigit;
    }

    /**
     * <p>Gets the comparison digit representing the tie-breaker value.</p>
     *
     * @return the comparison digit representing the tie-breaker value.
     */
    public int getComparisonDigit() {
        return this.comparisonDigit;
    }

    /**
     * <p>Set the accuracy digit representing the level of precision.
     * Any non-negative integer is allowable.</p>
     *
     * @param accuracyDigit the desired accuracy
     * @throws IllegalArgumentException if the given number is negative
     */
    public void setAccuracyDigit(int accuracyDigit) {
        this.accuracyDigit = accuracyDigit;
    }

    /**
     * <p>Set the comparison digit, representing the &quot;tie-breaker&quot; value.</p>
     * <p>Valid values are between 1 and 9, inclusive.</p>
     *
     * @param comparisonDigit the comparison digit to be set
     * @throws IllegalArgumentException if the given number is out of the scope of 1 to 9.
     */
    public void setComparisonDigit(int comparisonDigit) {
        this.comparisonDigit = comparisonDigit;
    }

    /**
     * <p>Checks whether the accuracy digit and comparison digit are valid</p>
     * <p>accuracyDigit should be non-negative.</p>
     * <p>comparisonDigit should be between 1 and 9, inclusive.</p>
     *
     * @param accuracyDigit the accuracy digit to be verified.
     * @param comparisonDigit the comparison digit to be verified.
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * if the accuracyDigit is negative.
     */
    static void checkRoundingArguments(int accuracyDigit, int comparisonDigit) {
        return;
    }

    /**
     * <p>Checks whether the accuracy digit is valid</p>
     * <p>accuracyDigit should be non-negative.</p>
     *
     * @param accuracyDigit the accuracy digit to be verified.
     * @throws IllegalArgumentException if the accuracyDigit is negative.
     */
    private static void checkAccuracyDigit(int accuracyDigit) {
        return;
    }

    /**
     * <p>Checks whether the comparison digit is valid</p>
     * <p>comparisonDigit should be between 1 and 9, inclusive.</p>
     *
     * @param comparisonDigit the comparison digit to be verified.
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9.
     */
    private static void checkComparisonDigit(int comparisonDigit) {
        return;
    }

}
