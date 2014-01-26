/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

/**
 * <p>A concrete subclass of RoundingAlgorithm which performs the Always Round Down (Symmetric)
 * rounding algorithm:</p>
 * <p>Symmetrically rounds numbers down. Truncates all numbers toward 0. The absolute value of
 * the numbers decrease. Same as DownAsymmetricRounding for positive numbers.<p>
 * <p>The number will not be changed if it's already a rounded number.</p>
 * <p>Example:</p>
 * <p>round(1.20, 1, x) -> 1.2</p>
 * <p>round(1.25, 1, x) -> 1.2</p>
 * <p>round(-1.25, 1, x) -> -1.2</p>
 *
 * <p>This class is thread safe.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public class DownSymmetricRounding extends RoundingAlgorithm {

    /**
     * <p>Constructs an instance of DownSymmetricRounding with accuracyDigit equal to 2 and
     * comparisonDigit equal to 5.</p>
     */
    public DownSymmetricRounding() {
        // empty
    }

    /**
     * <p>Constructs an instance of DownSymmetricRounding with accuracyDigit and comparisonDigit as specified.</p>
     *
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     */
    public DownSymmetricRounding(int accuracyDigit, int comparisonDigit) {
        super(accuracyDigit, comparisonDigit);
    }

    /**
     * <p>Performs the rounding.</p>
     * <p>Symmetrically rounds numbers down. Truncates all numbers toward 0. Same as
     * DownAsymmetricRounding for positive numbers.<p>
     * <p>Truncates everything after the accuracy digit, and then rounds the last digit
     * of number such that the absolute value of the number decreases.</p>
     * <p>Example:</p>
     * <p>round(1.20, 1, x) -> 1.2</p>
     * <p>round(1.25, 1, x) -> 1.2</p>
     * <p>round(-1.25, 1, x) -> -1.2</p>
     *
     * @return the rounded number
     * @param number the number to round
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws NullPointerException if number is null
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     * @throws NumberFormatException if number is not a valid floating point number
     */
    public String round(String number, int accuracyDigit, int comparisonDigit) {

        // check arguments
        RoundingAlgorithm.checkRoundingArguments(accuracyDigit, comparisonDigit);

        // exception will be thrown if the number is invalid
        FloatingNumber floatingNumber = new FloatingNumber(number);
        try {
            // round the number towards 0
            return floatingNumber.roundTowardsZero(accuracyDigit);
        } catch (Exception e) {
            throw new RoundingException("exception occurs when rounding", e);
        }

    }
}
