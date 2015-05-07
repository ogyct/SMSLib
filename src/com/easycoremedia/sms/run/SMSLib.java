package com.easycoremedia.sms.run;

import java.util.Map;

import com.easycoremedia.sms.connector.Connector;
import com.easycoremedia.sms.request.RequestBuilder;
import com.easycoremedia.sms.response.ResponseParser;
import com.easycoremedia.sms.response.beans.ParentBean;
import com.easycoremedia.sms.response.beans.StatusBean;

/**
 * Initial class that allows user to use the library
 * Class IntegrationTests.java contains examples of using this lib.
 * @author Dmitry
 *
 */
public class SMSLib {

    private final String userName;
    private final String password;

    /**
     * Set up credentials here
     * @param userName
     * @param password
     */
    public SMSLib(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    /**
     * This method sends request to get balance
     * @return 
     */
    public Result getBalance() {
        Result res;
        try {
            RequestBuilder rb = new RequestBuilder();
            String balanceMessage = rb.balanceRequest(userName, password);
            Connector c = new Connector();
            String response = c.sendRequest(balanceMessage);
            ResponseParser rp = new ResponseParser();
            ParentBean pb = rp.parseBalace(response);
            res = new Result(pb, c.getHttpPost(), c.getHttpResponse());
        } catch (Exception e) {
            res = new Result(e);
        }
        return res;
    }

    /**
     * Method sends request to get how much SMS delivery will cost
     * @param sender
     * @param message
     * @param phones Map which contains ID key and Phone Number value
     * @return 
     */
    public Result getPrice(String sender, String message, Map<String, String> phones) {
        Result res;
        try {
            Connector c = new Connector();
            RequestBuilder rb = new RequestBuilder();
            ResponseParser rp = new ResponseParser();

            String sendMessage = rb.priceRequest(userName, password, sender, message, phones);

            String response = c.sendRequest(sendMessage);

            ParentBean pb = rp.parseBalace(response);
            res = new Result(pb, c.getHttpPost(), c.getHttpResponse());
        } catch (Exception e) {
            res = new Result(e);
        }
        return res;
    }

    /**
     * This method works differently from the others.
     * It return delivery report for each message with a certain ID. If id is wrong, then delivery report will be empty
     * @param id which you assigned to a message
     * @return
     * @throws Exception
     */
    public StatusBean getStatus(String id) throws Exception {
        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        ResponseParser rp = new ResponseParser();
        String response = c.sendRequest(rb.statusRequest(userName, password, id));
        StatusBean sb = rp.StatusBean(response);

        if (sb.getMessages().isEmpty()) {
            //throw new SMSLibException("Delivery report is empty");
        }

        return sb;

    }

    /**
     * Method requests server to send as many messages as phone numbers will be in PHONES map
     * @param sender
     * @param message
     * @param phones Map which contains ID key and Phone Number value
     * @return
     */
    public Result sendSMS(String sender, String message, Map<String, String> phones) {
        Result res;
        try {
        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        ResponseParser rp = new ResponseParser();

        String sendMessage = rb.sendMessage(userName, password, sender, message, phones);

        String response = c.sendRequest(sendMessage);

        ParentBean pb = rp.parseBalace(response);
        res = new Result(pb, c.getHttpPost(), c.getHttpResponse());
        } catch (Exception e) {
            res = new Result(e);
        }
        return res; 
    }

}
