/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.NoRounding;

/**
 * Failure tests for NoRounding class
 *
 * @author roma
 * @version 1.0
 */
public class RandomRoundingTests extends AlgorithmTests {

    /**
     * Call NoRounding() constructor
     *
     * @return new instance of NoRounding
     */
    public Algorithm getAlgorithm() {
        return new NoRounding();
    }

    /**
     * Call NoRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to NoRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to NoRounding(int,int) constructor
     * @return new instance of NoRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new NoRounding(accuracyDigit, comparisonDigit);
    }
}