/*
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.math.roundingfactory.accuracytests;

import java.io.File;
import java.util.Collection;

import com.topcoder.math.roundingfactory.RoundingManager;
import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.AlternateRounding;
import com.topcoder.math.roundingfactory.algorithms.BankersRounding;
import com.topcoder.math.roundingfactory.algorithms.NoRounding;
import com.topcoder.math.roundingfactory.algorithms.RoundingAlgorithm;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Accuracy tests for RoundingManager.
 *
 * @author alanSunny
 * @version 1.0
 */
public class RoundingManagerAccuracyTest extends TestCase {
    /** A RoundingManager to test against.*/
    private RoundingManager manager;

    /** The constant config file for accuracy test. */
    private final static String TEST_FILE = "test_files/accuracy/roundingfactory.xml";

    /**
     * Get instance of RoundingManager for testing.
     * @throw Exception to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        if (!cm.existsNamespace(RoundingManager.NAMESPACE)) {
            cm.add(RoundingManager.NAMESPACE, new File(TEST_FILE).getAbsolutePath(), ConfigManager.CONFIG_XML_FORMAT);
        }
        manager = RoundingManager.getInstance();
        manager.clearAlgorithms();
    }

    /**
     * Remove the accuracy namespace config, clear all algorithms for testing.
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        if (cm.existsNamespace(RoundingManager.NAMESPACE)) {
            cm.removeNamespace(RoundingManager.NAMESPACE);
        }
        manager.clearAlgorithms();
    }

    /**
     * Test of getInstance method.
     */
    public void testGetInstance() {
        assertNotNull("Fails to get RoundingManager instance", manager);
    }

    /**
     * Test of addAlgorithm method.
     *
     */
    public void testAddAlgorithm() {
        String testRound = "Test Round";
        RoundingAlgorithm rounding = new NoRounding();

        assertTrue(manager.addAlgorithm(testRound, rounding));
        assertFalse(manager.addAlgorithm(testRound, rounding));
        assertTrue(manager.removeAlgorithm(testRound));
    }

    /**
     * Test of getAlgorithm method.
     *
     */
    public void testGetAlgorithm() {
        String testRound = "Test Round";
        RoundingAlgorithm rounding = new NoRounding();

        manager.removeAlgorithm(testRound);
        manager.addAlgorithm(testRound, rounding);      
        assertEquals("Fails to get rounding", rounding, manager.getAlgorithm(testRound));
    }

    /**
     * Test of removeAlgorithm method.
     *
     */
    public void testRemoveAlgorithm() {
        String testRound = "Test Round";
        RoundingAlgorithm rounding = new NoRounding();

        manager.addAlgorithm(testRound, rounding);        
        assertEquals("Fails to get rounding", rounding, manager.getAlgorithm(testRound));
        manager.removeAlgorithm(testRound);
        assertNull("Fails to remove rounding", manager.getAlgorithm(testRound));
    }

    /**
     * Test of getAllAlgorithms method.
     *
     */
    public void testGetAllAlgorithms1() {
        manager.clearAlgorithms();
        RoundingAlgorithm rounding1 = new NoRounding();
        RoundingAlgorithm rounding2 = new BankersRounding();
        RoundingAlgorithm rounding3 = new AlternateRounding();
        manager.addAlgorithm("round 1", rounding1);
        manager.addAlgorithm("round 2", rounding2);
        manager.addAlgorithm("round 3", rounding3);
        Collection c = manager.getAllAlgorithms();
        assertTrue("Fails to get rounding1", c.contains(rounding1));
        assertTrue("Fails to get rounding2", c.contains(rounding2));
        assertTrue("Fails to get rounding3", c.contains(rounding3));
        assertEquals("Fails to get correct roundings", 3, c.size());
    }
}
