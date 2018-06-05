/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.servlet.request;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for <code>ConfigurationException</code>.
 * </p>
 *
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be instantiated with the error message
 * and cause properly propagated, and that it comes with correct inheritance.
 * </p>
 *
 * @author PE
 * @version 2.0
 */
public class ConfigurationExceptionUnitTest extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message is properly propagated.
     * </p>
     */
    public void testConfigurationException1() {
        ConfigurationException ce = new ConfigurationException(ERROR_MESSAGE);

        assertNotNull("Unable to instantiate ConfigurationException.", ce);
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, ce.getMessage());
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message and the cause are properly propagated.
     * </p>
     */
    public void testConfigurationException2() {
        Exception cause = new Exception();
        ConfigurationException ce = new ConfigurationException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate ConfigurationException.", ce);
        assertEquals("Cause is not properly propagated to super class.", cause, ce.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies ConfigurationException subclasses FileUploadException.
     * </p>
     */
    public void testConfigurationExceptionInheritance1() {
        assertTrue("ConfigurationException does not subclass FileUploadException.",
            new ConfigurationException(ERROR_MESSAGE) instanceof FileUploadException);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies ConfigurationException subclasses FileUploadException.
     * </p>
     */
    public void testConfigurationExceptionInheritance2() {
        assertTrue("ConfigurationException does not subclass FileUploadException.",
            new ConfigurationException(ERROR_MESSAGE, new Exception()) instanceof FileUploadException);
    }
}
