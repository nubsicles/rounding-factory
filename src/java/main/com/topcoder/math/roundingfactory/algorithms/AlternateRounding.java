/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

/**
 * <p>A concrete subclass of RoundingAlgorithm which performs the Alternate rounding algorithm:</p>
 * <p>If the digits past the accuracy digit equals to the comparison digit, round up in first time and than
 * choose whether to round up or down alternately. Otherwise round to the nearest number.</p>
 * <p>The number will not be changed if it's already a rounded number.</p>
 * <p>Example:</p>
 * <p>round(1.251, 1, 5) -> 1.3</p>
 * <p>round(1.25, 1, 5) -> 1.3</p>
 * <p>round(1.25, 1, 5) -> 1.2(again)</p>
 * <p>round(1.249, 1, 5) -> 1.2</p>
 *
 * <p>This class is thread safe.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public class AlternateRounding extends RoundingAlgorithm {

    /**
     * A flag indicating whether round up or round down.
     * The value will be changed alternately.
     */
    private boolean roundUp = true;

    /**
     * <p>Constructs an instance of AlternateRounding with accuracyDigit equal to 2 and
     * comparisonDigit equal to 5.</p>
     */
    public AlternateRounding() {
        // empty
    }

    /**
     * <p>Constructs an instance of AlternateRounding with accuracyDigit and comparisonDigit as specified.</p>
     *
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     */
    public AlternateRounding(int accuracyDigit, int comparisonDigit) {
        super(accuracyDigit, comparisonDigit);
    }

    /**
     * <p>Performs the rounding.</p>
     * <p>If the digits past the accuracy digit equals to the comparison digit, round up in first time and than
     * choose whether to round up or down alternately. Otherwise round to the nearest number.</p>
     * <p>Example:</p>
     * <p>round(1.251, 1, 5) -> 1.3</p>
     * <p>round(1.25, 1, 5) -> 1.2 or 1.3</p>
     * <p>round(1.249, 1, 5) -> 1.2</p>
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
            int comparisonResult = floatingNumber.truncationCompare(accuracyDigit, comparisonDigit);
            if (comparisonResult == 0) {

                // copy the old value
                boolean copyOfRoundUp = false;

                // accessing to roundUp variable must be synchronized
                synchronized (this) {
                    copyOfRoundUp = roundUp;
                    roundUp = !roundUp;
                }

                // if comparisonDigit equals to truncation digits,
                // choose round up or down according the roundUp flag
                if (copyOfRoundUp) {
                    return floatingNumber.roundUp(accuracyDigit);
                } else {
                    return floatingNumber.roundDown(accuracyDigit);
                }

            }

            if (comparisonResult == 1) {
                // if comparisonDigit is less than truncation digits, round away from 0
                return floatingNumber.roundAwayFromZero(accuracyDigit);
            } else {
                // if comparisonDigit is greater than truncation digits, round towards 0
                return floatingNumber.roundTowardsZero(accuracyDigit);
            }
        } catch (Exception e) {
            throw new RoundingException("exception occurs when rounding", e);
        }
    }
}
