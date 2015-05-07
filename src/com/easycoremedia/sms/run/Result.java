package com.easycoremedia.sms.run;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

import com.easycoremedia.sms.response.beans.ParentBean;

/**
 * Main result object which contains all necessary information:
 * Business errors
 * Exceptions
 * Debug Info
 * Bean objects
 * @author avgustisd
 *
 */
public class Result {

    private CallStatus status;
    private ParentBean bean;
    private Exception ex;
    private HttpPost httpPost;
    private HttpResponse httpResponse;

    /**
     * Call this constructor if exception is thrown
     * @param ex
     */
    public Result(Exception ex) {
        this.ex = ex;        
    }
    
    /**
     * Call this constructor in normal case.
     * @param pb
     * @param httpPost
     * @param httpResponse
     */
    public Result(ParentBean pb, HttpPost httpPost, HttpResponse httpResponse) {        
        this.bean = pb;
        this.httpPost = httpPost;
        this.httpResponse = httpResponse;
        processStatus(pb.getStatus());
    }

    /**
     * Bean contains info from xml response
     * @return
     */
    public ParentBean getBean() {
        return bean;
    }

    /**
     * Status field will only contain business statuses
     * In case of any technical error Exception object should be used
     * @return
     */
    public CallStatus getStatus() {
        return status;
    }

    /**
     * Exception will contain info only if some technical error occurs
     * @return
     */
    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }

    /**
     * For debugging needs
     * @return
     */
    public HttpPost getHttpPost() {
        return httpPost;
    }

    /**
     * For debugging needs
     * @return
     */
    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    /**
     * This method gets number from response and sets STATUS accordingly
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
