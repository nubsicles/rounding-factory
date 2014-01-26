/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory.algorithms;

import com.topcoder.util.errorhandling.BaseRuntimeException;

/**
 * <p>An exception indicating that something has gone wrong while using any RoundingAlgorithm.</p>
 * <p>RoundingAlgorithm.round method will throw this exception</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @version 1.0
 */
public class RoundingException extends BaseRuntimeException {

    /**
     * <p>Constructs a RoundingException instance with the given message and cause.
     * The message is constrained to be non-null, so that users get a reasonable error message.</p>
     * <p>This exception will be thrown if any exception occurs while rounding.</p>
     *
     * @param message a description of what went wrong
     * @throws NullPointerException if message is null
     */
    public RoundingException(String message) {
        super(message);

        // check the argument
        if (message == null) {
            throw new NullPointerException("message should not be null");
        }
    }

    /**
     * <p>Constructs a RoundingException instance with the given message and cause.
     * The message and cause are constrained to be non-null, so that users get a reasonable
     * error message and the cause.</p>
     * <p>This exception will be thrown if any exception occurs while rounding.</p>
     *
     * @param message a description of what went wrong
     * @param cause the exception being wrapped
     * @throws NullPointerException if either argument is null
     */
    public RoundingException(String message, Throwable cause) {
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
