/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.datavalidator.failure;

import com.topcoder.util.datavalidator.IntegerValidator;


/**
 * <p>
 * Test the functionality of class <code>IntegerValidator</code>.
 * </p>
 * 
 * <p>
 * This test suite contains multiple failure test cases that addressed different aspects for each public methods and constructors.<br>
 * Various real data is used to ensure that the invalid inputs are handled properly as defined in the
 * documentation.<br>
 * </p>
 *
 * @author lyt
 * @version 1.0
 */
public class IntegerValidatorFailureTests extends AbstractObjectValidatorFailureTests {
    /**
     * <p>
     * Sets up the test environment.
     * </p>
     * 
     * <p>
     * The test instance is initialized and all the need configuration are loaded.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        validator = IntegerValidator.isEven();
    }

    /**
     * <p>
     * Tear down the test environment.
     * </p>
     * 
     * <p>
     * The test instance is released and the configuration is clear.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * <p>
     * Failure test case for method 'isNegative()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testIsNegative_BundleInfo_Null1() {
        try {
            IntegerValidator.isNegative(null);
            fail("Test failure for isNegative() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'greaterThan()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testGreaterThan_intBundleInfo_Null1() {
        try {
            IntegerValidator.greaterThan(10, null);
            fail("Test failure for greaterThan() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'greaterThanOrEqualTo()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testGreaterThanOrEqualTo_intBundleInfo_Null1() {
        try {
            IntegerValidator.greaterThanOrEqualTo(10, null);
            fail("Test failure for greaterThanOrEqualTo() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'equalTo()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testEqualTo_intBundleInfo_Null1() {
        try {
            IntegerValidator.equalTo(10, null);
            fail("Test failure for equalTo() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'lessThan()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testLessThan_intBundleInfo_Null1() {
        try {
            IntegerValidator.lessThan(10, null);
            fail("Test failure for lessThan() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'lessThanOrEqualTo()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testLessThanOrEqualTo_intBundleInfo_Null1() {
        try {
            IntegerValidator.lessThanOrEqualTo(10, null);
            fail("Test failure for lessThanOrEqualTo() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'inRange()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testInRange_intintBundleInfo_Null1() {
        try {
            IntegerValidator.inRange(10, 20, null);
            fail("Test failure for inRange() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'inExclusiveRange()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testInExclusiveRange_intintBundleInfo_Null1() {
        try {
            IntegerValidator.inExclusiveRange(10, 20, null);
            fail("Test failure for inExclusiveRange() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'isPositive()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testIsPositive_BundleInfo_Null1() {
        try {
            IntegerValidator.isPositive(null);
            fail("Test failure for isPositive() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'isOdd()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testIsOdd_BundleInfo_Null1() {
        try {
            IntegerValidator.isOdd(null);
            fail("Test failure for isOdd() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Failure test case for method 'isEven()'.<br>
     * The argument is null, <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testIsEven_BundleInfo_Null1() {
        try {
            IntegerValidator.isEven(null);
            fail("Test failure for isEven() failed, IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }
}
