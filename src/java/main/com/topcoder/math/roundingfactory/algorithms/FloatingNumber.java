/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

/**
 * <p>A helper class used to parse floating-number.
 * This class can parse floating-number and provides some useful rounding methods including
 * round up, round down, round away form zero round towards zero.</p>
 * <p>NOTE:This class does not support scientific notion</p>
 * <p>Examples:</p>
 *
 * <p>RoundUp(1): 123.45 -> 123.5, -123.45 -> -123.4</p>
 *
 * <p>RoundDown(1): 123.45 -> 123.4, -123.45 -> -123.5</p>
 *
 * <p>RoundTowardsZero(1): 123.45 -> 123.4, -123.45 -> -123.4</p>
 *
 * <p>RoundAwayFromsZero(1): 123.45 -> 123.4, -123.45 -> -123.4</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @copyright (c) 2005, Topcoder, Inc. All Rights Reserved.
 *
 * @version 1.0
 */
class FloatingNumber {

    /**
     * Constant for the decimal symbol.
     */
    private static final String DECIMAL_SYMBOL = ".,";

    /**
     * Current decimal symbol.
     */
    private char currentDecimalSymbol = '.';

    /**
     * The integral digits of this floating-number.
     * Note: these digits excludes leading 0's.
     */
    private String integral = "0";

    /**
     * The fractional digits of this floating-number.
     * Note: these digits excludes trailing 0's.
     */
    private String fractional = "";

    /**
     * The sign of this floating-number.
     */
    private char sign = '+';

    /**
     * Constructs an instance of FloatingNumber with given number in String format.
     * NOTE:This class does not support scientific notion.
     *
     * @param number the number used to create this instance
     * @throws NullPointerException if number is null
     * @throws NumberFormatException if number is not a valid floating point number
     */
    FloatingNumber(String number) {

        if( (number == null)
                || ( number == "" )) {

            throw new NullPointerException("Attempted to parse a number, but provided a null/empty string");
        }

        // First step is to parse the number by simply splitting on the decimal symbol
	    String[] numArray = number.split(Character.toString(currentDecimalSymbol));

	    if( numArray.length < 1 ) {
			throw new NumberFormatException("Improperly formatted number");
	    }

		if( numArray.length == 1 ) {
			// check the integral digits
			checkDigits(numArray[0], 0, true);
			integral = numArray[0];
	    }
	    else {
			checkDigits(numArray[0], 0, true);
			checkDigits(numArray[1], 0, false);
			integral = numArray[0];
			fractional = numArray[1];
	    }

    }

    /**
     * Checks whether the given number contains invalid characters, and returns the end position
     * of integral or fractional digits.
     *
     * @param number the number to check
     * @param position the begin position
     * @param isIntegral whether current digits are integral part
     * @return the end position of the integral or fractional digits.
     * @throws NumberFormatException if the given number contains invalid characters.
     */
    private int checkDigits(String number, int position, boolean isIntegral) {
       
        int numArraySize = number.length()-1-position;
        char[] numArray = new char[numArraySize];

        number.getChars(position, number.length()-1, numArray, 0);

        for(int index=0; index < numArraySize - 1; index++) {
            if( isIntegral &&
                    (numArray[index] == currentDecimalSymbol)) {
                return position+index;
            }
            else if( Character.isDigit(numArray[index]) ) {
                continue;
            }
        }
        return 0;
    }

    /**
     * Return whether this floating number is zero.
     *
     * @return whether this floating number is zero.
     */
    boolean isZero() {
        return true;
    }

    /**
     * Compare the truncation after the specified accuracy digit to the given comparison digit.
     *
     * @param accuracyDigit the accuracy digit to truncate
     * @param comparisonDigit the digit used for comparison
     * @return 1 if the truncation is greater than comparisonDigit, 0 if the truncation equals to comparisonDigit
     * or -1 if the truncation is less than comparisonDigit.
     */
    int truncationCompare(int accuracyDigit, int comparisonDigit) {
        return 0;
    }

    /**
     * Rounds such that the value of the number increases.
     * The number will not be changed if it's a rounded number.
     *
     * @param accuracyDigit the desired accuracy
     * @return the rounded number
     */
    String roundUp(int accuracyDigit) {
        return "";
    }

    /**
     * Rounds such that the value of the number decreases.
     * The number will not be changed if it's a rounded number.
     *
     * @param accuracyDigit the desired accuracy
     * @return the rounded number
     */
    String roundDown(int accuracyDigit) {
        return "";
    }

    /**
     * Rounds this number away from zero(the absolute value of the number increases).
     * The number will not be changed if it's a rounded number.
     *
     * @param accuracyDigit the desired accuracy
     * @return the rounded number
     */
    String roundAwayFromZero(int accuracyDigit) {
        return "";
    }

    /**
     * Rounds this number towards zero(the absolute value of the number decreases).
     * The number will not be changed if it's a rounded number.
     *
     * @param accuracyDigit the desired accuracy
     * @return the rounded number
     */
    String roundTowardsZero(int accuracyDigit) {
        return "";
    }

    /**
     * Returns all significant digits according to the desired accuracy.
     *
     * @param accuracyDigit the desired accuracy
     * @return the significant digits
     */
    private String getSignificantDigits(int accuracyDigit) {
        return "";
   }


    /**
     * Converts the number to normal notation.
     *
     * @param digits the significant digits of the number
     * @param accuracyDigit the desired accuracy
     * @return the number in normal notation
     */
    private String toNormalNotation(String digits, int accuracyDigit) {
        return "";
    }


    /**
     * Append some 0's to the StringBuffer.
     *
     * @param builder the StringBuffer instance to append
     * @param count the number of 0 to append
     */
    private static void appendZero(StringBuffer builder, int count) {
        return;
    }

    /**
     * Get the last digit according to the accuracy.
     * This method may be used in Banker's Rounding.
     *
     * @param accuracyDigit the desired accuracy
     * @return the last digit according to the accuracy
     */
    int getLastDigit(int accuracyDigit) {
        return 0;
    }

}
