/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved
 */
package com.topcoder.math.roundingfactory.stresstests;

import com.topcoder.math.roundingfactory.RoundingManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Stress tests for RoundingManager class.
 * 
 * @author kr00tki
 * @version 1.0
 */
public class RoundingManagerStressTests extends TestCase {

    /** Configuration file path. */
    private static final String CONFIG_FILE = "stresstests/stress.properties";
    
    /**
     * Sets up test environment.
     * 
     * @throws Exception propagated to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        if(cm.existsNamespace(RoundingManager.NAMESPACE)) {
            cm.removeNamespace(RoundingManager.NAMESPACE);
        }
        cm.add(RoundingManager.NAMESPACE, CONFIG_FILE, ConfigManager.CONFIG_PROPERTIES_FORMAT);
    }
    
    /**
     * Clears after test.
     * 
     * @throws Exception propagated to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager.getInstance().removeNamespace(RoundingManager.NAMESPACE);
    }

    /**
     * Speed test for configuration loading.
     * 
     * @throws Exception propagated to JUnit
     */
    public void testAlgorithmsLoading() throws Exception {
        System.out.print("Loading 1000 algorithms costs:");
        long start = System.currentTimeMillis();
        RoundingManager rm = RoundingManager.getInstance();
        System.out.println((System.currentTimeMillis() - start) + " ms.");
        assertEquals("Incorrect algorithms count", 1000, rm.getAllAlgorithms().size());
    }

}
