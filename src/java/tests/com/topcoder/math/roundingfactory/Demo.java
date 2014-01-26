/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.RoundingAlgorithm;
import com.topcoder.math.roundingfactory.algorithms.NoRounding;
import com.topcoder.math.roundingfactory.algorithms.RandomRounding;
import com.topcoder.math.roundingfactory.algorithms.AlternateRounding;
import com.topcoder.math.roundingfactory.algorithms.BankersRounding;
import com.topcoder.math.roundingfactory.algorithms.SymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.AsymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.UpAsymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.DownAsymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.UpSymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.DownSymmetricRounding;

import junit.framework.TestCase;


/**
 * <p>Component demonstration for Rounding Factory.</p>
 * <p>This demo is separated into three parts.</p>
 * <p>RoundingManagerDemo shows the usage of RoundingManager class.
 * RoundingAlgorithmDemo shows the usage of RoundingAlgorithm class.
 * AlgorithmBehaviorsDemo shows the behavior of different rounding algorithms.
 *
 *
 * @author TCSDEVELOPER
 *
 * @copyright (c) 2005, Topcoder, Inc. All Rights Reserved.
 *
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * Demonstration for RoundingManager.
     * This demo shows the usage of RoundingManager class.
     *
     * @throws Exception to JUnit
     */
    public void testRoundingManagerDemo() throws Exception {
        // create some rounding algorithms
        Algorithm noRounding = new NoRounding();
        Algorithm bankersRounding = new BankersRounding();

        // get the RoundingManager instance
        RoundingManager manager = RoundingManager.getInstance();

        // clear all algorithms before test
        manager.clearAlgorithms();

        // add these algorithms to the mananger
        assertTrue("should be added", manager.addAlgorithm("no rounding", noRounding));
        assertTrue("should be added", manager.addAlgorithm("banker's rounding", bankersRounding));

        // if the algorithm already exists, it can't be added again
        assertFalse("should not be added", manager.addAlgorithm("banker's rounding", bankersRounding));

        // get a algorithm using it's name
        assertEquals("bankersRounding should not be returned",
                bankersRounding, manager.getAlgorithm("banker's rounding"));

        // null will be returned if we get a non-existing algorithm
        assertNull("null should be returned", manager.getAlgorithm("another rounding"));

        // remove a algorithm using it's name
        assertTrue("should be removed", manager.removeAlgorithm("no rounding"));
        assertNull("null should be return", manager.getAlgorithm("no rounding"));

        // flase will be returned if we removed a non-existing algorithm
        assertFalse("should be removed", manager.removeAlgorithm("no rounding"));

        // clear all algorithms
        manager.clearAlgorithms();

        // all algorithms should be removed
        assertNull("null should be return", manager.getAlgorithm("banker's rounding"));
    }

    /**
     * Demonstration for using the RoundingAlgorithm.
     */
    public void testRoundingAlgorithmDemo() {
        // create a RoundingAlgorithm instance using default accuracy and comparison digit
        RoundingAlgorithm algorithm = new SymmetricRounding();

        // get the accuracy and comparison digit
        assertEquals("default value should be 2", 2, algorithm.getAccuracyDigit());
        assertEquals("default value should be 5", 5, algorithm.getComparisonDigit());

        // create another RoundingAlgorithm instance using specified accuracy and comparison digit
        algorithm = new AsymmetricRounding(0, 5);

        // get the accuracy and comparison digit
        assertEquals("default value should be 0", 0, algorithm.getAccuracyDigit());
        assertEquals("default value should be 5", 5, algorithm.getComparisonDigit());

        // round a double number using default accuracy and comparison digit
        assertEquals("rounded number should be 2", "2", algorithm.round(1.5));

        // round a double number using specified accuracy and comparison digit
        assertEquals("rounded number should be 10.00", 10.00, algorithm.roundDouble(9.999, 2, 9), 1e-10);

        // round a string number using default accuracy and comparison digit
        assertEquals("rounded number should be -1", "-1", algorithm.round("-1.5"));

        // round a string number using specified accuracy and comparison digit
        assertEquals("rounded number should be 9.99", "9.99", algorithm.round("9.99", 2, 9));
    }

    /**
     * Demonstration for the behavior of different rounding algorithms.
     */
    public void testAlgorithmBehaviorsDemo() {

        /////////////////////////////////////////////////////
        // create a NoRounding instance
        RoundingAlgorithm algorithm = new NoRounding();

        // the number should not be rounded
        assertEquals("should not be rounded", "00123.45600", algorithm.round("00123.45600", 3, 5));
        assertEquals("should not be rounded", "-00123.45600", algorithm.round("-00123.45600", 3, 5));
        assertEquals("should not be rounded", "0", algorithm.round("-000.00", 3, 5));


        /////////////////////////////////////////////////////
        // create an UpAsymmetricRounding instance
        algorithm = new UpAsymmetricRounding();

        // all numbers increase
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.400", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.450", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.451", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.400", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.450", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.451", 1, 5));

        /////////////////////////////////////////////////////
        // create an UpSymmetricRounding instance
        algorithm = new UpSymmetricRounding();

        // all numbers move away from zero
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.400", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.450", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.451", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.400", 1, 5));
        assertEquals("value should be -1.5", "-1.5", algorithm.round("-1.450", 1, 5));
        assertEquals("value should be -1.5", "-1.5", algorithm.round("-1.451", 1, 5));

        /////////////////////////////////////////////////////
        // create a DownSymmetricRounding instance
        algorithm = new DownSymmetricRounding();

        // all numbers move towards zero
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.400", 1, 5));
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.450", 1, 5));
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.451", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.400", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.450", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.451", 1, 5));

        /////////////////////////////////////////////////////
        // create a DownAsymmetricRounding instance
        algorithm = new DownAsymmetricRounding();

        // all numbers decrease
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.400", 1, 5));
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.450", 1, 5));
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.451", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.400", 1, 5));
        assertEquals("value should be -1.5", "-1.5", algorithm.round("-1.450", 1, 5));
        assertEquals("value should be -1.5", "-1.5", algorithm.round("-1.451", 1, 5));

        /////////////////////////////////////////////////////
        // create a SymmetricRounding instance
        algorithm = new SymmetricRounding();

        // round away from 0 if comparison digit equals to truncation
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.400", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.450", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.451", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.400", 1, 5));
        assertEquals("value should be -1.5", "-1.5", algorithm.round("-1.450", 1, 5));
        assertEquals("value should be -1.5", "-1.5", algorithm.round("-1.451", 1, 5));

        /////////////////////////////////////////////////////
        // create an AsymmetricRounding instance
        algorithm = new AsymmetricRounding();

        // round up if comparison digit equals to truncation
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.400", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.450", 1, 5));
        assertEquals("value should be 1.5", "1.5", algorithm.round("1.451", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.400", 1, 5));
        assertEquals("value should be -1.4", "-1.4", algorithm.round("-1.450", 1, 5));
        assertEquals("value should be -1.5", "-1.5", algorithm.round("-1.451", 1, 5));

        /////////////////////////////////////////////////////
        // create a BankersRounding instance
        algorithm = new BankersRounding();

        // round to nearest even number
        assertEquals("value should be 1.0", "1.0", algorithm.round("1.05", 1, 5));
        assertEquals("value should be 1.2", "1.2", algorithm.round("1.15", 1, 5));
        assertEquals("value should be 1.4", "1.4", algorithm.round("1.45", 1, 5));
        assertEquals("value should be -1.6", "-1.6", algorithm.round("-1.55", 1, 5));
        assertEquals("value should be -1.8", "-1.8", algorithm.round("-1.85", 1, 5));
        assertEquals("value should be -2.0", "-2.0", algorithm.round("-1.95", 1, 5));


        /////////////////////////////////////////////////////
        // create a RandomRounding instance
        algorithm = new RandomRounding();

        // round randomly
        String result =  algorithm.round("1.450", 1, 5);
        assertTrue("value should be 1.4 or 1.5", "1.4".equals(result) || "1.5".equals(result));
        result =  algorithm.round("-1.450", 1, 5);
        assertTrue("value should be -1.4 or -1.5", "-1.4".equals(result) || "-1.5".equals(result));


        /////////////////////////////////////////////////////
        // create a AlternateRounding instance
        algorithm = new AlternateRounding();

        // round alternately
        // first time, round up
        assertEquals("result should be 1.5", "1.5", algorithm.round("1.450", 1, 5));
        // second time, round down
        assertEquals("result should be 1.4", "1.4", algorithm.round("1.450", 1, 5));

    }

}
