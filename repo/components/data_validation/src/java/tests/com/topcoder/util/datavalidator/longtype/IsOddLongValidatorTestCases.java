/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.datavalidator.longtype;

import com.topcoder.util.datavalidator.AbstractLongValidatorTestCases;
import com.topcoder.util.datavalidator.AbstractObjectValidator;
import com.topcoder.util.datavalidator.BundleInfo;
import com.topcoder.util.datavalidator.LongValidator;


/**
 * <p>
 * Test the functionality of class <code>LongValidator</code>.
 * </p>
 *
 * @author telly12
 * @version 1.1
 */
public class IsOddLongValidatorTestCases extends AbstractLongValidatorTestCases {
    /**
     * <p>
     * A <code>String</code> represents the message that the validation long is not odd.
     * </p>
     */
    private static String NOT_ODD = "not odd";

    /**
     * <p>
     * Sets up the test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        longValidator = LongValidator.isOdd(bundleInfo);
        longValidator = LongValidator.isOdd();
    }

    /**
     * <p>
     * Tear down the test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * <p>
     * Accuracy test case for method 'getMessage()'.<br>
     * The result should be unsuccessful when validating an even long.
     * </p>
     */
    public void testGetMessage_Object_Accuracy1() {
        String msg = longValidator.getMessage("1026");
        assertEquals("Test accuracy for method getMessage() failed.", NOT_ODD, msg);
    }

    /**
     * <p>
     * Accuracy test case for method 'getMessage()'.<br>The result should be successful when validating an odd long.
     * </p>
     */
    public void testGetMessage_Object_Accuracy2() {
        String msg = longValidator.getMessage("1023");
        assertNull("Test accuracy for method getMessage() failed.", msg);
    }

    /**
     * <p>
     * Accuracy test case for method 'getMessage()'.<br>
     * The result should be unsuccessful when validating an even long.
     * </p>
     */
    public void testGetMessage_int_Accuracy1() {
        String msg = longValidator.getMessage(1026);
        assertEquals("Test accuracy for method getMessage() failed.", NOT_ODD, msg);
    }

    /**
     * <p>
     * Accuracy test case for method 'getMessage()'.<br>The result should be successful when validating an odd long.
     * </p>
     */
    public void testGetMessage_int_Accuracy2() {
        String msg = longValidator.getMessage(1023);
        assertNull("Test accuracy for method getMessage() failed.", msg);
    }

    /**
     * <p>
     * Accuracy test case for method 'valid()'.<br>The result should be unsuccessful when validating an even long.
     * </p>
     */
    public void testValid_Object_Accuracy1() {
        assertFalse("Test accuracy for method valid() failed.", longValidator.valid("1026"));
    }

    /**
     * <p>
     * Accuracy test case for method 'valid()'.<br>The result should be successful when validating an odd long.
     * </p>
     */
    public void testValid_Object_Accuracy2() {
        assertTrue("Test accuracy for method valid() failed.", longValidator.valid("1023"));
    }

    /**
     * <p>
     * Accuracy test case for method 'valid()'.<br>
     * <br>
     * The result should be unsuccessful when validating an even long.
     * </p>
     */
    public void testValid_int_Accuracy1() {
        assertFalse("Test accuracy for method valid() failed.", longValidator.valid(1026));
    }

    /**
     * <p>
     * Accuracy test case for method 'valid()'.<br>The result should be successful when validating an odd long.
     * </p>
     */
    public void testValid_int_Accuracy2() {
        assertTrue("Test accuracy for method valid() failed.", longValidator.valid(1023));
    }

    /**
     * <p>
     * Accuracy test case for method 'getMessages()'.<br>
     * The result should be unsuccessful when validating an even long.
     * </p>
     */
    public void testGetMessages_Object_Accuracy1() {
        String[] msg = longValidator.getMessages("1026");
        assertEquals("Test accuracy for method getMessages() failed.", 1, msg.length);
        assertEquals("Test accuracy for method getMessages() failed.", NOT_ODD, msg[0]);
    }

    /**
     * <p>
     * Accuracy test case for method 'getMessages()'.<br>
     * The result should be successful when validating an odd long.
     * </p>
     */
    public void testGetMessages_Object_Accuracy2() {
        String[] msg = longValidator.getMessages("1023");
        assertNull("Test accuracy for method getMessages() failed.", msg);
    }

    /**
     * <p>
     * Accuracy test case for method 'getAllMessages()'.<br>
     * The result should be unsuccessful when validating an even long.
     * </p>
     */
    public void testGetAllMessages_Object_Accuracy1() {
        String[] msg = longValidator.getAllMessages("1026");
        assertEquals("Test accuracy for method getAllMessages() failed.", 1, msg.length);
        assertEquals("Test accuracy for method getAllMessages() failed.", NOT_ODD, msg[0]);
    }

    /**
     * <p>
     * Accuracy test case for method 'getAllMessages()'.<br>
     * The result should be successful when validating an odd long.
     * </p>
     */
    public void testGetAllMessages_Object_Accuracy2() {
        String[] msg = longValidator.getAllMessages("1023");
        assertNull("Test accuracy for method getAllMessages() failed.", msg);
    }

    /**
     * <p>
     * Accuracy test case for method 'getAllMessages()'.<br>
     * The result should be unsuccessful when validating an even long.
     * </p>
     */
    public void testGetAllMessages_ObjectInt_Accuracy1() {
        String[] msg = longValidator.getAllMessages("1024", 2);
        assertEquals("Test accuracy for method getAllMessages() failed.", 1, msg.length);
        assertEquals("Test accuracy for method getAllMessages() failed.", NOT_ODD, msg[0]);
    }

    /**
     * <p>
     * Accuracy test case for method 'getAllMessages()'.<br>
     * The result should be successful when validating an odd long.
     * </p>
     */
    public void testGetAllMessages_ObjectInt_Accuracy2() {
        String[] msg = longValidator.getAllMessages("1023", 1);
        assertNull("Test accuracy for method getAllMessages() failed.", msg);
    }

    /**
     * <p>
     * Creates an instance of <code>AbstractObjectValidator.</code>
     * </p>
     *
     * @return the <code>AbstractObjectValidator</code> instance.
     */
    public AbstractObjectValidator createObjectValidator() {
        return LongValidator.isOdd();
    }

    /**
     * <p>
     * Create an instance of <code>AbstractObjectValidator.</code>
     * </p>
     *
     * @param bundleInfo name of the bundle to use
     *
     * @return the <code>AbstractObjectValidator</code> instance.
     */
    public AbstractObjectValidator createObjectValidator(BundleInfo bundleInfo) {
        return LongValidator.isOdd(bundleInfo);
    }
}
