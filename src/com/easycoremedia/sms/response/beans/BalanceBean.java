package com.easycoremedia.sms.response.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class represents balance response data model
 * @author Dmitry
 *
 */
@XmlRootElement(name="RESPONSE")
public class BalanceBean {

    private String status;
    private String credits;
    private String amount;
    private String currency;

    @XmlElement(name="status")
    public String getStatus() {
        return status;
    }

    
    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name="credits")
    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    @XmlElement(name="amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @XmlElement(name="currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
