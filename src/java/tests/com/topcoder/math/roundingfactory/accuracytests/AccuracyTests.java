/**
 *
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved
 */
package com.topcoder.math.roundingfactory.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(AlternateRoundingAccuracyTest.class);
        suite.addTestSuite(AsymmetricRoundingAccuracyTest.class);
        suite.addTestSuite(AlternateRoundingAccuracyTest.class);
        suite.addTestSuite(BankersRoundingAccuracyTest.class);
        suite.addTestSuite(DownAsymmetricRoundingAccuracyTest.class);
        suite.addTestSuite(DownSymmetricRoundingAccuracyTest.class);
        suite.addTestSuite(NoRoundingAccuracyTest.class);
        suite.addTestSuite(RandomRoundingAccuracyTest.class);
        suite.addTestSuite(RoundingManagerAccuracyTest.class);
        suite.addTestSuite(SymmetricRoundingAccuracyTest.class);
        suite.addTestSuite(UpAsymmetricRoundingAccuracyTest.class);
        suite.addTestSuite(UpSymmetricRoundingAccuracyTest.class);
        return suite;
    }
}
