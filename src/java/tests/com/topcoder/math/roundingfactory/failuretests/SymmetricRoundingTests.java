/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.SymmetricRounding;

/**
 * Failure tests for SymmetricRounding class.
 *
 * @author roma
 * @version 1.0
 */
public class SymmetricRoundingTests extends AlgorithmTests {

    /**
     * Call SymmetricRounding() constructor
     *
     * @return new instance of SymmetricRounding
     */
    public Algorithm getAlgorithm() {
        return new SymmetricRounding();
    }

    /**
     * Call SymmetricRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to SymmetricRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to SymmetricRounding(int,int) constructor
     * @return new instance of SymmetricRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new SymmetricRounding(accuracyDigit, comparisonDigit);
    }
}