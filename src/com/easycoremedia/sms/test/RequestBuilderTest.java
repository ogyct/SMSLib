package com.easycoremedia.sms.test;

import static org.junit.Assert.*;

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
    
    String balance = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SMS><operations><operation>BALANCE</operation></operations><authentification><username></username><password></password></authentification></SMS>"; 
            

    @Test
    public void testRequestBalance() throws XMLStreamException {
        RequestBuilder rb = new RequestBuilder();
        //escaping symbols seems to be working as intended
        assertEquals(balance, rb.balanceRequest("", ""));

    }

    @Test
    public void testRequestStatus() throws XMLStreamException {
        AtomparkBuilder ab = new AtomparkBuilder();
        RequestBuilder rb = new RequestBuilder();
        rb.statusRequest("", "pass", "id1");
        assertEquals(ab.getStatus(""), rb.statusRequest("", "", ""));
    }

    @Test
    public void testRequestSendMessage() throws XMLStreamException {
        AtomparkBuilder ab = new AtomparkBuilder();
        
        RequestBuilder rb = new RequestBuilder();
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("id1", "+420731634696");
        phones.put("id2", "+38093101****");

        assertEquals(ab.sendSMS("", phones) , rb.sendMessage("", "", "", "", phones));
    }
    
    @Test
    public void testRequestGetPrice() throws XMLStreamException {
        AtomparkBuilder ab = new AtomparkBuilder();
        RequestBuilder rb = new RequestBuilder();
        Map<String, String> phones = new HashMap<String, String>();
        phones.put("id1", "+420731634696");
        phones.put("id2", "+38093101****");


        assertEquals(ab.getPrice("", phones) , rb.priceRequest("", "", "", "", phones));
    }

}
