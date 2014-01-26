/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.math.roundingfactory.algorithms.NoRounding;
import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import java.lang.reflect.Field;


import junit.framework.TestCase;


/**
 * <p>Tests the RoundingManager class.</p>
 *
 * @author TCSDEVELOPER
 *
 * @copyright (c) 2005, Topcoder, Inc. All Rights Reserved.
 *
 * @version 1.0
 */
public class RoundingManagerTests extends TestCase {

    /**
     * A config file for the test.
     */
    private static final String CUSTOM_CONFIG_FILE = "custom.xml";

    /**
     * A bad config file without the hash_algorithms property.
     */
    private static final String BAD_CONFIG_FILE1 = "bad1.xml";

    /**
     * A bad config file missing a class property.
     */
    private static final String BAD_CONFIG_FILE2 = "bad2.xml";

    /**
     * A bad config file containing an invalid class property.
     */
    private static final String BAD_CONFIG_FILE3 = "bad3.xml";

    /**
     * A bad config file missing an accuracy property.
     */
    private static final String BAD_CONFIG_FILE4 = "bad4.xml";

    /**
     * A bad config file containing an invalid accuracy property.
     */
    private static final String BAD_CONFIG_FILE5 = "bad5.xml";

    /**
     * A bad config file containing an non-integer accuracy property.
     */
    private static final String BAD_CONFIG_FILE6 = "bad6.xml";

    /**
     * A bad config file missing an comparison property.
     */
    private static final String BAD_CONFIG_FILE7 = "bad7.xml";

    /**
     * A bad config file containing an invalid comparison property.
     */
    private static final String BAD_CONFIG_FILE8 = "bad8.xml";

    /**
     * A bad config file containing an non-integer comparison property.
     */
    private static final String BAD_CONFIG_FILE9 = "bad9.xml";

    /**
     * A empty config file.
     */
    private static final String BAD_CONFIG_FILE10 = "bad10.xml";

    /**
     * The ConfigManager instance for test.
     */
    private ConfigManager configManager = ConfigManager.getInstance();

    /**
     * A RoundingManager instance for test.
     */
    private RoundingManager manager = null;

    /**
     * A Algorithm instance for test.
     */
    private Algorithm rounding = new NoRounding();

    /**
     * Create a RoundingManager instance.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {

        // set up the ConfigManager environment
        removeNamespace();
        configManager.add(CUSTOM_CONFIG_FILE);

        reset();
        manager = RoundingManager.getInstance();
    }

    /**
     * Remove the namespace to make sure other tests will not be effected.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        removeNamespace();
    }

    /**
     * Tests getInstance method. The singleton RoundingManager instance should be returned .
     *
     * @throws Exception to JUnit
     */
    public void testGetInstance() throws Exception {
        assertNotNull("testGetInstance failed", RoundingManager.getInstance());
    }

    /**
     * Tests loading configuration.
     * Load a bad config file without hash_algorithms property
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration1() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE1);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file without class property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration2() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE2);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file with invalid class property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration3() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE3);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file without accuracy property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration4() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE4);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file with invalid accuracy property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration5() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE5);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file with non-integer accuracy property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration6() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE6);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file without comparison property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration7() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE7);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file with invalid comparison property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration8() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE5);
    }

    /**
     * Tests loading configuration.
     * Load a bad config file with non-integer comparison property.
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration9() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE9);
    }

    /**
     * Tests loading configuration.
     * The namespace does not exist, ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void testLoadConfiguration10() throws Exception {
        loadConfigurationTest(BAD_CONFIG_FILE10);
    }

    /**
     * Load the specified bad config file. ConfigurationException should be thrown.
     *
     * @param filename the config file to load
     * @throws Exception to JUnit
     */
    private void loadConfigurationTest(String filename) throws Exception {

        removeNamespace();
        configManager.add(filename);

        try {
            reset();
            RoundingManager.getInstance();
            fail("ConfigurationException should be thrown");
        } catch (ConfigurationException ce) {
            // success
        }
    }

    /**
     * Removes the namespace.
     *
     * @throws Exception to JUnit
     */
    private void removeNamespace() throws Exception {
        if (configManager.existsNamespace(RoundingManager.NAMESPACE)) {
            configManager.removeNamespace(RoundingManager.NAMESPACE);
        }
    }

    /**
     * Tests addAlgorithm method.
     * Adds a new algorithm, true should be returned.
     */
    public void testAddAlgorithm_True() {
        // a new algorithm, true should be returned
        assertTrue("testAddAlgorithm_True failed", manager.addAlgorithm("test", rounding));
        // check whether the algorithm is added successfully
        assertNotNull("testAddAlgorithm_True failed", manager.getAlgorithm("test"));
    }

