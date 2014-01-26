/**
 * Copyright (c) 2005, TopCoder, Inc. All rights reserved.
 *
 * TCS Rounding Factory 1.0
 */
package com.topcoder.math.roundingfactory;

import com.topcoder.math.roundingfactory.algorithms.Algorithm;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.util.Collection;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import java.lang.reflect.Constructor;


/**
 * <p>The manager class provides an API to manage the rounding algorithms.
 * It allows the user to define new algorithms, either in a configuration
 * file or dynamically through code. The manager class is a singleton.</p>
 *
 * <p>This class is thread safe, since the inner map is a Hashtable</p>
 *
 * @author qiucx0161
 * @author TCSDEVELOPER
 *
 * @copyright (c) 2005, Topcoder, Inc. All Rights Reserved.
 *
 * @version 1.0
 */
public class RoundingManager {

    /**
     * <p>The default namespace for configuration.</p>
     */
    public static final String NAMESPACE = "com.topcoder.math.roundingfactory";

    /**
     * <p>Constant for the property specifying the rounding algorithm name list.</p>
     */
    private static final String ROUNDING_ALGORITHMS_PROPERTY = "rounding_algorithms";

    /**
     * <p>Constant for the property suffix for the rounding algorithm classes.</p>
     */
    private static final String ROUNDING_ALGORITHM_CLASS_SUFFIX = "_class";

    /**
     * <p>Constant for the property suffix for the accuracy digit.</p>
     */
    private static final String ROUNDING_ALGORITHM_ACCURACY_SUFFIX = "_accuracy";

    /**
     * <p>Constant for the property suffix for the comparison digit.</p>
     */
    private static final String ROUNDING_ALGORITHM_COMPARISON_SUFFIX = "_comparison";

    /**
     * <p>Constant for the parameter types to retrieve the constructor.</p>
     */
    private static final Class[] PARAMETER_TYPES = new Class[] {int.class, int.class};

    /**
     * <p>The singleton instance of RoundingManager. It will be instantiated in getInstance()
     * only once. This variable will be null until accessed the first time.</p>
     */
    private static RoundingManager instance = null;

    /**
     * <p>Represents a mapping from Strings to instances of Algorithm - that is, from
     * the identifier of an algorithm to the algorithm itself.It is initialized in constructor.</p>
     */
    private final Map algorithms;

    /**
     * <p>Private constructor that prevents outside instantiation(singleton).</p>
     * <p>This constructor will retrieve the algorithms information from ConfigManager,
     * instantiate them through reflection and then register them.
     *
     * @throws ConfigurationException if anything goes wrong with ConfigManager
     */
    private RoundingManager() throws ConfigurationException {

        algorithms = new Hashtable();

        try {

            // get the ConfigManager instance
            ConfigManager configManager = ConfigManager.getInstance();

            if (!configManager.existsNamespace(NAMESPACE)) {
                // if the NAMESPACE does not exist, throw an exception
                throw new ConfigurationException(
                        "the default namespace(" + NAMESPACE + ") does not exist");
            }

            // get the algorithm names from ConfigManager
            String[] algorithmArray = configManager.getStringArray(NAMESPACE, ROUNDING_ALGORITHMS_PROPERTY);

            if (algorithmArray == null) {
                // if ROUNDING_ALGORITHMS_PROPERTY is missing, throw an exception
                throw new ConfigurationException(ROUNDING_ALGORITHMS_PROPERTY + " property does not exist.");
            }

            // load all algorithms
            for (int i = 0; i < algorithmArray.length; ++i) {

                String className = getProperty(algorithmArray[i] + ROUNDING_ALGORITHM_CLASS_SUFFIX);
                Integer accuracyDigit = getIntProperty(algorithmArray[i] + ROUNDING_ALGORITHM_ACCURACY_SUFFIX);
                Integer comparisonDigit = getIntProperty(algorithmArray[i] + ROUNDING_ALGORITHM_COMPARISON_SUFFIX);

                // retrieve the public constructor using the parameter type array
                Constructor algorithmConstructor = Class.forName(className).getConstructor(PARAMETER_TYPES);

                // create the algorithm instacne using reflection
                Algorithm algorithm = (Algorithm) algorithmConstructor.newInstance(
                        new Object[] {accuracyDigit, comparisonDigit});

                // add the algorithm
                addAlgorithm(algorithmArray[i], algorithm);
            }
        } catch (ConfigurationException ce) {
            // do not wrap ConfigurationException
            throw ce;
        } catch (Exception e) {
            // wrap the exception with ConfigurationException
            throw new ConfigurationException("Exception occurs while creating the instance", e);
        }
    }

