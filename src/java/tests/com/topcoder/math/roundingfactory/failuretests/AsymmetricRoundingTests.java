/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.AsymmetricRounding;

/**
 * Failure tests for AsymmetricRounding class
 *
 * @author roma
 * @version 1.0
 */
public class AsymmetricRoundingTests extends AlgorithmTests {

    /**
     * Call AsymmetricRounding() constructor
     *
     * @return new instance of AsymmetricRounding
     */
    public Algorithm getAlgorithm() {
        return new AsymmetricRounding();
    }

    /**
     * Call AsymmetricRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to AsymmetricRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to AsymmetricRounding(int,int) constructor
     * @return new instance of AsymmetricRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new AsymmetricRounding(accuracyDigit, comparisonDigit);
    }
}