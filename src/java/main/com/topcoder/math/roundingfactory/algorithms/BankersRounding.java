/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

/**
 * <p>A concrete subclass of RoundingAlgorithm which performs the Banker's rounding algorithm:</p>
 * <p>If the digits past the accuracy digit are equals to the comparison digit, round the accuracy
 * digit to the closest even digit (0, 2, 4, 6, or 8). Otherwise round to the nearest number.</p>
 * <p>The number will not be changed if it's already a rounded number.</p>
 * <p>Example:</p>
 * <p>round(1.05, 1, 5) -> 1.0</p>
 * <p>round(1.15, 1, 5) -> 1.2</p>
 * <p>round(1.45, 1, 5) -> 1.4</p>
 * <p>round(1.55, 1, 5) -> 1.6</p>
 * <p>round(1.85, 1, 5) -> 1.8</p>
 * <p>round(1.95, 1, 5) -> 2.0</p>
 *
 * <p>This class is thread safe.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public class BankersRounding extends RoundingAlgorithm {

    /**
     * <p>Constructs an instance of BankersRounding with accuracyDigit equal to 2 and comparisonDigit equal to 5.</p>
     */
    public BankersRounding() {
        // empty
    }

    /**
     * <p>Constructs an instance of BankersRounding with accuracyDigit and comparisonDigit as specified.</p>
     *
     * @param accuracyDigit the desired accuracy
     * @param comparisonDigit the comparison digit
     * @throws IllegalArgumentException if comparisonDigit is less than 1 or greater than 9 or
     * the accuracyDigit is negative.
     */
    public BankersRounding(int accuracyDigit, int comparisonDigit) {
        super(accuracyDigit, comparisonDigit);
    }

    /**
     * <p>Performs the rounding.</p>
     * <p>If the digits past the accuracy digit are equals to the comparison digit, round the accuracy
     * digit to the closest even digit (0, 2, 4, 6, or 8). Otherwise round to the nearest number.</p>
     * <p>Example:</p>
     * <p>round(1.05, 1, 5) -> 1.0</p>
     * <p>round(1.15, 1, 5) -> 1.2</p>
     * <p>round(1.45, 1, 5) -> 1.4</p>
     * <p>round(1.55, 1, 5) -> 1.6</p>
     * <p>round(1.85, 1, 5) -> 1.8</p>
     * <p>round(1.95, 1, 5) -> 2.0</p>
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
                // if comparisonDigit is equals to truncation digits and the last digit is odd, round away from 0,
                // otherwise round towards 0
                if ((floatingNumber.getLastDigit(accuracyDigit) & 1) == 1) {
                    comparisonResult = 1;
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