    /**
     * Gets the specified property from the ConfigManager.
     *
     * @param key the name of the property
     * @return the specified value.
     * @throws ConfigurationException if the property does not exist.
     * @throws UnknownNamespaceException if the namespace does not exist.
     */
    private String getProperty(String key) throws ConfigurationException, UnknownNamespaceException {

        // retrieve the property from ConfigManager
        String value = ConfigManager.getInstance().getString(NAMESPACE, key);

        if (value == null) {
            // if the given property does not exist, throw an exception
            throw new ConfigurationException(key + " property does not exist.");
        }
        return value.trim();
    }

    /**
     * Gets the specified integer property from the ConfigManager.
     *
     * @param key the name of the property
     * @return the specified integer value.
     * @throws ConfigurationException if the property does not exist of the value is invalid.
     * @throws UnknownNamespaceException if the namespace does not exist.
     */
    private Integer getIntProperty(String key) throws ConfigurationException, UnknownNamespaceException {
        try {
            return Integer.valueOf(getProperty(key));
        } catch (NumberFormatException nfe) {
            throw new ConfigurationException(key + " property is invalid integer.", nfe);
        }
    }

    /**
     * <p>Gets the singleton instance of RoundingManager.</p>
     *
     * @return the singleton instance of RoundingManager
     * @throws ConfigurationException if anything goes wrong with ConfigManager
     */
    public static synchronized RoundingManager getInstance() throws ConfigurationException {

        // create the singleton instance if it not be created yet.
        if (instance == null) {
            instance = new RoundingManager();
        }

        return instance;
    }

    /**
     * <p>Adds the given round algorithm. If name already exists as a key,
     * false will be returned, otherwise the algorithm will be registered and true will be returned.</p>
     *
     * @return whether the algorithm was added.
     * @param name the algorithm name
     * @param algorithm the algorithm instance to add
     * @throws NullPointerException if either argument is null
     * @throws IllegalArgumentException if the name is empty string.
     */
    public boolean addAlgorithm(String name, Algorithm algorithm) {

        checkAlgorithmName(name);

        if (algorithm == null) {
            throw new NullPointerException("algorithm should not be null");
        }

        // return false immediately if the algorithm already exists
        if (algorithms.containsKey(name)) {
            return false;
        }

        // register the algorithm and return true
        algorithms.put(name, algorithm);
        return true;
    }

    /**
     * <p>Get the specified rounding algorithm. If the given name does no exist, null will be returned.</p>
     *
     * @return the Algorithm instance with the given name, or null if there is no corresponding name
     * @param name the name of an algorithm
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if the name is empty string.
     */
    public Algorithm getAlgorithm(String name) {
        checkAlgorithmName(name);

        return (Algorithm) algorithms.get(name);
    }

    /**
     * <p>Removes the specified algorithm from manager. If the algorithm does not exist, false will be returned,
     * otherwise, this algorithm will be removed and true will be returned.</p>
     *
     * @return whether the algorithm was removed
     * @param name the algorithm to remove
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if the name is empty string.
     */
    public boolean removeAlgorithm(String name) {
        checkAlgorithmName(name);

        return algorithms.remove(name) != null;
    }

    /**
     * <p>Clears all registered algorithms.</p>
     */
    public void clearAlgorithms() {
        algorithms.clear();
    }

    /**
     * <p>Gets a collection of all registered althorithms.</p>
     * <p>Note: A shallow copy is returned, so changes to the manager are not reflected in the
     * returned collection, and vice-versa.
     *
     * @return a shallow copy of all registered althorithms.
     */
    public Collection getAllAlgorithms() {
        return new ArrayList(algorithms.values());
    }

    /**
     * <p>Checks whether the name is valid.</p>
     * <p>name should not be null or empty.</p>
     *
     * @param name the name to be verified.
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is empty
     */
    private void checkAlgorithmName(String name) {
        if (name == null) {
            throw new NullPointerException("name should not be null");
        }

        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("name should not be empty");
        }
    }

}