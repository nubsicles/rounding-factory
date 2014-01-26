/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

import junit.framework.TestCase;
import com.topcoder.util.errorhandling.BaseRuntimeException;

/**
 * <p>Tests the RoundingException class.</p>
 *
 * @author TCSDEVELOPER
 *
 * @copyright (c) 2005, Topcoder, Inc. All Rights Reserved.
 *
 * @version 1.0
 */
public class RoundingExceptionTests extends TestCase {

    /**
     * Tests constructor.
     * RoundingException(String)
     * Null message, NullPointerException will be thrown.
     */
    public void testConstructor_String1() {
        try {
            new RoundingException(null);
            fail("testConstructor_String1 failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests constructor.
     * RoundingException(String).
     * The created instance should be BaseRuntimeException
     */
    public void testConstructor_String2() {
        assertTrue("testConstructor_String2 failed", new RoundingException("test") instanceof BaseRuntimeException);
    }

    /**
     * Tests constructor.
     * RoundingException(String, Throwable)
     * Null message, NullPointerException will be thrown.
     */
    public void testConstructor_StringThrowable1() {
        try {
            new RoundingException(null, new Exception());
            fail("testConstructor_StringThrowable1 failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests constructor.
     * RoundingException(String, Throwable)
     * Null cause, NullPointerException will be thrown.
     */
    public void testConstructor_StringThrowable2() {
        try {
            new RoundingException("test", null);
            fail("testConstructor_StringThrowable2 failed");
        } catch (NullPointerException npe) {
            // success
        }
    }

    /**
     * Tests constructor.
     * RoundingException(String, Throwable)
     */
    public void testConstructor_StringThrowable3() {
        assertTrue("testConstructor_StringThrowable3 failed",
                new RoundingException("test", new Exception()) instanceof BaseRuntimeException);
    }

}
