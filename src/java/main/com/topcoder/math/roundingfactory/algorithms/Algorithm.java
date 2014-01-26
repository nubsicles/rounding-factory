/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

/**
 * <p>An interface class that represents an algorithm to perform rounding.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public interface Algorithm {

    /**
     * <p>Rounds the given string number using the given accuracy and comparison digits, overriding the defaults.</p>
     * <p>This method needs to be implemented by concrete subclasses to provide differing behavior.</p>
     *
     * @return the rounded result
     * @param number a number to round
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     *
     * @throws NullPointerException if number is null
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * if the accuracyDigit is negative.
     * @throws RoundingException if exceptions occur while rounding.
     * @throws NumberFormatException if number is not a valid floating point number
     */
    String round(String number, int accuracyDigit, int comparisonDigit);

    /**
     * <p>Rounds the given double number using the given accuracy and comparison digits, overriding the defaults.</p>
     * @return the rounded result
     * @param number a number to round
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws RoundingException if any exceptions occur when rounding or any exception occurs while converting
     * the string to double.
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * if the accuracyDigit is negative.
     */
    double roundDouble(double number, int accuracyDigit, int comparisonDigit);

    /**
     * <p>Rounds the given double number using the default accuracy and comparison digits.</p>
     *
     * @return the rounded result
     * @param number a number to round
     * @throws RoundingException if any exceptions occur while rounding
     */
    String round(double number);

    /**
     * <p>Rounds the given string number using the default accuracy and comparison digits.</p>
     *
     * @return the rounded result
     * @param number a number to round
     * @throws NullPointerException if number is null
     * @throws RoundingException if any exceptions occur when rounding.
     * @throws NumberFormatException if number is not a valid floating point number
     */
    String round(String number);

    /**
     * <p>Get the accuracy digit representing the level of precision.</p>
     *
     * @return the accuracy digit representing the level of precision.
     */
    int getAccuracyDigit();

    /**
     * <p>Gets the comparison digit representing the tie-breaker value.</p>
     *
     * @return the comparison digit representing the tie-breaker value.
     */
    int getComparisonDigit();

    /**
     * <p>Set the accuracy digit representing the level of precision.
     * Any non-negative integer is allowable.</p>
     *
     * @param accuracyDigit the desired accuracy to be set
     * @throws IllegalArgumentException if the given number is negative
     */
    void setAccuracyDigit(int accuracyDigit);

    /**
     * <p>Set the comparison digit, representing the &quot;tie-breaker&quot; value.</p>
     * <p>Valid values are between 1 and 9, inclusive.</p>
     *
     * @param comparisonDigit the comparison digit to be set
     * @throws IllegalArgumentException if the given number is out of the scope of 1 to 9.
     */
    void setComparisonDigit(int comparisonDigit);
}
