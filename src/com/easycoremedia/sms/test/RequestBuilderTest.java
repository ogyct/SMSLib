package com.easycoremedia.sms.test;

import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

import com.easycoremedia.sms.request.RequestBuilder;

/**
 * Test class for creating XML messages
 * @author Dmitry
 *
 */
public class RequestBuilderTest {

    @Test
    public void testRequestBalance() throws XMLStreamException {
        RequestBuilder rb = new RequestBuilder();
        //escaping symbols seems to be working as intended
        System.out.println(rb.balanceRequest("?test", "<test1>"));

    }

    @Test
    public void testRequestStatus() throws XMLStreamException {
        RequestBuilder rb = new RequestBuilder();
        System.out.println(rb.statusRequest("", "pass", "12"));
    }

    @Test
    public void testRequestSendMessage() throws XMLStreamException {
        RequestBuilder rb = new RequestBuilder();
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("id1", "+420731634696");
        phones.put("id2", "+38093101****");

        System.out.println(rb.sendMessage("TEST", "TEST1", "DIMA", "HI dima, nice to see you", phones));
    }
    
    @Test
    public void testRequestGetPrice() throws XMLStreamException {
        RequestBuilder rb = new RequestBuilder();
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("id1", "+420731634696");
        phones.put("id2", "+38093101****");

        System.out.println(rb.priceRequest("TEST", "TEST1", "DIMA", "HI dima, nice to see you", phones));
    }

}
