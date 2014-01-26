/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

/**
 * <p>A concrete subclass of RoundingAlgorithm which performs the No Rounding algorithm:</p>
 * <p>Don't do any rounding, simple as that. The returned number will not contain sign "+",
 * if the returned number is non-negative.</p>
 * <p>If the result equals 0, "0" will be returned</p>
 * <p>Example:</p>
 * <p>round("+001.050") -> "001.050"</p>
 * <p>round("-001.050") -> "-001.050"</p>
 * <p>round("+000.000") -> "0"</p>
 *
 * <p>This class is thread safe.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public class NoRounding extends RoundingAlgorithm {

    /**
     * <p>Constructs an instance of NoRounding with accuracyDigit equal to 2 and comparisonDigit equal to 5.</p>
     */
    public NoRounding() {
        // empty
    }

    /**
     * <p>Constructs an instance of NoRounding with accuracyDigit and comparisonDigit as specified.</p>
     *
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     */
    public NoRounding(int accuracyDigit, int comparisonDigit) {
        super(accuracyDigit, comparisonDigit);
    }

    /**
     * <p>Performs the rounding.</p>
     * <p>As indicated by the name, this does no rounding, just return number.
     * If the given number contains "+", remove it before it returned.</p>
     * <p>Refer to CS for more details.</p>
     * <p>If the result equals 0, "0" will be returned</p>
     * <p>Example:</p>
     * <p>round("+001.050") -> "001.050"</p>
     * <p>round("-001.050") -> "-001.050"</p>
     * <p>round("+000.000") -> "0"</p>
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

        // Note: this class will never throw RoundingException

        // exception will be thrown if the number is invalid
        FloatingNumber floatingNumber = new FloatingNumber(number);

        // if the number is 0, simply return "0"
        if (floatingNumber.isZero()) {
            return "0";
        }

        if (number.charAt(0) == '+') {
            // remove the '+' if necessary
            return number.substring(1);
        } else {
            return number;
        }

    }
}
