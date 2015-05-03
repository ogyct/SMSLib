package com.easycoremedia.sms.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import com.easycoremedia.sms.connector.Connector;
import com.easycoremedia.sms.request.RequestBuilder;
import com.easycoremedia.sms.response.ResponseParser;

/**
 * This class contains complete integration tests, which should test the whole procedure at once.
 * NOTE!! Before using this, set up credintials accordingly
 * @author Dmitry
 *
 */
public class IntegrationTests {


//    @Test
//    public void testBalance() throws XMLStreamException, ClientProtocolException, IOException {
//        Connector c = new Connector();
//        RequestBuilder rb = new RequestBuilder();
//        String balanceMessage = rb.balanceRequest("", "");
//        
//        c.sendRequest(balanceMessage);
//    }
//    
//    @Test
//    public void testSendMessage() throws XMLStreamException, ClientProtocolException, IOException {
//        Connector c = new Connector();
//        RequestBuilder rb = new RequestBuilder();
//        ResponseParser rp = new ResponseParser();
//        
//        Map<String, String> phones = new HashMap<String, String>();
//        //Here is the problem, even though one number is wrong, request still says 2 messages are sent.
//        //However the price is getting calculated right, so price should be used to define if messages are sent.
//        phones.put("russianNumber", "+79193386820");
//        String sendMessage = rb.sendMessage(Credentials.USERNAME, Credentials.PASSWORD, "Dima", "Message itself", phones);
//        
//        String response = c.sendRequest(sendMessage);
//        
//        
//    }
    
//    @Test
//    public void testRequestStatus() throws XMLStreamException, ClientProtocolException, IOException {
//        Connector c = new Connector();
//        RequestBuilder rb = new RequestBuilder();
//        c.sendRequest(rb.statusRequest(Credentials.USERNAME, Credentials.PASSWORD, "russianNumber"));
//    }

    @Test
    public void testGetPrice()throws XMLStreamException, ClientProtocolException, IOException, JAXBException {
        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        ResponseParser rp = new ResponseParser();
        
        Map<String, String> phones = new HashMap<String, String>();
        
        phones.put("russianNumber", "+79193386820");
        
        String sendMessage = rb.priceRequest(Credentials.USERNAME, Credentials.PASSWORD, "Dima", "Message itself", phones);
        
        String response = c.sendRequest(sendMessage);
        
        rp.parseGetPriceResponse(response);
        
    }
}