    /**
     * Tests addAlgorithm method.
     * Adds an existing algorithm, false should be returned.
     */
    public void testAddAlgorithm_False() {
        manager.addAlgorithm("test", rounding);
        // this algorithm already exists, false should be returned.
        assertFalse("testAddAlgorithm_False failed", manager.addAlgorithm("test", rounding));
    }

    /**
     * Tests addAlgorithm method.
     * Null name, NullPointerException should be thrown.
     */
    public void testAddAlgorithm_NullName() {
        try {
            manager.addAlgorithm(null, rounding);
            fail("testAddAlgorithm_NullName failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests addAlgorithm method.
     * Empty name, IllegalArgumentException should be thrown.
     */
    public void testAddAlgorithm_EmptyName() {
        try {
            manager.addAlgorithm(" ", rounding);
            fail("testAddAlgorithm_EmptyName failed");
        } catch (IllegalArgumentException iae) {
            // success
        }
    }

    /**
     * Tests addAlgorithm method.
     * Null algorithm, NullPointerException should be thrown.
     */
    public void testAddAlgorithm_NullAlgorithm() {
        try {
            manager.addAlgorithm("test", null);
            fail("testAddAlgorithm_NullAlgorithme failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests removeAlgorithm method.
     * Removes an existing algorithm, true should be returned.
     */
    public void testRemoveAlgorithm_True() {
        // this algorithm exists, true should be returned.
        assertTrue("testRemoveAlgorithm_True failed", manager.removeAlgorithm("no"));
        // check whether the algorithm is removed successfully
        assertNull("testRemoveAlgorithm_True failed", manager.getAlgorithm("no"));
    }

    /**
     * Tests removeAlgorithm method.
     * Removing a non-existing algorithm, false should be returned.
     */
    public void testRemoveAlgorithm_False() {
        // this algorithm does not exist, false should be returned.
        assertFalse("testRemoveAlgorithm_False failed", manager.removeAlgorithm("test"));
    }

    /**
     * Tests removeAlgorithm method.
     * Null name, NullPointerException should be thrown.
     */
    public void testRemoveAlgorithm_NullName() {
        try {
            manager.removeAlgorithm(null);
            fail("testRemoveAlgorithm_NullName failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests removeAlgorithm method.
     * Empty name, IllegalArgumentException should be thrown.
     */
    public void testRemoveAlgorithm_EmptyName() {
        try {
            manager.removeAlgorithm("  ");
            fail("testRemoveAlgorithm_EmptyName failed");
        } catch (IllegalArgumentException iae) {
            // success
        }
    }

    /**
     * Tests clearAlgorithms method. All algorithms should be removed.
     */
    public void testClearAlgorithms() {
        manager.clearAlgorithms();
        // all algorithms should be removed
        assertEquals("testClearAlgorithms failed", 0, manager.getAllAlgorithms().size());
    }

    /**
     * Tests getAlgorithm method.
     * Getting an existing algorithm, the algorithm should be returned.
     */
    public void testGetAlgorithm_Found() {
        // this algorithm exists
        assertNotNull("testGetAlgorithm_Found failed", manager.getAlgorithm("no"));
    }

    /**
     * Tests getAlgorithm method.
     * Getting an non-existing algorithm, null should be returned.
     */
    public void testGetAlgorithm_NotFound() {
        // this algorithm does not exist, null should be returned.
        assertNull("testGetAlgorithm_NotFound failed", manager.getAlgorithm("test"));
    }

    /**
     * Tests getAlgorithm method.
     * Null name, NullPointerException should be thrown.
     */
    public void testGetAlgorithm_NullName() {
        try {
            manager.getAlgorithm(null);
            fail("testGetAlgorithm_NullName failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests getAlgorithm method.
     * Empty name, IllegalArgumentException should be thrown.
     */
    public void testGetAlgorithm_EmptyName() {
        try {
            manager.getAlgorithm(" ");
            fail("testGetAlgorithm_EmptyName failed");
        } catch (IllegalArgumentException npe) {
            // success
        }
    }

    /**
     * Tests getAllAlgorithms method.
     *
     * All algorithms should be returned.
     */
    public void testGetAllAlgorithm1() {

        // 2 algorithms should be returned.
        assertEquals("testGetAllAlgorithm1 failed", 2, manager.getAllAlgorithms().size());
    }

    /**
     * Tests getAllAlgorithms method.
     *
     * All algorithms should be returned.
     */
    public void testGetAllAlgorithm2() {

        manager.clearAlgorithms();

        // 0 algorithms should be returned.
        assertEquals("testGetAllAlgorithm2 failed", 0, manager.getAllAlgorithms().size());
    }

    /**
     * Reset RoundingManager.instance to null.
     *
     * @throws exception to JUnit;
     */
    private void reset() throws Exception {
        Field instance = RoundingManager.class.getDeclaredField("instance");

        instance.setAccessible(true);

        instance.set(null, null);
    }
}