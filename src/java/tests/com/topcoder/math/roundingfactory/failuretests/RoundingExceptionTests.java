/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.math.roundingfactory.failuretests;

import junit.framework.TestCase;
import com.topcoder.math.roundingfactory.algorithms.RoundingException;

/**
 * Failure tests for RoundingException class
 *
 * @author roma
 * @version 1.0
 */
public class RoundingExceptionTests extends TestCase {

    /**
     * Test failure when creating new RoundingException(String message)
     * with a null message.
     */
    public void testConfigurationExceptionStringMessageNull() {
        try {
            new RoundingException(null);
            fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            // Expected
        }
    }

    /**
     * Test failure when creating new RoundingException(String message, Throwable cause)
     * with a null message.
     */
    public void testConfigurationExceptionStringThrowableMessageNull() {
        try {
            new RoundingException(null, new Throwable());
            fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            // Expected
        }
    }

    /**
     * Test failure when creating new RoundingException(String message, Throwable cause)
     * with a null cause.
     */
    public void testConfigurationExceptionStringThrowableCauseNull() {
        try {
            new RoundingException("message", null);
            fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            // Expected
        }
    }
}