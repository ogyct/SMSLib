package com.easycoremedia.sms.run;

import java.util.Map;

import com.easycoremedia.sms.connector.Connector;
import com.easycoremedia.sms.exception.ExceptionChecker;
import com.easycoremedia.sms.exception.SMSLibException;
import com.easycoremedia.sms.request.RequestBuilder;
import com.easycoremedia.sms.response.ResponseParser;
import com.easycoremedia.sms.response.beans.BalanceBean;
import com.easycoremedia.sms.response.beans.GetPriceBean;
import com.easycoremedia.sms.response.beans.SendResponseBean;
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
     * @return Bean which contains additional info
     * @throws Exception
     */
    public BalanceBean getBalance() throws Exception {
        BalanceBean bb = null;

        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        String balanceMessage = rb.balanceRequest(userName, password);

        String response = c.sendRequest(balanceMessage);
        ResponseParser rp = new ResponseParser();
        bb = rp.parseBalace(response);

        ExceptionChecker.checkIfException(bb.getStatus());

        return bb;
    }

    /**
     * Method sends request to get how much SMS delivery will cost
     * @param sender
     * @param message
     * @param phones Map which contains ID key and Phone Number value
     * @return Bean which contains additional info
     * @throws SMSLibException 
     * @throws Exception
     */
    public GetPriceBean getPrice(String sender, String message, Map<String, String> phones) throws Exception {
        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        ResponseParser rp = new ResponseParser();

        String sendMessage = rb.priceRequest(userName, password, sender, message, phones);

        String response = c.sendRequest(sendMessage);

        GetPriceBean pb = rp.parseGetPriceResponse(response);

        ExceptionChecker.checkIfException(pb.getStatus());

        return pb;
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
            throw new SMSLibException("Delivery report is empty");
        }
        
        return sb;

    }
    
    
    /**
     * Method requests server to send as many messages as phones map will contain
     * @param sender
     * @param message
     * @param phones Map which contains ID key and Phone Number value
     * @return
     * @throws Exception
     */
    public SendResponseBean sendSMS(String sender, String message, Map<String, String> phones) throws Exception {
        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        ResponseParser rp = new ResponseParser();

        String sendMessage = rb.sendMessage(userName, password, sender, message, phones);

        String response = c.sendRequest(sendMessage);

        SendResponseBean sendBean = rp.parseSendResonse(response);

        ExceptionChecker.checkIfException(sendBean.getStatus());

        return sendBean;
    }

}
