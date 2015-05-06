package com.easycoremedia.sms.run;

import com.easycoremedia.sms.response.beans.ParentBean;

/**
 * Main response object which is returned when no technical problem occurred
 * @author avgustisd
 *
 */
public class Response {

    private CallStatus status;
    private ParentBean bean;
    private Exception ex;

    public Response(ParentBean pb, String statusNumber) {
        processStatus(statusNumber);
        this.bean = pb;
    }

    public ParentBean getBean() {
        return bean;
    }



    public CallStatus getStatus() {
        return status;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }
    
    /**
     * This method get number from response and sets STATUS accordingly
     * @param statusNumber
     */
    private void processStatus(String statusNumber) {
        int number = Integer.valueOf(statusNumber);
        if (number == -4) {
            this.status = CallStatus.NO_RECIPIENTS;
        } else if (number == -3) {
            this.status = CallStatus.NOT_ENOUGH_CREDITS;
        } else if (number == -2) {
            this.status = CallStatus.XML_ERROR;
        } else if (number == -1) {
            this.status = CallStatus.AUTH_FAILED;
        } else if (number >= 0) {
            this.status = CallStatus.OK;
        }
    }

}
