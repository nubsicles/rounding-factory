/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.UpAsymmetricRounding;

/**
 * Failure tests for UpAsymmetricRounding class.
 *
 * @author roma
 * @version 1.0
 */
public class UpAsymmetricRoundingTests extends AlgorithmTests {

    /**
     * Call UpAsymmetricRounding() constructor.
     *
     * @return new instance of UpAsymmetricRounding
     */
    public Algorithm getAlgorithm() {
        return new UpAsymmetricRounding();
    }

    /**
     * Call UpAsymmetricRounding(int,int) constructor with arguments specified.
     *
     * @param accuracyDigit
     *            first argument to UpAsymmetricRounding(int,int) constructor
     * @param comparisonDigit
     *            second argument to UpAsymmetricRounding(int,int) constructor
     * @return new instance of UpAsymmetricRounding
     */
    public Algorithm getAlgorithm(int accuracyDigit, int comparisonDigit) {
        return new UpAsymmetricRounding(accuracyDigit, comparisonDigit);
    }
}