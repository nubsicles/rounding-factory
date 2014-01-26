/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.BankersRounding;

/**
 * Failure tests for BankersRounding class
 *
 * @author roma
 * @version 1.0
 */
public class BankersRoundingTests extends AlgorithmTests {

    /**
     * Call BankersRounding() constructor
     *
     * @return new instance of BankersRounding
     */
    public Algorithm getAlgorithm() {
        return new BankersRounding();
    }

    /**
     * Call BankersRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to BankersRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to BankersRounding(int,int) constructor
     * @return new instance of BankersRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new BankersRounding(accuracyDigit, comparisonDigit);
    }
}