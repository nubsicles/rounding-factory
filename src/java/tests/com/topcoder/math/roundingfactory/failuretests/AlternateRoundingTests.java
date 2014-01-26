/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.AlternateRounding;

/**
 * Failure tests for AlternateRounding class
 *
 * @author roma
 * @version 1.0
 */
public class AlternateRoundingTests extends AlgorithmTests {

    /**
     * Call AlternateRounding() constructor
     *
     * @return new instance of AlternateRounding
     */
    public Algorithm getAlgorithm() {
        return new AlternateRounding();
    }

    /**
     * Call AlternateRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to AlternateRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to AlternateRounding(int,int) constructor
     * @return new instance of AlternateRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new AlternateRounding(accuracyDigit, comparisonDigit);
    }
}