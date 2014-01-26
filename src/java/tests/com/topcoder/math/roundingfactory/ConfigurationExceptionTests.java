/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory;

import junit.framework.TestCase;
import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>Tests the ConfigurationException class.</p>
 *
 * @author TCSDEVELOPER
 *
 * @copyright (c) 2005, Topcoder, Inc. All Rights Reserved.
 *
 * @version 1.0
 */
public class ConfigurationExceptionTests extends TestCase {

    /**
     * Tests constructor.
     * ConfigurationException(String)
     * Null message, NullPointerException will be thrown.
     */
    public void testConstructor_String1() {
        try {
            new ConfigurationException(null);
            fail("testConstructor_String1 failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests constructor.
     * ConfigurationException(String)
     */
    public void testConstructor_String2() {
        assertTrue("testConstructor_String2 failed", new ConfigurationException("test") instanceof BaseException);
    }

    /**
     * Tests constructor.
     * ConfigurationException(String, Throwable)
     * Null message, NullPointerException will be thrown.
     */
    public void testConstructor_StringThrowable1() {
        try {
            new ConfigurationException(null, new Exception());
            fail("testConstructor_StringThrowable1 failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests constructor.
     * ConfigurationException(String, Throwable)
     * Null cause, NullPointerException will be thrown.
     */
    public void testConstructor_StringThrowable2() {
        try {
            new ConfigurationException("test", null);
            fail("testConstructor_StringThrowable2 failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests constructor.
     * ConfigurationException(String, Throwable)
     */
    public void testConstructor_StringThrowable3() {
        assertTrue("testConstructor_StringThrowable3 failed",
                new ConfigurationException("test", new Exception()) instanceof BaseException);
    }

}
