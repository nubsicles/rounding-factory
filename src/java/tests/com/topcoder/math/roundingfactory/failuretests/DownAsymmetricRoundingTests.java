/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.DownAsymmetricRounding;

/**
 * Failure tests for DownAsymmetricRounding class
 *
 * @author roma
 * @version 1.0
 */
public class DownAsymmetricRoundingTests extends AlgorithmTests {

    /**
     * Call DownAsymmetricRounding() constructor
     *
     * @return new instance of DownAsymmetricRounding
     */
    public Algorithm getAlgorithm() {
        return new DownAsymmetricRounding();
    }

    /**
     * Call DownAsymmetricRounding(int,int) constructor with arguments specified
     *
     * @param accuracyDigit
     *            first argument to DownAsymmetricRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to DownAsymmetricRounding(int,int) constructor
     * @return new instance of DownAsymmetricRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new DownAsymmetricRounding(accuracyDigit, comparisonDigit);
    }
}