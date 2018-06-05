/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.file.transfer.persistence;

/**
 * <p>
 * Thrown by the FilePersistence methods if the write operation cannot take place because the file to be modified has
 * not yet had a lock obtained on it. Extends FilePersistenceException.
 * </p>
 *
 * <p>
 * <strong>Thread Safety:</strong> This class is not thread safe, since its parent class is not thread safe.
 * </p>
 *
 * @author argolite, TCSDEVELOPER
 * @version 1.1
 */
public class FileNotYetLockedException extends FilePersistenceException {
    /**
     * <p>
     * Creates a new exception instance with this error message.
     * </p>
     *
     * @param message
     *            error message
     */
    public FileNotYetLockedException(String message) {
        super(message);
    }

    /**
     * <p>
     * Creates a new exception instance with this error message and cause of error.
     * </p>
     *
     * @param message
     *            error message
     * @param cause
     *            cause of error
     */
    public FileNotYetLockedException(String message, Exception cause) {
        super(message, cause);
    }
}
