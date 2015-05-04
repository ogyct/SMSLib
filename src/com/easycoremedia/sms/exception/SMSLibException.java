package com.easycoremedia.sms.exception;

/**
 * Custom exception object for SMSLib library
 * @author avgustisd
 *
 */
@SuppressWarnings("serial")
public class SMSLibException extends Exception {
    
    private static final String TECHNICAL_ERROR = "Technical error apeared";

    private String errorText;

    private boolean businessCategory = false;

    /**
     * Business category means, that exception isn't caused by any technical reason (like connection error, xml parsing error etc etc.)
     * Business category examples are  AUTH_FAILED (-1)  XML_ERROR, (-2) NOT_ENOUGH_CREDITS,(-3) NO_RECIPIENTS,(-4) OK (0+) 
     * @param message
     * @param businessCategory
     */
    public SMSLibException(String message, boolean businessCategory) {
        super(message);
        setBusinessCategory(businessCategory);
        setErrorText(message);
    }

    public SMSLibException(Throwable cause) {
        super(cause);
        setErrorText(cause.toString());
    }


//    public SMSLibException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }

    /**
     * 
     * @return
     */
    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public boolean isBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(boolean businessCategory) {
        this.businessCategory = businessCategory;
    }

}
