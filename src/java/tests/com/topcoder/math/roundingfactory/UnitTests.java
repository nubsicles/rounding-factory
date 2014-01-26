/**
 *
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved
 */
package com.topcoder.math.roundingfactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.math.roundingfactory.algorithms.RoundingExceptionTests;
import com.topcoder.math.roundingfactory.algorithms.NoRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.RandomRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.AlternateRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.BankersRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.SymmetricRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.AsymmetricRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.UpAsymmetricRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.DownAsymmetricRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.UpSymmetricRoundingTests;
import com.topcoder.math.roundingfactory.algorithms.DownSymmetricRoundingTests;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {


    /**
     * <p>Unit tests for Rounding Factory</p>
     *
     * @return the Test suite.
     */
    public static Test suite() {

        final TestSuite suite = new TestSuite();


        suite.addTestSuite(RoundingManagerTests.class);
        suite.addTestSuite(ConfigurationExceptionTests.class);

        suite.addTestSuite(RoundingExceptionTests.class);
        suite.addTestSuite(NoRoundingTests.class);
        suite.addTestSuite(RandomRoundingTests.class);
        suite.addTestSuite(AlternateRoundingTests.class);
        suite.addTestSuite(BankersRoundingTests.class);
        suite.addTestSuite(SymmetricRoundingTests.class);
        suite.addTestSuite(AsymmetricRoundingTests.class);
        suite.addTestSuite(UpAsymmetricRoundingTests.class);
        suite.addTestSuite(DownAsymmetricRoundingTests.class);
        suite.addTestSuite(UpSymmetricRoundingTests.class);
        suite.addTestSuite(DownSymmetricRoundingTests.class);

        suite.addTestSuite(Demo.class);

        return suite;
    }

}
