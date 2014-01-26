/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>An exception which indicates that something has gone wrong in the configuration step inside
 * the constructor of RoundingManager.</p>
 * <p>This exception will be thrown if any errors occur in reading config file.</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public class ConfigurationException extends BaseException {

    /**
     * <p>Constructs a ConfigurationException instance with the given message and cause.
     * The message is constrained to be non-null, so that users get a reasonable error message.</p>
     * <p>This exception will be thrown if any errors occur in reading config file.</p>
     *
     * @param message a description of what went wrong
     * @throws NullPointerException if message is null
     */
    public ConfigurationException(String message) {
        super(message);

        // check the argument
        if (message == null) {
            throw new NullPointerException("message should not be null");
        }
    }

    /**
     * <p>Constructs a ConfigurationException instance with the given message and cause.
     * The message and cause are constrained to be non-null, so that users get a reasonable
     * error message and the cause.</p>
     * <p>This exception will be thrown if any errors occur in reading config file.</p>
     *
     * @param message a description of what went wrong
     * @param cause the exception being wrapped
     * @throws NullPointerException if either argument is null
     */
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);

        // check the arguments
        if (message == null) {
            throw new NullPointerException("message should not be null");
        }
        if (cause == null) {
            throw new NullPointerException("cause should not be null");
        }

    }
}
