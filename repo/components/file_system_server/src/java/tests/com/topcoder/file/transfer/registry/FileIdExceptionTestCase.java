/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.file.transfer.registry;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Tests functionality of FileIdException. All consturctors and methods are tested.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FileIdExceptionTestCase extends TestCase {
    /**
     * <p>
     * Represents a string with a detail message.
     * </p>
     */
    private static final String DETAIL_MESSAGE = "detail";

    /**
     * <p>
     * Represents the fileId used in tests.
     * </p>
     */
    private static final String FILEID = "fileId";

    /**
     * <p>
     * Tests accuracy of <code>FileIdException(String, String)</code> constructor. The detail error message and the
     * fildId should be correct.
     * </p>
     */
    public void testFileIdExceptionStringStringAccuracy() {
        // Construct FileIdException with a detail message and a cause
        FileIdException exception = new FileIdException(DETAIL_MESSAGE, FILEID);

        // Verify that there is a detail message
        assertNotNull("Should have message", exception.getMessage());
        assertEquals("Detailed error message with cause should be correct", DETAIL_MESSAGE, exception.getMessage());

        // Verify that the fileId is correct
        assertEquals("the fileId returned not correct", FILEID, exception.getFileId());
    }

    /**
     * <p>
     * Tests accuracy of <code>getFileId()</code> method. return the fileId setted in constructor.
     * </p>
     */
    public void testGetFileIdAccuracy() {
        // Construct FileIdException with a detail message and a cause
        FileIdException exception = new FileIdException(DETAIL_MESSAGE, FILEID);

        // Verify that the fileId is correct
        assertEquals("the fileId returned not correct", FILEID, exception.getFileId());
    }

    /**
     * <p>
     * Aggragates all tests in this class.
     * </p>
     * @return test suite aggragating all tests.
     */
    public static Test suite() {
        return new TestSuite(FileIdExceptionTestCase.class);
    }
}
