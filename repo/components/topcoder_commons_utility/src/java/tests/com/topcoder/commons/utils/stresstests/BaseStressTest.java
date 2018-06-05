/*
 * Copyright (C) 2011 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.commons.utils.stresstests;

import java.util.Date;

import junit.framework.TestCase;

/**
 * <p>
 * BaseStressTest class for the stress tests.
 * </p>
 * <p>
 * Thread safe: This class has no state, and thus it is thread safe.
 * </p>
 * 
 * @author mumujava
 * @version 1.0
 */
public class BaseStressTest extends TestCase {

    /** The test count. */
    protected static final int testCount = 50;

    /** time started to test */
    protected long start = 0;

    /**
     * Initialize variables.
     * 
     * @throws Exception
     *             if anything goes wrong
     */
    public void setUp() throws Exception {
        start = new Date().getTime();
    }
}
