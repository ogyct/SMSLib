package com.easycoremedia.sms.response.beans;

/**
 * General object for storing information from responses
 * @author avgustisd
 *
 */
public abstract class ParentBean {
    
    public abstract String getStatus();
    public abstract String getCredits();
    public abstract String getAmount();
    public abstract String getCurrency();

}
