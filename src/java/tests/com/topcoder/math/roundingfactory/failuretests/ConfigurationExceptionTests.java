/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import junit.framework.TestCase;
import com.topcoder.math.roundingfactory.ConfigurationException;

/**
 * Failure tests for ConfigurationException class
 *
 * @author roma
 * @version 1.0
 */
public class ConfigurationExceptionTests extends TestCase {

    /**
     * Test failure when creating new ConfigurationException(String message)
     * with a null message.
     */
    public void testConfigurationExceptionStringMessageNull() {
        try {
            new ConfigurationException(null);
            fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            // Expected
        }
    }

    /**
     * Test failure when creating new ConfigurationException(String message, Throwable cause)
     * with a null message.
     */
    public void testConfigurationExceptionStringThrowableMessageNull() {
        try {
            new ConfigurationException(null, new Throwable());
            fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            // Expected
        }
    }

    /**
     * Test failure when creating new ConfigurationException(String message, Throwable cause)
     * with a null cause.
     */
    public void testConfigurationExceptionStringThrowableCauseNull() {
        try {
            new ConfigurationException("message", null);
            fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            // Expected
        }
    }
}