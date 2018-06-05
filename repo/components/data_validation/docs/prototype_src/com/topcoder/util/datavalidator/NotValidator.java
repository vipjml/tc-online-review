/*
 * TCS Data Validation
 *
 * NotValidator.java
 *
 * Copyright (c) 2003, TopCoder, Inc. All rights reserved
 */
package com.topcoder.util.datavalidator;

/**
 * This is a specific type of a composite validator which validates based on a
 * boolean NOT outcome of the associated validator. In other words it reverses
 * the validation outcome of the associated validator. Note that the message
 * returned by this validator in case of failure doesn't take into account
 * the assiciated validator since it reverses the successful validation outcome
 * of that validator.
 * This class is thread-safe as it is immutable.
 * @version 1.1
 */
public class NotValidator extends AbstractObjectValidator {

    /** The underlying validator to use. */
    private final ObjectValidator validator;

    /**
     * Creates a new <code>NotValidator</code> that uses
     * <code>validator</code> as the underlying <code>ObjectValidator</code>.
     *
     * @param   validator   the underlying <code>ObjectValidator</code> to use.
     * @throws  IllegalArgumentException    if <code>validator</code> is
     * <code>null</code>.
     */
    public  NotValidator(ObjectValidator validator)
            throws IllegalArgumentException {
        if (validator == null) {
            throw new IllegalArgumentException("validator cannot be null");
        }

        this.validator = validator;
    }

    /**
     * Creates a new <code>NotValidator</code> that uses
     * <code>validator</code> as the underlying <code>ObjectValidator</code> and
     * is initialized with a specified resource bundle information.
     *
     * @param   validator   the underlying <code>ObjectValidator</code> to use.
     * @throws  IllegalArgumentException    if <code>validator</code> is
     * <code>null</code>.
     */
    public  NotValidator(ObjectValidator validator, BundleInfo bundleInfo)
        throws IllegalArgumentException {
      super(bundleInfo);
      if (validator == null) {
        throw new IllegalArgumentException("validator cannot be null");
      }

      this.validator = validator;
    }


    /**
     * Validates the given <code>Object</code>.
     *
     * @param  obj <code>Object</code> to be validated.
     * @return <code>true</code> if <code>obj</code> is valid;
     *      <code>false</code> otherwise.
     */
    public boolean valid(Object obj) {
        return !validator.valid(obj);
    }

    /**
     * If the given <code>Object</code> is valid, this returns
     * <code>null</code>. Otherwise, it returns an error message.
     *
     * @param   obj  <code>Object</code> to be validated.
     * @return  <code>null</code> if <code>obj</code> is valid. Otherwise an
     *      error message is returned.
     */
    public String getMessage(Object obj) {
        String message = null;
        if (valid(obj)) {
            return null;
        } else {
            return "NOT failure";
        }
    }

    /**
 * Gives error information about the given object being validated. This
 * method will return posibly a number of messages produced for this object
 * by a number of validators if the validator is composite. Since this is
 * a primitive validator the result will always be equivalent to getting
 * a simgle message but as an array.
 * @param object Object the object to validate
 * @return String[] a non-empty but possibly null array of failure messages
 */
public String[] getMessages(Object object){
  String[] result = null;
  String message = getMessage(object);
  if(message != null){
    result = new String[1];
    result[0] = message;
  }
  return result;
}

/**
 * This is the same method concept as the getMessage except taht this method
 * will evalulat the whole validator tree and return all the messages from any
 * validators that failed the object. In other words this is a
 * non-short-circuited version of the method. Since this is
 * a primitive validator the result will always be equivalent to getting
 * a single message but as an array.
 * @param object Object the object to validate
 * @return String[] a non-empty but possibly null array of failure messages
 */
public String[] getAllMessages(Object object){
  return getMessages(object);
}


/**
 * This is a helper method to the getAllMessages method with a message limit.
 * User will need to implement this to implement the validator tree traversal.
 * The most important aspect of this method is the fact that the currently
 * accumulated message count has to be ferried as the traversal is happening.
 * To ensure thread-safety this is done on the stack with modification by all
 * the callers in the call chain.
 * @param object Object the object to validate
 * @param messageLimit int int the max number of messages. This must be
 * greater-than-or-equal to 0
 * @param currentCount int the number of messages so far accumulated.
 * @return String[] a non-empty but possibly null array of failure messages with
 * a most messagelimit messages.
 */
protected String[] getAllMessages(Object object, int messageLimit, int currentCount){
  String[] result = getMessages(object);
  if(result == null){
    // no op
  }else{
    currentCount+= result.length;
  }
  return result;
}


}
