/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

/**
 * <p>A concrete subclass of RoundingAlgorithm which performs the Always Round Down (Asymmetric)
 * rounding algorithm:</p>
 * <p>Asymmetrically rounds numbers down. All numbers decrease. Negative numbers get more negative.</p>
 * <p>The number will not be changed if it's already a rounded number.</p>
 * <p>Example:</p>
 * <p>round(1.20, 1, x) -> 1.2</p>
 * <p>round(1.25, 1, x) -> 1.2</p>
 * <p>round(-1.25, 1, x) -> -1.3</p>
 *
 * <p>This class is thread safe.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public class DownAsymmetricRounding extends RoundingAlgorithm {

    /**
     * <p>Constructs an instance of DownAsymmetricRounding with accuracyDigit equal to 2 and
     * comparisonDigit equal to 5.</p>
     */
    public DownAsymmetricRounding() {
        // empty
    }

    /**
     * <p>Constructs an instance of DownAsymmetricRounding with accuracyDigit and comparisonDigit as specified.</p>
     *
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     */
    public DownAsymmetricRounding(int accuracyDigit, int comparisonDigit) {
        super(accuracyDigit, comparisonDigit);
    }

    /**
     * <p>Asymmetrically rounds numbers down. All numbers decrease. Negative numbers get more negative.</p>
     * <p>Truncate everything after the accuracy digit, and round down,
     * UNLESS the input is a 'round number'. That is, if the input given would
     * result from a call to Round(), only do the truncation. </p>
     * <p>Example:</p>
     * <p>round(1.20, 1, x) -> 1.2</p>
     * <p>round(1.25, 1, x) -> 1.2</p>
     * <p>round(-1.25, 1, x) -> -1.3</p>
     *
     * @return the rounded number
     * @param number the number to round
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws NullPointerException if number is null
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     * @throws NumberFormatException if number is not a valid floating point number
     * @throws RoundingException if any exception occurs when rounding.
     */
    public String round(String number, int accuracyDigit, int comparisonDigit) {

        // check arguments
        RoundingAlgorithm.checkRoundingArguments(accuracyDigit, comparisonDigit);

        // exception will be thrown if the number is invalid
        FloatingNumber floatingNumber = new FloatingNumber(number);
        try {
            // round the numbe down(decrease)
            return floatingNumber.roundDown(accuracyDigit);
        } catch (Exception e) {
            throw new RoundingException("exception occurs when rounding", e);
        }

    }
}
