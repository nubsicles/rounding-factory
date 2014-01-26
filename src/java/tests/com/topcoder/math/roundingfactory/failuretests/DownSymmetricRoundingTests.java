/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.DownSymmetricRounding;

/**
 * Failure tests for DownSymmetricRounding class
 *
 * @author roma
 * @version 1.0
 */
public class DownSymmetricRoundingTests extends AlgorithmTests {

    /**
     * Call DownSymmetricRounding() constructor
     *
     * @return new instance of DownSymmetricRounding
     */
    public Algorithm getAlgorithm() {
        return new DownSymmetricRounding();
    }

    /**
     * Call DownSymmetricRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to DownSymmetricRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to DownSymmetricRounding(int,int) constructor
     * @return new instance of DownSymmetricRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new DownSymmetricRounding(accuracyDigit, comparisonDigit);
    }
}