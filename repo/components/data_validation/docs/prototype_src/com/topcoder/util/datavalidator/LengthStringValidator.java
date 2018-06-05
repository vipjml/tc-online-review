package com.topcoder.util.datavalidator;

    /**
     * This is an extention of the StringValidator which specifically deals with
     * validating strings based on their length. note that the actual validation
     * is performed based on an IntegerValidator which means that we could have
     * this validator do all the integer validations including range validation
     * of the length.
     * As an example, if we create an instance of this validator set
     * with an IntegerValidator which checks that a number is in range of
     * 2..10 inclusive then any user input that would have its length in that
     * range would be considered valid.
     * This is an inner class to StringValidator.
     * This class is thread-safe as it is immutable.
     * @version 1.1
     */
    class LengthStringValidator extends StringValidator {

       /**
        * The underlying <code>IntegerValidator</code> to use. This is the
        * validator initilization value which is set in the constructor and once
        * set is immutable. This cannot be null and represents the validator
        * doing the actual validation of the length.
        */
        private final IntegerValidator validator;

        /**
         * Creates a new <code>LengthStringValidator</code> that uses the given
         * <code>IntegerValidator</code> to check whether the length of inputs
         * are valid.
         *
         * @param   validator   the underlying <code>IntegerValidator</code> to
         * use.
         * @throws  IllegalArgumentException    if <code>validator</code> is
         * <code>null</code>.
         */
        public LengthStringValidator(IntegerValidator validator)
                throws IllegalArgumentException {
            if (validator == null) {
                throw new IllegalArgumentException("validator cannot be null");
            }

            this.validator = validator;
        }

        /**
         * Creates a new <code>LengthStringValidator</code> that uses the given
         * <code>IntegerValidator</code> to check whether the length of inputs
         * are valid and initializes the validator with a specific resource
         * bundle information.
         * @param bundleInfo BundleInfo  resource bundle information
         * @param   validator   the underlying <code>IntegerValidator</code> to
         * use.
         * @throws  IllegalArgumentException    if <code>validator</code> is
         * <code>null</code>.
         */
        public LengthStringValidator(IntegerValidator validator, BundleInfo bundleInfo)
                throws IllegalArgumentException {
              super(bundleInfo);
              if (validator == null) {
                throw new IllegalArgumentException("validator cannot be null");
              }

              this.validator = validator;
       }

        /**
         * Validates the given <code>String</code>.
         *
         * @param  str <code>String</code> to be validated.
         * @return <code>true</code> if <code>str</code> is valid;
         *      <code>false</code> otherwise.
         */
        public boolean valid(String str) {
            return validator.valid(str.length());
        }

        /**
         * If the given <code>String</code> is valid, this returns
         * <code>null</code>. Otherwise, it returns an error message.
         *
         * @param   str <code>String</code> value to be validated.
         * @return  <code>null</code> if <code>str</code> is valid. Otherwise an
         *      error message is returned.
         */
        public String getMessage(String str) {
            String message = null;
            String msg = validator.getMessage(str.length());

            if (msg == null) {
                return null;
            } else {
                return "string length " + msg;
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
