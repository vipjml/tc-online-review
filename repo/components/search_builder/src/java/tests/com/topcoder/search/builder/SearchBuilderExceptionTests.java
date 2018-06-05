/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.search.builder;

import com.topcoder.util.errorhandling.BaseException;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for SearchBuilderException.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.3
 */
public class SearchBuilderExceptionTests extends TestCase {
    /** The test message. */
    private static final String ERROR_MESSAGE = "test exception message";
    /**
     * the cause Exception.
     */
    private final Exception cause = new NullPointerException();

    /**
     * test the excption constructor with ERROR_MESSAGE.
     */
    public void testSearchBuilderException1() {
        SearchBuilderException de = new SearchBuilderException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate SearchBuilderException.", de);

        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, de.getMessage());
        assertTrue("The error message should match.", de.getMessage().indexOf(ERROR_MESSAGE) >= 0);
    }

    /**
     * test the excption constructor with ERROR_MESSAGE and throwable.
     */
    public void testSearchBuilderException2() {
        SearchBuilderException de = new SearchBuilderException(ERROR_MESSAGE, cause);

        assertNotNull("Unable to instantiate SearchBuilderException.", de);

        assertEquals("Cause is not properly propagated to super class.", cause, de.getCause());
    }

    /**
     * Inheritance test.
     */
    public void testSearchBuilderException3() {
        assertTrue("SearchBuilderException does not subclass SearchBuilderException.",
            new SearchBuilderException(ERROR_MESSAGE) instanceof BaseException);

        assertTrue("SearchBuilderException does not subclass SearchBuilderException.",
            new SearchBuilderException(ERROR_MESSAGE, cause) instanceof BaseException);
    }

}
