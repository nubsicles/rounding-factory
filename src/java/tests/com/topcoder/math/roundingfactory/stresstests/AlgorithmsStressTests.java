/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved
 */
package com.topcoder.math.roundingfactory.stresstests;

import java.util.Random;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;
import com.topcoder.math.roundingfactory.algorithms.AlternateRounding;
import com.topcoder.math.roundingfactory.algorithms.AsymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.BankersRounding;
import com.topcoder.math.roundingfactory.algorithms.DownAsymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.DownSymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.RandomRounding;
import com.topcoder.math.roundingfactory.algorithms.SymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.UpAsymmetricRounding;
import com.topcoder.math.roundingfactory.algorithms.UpSymmetricRounding;

import junit.framework.TestCase;

/**
 * Stress test for rounding algorithms from <tt>com.topcoder.math.roundingfactory.algorithms</tt> package.
 * 
 * @author kr00tki
 * @version 1.0
 */
public class AlgorithmsStressTests extends TestCase {

    /** Main loop count. */
    private final static int ROUNDING_COUNT = 100000;
    
    /** Number of decimal places in test number. */
    private final static int DECIMAL_COUNT = 1000;
    
    /** Number of integer digits before decimal. */
    private final static int INT_COUNT = 10;
    
    /** Test number. */
    private static String number = null;
    
    /** Test negative number. */
    private static String negativeNumber = null;
    
    /** Generate test number */
    static {
        // allocate some place
        StringBuffer buffer = new StringBuffer(DECIMAL_COUNT + INT_COUNT + 1);
        Random rand = new Random();
        
        // generate random number
        for (int i = 0; i < INT_COUNT; i++) {
            buffer.append(rand.nextInt(10));
        }
        buffer.append('.');
        for (int i = 0; i < DECIMAL_COUNT; i++) {
            buffer.append(rand.nextInt(10));
        }
        
        // convert ot string and negative
        number = buffer.toString();
        negativeNumber = '-' + number;
    }
    
    /**
     * Seped test for <tt>UpSymmetricRounding</tt> algorithm.
     */
    public void testUpSymmetricRounding() {
        algorithmTest(new UpSymmetricRounding());
    }
    
    /**
     * Speed test for <tt>UpAsymmetricRounding</tt> algorithm.
     */
    public void testUpAsymmetricRounding() {
        algorithmTest(new UpAsymmetricRounding());        
    }
    
    /**
     * Speed test for <tt>AlternateRounding</tt> algorithm.
     */
    public void testAlternateRounding() {
        algorithmTest(new AlternateRounding());
    }
    
    /**
     * Speed test for <tt>SymmetricRounding</tt> algorithm.
     */
    public void testSymmetricRounding() {
        algorithmTest(new SymmetricRounding());
    }
    
    /**
     * Speed test for <tt>DownSymmetricRounding</tt> algorithm.
     */
    public void testDownSymmetricRounding() {
        algorithmTest(new DownSymmetricRounding());
    }
    
    /**
     * Speed test for <tt>DownAsymmetricRounding</tt> algorithm.
     */
    public void testDownAsymmetricRounding() {
        algorithmTest(new DownAsymmetricRounding());        
    }
    
    /**
     * Speed test for <tt>BankersRounding</tt> algorithm.
     */
    public void testBankersRounding() {
        algorithmTest(new BankersRounding());
    }
    
    /**
     * Speed test for <tt>AsymmetricRounding</tt> algorithm.
     */
    public void testAsymmetricRounding() {
        algorithmTest(new AsymmetricRounding());
    }
    
    /**
     * Speed test for <tt>RandomRounding</tt> algorithm.
     */
    public void testRandomRounding() {
        algorithmTest(new RandomRounding());
    }
    
    /**
     * Rounds test numbers with given algorithm ROUNDING_COUNT times.
     * 
     * @param algo Algorithm to test
     */
    private void algorithmTest(Algorithm algo) {
        System.out.println("----\t " + algo.getClass().getName() + "\t----");
        
        System.out.print("Rounding " + ROUNDING_COUNT + " times with default precision costs: ");
        long start = System.currentTimeMillis();
        for(int i = 0; i < ROUNDING_COUNT; i++) {
            algo.round(number);
        }
        System.out.println((System.currentTimeMillis() - start) + " ms.");
        
        System.out.print("Rounding " + ROUNDING_COUNT + " times negative number with " + (DECIMAL_COUNT / 10) +
                " precision costs: ");
        start = System.currentTimeMillis();
        for(int i = 0; i < ROUNDING_COUNT; i++) {
            algo.round(negativeNumber, (DECIMAL_COUNT / 10), 5);
        }
        System.out.println((System.currentTimeMillis() - start) + " ms.");
    }

}
