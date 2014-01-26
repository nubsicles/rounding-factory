/**
 *
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.math.roundingfactory.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * Returns test suite with all Failure test cases
     *
     * @return test suite with all Failure test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // Exceptions
        suite.addTestSuite(ConfigurationExceptionTests.class);
        suite.addTestSuite(RoundingExceptionTests.class);

        // Algorithms
        suite.addTestSuite(AlternateRoundingTests.class);
        suite.addTestSuite(AsymmetricRoundingTests.class);
        suite.addTestSuite(BankersRoundingTests.class);
        suite.addTestSuite(DownAsymmetricRoundingTests.class);
        suite.addTestSuite(DownSymmetricRoundingTests.class);
        suite.addTestSuite(NoRoundingTests.class);
        suite.addTestSuite(RandomRoundingTests.class);
        suite.addTestSuite(RoundingAlgorithmTests.class);
        suite.addTestSuite(SymmetricRoundingTests.class);
        suite.addTestSuite(UpAsymmetricRoundingTests.class);
        suite.addTestSuite(UpSymmetricRoundingTests.class);

        // Rounding manager
        suite.addTestSuite(RoundingManagerTests.class);

        return suite;
    }

}
