package com.easycoremedia.sms.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import com.easycoremedia.sms.connector.Connector;
import com.easycoremedia.sms.request.RequestBuilder;

/**
 * This class contains complete integration tests, which should test the whole procedure at once.
 * @author Dmitry
 *
 */
public class IntegrationTests {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testBalance() throws XMLStreamException, ClientProtocolException, IOException {
        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        String balanceMessage = rb.balanceRequest("", "");
        
        c.sendRequest(balanceMessage);
    }
    
    @Test
    public void testSendMessage() throws XMLStreamException, ClientProtocolException, IOException {
        Connector c = new Connector();
        RequestBuilder rb = new RequestBuilder();
        
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("id1", "+420731634696");
        //Here is the problem, even though one number is wrong, request still says 2 messages are sent.
        //However the price is getting calculated right, so price should be used to define if messages are sent.
        phones.put("russianNumber", "+79193386820");
        String sendMessage = rb.sendMessage("", "", "Dima", "Message itself", phones);
        
        c.sendRequest(sendMessage);
    }

}
