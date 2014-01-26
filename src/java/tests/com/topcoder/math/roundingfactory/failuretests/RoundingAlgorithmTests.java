/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.RoundingAlgorithm;

/**
 * Failure tests for RoundingAlgorithm class.
 * 
 * @author roma
 * @version 1.0
 */
public class RoundingAlgorithmTests extends AlgorithmTests {

    /**
     * Call RoundingAlgorithm() constructor
     * 
     * @return new instance of RoundingAlgorithm
     */
    public Algorithm getAlgorithm() {
        return new RoundingAlgorithmImpl();
    }

    /**
     * Call RoundingAlgorithm(int,int) constructor with arguments specified
     * 
     * @param accuracyDigit
     *            first argument to RoundingAlgorithm(int,int) constructor
     * @param comparisonDigit
     *            second argument to RoundingAlgorithm(int,int) constructor
     * @return new instance of RoundingAlgorithm
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new RoundingAlgorithmImpl(accuracyDigit, comparisonDigit);
    }

    /**
     * Simple implementation.
     * 
     * @author roma
     * @version 1.0
     * @copyright (C) 2005 TopCoder, Inc. All rights reserved
     */
    class RoundingAlgorithmImpl extends RoundingAlgorithm {

        /**
         * Constructor.
         */
        RoundingAlgorithmImpl() {
        }

        /**
         * Constructor.
         * 
         * @param accuracyDigit
         *            the desired accuracy
         * @param comparisonDigit
         *            the comparison digit
         * 
         * @throws IllegalArgumentException
         *             if comparisonDigit is less than 1 or greater than 9, or
         *             if the accuracyDigit is negative.
         */
        RoundingAlgorithmImpl(int accuracyDigit, int comparisonDigit) {
            super(accuracyDigit, comparisonDigit);
        }

        /**
         * Test method that will always throw NullPointerException or
         * NumberFormatException
         * 
         * @see RoundingAlgorithm#round(String,int,int)
         * @param number
         *            number to round
         * @param accuracyDigit
         *            the desired accuracy
         * @param comparisonDigit
         *            the comparison digit
         * @return never return anything
         * @throws NullPointerException
         *             if number is null
         * @throws IllegalArgumentException
         *             if comparisonDigit is less than 1 or greater than 9, or
         *             if the accuracyDigit is negative.
         * @throws NumberFormatException
         *             if number is not null and accuracyDigit, comparisonDigit
         *             are valid
         */
        public String round(String number, int accuracyDigit, int comparisonDigit) {
            if (number == null) {
                throw new NullPointerException("number is null");
            }
            // Check if arguments are valid
            new RoundingAlgorithmImpl(accuracyDigit, comparisonDigit);
            
            throw new NumberFormatException("This class can be used for failure tests only");
        }
    }
}