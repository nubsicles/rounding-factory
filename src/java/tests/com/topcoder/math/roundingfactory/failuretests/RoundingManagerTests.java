/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import junit.framework.TestCase;
import com.topcoder.math.roundingfactory.ConfigurationException;
import com.topcoder.math.roundingfactory.RoundingManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;

/**
 * Failure tests for RoundingManager class.
 * 
 * @author roma
 * @version 1.0
 */
public class RoundingManagerTests extends TestCase {

    /**
     * Configuration manager instance used for testing.
     */
    private ConfigManager config;

    /**
     * Clean up environment so RoundingManager singleton will not be created
     * yet.
     * 
     * @throws Exception
     *             not expected. Will indicate that test configuration failed.
     */
    protected void setUp() throws Exception {
        super.setUp();
        // Clean configuration manager values entirely
        config = ConfigManager.getInstance();
        Iterator iter = config.getAllNamespaces();
        while (iter.hasNext()) {
            config.removeNamespace((String) iter.next());
        }
        // Force RoundingManager to re-read configuration
        clearSingletonInstance(RoundingManager.class, "instance");
    }

    /**
     * Restore environment to default settings to not cause any side effects to
     * others tests.
     * 
     * @throws Exception
     *             not expected. Will indicate that test clean-up failed.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        config = null;
        // Force ConfigManager to re-read default configuration
        clearSingletonInstance(ConfigManager.class, "defaultConfigManager");
        // As well make RoundingManager use default configuration
        clearSingletonInstance(RoundingManager.class, "instance");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * rounding_algorithms property not defined.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceNoRoundingAlgorithms() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("no_rounding_algorithms.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * rounding_algorithms property define algorithm with empty name
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceEmptyAlgorithmName() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("empty_name.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_class property not defined.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceNoClass() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("no_class.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_class property define an interface class.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceClassIsInterface() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("class_is_interface.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_class property define a non-existant class.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceClassNotExists() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("class_not_exists.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_accuracy property not defined.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceNoAccuracyDefined() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("no_accuracy.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_accuracy property define not not numeric value.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceAccuracyNotNumber() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("accuracy_not_number.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_accuracy property define negative value.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceAccuracyNegative() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("accuracy_negative.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_comparison property is not defined.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceNoComparisonDefined() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("no_comparison.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_comparison property define not not numeric value.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceComparisonNotNumber() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("comparison_not_number.xml");
    }

    /**
     * Test failure when calling RoundingManager.getInstace() method then
     * XYZ_comparison property define value outside of allowed range 0-9.
     * 
     * @throws ConfigManagerException
     *             not expected
     */
    public void testGetInstanceComparisonTen() throws ConfigManagerException {
        checkGetInstanceExceptionForFile("comparison_ten.xml");
    }

    /**
     * Check if RoundingManager.getInstance() will fail with
     * ConfigurationException for specified configuration file.
     * 
     * @param name
     *            file name to load into Configuration Manager as settings.
     * @throws ConfigManagerException
     *             in case if specified file is malformed or does not exists.
     */
    private void checkGetInstanceExceptionForFile(String name) throws ConfigManagerException {
        config.add(RoundingManager.NAMESPACE, // Namespace to load file into
                "failure" + File.separatorChar + name, // Name of file
                ConfigManager.CONFIG_XML_FORMAT); // File format
        try {
            // This is expected to fail with exception due to configuration
            // values loaded
            RoundingManager.getInstance();
            fail("ConfigurationException expected for configuration file " + name);
        } catch (ConfigurationException ce) {
            // Expected
        }
    }

    /**
     * Reset specified instance variable in singleton class.
     * 
     * @param cls
     *            class with singleton
     * @param fieldName
     *            name of field holding singleton
     * @throws IllegalArgumentException
     *             not expected
     * @throws IllegalAccessException
     *             not expected
     * @throws SecurityException
     *             not expected
     * @throws NoSuchFieldException
     *             not expected
     */
    private void clearSingletonInstance(Class cls, String fieldName) throws IllegalArgumentException,
            IllegalAccessException, SecurityException, NoSuchFieldException {
        Field field = cls.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(null, null);
    }
}