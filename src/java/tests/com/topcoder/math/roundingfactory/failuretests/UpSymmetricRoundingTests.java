/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.UpSymmetricRounding;

/**
 * Failure tests for UpSymmetricRounding class
 *
 * @author roma
 * @version 1.0
 */
public class UpSymmetricRoundingTests extends AlgorithmTests {

    /**
     * Call UpSymmetricRounding() constructor
     *
     * @return new instance of UpSymmetricRounding
     */
    public Algorithm getAlgorithm() {
        return new UpSymmetricRounding();
    }

    /**
     * Call UpSymmetricRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to UpSymmetricRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to UpSymmetricRounding(int,int) constructor
     * @return new instance of UpSymmetricRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new UpSymmetricRounding(accuracyDigit, comparisonDigit);
    }
}